package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbok extends zzbnl {
    public final /* synthetic */ zzbom zza;

    public /* synthetic */ zzbok(zzbom zzbom, zzboj zzboj) {
        this.zza = zzbom;
    }

    public final void zze(zzbnc zzbnc, String str) {
        if (this.zza.zzb != null) {
            this.zza.zzb.onCustomClick(this.zza.zzf(zzbnc), str);
        }
    }
}
