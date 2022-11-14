package com.helpshift.common.exception;

public enum NetworkException implements ExceptionType {
    GENERIC,
    NO_CONNECTION,
    UNKNOWN_HOST,
    SSL_PEER_UNVERIFIED,
    SSL_HANDSHAKE,
    UNHANDLED_STATUS_CODE,
    TIMESTAMP_CORRECTION_RETRIES_EXHAUSTED,
    ENTITY_TOO_LARGE_RETRIES_EXHAUSTED,
    CONTENT_NOT_FOUND,
    UNSUPPORTED_ENCODING_EXCEPTION,
    UNABLE_TO_GENERATE_SIGNATURE,
    UNSUPPORTED_MIME_TYPE,
    NON_RETRIABLE,
    CONVERSATION_ARCHIVED,
    CONVERSATION_REOPEN_EXPIRED,
    CSAT_EXPIRED,
    SCREENSHOT_UPLOAD_ERROR,
    INVALID_AUTH_TOKEN,
    AUTH_TOKEN_NOT_PROVIDED,
    USER_PRE_CONDITION_FAILED,
    USER_NOT_FOUND,
    CONTENT_UNCHANGED;
    
    public String route;
    public int serverStatusCode;
}
