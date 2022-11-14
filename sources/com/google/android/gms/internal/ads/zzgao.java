package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgao implements zzfrh {
    public static final ThreadLocal<Cipher> zza = new zzgan();
    public final SecretKey zzb;

    public zzgao(byte[] bArr) throws GeneralSecurityException {
        zzgbx.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int length = bArr.length;
        if (length <= 2147483619) {
            byte[] bArr3 = new byte[(length + 28)];
            byte[] zza2 = zzgbv.zza(12);
            System.arraycopy(zza2, 0, bArr3, 0, 12);
            int length2 = zza2.length;
            if (!zzgbw.zza() || zzgbw.zzb() > 19) {
                algorithmParameterSpec = new GCMParameterSpec(128, zza2, 0, length2);
            } else {
                algorithmParameterSpec = new IvParameterSpec(zza2, 0, length2);
            }
            zza.get().init(1, this.zzb, algorithmParameterSpec);
            if (bArr2.length != 0) {
                zza.get().updateAAD(bArr2);
            }
            int doFinal = zza.get().doFinal(bArr, 0, length, bArr3, 12);
            if (doFinal == length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
