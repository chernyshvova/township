package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwe extends zzbfd {
    public final /* synthetic */ zzdvy zza;
    public final /* synthetic */ zzdwf zzb;

    public zzdwe(zzdwf zzdwf, zzdvy zzdvy) {
        this.zzb = zzdwf;
        this.zza = zzdvy;
    }

    public final void zzb() throws RemoteException {
        this.zza.zzi(this.zzb.zza);
    }

    public final void zzc(int i) throws RemoteException {
        this.zza.zzf(this.zzb.zza, i);
    }

    public final void zzd(zzbdd zzbdd) throws RemoteException {
        this.zza.zzf(this.zzb.zza, zzbdd.zza);
    }

    public final void zze() {
    }

    public final void zzf() throws RemoteException {
        this.zza.zze(this.zzb.zza);
    }

    public final void zzg() throws RemoteException {
        this.zza.zzg(this.zzb.zza);
    }

    public final void zzh() throws RemoteException {
        this.zza.zzh(this.zzb.zza);
    }

    public final void zzi() {
    }
}
