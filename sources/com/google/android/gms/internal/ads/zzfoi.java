package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoi {
    public static int zza(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    public static boolean zzb(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static boolean zzc(Set<?> set, Collection<?> collection) {
        if (collection != null) {
            if (collection instanceof zzfnu) {
                collection = ((zzfnu) collection).zza();
            }
            if (!(collection instanceof Set) || collection.size() <= set.size()) {
                return zzb(set, collection.iterator());
            }
            Iterator<?> it = set.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        throw null;
    }
}
