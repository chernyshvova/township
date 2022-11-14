package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbjf<T> {
    public final int zza;
    public final String zzb;
    public final T zzc;

    public /* synthetic */ zzbjf(int i, String str, Object obj, zzbja zzbja) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        zzbex.zzb().zza(this);
    }

    public static zzbjf<Boolean> zzg(int i, String str, Boolean bool) {
        return new zzbja(i, str, bool);
    }

    public static zzbjf<Integer> zzh(int i, String str, int i2) {
        return new zzbjb(1, str, Integer.valueOf(i2));
    }

    public static zzbjf<Long> zzi(int i, String str, long j) {
        return new zzbjc(1, str, Long.valueOf(j));
    }

    public static zzbjf<Float> zzj(int i, String str, float f) {
        return new zzbjd(1, str, Float.valueOf(f));
    }

    public static zzbjf<String> zzk(int i, String str, String str2) {
        return new zzbje(1, str, str2);
    }

    public static zzbjf<String> zzl(int i, String str) {
        zzbjf<String> zzk = zzk(1, "gads:sdk_core_constants:experiment_id", (String) null);
        zzbex.zzb().zzb(zzk);
        return zzk;
    }

    public abstract T zza(Bundle bundle);

    public abstract void zzb(SharedPreferences.Editor editor, T t);

    public abstract T zzc(JSONObject jSONObject);

    public abstract T zzd(SharedPreferences sharedPreferences);

    public final String zze() {
        return this.zzb;
    }

    public final T zzf() {
        return this.zzc;
    }

    public final int zzm() {
        return this.zza;
    }
}
