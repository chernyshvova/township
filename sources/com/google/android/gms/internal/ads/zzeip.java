package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzeip extends zzbvm {
    public final zzdbb zza;
    public final zzdbv zzb;
    public final zzdck zzc;
    public final zzdcp zzd;
    public final zzdfs zze;
    public final zzddj zzf;
    public final zzdit zzg;
    public final zzdfo zzh;
    public final zzdbq zzi;

    public zzeip(zzdbb zzdbb, zzdbv zzdbv, zzdck zzdck, zzdcp zzdcp, zzdfs zzdfs, zzddj zzddj, zzdit zzdit, zzdfo zzdfo, zzdbq zzdbq) {
        this.zza = zzdbb;
        this.zzb = zzdbv;
        this.zzc = zzdck;
        this.zzd = zzdcp;
        this.zze = zzdfs;
        this.zzf = zzddj;
        this.zzg = zzdit;
        this.zzh = zzdfo;
        this.zzi = zzdbq;
    }

    public final void zze() {
        this.zza.onAdClicked();
    }

    public final void zzf() {
        this.zzf.zzbK(4);
    }

    public final void zzg(int i) {
    }

    public final void zzh() {
        this.zzc.zzb();
    }

    public final void zzi() {
        this.zzf.zzbE();
        this.zzh.zzb();
    }

    public final void zzj() {
        this.zzd.zzbU();
    }

    public void zzk() {
        this.zzb.zza();
        this.zzh.zza();
    }

    public final void zzl(String str, String str2) {
        this.zze.zzbS(str, str2);
    }

    public final void zzm(zzbnc zzbnc, String str) {
    }

    public void zzn() {
        this.zzg.zzb();
    }

    public void zzo() {
        this.zzg.zzc();
    }

    public void zzp(zzccm zzccm) {
    }

    public final void zzq() {
        this.zzg.zza();
    }

    public void zzr(zzccq zzccq) throws RemoteException {
    }

    @Deprecated
    public final void zzs(int i) throws RemoteException {
        zzy(new zzbdd(i, "", "undefined", (zzbdd) null, (IBinder) null));
    }

    public void zzt() throws RemoteException {
    }

    public final void zzu() throws RemoteException {
        this.zzg.zzd();
    }

    public final void zzv(String str) {
        zzy(new zzbdd(0, str, "undefined", (zzbdd) null, (IBinder) null));
    }

    public final void zzw(int i, String str) {
    }

    public final void zzx(zzbdd zzbdd) {
    }

    public final void zzy(zzbdd zzbdd) {
        this.zzi.zza(zzezr.zzc(8, zzbdd));
    }
}
