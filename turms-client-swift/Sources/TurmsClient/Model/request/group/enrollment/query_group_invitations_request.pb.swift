// DO NOT EDIT.
//
// Generated by the Swift generator plugin for the protocol buffer compiler.
// Source: request/group/enrollment/query_group_invitations_request.proto
//
// For information on using the generated types, please see the documentation:
//   https://github.com/apple/swift-protobuf/

import Foundation
import SwiftProtobuf

// If the compiler emits an error on this type, it is because this file
// was generated by a version of the `protoc` Swift plug-in that is
// incompatible with the version of SwiftProtobuf to which you are linking.
// Please ensure that your are building against the same version of the API
// that was used to generate this file.
fileprivate struct _GeneratedWithProtocGenSwiftVersion: SwiftProtobuf.ProtobufAPIVersionCheck {
  struct _2: SwiftProtobuf.ProtobufAPIVersion_2 {}
  typealias Version = _2
}

public struct QueryGroupInvitationsRequest {
  // SwiftProtobuf.Message conformance is added in an extension below. See the
  // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
  // methods supported on all messages.

  public var groupID: SwiftProtobuf.Google_Protobuf_Int64Value {
    get {return _storage._groupID ?? SwiftProtobuf.Google_Protobuf_Int64Value()}
    set {_uniqueStorage()._groupID = newValue}
  }
  /// Returns true if `groupID` has been explicitly set.
  public var hasGroupID: Bool {return _storage._groupID != nil}
  /// Clears the value of `groupID`. Subsequent reads from it will return its default value.
  public mutating func clearGroupID() {_uniqueStorage()._groupID = nil}

  public var areSentByMe: SwiftProtobuf.Google_Protobuf_BoolValue {
    get {return _storage._areSentByMe ?? SwiftProtobuf.Google_Protobuf_BoolValue()}
    set {_uniqueStorage()._areSentByMe = newValue}
  }
  /// Returns true if `areSentByMe` has been explicitly set.
  public var hasAreSentByMe: Bool {return _storage._areSentByMe != nil}
  /// Clears the value of `areSentByMe`. Subsequent reads from it will return its default value.
  public mutating func clearAreSentByMe() {_uniqueStorage()._areSentByMe = nil}

  public var lastUpdatedDate: SwiftProtobuf.Google_Protobuf_Int64Value {
    get {return _storage._lastUpdatedDate ?? SwiftProtobuf.Google_Protobuf_Int64Value()}
    set {_uniqueStorage()._lastUpdatedDate = newValue}
  }
  /// Returns true if `lastUpdatedDate` has been explicitly set.
  public var hasLastUpdatedDate: Bool {return _storage._lastUpdatedDate != nil}
  /// Clears the value of `lastUpdatedDate`. Subsequent reads from it will return its default value.
  public mutating func clearLastUpdatedDate() {_uniqueStorage()._lastUpdatedDate = nil}

  public var unknownFields = SwiftProtobuf.UnknownStorage()

  public init() {}

  fileprivate var _storage = _StorageClass.defaultInstance
}

// MARK: - Code below here is support for the SwiftProtobuf runtime.

fileprivate let _protobuf_package = "im.turms.proto"

extension QueryGroupInvitationsRequest: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
  public static let protoMessageName: String = _protobuf_package + ".QueryGroupInvitationsRequest"
  public static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
    1: .standard(proto: "group_id"),
    2: .standard(proto: "are_sent_by_me"),
    3: .standard(proto: "last_updated_date"),
  ]

  fileprivate class _StorageClass {
    var _groupID: SwiftProtobuf.Google_Protobuf_Int64Value? = nil
    var _areSentByMe: SwiftProtobuf.Google_Protobuf_BoolValue? = nil
    var _lastUpdatedDate: SwiftProtobuf.Google_Protobuf_Int64Value? = nil

    static let defaultInstance = _StorageClass()

    private init() {}

    init(copying source: _StorageClass) {
      _groupID = source._groupID
      _areSentByMe = source._areSentByMe
      _lastUpdatedDate = source._lastUpdatedDate
    }
  }

  fileprivate mutating func _uniqueStorage() -> _StorageClass {
    if !isKnownUniquelyReferenced(&_storage) {
      _storage = _StorageClass(copying: _storage)
    }
    return _storage
  }

  public mutating func decodeMessage<D: SwiftProtobuf.Decoder>(decoder: inout D) throws {
    _ = _uniqueStorage()
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      while let fieldNumber = try decoder.nextFieldNumber() {
        switch fieldNumber {
        case 1: try decoder.decodeSingularMessageField(value: &_storage._groupID)
        case 2: try decoder.decodeSingularMessageField(value: &_storage._areSentByMe)
        case 3: try decoder.decodeSingularMessageField(value: &_storage._lastUpdatedDate)
        default: break
        }
      }
    }
  }

  public func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      if let v = _storage._groupID {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 1)
      }
      if let v = _storage._areSentByMe {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 2)
      }
      if let v = _storage._lastUpdatedDate {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 3)
      }
    }
    try unknownFields.traverse(visitor: &visitor)
  }

  public static func ==(lhs: QueryGroupInvitationsRequest, rhs: QueryGroupInvitationsRequest) -> Bool {
    if lhs._storage !== rhs._storage {
      let storagesAreEqual: Bool = withExtendedLifetime((lhs._storage, rhs._storage)) { (_args: (_StorageClass, _StorageClass)) in
        let _storage = _args.0
        let rhs_storage = _args.1
        if _storage._groupID != rhs_storage._groupID {return false}
        if _storage._areSentByMe != rhs_storage._areSentByMe {return false}
        if _storage._lastUpdatedDate != rhs_storage._lastUpdatedDate {return false}
        return true
      }
      if !storagesAreEqual {return false}
    }
    if lhs.unknownFields != rhs.unknownFields {return false}
    return true
  }
}
