package com.google.android.gms.ads;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbdd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class AdError {
    @RecentlyNonNull
    public static final String UNDEFINED_DOMAIN = "undefined";
    public final int zza;
    @NonNull
    public final String zzb;
    @NonNull
    public final String zzc;
    @Nullable
    public final AdError zzd;

    public AdError(int i, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        this(i, str, str2, (AdError) null);
    }

    public AdError(int i, @RecentlyNonNull String str, @RecentlyNonNull String str2, @Nullable AdError adError) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = adError;
    }

    @RecentlyNullable
    public AdError getCause() {
        return this.zzd;
    }

    public int getCode() {
        return this.zza;
    }

    @NonNull
    public String getDomain() {
        return this.zzc;
    }

    @NonNull
    public String getMessage() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @NonNull
    public final zzbdd zza() {
        AdError adError = this.zzd;
        return new zzbdd(this.zza, this.zzb, this.zzc, adError == null ? null : new zzbdd(adError.zza, adError.zzb, adError.zzc, (zzbdd) null, (IBinder) null), (IBinder) null);
    }

    @RecentlyNonNull
    public JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.zza);
        jSONObject.put("Message", this.zzb);
        jSONObject.put("Domain", this.zzc);
        AdError adError = this.zzd;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzb());
        }
        return jSONObject;
    }
}
