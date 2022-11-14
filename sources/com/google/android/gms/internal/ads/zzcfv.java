package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfv implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzchj zzb;

    public zzcfv(zzcfw zzcfw, Context context, zzchj zzchj) {
        this.zza = context;
        this.zzb = zzchj;
    }

    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            zzcgs.zzg("Exception while getting advertising Id info", e);
        }
    }
}
