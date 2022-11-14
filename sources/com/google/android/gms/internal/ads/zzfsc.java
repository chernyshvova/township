package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsc<P> {
    public final P zza;
    public final byte[] zzb;
    public final zzfyu zzc;
    public final zzfzy zzd;

    public zzfsc(P p, byte[] bArr, zzfyu zzfyu, zzfzy zzfzy, int i) {
        this.zza = p;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zzc = zzfyu;
        this.zzd = zzfzy;
    }

    public final P zza() {
        return this.zza;
    }

    public final zzfyu zzb() {
        return this.zzc;
    }

    public final zzfzy zzc() {
        return this.zzd;
    }

    public final byte[] zzd() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
