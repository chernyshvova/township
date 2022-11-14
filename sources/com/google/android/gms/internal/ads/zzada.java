package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzada implements zzafj {
    public final zzafj zza;
    public final /* synthetic */ zzadb zzb;
    public boolean zzc;

    public zzada(zzadb zzadb, zzafj zzafj) {
        this.zzb = zzadb;
        this.zza = zzafj;
    }

    public final void zza() {
        this.zzc = false;
    }

    public final boolean zzb() {
        return !this.zzb.zzp() && this.zza.zzb();
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final int zzd(zzkd zzkd, zzrr zzrr, int i) {
        if (this.zzb.zzp()) {
            return -3;
        }
        if (this.zzc) {
            zzrr.zzf(4);
            return -4;
        }
        int zzd = this.zza.zzd(zzkd, zzrr, i);
        if (zzd == -5) {
            zzkc zzkc = zzkd.zza;
            if (zzkc != null) {
                int i2 = zzkc.zzB;
                int i3 = 0;
                if (i2 == 0) {
                    if (zzkc.zzC != 0) {
                        i2 = 0;
                    }
                    return -5;
                }
                if (this.zzb.zzb == Long.MIN_VALUE) {
                    i3 = zzkc.zzC;
                }
                zzkb zza2 = zzkc.zza();
                zza2.zzz(i2);
                zza2.zzA(i3);
                zzkd.zza = zza2.zzD();
                return -5;
            }
            throw null;
        }
        zzadb zzadb = this.zzb;
        long j = zzadb.zzb;
        if (j == Long.MIN_VALUE || ((zzd != -4 || zzrr.zzd < j) && (zzd != -3 || zzadb.zzh() != Long.MIN_VALUE || zzrr.zzc))) {
            return zzd;
        }
        zzrr.zza();
        zzrr.zzf(4);
        this.zzc = true;
        return -4;
    }

    public final int zze(long j) {
        if (this.zzb.zzp()) {
            return -3;
        }
        return this.zza.zze(j);
    }
}
