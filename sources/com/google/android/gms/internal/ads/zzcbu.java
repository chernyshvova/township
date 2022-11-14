package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbu extends zzcbv {
    public final Object zza = new Object();
    public final Context zzb;
    @Nullable
    public SharedPreferences zzc;
    public final zzbtx<JSONObject, JSONObject> zzd;

    public zzcbu(Context context, zzbtx<JSONObject, JSONObject> zzbtx) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzbtx;
    }

    public static JSONObject zzb(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzcgy.zza().zza);
            jSONObject.put("mf", zzbla.zza.zze());
            jSONObject.put("cl", "386087985");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final zzfqn<Void> zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzs.zzj().currentTimeMillis() - this.zzc.getLong("js_last_update", 0) < zzbla.zzb.zze().longValue()) {
            return zzfqe.zza(null);
        }
        return zzfqe.zzj(this.zzd.zzb(zzb(this.zzb)), new zzcbt(this), zzche.zzf);
    }

    public final /* synthetic */ Void zzc(JSONObject jSONObject) {
        zzbjn.zzb(this.zzb, 1, jSONObject);
        this.zzc.edit().putLong("js_last_update", zzs.zzj().currentTimeMillis()).apply();
        return null;
    }
}
