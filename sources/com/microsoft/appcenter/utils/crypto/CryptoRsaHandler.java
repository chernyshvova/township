package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import com.playrix.gplay.billing.Security;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public class CryptoRsaHandler implements CryptoHandler {
    public byte[] decrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr) throws Exception {
        CryptoUtils.C29751.C29762 r2 = (CryptoUtils.C29751.C29762) ((CryptoUtils.C29751) iCryptoFactory).getCipher("RSA/ECB/PKCS1Padding", i >= 23 ? "AndroidKeyStoreBCWorkaround" : "AndroidOpenSSL");
        r1.init(2, ((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
        return r1.doFinal(bArr);
    }

    public byte[] encrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] bArr) throws Exception {
        CryptoUtils.ICipher cipher = ((CryptoUtils.C29751) iCryptoFactory).getCipher("RSA/ECB/PKCS1Padding", i >= 23 ? "AndroidKeyStoreBCWorkaround" : "AndroidOpenSSL");
        X509Certificate x509Certificate = (X509Certificate) ((KeyStore.PrivateKeyEntry) entry).getCertificate();
        try {
            x509Certificate.checkValidity();
            CryptoUtils.C29751.C29762 r2 = (CryptoUtils.C29751.C29762) cipher;
            r1.init(1, x509Certificate.getPublicKey());
            return r1.doFinal(bArr);
        } catch (CertificateExpiredException e) {
            throw new InvalidKeyException(e);
        }
    }

    @SuppressLint({"InlinedApi", "TrulyRandom"})
    public void generateKey(CryptoUtils.ICryptoFactory iCryptoFactory, String str, Context context) throws Exception {
        Calendar instance = Calendar.getInstance();
        instance.add(1, 1);
        KeyPairGenerator instance2 = KeyPairGenerator.getInstance(Security.KEY_FACTORY_ALGORITHM, "AndroidKeyStore");
        instance2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal(GeneratedOutlineSupport.outline16("CN=", str))).setStartDate(new Date()).setEndDate(instance.getTime()).setSerialNumber(BigInteger.TEN).setKeySize(2048).build());
        instance2.generateKeyPair();
    }

    public String getAlgorithm() {
        return "RSA/ECB/PKCS1Padding/2048";
    }
}
