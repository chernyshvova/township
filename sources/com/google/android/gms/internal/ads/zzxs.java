package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxs implements zzyc {
    public final zzakq zza;
    public final zzakr zzb;
    @Nullable
    public final String zzc;
    public String zzd;
    public zztz zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public long zzi;
    public zzkc zzj;
    public int zzk;
    public long zzl;

    public zzxs() {
        this((String) null);
    }

    public final void zza() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzd = zzzo.zzc();
        this.zze = zztd.zza(zzzo.zzb(), 1);
    }

    public final void zzc(long j, int i) {
        this.zzl = j;
    }

    public final void zzd(zzakr zzakr) {
        zzajg.zze(this.zze);
        while (zzakr.zzd() > 0) {
            int i = this.zzf;
            if (i == 0) {
                while (true) {
                    if (zzakr.zzd() <= 0) {
                        break;
                    } else if (!this.zzh) {
                        this.zzh = zzakr.zzn() == 11;
                    } else {
                        int zzn = zzakr.zzn();
                        if (zzn == 119) {
                            this.zzh = false;
                            this.zzf = 1;
                            this.zzb.zzi()[0] = 11;
                            this.zzb.zzi()[1] = 119;
                            this.zzg = 2;
                            break;
                        }
                        this.zzh = zzn == 11;
                    }
                }
            } else if (i != 1) {
                int min = Math.min(zzakr.zzd(), this.zzk - this.zzg);
                zztx.zzb(this.zze, zzakr, min);
                int i2 = this.zzg + min;
                this.zzg = i2;
                int i3 = this.zzk;
                if (i2 == i3) {
                    this.zze.zzd(this.zzl, 1, i3, 0, (zzty) null);
                    this.zzl += this.zzi;
                    this.zzf = 0;
                }
            } else {
                byte[] zzi2 = this.zzb.zzi();
                int min2 = Math.min(zzakr.zzd(), 128 - this.zzg);
                zzakr.zzm(zzi2, this.zzg, min2);
                int i4 = this.zzg + min2;
                this.zzg = i4;
                if (i4 == 128) {
                    this.zza.zzd(0);
                    zzpb zzc2 = zzpc.zzc(this.zza);
                    zzkc zzkc = this.zzj;
                    if (zzkc == null || zzc2.zzc != zzkc.zzy || zzc2.zzb != zzkc.zzz || !zzalh.zzc(zzc2.zza, zzkc.zzl)) {
                        zzkb zzkb = new zzkb();
                        zzkb.zza(this.zzd);
                        zzkb.zzj(zzc2.zza);
                        zzkb.zzw(zzc2.zzc);
                        zzkb.zzx(zzc2.zzb);
                        zzkb.zzd(this.zzc);
                        zzkc zzD = zzkb.zzD();
                        this.zzj = zzD;
                        this.zze.zza(zzD);
                    }
                    this.zzk = zzc2.zzd;
                    this.zzi = (((long) zzc2.zze) * 1000000) / ((long) this.zzj.zzz);
                    this.zzb.zzh(0);
                    zztx.zzb(this.zze, this.zzb, 128);
                    this.zzf = 2;
                }
            }
        }
    }

    public final void zze() {
    }

    public zzxs(@Nullable String str) {
        zzakq zzakq = new zzakq(new byte[128], 128);
        this.zza = zzakq;
        this.zzb = new zzakr(zzakq.zza);
        this.zzf = 0;
        this.zzc = str;
    }
}
