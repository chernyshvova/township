package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.LegacyTokenHelper;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzelt implements zzeqo<Bundle> {
    public final zzeyw zza;
    public final long zzb;

    public zzelt(zzeyw zzeyw, long j) {
        Preconditions.checkNotNull(zzeyw, "the targeting must not be null");
        this.zza = zzeyw;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzbdk zzbdk = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzbdk.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        int i2 = i - 1;
        if (i != 0) {
            boolean z = true;
            if (i2 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i2 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            zzezi.zzb(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzbdk.zzb)), zzbdk.zzb != -1);
            zzezi.zzf(bundle, "extras", zzbdk.zzc);
            zzezi.zzc(bundle, "cust_gender", Integer.valueOf(zzbdk.zzd), zzbdk.zzd != -1);
            zzezi.zzg(bundle, "kw", zzbdk.zze);
            zzezi.zzc(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzbdk.zzg), zzbdk.zzg != -1);
            if (zzbdk.zzf) {
                bundle.putBoolean("test_request", true);
            }
            zzezi.zzc(bundle, "d_imp_hdr", 1, zzbdk.zza >= 2 && zzbdk.zzh);
            String str = zzbdk.zzi;
            zzezi.zzb(bundle, "ppid", str, zzbdk.zza >= 2 && !TextUtils.isEmpty(str));
            Location location = zzbdk.zzk;
            if (location != null) {
                Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(location.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", valueOf.floatValue());
                bundle2.putLong("lat", valueOf3.longValue());
                bundle2.putLong(LegacyTokenHelper.TYPE_LONG, valueOf4.longValue());
                bundle2.putLong("time", valueOf2.longValue());
                bundle.putBundle("uule", bundle2);
            }
            zzezi.zze(bundle, "url", zzbdk.zzl);
            zzezi.zzg(bundle, "neighboring_content_urls", zzbdk.zzv);
            zzezi.zzf(bundle, "custom_targeting", zzbdk.zzn);
            zzezi.zzg(bundle, "category_exclusions", zzbdk.zzo);
            zzezi.zze(bundle, "request_agent", zzbdk.zzp);
            zzezi.zze(bundle, "request_pkg", zzbdk.zzq);
            zzezi.zzd(bundle, "is_designed_for_families", Boolean.valueOf(zzbdk.zzr), zzbdk.zza >= 7);
            if (zzbdk.zza >= 8) {
                Integer valueOf5 = Integer.valueOf(zzbdk.zzt);
                if (zzbdk.zzt == -1) {
                    z = false;
                }
                zzezi.zzc(bundle, "tag_for_under_age_of_consent", valueOf5, z);
                zzezi.zze(bundle, "max_ad_content_rating", zzbdk.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
