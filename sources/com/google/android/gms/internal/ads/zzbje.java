package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbje extends zzbjf<String> {
    public zzbje(int i, String str, String str2) {
        super(1, str, str2, (zzbja) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        String str;
        String zze = zze();
        if (zze.length() != 0) {
            str = "com.google.android.gms.ads.flag.".concat(zze);
        } else {
            str = new String("com.google.android.gms.ads.flag.");
        }
        if (!bundle.containsKey(str)) {
            return (String) zzf();
        }
        String zze2 = zze();
        return bundle.getString(zze2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze2) : new String("com.google.android.gms.ads.flag."));
    }

    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putString(zze(), (String) obj);
    }

    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return jSONObject.optString(zze(), (String) zzf());
    }

    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(zze(), (String) zzf());
    }
}
