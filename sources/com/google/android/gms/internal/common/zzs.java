package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzs<E> extends zzn<E> {
    public final zzu<E> zza;

    public zzs(zzu<E> zzu, int i) {
        super(zzu.size(), i);
        this.zza = zzu;
    }

    public final E zza(int i) {
        return this.zza.get(i);
    }
}
