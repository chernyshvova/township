package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzpi {
    public static final zzpi zza = new zzpi(0, 0, 1, 1, (zzph) null);
    public static final zzif<zzpi> zzc = zzpg.zza;
    public final int zzb = 1;
    @Nullable
    public AudioAttributes zzd;

    public /* synthetic */ zzpi(int i, int i2, int i3, int i4, zzph zzph) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzpi.class != obj.getClass()) {
            return false;
        }
        zzpi zzpi = (zzpi) obj;
        return true;
    }

    public final int hashCode() {
        return 15699889;
    }

    @RequiresApi(21)
    public final AudioAttributes zza() {
        if (this.zzd == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            if (zzalh.zza >= 29) {
                usage.setAllowedCapturePolicy(1);
            }
            this.zzd = usage.build();
        }
        return this.zzd;
    }
}
