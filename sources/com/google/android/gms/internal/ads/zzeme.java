package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeme implements zzeqp<zzeqo<Bundle>> {
    public final Set<String> zza;

    public zzeme(Set<String> set) {
        this.zza = set;
    }

    public final zzfqn<zzeqo<Bundle>> zza() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zza) {
            arrayList.add(add);
        }
        return zzfqe.zza(new zzemd(arrayList));
    }
}
