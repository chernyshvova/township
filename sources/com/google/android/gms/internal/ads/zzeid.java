package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeid extends zzcck {
    public final /* synthetic */ zzddj zza;
    public final /* synthetic */ zzdbb zzb;
    public final /* synthetic */ zzdck zzc;
    public final /* synthetic */ zzdil zzd;

    public zzeid(zzeie zzeie, zzddj zzddj, zzdbb zzdbb, zzdck zzdck, zzdil zzdil) {
        this.zza = zzddj;
        this.zzb = zzdbb;
        this.zzc = zzdck;
        this.zzd = zzdil;
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final void zzf(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zza.zzbE();
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzd.zza();
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzbK(4);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzccm zzccm) {
        this.zzd.zzb(zzccm);
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    public final void zzm(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzc.zzf();
    }
}
