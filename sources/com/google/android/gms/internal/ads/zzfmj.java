package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfmj<E> extends zzfkp<E> {
    public final zzfml<E> zza;

    public zzfmj(zzfml<E> zzfml, int i) {
        super(zzfml.size(), i);
        this.zza = zzfml;
    }

    public final E zza(int i) {
        return this.zza.get(i);
    }
}
