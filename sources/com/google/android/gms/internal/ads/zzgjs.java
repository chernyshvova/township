package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjs<T> implements zzgjg<Set<T>> {
    public static final zzgjg<Set<Object>> zza = zzgjh.zza(Collections.emptySet());
    public final List<zzgju<T>> zzb;
    public final List<zzgju<Collection<T>>> zzc;

    public /* synthetic */ zzgjs(List list, List list2, zzgjq zzgjq) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static <T> zzgjr<T> zza(int i, int i2) {
        return new zzgjr<>(i, i2, (zzgjq) null);
    }

    /* renamed from: zzc */
    public final Set<T> zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.zzc.get(i).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzb2 = zzgjd.zzb(size);
        int size3 = this.zzb.size();
        int i2 = 0;
        while (i2 < size3) {
            Object zzb3 = this.zzb.get(i2).zzb();
            if (zzb3 != null) {
                zzb2.add(zzb3);
                i2++;
            } else {
                throw null;
            }
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object next : (Collection) arrayList.get(i3)) {
                if (next != null) {
                    zzb2.add(next);
                } else {
                    throw null;
                }
            }
        }
        return Collections.unmodifiableSet(zzb2);
    }
}
