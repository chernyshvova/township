package com.helpshift.common.domain.network;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.vungle.warren.downloader.AssetDownloader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface NetworkErrorCodes {
    public static final Integer AUTH_TOKEN_NOT_PROVIDED = 441;
    public static final Integer CONFLICT = 409;
    public static final Integer CONTENT_NOT_FOUND = 404;
    public static final Integer CONTENT_UNCHANGED = 304;
    public static final Integer ENTITY_TOO_LARGE = 413;
    public static final Integer EXPECTATION_FAILED = 417;
    public static final Integer FAILED_DEPENDENCY = 424;
    public static final Integer FORBIDDEN_ACCESS = 403;
    public static final Integer GENERIC_NETWORK_ERROR = 1;
    public static final Integer GONE_ERROR = 410;
    public static final Integer INVALID_AUTH_TOKEN = 443;
    public static final Integer LOCKED = 423;
    public static final Integer METHOD_NOT_ALLOWED = 405;
    public static final Set<Integer> NOT_RETRIABLE_STATUS_CODES = new HashSet(Arrays.asList(new Integer[]{OBJECT_NOT_FOUND, PAYMENT_REQUIRED, FORBIDDEN_ACCESS, CONTENT_NOT_FOUND, METHOD_NOT_ALLOWED, PARSE_ERROR, CONFLICT, GONE_ERROR, NO_REQUEST_LENGTH, PRE_CONDITION_NOT_MATCHED, ENTITY_TOO_LARGE, URI_TOO_LONG, UNSUPPORTED_MEDIA_TYPE, RANGE_NOT_SATISFIABLE, EXPECTATION_FAILED, LOCKED, FAILED_DEPENDENCY, UPGRADE_REQUIRED, PRECONDITION_REQUIRED, REQUEST_HEADER_FIELDS_LARGE, UNAVAILABLE_LEGAL_REASONS}));
    public static final Integer NO_CONNECTION = 0;
    public static final Integer NO_REQUEST_LENGTH = 411;
    public static final Integer OBJECT_NOT_FOUND = 400;

    /* renamed from: OK */
    public static final Integer f3330OK = 200;
    public static final Integer PARSE_ERROR = 406;
    public static final Integer PAYMENT_REQUIRED = 402;
    public static final Integer PRECONDITION_REQUIRED = 428;
    public static final Integer PRE_CONDITION_NOT_MATCHED = Integer.valueOf(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED);
    public static final Integer PROCESSING_REQUEST = 102;
    public static final Integer RANGE_NOT_SATISFIABLE = Integer.valueOf(AssetDownloader.RANGE_NOT_SATISFIABLE);
    public static final Integer REQUEST_HEADER_FIELDS_LARGE = 431;
    public static final Integer REQUEST_TIMEOUT = 408;
    public static final Integer SCREENSHOT_UPLOAD_ERROR = 2;
    public static final Integer SERVER_ERROR = 500;
    public static final Integer SSL_HANDSHAKE_ERROR = 5;
    public static final Integer SSL_PEER_UNVERIFIED_ERROR = 4;
    public static final Integer TIMESTAMP_MISMATCH = 422;
    public static final Integer UNAUTHORIZED_ACCESS = 401;
    public static final Integer UNAVAILABLE_LEGAL_REASONS = 451;
    public static final Integer UNKNOWN_HOST_ERROR = 3;
    public static final Integer UNSUPPORTED_MEDIA_TYPE = 415;
    public static final Integer UPGRADE_REQUIRED = 426;
    public static final Integer URI_TOO_LONG = 414;
}
