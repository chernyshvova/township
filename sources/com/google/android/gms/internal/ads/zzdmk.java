package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdmk {
    public zzbnj zza;
    public zzbng zzb;
    public zzbnw zzc;
    public zzbnt zzd;
    public zzbsh zze;
    public final SimpleArrayMap<String, zzbnp> zzf = new SimpleArrayMap<>();
    public final SimpleArrayMap<String, zzbnm> zzg = new SimpleArrayMap<>();

    public final zzdmk zza(zzbnj zzbnj) {
        this.zza = zzbnj;
        return this;
    }

    public final zzdmk zzb(zzbng zzbng) {
        this.zzb = zzbng;
        return this;
    }

    public final zzdmk zzc(zzbnw zzbnw) {
        this.zzc = zzbnw;
        return this;
    }

    public final zzdmk zzd(zzbnt zzbnt) {
        this.zzd = zzbnt;
        return this;
    }

    public final zzdmk zze(zzbsh zzbsh) {
        this.zze = zzbsh;
        return this;
    }

    public final zzdmk zzf(String str, zzbnp zzbnp, @Nullable zzbnm zzbnm) {
        this.zzf.put(str, zzbnp);
        if (zzbnm != null) {
            this.zzg.put(str, zzbnm);
        }
        return this;
    }

    public final zzdml zzg() {
        return new zzdml(this);
    }
}
