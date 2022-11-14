package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgc extends zzdw<Integer, Long> {
    public Long zza;
    public Long zzb;
    public Long zzc;
    public Long zzd;

    public zzgc() {
    }

    public final HashMap<Integer, Long> zza() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        hashMap.put(3, this.zzd);
        return hashMap;
    }

    public zzgc(String str) {
        HashMap zzb2 = zzdw.zzb(str);
        if (zzb2 != null) {
            this.zza = (Long) zzb2.get(0);
            this.zzb = (Long) zzb2.get(1);
            this.zzc = (Long) zzb2.get(2);
            this.zzd = (Long) zzb2.get(3);
        }
    }
}
