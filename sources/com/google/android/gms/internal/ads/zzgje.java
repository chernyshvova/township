package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgje<T> implements zzgjg<T> {
    public zzgju<T> zza;

    public static <T> void zza(zzgju<T> zzgju, zzgju<T> zzgju2) {
        zzgje zzgje = (zzgje) zzgju;
        if (zzgje.zza == null) {
            zzgje.zza = zzgju2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T zzb() {
        zzgju<T> zzgju = this.zza;
        if (zzgju != null) {
            return zzgju.zzb();
        }
        throw new IllegalStateException();
    }
}
