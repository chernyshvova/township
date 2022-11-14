package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzbuy implements Runnable {
    public final zzbva zza;
    public final Context zzb;
    public final String zzc;

    public zzbuy(zzbva zzbva, Context context, String str) {
        this.zza = zzbva;
        this.zzb = context;
        this.zzc = str;
    }

    public final void run() {
        Context context = this.zzb;
        String str = this.zzc;
        zzbjn.zza(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzbex.zzc().zzb(zzbjn.zzac)).booleanValue());
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaj)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        try {
            ((zzcom) zzcgw.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzbuz.zza)).zze(ObjectWrapper.wrap(context), new zzbux(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzcgv | NullPointerException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
