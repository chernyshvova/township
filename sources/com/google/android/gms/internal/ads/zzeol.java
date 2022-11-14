package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeol implements zzeqp<zzeom> {
    public final zzfqo zza;
    public final zzdxo zzb;

    public zzeol(zzfqo zzfqo, zzdxo zzdxo) {
        this.zza = zzfqo;
        this.zzb = zzdxo;
    }

    public final zzfqn<zzeom> zza() {
        return this.zza.zzb(new zzeok(this));
    }

    public final /* synthetic */ zzeom zzb() throws Exception {
        return new zzeom(this.zzb.zzg(), this.zzb.zzd(), zzs.zzm().zzk());
    }
}
