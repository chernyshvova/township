package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzaxo extends AppOpenAd {
    @Nullable
    public FullScreenContentCallback zza;
    public final zzaxs zzb;
    @NonNull
    public final String zzc;
    public final zzaxp zzd = new zzaxp();
    @Nullable
    public OnPaidEventListener zze;

    public zzaxo(zzaxs zzaxs, String str) {
        this.zzb = zzaxs;
        this.zzc = str;
    }

    public final String getAdUnitId() {
        return this.zzc;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zza;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zze;
    }

    @NonNull
    public final ResponseInfo getResponseInfo() {
        zzbhd zzbhd;
        try {
            zzbhd = this.zzb.zzg();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            zzbhd = null;
        }
        return ResponseInfo.zzc(zzbhd);
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzb.zzh(z);
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zze = onPaidEventListener;
        try {
            this.zzb.zzi(new zzbio(onPaidEventListener));
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(@NonNull Activity activity) {
        try {
            this.zzb.zzf(ObjectWrapper.wrap(activity), this.zzd);
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
