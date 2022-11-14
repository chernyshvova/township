package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.domain.network.NetworkConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbjq {
    public final String zza = zzbkv.zzb.zze();
    public final Map<String, String> zzb;
    public final Context zzc;
    public final String zzd;

    public zzbjq(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put(AnalyticsEventKey.SEARCH_QUERY, "gmob_sdk");
        this.zzb.put(MetadataRule.FIELD_V, NetworkConstants.apiVersion);
        this.zzb.put("os", Build.VERSION.RELEASE);
        this.zzb.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzb;
        zzs.zzc();
        map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zzr.zzx());
        Map<String, String> map2 = this.zzb;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map<String, String> map3 = this.zzb;
        zzs.zzc();
        map3.put("is_lite_sdk", true != zzr.zzH(context) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        Future<zzcbp> zza2 = zzs.zzn().zza(this.zzc);
        try {
            this.zzb.put("network_coarse", Integer.toString(zza2.get().zzk));
            this.zzb.put("network_fine", Integer.toString(zza2.get().zzl));
        } catch (Exception e) {
            zzs.zzg().zzg(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    public final String zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final Map<String, String> zzd() {
        return this.zzb;
    }
}
