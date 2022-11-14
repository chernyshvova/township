package com.helpshift.crypto;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.util.HSLogger;
import com.playrix.gplay.billing.Base64;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CryptoDM {
    public static final int MAX_HMAC_RETRY_COUNT = 1;
    public static final String TAG = "Helpshift_CryptoDM";

    private String getHMacSHA256(String str, String str2, int i) {
        if (i > 1) {
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return toHex(instance.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            if (i == 1) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Could not generate mac signature: ");
                outline24.append(e.getLocalizedMessage());
                outline24.append(", retryCount: ");
                outline24.append(i);
                HSLogger.m3245f(TAG, outline24.toString(), (Throwable) e, new ILogExtrasModel[0]);
            } else {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Could not generate mac signature: ");
                outline242.append(e.getLocalizedMessage());
                outline242.append(", retryCount: ");
                outline242.append(i);
                HSLogger.m3242e(TAG, outline242.toString(), e);
            }
            return getHMacSHA256(str, str2, i + 1);
        }
    }

    private String toHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & Base64.EQUALS_SIGN_ENC;
            int i2 = i * 2;
            cArr2[i2] = cArr[b >>> 4];
            cArr2[i2 + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public String getSignature(String str, String str2) throws GeneralSecurityException {
        String hMacSHA256 = getHMacSHA256(str, str2, 0);
        if (hMacSHA256 != null) {
            return hMacSHA256;
        }
        throw new GeneralSecurityException();
    }
}
