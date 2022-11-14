package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzcfz;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzfqn;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzj implements zzg {
    @GuardedBy("lock")
    public long zzA = 0;
    public final Object zza = new Object();
    public boolean zzb;
    public final List<Runnable> zzc = new ArrayList();
    public zzfqn<?> zzd;
    @GuardedBy("lock")
    @Nullable
    public zzawy zze = null;
    @GuardedBy("lock")
    @Nullable
    public SharedPreferences zzf;
    @GuardedBy("lock")
    @Nullable
    public SharedPreferences.Editor zzg;
    @GuardedBy("lock")
    public boolean zzh = true;
    @GuardedBy("lock")
    @Nullable
    public String zzi;
    @GuardedBy("lock")
    @Nullable
    public String zzj;
    @GuardedBy("lock")
    public boolean zzk = true;
    @GuardedBy("lock")
    public zzcfz zzl = new zzcfz("", 0);
    @GuardedBy("lock")
    public long zzm = 0;
    @GuardedBy("lock")
    public long zzn = 0;
    @GuardedBy("lock")
    public int zzo = -1;
    @GuardedBy("lock")
    public int zzp = 0;
    @GuardedBy("lock")
    public Set<String> zzq = Collections.emptySet();
    @GuardedBy("lock")
    public JSONObject zzr = new JSONObject();
    @GuardedBy("lock")
    public boolean zzs = true;
    @GuardedBy("lock")
    public boolean zzt = true;
    @GuardedBy("lock")
    public String zzu = null;
    @GuardedBy("lock")
    public String zzv = "";
    @GuardedBy("lock")
    public boolean zzw = false;
    @GuardedBy("lock")
    public String zzx = "";
    @GuardedBy("lock")
    public int zzy = -1;
    @GuardedBy("lock")
    public int zzz = -1;

    private final void zzN() {
        zzfqn<?> zzfqn = this.zzd;
        if (zzfqn != null && !zzfqn.isDone()) {
            try {
                this.zzd.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzcgs.zzj("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzcgs.zzg("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final void zzO() {
        zzche.zza.execute(new zzi(this));
    }

    public final void zzA(String str) {
        zzN();
        synchronized (this.zza) {
            if (!TextUtils.equals(this.zzu, str)) {
                this.zzu = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzB(boolean z) {
        zzN();
        synchronized (this.zza) {
            if (z != this.zzk) {
                this.zzk = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final boolean zzC() {
        boolean z;
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzao)).booleanValue()) {
            return false;
        }
        zzN();
        synchronized (this.zza) {
            z = this.zzk;
        }
        return z;
    }

    public final void zzD(int i) {
        zzN();
        synchronized (this.zza) {
            if (this.zzz != i) {
                this.zzz = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final long zzE() {
        long j;
        zzN();
        synchronized (this.zza) {
            j = this.zzA;
        }
        return j;
    }

    public final void zzF(long j) {
        zzN();
        synchronized (this.zza) {
            if (this.zzA != j) {
                this.zzA = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final String zzG() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzv;
        }
        return str;
    }

    public final void zzH(String str) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue()) {
            zzN();
            synchronized (this.zza) {
                if (!this.zzv.equals(str)) {
                    this.zzv = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzO();
                }
            }
        }
    }

    public final boolean zzI() {
        boolean z;
        zzN();
        synchronized (this.zza) {
            z = this.zzw;
        }
        return z;
    }

    public final void zzJ(boolean z) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue()) {
            zzN();
            synchronized (this.zza) {
                if (this.zzw != z) {
                    this.zzw = z;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z);
                        this.zzg.apply();
                    }
                    zzO();
                }
            }
        }
    }

    public final String zzK() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzx;
        }
        return str;
    }

    public final void zzL(String str) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue()) {
            zzN();
            synchronized (this.zza) {
                if (!this.zzx.equals(str)) {
                    this.zzx = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzO();
                }
            }
        }
    }

    public final /* synthetic */ void zzM(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.zza) {
            this.zzf = sharedPreferences;
            this.zzg = edit;
            if (PlatformVersion.isAtLeastM()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.zzh = this.zzf.getBoolean("use_https", this.zzh);
            this.zzs = this.zzf.getBoolean("content_url_opted_out", this.zzs);
            this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
            this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
            this.zzt = this.zzf.getBoolean("content_vertical_opted_out", this.zzt);
            this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
            this.zzp = this.zzf.getInt("version_code", this.zzp);
            this.zzl = new zzcfz(this.zzf.getString("app_settings_json", this.zzl.zzd()), this.zzf.getLong("app_settings_last_update_ms", this.zzl.zzb()));
            this.zzm = this.zzf.getLong("app_last_background_time_ms", this.zzm);
            this.zzo = this.zzf.getInt("request_in_session_count", this.zzo);
            this.zzn = this.zzf.getLong("first_ad_req_time_ms", this.zzn);
            this.zzq = this.zzf.getStringSet("never_pool_slots", this.zzq);
            this.zzu = this.zzf.getString("display_cutout", this.zzu);
            this.zzy = this.zzf.getInt("app_measurement_npa", this.zzy);
            this.zzz = this.zzf.getInt("sd_app_measure_npa", this.zzz);
            this.zzA = this.zzf.getLong("sd_app_measure_npa_ts", this.zzA);
            this.zzv = this.zzf.getString("inspector_info", this.zzv);
            this.zzw = this.zzf.getBoolean("linked_device", this.zzw);
            this.zzx = this.zzf.getString("linked_ad_unit", this.zzx);
            try {
                this.zzr = new JSONObject(this.zzf.getString("native_advanced_settings", JsonUtils.EMPTY_JSON));
            } catch (JSONException e) {
                zzcgs.zzj("Could not convert native advanced settings to json object", e);
            }
            zzO();
        }
    }

    public final void zza(Context context) {
        synchronized (this.zza) {
            if (this.zzf == null) {
                this.zzd = zzche.zza.zza(new zzh(this, context, AppLovinMediationProvider.ADMOB));
                this.zzb = true;
            }
        }
    }

    @Nullable
    public final zzawy zzb() {
        if (!this.zzb) {
            return null;
        }
        if ((zzd() && zzh()) || !zzbku.zzb.zze().booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzawy();
            }
            this.zze.zza();
            zzcgs.zzh("start fetching content...");
            zzawy zzawy = this.zze;
            return zzawy;
        }
    }

    public final void zzc(boolean z) {
        zzN();
        synchronized (this.zza) {
            if (this.zzs != z) {
                this.zzs = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final boolean zzd() {
        boolean z;
        zzN();
        synchronized (this.zza) {
            z = this.zzs;
        }
        return z;
    }

    public final void zze(@Nullable String str) {
        zzN();
        synchronized (this.zza) {
            if (!str.equals(this.zzi)) {
                this.zzi = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_url_hashes", str);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    @Nullable
    public final String zzf() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    public final void zzg(boolean z) {
        zzN();
        synchronized (this.zza) {
            if (this.zzt != z) {
                this.zzt = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final boolean zzh() {
        boolean z;
        zzN();
        synchronized (this.zza) {
            z = this.zzt;
        }
        return z;
    }

    public final void zzi(@Nullable String str) {
        zzN();
        synchronized (this.zza) {
            if (!str.equals(this.zzj)) {
                this.zzj = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    @Nullable
    public final String zzj() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    public final void zzk(int i) {
        zzN();
        synchronized (this.zza) {
            if (this.zzp != i) {
                this.zzp = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final int zzl() {
        int i;
        zzN();
        synchronized (this.zza) {
            i = this.zzp;
        }
        return i;
    }

    public final void zzm(String str) {
        zzN();
        synchronized (this.zza) {
            long currentTimeMillis = zzs.zzj().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzl.zzd())) {
                    this.zzl = new zzcfz(str, currentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzg.apply();
                    }
                    zzO();
                    for (Runnable run : this.zzc) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzl.zza(currentTimeMillis);
        }
    }

    public final zzcfz zzn() {
        zzcfz zzcfz;
        zzN();
        synchronized (this.zza) {
            zzcfz = this.zzl;
        }
        return zzcfz;
    }

    public final zzcfz zzo() {
        zzcfz zzcfz;
        synchronized (this.zza) {
            zzcfz = this.zzl;
        }
        return zzcfz;
    }

    public final void zzp(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzq(long j) {
        zzN();
        synchronized (this.zza) {
            if (this.zzm != j) {
                this.zzm = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final long zzr() {
        long j;
        zzN();
        synchronized (this.zza) {
            j = this.zzm;
        }
        return j;
    }

    public final void zzs(int i) {
        zzN();
        synchronized (this.zza) {
            if (this.zzo != i) {
                this.zzo = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final int zzt() {
        int i;
        zzN();
        synchronized (this.zza) {
            i = this.zzo;
        }
        return i;
    }

    public final void zzu(long j) {
        zzN();
        synchronized (this.zza) {
            if (this.zzn != j) {
                this.zzn = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final long zzv() {
        long j;
        zzN();
        synchronized (this.zza) {
            j = this.zzn;
        }
        return j;
    }

    public final void zzw(String str, String str2, boolean z) {
        zzN();
        synchronized (this.zza) {
            JSONArray optJSONArray = this.zzr.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (str2.equals(optJSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_TEMPATE_ID))) {
                            if (z) {
                                if (optJSONObject.optBoolean("uses_media_view", false)) {
                                    return;
                                }
                            }
                            length = i;
                        } else {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportDBAdapter.ReportColumns.COLUMN_TEMPATE_ID, str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzs.zzj().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzr.put(str, optJSONArray);
            } catch (JSONException e) {
                zzcgs.zzj("Could not update native advanced settings", e);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzr.toString());
                this.zzg.apply();
            }
            zzO();
        }
    }

    public final JSONObject zzx() {
        JSONObject jSONObject;
        zzN();
        synchronized (this.zza) {
            jSONObject = this.zzr;
        }
        return jSONObject;
    }

    public final void zzy() {
        zzN();
        synchronized (this.zza) {
            this.zzr = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzO();
        }
    }

    public final String zzz() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzu;
        }
        return str;
    }
}
