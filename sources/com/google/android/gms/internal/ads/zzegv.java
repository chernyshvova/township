package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegv extends zzegs<zzdiw> {
    public final zzcop zza;
    public final zzdao zzb;
    public final zzejb zzc;
    public final zzdgi zzd;

    public zzegv(zzcop zzcop, zzdao zzdao, zzejb zzejb, zzdgi zzdgi) {
        this.zza = zzcop;
        this.zzb = zzdao;
        this.zzc = zzejb;
        this.zzd = zzdgi;
    }

    public final zzfqn<zzdiw> zzc(zzeyw zzeyw, Bundle bundle) {
        zzdjs zzp = this.zza.zzp();
        zzdao zzdao = this.zzb;
        zzdao.zzb(zzeyw);
        zzdao.zzc(bundle);
        zzp.zzc(zzdao.zzd());
        zzp.zzd(this.zzd);
        zzp.zzb(this.zzc);
        zzcyl<zzdiw> zzb2 = zzp.zza().zzb();
        return zzb2.zzc(zzb2.zzb());
    }
}
