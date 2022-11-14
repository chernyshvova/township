package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzahh implements Runnable {
    public final zzahi zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;

    public zzahh(zzahi zzahi, int i, long j, long j2) {
        this.zza = zzahi;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        zzahi zzahi = this.zza;
        zzahi.zzb.zzV(this.zzb, this.zzc, this.zzd);
    }
}
