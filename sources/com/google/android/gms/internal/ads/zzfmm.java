package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfmm<K, V> extends zzfmr<K, V> {
    public final zzfmm<K, V> zza(K k, V... vArr) {
        List asList = Arrays.asList(vArr);
        Collection collection = this.zza.get(k);
        if (collection != null) {
            for (Object next : asList) {
                zzflm.zza(k, next);
                collection.add(next);
            }
        } else {
            Iterator it = asList.iterator();
            if (it.hasNext()) {
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    Object next2 = it.next();
                    zzflm.zza(k, next2);
                    arrayList.add(next2);
                }
                this.zza.put(k, arrayList);
            }
        }
        return this;
    }

    public final zzfmn<K, V> zzb() {
        Set<Map.Entry<K, Collection<V>>> entrySet = this.zza.entrySet();
        if (entrySet.isEmpty()) {
            return zzfmb.zza;
        }
        zzfmo zzfmo = new zzfmo(entrySet.size());
        int i = 0;
        for (Map.Entry next : entrySet) {
            Object key = next.getKey();
            zzfml zzp = zzfml.zzp((Collection) next.getValue());
            if (!zzp.isEmpty()) {
                zzfmo.zza(key, zzp);
                i += zzp.size();
            }
        }
        return new zzfmn<>(zzfmo.zzc(), i);
    }
}
