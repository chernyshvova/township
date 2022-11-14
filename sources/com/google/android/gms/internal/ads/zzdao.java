package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdao {
    public Context zza;
    public zzeyw zzb;
    public Bundle zzc;
    @Nullable
    public zzeyr zzd;

    public final zzdao zza(Context context) {
        this.zza = context;
        return this;
    }

    public final zzdao zzb(zzeyw zzeyw) {
        this.zzb = zzeyw;
        return this;
    }

    public final zzdao zzc(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzdap zzd() {
        return new zzdap(this, (zzdan) null);
    }

    public final zzdao zze(zzeyr zzeyr) {
        this.zzd = zzeyr;
        return this;
    }
}
