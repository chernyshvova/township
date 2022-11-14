package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.domain.network.NetworkConstants;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdp {
    public final Context zza;
    public final String zzb;
    public final String zzc;

    public zzfdp(Context context, zzcgy zzcgy) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzcgy.zza;
    }

    public final void zza(Map<String, String> map) {
        map.put(AnalyticsEventKey.SEARCH_QUERY, "gmob_sdk");
        map.put(MetadataRule.FIELD_V, NetworkConstants.apiVersion);
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzs.zzc();
        map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zzr.zzx());
        map.put("app", this.zzb);
        zzs.zzc();
        map.put("is_lite_sdk", true != zzr.zzH(this.zza) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        List<String> zzd = zzbjn.zzd();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfc)).booleanValue()) {
            zzd.addAll(zzs.zzg().zzl().zzn().zzh());
        }
        map.put("e", TextUtils.join(",", zzd));
        map.put("sdkVersion", this.zzc);
    }
}
