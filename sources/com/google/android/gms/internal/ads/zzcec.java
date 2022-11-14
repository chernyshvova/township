package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcec {
    public final Clock zza;
    public final zzg zzb;
    public final zzcfb zzc;

    public zzcec(Clock clock, zzg zzg, zzcfb zzcfb) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzcfb;
    }

    public final void zza(int i, long j) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzak)).booleanValue()) {
            if (j - this.zzb.zzE() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzal)).booleanValue()) {
                this.zzb.zzD(-1);
                this.zzb.zzF(j);
            } else {
                this.zzb.zzD(i);
                this.zzb.zzF(j);
            }
            zzb();
        }
    }

    public final void zzb() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzal)).booleanValue()) {
            this.zzc.zza();
        }
    }
}
