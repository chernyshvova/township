package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaeb implements Runnable {
    public final zzaee zza;
    public final zzaef zzb;
    public final zzadm zzc;
    public final zzadr zzd;
    public final IOException zze;
    public final boolean zzf;

    public zzaeb(zzaee zzaee, zzaef zzaef, zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        this.zza = zzaee;
        this.zzb = zzaef;
        this.zzc = zzadm;
        this.zzd = zzadr;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        zzaee zzaee = this.zza;
        this.zzb.zzbg(zzaee.zza, zzaee.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
