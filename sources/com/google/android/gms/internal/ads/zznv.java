package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zznv implements zzajw {
    public final zzov zza;
    public final zzadm zzb;
    public final zzadr zzc;
    public final IOException zzd;
    public final boolean zze;

    public zznv(zzov zzov, zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        this.zza = zzov;
        this.zzb = zzadm;
        this.zzc = zzadr;
        this.zzd = iOException;
        this.zze = z;
    }

    public final void zza(Object obj) {
        ((zzow) obj).zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
