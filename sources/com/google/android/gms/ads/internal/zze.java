package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbtx;
import com.google.android.gms.internal.ads.zzbub;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzbuh;
import com.google.android.gms.internal.ads.zzcfz;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzchh;
import com.google.android.gms.internal.ads.zzfqe;
import com.google.android.gms.internal.ads.zzfqn;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zze {
    public Context zza;
    public long zzb = 0;

    public final void zza(Context context, zzcgy zzcgy, String str, @Nullable Runnable runnable) {
        zzc(context, zzcgy, true, (zzcfz) null, str, (String) null, runnable);
    }

    public final void zzb(Context context, zzcgy zzcgy, String str, zzcfz zzcfz) {
        zzc(context, zzcgy, false, zzcfz, zzcfz != null ? zzcfz.zze() : null, str, (Runnable) null);
    }

    @VisibleForTesting
    public final void zzc(Context context, zzcgy zzcgy, boolean z, @Nullable zzcfz zzcfz, String str, @Nullable String str2, @Nullable Runnable runnable) {
        PackageInfo packageInfo;
        if (zzs.zzj().elapsedRealtime() - this.zzb < 5000) {
            zzcgs.zzi("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzs.zzj().elapsedRealtime();
        if (zzcfz != null) {
            long zzb2 = zzcfz.zzb();
            if (zzs.zzj().currentTimeMillis() - zzb2 <= ((Long) zzbex.zzc().zzb(zzbjn.zzcs)).longValue() && zzcfz.zzc()) {
                return;
            }
        }
        if (context == null) {
            zzcgs.zzi("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            zzbuh zzb3 = zzs.zzp().zzb(this.zza, zzcgy);
            zzbub<JSONObject> zzbub = zzbue.zza;
            zzbtx<I, O> zza2 = zzb3.zza("google.afma.config.fetchAppSettings", zzbub, zzbub);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                jSONObject.put("experiment_ids", TextUtils.join(",", zzbjn.zzc()));
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                zzfqn<O> zzb4 = zza2.zzb(jSONObject);
                zzfqn<O> zzi = zzfqe.zzi(zzb4, zzd.zza, zzche.zzf);
                if (runnable != null) {
                    zzb4.zze(runnable, zzche.zzf);
                }
                zzchh.zza(zzi, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                zzcgs.zzg("Error requesting application settings", e);
            }
        } else {
            zzcgs.zzi("App settings could not be fetched. Required parameters missing");
        }
    }
}
