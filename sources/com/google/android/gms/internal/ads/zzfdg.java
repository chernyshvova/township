package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdg {
    public final HashMap<String, String> zza = new HashMap<>();
    public final zzfdm zzb = new zzfdm(zzs.zzj());

    public zzfdg() {
        this.zza.put("new_csi", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    public static zzfdg zza(String str) {
        zzfdg zzfdg = new zzfdg();
        zzfdg.zza.put("action", str);
        return zzfdg;
    }

    public static zzfdg zzb(String str) {
        zzfdg zzfdg = new zzfdg();
        zzfdg.zza.put("request_id", str);
        return zzfdg;
    }

    public final zzfdg zzc(@NonNull String str, @NonNull String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzfdg zzd(@NonNull String str) {
        this.zzb.zza(str);
        return this;
    }

    public final zzfdg zze(@NonNull String str, @NonNull String str2) {
        this.zzb.zzb(str, str2);
        return this;
    }

    public final zzfdg zzf(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final zzfdg zzg(zzeyq zzeyq, @Nullable zzcgh zzcgh) {
        zzeyp zzeyp = zzeyq.zzb;
        zzh(zzeyp.zzb);
        if (!zzeyp.zza.isEmpty()) {
            switch (zzeyp.zza.get(0).zzb) {
                case 1:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    if (zzcgh != null) {
                        this.zza.put("as", true != zzcgh.zzj() ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        break;
                    }
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzfdg zzh(zzeyh zzeyh) {
        if (!TextUtils.isEmpty(zzeyh.zzb)) {
            this.zza.put("gqi", zzeyh.zzb);
        }
        return this;
    }

    public final zzfdg zzi(zzeye zzeye) {
        this.zza.put("aai", zzeye.zzw);
        return this;
    }

    public final Map<String, String> zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzfdl next : this.zzb.zzc()) {
            hashMap.put(next.zza, next.zzb);
        }
        return hashMap;
    }
}
