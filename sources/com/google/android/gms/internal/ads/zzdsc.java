package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdsc implements zzcod {
    public final zzchj zza;

    public zzdsc(zzchj zzchj) {
        this.zza = zzchj;
    }

    public final void zza(boolean z) {
        zzchj zzchj = this.zza;
        if (z) {
            zzchj.zzc(null);
        } else {
            zzchj.zzd(new Exception("Ad Web View failed to load."));
        }
    }
}
