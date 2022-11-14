package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class GamesCallbackStatusCodes {
    @Deprecated
    public static final int CLIENT_RECONNECT_REQUIRED = 2;
    public static final int INTERNAL_ERROR = 1;

    /* renamed from: OK */
    public static final int f2773OK = 0;

    @RecentlyNonNull
    public static String getStatusCodeString(int i) {
        if (i == 0) {
            return "OK";
        }
        if (i == 1) {
            return "INTERNAL_ERROR";
        }
        if (i == 2) {
            return "CLIENT_RECONNECT_REQUIRED";
        }
        if (i == 6003) {
            return "MULTIPLAYER_DISABLED";
        }
        if (i == 7004) {
            return "REAL_TIME_ROOM_NOT_JOINED";
        }
        if (i != 7000) {
            return i != 7001 ? GeneratedOutlineSupport.outline9(47, "unknown games callback status code: ", i) : "REAL_TIME_MESSAGE_SEND_FAILED";
        }
        return "REAL_TIME_CONNECTION_FAILED";
    }
}
