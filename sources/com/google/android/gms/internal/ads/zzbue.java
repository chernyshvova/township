package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbue {
    public static final zzbub<JSONObject> zza = new zzbud();
    public static final zzbtz<InputStream> zzb = zzbuc.zza;
    public static final Charset zzc = Charset.forName("UTF-8");

    public static final /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
