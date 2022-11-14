package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeoe implements zzeqo<Bundle> {
    public final String zza;
    public final boolean zzb;

    public zzeoe(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }
}
