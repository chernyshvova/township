package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahd {
    public final int zza;
    public final zzmc[] zzb;
    @Nullable
    public final Object zzc;
    public final zzagf[] zzd;

    public zzahd(zzmc[] zzmcArr, zzagf[] zzagfArr, @Nullable Object obj, byte[] bArr) {
        this.zzb = zzmcArr;
        this.zzd = (zzagf[]) zzagfArr.clone();
        this.zzc = obj;
        this.zza = zzmcArr.length;
    }

    public final boolean zza(int i) {
        return this.zzb[i] != null;
    }

    public final boolean zzb(@Nullable zzahd zzahd, int i) {
        if (zzahd != null && zzalh.zzc(this.zzb[i], zzahd.zzb[i]) && zzalh.zzc(this.zzd[i], zzahd.zzd[i])) {
            return true;
        }
        return false;
    }
}
