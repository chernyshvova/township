package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdpn implements zzavz {
    public final zzcmr zza;

    public zzdpn(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public final void zzc(zzavy zzavy) {
        zzcmr zzcmr = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != zzavy.zzj ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzcmr.zze("onAdVisibilityChanged", hashMap);
    }
}
