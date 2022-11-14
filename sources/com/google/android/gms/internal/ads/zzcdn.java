package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdn extends RewardedInterstitialAd {
    public final String zza;
    public final zzcct zzb;
    public final Context zzc;
    public final zzcdl zzd = new zzcdl();
    @Nullable
    public FullScreenContentCallback zze;
    @Nullable
    public OnAdMetadataChangedListener zzf;
    @Nullable
    public OnPaidEventListener zzg;

    public zzcdn(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = zzbev.zzb().zzf(context, str, new zzbve());
    }

    public final Bundle getAdMetadata() {
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                return zzcct.zzg();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    @NonNull
    public final ResponseInfo getResponseInfo() {
        zzbhd zzbhd = null;
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzbhd = zzcct.zzm();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzc(zzbhd);
    }

    @NonNull
    public final RewardItem getRewardItem() {
        try {
            zzcct zzcct = this.zzb;
            zzccq zzl = zzcct != null ? zzcct.zzl() : null;
            if (zzl != null) {
                return new zzcdd(zzl);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzo(z);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzf(new zzbin(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzn(new zzbio(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzh(new zzcdh(serverSideVerificationOptions));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zze(this.zzd);
                this.zzb.zzb(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzbhn zzbhn, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzd(zzbdo.zza.zza(this.zzc, zzbhn), new zzcdm(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
