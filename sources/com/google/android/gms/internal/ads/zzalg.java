package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzalg implements ThreadFactory {
    public final String zza = "ExoPlayer:Loader:ProgressiveMediaPeriod";

    public zzalg(String str) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
