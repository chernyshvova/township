package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeci implements zzfcy {
    public final zzecf zza;

    public zzeci(zzecf zzecf) {
        this.zza = zzecf;
    }

    public final void zzbV(zzfcr zzfcr, String str) {
    }

    public final void zzbW(zzfcr zzfcr, String str) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue() && zzfcr.RENDERER == zzfcr) {
            this.zza.zze(zzs.zzj().elapsedRealtime());
        }
    }

    public final void zzbX(zzfcr zzfcr, String str, Throwable th) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue() && zzfcr.RENDERER == zzfcr && this.zza.zzf() != 0) {
            this.zza.zzg(zzs.zzj().elapsedRealtime() - this.zza.zzf());
        }
    }

    public final void zzbY(zzfcr zzfcr, String str) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue() && zzfcr.RENDERER == zzfcr && this.zza.zzf() != 0) {
            this.zza.zzg(zzs.zzj().elapsedRealtime() - this.zza.zzf());
        }
    }
}
