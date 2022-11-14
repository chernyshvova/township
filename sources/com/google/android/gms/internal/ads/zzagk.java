package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagk implements Comparable<zzagk> {
    public final boolean zza;
    public final boolean zzb;

    public zzagk(zzkc zzkc, int i) {
        this.zza = 1 != (zzkc.zzd & 1) ? false : true;
        this.zzb = zzags.zzd(i, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzagk zzagk) {
        return zzfma.zzg().zzd(this.zzb, zzagk.zzb).zzd(this.zza, zzagk.zza).zze();
    }
}
