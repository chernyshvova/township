package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcyc implements zzo {
    public final zzdck zza;
    public final AtomicBoolean zzb = new AtomicBoolean(false);
    public final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzcyc(zzdck zzdck) {
        this.zza = zzdck;
    }

    private final void zzh() {
        if (!this.zzc.get()) {
            this.zzc.set(true);
            this.zza.zza();
        }
    }

    public final void zzbE() {
        this.zza.zzc();
    }

    public final void zzbH() {
        zzh();
    }

    public final void zzbI() {
    }

    public final void zzbJ() {
    }

    public final void zzbK(int i) {
        this.zzb.set(true);
        zzh();
    }

    public final void zzca() {
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
