package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcnm implements Runnable {
    public final zzcnn zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final boolean zze;

    public zzcnm(zzcnn zzcnn, int i, int i2, boolean z, boolean z2) {
        this.zza = zzcnn;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = z2;
    }

    public final void run() {
        this.zza.zzt(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
