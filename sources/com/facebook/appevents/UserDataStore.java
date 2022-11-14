package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: UserDataStore.kt */
public final class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final UserDataStore INSTANCE = new UserDataStore();
    public static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    public static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    public static final String TAG;
    public static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    public static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    public static SharedPreferences sharedPreferences;

    static {
        String simpleName = UserDataStore.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "UserDataStore::class.java.simpleName");
        TAG = simpleName;
    }

    public static final void clear() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute($$Lambda$_lRlHgyCtmqelduvnpVegcpTvw.INSTANCE);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: clear$lambda-2  reason: not valid java name */
    public static final void m3561clear$lambda2() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    Log.w(TAG, "initStore should have been called before calling setUserData");
                    INSTANCE.initAndWait();
                }
                externalHashedUserData.clear();
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(USER_DATA_KEY, (String) null).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final String getAllHashedUserData() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(externalHashedUserData);
            hashMap.putAll(INSTANCE.getEnabledInternalUserData());
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(hashMap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set<String> enabledRuleNames = MetadataRule.Companion.getEnabledRuleNames();
            for (String next : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(next)) {
                    hashMap.put(next, internalHashedUserData.get(next));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final String getHashedUserData$facebook_core_release() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                Log.w(TAG, "initStore should have been called before calling setUserID");
                INSTANCE.initAndWait();
            }
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(externalHashedUserData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final synchronized void initAndWait() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!initialized.get()) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
                    sharedPreferences = defaultSharedPreferences;
                    if (defaultSharedPreferences != null) {
                        String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
                        if (string == null) {
                            string = "";
                        }
                        SharedPreferences sharedPreferences2 = sharedPreferences;
                        if (sharedPreferences2 != null) {
                            String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, "");
                            if (string2 == null) {
                                string2 = "";
                            }
                            ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                            Utility utility = Utility.INSTANCE;
                            concurrentHashMap.putAll(Utility.jsonStrToMap(string));
                            ConcurrentHashMap<String, String> concurrentHashMap2 = internalHashedUserData;
                            Utility utility2 = Utility.INSTANCE;
                            concurrentHashMap2.putAll(Utility.jsonStrToMap(string2));
                            initialized.set(true);
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void initStore() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean maybeSHA256Hashed(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return new Regex("[A-Fa-f0-9]{64}").matches(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final String normalizeData(String str, String str2) {
        String str3;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i > length) {
                    break;
                }
                boolean z2 = Intrinsics.compare(str2.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = str2.subSequence(i, length + 1).toString();
            if (obj != null) {
                String lowerCase = obj.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (Intrinsics.areEqual(EMAIL, str)) {
                    if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                        return lowerCase;
                    }
                    Log.e(TAG, "Setting email failure: this is not a valid email address");
                    return "";
                } else if (Intrinsics.areEqual(PHONE, str)) {
                    return new Regex("[^0-9]").replace(lowerCase, "");
                } else {
                    if (!Intrinsics.areEqual(GENDER, str)) {
                        return lowerCase;
                    }
                    if (lowerCase.length() > 0) {
                        str3 = lowerCase.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        str3 = "";
                    }
                    if (!Intrinsics.areEqual("f", str3)) {
                        if (!Intrinsics.areEqual(PaintCompat.EM_STRING, str3)) {
                            Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                            return "";
                        }
                    }
                    return str3;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final void setInternalUd(Map<String, String> map) {
        String[] strArr;
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(map, "ud");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    String str2 = (String) next.getValue();
                    Utility utility = Utility.INSTANCE;
                    UserDataStore userDataStore = INSTANCE;
                    int i = 1;
                    int length = str2.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 > length) {
                            break;
                        }
                        boolean z2 = Intrinsics.compare(str2.charAt(!z ? i2 : length), 32) <= 0;
                        if (!z) {
                            if (!z2) {
                                z = true;
                            } else {
                                i2++;
                            }
                        } else if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String sha256hash = Utility.sha256hash(userDataStore.normalizeData(str, str2.subSequence(i2, length + 1).toString()));
                    if (internalHashedUserData.containsKey(str)) {
                        String str3 = internalHashedUserData.get(str);
                        if (str3 == null) {
                            strArr = null;
                        } else {
                            Object[] array = new Regex(",").split(str3, 0).toArray(new String[0]);
                            if (array != null) {
                                strArr = (String[]) array;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        if (strArr == null) {
                            strArr = new String[0];
                        }
                        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
                        Intrinsics.checkNotNullParameter(copyOf, "elements");
                        LinkedHashSet linkedHashSet = new LinkedHashSet(zzam.mapCapacity(copyOf.length));
                        zzam.toCollection(copyOf, linkedHashSet);
                        if (!linkedHashSet.contains(sha256hash)) {
                            StringBuilder sb = new StringBuilder();
                            if (strArr.length == 0) {
                                sb.append(sha256hash);
                            } else if (strArr.length < 5) {
                                sb.append(str3);
                                sb.append(",");
                                sb.append(sha256hash);
                            } else {
                                while (true) {
                                    int i3 = i + 1;
                                    sb.append(strArr[i]);
                                    sb.append(",");
                                    if (i3 >= 5) {
                                        break;
                                    }
                                    i = i3;
                                }
                                sb.append(sha256hash);
                                linkedHashSet.remove(strArr[0]);
                            }
                            internalHashedUserData.put(str, sb.toString());
                        } else {
                            return;
                        }
                    } else {
                        internalHashedUserData.put(str, sha256hash);
                    }
                }
                UserDataStore userDataStore2 = INSTANCE;
                Utility utility2 = Utility.INSTANCE;
                userDataStore2.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void setUserDataAndHash(Bundle bundle) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable(bundle) {
                    public final /* synthetic */ Bundle f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        UserDataStore.m3562setUserDataAndHash$lambda1(this.f$0);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: setUserDataAndHash$lambda-1  reason: not valid java name */
    public static final void m3562setUserDataAndHash$lambda1(Bundle bundle) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    Log.w(TAG, "initStore should have been called before calling setUserData");
                    INSTANCE.initAndWait();
                }
                INSTANCE.updateHashUserData(bundle);
                UserDataStore userDataStore = INSTANCE;
                Utility utility = Utility.INSTANCE;
                userDataStore.writeDataIntoCache(USER_DATA_KEY, Utility.mapToJsonStr(externalHashedUserData));
                UserDataStore userDataStore2 = INSTANCE;
                Utility utility2 = Utility.INSTANCE;
                userDataStore2.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void updateHashUserData(Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this) && bundle != null) {
            try {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        String obj2 = obj.toString();
                        if (maybeSHA256Hashed(obj2)) {
                            ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                            if (obj2 != null) {
                                String lowerCase = obj2.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                concurrentHashMap.put(str, lowerCase);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            Utility utility = Utility.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(str, "key");
                            String sha256hash = Utility.sha256hash(normalizeData(str, obj2));
                            if (sha256hash != null) {
                                externalHashedUserData.put(str, sha256hash);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void writeDataIntoCache(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable(str, str2) {
                    public final /* synthetic */ String f$0;
                    public final /* synthetic */ String f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        UserDataStore.m3563writeDataIntoCache$lambda0(this.f$0, this.f$1);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: writeDataIntoCache$lambda-0  reason: not valid java name */
    public static final void m3563writeDataIntoCache$lambda0(String str, String str2) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$key");
                Intrinsics.checkNotNullParameter(str2, "$value");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(str, str2).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                if (str != null) {
                    bundle.putString(EMAIL, str);
                }
                if (str2 != null) {
                    bundle.putString(FIRST_NAME, str2);
                }
                if (str3 != null) {
                    bundle.putString(LAST_NAME, str3);
                }
                if (str4 != null) {
                    bundle.putString(PHONE, str4);
                }
                if (str5 != null) {
                    bundle.putString(DATE_OF_BIRTH, str5);
                }
                if (str6 != null) {
                    bundle.putString(GENDER, str6);
                }
                if (str7 != null) {
                    bundle.putString(CITY, str7);
                }
                if (str8 != null) {
                    bundle.putString(STATE, str8);
                }
                if (str9 != null) {
                    bundle.putString(ZIP, str9);
                }
                if (str10 != null) {
                    bundle.putString(COUNTRY, str10);
                }
                setUserDataAndHash(bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
