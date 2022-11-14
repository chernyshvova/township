package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class zzit {
    public static final zzit zza = new zziv();
    public static final zzit zzb = new zziu();

    public zzit() {
    }

    public static zzit zza() {
        return zza;
    }

    public static zzit zzb() {
        return zzb;
    }

    public abstract <L> List<L> zza(Object obj, long j);

    public abstract <L> void zza(Object obj, Object obj2, long j);

    public abstract void zzb(Object obj, long j);
}
