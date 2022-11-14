package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.helpshift.analytics.AnalyticsEventKey;
import com.swrve.sdk.SwrveImp;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzemq implements zzeqo<Bundle> {
    public final zzbdv zza;
    public final zzcgy zzb;
    public final boolean zzc;

    public zzemq(zzbdv zzbdv, zzcgy zzcgy, boolean z) {
        this.zza = zzbdv;
        this.zzb = zzcgy;
        this.zzc = z;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) zzbex.zzc().zzb(zzbjn.zzdB)).intValue()) {
            bundle.putString("app_open_version", SwrveImp.CAMPAIGN_RESPONSE_VERSION);
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdC)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        zzbdv zzbdv = this.zza;
        if (zzbdv != null) {
            int i = zzbdv.zza;
            if (i == 1) {
                bundle.putString("avo", AnalyticsEventKey.PROTOCOL);
            } else if (i == 2) {
                bundle.putString("avo", AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL);
            }
        }
    }
}
