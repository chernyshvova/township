package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final /* synthetic */ class zzd implements Callable {
    public final boolean zza;
    public final String zzb;
    public final zzi zzc;

    public zzd(boolean z, String str, zzi zzi) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzi;
    }

    public final Object call() {
        return zzm.zze(this.zza, this.zzb, this.zzc);
    }
}
