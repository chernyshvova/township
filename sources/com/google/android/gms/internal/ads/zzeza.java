package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeza {
    public static zzeyf zza(List<zzeyf> list, zzeyf zzeyf) {
        return list.get(0);
    }

    public static zzbdp zzb(Context context, List<zzeyf> list) {
        ArrayList arrayList = new ArrayList();
        for (zzeyf next : list) {
            if (next.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.zza, next.zzb));
            }
        }
        return new zzbdp(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzeyf zzc(zzbdp zzbdp) {
        if (zzbdp.zzi) {
            return new zzeyf(-3, 0, true);
        }
        return new zzeyf(zzbdp.zze, zzbdp.zzb, false);
    }
}
