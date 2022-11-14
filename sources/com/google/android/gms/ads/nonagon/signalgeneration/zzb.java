package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzb {
    public final int zza = ((Integer) zzbex.zzc().zzb(zzbjn.zzfg)).intValue();
    public final long zzb = ((Long) zzbex.zzc().zzb(zzbjn.zzfh)).longValue();
    public final Map<String, Pair<Long, String>> zzc = Collections.synchronizedMap(new zza(this));

    private final void zze() {
        long currentTimeMillis = zzs.zzj().currentTimeMillis();
        try {
            Iterator<Map.Entry<String, Pair<Long, String>>> it = this.zzc.entrySet().iterator();
            while (it.hasNext() && currentTimeMillis - ((Long) ((Pair) it.next().getValue()).first).longValue() > this.zzb) {
                it.remove();
            }
        } catch (ConcurrentModificationException e) {
            zzs.zzg().zzg(e, "QueryJsonMap.removeExpiredEntries");
        }
    }

    public final synchronized void zza(String str, String str2) {
        this.zzc.put(str, new Pair(Long.valueOf(zzs.zzj().currentTimeMillis()), str2));
        zze();
    }

    @Nullable
    public final synchronized String zzb(String str) {
        Pair pair = this.zzc.get(str);
        if (pair == null) {
            return null;
        }
        String str2 = (String) pair.second;
        this.zzc.remove(str);
        return str2;
    }

    public final synchronized void zzc(String str) {
        this.zzc.remove(str);
    }
}
