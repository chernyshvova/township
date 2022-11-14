package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyq implements zzyc {
    public final zzakr zza;
    public final zzrc zzb;
    @Nullable
    public final String zzc;
    public zztz zzd;
    public String zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public boolean zzi;
    public long zzj;
    public int zzk;
    public long zzl;

    public zzyq() {
        this((String) null);
    }

    public final void zza() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zze = zzzo.zzc();
        this.zzd = zztd.zza(zzzo.zzb(), 1);
    }

    public final void zzc(long j, int i) {
        this.zzl = j;
    }

    public final void zzd(zzakr zzakr) {
        zzajg.zze(this.zzd);
        while (zzakr.zzd() > 0) {
            int i = this.zzf;
            if (i == 0) {
                byte[] zzi2 = zzakr.zzi();
                int zzg2 = zzakr.zzg();
                int zze2 = zzakr.zze();
                while (true) {
                    if (zzg2 >= zze2) {
                        zzakr.zzh(zze2);
                        break;
                    }
                    byte b = zzi2[zzg2];
                    boolean z = (b & Base64.EQUALS_SIGN_ENC) == 255;
                    boolean z2 = this.zzi && (b & 224) == 224;
                    this.zzi = z;
                    if (z2) {
                        zzakr.zzh(zzg2 + 1);
                        this.zzi = false;
                        this.zza.zzi()[1] = zzi2[zzg2];
                        this.zzg = 2;
                        this.zzf = 1;
                        break;
                    }
                    zzg2++;
                }
            } else if (i != 1) {
                int min = Math.min(zzakr.zzd(), this.zzk - this.zzg);
                zztx.zzb(this.zzd, zzakr, min);
                int i2 = this.zzg + min;
                this.zzg = i2;
                int i3 = this.zzk;
                if (i2 >= i3) {
                    this.zzd.zzd(this.zzl, 1, i3, 0, (zzty) null);
                    this.zzl += this.zzj;
                    this.zzg = 0;
                    this.zzf = 0;
                }
            } else {
                int min2 = Math.min(zzakr.zzd(), 4 - this.zzg);
                zzakr.zzm(this.zza.zzi(), this.zzg, min2);
                int i4 = this.zzg + min2;
                this.zzg = i4;
                if (i4 >= 4) {
                    this.zza.zzh(0);
                    if (!this.zzb.zza(this.zza.zzv())) {
                        this.zzg = 0;
                        this.zzf = 1;
                    } else {
                        zzrc zzrc = this.zzb;
                        this.zzk = zzrc.zzc;
                        if (!this.zzh) {
                            this.zzj = (((long) zzrc.zzg) * 1000000) / ((long) zzrc.zzd);
                            zzkb zzkb = new zzkb();
                            zzkb.zza(this.zze);
                            zzkb.zzj(this.zzb.zzb);
                            zzkb.zzk(4096);
                            zzkb.zzw(this.zzb.zze);
                            zzkb.zzx(this.zzb.zzd);
                            zzkb.zzd(this.zzc);
                            this.zzd.zza(zzkb.zzD());
                            this.zzh = true;
                        }
                        this.zza.zzh(0);
                        zztx.zzb(this.zzd, this.zza, 4);
                        this.zzf = 2;
                    }
                }
            }
        }
    }

    public final void zze() {
    }

    public zzyq(@Nullable String str) {
        this.zzf = 0;
        zzakr zzakr = new zzakr(4);
        this.zza = zzakr;
        zzakr.zzi()[0] = -1;
        this.zzb = new zzrc();
        this.zzc = str;
    }
}
