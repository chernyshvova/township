package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyo implements zzyc {
    public final zzakr zza = new zzakr(10);
    public zztz zzb;
    public boolean zzc;
    public long zzd;
    public int zze;
    public int zzf;

    public final void zza() {
        this.zzc = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        zztz zza2 = zztd.zza(zzzo.zzb(), 5);
        this.zzb = zza2;
        zzkb zzkb = new zzkb();
        zzkb.zza(zzzo.zzc());
        zzkb.zzj("application/id3");
        zza2.zza(zzkb.zzD());
    }

    public final void zzc(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzd = j;
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zzd(zzakr zzakr) {
        zzajg.zze(this.zzb);
        if (this.zzc) {
            int zzd2 = zzakr.zzd();
            int i = this.zzf;
            if (i < 10) {
                int min = Math.min(zzd2, 10 - i);
                System.arraycopy(zzakr.zzi(), zzakr.zzg(), this.zza.zzi(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzh(0);
                    if (this.zza.zzn() == 73 && this.zza.zzn() == 68 && this.zza.zzn() == 51) {
                        this.zza.zzk(3);
                        this.zze = this.zza.zzA() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zzd2, this.zze - this.zzf);
            zztx.zzb(this.zzb, zzakr, min2);
            this.zzf += min2;
        }
    }

    public final void zze() {
        int i;
        zzajg.zze(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            this.zzb.zzd(this.zzd, 1, i, 0, (zzty) null);
            this.zzc = false;
        }
    }
}
