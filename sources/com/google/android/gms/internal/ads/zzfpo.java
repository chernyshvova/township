package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpo<V, C> extends zzfpe<V, C> {
    @CheckForNull
    public List<zzfpn<V>> zza;

    public zzfpo(zzfmg<? extends zzfqn<? extends V>> zzfmg, boolean z) {
        super(zzfmg, true, true);
        List<zzfpn<V>> list;
        if (zzfmg.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzfnd.zza(zzfmg.size());
        }
        for (int i = 0; i < zzfmg.size(); i++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    public final void zzB(int i) {
        super.zzB(i);
        this.zza = null;
    }

    public abstract C zzI(List<zzfpn<V>> list);

    public final void zzw(int i, V v) {
        List<zzfpn<V>> list = this.zza;
        if (list != null) {
            list.set(i, new zzfpn(v));
        }
    }

    public final void zzx() {
        List<zzfpn<V>> list = this.zza;
        if (list != null) {
            zzh(zzI(list));
        }
    }
}
