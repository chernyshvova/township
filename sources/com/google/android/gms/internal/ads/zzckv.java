package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckv implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzckx zzd;

    public zzckv(zzckx zzckx, String str, String str2, long j) {
        this.zzd = zzckx;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
    }

    public final void run() {
        HashMap outline28 = GeneratedOutlineSupport.outline28("event", "precacheComplete");
        outline28.put(AnalyticsEventKey.FAQ_SOURCE, this.zza);
        outline28.put("cachedSrc", this.zzb);
        outline28.put("totalDuration", Long.toString(this.zzc));
        zzckx.zzo(this.zzd, "onPrecacheEvent", outline28);
    }
}
