package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegq extends zzegs<zzcxp> {
    public final zzcop zza;
    public final zzdkk zzb;
    public final zzdao zzc;
    public final zzdgi zzd;

    public zzegq(zzcop zzcop, zzdkk zzdkk, zzdao zzdao, zzdgi zzdgi) {
        this.zza = zzcop;
        this.zzb = zzdkk;
        this.zzc = zzdao;
        this.zzd = zzdgi;
    }

    public final zzfqn<zzcxp> zzc(zzeyw zzeyw, Bundle bundle) {
        zzdko zzr = this.zza.zzr();
        zzdao zzdao = this.zzc;
        zzdao.zzb(zzeyw);
        zzdao.zzc(bundle);
        zzr.zzd(zzdao.zzd());
        zzr.zze(this.zzd);
        zzr.zzc(this.zzb);
        zzr.zzb(new zzcvg((ViewGroup) null));
        zzcyl<zzcxp> zza2 = zzr.zza().zza();
        return zza2.zzc(zza2.zzb());
    }
}
