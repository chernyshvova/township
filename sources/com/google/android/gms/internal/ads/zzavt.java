package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavt {
    public final Handler zza;
    public final zzavu zzb;

    public zzavt(Handler handler, zzavu zzavu) {
        if (handler != null) {
            this.zza = handler;
            this.zzb = zzavu;
            return;
        }
        throw null;
    }

    public final void zza(zzapc zzapc) {
        this.zza.post(new zzavm(this, zzapc));
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.post(new zzavn(this, str, j, j2));
    }

    public final void zzc(zzank zzank) {
        this.zza.post(new zzavo(this, zzank));
    }

    public final void zzd(int i, long j) {
        this.zza.post(new zzavp(this, i, j));
    }

    public final void zze(int i, int i2, int i3, float f) {
        this.zza.post(new zzavq(this, i, i2, i3, f));
    }

    public final void zzf(Surface surface) {
        this.zza.post(new zzavr(this, surface));
    }

    public final void zzg(zzapc zzapc) {
        this.zza.post(new zzavs(this, zzapc));
    }
}
