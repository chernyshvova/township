package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzdo implements zzcx {
    @GuardedBy("SharedPreferencesLoader.class")
    public static final Map<String, zzdo> zza = new ArrayMap();
    public final SharedPreferences zzb;
    public final SharedPreferences.OnSharedPreferenceChangeListener zzc = new zzdr(this);
    public final Object zzd = new Object();
    public volatile Map<String, ?> zze;
    @GuardedBy("this")
    public final List<zzcu> zzf = new ArrayList();

    public zzdo(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    public static zzdo zza(Context context, String str) {
        zzdo zzdo;
        if (!zzcr.zza()) {
            synchronized (zzdo.class) {
                zzdo = zza.get((Object) null);
                if (zzdo == null) {
                    zzdo = new zzdo(zzb(context, (String) null));
                    zza.put((Object) null, zzdo);
                }
            }
            return zzdo;
        }
        throw null;
    }

    public static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzcr.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: finally extract failed */
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static synchronized void zza() {
        synchronized (zzdo.class) {
            for (zzdo next : zza.values()) {
                next.zzb.unregisterOnSharedPreferenceChangeListener(next.zzc);
            }
            zza.clear();
        }
    }

    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzdh.zza();
        }
        synchronized (this) {
            for (zzcu zza2 : this.zzf) {
                zza2.zza();
            }
        }
    }
}
