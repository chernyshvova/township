package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxf implements zzta {
    public static final zztg zza = zzxe.zza;
    public zztd zzb;
    public zzxn zzc;
    public boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zza(zztb zztb) throws IOException {
        zzxh zzxh = new zzxh();
        if (zzxh.zzc(zztb, true) && (zzxh.zza & 2) == 2) {
            int min = Math.min(zzxh.zze, 8);
            zzakr zzakr = new zzakr(min);
            ((zzsx) zztb).zzh(zzakr.zzi(), 0, min, false);
            zzakr.zzh(0);
            if (zzakr.zzd() >= 5 && zzakr.zzn() == 127 && zzakr.zzt() == 1179402563) {
                this.zzc = new zzxd();
            } else {
                zzakr.zzh(0);
                try {
                    if (zzue.zzc(1, zzakr, true)) {
                        this.zzc = new zzxp();
                    }
                } catch (zzlg unused) {
                }
                zzakr.zzh(0);
                if (zzxj.zzd(zzakr)) {
                    this.zzc = new zzxj();
                }
            }
            return true;
        }
        return false;
    }

    public final boolean zzd(zztb zztb) throws IOException {
        try {
            return zza(zztb);
        } catch (zzlg unused) {
            return false;
        }
    }

    public final void zze(zztd zztd) {
        this.zzb = zztd;
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        zzajg.zze(this.zzb);
        if (this.zzc == null) {
            if (zza(zztb)) {
                zztb.zzl();
            } else {
                throw new zzlg("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzd) {
            zztz zza2 = this.zzb.zza(0, 1);
            this.zzb.zzbl();
            this.zzc.zze(this.zzb, zza2);
            this.zzd = true;
        }
        return this.zzc.zzg(zztb, zzts);
    }

    public final void zzg(long j, long j2) {
        zzxn zzxn = this.zzc;
        if (zzxn != null) {
            zzxn.zzf(j, j2);
        }
    }
}
