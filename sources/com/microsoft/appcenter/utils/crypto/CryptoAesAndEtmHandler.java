package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoAesAndEtmHandler implements CryptoHandler {
    @RequiresApi(api = 23)
    public byte[] decrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr) throws Exception {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int i2 = wrap.get();
        if (i2 == 16) {
            byte[] bArr2 = new byte[i2];
            wrap.get(bArr2);
            int i3 = wrap.get();
            if (i3 == 32) {
                byte[] bArr3 = new byte[i3];
                wrap.get(bArr3);
                byte[] bArr4 = new byte[wrap.remaining()];
                wrap.get(bArr4);
                SecretKey secretKey = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
                byte[] subkey = getSubkey(secretKey, 32);
                if (MessageDigest.isEqual(getMacBytes(getSubkey(secretKey, 16), bArr2, bArr4), bArr3)) {
                    CryptoUtils.ICipher cipher = ((CryptoUtils.C29751) iCryptoFactory).getCipher("AES/CBC/PKCS7Padding", (String) null);
                    CryptoUtils.C29751.C29762 r5 = (CryptoUtils.C29751.C29762) cipher;
                    r1.init(2, new SecretKeySpec(subkey, "AES"), new IvParameterSpec(bArr2));
                    return r1.doFinal(bArr4);
                }
                throw new SecurityException("Could not authenticate MAC value.");
            }
            throw new IllegalArgumentException("Invalid MAC length.");
        }
        throw new IllegalArgumentException("Invalid IV length.");
    }

    @RequiresApi(api = 23)
    public byte[] encrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr) throws Exception {
        SecretKey secretKey = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
        byte[] subkey = getSubkey(secretKey, 32);
        byte[] subkey2 = getSubkey(secretKey, 16);
        CryptoUtils.ICipher cipher = ((CryptoUtils.C29751) iCryptoFactory).getCipher("AES/CBC/PKCS7Padding", (String) null);
        CryptoUtils.C29751.C29762 r3 = (CryptoUtils.C29751.C29762) cipher;
        r1.init(1, new SecretKeySpec(subkey, "AES"));
        byte[] iv = r1.getIV();
        byte[] doFinal = r1.doFinal(bArr);
        byte[] macBytes = getMacBytes(subkey2, iv, doFinal);
        ByteBuffer allocate = ByteBuffer.allocate(iv.length + 1 + 1 + macBytes.length + doFinal.length);
        allocate.put((byte) iv.length);
        allocate.put(iv);
        allocate.put((byte) macBytes.length);
        allocate.put(macBytes);
        allocate.put(doFinal);
        return allocate.array();
    }

    @RequiresApi(api = 23)
    public void generateKey(CryptoUtils.ICryptoFactory iCryptoFactory, String str, Context context) throws Exception {
        Calendar instance = Calendar.getInstance();
        instance.add(1, 1);
        if (((CryptoUtils.C29751) iCryptoFactory) != null) {
            KeyGenerator instance2 = KeyGenerator.getInstance("HmacSHA256", "AndroidKeyStore");
            instance2.init(new KeyGenParameterSpec.Builder(str, 4).setKeyValidityForOriginationEnd(instance.getTime()).build());
            instance2.generateKey();
            return;
        }
        throw null;
    }

    @RequiresApi(api = 23)
    public String getAlgorithm() {
        return "AES/CBC/PKCS7Padding/256/HmacSHA256";
    }

    @RequiresApi(api = 23)
    public final byte[] getMacBytes(byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidKeyException, NoSuchAlgorithmException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        instance.update(bArr2);
        instance.update(bArr3);
        return instance.doFinal();
    }

    @RequiresApi(api = 23)
    @VisibleForTesting
    public byte[] getSubkey(@NonNull SecretKey secretKey, int i) throws NoSuchAlgorithmException, InvalidKeyException {
        if (i >= 1) {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKey);
            double d = (double) i;
            double macLength = (double) instance.getMacLength();
            Double.isNaN(d);
            Double.isNaN(macLength);
            int ceil = (int) Math.ceil(d / macLength);
            if (ceil <= 255) {
                byte[] bArr = new byte[0];
                ByteBuffer allocate = ByteBuffer.allocate(i);
                int i2 = 0;
                while (i2 < ceil) {
                    instance.update(bArr);
                    i2++;
                    instance.update((byte) i2);
                    bArr = instance.doFinal();
                    int min = Math.min(i, bArr.length);
                    allocate.put(bArr, 0, min);
                    i -= min;
                }
                return allocate.array();
            }
            throw new IllegalArgumentException("Output data length must be maximum of 255 * hash-length.");
        }
        throw new IllegalArgumentException("Output data length must be greater than zero.");
    }
}
