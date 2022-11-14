package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfa<E> extends zzej<E> {
    public final zzfb<E> zza;

    public zzfa(zzfb<E> zzfb, int i) {
        super(zzfb.size(), i);
        this.zza = zzfb;
    }

    public final E zza(int i) {
        return this.zza.get(i);
    }
}
