package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjl implements SharedPreferences.OnSharedPreferenceChangeListener {
    @VisibleForTesting
    public volatile boolean zza = false;
    public final Object zzb = new Object();
    public final ConditionVariable zzc = new ConditionVariable();
    public volatile boolean zzd = false;
    @Nullable
    public SharedPreferences zze = null;
    public Bundle zzf = new Bundle();
    public Context zzg;
    public JSONObject zzh = new JSONObject();

    private final void zzf() {
        if (this.zze != null) {
            try {
                this.zzh = new JSONObject((String) zzbjp.zza(new zzbjj(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf();
        }
    }

    public final void zza(Context context) {
        if (!this.zzd) {
            synchronized (this.zzb) {
                if (!this.zzd) {
                    if (!this.zza) {
                        this.zza = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzg = applicationContext;
                    try {
                        this.zzf = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (!(remoteContext == null && (remoteContext = context.getApplicationContext()) == null)) {
                            context = remoteContext;
                        }
                        if (context != null) {
                            zzbex.zza();
                            SharedPreferences zza2 = zzbjh.zza(context);
                            this.zze = zza2;
                            if (zza2 != null) {
                                zza2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzblo.zzb(new zzbjk(this));
                            zzf();
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                        }
                    } finally {
                        this.zza = false;
                        this.zzc.open();
                    }
                }
            }
        }
    }

    public final <T> T zzb(zzbjf<T> zzbjf) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd) {
                    if (this.zze == null) {
                    }
                }
                T zzf2 = zzbjf.zzf();
                return zzf2;
            }
        }
        if (zzbjf.zzm() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbjf.zzf();
            }
            return zzbjf.zza(bundle);
        } else if (zzbjf.zzm() != 1 || !this.zzh.has(zzbjf.zze())) {
            return zzbjp.zza(new zzbji(this, zzbjf));
        } else {
            return zzbjf.zzc(this.zzh);
        }
    }

    public final /* synthetic */ String zzc() {
        return this.zze.getString("flag_configuration", JsonUtils.EMPTY_JSON);
    }

    public final /* synthetic */ Object zzd(zzbjf zzbjf) {
        return zzbjf.zzd(this.zze);
    }
}
