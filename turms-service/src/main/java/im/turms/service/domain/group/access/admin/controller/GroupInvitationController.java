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

package im.turms.service.domain.group.access.admin.controller;

import im.turms.server.common.access.admin.permission.RequiredPermission;
import im.turms.server.common.access.client.dto.constant.RequestStatus;
import im.turms.server.common.domain.common.dto.response.DeleteResultDTO;
import im.turms.server.common.domain.common.dto.response.PaginationDTO;
import im.turms.server.common.domain.common.dto.response.ResponseDTO;
import im.turms.server.common.domain.common.dto.response.ResponseFactory;
import im.turms.server.common.domain.common.dto.response.UpdateResultDTO;
import im.turms.server.common.infra.cluster.node.Node;
import im.turms.server.common.infra.time.DateRange;
import im.turms.service.domain.common.access.admin.controller.BaseController;
import im.turms.service.domain.group.access.admin.dto.request.AddGroupInvitationDTO;
import im.turms.service.domain.group.access.admin.dto.request.UpdateGroupInvitationDTO;
import im.turms.service.domain.group.access.admin.dto.response.GroupInvitationDTO;
import im.turms.service.domain.group.service.GroupInvitationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static im.turms.server.common.access.admin.permission.AdminPermission.GROUP_INVITATION_CREATE;
import static im.turms.server.common.access.admin.permission.AdminPermission.GROUP_INVITATION_DELETE;
import static im.turms.server.common.access.admin.permission.AdminPermission.GROUP_INVITATION_QUERY;
import static im.turms.server.common.access.admin.permission.AdminPermission.GROUP_INVITATION_UPDATE;

/**
 * @author James Chen
 */
@RestController
@RequestMapping("/groups/invitations")
public class GroupInvitationController extends BaseController {

    private final GroupInvitationService groupInvitationService;

    public GroupInvitationController(Node node, GroupInvitationService groupInvitationService) {
        super(node);
        this.groupInvitationService = groupInvitationService;
    }

    @PostMapping
    @RequiredPermission(GROUP_INVITATION_CREATE)
    public Mono<ResponseEntity<ResponseDTO<GroupInvitationDTO>>> addGroupInvitation(
            @RequestBody AddGroupInvitationDTO addGroupInvitationDTO) {
        Mono<GroupInvitationDTO> createMono = groupInvitationService.createGroupInvitation(
                        addGroupInvitationDTO.id(),
                        addGroupInvitationDTO.groupId(),
                        addGroupInvitationDTO.inviterId(),
                        addGroupInvitationDTO.inviteeId(),
                        addGroupInvitationDTO.content(),
                        addGroupInvitationDTO.status(),
                        addGroupInvitationDTO.creationDate(),
                        addGroupInvitationDTO.responseDate())
                .map(invitation -> new GroupInvitationDTO(invitation, groupInvitationService.getEntityExpirationDate()));
        return ResponseFactory.okIfTruthy(createMono);
    }

    @GetMapping
    @RequiredPermission(GROUP_INVITATION_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<GroupInvitationDTO>>>> queryGroupInvitations(
            @RequestParam(required = false) Set<Long> ids,
            @RequestParam(required = false) Set<Long> groupIds,
            @RequestParam(required = false) Set<Long> inviterIds,
            @RequestParam(required = false) Set<Long> inviteeIds,
            @RequestParam(required = false) Set<RequestStatus> statuses,
            @RequestParam(required = false) Date creationDateStart,
            @RequestParam(required = false) Date creationDateEnd,
            @RequestParam(required = false) Date responseDateStart,
            @RequestParam(required = false) Date responseDateEnd,
            @RequestParam(required = false) Date expirationDateStart,
            @RequestParam(required = false) Date expirationDateEnd,
            @RequestParam(required = false) Integer size) {
        size = getPageSize(size);
        Flux<GroupInvitationDTO> invitationFlux = groupInvitationService.queryInvitations(
                        ids,
                        groupIds,
                        inviterIds,
                        inviteeIds,
                        statuses,
                        DateRange.of(creationDateStart, creationDateEnd),
                        DateRange.of(responseDateStart, responseDateEnd),
                        DateRange.of(expirationDateStart, expirationDateEnd),
                        0,
                        size)
                .map(invitation -> new GroupInvitationDTO(invitation, groupInvitationService.getEntityExpirationDate()));
        return ResponseFactory.okIfTruthy(invitationFlux);
    }

    @GetMapping("/page")
    @RequiredPermission(GROUP_INVITATION_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<GroupInvitationDTO>>>> queryGroupInvitations(
            @RequestParam(required = false) Set<Long> ids,
            @RequestParam(required = false) Set<Long> groupIds,
            @RequestParam(required = false) Set<Long> inviterIds,
            @RequestParam(required = false) Set<Long> inviteeIds,
            @RequestParam(required = false) Set<RequestStatus> statuses,
            @RequestParam(required = false) Date creationDateStart,
            @RequestParam(required = false) Date creationDateEnd,
            @RequestParam(required = false) Date responseDateStart,
            @RequestParam(required = false) Date responseDateEnd,
            @RequestParam(required = false) Date expirationDateStart,
            @RequestParam(required = false) Date expirationDateEnd,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size) {
        size = getPageSize(size);
        Mono<Long> count = groupInvitationService.countInvitations(
                ids,
                groupIds,
                inviterIds,
                inviteeIds,
                statuses,
                DateRange.of(creationDateStart, creationDateEnd),
                DateRange.of(responseDateStart, responseDateEnd),
                DateRange.of(expirationDateStart, expirationDateEnd));
        Flux<GroupInvitationDTO> invitationFlux = groupInvitationService.queryInvitations(
                        ids,
                        groupIds,
                        inviterIds,
                        inviteeIds,
                        statuses,
                        DateRange.of(creationDateStart, creationDateEnd),
                        DateRange.of(responseDateStart, responseDateEnd),
                        DateRange.of(expirationDateStart, expirationDateEnd),
                        page,
                        size)
                .map(invitation -> new GroupInvitationDTO(invitation, groupInvitationService.getEntityExpirationDate()));
        return ResponseFactory.page(count, invitationFlux);
    }

    @PutMapping
    @RequiredPermission(GROUP_INVITATION_UPDATE)
    public Mono<ResponseEntity<ResponseDTO<UpdateResultDTO>>> updateGroupInvitations(
            @RequestParam Set<Long> ids,
            @RequestBody UpdateGroupInvitationDTO updateGroupInvitationDTO) {
        Mono<UpdateResultDTO> updateMono = groupInvitationService.updateInvitations(
                        ids,
                        updateGroupInvitationDTO.inviterId(),
                        updateGroupInvitationDTO.inviteeId(),
                        updateGroupInvitationDTO.content(),
                        updateGroupInvitationDTO.status(),
                        updateGroupInvitationDTO.creationDate(),
                        updateGroupInvitationDTO.responseDate())
                .map(UpdateResultDTO::get);
        return ResponseFactory.okIfTruthy(updateMono);
    }

    @DeleteMapping
    @RequiredPermission(GROUP_INVITATION_DELETE)
    public Mono<ResponseEntity<ResponseDTO<DeleteResultDTO>>> deleteGroupInvitations(
            @RequestParam(required = false) Set<Long> ids) {
        Mono<DeleteResultDTO> deleteMono = groupInvitationService.deleteInvitations(ids)
                .map(DeleteResultDTO::get);
        return ResponseFactory.okIfTruthy(deleteMono);
    }

}