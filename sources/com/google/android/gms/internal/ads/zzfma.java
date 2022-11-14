package com.google.android.gms.internal.ads;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfma {
    public static final zzfma zza = new zzfly();
    public static final zzfma zzb = new zzflz(-1);
    public static final zzfma zzc = new zzflz(1);

    public /* synthetic */ zzfma(zzfly zzfly) {
    }

    public static zzfma zzg() {
        return zza;
    }

    public abstract <T> zzfma zza(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract zzfma zzb(int i, int i2);

    public abstract zzfma zzc(boolean z, boolean z2);

    public abstract zzfma zzd(boolean z, boolean z2);

    public abstract int zze();
}
