package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegt extends zzegs<zzcvj> {
    public final zzcop zza;
    public final zzdao zzb;
    public final zzejb zzc;
    public final zzdgi zzd;
    public final zzdkk zze;
    public final zzdds zzf;
    public final ViewGroup zzg;

    public zzegt(zzcop zzcop, zzdao zzdao, zzejb zzejb, zzdgi zzdgi, zzdkk zzdkk, zzdds zzdds, @Nullable ViewGroup viewGroup) {
        this.zza = zzcop;
        this.zzb = zzdao;
        this.zzc = zzejb;
        this.zzd = zzdgi;
        this.zze = zzdkk;
        this.zzf = zzdds;
        this.zzg = viewGroup;
    }

    public final zzfqn<zzcvj> zzc(zzeyw zzeyw, Bundle bundle) {
        zzcwf zzk = this.zza.zzk();
        zzdao zzdao = this.zzb;
        zzdao.zzb(zzeyw);
        zzdao.zzc(bundle);
        zzk.zzi(zzdao.zzd());
        zzk.zzj(this.zzd);
        zzk.zze(this.zzc);
        zzk.zzb(this.zze);
        zzk.zzd(new zzcxc(this.zzf));
        zzk.zzc(new zzcvg(this.zzg));
        zzcyl<zzcvj> zzb2 = zzk.zza().zzb();
        return zzb2.zzc(zzb2.zzb());
    }
}
