package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgaj implements zzgbo {
    public static final ThreadLocal<Cipher> zza = new zzgai();
    public final SecretKeySpec zzb;
    public final int zzc;
    public final int zzd;

    public zzgaj(byte[] bArr, int i) throws GeneralSecurityException {
        zzgbx.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
        int blockSize = zza.get().getBlockSize();
        this.zzd = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzc = i;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        int i2 = Integer.MAX_VALUE - i;
        if (length <= i2) {
            byte[] bArr2 = new byte[(i + length)];
            byte[] zza2 = zzgbv.zza(i);
            System.arraycopy(zza2, 0, bArr2, 0, this.zzc);
            int i3 = this.zzc;
            Cipher cipher = zza.get();
            byte[] bArr3 = new byte[this.zzd];
            System.arraycopy(zza2, 0, bArr3, 0, this.zzc);
            cipher.init(1, this.zzb, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length, bArr2, i3) == length) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException(GeneratedOutlineSupport.outline9(43, "plaintext length can not exceed ", i2));
    }
}
