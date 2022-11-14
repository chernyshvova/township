package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayv {
    public final InputStream zza;
    public final boolean zzb;
    public final boolean zzc;
    public final long zzd;
    public final boolean zze;

    public zzayv(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.zza = inputStream;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = z3;
    }

    public static zzayv zza(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zzayv(inputStream, z, z2, j, z3);
    }

    public final InputStream zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
