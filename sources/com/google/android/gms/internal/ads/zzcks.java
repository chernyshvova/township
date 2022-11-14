package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcks implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ long zzf;
    public final /* synthetic */ long zzg;
    public final /* synthetic */ boolean zzh;
    public final /* synthetic */ int zzi;
    public final /* synthetic */ int zzj;
    public final /* synthetic */ zzckx zzk;

    public zzcks(zzckx zzckx, String str, String str2, long j, long j2, long j3, long j4, long j5, boolean z, int i, int i2) {
        this.zzk = zzckx;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = j3;
        this.zzf = j4;
        this.zzg = j5;
        this.zzh = z;
        this.zzi = i;
        this.zzj = i2;
    }

    public final void run() {
        HashMap outline28 = GeneratedOutlineSupport.outline28("event", "precacheProgress");
        outline28.put(AnalyticsEventKey.FAQ_SOURCE, this.zza);
        outline28.put("cachedSrc", this.zzb);
        outline28.put("bufferedDuration", Long.toString(this.zzc));
        outline28.put("totalDuration", Long.toString(this.zzd));
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue()) {
            outline28.put("qoeLoadedBytes", Long.toString(this.zze));
            outline28.put("qoeCachedBytes", Long.toString(this.zzf));
            outline28.put("totalBytes", Long.toString(this.zzg));
            outline28.put("reportTime", Long.toString(zzs.zzj().currentTimeMillis()));
        }
        outline28.put("cacheReady", true != this.zzh ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        outline28.put("playerCount", Integer.toString(this.zzi));
        outline28.put("playerPreparedCount", Integer.toString(this.zzj));
        zzckx.zzo(this.zzk, "onPrecacheEvent", outline28);
    }
}
