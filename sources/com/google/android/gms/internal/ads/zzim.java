package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzim implements zzakc {
    public final zzaky zza;
    public final zzil zzb;
    @Nullable
    public zzma zzc;
    @Nullable
    public zzakc zzd;
    public boolean zze = true;
    public boolean zzf;

    public zzim(zzil zzil, zzajh zzajh) {
        this.zzb = zzil;
        this.zza = new zzaky(zzajh);
    }

    public final void zza() {
        this.zzf = true;
        this.zza.zza();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zzb();
    }

    public final void zzc(long j) {
        this.zza.zzc(j);
    }

    public final void zzd(zzma zzma) throws zzio {
        zzakc zzakc;
        zzakc zzd2 = zzma.zzd();
        if (zzd2 != null && zzd2 != (zzakc = this.zzd)) {
            if (zzakc == null) {
                this.zzd = zzd2;
                this.zzc = zzma;
                zzd2.zzh(this.zza.zzi());
                return;
            }
            throw zzio.zzd(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public final void zze(zzma zzma) {
        if (zzma == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final long zzf(boolean z) {
        zzma zzma = this.zzc;
        if (zzma == null || zzma.zzM() || (!this.zzc.zzL() && (z || this.zzc.zzj()))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zza();
            }
        } else {
            zzakc zzakc = this.zzd;
            if (zzakc != null) {
                long zzg = zzakc.zzg();
                if (this.zze) {
                    if (zzg < this.zza.zzg()) {
                        this.zza.zzb();
                    } else {
                        this.zze = false;
                        if (this.zzf) {
                            this.zza.zza();
                        }
                    }
                }
                this.zza.zzc(zzg);
                zzll zzi = zzakc.zzi();
                if (!zzi.equals(this.zza.zzi())) {
                    this.zza.zzh(zzi);
                    this.zzb.zza(zzi);
                }
            } else {
                throw null;
            }
        }
        if (this.zze) {
            return this.zza.zzg();
        }
        zzakc zzakc2 = this.zzd;
        if (zzakc2 != null) {
            return zzakc2.zzg();
        }
        throw null;
    }

    public final long zzg() {
        throw null;
    }

    public final void zzh(zzll zzll) {
        zzakc zzakc = this.zzd;
        if (zzakc != null) {
            zzakc.zzh(zzll);
            zzll = this.zzd.zzi();
        }
        this.zza.zzh(zzll);
    }

    public final zzll zzi() {
        zzakc zzakc = this.zzd;
        return zzakc != null ? zzakc.zzi() : this.zza.zzi();
    }
}
