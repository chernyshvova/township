package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuq {
    public final zzfrh zza;
    public final zzfrk zzb;

    public zzfuq(zzfrh zzfrh) {
        this.zza = zzfrh;
        this.zzb = null;
    }

    public zzfuq(zzfrk zzfrk) {
        this.zza = null;
        this.zzb = zzfrk;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzfrh zzfrh = this.zza;
        if (zzfrh != null) {
            return zzfrh.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
