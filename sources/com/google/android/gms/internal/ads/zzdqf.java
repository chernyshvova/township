package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqf extends zzboe {
    @Nullable
    public final String zza;
    public final zzdlv zzb;
    public final zzdma zzc;

    public zzdqf(@Nullable String str, zzdlv zzdlv, zzdma zzdma) {
        this.zza = str;
        this.zzb = zzdlv;
        this.zzc = zzdma;
    }

    public final boolean zzA() throws RemoteException {
        return !this.zzc.zzC().isEmpty() && this.zzc.zzD() != null;
    }

    public final void zzB(@Nullable zzbgq zzbgq) throws RemoteException {
        this.zzb.zzv(zzbgq);
    }

    public final void zzC(zzbgm zzbgm) throws RemoteException {
        this.zzb.zzw(zzbgm);
    }

    public final void zzD() {
        this.zzb.zzx();
    }

    public final void zzE() {
        this.zzb.zzy();
    }

    public final zzbmf zzF() throws RemoteException {
        return this.zzb.zzH().zza();
    }

    public final boolean zzG() {
        return this.zzb.zzz();
    }

    public final zzbhd zzH() throws RemoteException {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeY)).booleanValue()) {
            return null;
        }
        return this.zzb.zzm();
    }

    public final void zzI(zzbha zzbha) throws RemoteException {
        this.zzb.zzI(zzbha);
    }

    public final String zze() throws RemoteException {
        return this.zzc.zzz();
    }

    public final List<?> zzf() throws RemoteException {
        return this.zzc.zzA();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzE();
    }

    public final zzbmi zzh() throws RemoteException {
        return this.zzc.zzN();
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzG();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzO();
    }

    public final double zzk() throws RemoteException {
        return this.zzc.zzM();
    }

    public final String zzl() throws RemoteException {
        return this.zzc.zzK();
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzL();
    }

    public final zzbhg zzn() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzo() throws RemoteException {
        return this.zza;
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzT();
    }

    public final zzbma zzq() throws RemoteException {
        return this.zzc.zzx();
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    public final void zzt(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final IObjectWrapper zzu() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final IObjectWrapper zzv() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final Bundle zzw() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzx(zzboc zzboc) throws RemoteException {
        this.zzb.zzt(zzboc);
    }

    public final void zzy() throws RemoteException {
        this.zzb.zzu();
    }

    public final List<?> zzz() throws RemoteException {
        if (zzA()) {
            return this.zzc.zzC();
        }
        return Collections.emptyList();
    }
}
