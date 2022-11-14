package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzeho extends zzeip {
    public final zzdil zza;

    public zzeho(zzdbb zzdbb, zzdbv zzdbv, zzdck zzdck, zzdcp zzdcp, zzdbq zzdbq, zzdfs zzdfs, zzdit zzdit, zzddj zzddj, zzdil zzdil, zzdfo zzdfo) {
        super(zzdbb, zzdbv, zzdck, zzdcp, zzdfs, zzddj, zzdit, zzdfo, zzdbq);
        this.zza = zzdil;
    }

    public final void zzn() {
        this.zza.zzc();
    }

    public final void zzo() {
        this.zza.zza();
    }

    public final void zzp(zzccm zzccm) {
        this.zza.zzb(zzccm);
    }

    public final void zzr(zzccq zzccq) throws RemoteException {
        this.zza.zzb(new zzccm(zzccq.zze(), zzccq.zzf()));
    }

    public final void zzt() throws RemoteException {
        this.zza.zzc();
    }
}
