package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqa extends zzbmy {
    @Nullable
    public final String zza;
    public final zzdlv zzb;
    public final zzdma zzc;

    public zzdqa(@Nullable String str, zzdlv zzdlv, zzdma zzdma) {
        this.zza = str;
        this.zzb = zzdlv;
        this.zzc = zzdma;
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzc() throws RemoteException {
        return this.zzc.zzz();
    }

    public final List<?> zzd() throws RemoteException {
        return this.zzc.zzA();
    }

    public final String zze() throws RemoteException {
        return this.zzc.zzE();
    }

    public final zzbmi zzf() throws RemoteException {
        return this.zzc.zzP();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzG();
    }

    public final String zzh() throws RemoteException {
        return this.zzc.zzO();
    }

    public final Bundle zzi() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzj() throws RemoteException {
        this.zzb.zzT();
    }

    public final zzbhg zzk() throws RemoteException {
        return this.zzc.zzw();
    }

    public final void zzl(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    public final boolean zzm(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    public final void zzn(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final zzbma zzo() throws RemoteException {
        return this.zzc.zzx();
    }

    public final IObjectWrapper zzp() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final String zzq() throws RemoteException {
        return this.zza;
    }
}
