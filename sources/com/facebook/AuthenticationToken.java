package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthenticationToken.kt */
public final class AuthenticationToken implements Parcelable {
    public static final String AUTHENTICATION_TOKEN_KEY = "id_token";
    public static final String CLAIMS_KEY = "claims";
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new AuthenticationToken$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXPECTED_NONCE_KEY = "expected_nonce";
    public static final String HEADER_KEY = "header";
    public static final String SIGNATURE_KEY = "signature";
    public static final String TOKEN_STRING_KEY = "token_string";
    public final AuthenticationTokenClaims claims;
    public final String expectedNonce;
    public final AuthenticationTokenHeader header;
    public final String signature;
    public final String token;

    /* compiled from: AuthenticationToken.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationToken getCurrentAuthenticationToken() {
            return AuthenticationTokenManager.Companion.getInstance().getCurrentAuthenticationToken();
        }

        public final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
            AuthenticationTokenManager.Companion.getInstance().setCurrentAuthenticationToken(authenticationToken);
        }
    }

    public AuthenticationToken(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "expectedNonce");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, "token");
        Validate validate2 = Validate.INSTANCE;
        Validate.notEmpty(str2, "expectedNonce");
        List split$default = CharsKt__CharKt.split$default(str, new String[]{CodelessMatcher.CURRENT_CLASS_NAME}, false, 0, 6);
        if (split$default.size() == 3) {
            String str3 = (String) split$default.get(0);
            String str4 = (String) split$default.get(1);
            String str5 = (String) split$default.get(2);
            this.token = str;
            this.expectedNonce = str2;
            this.header = new AuthenticationTokenHeader(str3);
            this.claims = new AuthenticationTokenClaims(str4, str2);
            if (isValidSignature(str3, str4, str5, this.header.getKid())) {
                this.signature = str5;
                return;
            }
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        throw new IllegalArgumentException("Invalid IdToken string".toString());
    }

    public static final AuthenticationToken getCurrentAuthenticationToken() {
        return Companion.getCurrentAuthenticationToken();
    }

    private final boolean isValidSignature(String str, String str2, String str3, String str4) {
        try {
            OidcSecurityUtil oidcSecurityUtil = OidcSecurityUtil.INSTANCE;
            String rawKeyFromEndPoint = OidcSecurityUtil.getRawKeyFromEndPoint(str4);
            if (rawKeyFromEndPoint == null) {
                return false;
            }
            OidcSecurityUtil oidcSecurityUtil2 = OidcSecurityUtil.INSTANCE;
            PublicKey publicKeyFromString = OidcSecurityUtil.getPublicKeyFromString(rawKeyFromEndPoint);
            OidcSecurityUtil oidcSecurityUtil3 = OidcSecurityUtil.INSTANCE;
            return OidcSecurityUtil.verify(publicKeyFromString, str + '.' + str2, str3);
        } catch (IOException | InvalidKeySpecException unused) {
            return false;
        }
    }

    public static final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
        Companion.setCurrentAuthenticationToken(authenticationToken);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        if (!Intrinsics.areEqual(this.token, authenticationToken.token) || !Intrinsics.areEqual(this.expectedNonce, authenticationToken.expectedNonce) || !Intrinsics.areEqual(this.header, authenticationToken.header) || !Intrinsics.areEqual(this.claims, authenticationToken.claims) || !Intrinsics.areEqual(this.signature, authenticationToken.signature)) {
            return false;
        }
        return true;
    }

    public final AuthenticationTokenClaims getClaims() {
        return this.claims;
    }

    public final String getExpectedNonce() {
        return this.expectedNonce;
    }

    public final AuthenticationTokenHeader getHeader() {
        return this.header;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.expectedNonce, GeneratedOutlineSupport.outline4(this.token, 527, 31), 31);
        int hashCode = this.claims.hashCode();
        return this.signature.hashCode() + ((hashCode + ((this.header.hashCode() + outline4) * 31)) * 31);
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TOKEN_STRING_KEY, this.token);
        jSONObject.put(EXPECTED_NONCE_KEY, this.expectedNonce);
        jSONObject.put(HEADER_KEY, this.header.toJSONObject$facebook_core_release());
        jSONObject.put(CLAIMS_KEY, this.claims.toJSONObject$facebook_core_release());
        jSONObject.put("signature", this.signature);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.token);
        parcel.writeString(this.expectedNonce);
        parcel.writeParcelable(this.header, i);
        parcel.writeParcelable(this.claims, i);
        parcel.writeString(this.signature);
    }

    public AuthenticationToken(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Validate validate = Validate.INSTANCE;
        this.token = Validate.notNullOrEmpty(readString, "token");
        String readString2 = parcel.readString();
        Validate validate2 = Validate.INSTANCE;
        this.expectedNonce = Validate.notNullOrEmpty(readString2, "expectedNonce");
        Parcelable readParcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (readParcelable != null) {
            this.header = (AuthenticationTokenHeader) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (readParcelable2 != null) {
                this.claims = (AuthenticationTokenClaims) readParcelable2;
                String readString3 = parcel.readString();
                Validate validate3 = Validate.INSTANCE;
                this.signature = Validate.notNullOrEmpty(readString3, "signature");
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public AuthenticationToken(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        String string = jSONObject.getString(TOKEN_STRING_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(TOKEN_STRING_KEY)");
        this.token = string;
        String string2 = jSONObject.getString(EXPECTED_NONCE_KEY);
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(EXPECTED_NONCE_KEY)");
        this.expectedNonce = string2;
        String string3 = jSONObject.getString("signature");
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(SIGNATURE_KEY)");
        this.signature = string3;
        JSONObject jSONObject2 = jSONObject.getJSONObject(HEADER_KEY);
        JSONObject jSONObject3 = jSONObject.getJSONObject(CLAIMS_KEY);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "headerJSONObject");
        this.header = new AuthenticationTokenHeader(jSONObject2);
        AuthenticationTokenClaims.Companion companion = AuthenticationTokenClaims.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "claimsJSONObject");
        this.claims = companion.createFromJSONObject$facebook_core_release(jSONObject3);
    }
}
