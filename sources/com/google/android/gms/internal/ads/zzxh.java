package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxh {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    public final zzakr zzg = new zzakr(255);

    public static boolean zzd(zztb zztb, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zztb.zzh(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zztb zztb, long j) throws IOException {
        zzajg.zza(zztb.zzn() == zztb.zzm());
        this.zzg.zza(4);
        while (true) {
            if ((j == -1 || zztb.zzn() + 4 < j) && zzd(zztb, this.zzg.zzi(), 0, 4, true)) {
                this.zzg.zzh(0);
                if (this.zzg.zzt() != 1332176723) {
                    ((zzsx) zztb).zze(1, false);
                } else {
                    zztb.zzl();
                    return true;
                }
            }
        }
        do {
            if ((j != -1 && zztb.zzn() >= j) || zztb.zzd(1) == -1) {
                return false;
            }
            break;
        } while (zztb.zzd(1) == -1);
        return false;
    }

    public final boolean zzc(zztb zztb, boolean z) throws IOException {
        zza();
        this.zzg.zza(27);
        if (!zzd(zztb, this.zzg.zzi(), 0, 27, z) || this.zzg.zzt() != 1332176723) {
            return false;
        }
        if (this.zzg.zzn() == 0) {
            this.zza = this.zzg.zzn();
            this.zzb = this.zzg.zzy();
            this.zzg.zzu();
            this.zzg.zzu();
            this.zzg.zzu();
            int zzn = this.zzg.zzn();
            this.zzc = zzn;
            this.zzd = zzn + 27;
            this.zzg.zza(zzn);
            ((zzsx) zztb).zzh(this.zzg.zzi(), 0, this.zzc, false);
            for (int i = 0; i < this.zzc; i++) {
                this.zzf[i] = this.zzg.zzn();
                this.zze += this.zzf[i];
            }
            return true;
        } else if (z) {
            return false;
        } else {
            throw new zzlg("unsupported bit stream revision", (Throwable) null);
        }
    }
}
