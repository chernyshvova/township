package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcvd extends zzaxr {
    public final zzcvc zza;
    public final zzbfr zzb;
    public final zzeud zzc;
    public boolean zzd = false;

    public zzcvd(zzcvc zzcvc, zzbfr zzbfr, zzeud zzeud) {
        this.zza = zzcvc;
        this.zzb = zzbfr;
        this.zzc = zzeud;
    }

    public final zzbfr zze() {
        return this.zzb;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzaxz zzaxz) {
        try {
            this.zzc.zzi(zzaxz);
            this.zza.zzb((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzaxz, this.zzd);
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final zzbhd zzg() {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeY)).booleanValue()) {
            return null;
        }
        return this.zza.zzm();
    }

    public final void zzh(boolean z) {
        this.zzd = z;
    }

    public final void zzi(zzbha zzbha) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        zzeud zzeud = this.zzc;
        if (zzeud != null) {
            zzeud.zzm(zzbha);
        }
    }

    public final void zzj(zzaxw zzaxw) {
    }
}
