package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbsi<AdT> extends AdManagerInterstitialAd {
    public final Context zza;
    public final zzbdo zzb;
    public final zzbfr zzc;
    public final String zzd;
    public final zzbve zze = new zzbve();
    @Nullable
    public AppEventListener zzf;
    @Nullable
    public FullScreenContentCallback zzg;
    @Nullable
    public OnPaidEventListener zzh;

    public zzbsi(Context context, String str) {
        this.zza = context;
        this.zzd = str;
        this.zzb = zzbdo.zza;
        this.zzc = zzbev.zzb().zzb(context, new zzbdp(), str, this.zze);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzf;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzh;
    }

    @NonNull
    public final ResponseInfo getResponseInfo() {
        zzbhd zzbhd = null;
        try {
            zzbfr zzbfr = this.zzc;
            if (zzbfr != null) {
                zzbhd = zzbfr.zzt();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzc(zzbhd);
    }

    public final void setAppEventListener(@Nullable AppEventListener appEventListener) {
        try {
            this.zzf = appEventListener;
            zzbfr zzbfr = this.zzc;
            if (zzbfr != null) {
                zzbfr.zzi(appEventListener != null ? new zzawn(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzg = fullScreenContentCallback;
            zzbfr zzbfr = this.zzc;
            if (zzbfr != null) {
                zzbfr.zzR(new zzbey(fullScreenContentCallback));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzbfr zzbfr = this.zzc;
            if (zzbfr != null) {
                zzbfr.zzJ(z);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzh = onPaidEventListener;
            zzbfr zzbfr = this.zzc;
            if (zzbfr != null) {
                zzbfr.zzO(new zzbio(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(@NonNull Activity activity) {
        if (activity == null) {
            zzcgs.zzi("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzbfr zzbfr = this.zzc;
            if (zzbfr != null) {
                zzbfr.zzQ(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzbhn zzbhn, AdLoadCallback<AdT> adLoadCallback) {
        try {
            if (this.zzc != null) {
                this.zze.zze(zzbhn.zzn());
                this.zzc.zzP(this.zzb.zza(this.zza, zzbhn), new zzbdg(adLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }
}
