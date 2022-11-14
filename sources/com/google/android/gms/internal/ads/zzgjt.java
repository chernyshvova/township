package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjt<T> implements zzgju<T> {
    public static final Object zza = new Object();
    public volatile zzgju<T> zzb;
    public volatile Object zzc = zza;

    public zzgjt(zzgju<T> zzgju) {
        this.zzb = zzgju;
    }

    public static <P extends zzgju<T>, T> zzgju<T> zza(P p) {
        if ((p instanceof zzgjt) || (p instanceof zzgjf)) {
            return p;
        }
        if (p != null) {
            return new zzgjt(p);
        }
        throw null;
    }

    public final T zzb() {
        T t = this.zzc;
        if (t != zza) {
            return t;
        }
        zzgju<T> zzgju = this.zzb;
        if (zzgju == null) {
            return this.zzc;
        }
        T zzb2 = zzgju.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
