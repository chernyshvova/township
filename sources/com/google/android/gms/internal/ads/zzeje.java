package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeje implements zzf {
    @GuardedBy("this")
    public zzf zza;

    public final synchronized void zza(View view) {
        zzf zzf = this.zza;
        if (zzf != null) {
            zzf.zza(view);
        }
    }

    public final synchronized void zzb() {
        zzf zzf = this.zza;
        if (zzf != null) {
            zzf.zzb();
        }
    }

    public final synchronized void zzc() {
        zzf zzf = this.zza;
        if (zzf != null) {
            zzf.zzc();
        }
    }

    public final synchronized void zzd(zzf zzf) {
        this.zza = zzf;
    }
}
