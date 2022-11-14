package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaec implements Runnable {
    public final zzaee zza;
    public final zzaef zzb;
    public final zzadr zzc;

    public zzaec(zzaee zzaee, zzaef zzaef, zzadr zzadr) {
        this.zza = zzaee;
        this.zzb = zzaef;
        this.zzc = zzadr;
    }

    public final void run() {
        zzaee zzaee = this.zza;
        this.zzb.zzbh(zzaee.zza, zzaee.zzb, this.zzc);
    }
}
