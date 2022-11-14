package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwa implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    public final /* synthetic */ zzbvn zza;
    public final /* synthetic */ Adapter zzb;
    public final /* synthetic */ zzbwg zzc;

    public zzbwa(zzbwg zzbwg, zzbvn zzbvn, Adapter adapter) {
        this.zzc = zzbwg;
        this.zza = zzbvn;
        this.zzb = adapter;
    }

    public final void onFailure(@NonNull AdError adError) {
        try {
            String canonicalName = this.zzb.getClass().getCanonicalName();
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
            MediationInterscrollerAd unused = this.zzc.zzi = (MediationInterscrollerAd) obj;
            this.zza.zzj();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
        return new zzbvy(this.zza);
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }
}
