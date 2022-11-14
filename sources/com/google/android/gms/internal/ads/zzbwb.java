package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwb implements InitializationCompleteCallback {
    public final /* synthetic */ zzbrq zza;

    public zzbwb(zzbwg zzbwg, zzbrq zzbrq) {
        this.zza = zzbrq;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }
}
