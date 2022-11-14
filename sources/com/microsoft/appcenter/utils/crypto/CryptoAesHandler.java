package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import java.security.KeyStore;
import java.util.Calendar;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

@RequiresApi(23)
public class CryptoAesHandler implements CryptoHandler {
    public byte[] decrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr) throws Exception {
        CryptoUtils.C29751.C29762 r4 = (CryptoUtils.C29751.C29762) ((CryptoUtils.C29751) iCryptoFactory).getCipher("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
        int blockSize = r1.getBlockSize();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr, 0, blockSize);
        r1.init(2, ((KeyStore.SecretKeyEntry) entry).getSecretKey(), ivParameterSpec);
        return r1.doFinal(bArr, blockSize, bArr.length - blockSize);
    }

    public byte[] encrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr) throws Exception {
        CryptoUtils.ICipher cipher = ((CryptoUtils.C29751) iCryptoFactory).getCipher("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
        CryptoUtils.C29751.C29762 r2 = (CryptoUtils.C29751.C29762) cipher;
        r1.init(1, ((KeyStore.SecretKeyEntry) entry).getSecretKey());
        byte[] iv = r1.getIV();
        byte[] doFinal = r1.doFinal(bArr);
        byte[] bArr2 = new byte[(iv.length + doFinal.length)];
        System.arraycopy(iv, 0, bArr2, 0, iv.length);
        System.arraycopy(doFinal, 0, bArr2, iv.length, doFinal.length);
        return bArr2;
    }

    public void generateKey(CryptoUtils.ICryptoFactory iCryptoFactory, String str, Context context) throws Exception {
        Calendar instance = Calendar.getInstance();
        instance.add(1, 1);
        if (((CryptoUtils.C29751) iCryptoFactory) != null) {
            KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).setKeyValidityForOriginationEnd(instance.getTime()).build());
            instance2.generateKey();
            return;
        }
        throw null;
    }

    public String getAlgorithm() {
        return "AES/CBC/PKCS7Padding/256";
    }
}
