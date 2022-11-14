package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzcfc {
    @GuardedBy("ScionComponent.class")
    @VisibleForTesting
    public static zzcfc zza;

    public static synchronized zzcfc zzd(Context context) {
        synchronized (zzcfc.class) {
            if (zza != null) {
                zzcfc zzcfc = zza;
                return zzcfc;
            }
            Context applicationContext = context.getApplicationContext();
            zzbjn.zza(applicationContext);
            zzg zzl = zzs.zzg().zzl();
            zzl.zza(applicationContext);
            zzceh zzceh = new zzceh((zzceg) null);
            zzceh.zza(applicationContext);
            zzceh.zzb(zzs.zzj());
            zzceh.zzc(zzl);
            zzceh.zzd(zzs.zzA());
            zzcfc zze = zzceh.zze();
            zza = zze;
            zze.zza().zza();
            zza.zzb().zze();
            zzcfh zzc = zza.zzc();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzal)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzbex.zzc().zzb(zzbjn.zzan));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String zzb : hashMap.keySet()) {
                        zzc.zzb(zzb);
                    }
                    zzc.zza(new zzcfe(zzc, hashMap));
                } catch (JSONException e) {
                    zzcgs.zze("Failed to parse listening list", e);
                }
            }
            zzcfc zzcfc2 = zza;
            return zzcfc2;
        }
    }

    public abstract zzcea zza();

    public abstract zzcee zzb();

    public abstract zzcfh zzc();
}
