package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlp {
    public static final zzlp zza = new zzlo().zze();
    public static final zzif<zzlp> zzb = zzln.zza;
    public final zzajr zzc;

    public /* synthetic */ zzlp(zzajr zzajr, zzlm zzlm) {
        this.zzc = zzajr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlp)) {
            return false;
        }
        return this.zzc.equals(((zzlp) obj).zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }
}
