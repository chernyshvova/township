package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzba {
    public final int zza;
    public final List<zzu> zzb;
    public final int zzc;
    @Nullable
    public final InputStream zzd;

    public zzba(int i, List<zzu> list, int i2, InputStream inputStream) {
        this.zza = i;
        this.zzb = list;
        this.zzc = i2;
        this.zzd = inputStream;
    }

    public final int zza() {
        return this.zza;
    }

    public final List<zzu> zzb() {
        return Collections.unmodifiableList(this.zzb);
    }

    public final int zzc() {
        return this.zzc;
    }

    @Nullable
    public final InputStream zzd() {
        InputStream inputStream = this.zzd;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }
}
