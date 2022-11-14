package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxv implements zzyc {
    public final zzakq zza;
    public final zzakr zzb;
    @Nullable
    public final String zzc;
    public String zzd;
    public zztz zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public boolean zzi;
    public long zzj;
    public zzkc zzk;
    public int zzl;
    public long zzm;

    public zzxv() {
        this((String) null);
    }

    public final void zza() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzd = zzzo.zzc();
        this.zze = zztd.zza(zzzo.zzb(), 1);
    }

    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    public final void zzd(zzakr zzakr) {
        byte b;
        boolean z;
        zzajg.zze(this.zze);
        while (zzakr.zzd() > 0) {
            int i = this.zzf;
            if (i == 0) {
                while (true) {
                    if (zzakr.zzd() <= 0) {
                        break;
                    } else if (!this.zzh) {
                        this.zzh = zzakr.zzn() == 172;
                    } else {
                        int zzn = zzakr.zzn();
                        this.zzh = zzn == 172;
                        b = 64;
                        if (zzn != 64) {
                            if (zzn == 65) {
                                break;
                            }
                        } else if (zzn != 65) {
                            z = false;
                        }
                    }
                }
                z = true;
                this.zzi = z;
                this.zzf = 1;
                this.zzb.zzi()[0] = -84;
                byte[] zzi2 = this.zzb.zzi();
                if (true == this.zzi) {
                    b = 65;
                }
                zzi2[1] = b;
                this.zzg = 2;
            } else if (i != 1) {
                int min = Math.min(zzakr.zzd(), this.zzl - this.zzg);
                zztx.zzb(this.zze, zzakr, min);
                int i2 = this.zzg + min;
                this.zzg = i2;
                int i3 = this.zzl;
                if (i2 == i3) {
                    this.zze.zzd(this.zzm, 1, i3, 0, (zzty) null);
                    this.zzm += this.zzj;
                    this.zzf = 0;
                }
            } else {
                byte[] zzi3 = this.zzb.zzi();
                int min2 = Math.min(zzakr.zzd(), 16 - this.zzg);
                zzakr.zzm(zzi3, this.zzg, min2);
                int i4 = this.zzg + min2;
                this.zzg = i4;
                if (i4 == 16) {
                    this.zza.zzd(0);
                    zzpe zza2 = zzpf.zza(this.zza);
                    zzkc zzkc = this.zzk;
                    if (zzkc == null || zzkc.zzy != 2 || zza2.zza != zzkc.zzz || !"audio/ac4".equals(zzkc.zzl)) {
                        zzkb zzkb = new zzkb();
                        zzkb.zza(this.zzd);
                        zzkb.zzj("audio/ac4");
                        zzkb.zzw(2);
                        zzkb.zzx(zza2.zza);
                        zzkb.zzd(this.zzc);
                        zzkc zzD = zzkb.zzD();
                        this.zzk = zzD;
                        this.zze.zza(zzD);
                    }
                    this.zzl = zza2.zzb;
                    this.zzj = (((long) zza2.zzc) * 1000000) / ((long) this.zzk.zzz);
                    this.zzb.zzh(0);
                    zztx.zzb(this.zze, this.zzb, 16);
                    this.zzf = 2;
                }
            }
        }
    }

    public final void zze() {
    }

    public zzxv(@Nullable String str) {
        zzakq zzakq = new zzakq(new byte[16], 16);
        this.zza = zzakq;
        this.zzb = new zzakr(zzakq.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzc = str;
    }
}
