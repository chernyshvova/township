package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvj {
    public final byte[] zza = new byte[10];
    public boolean zzb;
    public int zzc;
    public long zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final void zza() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzb(zztb zztb) throws IOException {
        if (!this.zzb) {
            ((zzsx) zztb).zzh(this.zza, 0, 10, false);
            zztb.zzl();
            byte[] bArr = this.zza;
            if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
                this.zzb = true;
            }
        }
    }

    @RequiresNonNull({"#1.output"})
    public final void zzc(zzvi zzvi, long j, int i, int i2, int i3) {
        if (this.zzb) {
            int i4 = this.zzc;
            int i5 = i4 + 1;
            this.zzc = i5;
            if (i4 == 0) {
                this.zzd = j;
                this.zze = i;
                this.zzf = 0;
            }
            this.zzf += i2;
            this.zzg = i3;
            if (i5 >= 16) {
                zzd(zzvi);
            }
        }
    }

    @RequiresNonNull({"#1.output"})
    public final void zzd(zzvi zzvi) {
        if (this.zzc > 0) {
            zzvi.zzV.zzd(this.zzd, this.zze, this.zzf, this.zzg, zzvi.zzi);
            this.zzc = 0;
        }
    }
}
