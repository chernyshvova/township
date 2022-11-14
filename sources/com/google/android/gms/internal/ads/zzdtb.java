package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdtb implements zzgjg<zzayx> {
    public final zzgju<Context> zza;
    public final zzgju<String> zzb;
    public final zzgju<zzcgy> zzc;
    public final zzgju<zzazh> zzd;
    public final zzgju<String> zze;

    public zzdtb(zzgju<Context> zzgju, zzgju<String> zzgju2, zzgju<zzcgy> zzgju3, zzgju<zzazh> zzgju4, zzgju<String> zzgju5) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcou) this.zza).zza();
        String zza3 = ((zzdyq) this.zzb).zzb();
        zzcgy zza4 = ((zzcpd) this.zzc).zza();
        zzazh zzb2 = this.zzd.zzb();
        String zzb3 = this.zze.zzb();
        zzayx zzayx = new zzayx(new zzazd(zza2));
        zzbca zza5 = zzbcb.zza();
        zza5.zza(zza4.zzb);
        zza5.zzb(zza4.zzc);
        zza5.zzc(true != zza4.zzd ? 2 : 0);
        zzayx.zzc(new zzdta(zzb2, zza3, (zzbcb) zza5.zzah(), zzb3));
        return zzayx;
    }
}
