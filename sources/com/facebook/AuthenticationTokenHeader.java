package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Validate;
import java.nio.charset.Charset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthenticationTokenHeader.kt */
public final class AuthenticationTokenHeader implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new AuthenticationTokenHeader$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final String alg;
    public final String kid;
    public final String typ;

    /* compiled from: AuthenticationTokenHeader.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationTokenHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "encodedHeaderString");
        if (isValidHeader(str)) {
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decodedBytes");
            JSONObject jSONObject = new JSONObject(new String(decode, Charsets.UTF_8));
            String string = jSONObject.getString("alg");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"alg\")");
            this.alg = string;
            String string2 = jSONObject.getString("typ");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"typ\")");
            this.typ = string2;
            String string3 = jSONObject.getString("kid");
            Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(\"kid\")");
            this.kid = string3;
            return;
        }
        throw new IllegalArgumentException("Invalid Header".toString());
    }

    private final boolean isValidHeader(String str) {
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, "encodedHeaderString");
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decode, Charsets.UTF_8));
            String optString = jSONObject.optString("alg");
            Intrinsics.checkNotNullExpressionValue(optString, "alg");
            boolean z = (optString.length() > 0) && Intrinsics.areEqual(optString, "RS256");
            String optString2 = jSONObject.optString("kid");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(\"kid\")");
            boolean z2 = optString2.length() > 0;
            String optString3 = jSONObject.optString("typ");
            Intrinsics.checkNotNullExpressionValue(optString3, "jsonObj.optString(\"typ\")");
            boolean z3 = optString3.length() > 0;
            if (!z || !z2 || !z3) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        if (!Intrinsics.areEqual(this.alg, authenticationTokenHeader.alg) || !Intrinsics.areEqual(this.typ, authenticationTokenHeader.typ) || !Intrinsics.areEqual(this.kid, authenticationTokenHeader.kid)) {
            return false;
        }
        return true;
    }

    public final String getAlg() {
        return this.alg;
    }

    public final String getKid() {
        return this.kid;
    }

    public final String getTyp() {
        return this.typ;
    }

    public int hashCode() {
        return this.kid.hashCode() + GeneratedOutlineSupport.outline4(this.typ, GeneratedOutlineSupport.outline4(this.alg, 527, 31), 31);
    }

    @VisibleForTesting(otherwise = 2)
    public final String toEnCodedString() {
        String authenticationTokenHeader = toString();
        Charset charset = Charsets.UTF_8;
        if (authenticationTokenHeader != null) {
            byte[] bytes = authenticationTokenHeader.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 0);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.DEFAULT)");
            return encodeToString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put("typ", this.typ);
        jSONObject.put("kid", this.kid);
        return jSONObject;
    }

    public String toString() {
        String jSONObject = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "headerJsonObject.toString()");
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.alg);
        parcel.writeString(this.typ);
        parcel.writeString(this.kid);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.alg = Validate.notNullOrEmpty(readString, "alg");
        String readString2 = parcel.readString();
        Validate validate2 = Validate.INSTANCE;
        this.typ = Validate.notNullOrEmpty(readString2, "typ");
        String readString3 = parcel.readString();
        Validate validate3 = Validate.INSTANCE;
        this.kid = Validate.notNullOrEmpty(readString3, "kid");
    }

    public AuthenticationTokenHeader(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String string = jSONObject.getString("alg");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"alg\")");
        this.alg = string;
        String string2 = jSONObject.getString("typ");
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"typ\")");
        this.typ = string2;
        String string3 = jSONObject.getString("kid");
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(\"kid\")");
        this.kid = string3;
    }

    @VisibleForTesting(otherwise = 2)
    public AuthenticationTokenHeader(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "alg");
        Intrinsics.checkNotNullParameter(str2, "typ");
        Intrinsics.checkNotNullParameter(str3, "kid");
        this.alg = str;
        this.typ = str2;
        this.kid = str3;
    }
}
