package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzegs<AdT> implements zzedn<AdT> {
    public static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        return !TextUtils.isEmpty(zzeye.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public final zzfqn<AdT> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzeye zzeye2 = zzeye;
        String optString = zzeye2.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzeyw zzeyw = zzeyq.zza.zza;
        zzeyv zzeyv = new zzeyv();
        zzeyv.zzt(zzeyw);
        zzeyv.zzf(optString);
        Bundle zzd = zzd(zzeyw.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzeye2.zzv.optString(AdMobAdapter.HOUSE_ADS_PARAMETER, (String) null);
        if (optString2 != null) {
            zzd2.putString(AdMobAdapter.HOUSE_ADS_PARAMETER, optString2);
        }
        String optString3 = zzeye2.zzv.optString(AdMobAdapter.AD_JSON_PARAMETER, (String) null);
        if (optString3 != null) {
            zzd2.putString(AdMobAdapter.AD_PARAMETER, optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzeye2.zzD.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzeye2.zzD.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzbdk zzbdk = zzeyw.zzd;
        zzbdk zzbdk2 = r5;
        zzbdk zzbdk3 = new zzbdk(zzbdk.zza, zzbdk.zzb, zzd2, zzbdk.zzd, zzbdk.zze, zzbdk.zzf, zzbdk.zzg, zzbdk.zzh, zzbdk.zzi, zzbdk.zzj, zzbdk.zzk, zzbdk.zzl, zzd, zzbdk.zzn, zzbdk.zzo, zzbdk.zzp, zzbdk.zzq, zzbdk.zzr, zzbdk.zzs, zzbdk.zzt, zzbdk.zzu, zzbdk.zzv, zzbdk.zzw, zzbdk.zzx);
        zzeyv.zza(zzbdk2);
        zzeyw zzu = zzeyv.zzu();
        Bundle bundle = new Bundle();
        zzeyq zzeyq2 = zzeyq;
        zzeyh zzeyh = zzeyq2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzeyh.zza));
        bundle2.putInt("refresh_interval", zzeyh.zzc);
        bundle2.putString("gws_query_id", zzeyh.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        Bundle outline5 = GeneratedOutlineSupport.outline5("initial_ad_unit_id", zzeyq2.zza.zza.zzf);
        zzeye zzeye3 = zzeye;
        outline5.putString("allocation_id", zzeye3.zzw);
        outline5.putStringArrayList("click_urls", new ArrayList(zzeye3.zzc));
        outline5.putStringArrayList("imp_urls", new ArrayList(zzeye3.zzd));
        outline5.putStringArrayList("manual_tracking_urls", new ArrayList(zzeye3.zzp));
        outline5.putStringArrayList("fill_urls", new ArrayList(zzeye3.zzn));
        outline5.putStringArrayList("video_start_urls", new ArrayList(zzeye3.zzh));
        outline5.putStringArrayList("video_reward_urls", new ArrayList(zzeye3.zzi));
        outline5.putStringArrayList("video_complete_urls", new ArrayList(zzeye3.zzj));
        outline5.putString("transaction_id", zzeye3.zzk);
        outline5.putString("valid_from_timestamp", zzeye3.zzl);
        outline5.putBoolean("is_closable_area_disabled", zzeye3.zzL);
        if (zzeye3.zzm != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("rb_amount", zzeye3.zzm.zzb);
            bundle3.putString("rb_type", zzeye3.zzm.zza);
            outline5.putParcelableArray("rewards", new Bundle[]{bundle3});
        }
        bundle.putBundle("parent_ad_config", outline5);
        return zzc(zzu, bundle);
    }

    public abstract zzfqn<AdT> zzc(zzeyw zzeyw, Bundle bundle);
}
