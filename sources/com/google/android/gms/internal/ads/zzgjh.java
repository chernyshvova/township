package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjh<T> implements zzgjg, zzgja {
    public static final zzgjh<Object> zza = new zzgjh<>((Object) null);
    public final T zzb;

    public zzgjh(T t) {
        this.zzb = t;
    }

    public static <T> zzgjg<T> zza(T t) {
        zzgjp.zza(t, "instance cannot be null");
        return new zzgjh(t);
    }

    public static <T> zzgjg<T> zzc(T t) {
        return t == null ? zza : new zzgjh(t);
    }

    public final T zzb() {
        return this.zzb;
    }
}
