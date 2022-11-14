package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhz implements MediaContent {
    public final zzbmf zza;
    public final VideoController zzb = new VideoController();

    public zzbhz(zzbmf zzbmf) {
        this.zza = zzbmf;
    }

    public final float getAspectRatio() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzg = this.zza.zzg();
            if (zzg != null) {
                return (Drawable) ObjectWrapper.unwrap(zzg);
            }
            return null;
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzj() != null) {
                this.zzb.zza(this.zza.zzj());
            }
        } catch (RemoteException e) {
            zzcgs.zzg("Exception occurred while getting video controller", e);
        }
        return this.zzb;
    }

    public final boolean hasVideoContent() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zza.zzf(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final zzbmf zza() {
        return this.zza;
    }
}
