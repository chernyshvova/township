package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpm<V> extends zzfpo<V, List<V>> {
    public zzfpm(zzfmg<? extends zzfqn<? extends V>> zzfmg, boolean z) {
        super(zzfmg, true);
        zza();
    }

    public final /* bridge */ /* synthetic */ Object zzI(List list) {
        ArrayList zza = zzfnd.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfpn zzfpn = (zzfpn) it.next();
            zza.add(zzfpn != null ? zzfpn.zza : null);
        }
        return Collections.unmodifiableList(zza);
    }
}
