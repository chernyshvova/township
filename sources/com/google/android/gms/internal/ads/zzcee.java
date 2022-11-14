package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcee {
    public final Clock zza;
    public final zzcec zzb;

    public zzcee(Clock clock, zzcec zzcec) {
        this.zza = clock;
        this.zzb = zzcec;
    }

    public static zzcee zza(Context context) {
        return zzcfc.zzd(context).zzb();
    }

    public final void zzb() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzc(zzbip zzbip) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zze() {
        this.zzb.zzb();
    }
}
