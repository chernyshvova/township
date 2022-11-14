package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajy<T> {
    @Nonnull
    public final T zza;
    public zzajq zzb = new zzajq();
    public boolean zzc;
    public boolean zzd;

    public zzajy(@Nonnull T t) {
        this.zza = t;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzajy.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzajy) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzajx<T> zzajx) {
        this.zzd = true;
        if (this.zzc) {
            zzajx.zza(this.zza, this.zzb.zzb());
        }
    }

    public final void zzb(int i, zzajw<T> zzajw) {
        if (!this.zzd) {
            if (i != -1) {
                this.zzb.zza(i);
            }
            this.zzc = true;
            zzajw.zza(this.zza);
        }
    }

    public final void zzc(zzajx<T> zzajx) {
        if (!this.zzd && this.zzc) {
            zzajr zzb2 = this.zzb.zzb();
            this.zzb = new zzajq();
            this.zzc = false;
            zzajx.zza(this.zza, zzb2);
        }
    }
}
