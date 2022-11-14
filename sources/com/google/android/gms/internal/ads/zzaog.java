package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaog {
    public final Handler zza;
    public final zzaoh zzb;

    public zzaog(Handler handler, zzaoh zzaoh) {
        if (handler != null) {
            this.zza = handler;
            this.zzb = zzaoh;
            return;
        }
        throw null;
    }

    public final void zza(zzapc zzapc) {
        this.zza.post(new zzaoa(this, zzapc));
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.post(new zzaob(this, str, j, j2));
    }

    public final void zzc(zzank zzank) {
        this.zza.post(new zzaoc(this, zzank));
    }

    public final void zzd(int i, long j, long j2) {
        this.zza.post(new zzaod(this, i, j, j2));
    }

    public final void zze(zzapc zzapc) {
        this.zza.post(new zzaoe(this, zzapc));
    }

    public final void zzf(int i) {
        this.zza.post(new zzaof(this, i));
    }
}
