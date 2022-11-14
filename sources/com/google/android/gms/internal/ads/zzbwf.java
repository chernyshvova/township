package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwf implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    public final /* synthetic */ zzbvn zza;
    public final /* synthetic */ zzbwg zzb;

    public zzbwf(zzbwg zzbwg, zzbvn zzbvn) {
        this.zzb = zzbwg;
        this.zza = zzbvn;
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.zza.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 85 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to load mediation ad: ErrorCode = ");
            sb.append(code);
            sb.append(". ErrorMessage = ");
            sb.append(message);
            sb.append(". ErrorDomain = ");
            sb.append(domain);
            zzcgs.zzd(sb.toString());
            this.zza.zzx(adError.zza());
            this.zza.zzw(adError.getCode(), adError.getMessage());
            this.zza.zzg(adError.getCode());
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        try {
            MediationRewardedAd unused = this.zzb.zzh = (MediationRewardedAd) obj;
            this.zza.zzj();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
        return new zzcdj(this.zza);
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzb.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzcgs.zzd(sb.toString());
            this.zza.zzw(0, str);
            this.zza.zzg(0);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }
}
