package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbmc implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    public final zzbnc zza;

    public zzbmc(zzbnc zzbnc) {
        this.zza = zzbnc;
        try {
            zzbnc.zzr();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return false;
        }
    }
}
