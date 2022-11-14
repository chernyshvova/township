package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.helpshift.websockets.WebSocketCloseCode;
import com.playrix.gplay.GoogleGameCenter;
import java.util.Locale;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class GamesStatusCodes {
    @RecentlyNonNull
    public static Status zza(int i) {
        return new Status(i, zzb(i));
    }

    @RecentlyNonNull
    public static String zzb(int i) {
        if (i == 0) {
            return "STATUS_OK";
        }
        if (i == 1) {
            return "STATUS_INTERNAL_ERROR";
        }
        if (i == 2) {
            return "STATUS_CLIENT_RECONNECT_REQUIRED";
        }
        if (i == 3) {
            return "STATUS_NETWORK_ERROR_STALE_DATA";
        }
        if (i == 4) {
            return "STATUS_NETWORK_ERROR_NO_DATA";
        }
        if (i == 5) {
            return "STATUS_NETWORK_ERROR_OPERATION_DEFERRED";
        }
        if (i == 6) {
            return "STATUS_NETWORK_ERROR_OPERATION_FAILED";
        }
        if (i == 7) {
            return "STATUS_LICENSE_CHECK_FAILED";
        }
        if (i == 14) {
            return "STATUS_INTERRUPTED";
        }
        if (i == 15) {
            return "STATUS_TIMEOUT";
        }
        if (i == 6500) {
            return "STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE";
        }
        if (i == 6501) {
            return "STATUS_MATCH_ERROR_INACTIVE_MATCH";
        }
        switch (i) {
            case 7:
                return "STATUS_LICENSE_CHECK_FAILED";
            case 8:
                return "STATUS_APP_MISCONFIGURED";
            case 9:
                return "STATUS_GAME_NOT_FOUND";
            case 500:
                return "STATUS_RESOLVE_STALE_OR_NO_DATA";
            case 1500:
                return "STATUS_PLAYER_OOB_REQUIRED";
            case 4006:
                return "STATUS_SNAPSHOT_CONFLICT_MISSING";
            case 8000:
                return "STATUS_MILESTONE_CLAIMED_PREVIOUSLY";
            case 8001:
                return "STATUS_MILESTONE_CLAIM_FAILED";
            case 8002:
                return "STATUS_QUEST_NO_LONGER_AVAILABLE";
            case 8003:
                return "STATUS_QUEST_NOT_STARTED";
            case 9000:
                return "STATUS_VIDEO_NOT_ACTIVE";
            case AdError.AD_PRESENTATION_ERROR_CODE:
                return "STATUS_VIDEO_UNSUPPORTED";
            case GoogleGameCenter.REQUEST_CODE_SHOW_LEADERBOARD /*9002*/:
                return "STATUS_VIDEO_PERMISSION_ERROR";
            case GoogleGameCenter.REQUEST_CODE_SHOW_ACHIEVEMENTS /*9003*/:
                return "STATUS_VIDEO_STORAGE_ERROR";
            case GoogleGameCenter.REQUEST_CODE_SHOW_DIALOG /*9004*/:
                return "STATUS_VIDEO_UNEXPECTED_CAPTURE_ERROR";
            case 9006:
                return "STATUS_VIDEO_ALREADY_CAPTURING";
            case 9009:
                return "STATUS_VIDEO_OUT_OF_DISK_SPACE";
            case 9010:
                return "STATUS_VIDEO_NO_MIC";
            case 9011:
                return "STATUS_VIDEO_NO_CAMERA";
            case 9012:
                return "STATUS_VIDEO_SCREEN_OFF";
            case 9016:
                return "STATUS_VIDEO_RELEASE_TIMEOUT";
            case 9017:
                return "STATUS_VIDEO_CAPTURE_VIDEO_PERMISSION_REQUIRED";
            case 9200:
                return "STATUS_VIDEO_MISSING_OVERLAY_PERMISSION";
            case 10000:
                return "STATUS_CLIENT_LOADING";
            case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED:
                return "STATUS_CLIENT_EMPTY";
            case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED:
                return "STATUS_CLIENT_HIDDEN";
            case GamesActivityResultCodes.RESULT_LICENSE_FAILED:
                return "STATUS_CONSENT_REQUIRED";
            default:
                switch (i) {
                    case 1000:
                        return "STATUS_AUTH_ERROR_HARD";
                    case 1001:
                        return "STATUS_AUTH_ERROR_USER_RECOVERABLE";
                    case 1002:
                        return "STATUS_AUTH_ERROR_UNREGISTERED_CLIENT_ID";
                    case 1003:
                        return "STATUS_AUTH_ERROR_API_ACCESS_DENIED";
                    case PointerIconCompat.TYPE_WAIT:
                        return "STATUS_AUTH_ERROR_ACCOUNT_NOT_USABLE";
                    case WebSocketCloseCode.NONE /*1005*/:
                        return "STATUS_AUTH_ERROR_ACCOUNT_UNICORN";
                    case 1006:
                        return "STATUS_AUTH_ERROR_SERVICE_CACHE_MISTAKE";
                    default:
                        switch (i) {
                            case 2000:
                                return "STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS";
                            case AdError.INTERNAL_ERROR_CODE:
                                return "STATUS_REQUEST_UPDATE_TOTAL_FAILURE";
                            case AdError.CACHE_ERROR_CODE:
                                return "STATUS_REQUEST_TOO_MANY_RECIPIENTS";
                            default:
                                switch (i) {
                                    case 3000:
                                        return "STATUS_ACHIEVEMENT_UNLOCK_FAILURE";
                                    case 3001:
                                        return "STATUS_ACHIEVEMENT_UNKNOWN";
                                    case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR:
                                        return "STATUS_ACHIEVEMENT_NOT_INCREMENTAL";
                                    case AuthApiStatusCodes.AUTH_API_SERVER_ERROR:
                                        return "STATUS_ACHIEVEMENT_UNLOCKED";
                                    default:
                                        switch (i) {
                                            case 4000:
                                                return "STATUS_SNAPSHOT_NOT_FOUND";
                                            case 4001:
                                                return "STATUS_SNAPSHOT_CREATION_FAILED";
                                            case 4002:
                                                return "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
                                            case 4003:
                                                return "STATUS_SNAPSHOT_COMMIT_FAILED";
                                            case 4004:
                                                return "STATUS_SNAPSHOT_CONFLICT";
                                            default:
                                                switch (i) {
                                                    case 6000:
                                                        return "STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED";
                                                    case AdError.MEDIAVIEW_MISSING_ERROR_CODE:
                                                        return "STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
                                                    case AdError.ICONVIEW_MISSING_ERROR_CODE:
                                                        return "STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE";
                                                    case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE:
                                                        return "STATUS_MULTIPLAYER_DISABLED";
                                                    default:
                                                        switch (i) {
                                                            case 6503:
                                                                return "STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION";
                                                            case 6504:
                                                                return "STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS";
                                                            case 6505:
                                                                return "STATUS_MATCH_ERROR_ALREADY_REMATCHED";
                                                            case 6506:
                                                                return "STATUS_MATCH_NOT_FOUND";
                                                            case 6507:
                                                                return "STATUS_MATCH_ERROR_LOCALLY_MODIFIED";
                                                            default:
                                                                switch (i) {
                                                                    case 7000:
                                                                        return "STATUS_REAL_TIME_CONNECTION_FAILED";
                                                                    case AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE:
                                                                        return "STATUS_REAL_TIME_MESSAGE_SEND_FAILED";
                                                                    case AdError.LOAD_CALLED_WHILE_SHOWING_AD:
                                                                        return "STATUS_INVALID_REAL_TIME_ROOM_ID";
                                                                    case AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED:
                                                                        return "STATUS_PARTICIPANT_NOT_CONNECTED";
                                                                    case AdError.INCORRECT_STATE_ERROR:
                                                                        return "STATUS_REAL_TIME_ROOM_NOT_JOINED";
                                                                    case AdError.MISSING_DEPENDENCIES_ERROR:
                                                                        return "STATUS_REAL_TIME_INACTIVE_ROOM";
                                                                    case AdError.API_NOT_SUPPORTED:
                                                                        return "STATUS_REAL_TIME_SERVICE_NOT_CONNECTED";
                                                                    case AdError.NATIVE_AD_IS_NOT_LOADED:
                                                                        return "STATUS_OPERATION_IN_FLIGHT";
                                                                    default:
                                                                        return String.format(Locale.US, "Status code (%d) not found!", new Object[]{Integer.valueOf(i)});
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
