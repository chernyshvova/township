package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class zzie implements Runnable {
    public final zzif zza;
    public final int zzb;
    public final Exception zzc;
    public final byte[] zzd;
    public final Map zze;

    public zzie(zzif zzif, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzif;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
