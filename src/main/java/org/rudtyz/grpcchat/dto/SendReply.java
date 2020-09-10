// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package org.rudtyz.grpcchat.dto;

/**
 * Protobuf type {@code message.SendReply}
 */
public final class SendReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:message.SendReply)
    SendReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SendReply.newBuilder() to construct.
  private SendReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SendReply() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SendReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SendReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            messageId_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.rudtyz.grpcchat.dto.Chat.internal_static_message_SendReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.rudtyz.grpcchat.dto.Chat.internal_static_message_SendReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.rudtyz.grpcchat.dto.SendReply.class, org.rudtyz.grpcchat.dto.SendReply.Builder.class);
  }

  public static final int MESSAGEID_FIELD_NUMBER = 1;
  private int messageId_;
  /**
   * <code>int32 messageId = 1;</code>
   * @return The messageId.
   */
  @java.lang.Override
  public int getMessageId() {
    return messageId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (messageId_ != 0) {
      output.writeInt32(1, messageId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (messageId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, messageId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.rudtyz.grpcchat.dto.SendReply)) {
      return super.equals(obj);
    }
    org.rudtyz.grpcchat.dto.SendReply other = (org.rudtyz.grpcchat.dto.SendReply) obj;

    if (getMessageId()
        != other.getMessageId()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
    hash = (53 * hash) + getMessageId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.rudtyz.grpcchat.dto.SendReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.rudtyz.grpcchat.dto.SendReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code message.SendReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:message.SendReply)
      org.rudtyz.grpcchat.dto.SendReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.rudtyz.grpcchat.dto.Chat.internal_static_message_SendReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.rudtyz.grpcchat.dto.Chat.internal_static_message_SendReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.rudtyz.grpcchat.dto.SendReply.class, org.rudtyz.grpcchat.dto.SendReply.Builder.class);
    }

    // Construct using org.rudtyz.grpcchat.dto.SendReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      messageId_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.rudtyz.grpcchat.dto.Chat.internal_static_message_SendReply_descriptor;
    }

    @java.lang.Override
    public org.rudtyz.grpcchat.dto.SendReply getDefaultInstanceForType() {
      return org.rudtyz.grpcchat.dto.SendReply.getDefaultInstance();
    }

    @java.lang.Override
    public org.rudtyz.grpcchat.dto.SendReply build() {
      org.rudtyz.grpcchat.dto.SendReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.rudtyz.grpcchat.dto.SendReply buildPartial() {
      org.rudtyz.grpcchat.dto.SendReply result = new org.rudtyz.grpcchat.dto.SendReply(this);
      result.messageId_ = messageId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.rudtyz.grpcchat.dto.SendReply) {
        return mergeFrom((org.rudtyz.grpcchat.dto.SendReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.rudtyz.grpcchat.dto.SendReply other) {
      if (other == org.rudtyz.grpcchat.dto.SendReply.getDefaultInstance()) return this;
      if (other.getMessageId() != 0) {
        setMessageId(other.getMessageId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.rudtyz.grpcchat.dto.SendReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.rudtyz.grpcchat.dto.SendReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int messageId_ ;
    /**
     * <code>int32 messageId = 1;</code>
     * @return The messageId.
     */
    @java.lang.Override
    public int getMessageId() {
      return messageId_;
    }
    /**
     * <code>int32 messageId = 1;</code>
     * @param value The messageId to set.
     * @return This builder for chaining.
     */
    public Builder setMessageId(int value) {
      
      messageId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 messageId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessageId() {
      
      messageId_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:message.SendReply)
  }

  // @@protoc_insertion_point(class_scope:message.SendReply)
  private static final org.rudtyz.grpcchat.dto.SendReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.rudtyz.grpcchat.dto.SendReply();
  }

  public static org.rudtyz.grpcchat.dto.SendReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SendReply>
      PARSER = new com.google.protobuf.AbstractParser<SendReply>() {
    @java.lang.Override
    public SendReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SendReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SendReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SendReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.rudtyz.grpcchat.dto.SendReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

