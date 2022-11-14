package com.facebook.internal.security;

import android.util.Base64;
import android.util.Log;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.playrix.gplay.billing.Security;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: OidcSecurityUtil.kt */
public final class OidcSecurityUtil {
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();
    public static final String OPENID_KEYS_PATH = "/.well-known/oauth/openid/keys/";
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";
    public static final long TIMEOUT_IN_MILLISECONDS = 5000;

    public static final PublicKey getPublicKeyFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        byte[] decode = Base64.decode(CharsKt__CharKt.replace$default(CharsKt__CharKt.replace$default(CharsKt__CharKt.replace$default(str, "\n", "", false, 4), "-----BEGIN PUBLIC KEY-----", "", false, 4), "-----END PUBLIC KEY-----", "", false, 4), 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance(Security.KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decode));
        Intrinsics.checkNotNullExpressionValue(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX INFO: finally extract failed */
    public static final String getRawKeyFromEndPoint(String str) {
        Intrinsics.checkNotNullParameter(str, "kid");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        URL url = new URL(Utility.URL_SCHEME, Intrinsics.stringPlus("www.", FacebookSdk.getFacebookDomain()), OPENID_KEYS_PATH);
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        FacebookSdk.getExecutor().execute(new Runnable(url, ref$ObjectRef, str, reentrantLock, newCondition) {
            public final /* synthetic */ URL f$0;
            public final /* synthetic */ Ref$ObjectRef f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ ReentrantLock f$3;
            public final /* synthetic */ Condition f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                OidcSecurityUtil.m3650getRawKeyFromEndPoint$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
        reentrantLock.lock();
        try {
            newCondition.await(5000, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) ref$ObjectRef.element;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: getRawKeyFromEndPoint$lambda-1  reason: not valid java name */
    public static final void m3650getRawKeyFromEndPoint$lambda1(URL url, Ref$ObjectRef ref$ObjectRef, String str, ReentrantLock reentrantLock, Condition condition) {
        Intrinsics.checkNotNullParameter(url, "$openIdKeyUrl");
        Intrinsics.checkNotNullParameter(ref$ObjectRef, "$result");
        Intrinsics.checkNotNullParameter(str, "$kid");
        Intrinsics.checkNotNullParameter(reentrantLock, "$lock");
        URLConnection openConnection = url.openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                String readText = zzam.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                httpURLConnection.getInputStream().close();
                ref$ObjectRef.element = new JSONObject(readText).optString(str);
                httpURLConnection.disconnect();
                reentrantLock.lock();
                try {
                    condition.signal();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (Exception e) {
                try {
                    String name = INSTANCE.getClass().getName();
                    String message = e.getMessage();
                    if (message == null) {
                        message = "Error getting public key";
                    }
                    Log.d(name, message);
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    condition.signal();
                } catch (Throwable th2) {
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    condition.signal();
                    throw th2;
                } finally {
                    reentrantLock.unlock();
                }
            } catch (Throwable th3) {
                throw th3;
            }
            reentrantLock.unlock();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    public static final boolean verify(PublicKey publicKey, String str, String str2) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, "signature");
        try {
            Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
            instance.initVerify(publicKey);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] decode = Base64.decode(str2, 8);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(signature, Base64.URL_SAFE)");
            return instance.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }

    public final String getOPENID_KEYS_PATH() {
        return OPENID_KEYS_PATH;
    }
}
