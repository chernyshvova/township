package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

@WorkerThread
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzey implements Runnable {
    public final zzez zza;
    public final int zzb;
    public final Throwable zzc;
    public final byte[] zzd;
    public final String zze;
    public final Map<String, List<String>> zzf;

    public zzey(String str, zzez zzez, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(zzez);
        this.zza = zzez;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
