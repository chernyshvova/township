package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjd extends zzbjf<Float> {
    public zzbjd(int i, String str, Float f) {
        super(1, str, f, (zzbja) null);
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
            return (Float) zzf();
        }
        String zze2 = zze();
        return Float.valueOf(bundle.getFloat(zze2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putFloat(zze(), ((Float) obj).floatValue());
    }

    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(zze(), (double) ((Float) zzf()).floatValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(zze(), ((Float) zzf()).floatValue()));
    }
}
