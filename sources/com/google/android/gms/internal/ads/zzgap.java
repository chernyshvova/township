package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgap implements zzfrk {
    public static final Collection<Integer> zza = Arrays.asList(new Integer[]{64});
    public static final byte[] zzb = new byte[16];
    public final zzgbq zzc;
    public final byte[] zzd;

    public zzgap(byte[] bArr) throws GeneralSecurityException {
        Collection<Integer> collection = zza;
        int length = bArr.length;
        if (collection.contains(Integer.valueOf(length))) {
            int i = length >> 1;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
            this.zzd = Arrays.copyOfRange(bArr, i, length);
            this.zzc = new zzgbq(copyOfRange);
            return;
        }
        throw new InvalidKeyException(GeneratedOutlineSupport.outline10(59, "invalid key size: ", length, " bytes; key must have 64 bytes"));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        if (bArr.length <= 2147483631) {
            Cipher zza2 = zzgbe.zza.zza("AES/CTR/NoPadding");
            byte[][] bArr4 = {bArr2, bArr};
            byte[] zza3 = this.zzc.zza(zzb, 16);
            for (int i = 0; i <= 0; i++) {
                byte[] bArr5 = bArr4[i];
                if (bArr5 == null) {
                    bArr5 = new byte[0];
                }
                zza3 = zzgar.zzd(zzgaq.zza(zza3), this.zzc.zza(bArr5, 16));
            }
            byte[] bArr6 = bArr4[1];
            int length = bArr6.length;
            if (length >= 16) {
                int length2 = zza3.length;
                if (length >= length2) {
                    int i2 = length - length2;
                    bArr3 = Arrays.copyOf(bArr6, length);
                    for (int i3 = 0; i3 < zza3.length; i3++) {
                        int i4 = i2 + i3;
                        bArr3[i4] = (byte) (bArr3[i4] ^ zza3[i3]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzgar.zzd(zzgaq.zzb(bArr6), zzgaq.zza(zza3));
            }
            byte[] zza4 = this.zzc.zza(bArr3, 16);
            byte[] bArr7 = (byte[]) zza4.clone();
            bArr7[8] = (byte) (bArr7[8] & Byte.MAX_VALUE);
            bArr7[12] = (byte) (bArr7[12] & Byte.MAX_VALUE);
            zza2.init(1, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr7));
            return zzgar.zza(zza4, zza2.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
