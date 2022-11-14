package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckp extends zzb {
    public final zzciz zza;
    public final zzckx zzb;
    public final String zzc;
    public final String[] zzd;

    public zzckp(zzciz zzciz, zzckx zzckx, String str, String[] strArr) {
        this.zza = zzciz;
        this.zzb = zzckx;
        this.zzc = str;
        this.zzd = strArr;
        zzs.zzy().zza(this);
    }

    public final void zza() {
        try {
            this.zzb.zzb(this.zzc, this.zzd);
        } finally {
            zzr.zza.post(new zzcko(this));
        }
    }
}
