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

/**
 * Protobuf type {@code im.turms.proto.DeleteFriendRequestRequest}
 */
public final class DeleteFriendRequestRequest extends com.google.protobuf.GeneratedMessage
        implements
        // @@protoc_insertion_point(message_implements:im.turms.proto.DeleteFriendRequestRequest)
        DeleteFriendRequestRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    static {
        com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
                com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
                /* major= */ 4,
                /* minor= */ 26,
                /* patch= */ 1,
                /* suffix= */ "",
                DeleteFriendRequestRequest.class.getName());
    }

    // Use DeleteFriendRequestRequest.newBuilder() to construct.
    private DeleteFriendRequestRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private DeleteFriendRequestRequest() {
    }

    public static com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequestOuterClass.internal_static_im_turms_proto_DeleteFriendRequestRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequestOuterClass.internal_static_im_turms_proto_DeleteFriendRequestRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest.class,
                        im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest.Builder.class);
    }

    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    private long requestId_ = 0L;

    /**
     * <code>int64 request_id = 1;</code>
     *
     * @return The requestId.
     */
    @java.lang.Override
    public long getRequestId() {
        return requestId_;
    }

    private byte memoizedIsInitialized = -1;

    @java.lang.Override
    public boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) {
            return true;
        }
        if (isInitialized == 0) {
            return false;
        }

        memoizedIsInitialized = 1;
        return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        if (requestId_ != 0L) {
            output.writeInt64(1, requestId_);
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) {
            return size;
        }

        size = 0;
        if (requestId_ != 0L) {
            size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, requestId_);
        }
        size += getUnknownFields().getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeleteFriendRequestRequest other)) {
            return super.equals(obj);
        }

        return getRequestId() == other.getRequestId()
                && getUnknownFields().equals(other.getUnknownFields());
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + REQUEST_ID_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getRequestId());
        hash = (29 * hash) + getUnknownFields().hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessage
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(
            im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder()
                .mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder()
                : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        return new Builder(parent);
    }

    /**
     * Protobuf type {@code im.turms.proto.DeleteFriendRequestRequest}
     */
    public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder>
            implements
            // @@protoc_insertion_point(builder_implements:im.turms.proto.DeleteFriendRequestRequest)
            im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequestOrBuilder {
        public static com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequestOuterClass.internal_static_im_turms_proto_DeleteFriendRequestRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequestOuterClass.internal_static_im_turms_proto_DeleteFriendRequestRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest.class,
                            im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest.Builder.class);
        }

        // Construct using
        // im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest.newBuilder()
        private Builder() {

        }

        private Builder(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            super(parent);

        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            bitField0_ = 0;
            requestId_ = 0L;
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequestOuterClass.internal_static_im_turms_proto_DeleteFriendRequestRequest_descriptor;
        }

        @java.lang.Override
        public im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest getDefaultInstanceForType() {
            return im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest
                    .getDefaultInstance();
        }

        @java.lang.Override
        public im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest build() {
            im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest result =
                    buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest buildPartial() {
            im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest result =
                    new im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest(
                            this);
            if (bitField0_ != 0) {
                buildPartial0(result);
            }
            onBuilt();
            return result;
        }

        private void buildPartial0(
                im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest result) {
            int from_bitField0_ = bitField0_;
            if (((from_bitField0_ & 0x00000001) != 0)) {
                result.requestId_ = requestId_;
            }
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest) {
                return mergeFrom(
                        (im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(
                im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest other) {
            if (other == im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest
                    .getDefaultInstance()) {
                return this;
            }
            if (other.getRequestId() != 0L) {
                setRequestId(other.getRequestId());
            }
            this.mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @java.lang.Override
        public boolean isInitialized() {
            return true;
        }

        @java.lang.Override
        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0 -> done = true;
                        case 8 -> {
                            requestId_ = input.readInt64();
                            bitField0_ |= 0x00000001;
                        } // case 8
                        default -> {
                            if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                done = true; // was an endgroup tag
                            }
                        } // default:
                    } // switch (tag)
                } // while (!done)
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.unwrapIOException();
            } finally {
                onChanged();
            } // finally
            return this;
        }

        private int bitField0_;

        private long requestId_;

        /**
         * <code>int64 request_id = 1;</code>
         *
         * @return The requestId.
         */
        @java.lang.Override
        public long getRequestId() {
            return requestId_;
        }

        /**
         * <code>int64 request_id = 1;</code>
         *
         * @param value The requestId to set.
         * @return This builder for chaining.
         */
        public Builder setRequestId(long value) {

            requestId_ = value;
            bitField0_ |= 0x00000001;
            onChanged();
            return this;
        }

        /**
         * <code>int64 request_id = 1;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearRequestId() {
            bitField0_ &= ~0x00000001;
            requestId_ = 0L;
            onChanged();
            return this;
        }

        // @@protoc_insertion_point(builder_scope:im.turms.proto.DeleteFriendRequestRequest)
    }

    // @@protoc_insertion_point(class_scope:im.turms.proto.DeleteFriendRequestRequest)
    private static final im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE =
                new im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest();
    }

    public static im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DeleteFriendRequestRequest> PARSER =
            new com.google.protobuf.AbstractParser<>() {
                @java.lang.Override
                public DeleteFriendRequestRequest parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    Builder builder = newBuilder();
                    try {
                        builder.mergeFrom(input, extensionRegistry);
                    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(builder.buildPartial());
                    } catch (com.google.protobuf.UninitializedMessageException e) {
                        throw e.asInvalidProtocolBufferException()
                                .setUnfinishedMessage(builder.buildPartial());
                    } catch (java.io.IOException e) {
                        throw new com.google.protobuf.InvalidProtocolBufferException(e)
                                .setUnfinishedMessage(builder.buildPartial());
                    }
                    return builder.buildPartial();
                }
            };

    public static com.google.protobuf.Parser<DeleteFriendRequestRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<DeleteFriendRequestRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public im.turms.server.common.access.client.dto.request.user.relationship.DeleteFriendRequestRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}