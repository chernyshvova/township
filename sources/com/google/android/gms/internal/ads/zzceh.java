package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzceh {
    public Context zza;
    public Clock zzb;
    public zzg zzc;
    public zzcfb zzd;

    public zzceh() {
    }

    public /* synthetic */ zzceh(zzceg zzceg) {
    }

    public final zzceh zza(Context context) {
        if (context != null) {
            this.zza = context;
            return this;
        }
        throw null;
    }

    public final zzceh zzb(Clock clock) {
        if (clock != null) {
            this.zzb = clock;
            return this;
        }
        throw null;
    }

    public final zzceh zzc(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzceh zzd(zzcfb zzcfb) {
        this.zzd = zzcfb;
        return this;
    }

    public final zzcfc zze() {
        zzgjp.zzc(this.zza, Context.class);
        zzgjp.zzc(this.zzb, Clock.class);
        zzgjp.zzc(this.zzc, zzg.class);
        zzgjp.zzc(this.zzd, zzcfb.class);
        return new zzcei(this.zza, this.zzb, this.zzc, this.zzd, (zzceg) null);
    }
}
