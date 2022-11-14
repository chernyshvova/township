package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgr implements Comparator<zzgp> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgp zzgp = (zzgp) obj;
        zzgp zzgp2 = (zzgp) obj2;
        zzgy zzgy = (zzgy) zzgp.iterator();
        zzgy zzgy2 = (zzgy) zzgp2.iterator();
        while (zzgy.hasNext() && zzgy2.hasNext()) {
            int compare = Integer.compare(zzgp.zzb(zzgy.zza()), zzgp.zzb(zzgy2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgp.zza(), zzgp2.zza());
    }
}
