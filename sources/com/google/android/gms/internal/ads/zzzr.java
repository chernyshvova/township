package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzr {
    public final List<zzkc> zza;
    public final zztz[] zzb;

    public zzzr(List<zzkc> list) {
        this.zza = list;
        this.zzb = new zztz[list.size()];
    }

    public final void zza(zztd zztd, zzzo zzzo) {
        String str;
        for (int i = 0; i < this.zzb.length; i++) {
            zzzo.zza();
            zztz zza2 = zztd.zza(zzzo.zzb(), 3);
            zzkc zzkc = this.zza.get(i);
            String str2 = zzkc.zzl;
            boolean z = true;
            if (!"application/cea-608".equals(str2) && !"application/cea-708".equals(str2)) {
                z = false;
            }
            String valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str = "Invalid closed caption mime type provided: ".concat(valueOf);
            } else {
                str = new String("Invalid closed caption mime type provided: ");
            }
            zzajg.zzb(z, str);
            zzkb zzkb = new zzkb();
            zzkb.zza(zzzo.zzc());
            zzkb.zzj(str2);
            zzkb.zze(zzkc.zzd);
            zzkb.zzd(zzkc.zzc);
            zzkb.zzB(zzkc.zzD);
            zzkb.zzl(zzkc.zzn);
            zza2.zza(zzkb.zzD());
            this.zzb[i] = zza2;
        }
    }

    public final void zzb(long j, zzakr zzakr) {
        if (zzakr.zzd() >= 9) {
            int zzv = zzakr.zzv();
            int zzv2 = zzakr.zzv();
            int zzn = zzakr.zzn();
            if (zzv == 434 && zzv2 == 1195456820 && zzn == 3) {
                zzsu.zzb(j, zzakr, this.zzb);
            }
        }
    }
}
