package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzc implements zzzp {
    public final zzzb zza;
    public final zzakr zzb = new zzakr(32);
    public int zzc;
    public int zzd;
    public boolean zze;
    public boolean zzf;

    public zzzc(zzzb zzzb) {
        this.zza = zzzb;
    }

    public final void zza(zzale zzale, zztd zztd, zzzo zzzo) {
        this.zza.zza(zzale, zztd, zzzo);
        this.zzf = true;
    }

    public final void zzb() {
        this.zzf = true;
    }

    public final void zzc(zzakr zzakr, int i) {
        int i2 = i & 1;
        int zzg = i2 != 0 ? zzakr.zzg() + zzakr.zzn() : -1;
        if (this.zzf) {
            if (i2 != 0) {
                this.zzf = false;
                zzakr.zzh(zzg);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzakr.zzd() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int zzn = zzakr.zzn();
                    zzakr.zzh(zzakr.zzg() - 1);
                    if (zzn == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int min = Math.min(zzakr.zzd(), 3 - this.zzd);
                zzakr.zzm(this.zzb.zzi(), this.zzd, min);
                int i4 = this.zzd + min;
                this.zzd = i4;
                if (i4 == 3) {
                    this.zzb.zzh(0);
                    this.zzb.zzf(3);
                    this.zzb.zzk(1);
                    int zzn2 = this.zzb.zzn();
                    int zzn3 = this.zzb.zzn();
                    this.zze = (zzn2 & 128) != 0;
                    this.zzc = (((zzn2 & 15) << 8) | zzn3) + 3;
                    int zzj = this.zzb.zzj();
                    int i5 = this.zzc;
                    if (zzj < i5) {
                        int zzj2 = this.zzb.zzj();
                        this.zzb.zzc(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, zzj2 + zzj2)));
                    }
                }
            } else {
                int min2 = Math.min(zzakr.zzd(), this.zzc - this.zzd);
                zzakr.zzm(this.zzb.zzi(), this.zzd, min2);
                int i6 = this.zzd + min2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzf(i7);
                    } else if (zzalh.zzR(this.zzb.zzi(), 0, this.zzc, -1) != 0) {
                        this.zzf = true;
                        return;
                    } else {
                        this.zzb.zzf(this.zzc - 4);
                    }
                    this.zzb.zzh(0);
                    this.zza.zzb(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }
}
