package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.unity3d.services.ads.gmascar.bridges.MobileAdsBridge;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdvy {
    public final zzbqn zza;

    public zzdvy(zzbqn zzbqn) {
        this.zza = zzbqn;
    }

    private final void zzq(zzdvx zzdvx) throws RemoteException {
        String str;
        String zza2 = zzdvx.zza(zzdvx);
        String valueOf = String.valueOf(zza2);
        if (valueOf.length() != 0) {
            str = "Dispatching AFMA event on publisher webview: ".concat(valueOf);
        } else {
            str = new String("Dispatching AFMA event on publisher webview: ");
        }
        zzcgs.zzh(str);
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzq(new zzdvx(MobileAdsBridge.initializeMethodName, (zzdvw) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("creation", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "nativeObjectCreated";
        zzq(zzdvx);
    }

    public final void zzc(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("creation", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "nativeObjectNotCreated";
        zzq(zzdvx);
    }

    public final void zzd(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("interstitial", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onNativeAdObjectNotAvailable";
        zzq(zzdvx);
    }

    public final void zze(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("interstitial", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onAdLoaded";
        zzq(zzdvx);
    }

    public final void zzf(long j, int i) throws RemoteException {
        zzdvx zzdvx = new zzdvx("interstitial", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onAdFailedToLoad";
        Integer unused3 = zzdvx.zzd = Integer.valueOf(i);
        zzq(zzdvx);
    }

    public final void zzg(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("interstitial", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onAdOpened";
        zzq(zzdvx);
    }

    public final void zzh(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("interstitial", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onAdClicked";
        this.zza.zzb(zzdvx.zza(zzdvx));
    }

    public final void zzi(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("interstitial", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onAdClosed";
        zzq(zzdvx);
    }

    public final void zzj(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onNativeAdObjectNotAvailable";
        zzq(zzdvx);
    }

    public final void zzk(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onRewardedAdLoaded";
        zzq(zzdvx);
    }

    public final void zzl(long j, int i) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onRewardedAdFailedToLoad";
        Integer unused3 = zzdvx.zzd = Integer.valueOf(i);
        zzq(zzdvx);
    }

    public final void zzm(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onRewardedAdOpened";
        zzq(zzdvx);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onRewardedAdFailedToShow";
        Integer unused3 = zzdvx.zzd = Integer.valueOf(i);
        zzq(zzdvx);
    }

    public final void zzo(long j) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onRewardedAdClosed";
        zzq(zzdvx);
    }

    public final void zzp(long j, zzccq zzccq) throws RemoteException {
        zzdvx zzdvx = new zzdvx("rewarded", (zzdvw) null);
        Long unused = zzdvx.zza = Long.valueOf(j);
        String unused2 = zzdvx.zzc = "onUserEarnedReward";
        String unused3 = zzdvx.zze = zzccq.zze();
        Integer unused4 = zzdvx.zzf = Integer.valueOf(zzccq.zzf());
        zzq(zzdvx);
    }
}
