package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbtl implements zzchn<zzbtu> {
    public final /* synthetic */ zzbtn zza;

    public zzbtl(zzbtn zzbtn) {
        this.zza = zzbtn;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbtu zzbtu = (zzbtu) obj;
        zze.zza("Releasing engine reference.");
        this.zza.zzb.zzb();
    }
}
