package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzauz implements ThreadFactory {
    public final /* synthetic */ String zza = "Loader:ExtractorMediaPeriod";

    public zzauz(String str) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
