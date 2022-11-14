package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzcs<T> implements zzcp<T> {
    public static final zzcs<Object> zza = new zzcs<>((Object) null);
    public final T zzb;

    public zzcs(T t) {
        this.zzb = t;
    }

    public static <T> zzcp<T> zza(T t) {
        return new zzcs(zzcu.zza(t, "instance cannot be null"));
    }

    public final T zza() {
        return this.zzb;
    }
}
