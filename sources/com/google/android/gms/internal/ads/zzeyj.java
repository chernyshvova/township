package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbv;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeyj {
    @Nullable
    public final String zza;
    @Nullable
    public final String zzb = this.zzd.optString("ad_base_url", (String) null);
    public final JSONObject zzc = this.zzd.optJSONObject("ad_json");
    public final JSONObject zzd;

    public zzeyj(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzc2 = zzbv.zzc(jsonReader);
        this.zzd = zzc2;
        this.zza = zzc2.optString("ad_html", (String) null);
    }
}
