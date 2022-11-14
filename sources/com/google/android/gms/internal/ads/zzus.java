package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzus {
    public final zztz zza;

    public zzus(zztz zztz) {
        this.zza = zztz;
    }

    public abstract boolean zza(zzakr zzakr) throws zzlg;

    public abstract boolean zzb(zzakr zzakr, long j) throws zzlg;

    public final boolean zzf(zzakr zzakr, long j) throws zzlg {
        return zza(zzakr) && zzb(zzakr, j);
    }
}
