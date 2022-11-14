package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxx {
    public final zzeyq zza;
    public final zzeye zzb;
    public final String zzc;

    public zzcxx(zzeyq zzeyq, zzeye zzeye, @Nullable String str) {
        this.zza = zzeyq;
        this.zzb = zzeye;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzeyq zza() {
        return this.zza;
    }

    public final zzeye zzb() {
        return this.zzb;
    }

    public final zzeyh zzc() {
        return this.zza.zzb.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
