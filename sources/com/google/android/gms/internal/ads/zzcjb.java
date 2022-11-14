package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcjb implements Runnable {
    public final zzcin zza;
    public boolean zzb = false;

    public zzcjb(zzcin zzcin) {
        this.zza = zzcin;
    }

    private final void zzc() {
        zzr.zza.removeCallbacks(this);
        zzr.zza.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.zzb) {
            this.zza.zzE();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzE();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
