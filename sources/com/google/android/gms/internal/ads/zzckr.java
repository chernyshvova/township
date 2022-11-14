package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckr implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ zzckx zze;

    public zzckr(zzckx zzckx, String str, String str2, int i, int i2, boolean z) {
        this.zze = zzckx;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = i2;
    }

    public final void run() {
        HashMap outline28 = GeneratedOutlineSupport.outline28("event", "precacheProgress");
        outline28.put(AnalyticsEventKey.FAQ_SOURCE, this.zza);
        outline28.put("cachedSrc", this.zzb);
        outline28.put("bytesLoaded", Integer.toString(this.zzc));
        outline28.put("totalBytes", Integer.toString(this.zzd));
        outline28.put("cacheReady", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzckx.zzo(this.zze, "onPrecacheEvent", outline28);
    }
}
