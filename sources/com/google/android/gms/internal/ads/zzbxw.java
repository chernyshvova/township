package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbxw implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    public final /* synthetic */ zzbxi zza;
    public final /* synthetic */ zzbvn zzb;

    public zzbxw(zzbxz zzbxz, zzbxi zzbxi, zzbvn zzbvn) {
        this.zza = zzbxi;
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
        UnifiedNativeAdMapper unifiedNativeAdMapper = (UnifiedNativeAdMapper) obj;
        if (unifiedNativeAdMapper == null) {
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
                this.zza.zze(new zzbwz(unifiedNativeAdMapper));
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
