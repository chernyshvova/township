package com.google.android.gms.common.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class RootTelemetryConfigManager {
    @Nullable
    public static RootTelemetryConfigManager zza;
    public static final RootTelemetryConfiguration zzb = new RootTelemetryConfiguration(0, false, false, 0, 0);
    @Nullable
    public RootTelemetryConfiguration zzc;

    @RecentlyNonNull
    @KeepForSdk
    public static synchronized RootTelemetryConfigManager getInstance() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            if (zza == null) {
                zza = new RootTelemetryConfigManager();
            }
            rootTelemetryConfigManager = zza;
        }
        return rootTelemetryConfigManager;
    }

    @KeepForSdk
    @RecentlyNullable
    public RootTelemetryConfiguration getConfig() {
        return this.zzc;
    }

    @VisibleForTesting
    public final synchronized void zza(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.zzc = zzb;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.zzc;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
            this.zzc = rootTelemetryConfiguration;
        }
    }
}
