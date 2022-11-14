package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbux extends zzcoi {
    public final AppMeasurementSdk zza;

    public zzbux(AppMeasurementSdk appMeasurementSdk) {
        this.zza = appMeasurementSdk;
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        this.zza.performAction(bundle);
    }

    public final Bundle zzc(Bundle bundle) throws RemoteException {
        return this.zza.performActionWithResponse(bundle);
    }

    public final void zzd(String str, String str2, Bundle bundle) throws RemoteException {
        this.zza.logEvent(str, str2, bundle);
    }

    public final void zze(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    public final Map zzf(String str, String str2, boolean z) throws RemoteException {
        return this.zza.getUserProperties(str, str2, z);
    }

    public final int zzg(String str) throws RemoteException {
        return this.zza.getMaxUserProperties(str);
    }

    public final void zzh(Bundle bundle) throws RemoteException {
        this.zza.setConditionalUserProperty(bundle);
    }

    public final void zzi(String str, String str2, Bundle bundle) throws RemoteException {
        this.zza.clearConditionalUserProperty(str, str2, bundle);
    }

    public final List zzj(String str, String str2) throws RemoteException {
        return this.zza.getConditionalUserProperties(str, str2);
    }

    public final String zzk() throws RemoteException {
        return this.zza.getAppInstanceId();
    }

    public final String zzl() throws RemoteException {
        return this.zza.getGmpAppId();
    }

    public final long zzm() throws RemoteException {
        return this.zza.generateEventId();
    }

    public final void zzn(String str) throws RemoteException {
        this.zza.beginAdUnitExposure(str);
    }

    public final void zzo(String str) throws RemoteException {
        this.zza.endAdUnitExposure(str);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zza.setConsent(bundle);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zza.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }

    public final String zzr() throws RemoteException {
        return this.zza.getCurrentScreenName();
    }

    public final String zzs() throws RemoteException {
        return this.zza.getCurrentScreenClass();
    }

    public final String zzt() throws RemoteException {
        return this.zza.getAppIdOrigin();
    }
}
