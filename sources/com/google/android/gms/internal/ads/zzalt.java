package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalt extends zzaag {
    public zzalt(Throwable th, @Nullable zzaah zzaah, @Nullable Surface surface) {
        super(th, zzaah);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
    }
}
