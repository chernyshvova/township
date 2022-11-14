package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbyx extends zzbnl {
    public final /* synthetic */ zzbyz zza;

    public /* synthetic */ zzbyx(zzbyz zzbyz, zzbyw zzbyw) {
        this.zza = zzbyz;
    }

    public final void zze(zzbnc zzbnc, String str) {
        if (this.zza.zzb != null) {
            this.zza.zzb.onCustomClick(this.zza.zzf(zzbnc), str);
        }
    }
}
