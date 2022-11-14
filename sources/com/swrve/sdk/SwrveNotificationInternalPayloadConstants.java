package com.swrve.sdk;

import java.util.Arrays;
import java.util.List;

public class SwrveNotificationInternalPayloadConstants {
    public static final String DEEPLINK_KEY = "_sd";
    public static final String PUSH_ID_CACHE_SIZE_KEY = "_s.c";
    public static final List<String> PUSH_INTERNAL_KEYS = Arrays.asList(new String[]{SWRVE_TRACKING_KEY, SWRVE_INFLUENCED_WINDOW_MINS_KEY, SWRVE_AUTH_USER_KEY, "text", DEEPLINK_KEY, SWRVE_NESTED_JSON_PAYLOAD_KEY, TIMESTAMP_KEY, PUSH_ID_CACHE_SIZE_KEY, SWRVE_PAYLOAD_KEY, "sound"});
    public static final String SOUND_KEY = "sound";
    public static final String SWRVE_AUTH_USER_KEY = "_aui";
    public static final String SWRVE_INFLUENCED_WINDOW_MINS_KEY = "_siw";
    public static final String SWRVE_NESTED_JSON_PAYLOAD_KEY = "_s.JsonPayload";
    public static final String SWRVE_PAYLOAD_KEY = "_sw";
    public static final String SWRVE_TRACKING_KEY = "_p";
    public static final String TEXT_KEY = "text";
    public static final String TIMESTAMP_KEY = "_s.t";
}
