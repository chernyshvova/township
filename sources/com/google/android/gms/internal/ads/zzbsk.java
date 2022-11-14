package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbsk {
    public static void zza(zzbsl zzbsl, String str, JSONObject jSONObject) {
        zzbsl.zzb(str, jSONObject.toString());
    }

    public static void zzb(zzbsl zzbsl, String str, String str2) {
        zzbsl.zza(GeneratedOutlineSupport.outline20(new StringBuilder(str.length() + 3 + String.valueOf(str2).length()), str, "(", str2, ");"));
    }

    public static void zzc(zzbsl zzbsl, String str, JSONObject jSONObject) {
        String str2;
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        if (valueOf.length() != 0) {
            str2 = "Dispatching AFMA event: ".concat(valueOf);
        } else {
            str2 = new String("Dispatching AFMA event: ");
        }
        zzcgs.zzd(str2);
        zzbsl.zza(sb.toString());
    }

    public static void zzd(zzbsl zzbsl, String str, Map map) {
        try {
            zzbsl.zzd(str, zzs.zzc().zzf(map));
        } catch (JSONException unused) {
            zzcgs.zzi("Could not convert parameters to JSON.");
        }
    }
}
