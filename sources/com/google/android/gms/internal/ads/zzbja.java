package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbja extends zzbjf<Boolean> {
    public zzbja(int i, String str, Boolean bool) {
        super(i, str, bool, (zzbja) null);
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
            return (Boolean) zzf();
        }
        String zze2 = zze();
        return Boolean.valueOf(bundle.getBoolean(zze2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putBoolean(zze(), ((Boolean) obj).booleanValue());
    }

    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(zze(), ((Boolean) zzf()).booleanValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(zze(), ((Boolean) zzf()).booleanValue()));
    }
}
