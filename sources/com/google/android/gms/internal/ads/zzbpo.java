package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpo implements zzbps<zzcmr> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcmr.zzbB();
        } else if ("resume".equals(str)) {
            zzcmr.zzbC();
        }
    }
}
