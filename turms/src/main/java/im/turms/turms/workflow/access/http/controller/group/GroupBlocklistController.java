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

package im.turms.turms.workflow.access.http.controller.group;

import im.turms.server.common.bo.common.DateRange;
import im.turms.turms.workflow.access.http.dto.request.group.AddGroupBlockedUserDTO;
import im.turms.turms.workflow.access.http.dto.request.group.UpdateGroupBlockedUserDTO;
import im.turms.turms.workflow.access.http.dto.response.*;
import im.turms.turms.workflow.access.http.permission.RequiredPermission;
import im.turms.turms.workflow.access.http.util.PageUtil;
import im.turms.turms.workflow.dao.domain.group.GroupBlockedUser;
import im.turms.turms.workflow.service.impl.group.GroupBlocklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static im.turms.turms.workflow.access.http.permission.AdminPermission.*;

/**
 * @author James Chen
 */
@RestController
@RequestMapping("/groups/blocked-users")
public class GroupBlocklistController {

    private final GroupBlocklistService groupBlocklistService;
    private final PageUtil pageUtil;

    public GroupBlocklistController(PageUtil pageUtil, GroupBlocklistService groupBlocklistService) {
        this.pageUtil = pageUtil;
        this.groupBlocklistService = groupBlocklistService;
    }

    @PostMapping
    @RequiredPermission(GROUP_BLOCKLIST_CREATE)
    public Mono<ResponseEntity<ResponseDTO<GroupBlockedUser>>> addGroupBlockedUser(@RequestBody AddGroupBlockedUserDTO addGroupBlockedUserDTO) {
        Mono<GroupBlockedUser> createMono = groupBlocklistService.addBlockedUser(
                addGroupBlockedUserDTO.getGroupId(),
                addGroupBlockedUserDTO.getUserId(),
                addGroupBlockedUserDTO.getRequesterId(),
                addGroupBlockedUserDTO.getBlockDate());
        return ResponseFactory.okIfTruthy(createMono);
    }

    @GetMapping
    @RequiredPermission(GROUP_BLOCKLIST_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<GroupBlockedUser>>>> queryGroupBlockedUsers(
            @RequestParam(required = false) Set<Long> groupIds,
            @RequestParam(required = false) Set<Long> userIds,
            @RequestParam(required = false) Date blockDateStart,
            @RequestParam(required = false) Date blockDateEnd,
            @RequestParam(required = false) Set<Long> requesterIds,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Flux<GroupBlockedUser> userFlux = groupBlocklistService.queryBlockedUsers(
                groupIds,
                userIds,
                DateRange.of(blockDateStart, blockDateEnd),
                requesterIds,
                0,
                size);
        return ResponseFactory.okIfTruthy(userFlux);
    }

    @GetMapping("/page")
    @RequiredPermission(GROUP_BLOCKLIST_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<GroupBlockedUser>>>> queryGroupBlockedUsers(
            @RequestParam(required = false) Set<Long> groupIds,
            @RequestParam(required = false) Set<Long> userIds,
            @RequestParam(required = false) Date blockDateStart,
            @RequestParam(required = false) Date blockDateEnd,
            @RequestParam(required = false) Set<Long> requesterIds,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Mono<Long> count = groupBlocklistService.countBlockedUsers(groupIds,
                userIds,
                DateRange.of(blockDateStart, blockDateEnd),
                requesterIds);
        Flux<GroupBlockedUser> userFlux = groupBlocklistService.queryBlockedUsers(
                groupIds,
                userIds,
                DateRange.of(blockDateStart, blockDateEnd),
                requesterIds,
                page,
                size);
        return ResponseFactory.page(count, userFlux);
    }

    @PutMapping
    @RequiredPermission(GROUP_BLOCKLIST_UPDATE)
    public Mono<ResponseEntity<ResponseDTO<UpdateResultDTO>>> updateGroupBlockedUsers(
            GroupBlockedUser.KeyList keys,
            @RequestBody UpdateGroupBlockedUserDTO updateGroupBlockedUserDTO) {
        Mono<UpdateResultDTO> updateMono = groupBlocklistService.updateBlockedUsers(
                new HashSet<>(keys.getKeys()),
                updateGroupBlockedUserDTO.getBlockDate(),
                updateGroupBlockedUserDTO.getRequesterId())
                .map(UpdateResultDTO::get);
        return ResponseFactory.okIfTruthy(updateMono);
    }

    @DeleteMapping
    @RequiredPermission(GROUP_BLOCKLIST_DELETE)
    public Mono<ResponseEntity<ResponseDTO<DeleteResultDTO>>> deleteGroupBlockedUsers(
            GroupBlockedUser.KeyList keys) {
        Mono<DeleteResultDTO> deleteMono = groupBlocklistService
                .deleteBlockedUsers(new HashSet<>(keys.getKeys()))
                .map(DeleteResultDTO::get);
        return ResponseFactory.okIfTruthy(deleteMono);
    }

}
