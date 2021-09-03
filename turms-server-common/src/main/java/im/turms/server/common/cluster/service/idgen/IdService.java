/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.server.common.cluster.service.idgen;

import im.turms.server.common.cluster.service.ClusterService;
import im.turms.server.common.cluster.service.config.domain.discovery.Member;
import im.turms.server.common.cluster.service.discovery.DiscoveryService;
import lombok.extern.log4j.Log4j2;

import java.util.TreeSet;

/**
 * @author James Chen
 */
@Log4j2
public class IdService implements ClusterService {

    private static final int FLAKE_ID_GENERATORS_LENGTH = ServiceType.values().length;

    /**
     * Use an array to mitigate unnecessary thread contention.
     */
    private final SnowflakeIdGenerator[] idGenerators = new SnowflakeIdGenerator[FLAKE_ID_GENERATORS_LENGTH];
    private int previousLocalDataCenterId;
    private int previousLocalMemberId;

    public IdService(DiscoveryService discoveryService) {
        for (int i = 0; i < FLAKE_ID_GENERATORS_LENGTH; i++) {
            idGenerators[i] = new SnowflakeIdGenerator(0, 0);
        }
        // Listen to the member changes to get the local member index
        // as the memberId of the snowflake algorithm
        discoveryService.addListenerOnMembersChange(() -> {
            TreeSet<String> zones = new TreeSet<>();
            for (Member member : discoveryService.getAllKnownMembers().values()) {
                zones.add(member.getZone());
            }
            int dataCenterId = zones
                    .headSet(discoveryService.getLocalMember().getZone())
                    .size();
            if (dataCenterId >= SnowflakeIdGenerator.MAX_DATA_CENTER_ID) {
                int fallbackDataCenterId = dataCenterId % SnowflakeIdGenerator.MAX_DATA_CENTER_ID;
                log.warn("The data center ID {} is larger than {}, so the ID fall back to {}." +
                                " It runs the risk of generating same IDs in the cluster",
                        dataCenterId, SnowflakeIdGenerator.MAX_DATA_CENTER_ID - 1, fallbackDataCenterId);
                dataCenterId = fallbackDataCenterId;
            }
            Integer localMemberId = discoveryService.getLocalServiceMemberIndex();
            boolean isMemberIdChanged = localMemberId != null && localMemberId != previousLocalMemberId;
            if (isMemberIdChanged || previousLocalDataCenterId != dataCenterId) {
                if (localMemberId == null) {
                    localMemberId = previousLocalMemberId;
                }
                for (SnowflakeIdGenerator idGenerator : idGenerators) {
                    idGenerator.updateNodeInfo(dataCenterId, localMemberId);
                }
                previousLocalDataCenterId = dataCenterId;
                previousLocalMemberId = localMemberId;
            }
        });
    }

    /**
     * Note: It's unnecessary to check if the ID is 0L because it should never happen due to its implementation
     */
    public long nextIncreasingId(ServiceType serviceType) {
        return idGenerators[serviceType.ordinal()].nextIncreasingId();
    }

    public long nextRandomId(ServiceType serviceType) {
        return idGenerators[serviceType.ordinal()].nextRandomId();
    }

}