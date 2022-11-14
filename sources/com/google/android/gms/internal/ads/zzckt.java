package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckt implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ long zzf;
    public final /* synthetic */ boolean zzg;
    public final /* synthetic */ int zzh;
    public final /* synthetic */ int zzi;
    public final /* synthetic */ zzckx zzj;

    public zzckt(zzckx zzckx, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzj = zzckx;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = j;
        this.zzf = j2;
        this.zzg = z;
        this.zzh = i3;
        this.zzi = i4;
    }

    public final void run() {
        HashMap outline28 = GeneratedOutlineSupport.outline28("event", "precacheProgress");
        outline28.put(AnalyticsEventKey.FAQ_SOURCE, this.zza);
        outline28.put("cachedSrc", this.zzb);
        outline28.put("bytesLoaded", Integer.toString(this.zzc));
        outline28.put("totalBytes", Integer.toString(this.zzd));
        outline28.put("bufferedDuration", Long.toString(this.zze));
        outline28.put("totalDuration", Long.toString(this.zzf));
        outline28.put("cacheReady", true != this.zzg ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        outline28.put("playerCount", Integer.toString(this.zzh));
        outline28.put("playerPreparedCount", Integer.toString(this.zzi));
        zzckx.zzo(this.zzj, "onPrecacheEvent", outline28);
    }
}
