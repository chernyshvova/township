package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaxb implements Comparator<zzaxh> {
    public zzaxb(zzaxd zzaxd) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzaxh zzaxh = (zzaxh) obj;
        zzaxh zzaxh2 = (zzaxh) obj2;
        int i = zzaxh.zzc - zzaxh2.zzc;
        if (i != 0) {
            return i;
        }
        return (int) (zzaxh.zza - zzaxh2.zza);
    }
}
