package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdpw extends zzbsa implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzblr {
    public View zza;
    public zzbhg zzb;
    public zzdlv zzc;
    public boolean zzd = false;
    public boolean zze = false;

    public zzdpw(zzdlv zzdlv, zzdma zzdma) {
        this.zza = zzdma.zzH();
        this.zzb = zzdma.zzw();
        this.zzc = zzdlv;
        if (zzdma.zzR() != null) {
            zzdma.zzR().zzaw(this);
        }
    }

    private final void zzg() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private final void zzh() {
        View view;
        zzdlv zzdlv = this.zzc;
        if (zzdlv != null && (view = this.zza) != null) {
            zzdlv.zzp(view, Collections.emptyMap(), Collections.emptyMap(), zzdlv.zzA(this.zza));
        }
    }

    public static final void zzi(zzbse zzbse, int i) {
        try {
            zzbse.zzf(i);
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzh();
    }

    public final void onScrollChanged() {
        zzh();
    }

    public final void zza() {
        zzr.zza.post(new zzdpu(this));
    }

    public final zzbhg zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzcgs.zzf("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzg();
        zzdlv zzdlv = this.zzc;
        if (zzdlv != null) {
            zzdlv.zzT();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zzd(IObjectWrapper iObjectWrapper, zzbse zzbse) throws RemoteException {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzcgs.zzf("Instream ad can not be shown after destroy().");
            zzi(zzbse, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            String str2 = view == null ? "can not get video view." : "can not get video controller.";
            if (str2.length() != 0) {
                str = "Instream internal error: ".concat(str2);
            } else {
                str = new String("Instream internal error: ");
            }
            zzcgs.zzf(str);
            zzi(zzbse, 0);
        } else if (this.zze) {
            zzcgs.zzf("Instream ad should not be used again.");
            zzi(zzbse, 1);
        } else {
            this.zze = true;
            zzg();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzs.zzz();
            zzchr.zza(this.zza, this);
            zzs.zzz();
            zzchr.zzb(this.zza, this);
            zzh();
            try {
                zzbse.zze();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzd(iObjectWrapper, new zzdpv(this));
    }

    public final zzbmf zzf() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzcgs.zzf("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdlv zzdlv = this.zzc;
        if (zzdlv == null || zzdlv.zzH() == null) {
            return null;
        }
        return this.zzc.zzH().zza();
    }
}
