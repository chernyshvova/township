package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfez {
    public final zzfgg zza;
    public final String zzb;
    public final zzfen zzc;
    public final String zzd;

    public zzfez(View view, zzfen zzfen, @Nullable String str) {
        this.zza = new zzfgg(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfen;
        this.zzd = str;
    }

    public final zzfgg zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzfen zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
