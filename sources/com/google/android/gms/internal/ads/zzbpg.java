package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpg implements zzbps<zzcmr> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzc;
        zzcmr zzcmr = (zzcmr) obj;
        zzblu zzaq = zzcmr.zzaq();
        if (zzaq == null || (zzc = zzaq.zzc()) == null) {
            zzcmr.zzd("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcmr.zzd("nativeAdViewSignalsReady", zzc);
        }
    }
}
