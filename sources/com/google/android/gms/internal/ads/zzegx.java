package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegx extends zzegs<zzdrj> {
    public final zzcop zza;
    public final zzdao zzb;
    public final zzdgi zzc;

    public zzegx(zzcop zzcop, zzdao zzdao, zzdgi zzdgi) {
        this.zza = zzcop;
        this.zzb = zzdao;
        this.zzc = zzdgi;
    }

    public final zzfqn<zzdrj> zzc(zzeyw zzeyw, Bundle bundle) {
        zzdrn zzs = this.zza.zzs();
        zzdao zzdao = this.zzb;
        zzdao.zzb(zzeyw);
        zzdao.zzc(bundle);
        zzs.zzb(zzdao.zzd());
        zzs.zzc(this.zzc);
        zzcyl<zzdrj> zzc2 = zzs.zza().zzc();
        return zzc2.zzc(zzc2.zzb());
    }
}
