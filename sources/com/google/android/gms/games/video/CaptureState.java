package com.google.android.gms.games.video;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class CaptureState {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final boolean zze;

    public CaptureState(boolean z, int i, int i2, boolean z2, boolean z3) {
        Preconditions.checkArgument(VideoConfiguration.isValidCaptureMode(i, true));
        Preconditions.checkArgument(VideoConfiguration.isValidQualityLevel(i2, true));
        this.zza = z;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = z3;
    }

    @RecentlyNonNull
    public static CaptureState zza(@RecentlyNonNull Bundle bundle) {
        if (bundle == null || bundle.get("IsCapturing") == null) {
            return null;
        }
        return new CaptureState(bundle.getBoolean("IsCapturing", false), bundle.getInt("CaptureMode", -1), bundle.getInt("CaptureQuality", -1), bundle.getBoolean("IsOverlayVisible", false), bundle.getBoolean("IsPaused", false));
    }

    public int getCaptureMode() {
        return this.zzb;
    }

    public int getCaptureQuality() {
        return this.zzc;
    }

    public boolean isCapturing() {
        return this.zza;
    }

    public boolean isOverlayVisible() {
        return this.zzd;
    }

    public boolean isPaused() {
        return this.zze;
    }

    @RecentlyNonNull
    public String toString() {
        return Objects.toStringHelper(this).add("IsCapturing", Boolean.valueOf(this.zza)).add("CaptureMode", Integer.valueOf(this.zzb)).add("CaptureQuality", Integer.valueOf(this.zzc)).add("IsOverlayVisible", Boolean.valueOf(this.zzd)).add("IsPaused", Boolean.valueOf(this.zze)).toString();
    }
}
