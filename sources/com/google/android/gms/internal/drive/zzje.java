package com.google.android.gms.internal.drive;

import java.util.Comparator;

public final class zzje implements Comparator<zzjc> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjc zzjc = (zzjc) obj;
        zzjc zzjc2 = (zzjc) obj2;
        zzjj zzjj = (zzjj) zzjc.iterator();
        zzjj zzjj2 = (zzjj) zzjc2.iterator();
        while (zzjj.hasNext() && zzjj2.hasNext()) {
            int compare = Integer.compare(zzjc.zza(zzjj.nextByte()), zzjc.zza(zzjj2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzjc.size(), zzjc2.size());
    }
}
