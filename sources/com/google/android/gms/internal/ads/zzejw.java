package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejw extends zzbfj {
    public final zzelb zza;

    public zzejw(Context context, zzcop zzcop, zzeyv zzeyv, zzdml zzdml, zzbfe zzbfe) {
        zzeld zzeld = new zzeld(zzdml, zzcop.zzd());
        zzeld.zza(zzbfe);
        this.zza = new zzelb(new zzeln(zzcop, context, zzeld, zzeyv), zzeyv.zzg());
    }

    public final void zze(zzbdk zzbdk) throws RemoteException {
        this.zza.zzb(zzbdk, 1);
    }

    public final synchronized String zzf() {
        return this.zza.zzc();
    }

    public final synchronized boolean zzg() throws RemoteException {
        return this.zza.zza();
    }

    public final synchronized String zzh() {
        return this.zza.zzd();
    }

    public final synchronized void zzi(zzbdk zzbdk, int i) throws RemoteException {
        this.zza.zzb(zzbdk, i);
    }
}
