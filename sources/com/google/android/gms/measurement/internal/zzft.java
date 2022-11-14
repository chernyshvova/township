package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzft implements Thread.UncaughtExceptionHandler {
    public final String zza;
    public final /* synthetic */ zzfr zzb;

    public zzft(zzfr zzfr, String str) {
        this.zzb = zzfr;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzq().zze().zza(this.zza, th);
    }
}
