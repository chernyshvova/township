package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjc extends zzbjf<Long> {
    public zzbjc(int i, String str, Long l) {
        super(1, str, l, (zzbja) null);
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
            return (Long) zzf();
        }
        String zze2 = zze();
        return Long.valueOf(bundle.getLong(zze2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(zze(), ((Long) obj).longValue());
    }

    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(zze(), ((Long) zzf()).longValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(zze(), ((Long) zzf()).longValue()));
    }
}
