package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzady implements Runnable {
    public final zzaee zza;
    public final zzaef zzb;
    public final zzadm zzc;
    public final zzadr zzd;

    public zzady(zzaee zzaee, zzaef zzaef, zzadm zzadm, zzadr zzadr) {
        this.zza = zzaee;
        this.zzb = zzaef;
        this.zzc = zzadm;
        this.zzd = zzadr;
    }

    public final void run() {
        zzaee zzaee = this.zza;
        this.zzb.zza(zzaee.zza, zzaee.zzb, this.zzc, this.zzd);
    }
}
