package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdtr implements zzddy, zzdcr, zzdbg, zzdbx, zzbcz, zzdgc {
    public final zzayx zza;
    @GuardedBy("this")
    public boolean zzb = false;

    public zzdtr(zzayx zzayx, @Nullable zzewb zzewb) {
        this.zza = zzayx;
        zzayx.zzb(zzayz.AD_REQUEST);
        if (zzewb != null) {
            zzayx.zzb(zzayz.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzb(zzayz.AD_FIRST_CLICK);
            this.zzb = true;
            return;
        }
        this.zza.zzb(zzayz.AD_SUBSEQUENT_CLICK);
    }

    public final synchronized void zzbF() {
        this.zza.zzb(zzayz.AD_IMPRESSION);
    }

    public final void zzbT(zzbdd zzbdd) {
        switch (zzbdd.zza) {
            case 1:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zza.zzb(zzayz.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final void zzbU() {
        this.zza.zzb(zzayz.AD_LOADED);
    }

    public final void zzj(zzcbk zzcbk) {
    }

    public final void zzk(zzazu zzazu) {
        this.zza.zzc(new zzdto(zzazu));
        this.zza.zzb(zzayz.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzl(zzazu zzazu) {
        this.zza.zzc(new zzdtp(zzazu));
        this.zza.zzb(zzayz.REQUEST_SAVED_TO_CACHE);
    }

    public final void zzm(zzazu zzazu) {
        this.zza.zzc(new zzdtq(zzazu));
        this.zza.zzb(zzayz.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzn(boolean z) {
        zzayz zzayz;
        zzayx zzayx = this.zza;
        if (z) {
            zzayz = zzayz.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzayz = zzayz.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zzayx.zzb(zzayz);
    }

    public final void zzo(boolean z) {
        zzayz zzayz;
        zzayx zzayx = this.zza;
        if (z) {
            zzayz = zzayz.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzayz = zzayz.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zzayx.zzb(zzayz);
    }

    public final void zzp() {
        this.zza.zzb(zzayz.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzq(zzeyq zzeyq) {
        this.zza.zzc(new zzdtn(zzeyq));
    }
}
