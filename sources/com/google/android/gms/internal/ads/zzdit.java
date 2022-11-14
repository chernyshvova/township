package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdit extends zzdgf<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")
    public boolean zzb;

    public zzdit(Set<zzdhz<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void zza() {
        zzr(zzdio.zza);
    }

    public final void zzb() {
        zzr(zzdip.zza);
    }

    public final synchronized void zzc() {
        zzr(zzdiq.zza);
        this.zzb = true;
    }

    public final synchronized void zzd() {
        if (!this.zzb) {
            zzr(zzdir.zza);
            this.zzb = true;
        }
        zzr(zzdis.zza);
    }
}
