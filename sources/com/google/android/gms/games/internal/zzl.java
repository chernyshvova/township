package com.google.android.gms.games.internal;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzl {
    public static final zzl zza = new zzl(new zzj((zzi) null));
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public zzl(zzj zzj) {
        this.zzb = zzj.zza;
        this.zzc = zzj.zzb;
        this.zzd = zzj.zzc;
    }

    public static zzj zza() {
        return new zzj((zzi) null);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzl.class == obj.getClass()) {
            zzl zzl = (zzl) obj;
            return this.zzb == zzl.zzb && this.zzc == zzl.zzc && this.zzd == zzl.zzd;
        }
    }

    public final int hashCode() {
        return ((((this.zzb ? 1 : 0) * true) + (this.zzc ? 1 : 0)) * 31) + (this.zzd ? 1 : 0);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
