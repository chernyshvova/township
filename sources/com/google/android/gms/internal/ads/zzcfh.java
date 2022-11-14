package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfh {
    @GuardedBy("this")
    public final Map<String, zzcff> zza = new HashMap();
    @GuardedBy("this")
    public final List<zzcfg> zzb = new ArrayList();
    public final Context zzc;
    public final zzcee zzd;

    public zzcfh(Context context, zzcee zzcee) {
        this.zzc = context;
        this.zzd = zzcee;
    }

    public final synchronized void zza(zzcfg zzcfg) {
        this.zzb.add(zzcfg);
    }

    public final synchronized void zzb(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if ("__default__".equals(str)) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzcff zzcff = new zzcff(this, str);
            this.zza.put(str, zzcff);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzcff);
        }
    }

    public final /* synthetic */ void zzc(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zzb();
        }
    }
}
