package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeso {
    public final zzcbk zza;
    public final int zzb;

    public zzeso(zzcbk zzcbk, int i) {
        this.zza = zzcbk;
        this.zzb = i;
    }

    public final String zza() {
        return this.zza.zzd;
    }

    public final String zzb() {
        return this.zza.zza.getString("ms");
    }

    @Nullable
    public final PackageInfo zzc() {
        return this.zza.zzf;
    }

    public final List<String> zzd() {
        return this.zza.zze;
    }

    public final String zze() {
        return this.zza.zzh;
    }

    public final int zzf() {
        return this.zzb;
    }
}
