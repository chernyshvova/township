package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyb implements zzyc {
    public final List<zzzl> zza;
    public final zztz[] zzb;
    public boolean zzc;
    public int zzd;
    public int zze;
    public long zzf;

    public zzyb(List<zzzl> list) {
        this.zza = list;
        this.zzb = new zztz[list.size()];
    }

    private final boolean zzf(zzakr zzakr, int i) {
        if (zzakr.zzd() == 0) {
            return false;
        }
        if (zzakr.zzn() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza() {
        this.zzc = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzzl zzzl = this.zza.get(i);
            zzzo.zza();
            zztz zza2 = zztd.zza(zzzo.zzb(), 3);
            zzkb zzkb = new zzkb();
            zzkb.zza(zzzo.zzc());
            zzkb.zzj("application/dvbsubs");
            zzkb.zzl(Collections.singletonList(zzzl.zzb));
            zzkb.zzd(zzzl.zza);
            zza2.zza(zzkb.zzD());
            this.zzb[i] = zza2;
        }
    }

    public final void zzc(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzf = j;
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zzd(zzakr zzakr) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzakr, 32)) {
            if (this.zzd != 1 || zzf(zzakr, 0)) {
                int zzg = zzakr.zzg();
                int zzd2 = zzakr.zzd();
                for (zztz zzf2 : this.zzb) {
                    zzakr.zzh(zzg);
                    zzf2.zzf(zzakr, zzd2);
                }
                this.zze += zzd2;
            }
        }
    }

    public final void zze() {
        if (this.zzc) {
            for (zztz zzd2 : this.zzb) {
                zzd2.zzd(this.zzf, 1, this.zze, 0, (zzty) null);
            }
            this.zzc = false;
        }
    }
}
