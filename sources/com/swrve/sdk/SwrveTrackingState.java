package com.swrve.sdk;

import android.content.Context;

public enum SwrveTrackingState {
    UNKNOWN,
    STARTED,
    EVENT_SENDING_PAUSED,
    STOPPED;

    /* renamed from: com.swrve.sdk.SwrveTrackingState$1 */
    public static /* synthetic */ class C16911 {
        public static final /* synthetic */ int[] $SwitchMap$com$swrve$sdk$SwrveTrackingState = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.swrve.sdk.SwrveTrackingState[] r0 = com.swrve.sdk.SwrveTrackingState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$swrve$sdk$SwrveTrackingState = r0
                r1 = 1
                com.swrve.sdk.SwrveTrackingState r2 = com.swrve.sdk.SwrveTrackingState.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$swrve$sdk$SwrveTrackingState     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.SwrveTrackingState r3 = com.swrve.sdk.SwrveTrackingState.STARTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$swrve$sdk$SwrveTrackingState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.SwrveTrackingState r3 = com.swrve.sdk.SwrveTrackingState.EVENT_SENDING_PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$swrve$sdk$SwrveTrackingState     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.SwrveTrackingState r2 = com.swrve.sdk.SwrveTrackingState.STOPPED     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveTrackingState.C16911.<clinit>():void");
        }
    }

    public static SwrveTrackingState getTrackingState(Context context) {
        return parse(context.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).getString(ISwrveCommon.SDK_PREFS_KEY_TRACKING_STATE, (String) null));
    }

    public static SwrveTrackingState parse(String str) {
        SwrveTrackingState swrveTrackingState = UNKNOWN;
        if (SwrveHelper.isNullOrEmpty(str)) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("STARTED")) {
            return STARTED;
        }
        if (str.equalsIgnoreCase("EVENT_SENDING_PAUSED")) {
            return EVENT_SENDING_PAUSED;
        }
        if (str.equalsIgnoreCase("STOPPED")) {
            return STOPPED;
        }
        return str.equalsIgnoreCase("UNKNOWN") ? UNKNOWN : swrveTrackingState;
    }

    public static void saveTrackingState(Context context, SwrveTrackingState swrveTrackingState) {
        if (swrveTrackingState != EVENT_SENDING_PAUSED) {
            context.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).edit().putString(ISwrveCommon.SDK_PREFS_KEY_TRACKING_STATE, swrveTrackingState.toString()).commit();
        }
    }

    public String toString() {
        int ordinal = ordinal();
        if (ordinal == 1) {
            return "STARTED";
        }
        if (ordinal != 2) {
            return ordinal != 3 ? "UNKNOWN" : "STOPPED";
        }
        return "EVENT_SENDING_PAUSED";
    }
}
