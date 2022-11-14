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
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdc extends RewardedAd {
    public final String zza;
    public final zzcct zzb;
    public final Context zzc;
    public final zzcdl zzd = new zzcdl();
    @Nullable
    public OnAdMetadataChangedListener zze;
    @Nullable
    public OnPaidEventListener zzf;
    @Nullable
    public FullScreenContentCallback zzg;

    public zzcdc(Context context, String str) {
        this.zzc = context.getApplicationContext();
        this.zza = str;
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

    @NonNull
    public final String getAdUnitId() {
        return this.zza;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
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
            if (zzl == null) {
                return RewardItem.DEFAULT_REWARD;
            }
            return new zzcdd(zzl);
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return RewardItem.DEFAULT_REWARD;
        }
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
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
        try {
            this.zze = onAdMetadataChangedListener;
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzf(new zzbin(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzn(new zzbio(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(@Nullable ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzcct zzcct = this.zzb;
                if (zzcct != null) {
                    zzcct.zzh(new zzcdh(serverSideVerificationOptions));
                }
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzcgs.zzi("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
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

    public final void zza(zzbhn zzbhn, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzcct zzcct = this.zzb;
            if (zzcct != null) {
                zzcct.zzc(zzbdo.zza.zza(this.zzc, zzbhn), new zzcdg(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
