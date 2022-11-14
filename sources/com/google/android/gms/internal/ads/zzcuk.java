package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcuk {
    public final zzfdh zza;
    public final zzduu zzb;
    public final zzeyq zzc;

    public zzcuk(zzduu zzduu, zzeyq zzeyq, zzfdh zzfdh) {
        this.zza = zzfdh;
        this.zzb = zzduu;
        this.zzc = zzeyq;
    }

    public static String zzb(int i) {
        int i2 = i - 1;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? AnalyticsEventKey.URL : "ac" : "cb" : "cc" : "bb" : "h";
    }

    public final void zza(long j, int i) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
            zzfdh zzfdh = this.zza;
            zzfdg zza2 = zzfdg.zza("ad_closed");
            zza2.zzh(this.zzc.zzb.zzb);
            zza2.zzc("show_time", String.valueOf(j));
            zza2.zzc(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
            zza2.zzc("acr", zzb(i));
            zzfdh.zza(zza2);
            return;
        }
        zzdut zza3 = this.zzb.zza();
        zza3.zza(this.zzc.zzb.zzb);
        zza3.zzc("action", "ad_closed");
        zza3.zzc("show_time", String.valueOf(j));
        zza3.zzc(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        zza3.zzc("acr", zzb(i));
        zza3.zzd();
    }
}
