package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.stats.CodePackage;
import com.playrix.gplay.billing.Security;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class IidStore {
    public static final String[] ALLOWABLE_SCOPES = {"*", "FCM", CodePackage.GCM, ""};
    public final String defaultSenderId;
    @GuardedBy("iidPrefs")
    public final SharedPreferences iidPrefs;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r0.isEmpty() != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IidStore(@androidx.annotation.NonNull com.google.firebase.FirebaseApp r4) {
        /*
            r3 = this;
            r3.<init>()
            r4.checkNotDeleted()
            android.content.Context r0 = r4.applicationContext
            java.lang.String r1 = "com.google.android.gms.appid"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.iidPrefs = r0
            r4.checkNotDeleted()
            com.google.firebase.FirebaseOptions r0 = r4.options
            java.lang.String r0 = r0.gcmSenderId
            if (r0 == 0) goto L_0x001b
            goto L_0x0049
        L_0x001b:
            r4.checkNotDeleted()
            com.google.firebase.FirebaseOptions r4 = r4.options
            java.lang.String r0 = r4.applicationId
            java.lang.String r4 = "1:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = "2:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x0033
            goto L_0x0049
        L_0x0033:
            java.lang.String r4 = ":"
            java.lang.String[] r4 = r0.split(r4)
            int r0 = r4.length
            r1 = 4
            r2 = 0
            if (r0 == r1) goto L_0x003f
            goto L_0x0048
        L_0x003f:
            r0 = 1
            r0 = r4[r0]
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0049
        L_0x0048:
            r0 = r2
        L_0x0049:
            r3.defaultSenderId = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.IidStore.<init>(com.google.firebase.FirebaseApp):void");
    }

    @Nullable
    public final String readPublicKeyFromLocalStorageAndCalculateInstanceId() {
        String str;
        PublicKey publicKey;
        synchronized (this.iidPrefs) {
            str = null;
            String string = this.iidPrefs.getString("|S||P|", (String) null);
            if (string == null) {
                return null;
            }
            try {
                publicKey = KeyFactory.getInstance(Security.KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                Log.w("ContentValues", "Invalid key stored " + e);
                publicKey = null;
            }
            if (publicKey == null) {
                return null;
            }
            try {
                byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
                digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
                str = Base64.encodeToString(digest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
                Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            }
        }
        return str;
    }
}
