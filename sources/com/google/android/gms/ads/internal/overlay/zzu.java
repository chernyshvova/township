package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbzq;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzu extends zzbzq {
    public final AdOverlayInfoParcel zza;
    public final Activity zzb;
    public boolean zzc = false;
    public boolean zzd = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzo zzo = this.zza.zzc;
            if (zzo != null) {
                zzo.zzbK(4);
            }
            this.zzd = true;
        }
    }

    public final void zze() throws RemoteException {
    }

    public final void zzf() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbI();
        }
    }

    public final boolean zzg() throws RemoteException {
        return false;
    }

    public final void zzh(@Nullable Bundle bundle) {
        zzo zzo;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfZ)).booleanValue()) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zzbcz zzbcz = adOverlayInfoParcel.zzb;
                if (zzbcz != null) {
                    zzbcz.onAdClicked();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzo = this.zza.zzc) == null)) {
                    zzo.zzbE();
                }
            }
            zzs.zza();
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzi() throws RemoteException {
    }

    public final void zzj() throws RemoteException {
    }

    public final void zzk() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzca();
        }
    }

    public final void zzl() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbJ();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzm(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzp() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzq() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzs() throws RemoteException {
    }
}
