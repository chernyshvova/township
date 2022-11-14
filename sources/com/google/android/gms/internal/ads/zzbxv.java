package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbxv implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    public final /* synthetic */ zzbxf zza;
    public final /* synthetic */ zzbvn zzb;
    public final /* synthetic */ zzbxz zzc;

    public zzbxv(zzbxz zzbxz, zzbxf zzbxf, zzbvn zzbvn) {
        this.zzc = zzbxz;
        this.zza = zzbxf;
        this.zzb = zzbvn;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationInterstitialAd mediationInterstitialAd = (MediationInterstitialAd) obj;
        if (mediationInterstitialAd == null) {
            zzcgs.zzi("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zzf("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzcgs.zzg("", e);
                return null;
            }
        } else {
            try {
                MediationInterstitialAd unused = this.zzc.zzb = mediationInterstitialAd;
                this.zza.zze();
            } catch (RemoteException e2) {
                zzcgs.zzg("", e2);
            }
            return new zzbya(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined"));
    }
}
