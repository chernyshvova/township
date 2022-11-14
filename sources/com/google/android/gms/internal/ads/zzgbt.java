package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbt implements zzfrz {
    public final zzfvb zza;
    public final int zzb;

    public zzgbt(zzfvb zzfvb, int i) throws GeneralSecurityException {
        this.zza = zzfvb;
        this.zzb = i;
        if (i >= 10) {
            zzfvb.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return this.zza.zza(bArr, this.zzb);
    }
}
