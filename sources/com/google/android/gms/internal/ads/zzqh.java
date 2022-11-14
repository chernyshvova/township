package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqh {
    @Nullable
    public final zzqg zza;
    public int zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public long zzf;

    public zzqh(AudioTrack audioTrack) {
        if (zzalh.zza >= 19) {
            this.zza = new zzqg(audioTrack);
            zze();
            return;
        }
        this.zza = null;
        zzh(3);
    }

    private final void zzh(int i) {
        this.zzb = i;
        if (i == 0) {
            this.zze = 0;
            this.zzf = -1;
            this.zzc = System.nanoTime() / 1000;
            this.zzd = 10000;
        } else if (i == 1) {
            this.zzd = 10000;
        } else if (i == 2 || i == 3) {
            this.zzd = 10000000;
        } else {
            this.zzd = 500000;
        }
    }

    @TargetApi(19)
    public final boolean zza(long j) {
        zzqg zzqg = this.zza;
        if (zzqg != null && j - this.zze >= this.zzd) {
            this.zze = j;
            boolean zza2 = zzqg.zza();
            int i = this.zzb;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && zza2) {
                            zze();
                            return true;
                        }
                    } else if (!zza2) {
                        zze();
                        return false;
                    }
                } else if (!zza2) {
                    zze();
                } else if (this.zza.zzc() > this.zzf) {
                    zzh(2);
                    return true;
                }
            } else if (zza2) {
                if (this.zza.zzb() < this.zzc) {
                    return false;
                }
                this.zzf = this.zza.zzc();
                zzh(1);
                return true;
            } else if (j - this.zzc > 500000) {
                zzh(3);
            }
            return zza2;
        }
        return false;
    }

    public final void zzb() {
        zzh(4);
    }

    public final void zzc() {
        if (this.zzb == 4) {
            zze();
        }
    }

    public final boolean zzd() {
        return this.zzb == 2;
    }

    public final void zze() {
        if (this.zza != null) {
            zzh(0);
        }
    }

    @TargetApi(19)
    public final long zzf() {
        zzqg zzqg = this.zza;
        if (zzqg != null) {
            return zzqg.zzb();
        }
        return -9223372036854775807L;
    }

    @TargetApi(19)
    public final long zzg() {
        zzqg zzqg = this.zza;
        if (zzqg != null) {
            return zzqg.zzc();
        }
        return -1;
    }
}
