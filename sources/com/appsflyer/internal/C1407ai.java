package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.facebook.internal.Utility;
import com.playrix.gplay.billing.Base64;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.appsflyer.internal.ai */
public final class C1407ai {
    public static String AFInAppEventParameterName(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toString((b & Base64.EQUALS_SIGN_ENC) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    public static String AFInAppEventType(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return valueOf(instance.digest());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.values(sb.toString(), e);
            return null;
        }
    }

    public static String AFKeystoreWrapper(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA1);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return valueOf(instance.digest());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.values(sb.toString(), e);
            return null;
        }
    }

    public static String valueOf(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA256);
            instance.update(str.getBytes());
            return AFInAppEventParameterName(instance.digest());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA-256");
            AFLogger.values(sb.toString(), e);
            return null;
        }
    }

    public static String values(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            return AFInAppEventParameterName(instance.doFinal(str.getBytes())).toLowerCase();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            AFLogger.AFInAppEventParameterName(e.getMessage(), e);
            return e.getMessage();
        }
    }

    public static String valueOf(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
        }
        String obj = formatter.toString();
        formatter.close();
        return obj;
    }
}
