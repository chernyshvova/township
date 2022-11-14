package com.playrix.gplay.billing;

import android.text.TextUtils;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security {
    public static final String KEY_FACTORY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    public static final String TAG = "IABUtil/Security";

    public static PublicKey generatePublicKey(String str) {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            Log.e(TAG, "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        } catch (Base64DecoderException e3) {
            Log.e(TAG, "Base64 decoding failed.");
            throw new IllegalArgumentException(e3);
        }
    }

    public static boolean verify(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM);
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2))) {
                return true;
            }
            Log.e(TAG, "Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException unused) {
            Log.e(TAG, "NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException unused2) {
            Log.e(TAG, "Invalid key specification.");
            return false;
        } catch (SignatureException unused3) {
            Log.e(TAG, "Signature exception.");
            return false;
        } catch (Base64DecoderException unused4) {
            Log.e(TAG, "Base64 decoding failed.");
            return false;
        }
    }

    public static boolean verifyPurchase(String str, String str2, String str3) {
        if (str2 == null) {
            Log.e(TAG, "data is null");
            return false;
        } else if (TextUtils.isEmpty(str3) || verify(generatePublicKey(str), str2, str3)) {
            return true;
        } else {
            Log.w(TAG, "signature does not match data.");
            return false;
        }
    }
}
