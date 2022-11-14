package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoc extends zzfml<Object> {
    public final transient Object[] zza;
    public final transient int zzb;
    public final transient int zzc;

    public zzfoc(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzfke.zze(i, this.zzc, "index");
        return this.zza[i + i + this.zzb];
    }

    public final int size() {
        return this.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
