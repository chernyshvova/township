package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdml {
    public static final zzdml zza = new zzdml(new zzdmk());
    @Nullable
    public final zzbnj zzb;
    @Nullable
    public final zzbng zzc;
    @Nullable
    public final zzbnw zzd;
    @Nullable
    public final zzbnt zze;
    @Nullable
    public final zzbsh zzf;
    public final SimpleArrayMap<String, zzbnp> zzg;
    public final SimpleArrayMap<String, zzbnm> zzh;

    public zzdml(zzdmk zzdmk) {
        this.zzb = zzdmk.zza;
        this.zzc = zzdmk.zzb;
        this.zzd = zzdmk.zzc;
        this.zzg = new SimpleArrayMap<>(zzdmk.zzf);
        this.zzh = new SimpleArrayMap<>(zzdmk.zzg);
        this.zze = zzdmk.zzd;
        this.zzf = zzdmk.zze;
    }

    @Nullable
    public final zzbnj zza() {
        return this.zzb;
    }

    @Nullable
    public final zzbng zzb() {
        return this.zzc;
    }

    @Nullable
    public final zzbnw zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzbnt zzd() {
        return this.zze;
    }

    @Nullable
    public final zzbsh zze() {
        return this.zzf;
    }

    @Nullable
    public final zzbnp zzf(String str) {
        return this.zzg.get(str);
    }

    @Nullable
    public final zzbnm zzg(String str) {
        return this.zzh.get(str);
    }

    public final ArrayList<String> zzh() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzg.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzi() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add(this.zzg.keyAt(i));
        }
        return arrayList;
    }
}
