package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    public final zzbvn zza;

    public zzbwx(zzbvn zzbvn) {
        this.zza = zzbvn;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgs.zzd("Adapter called onClick.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwo(this));
            return;
        }
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgs.zzd("Adapter called onDismissScreen.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzi("#008 Must be called on the main UI thread.");
            zzcgl.zza.post(new zzbwp(this));
            return;
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest$ErrorCode adRequest$ErrorCode) {
        String valueOf = String.valueOf(adRequest$ErrorCode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzcgs.zzd(sb.toString());
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwq(this, adRequest$ErrorCode));
            return;
        }
        try {
            this.zza.zzg(zzbwy.zza(adRequest$ErrorCode));
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgs.zzd("Adapter called onLeaveApplication.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwr(this));
            return;
        }
        try {
            this.zza.zzh();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgs.zzd("Adapter called onPresentScreen.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbws(this));
            return;
        }
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgs.zzd("Adapter called onReceivedAd.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwt(this));
            return;
        }
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgs.zzd("Adapter called onDismissScreen.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwu(this));
            return;
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest$ErrorCode adRequest$ErrorCode) {
        String valueOf = String.valueOf(adRequest$ErrorCode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
        zzcgs.zzd(sb.toString());
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwv(this, adRequest$ErrorCode));
            return;
        }
        try {
            this.zza.zzg(zzbwy.zza(adRequest$ErrorCode));
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgs.zzd("Adapter called onLeaveApplication.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbww(this));
            return;
        }
        try {
            this.zza.zzh();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgs.zzd("Adapter called onPresentScreen.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwm(this));
            return;
        }
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgs.zzd("Adapter called onReceivedAd.");
        zzbev.zza();
        if (!zzcgl.zzp()) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcgl.zza.post(new zzbwn(this));
            return;
        }
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
