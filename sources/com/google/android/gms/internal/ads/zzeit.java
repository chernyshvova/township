package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeit implements zzf {
    public final AtomicBoolean zza = new AtomicBoolean(false);
    public final zzdbb zzb;
    public final zzdbv zzc;
    public final zzdie zzd;
    public final zzdib zze;
    public final zzcts zzf;

    public zzeit(zzdbb zzdbb, zzdbv zzdbv, zzdie zzdie, zzdib zzdib, zzcts zzcts) {
        this.zzb = zzdbb;
        this.zzc = zzdbv;
        this.zzd = zzdie;
        this.zze = zzdib;
        this.zzf = zzcts;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzbF();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
