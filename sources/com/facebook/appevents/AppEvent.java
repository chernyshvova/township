package com.facebook.appevents;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: AppEvent.kt */
public final class AppEvent implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_IDENTIFIER_LENGTH = 40;
    public static final long serialVersionUID = 1;
    public static final HashSet<String> validatedIdentifiers = new HashSet<>();
    public final String checksum;
    public final boolean inBackground;
    public final boolean isImplicit;
    public final JSONObject jsonObject;
    public final String name;

    /* compiled from: AppEvent.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String md5Checksum(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                if (str != null) {
                    byte[] bytes = str.getBytes(forName);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes, 0, bytes.length);
                    byte[] digest = instance.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    return AppEventUtility.bytesToHex(digest);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (NoSuchAlgorithmException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd("Failed to generate checksum: ", (Exception) e);
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } catch (UnsupportedEncodingException e2) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd("Failed to generate checksum: ", (Exception) e2);
                return AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
        }

        /* access modifiers changed from: private */
        public final void validateIdentifier(String str) {
            boolean contains;
            if (str != null) {
                if (!(str.length() == 0) && str.length() <= 40) {
                    synchronized (AppEvent.validatedIdentifiers) {
                        contains = AppEvent.validatedIdentifiers.contains(str);
                    }
                    if (contains) {
                        return;
                    }
                    if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").matches(str)) {
                        synchronized (AppEvent.validatedIdentifiers) {
                            AppEvent.validatedIdentifiers.add(str);
                        }
                        return;
                    }
                    throw new FacebookException(GeneratedOutlineSupport.outline21(new Object[]{str}, 1, "Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", "java.lang.String.format(format, *args)"));
                }
            }
            if (str == null) {
                str = "<None Provided>";
            }
            String format = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }
    }

    /* compiled from: AppEvent.kt */
    public static final class SerializationProxyV2 implements Serializable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final long serialVersionUID = 20160803001L;
        public final String checksum;
        public final boolean inBackground;
        public final boolean isImplicit;
        public final String jsonString;

        /* compiled from: AppEvent.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SerializationProxyV2(String str, boolean z, boolean z2, String str2) {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
            this.checksum = str2;
        }

        private final Object readResolve() throws JSONException, ObjectStreamException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum, (DefaultConstructorMarker) null);
        }
    }

    public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z, boolean z2, UUID uuid) throws JSONException, FacebookException {
        Intrinsics.checkNotNullParameter(str, "contextName");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        this.isImplicit = z;
        this.inBackground = z2;
        this.name = str2;
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    public /* synthetic */ AppEvent(String str, boolean z, boolean z2, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, str2);
    }

    private final String calculateChecksum() {
        if (Build.VERSION.SDK_INT > 19) {
            Companion companion = Companion;
            String jSONObject = this.jsonObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
            return companion.md5Checksum(jSONObject);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Intrinsics.checkNotNullParameter(arrayList, "$this$sort");
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str);
            sb.append(" = ");
            sb.append(this.jsonObject.optString(str));
            sb.append(10);
        }
        Companion companion2 = Companion;
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return companion2.md5Checksum(sb2);
    }

    private final JSONObject getJSONObjectForAppEvent(String str, String str2, Double d, Bundle bundle, UUID uuid) {
        Companion.validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        String processEvent = RestrictiveDataManager.processEvent(str2);
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, processEvent);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, Companion.md5Checksum(processEvent));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / ((long) 1000));
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map<String, String> validateParameters = validateParameters(bundle);
            for (String next : validateParameters.keySet()) {
                jSONObject.put(next, validateParameters.get(next));
            }
        }
        if (d != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } else {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventObject.toString()");
            companion.log(loggingBehavior, "AppEvents", "Created app event '%s'", jSONObject2);
        }
        return jSONObject;
    }

    private final Map<String, String> validateParameters(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(str, "key");
            companion.validateIdentifier(str);
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof Number)) {
                hashMap.put(str, obj.toString());
            } else {
                throw new FacebookException(GeneratedOutlineSupport.outline21(new Object[]{obj, str}, 2, "Parameter value '%s' for key '%s' should be a string or a numeric type.", "java.lang.String.format(format, *args)"));
            }
        }
        IntegrityManager integrityManager = IntegrityManager.INSTANCE;
        IntegrityManager.processParameters(hashMap);
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        RestrictiveDataManager.processParameters(hashMap, this.name);
        EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
        EventDeactivationManager.processDeprecatedParameters(hashMap, this.name);
        return hashMap;
    }

    private final Object writeReplace() throws ObjectStreamException {
        String jSONObject = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        return new SerializationProxyV2(jSONObject, this.isImplicit, this.inBackground, this.checksum);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    public final JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return Intrinsics.areEqual(calculateChecksum(), this.checksum);
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline21(new Object[]{this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3, "\"%s\", implicit: %b, json: %s", "java.lang.String.format(format, *args)");
    }

    public AppEvent(String str, boolean z, boolean z2, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.isImplicit = z;
        String optString = jSONObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.name = optString;
        this.checksum = str2;
        this.inBackground = z2;
    }
}
