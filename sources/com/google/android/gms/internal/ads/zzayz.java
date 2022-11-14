package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.helpshift.websockets.WebSocketCloseCode;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzayz implements zzgee {
    UNKNOWN_EVENT_TYPE(0),
    AD_REQUEST(1),
    AD_LOADED(2),
    AD_IMPRESSION(5),
    AD_FIRST_CLICK(6),
    AD_SUBSEQUENT_CLICK(7),
    REQUEST_WILL_START(8),
    REQUEST_DID_END(9),
    REQUEST_WILL_UPDATE_SIGNALS(10),
    REQUEST_DID_UPDATE_SIGNALS(11),
    REQUEST_WILL_BUILD_URL(12),
    REQUEST_DID_BUILD_URL(13),
    REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
    REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
    REQUEST_WILL_PROCESS_RESPONSE(16),
    REQUEST_DID_PROCESS_RESPONSE(17),
    REQUEST_WILL_RENDER(18),
    REQUEST_DID_RENDER(19),
    AD_FAILED_TO_LOAD(3),
    AD_FAILED_TO_LOAD_NO_FILL(4),
    AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
    AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
    AD_FAILED_TO_LOAD_TIMEOUT(102),
    AD_FAILED_TO_LOAD_CANCELLED(103),
    AD_FAILED_TO_LOAD_NO_ERROR(104),
    AD_FAILED_TO_LOAD_NOT_FOUND(105),
    REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
    REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
    REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
    REQUEST_FAILED_TO_BUILD_URL(1003),
    REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(PointerIconCompat.TYPE_WAIT),
    REQUEST_FAILED_TO_PROCESS_RESPONSE(WebSocketCloseCode.NONE),
    REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
    REQUEST_FAILED_TO_RENDER(1007),
    REQUEST_IS_PREFETCH(1100),
    REQUEST_SAVED_TO_CACHE(1101),
    REQUEST_LOADED_FROM_CACHE(1102),
    REQUEST_PREFETCH_INTERCEPTED(1103),
    REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED(1104),
    REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED(1105),
    NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED(1106),
    NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED(1107),
    REQUEST_FAILED_TO_LOAD_FROM_CACHE(1108),
    BANNER_SIZE_INVALID(10000),
    BANNER_SIZE_VALID(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED),
    ANDROID_WEBVIEW_CRASH(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED),
    OFFLINE_UPLOAD(GamesActivityResultCodes.RESULT_LICENSE_FAILED),
    DELAY_PAGE_LOAD_CANCELLED_AD(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED);
    
    public static final zzgef<zzayz> zzW = null;
    public final int zzX;

    /* access modifiers changed from: public */
    static {
        zzW = new zzayy();
    }

    /* access modifiers changed from: public */
    zzayz(int i) {
        this.zzX = i;
    }

    public final String toString() {
        return "<" + zzayz.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzX + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzX;
    }
}
