package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzbhr implements InitializationStatus {
    public final zzbhv zza;

    public zzbhr(zzbhv zzbhv) {
        this.zza = zzbhv;
    }

    public final Map getAdapterStatusMap() {
        zzbhv zzbhv = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzbhs(zzbhv));
        return hashMap;
    }
}
