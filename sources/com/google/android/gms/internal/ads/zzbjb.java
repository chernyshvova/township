package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjb extends zzbjf<Integer> {
    public zzbjb(int i, String str, Integer num) {
        super(1, str, num, (zzbja) null);
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
            return (Integer) zzf();
        }
        String zze2 = zze();
        return Integer.valueOf(bundle.getInt(zze2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(zze(), ((Integer) obj).intValue());
    }

    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zze(), ((Integer) zzf()).intValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zze(), ((Integer) zzf()).intValue()));
    }
}
