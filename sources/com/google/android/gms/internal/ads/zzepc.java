package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzepc implements zzgjg<zzepa> {
    public final zzgju<zzfqo> zza;
    public final zzgju<zzeyw> zzb;
    public final zzgju<PackageInfo> zzc;
    public final zzgju<zzg> zzd;

    public zzepc(zzgju<zzfqo> zzgju, zzgju<zzeyw> zzgju2, zzgju<PackageInfo> zzgju3, zzgju<zzg> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzepa(zzfqo, ((zzdau) this.zzb).zza(), this.zzc.zzb(), ((zzezz) this.zzd).zzb());
    }
}
