package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzecd implements zzdcr, zzdbg {
    public static final Object zza = new Object();
    public static int zzb;
    public final zzg zzc;
    public final zzecm zzd;

    public zzecd(zzecm zzecm, zzg zzg) {
        this.zzd = zzecm;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue() && !this.zzc.zzC()) {
            synchronized (zza) {
                i = zzb;
                intValue = ((Integer) zzbex.zzc().zzb(zzbjn.zzex)).intValue();
            }
            if (i < intValue) {
                this.zzd.zza(z);
                synchronized (zza) {
                    zzb++;
                }
            }
        }
    }

    public final void zzbT(zzbdd zzbdd) {
        zzb(false);
    }

    public final void zzbU() {
        zzb(true);
    }
}
