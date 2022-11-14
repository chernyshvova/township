package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzewa implements zzgjg<zzevv<zzdro, zzdrj>> {
    public final zzgju<Context> zza;
    public final zzgju<zzfad> zzb;
    public final zzgju<zzfav> zzc;

    public zzewa(zzgju<Context> zzgju, zzgju<zzfad> zzgju2, zzgju<zzfav> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    /* renamed from: zza */
    public final zzevv<zzdro, zzdrj> zzb() {
        Context zzb2 = this.zza.zzb();
        zzfad zzb3 = this.zzb.zzb();
        zzfav zzb4 = this.zzc.zzb();
        if (((Integer) zzbex.zzc().zzb(zzbjn.zzeE)).intValue() > 0) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeC)).booleanValue() || zzs.zzg().zzl().zzo().zzi()) {
                zzfau zza2 = zzb4.zza(zzfal.Rewarded, zzb2, zzb3, new zzeva(new zzeux()));
                return new zzevc(new zzevm(new zzevl()), new zzevi(zza2.zza, zzche.zza), zza2.zzb, zza2.zza.zze().zzf, zzche.zza);
            }
        }
        return new zzevl();
    }
}
