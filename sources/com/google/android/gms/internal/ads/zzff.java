package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzff extends zzdw<Integer, Long> {
    public long zza = -1;
    public long zzb = -1;

    public zzff() {
    }

    public final HashMap<Integer, Long> zza() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zza));
        hashMap.put(1, Long.valueOf(this.zzb));
        return hashMap;
    }

    public zzff(String str) {
        HashMap zzb2 = zzdw.zzb(str);
        if (zzb2 != null) {
            this.zza = ((Long) zzb2.get(0)).longValue();
            this.zzb = ((Long) zzb2.get(1)).longValue();
        }
    }
}
