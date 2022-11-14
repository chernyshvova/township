package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzadu {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzadu(zzadu zzadu) {
        this.zza = zzadu.zza;
        this.zzb = zzadu.zzb;
        this.zzc = -1;
        this.zzd = zzadu.zzd;
        this.zze = zzadu.zze;
    }

    public zzadu(Object obj, int i, int i2, long j) {
        this(obj, i, -1, j, -1);
    }

    public zzadu(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = -1;
        this.zzd = j;
        this.zze = i3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzadu)) {
            return false;
        }
        zzadu zzadu = (zzadu) obj;
        return this.zza.equals(zzadu.zza) && this.zzb == zzadu.zzb && this.zzd == zzadu.zzd && this.zze == zzadu.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) - 1) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzadu zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzadu(obj, this.zzb, -1, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzadu(Object obj, long j) {
        this(obj, -1, -1, -1, -1);
    }

    public zzadu(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
