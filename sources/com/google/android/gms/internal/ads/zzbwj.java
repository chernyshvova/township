package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwj extends zzbvm {
    public final Adapter zza;
    public final zzccl zzb;

    public zzbwj(Adapter adapter, zzccl zzccl) {
        this.zza = adapter;
        this.zzb = zzccl;
    }

    public final void zze() throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzl(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzm(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzh() throws RemoteException {
    }

    public final void zzi() throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzh(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzj() throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzg(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzk() throws RemoteException {
    }

    public final void zzl(String str, String str2) throws RemoteException {
    }

    public final void zzm(zzbnc zzbnc, String str) throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp(zzccm zzccm) throws RemoteException {
    }

    public final void zzq() throws RemoteException {
    }

    public final void zzr(zzccq zzccq) throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzk(ObjectWrapper.wrap(this.zza), new zzccm(zzccq.zze(), zzccq.zzf()));
        }
    }

    public final void zzs(int i) throws RemoteException {
    }

    public final void zzt() throws RemoteException {
        zzccl zzccl = this.zzb;
        if (zzccl != null) {
            zzccl.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzu() throws RemoteException {
    }

    public final void zzv(String str) {
    }

    public final void zzw(int i, String str) throws RemoteException {
    }

    public final void zzx(zzbdd zzbdd) throws RemoteException {
    }

    public final void zzy(zzbdd zzbdd) {
    }
}
