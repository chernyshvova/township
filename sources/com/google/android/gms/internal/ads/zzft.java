package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzft extends zzdw<Integer, Long> {
    public Long zza;
    public Long zzb;

    public zzft() {
    }

    public final HashMap<Integer, Long> zza() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        return hashMap;
    }

    public zzft(String str) {
        HashMap zzb2 = zzdw.zzb(str);
        if (zzb2 != null) {
            this.zza = (Long) zzb2.get(0);
            this.zzb = (Long) zzb2.get(1);
        }
    }
}
