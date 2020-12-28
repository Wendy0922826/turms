enum Code {

    //**********************************************************
    //* Defined on the client side
    //**********************************************************

    //**********************************************************
    //* For application error
    //**********************************************************

    // Client - Request
    INVALID_REQUEST = 100,
    CLIENT_REQUESTS_TOO_FREQUENT,
    REQUEST_TIMEOUT,
    ILLEGAL_ARGUMENT,

    // Server - Notification
    INVALID_NOTIFICATION = 200,
    INVALID_RESPONSE,

    //**********************************************************
    //* For business error
    //**********************************************************

    // User
    CLIENT_SESSION_ALREADY_ESTABLISHED = 300,
    CLIENT_SESSION_HAS_BEEN_CLOSED,
    RELOGIN_SHOULD_BE_CALLED_AFTER_LOGIN,

    // Message
    MESSAGE_IS_REJECTED = 400,

    // Storage
    QUERY_PROFILE_URL_TO_UPDATE_BEFORE_LOGIN = 500,

    //**********************************************************
    //* Defined on the server side
    //**********************************************************

    // Successful responses
    OK = 1000,
    NO_CONTENT,
    ALREADY_UP_TO_DATE,

    //**********************************************************
    //* For application error
    //**********************************************************

    // Client
    INVALID_REQUEST_FROM_SERVER = 1100,
    CLIENT_REQUESTS_TOO_FREQUENT_FROM_SERVER,
    ILLEGAL_ARGUMENT_FROM_SERVER,
    RECORD_CONTAINS_DUPLICATE_KEY,
    REQUESTED_RECORDS_TOO_MANY,
    SEND_REQUEST_FROM_NON_EXISTING_SESSION,

    // Server
    SERVER_INTERNAL_ERROR = 1200,
    SERVER_UNAVAILABLE,
    DISABLED_FUNCTION,

    //**********************************************************
    //* For business error
    //**********************************************************

    // User

    // User - Login
    LOGIN_USER_ID_NOT_NUMBER = 2000,
    LOGIN_AUTHENTICATION_FAILED,
    LOGGING_IN_USER_NOT_ACTIVE,
    LOGIN_FROM_FORBIDDEN_DEVICE_TYPE,
    FORBIDDEN_DEVICE_TYPE_FOR_LOGIN_FAILURE_REASON,
    LOGIN_FAILURE_REASON_CACHE_IS_DISABLED,

    // User - Session
    SESSION_SIMULTANEOUS_CONFLICTS_DECLINE = 2100,
    SESSION_SIMULTANEOUS_CONFLICTS_NOTIFY,
    SESSION_SIMULTANEOUS_CONFLICTS_OFFLINE,
    CREATE_EXISTING_SESSION,
    FORBIDDEN_DEVICE_TYPE_FOR_SESSION_DISCONNECTION_REASON,
    SESSION_DISCONNECTION_REASON_CACHE_IS_DISABLED,

    // User - Location
    USER_LOCATION_RELATED_FEATURES_ARE_DISABLED = 2200,
    QUERYING_NEAREST_USERS_BY_SESSION_ID_IS_DISABLED,

    // User - Info
    UPDATE_INFO_OF_NON_EXISTING_USER = 2300,
    USER_PROFILE_NOT_FOUND,
    PROFILE_REQUESTER_NOT_IN_CONTACTS_OR_BLOCKED,
    PROFILE_REQUESTER_HAS_BEEN_BLOCKED,

    // User - Permission
    QUERY_PERMISSION_OF_NON_EXISTING_USER = 2400,

    // User - Relationship
    ADD_NOT_RELATED_USER_TO_GROUP = 2500,
    CREATE_EXISTING_RELATIONSHIP,

    // User - Friend Request
    REQUESTER_NOT_FRIEND_REQUEST_RECIPIENT = 2600,
    CREATE_EXISTING_FRIEND_REQUEST,
    FRIEND_REQUEST_SENDER_HAS_BEEN_BLOCKED,

    // Group

    // Group - Info
    UPDATE_INFO_OF_NON_EXISTING_GROUP = 3000,
    NOT_OWNER_TO_UPDATE_GROUP_INFO,
    NOT_OWNER_OR_MANAGER_TO_UPDATE_GROUP_INFO,
    NOT_MEMBER_TO_UPDATE_GROUP_INFO,

    // Group - Type
    NO_PERMISSION_TO_CREATE_GROUP_WITH_GROUP_TYPE = 3100,
    CREATE_GROUP_WITH_NON_EXISTING_GROUP_TYPE,

    // Group - Ownership
    NOT_ACTIVE_USER_TO_CREATE_GROUP = 3200,
    NOT_OWNER_TO_TRANSFER_GROUP,
    NOT_OWNER_TO_DELETE_GROUP,
    SUCCESSOR_NOT_GROUP_MEMBER,
    OWNER_QUITS_WITHOUT_SPECIFYING_SUCCESSOR,
    MAX_OWNED_GROUPS_REACHED,
    TRANSFER_NON_EXISTING_GROUP,

    // Group - Question
    NOT_OWNER_OR_MANAGER_TO_CREATE_GROUP_QUESTION = 3300,
    NOT_OWNER_OR_MANAGER_TO_DELETE_GROUP_QUESTION,
    NOT_OWNER_OR_MANAGER_TO_UPDATE_GROUP_QUESTION,
    NOT_OWNER_OR_MANAGER_TO_ACCESS_GROUP_QUESTION_ANSWER,
    GROUP_QUESTION_ANSWERER_HAS_BEEN_BLOCKED,
    MEMBER_CANNOT_ANSWER_GROUP_QUESTION,
    ANSWER_QUESTION_OF_INACTIVE_GROUP,

    // Group - Member
    NOT_OWNER_OR_MANAGER_TO_REMOVE_GROUP_MEMBER = 3400,
    NOT_OWNER_TO_UPDATE_GROUP_MEMBER_INFO,
    NOT_OWNER_OR_MANAGER_TO_UPDATE_GROUP_MEMBER_INFO,
    NOT_MEMBER_TO_QUERY_MEMBER_INFO,
    ADD_BLOCKED_USER_TO_GROUP,
    ADD_BLOCKED_USER_TO_INACTIVE_GROUP,
    ADD_USER_TO_INACTIVE_GROUP,
    ADD_NEW_MEMBER_WITH_ROLE_HIGHER_THAN_REQUESTER,

    // Group - Blocklist
    NOT_OWNER_OR_MANAGER_TO_ADD_BLOCKED_USER = 3500,
    NOT_OWNER_OR_MANAGER_TO_REMOVE_BLOCKED_USER,

    // Group - Join Request
    GROUP_JOIN_REQUEST_SENDER_HAS_BEEN_BLOCKED = 3600,
    NOT_JOIN_REQUEST_SENDER_TO_RECALL_REQUEST,
    NOT_OWNER_OR_MANAGER_TO_ACCESS_GROUP_REQUEST,
    RECALL_NOT_PENDING_GROUP_JOIN_REQUEST,
    SEND_JOIN_REQUEST_TO_INACTIVE_GROUP,
    RECALLING_GROUP_JOIN_REQUEST_IS_DISABLED,

    // Group - Invitation
    GROUP_INVITER_NOT_MEMBER = 3700,
    GROUP_INVITEE_ALREADY_GROUP_MEMBER,
    NOT_OWNER_OR_MANAGER_TO_RECALL_INVITATION,
    NOT_OWNER_OR_MANAGER_TO_ACCESS_INVITATION,
    NOT_OWNER_TO_SEND_INVITATION,
    NOT_OWNER_OR_MANAGER_TO_SEND_INVITATION,
    NOT_MEMBER_TO_SEND_INVITATION,
    INVITEE_HAS_BEEN_BLOCKED,
    RECALLING_GROUP_INVITATION_IS_DISABLED,
    REDUNDANT_GROUP_INVITATION,
    RECALL_NOT_PENDING_GROUP_INVITATION,

    // Conversation
    UPDATING_TYPING_STATUS_IS_DISABLED = 4000,
    UPDATING_READ_DATE_IS_DISABLED,

    // Message

    // Message - Send
    MESSAGE_RECIPIENT_NOT_ACTIVE = 5000,
    MESSAGE_SENDER_NOT_IN_CONTACTS_OR_BLOCKED,
    PRIVATE_MESSAGE_SENDER_HAS_BEEN_BLOCKED,
    GROUP_MESSAGE_SENDER_HAS_BEEN_BLOCKED,
    SEND_MESSAGE_TO_INACTIVE_GROUP,
    SEND_MESSAGE_TO_MUTED_GROUP,
    SENDING_MESSAGES_TO_ONESELF_IS_DISABLED,
    MUTED_MEMBER_SEND_MESSAGE,
    GUESTS_HAVE_BEEN_MUTED,

    // Message - Update
    UPDATING_MESSAGE_BY_SENDER_IS_DISABLED = 5100,
    NOT_SENDER_TO_UPDATE_MESSAGE,
    NOT_MESSAGE_RECIPIENT_TO_UPDATE_MESSAGE_READ_DATE,

    // Message - Recall
    RECALL_NON_EXISTING_MESSAGE = 5200,
    RECALLING_MESSAGE_IS_DISABLED,
    MESSAGE_RECALL_TIMEOUT,

    // Storage
    STORAGE_NOT_IMPLEMENTED = 6000,
    FILE_TOO_LARGE,

    // Storage - Extension
    REDUNDANT_REQUEST_FOR_PRESIGNED_PROFILE_URL = 6900

}

class TurmsStatusCode {

    static isSuccessCode(code: number | string | Code): boolean {
        if (typeof code === 'string') {
            code = parseInt(code);
        }
        return 1000 <= code && code < 1100;
    }

    static isErrorCode(code: number | string): boolean {
        return !this.isSuccessCode(code);
    }

}

export default Object.assign(TurmsStatusCode, Code);