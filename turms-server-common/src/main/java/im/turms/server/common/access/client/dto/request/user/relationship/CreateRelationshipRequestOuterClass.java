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

package im.turms.server.common.access.client.dto.request.user.relationship;

public final class CreateRelationshipRequestOuterClass {
    private CreateRelationshipRequestOuterClass() {
    }

    static {
        com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
                com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
                /* major= */ 4,
                /* minor= */ 26,
                /* patch= */ 1,
                /* suffix= */ "",
                CreateRelationshipRequestOuterClass.class.getName());
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_im_turms_proto_CreateRelationshipRequest_descriptor;
    static final com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_im_turms_proto_CreateRelationshipRequest_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static final com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static {
        java.lang.String[] descriptorData = {"\n;request/user/relationship/create_relat"
                + "ionship_request.proto\022\016im.turms.proto\"\203\001"
                + "\n\031CreateRelationshipRequest\022\017\n\007user_id\030\001"
                + " \001(\003\022\017\n\007blocked\030\002 \001(\010\022\030\n\013group_index\030\003 \001"
                + "(\005H\000\210\001\001\022\021\n\004name\030\004 \001(\tH\001\210\001\001B\016\n\014_group_ind"
                + "exB\007\n\005_nameBI\nBim.turms.server.common.ac"
                + "cess.client.dto.request.user.relationshi"
                + "pP\001\272\002\000b\006proto3"};
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
                descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[]{});
        internal_static_im_turms_proto_CreateRelationshipRequest_descriptor =
                getDescriptor().getMessageTypes()
                        .get(0);
        internal_static_im_turms_proto_CreateRelationshipRequest_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
                        internal_static_im_turms_proto_CreateRelationshipRequest_descriptor,
                        new java.lang.String[]{"UserId", "Blocked", "GroupIndex", "Name",});
        descriptor.resolveAllFeaturesImmutable();
    }

    // @@protoc_insertion_point(outer_class_scope)
}