package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdop implements zzcod {
    public final zzchi zza;

    public zzdop(zzchi zzchi) {
        this.zza = zzchi;
    }

    public final void zza(boolean z) {
        zzchi zzchi = this.zza;
        if (z) {
            zzchi.zzb();
        } else {
            zzchi.zzd(new zzehd(1, "Image Web View failed to load."));
        }
    }
}
