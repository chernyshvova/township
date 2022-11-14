package com.facebook.internal;

import com.android.billingclient.api.zzam;
import com.facebook.FacebookRequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FacebookRequestErrorClassification.kt */
public final class FacebookRequestErrorClassification {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    public static final String KEY_NAME = "name";
    public static final String KEY_OTHER = "other";
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    public static final String KEY_TRANSIENT = "transient";
    public static FacebookRequestErrorClassification defaultInstance;
    public final Map<Integer, Set<Integer>> loginRecoverableErrors;
    public final String loginRecoverableRecoveryMessage;
    public final Map<Integer, Set<Integer>> otherErrors;
    public final String otherRecoveryMessage;
    public final Map<Integer, Set<Integer>> transientErrors;
    public final String transientRecoveryMessage;

    /* compiled from: FacebookRequestErrorClassification.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefaultErrorClassification$annotations() {
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification((Map<Integer, ? extends Set<Integer>>) null, zzam.hashMapOf(new Pair(2, null), new Pair(4, null), new Pair(9, null), new Pair(17, null), new Pair(Integer.valueOf(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null)), zzam.hashMapOf(new Pair(102, null), new Pair(Integer.valueOf(FacebookRequestErrorClassification.EC_INVALID_TOKEN), null), new Pair(Integer.valueOf(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED), null)), (String) null, (String) null, (String) null);
        }

        private final Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
            int optInt;
            HashSet hashSet;
            JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (optJSONArray.length() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int length = optJSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (!(optJSONObject == null || (optInt = optJSONObject.optInt("code")) == 0)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int length2 = optJSONArray2.length();
                            if (length2 > 0) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3 + 1;
                                    int optInt2 = optJSONArray2.optInt(i3);
                                    if (optInt2 != 0) {
                                        hashSet.add(Integer.valueOf(optInt2));
                                    }
                                    if (i4 >= length2) {
                                        break;
                                    }
                                    i3 = i4;
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(optInt), hashSet);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return hashMap;
        }

        public final FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
            String str;
            String str2;
            String str3;
            Map<Integer, Set<Integer>> map;
            Map<Integer, Set<Integer>> map2;
            Map<Integer, Set<Integer>> map3;
            String optString;
            JSONArray jSONArray2 = jSONArray;
            if (jSONArray2 == null) {
                return null;
            }
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                Map<Integer, Set<Integer>> map4 = null;
                Map<Integer, Set<Integer>> map5 = null;
                Map<Integer, Set<Integer>> map6 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                    if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                        if (CharsKt__CharKt.equals(optString, "other", true)) {
                            str4 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map4 = parseJSONDefinition(optJSONObject);
                        } else if (CharsKt__CharKt.equals(optString, FacebookRequestErrorClassification.KEY_TRANSIENT, true)) {
                            str5 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map5 = parseJSONDefinition(optJSONObject);
                        } else if (CharsKt__CharKt.equals(optString, FacebookRequestErrorClassification.KEY_LOGIN_RECOVERABLE, true)) {
                            str6 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map6 = parseJSONDefinition(optJSONObject);
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
                map3 = map4;
                map2 = map5;
                map = map6;
                str3 = str4;
                str2 = str5;
                str = str6;
            } else {
                map3 = null;
                map2 = null;
                map = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            return new FacebookRequestErrorClassification(map3, map2, map, str3, str2, str);
        }

        public final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification access$getDefaultInstance$cp;
            if (FacebookRequestErrorClassification.defaultInstance == null) {
                FacebookRequestErrorClassification.defaultInstance = getDefaultErrorClassificationImpl();
            }
            access$getDefaultInstance$cp = FacebookRequestErrorClassification.defaultInstance;
            if (access$getDefaultInstance$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            }
            return access$getDefaultInstance$cp;
        }
    }

    /* compiled from: FacebookRequestErrorClassification.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FacebookRequestError.Category.values().length];
            FacebookRequestError.Category category = FacebookRequestError.Category.OTHER;
            iArr[1] = 1;
            FacebookRequestError.Category category2 = FacebookRequestError.Category.LOGIN_RECOVERABLE;
            iArr[0] = 2;
            FacebookRequestError.Category category3 = FacebookRequestError.Category.TRANSIENT;
            iArr[2] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FacebookRequestErrorClassification(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public static final FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
        return Companion.createFromJSON(jSONArray);
    }

    public static final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification defaultErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            defaultErrorClassification = Companion.getDefaultErrorClassification();
        }
        return defaultErrorClassification;
    }

    public final FacebookRequestError.Category classify(int i, int i2, boolean z) {
        Set set;
        Set set2;
        Set set3;
        if (z) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(i)) && ((set3 = this.otherErrors.get(Integer.valueOf(i))) == null || set3.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(i)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i))) == null || set2.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        if (map3 == null || !map3.containsKey(Integer.valueOf(i)) || ((set = this.transientErrors.get(Integer.valueOf(i))) != null && !set.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.OTHER;
        }
        return FacebookRequestError.Category.TRANSIENT;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        int i = category == null ? -1 : WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i == 1) {
            return this.otherRecoveryMessage;
        }
        if (i == 2) {
            return this.loginRecoverableRecoveryMessage;
        }
        if (i != 3) {
            return null;
        }
        return this.transientRecoveryMessage;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }
}
