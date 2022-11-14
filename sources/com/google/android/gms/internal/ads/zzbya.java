package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbya implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationRewardedAdCallback, MediationNativeAdCallback {
    public final zzbvn zza;

    public zzbya(zzbvn zzbvn) {
        this.zza = zzbvn;
    }

    public final void onAdClosed() {
        try {
            this.zza.zzf();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        try {
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 86 + String.valueOf(domain).length());
            sb.append("Mediated ad failed to show: Error Code = ");
            sb.append(code);
            sb.append(". Error Message = ");
            sb.append(message);
            sb.append(" Error Domain = ");
            sb.append(domain);
            zzcgs.zzi(sb.toString());
            this.zza.zzy(adError.zza());
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zza.zzh();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zza.zzi();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zza.zzr(new zzcdk(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zza.zzn();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        try {
            this.zza.zzq();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zza.zzu();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zza.zzo();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.zza.zze();
        } catch (RemoteException unused) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.zza.zzk();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        String str2;
        try {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Mediated ad failed to show: ".concat(valueOf);
            } else {
                str2 = new String("Mediated ad failed to show: ");
            }
            zzcgs.zzi(str2);
            this.zza.zzv(str);
        } catch (RemoteException unused) {
        }
    }
}
