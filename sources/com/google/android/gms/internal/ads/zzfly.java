package com.google.android.gms.internal.ads;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfly extends zzfma {
    public zzfly() {
        super((zzfly) null);
    }

    public static final zzfma zzf(int i) {
        return i < 0 ? zzfma.zzb : i > 0 ? zzfma.zzc : zzfma.zza;
    }

    public final <T> zzfma zza(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
        return zzf(comparator.compare(t, t2));
    }

    public final zzfma zzb(int i, int i2) {
        return zzf(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    public final zzfma zzc(boolean z, boolean z2) {
        return zzf(zzfor.zza(z2, z));
    }

    public final zzfma zzd(boolean z, boolean z2) {
        return zzf(zzfor.zza(z, z2));
    }

    public final int zze() {
        return 0;
    }
}
