package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzatr {
    public final zzatc zza;
    public final zzato zzb;
    public final Object zzc;
    public final zzanr[] zzd;

    public zzatr(zzatc zzatc, zzato zzato, Object obj, zzanr[] zzanrArr) {
        this.zza = zzatc;
        this.zzb = zzato;
        this.zzc = obj;
        this.zzd = zzanrArr;
    }

    public final boolean zza(zzatr zzatr, int i) {
        if (zzatr != null && zzava.zza(this.zzb.zza(i), zzatr.zzb.zza(i)) && zzava.zza(this.zzd[i], zzatr.zzd[i])) {
            return true;
        }
        return false;
    }
}
