package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdlm extends zzbme {
    public final zzdma zza;
    public IObjectWrapper zzb;

    public zzdlm(zzdma zzdma) {
        this.zza = zzdma;
    }

    public static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float zze() throws RemoteException {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzez)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzW() != 0.0f) {
            return this.zza.zzW();
        }
        if (this.zza.zzw() != null) {
            try {
                return this.zza.zzw().zzm();
            } catch (RemoteException e) {
                zzcgs.zzg("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        } else {
            IObjectWrapper iObjectWrapper = this.zzb;
            if (iObjectWrapper != null) {
                return zzb(iObjectWrapper);
            }
            zzbmi zzB = this.zza.zzB();
            if (zzB == null) {
                return 0.0f;
            }
            float zze = (zzB.zze() == -1 || zzB.zzf() == -1) ? 0.0f : ((float) zzB.zze()) / ((float) zzB.zzf());
            return zze == 0.0f ? zzb(zzB.zzb()) : zze;
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    public final IObjectWrapper zzg() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbmi zzB = this.zza.zzB();
        if (zzB == null) {
            return null;
        }
        return zzB.zzb();
    }

    public final float zzh() throws RemoteException {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeA)).booleanValue() && this.zza.zzw() != null) {
            return this.zza.zzw().zzj();
        }
        return 0.0f;
    }

    public final float zzi() throws RemoteException {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeA)).booleanValue() && this.zza.zzw() != null) {
            return this.zza.zzw().zzk();
        }
        return 0.0f;
    }

    public final zzbhg zzj() throws RemoteException {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeA)).booleanValue()) {
            return null;
        }
        return this.zza.zzw();
    }

    public final boolean zzk() throws RemoteException {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeA)).booleanValue() && this.zza.zzw() != null) {
            return true;
        }
        return false;
    }

    public final void zzl(zzbnq zzbnq) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeA)).booleanValue() && (this.zza.zzw() instanceof zzcnn)) {
            ((zzcnn) this.zza.zzw()).zzv(zzbnq);
        }
    }
}
