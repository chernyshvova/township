package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzata extends zzanv {
    public static final Object zzb = new Object();
    public final long zzc;
    public final long zzd;

    public zzata(long j, boolean z) {
        this.zzc = j;
        this.zzd = j;
    }

    public final int zza() {
        return 1;
    }

    public final zzanu zzb(int i, zzanu zzanu, boolean z, long j) {
        zzaul.zzc(i, 0, 1);
        zzanu.zza = this.zzd;
        return zzanu;
    }

    public final int zzc() {
        return 1;
    }

    public final zzant zzd(int i, zzant zzant, boolean z) {
        zzaul.zzc(i, 0, 1);
        Object obj = z ? zzb : null;
        long j = this.zzc;
        zzant.zza = obj;
        zzant.zzb = obj;
        zzant.zzc = j;
        return zzant;
    }

    public final int zze(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }
}
