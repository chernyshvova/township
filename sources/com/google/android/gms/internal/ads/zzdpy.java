package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdpy extends zzbmw {
    @Nullable
    public final String zza;
    public final zzdlv zzb;
    public final zzdma zzc;

    public zzdpy(@Nullable String str, zzdlv zzdlv, zzdma zzdma) {
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
        return this.zzc.zzN();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzG();
    }

    public final double zzh() throws RemoteException {
        return this.zzc.zzM();
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzK();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzL();
    }

    public final Bundle zzk() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzl() throws RemoteException {
        this.zzb.zzT();
    }

    public final zzbhg zzm() throws RemoteException {
        return this.zzc.zzw();
    }

    public final void zzn(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    public final boolean zzo(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final zzbma zzq() throws RemoteException {
        return this.zzc.zzx();
    }

    public final IObjectWrapper zzr() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final String zzs() throws RemoteException {
        return this.zza;
    }
}
