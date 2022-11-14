package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzxn {
    public final zzxg zza = new zzxg();
    public zztz zzb;
    public zztd zzc;
    public zzxi zzd;
    public long zze;
    public long zzf;
    public long zzg;
    public int zzh;
    public int zzi;
    public zzxl zzj = new zzxl();
    public long zzk;
    public boolean zzl;
    public boolean zzm;

    public void zza(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzxl();
            this.zzf = 0;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1;
        this.zzg = 0;
    }

    public abstract long zzb(zzakr zzakr);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzakr zzakr, long j, zzxl zzxl) throws IOException;

    public final void zze(zztd zztd, zztz zztz) {
        this.zzc = zztd;
        this.zzb = zztz;
        zza(true);
    }

    public final void zzf(long j, long j2) {
        this.zza.zza();
        if (j == 0) {
            zza(!this.zzl);
        } else if (this.zzh != 0) {
            long zzi2 = zzi(j2);
            this.zze = zzi2;
            zzxi zzxi = this.zzd;
            int i = zzalh.zza;
            zzxi.zzb(zzi2);
            this.zzh = 2;
        }
    }

    public final int zzg(zztb zztb, zzts zzts) throws IOException {
        zztb zztb2 = zztb;
        zzajg.zze(this.zzb);
        int i = zzalh.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zzb(zztb2)) {
                this.zzk = zztb.zzn() - this.zzf;
                if (zzc(this.zza.zzd(), this.zzf, this.zzj)) {
                    this.zzf = zztb.zzn();
                } else {
                    zzkc zzkc = this.zzj.zza;
                    this.zzi = zzkc.zzz;
                    if (!this.zzm) {
                        this.zzb.zza(zzkc);
                        this.zzm = true;
                    }
                    zzxi zzxi = this.zzj.zzb;
                    if (zzxi != null) {
                        this.zzd = zzxi;
                    } else if (zztb.zzo() == -1) {
                        this.zzd = new zzxm((zzxk) null);
                    } else {
                        zzxh zzc2 = this.zza.zzc();
                        this.zzd = new zzxb(this, this.zzf, zztb.zzo(), (long) (zzc2.zzd + zzc2.zze), zzc2.zzb, (zzc2.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zze();
                    return 0;
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i2 == 1) {
            ((zzsx) zztb2).zze((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        } else if (i2 != 2) {
            return -1;
        } else {
            long zza2 = this.zzd.zza(zztb2);
            if (zza2 >= 0) {
                zzts.zza = zza2;
                return 1;
            }
            if (zza2 < -1) {
                zzj(-(zza2 + 2));
            }
            if (!this.zzl) {
                zztv zzc3 = this.zzd.zzc();
                zzajg.zze(zzc3);
                this.zzc.zzbm(zzc3);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zzb(zztb2)) {
                this.zzk = 0;
                zzakr zzd2 = this.zza.zzd();
                long zzb2 = zzb(zzd2);
                if (zzb2 >= 0) {
                    long j = this.zzg;
                    if (j + zzb2 >= this.zze) {
                        long zzh2 = zzh(j);
                        zztx.zzb(this.zzb, zzd2, zzd2.zze());
                        this.zzb.zzd(zzh2, 1, zzd2.zze(), 0, (zzty) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zzb2;
                return 0;
            }
            this.zzh = 3;
            return -1;
        }
    }

    public final long zzh(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    public final long zzi(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    public void zzj(long j) {
        this.zzg = j;
    }
}
