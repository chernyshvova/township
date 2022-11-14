package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxg {
    public final zzxh zza = new zzxh();
    public final zzakr zzb = new zzakr(new byte[65025], 0);
    public int zzc = -1;
    public int zzd;
    public boolean zze;

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzxh zzxh = this.zza;
            if (i5 >= zzxh.zzc) {
                break;
            }
            int[] iArr = zzxh.zzf;
            this.zzd = i4 + 1;
            i2 = iArr[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final void zza() {
        this.zza.zza();
        this.zzb.zza(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final boolean zzb(zztb zztb) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zza(0);
        }
        while (true) {
            boolean z = true;
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzb(zztb, -1) || !this.zza.zzc(zztb, true)) {
                    return false;
                }
                zzxh zzxh = this.zza;
                int i2 = zzxh.zzd;
                if ((zzxh.zza & 1) == 1 && this.zzb.zze() == 0) {
                    i2 += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                ((zzsx) zztb).zze(i2, false);
                this.zzc = i;
            }
            int zzf = zzf(i);
            int i3 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzakr zzakr = this.zzb;
                zzakr.zzc(zzakr.zze() + zzf);
                ((zzsx) zztb).zzb(this.zzb.zzi(), this.zzb.zze(), zzf, false);
                zzakr zzakr2 = this.zzb;
                zzakr2.zzf(zzakr2.zze() + zzf);
                if (this.zza.zzf[i3 - 1] == 255) {
                    z = false;
                }
                this.zze = z;
            }
            if (i3 == this.zza.zzc) {
                i3 = -1;
            }
            this.zzc = i3;
        }
        return false;
    }

    public final zzxh zzc() {
        return this.zza;
    }

    public final zzakr zzd() {
        return this.zzb;
    }

    public final void zze() {
        if (this.zzb.zzi().length != 65025) {
            zzakr zzakr = this.zzb;
            zzakr.zzb(Arrays.copyOf(zzakr.zzi(), Math.max(65025, this.zzb.zze())), this.zzb.zze());
        }
    }
}
