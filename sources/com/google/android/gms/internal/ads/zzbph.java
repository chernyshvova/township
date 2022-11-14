package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbph implements zzbps<zzcmr> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzd;
        zzcmr zzcmr = (zzcmr) obj;
        zzblu zzaq = zzcmr.zzaq();
        if (zzaq == null || (zzd = zzaq.zzd()) == null) {
            zzcmr.zzd("nativeClickMetaReady", new JSONObject());
        } else {
            zzcmr.zzd("nativeClickMetaReady", zzd);
        }
    }
}
