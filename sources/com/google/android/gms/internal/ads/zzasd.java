package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzasd implements Runnable {
    public final /* synthetic */ IOException zza;
    public final /* synthetic */ zzash zzb;

    public zzasd(zzash zzash, IOException iOException) {
        this.zzb = zzash;
        this.zza = iOException;
    }

    public final void run() {
        this.zzb.zze.zzi(this.zza);
    }
}
