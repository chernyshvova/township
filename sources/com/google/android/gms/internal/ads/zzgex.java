package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgex extends zzgey {
    public zzgex() {
        super((zzgev) null);
    }

    public /* synthetic */ zzgex(zzgev zzgev) {
        super((zzgev) null);
    }

    public final <L> List<L> zza(Object obj, long j) {
        zzgel zzgel = (zzgel) zzggy.zzn(obj, j);
        if (zzgel.zza()) {
            return zzgel;
        }
        int size = zzgel.size();
        zzgel zze = zzgel.zze(size == 0 ? 10 : size + size);
        zzggy.zzo(obj, j, zze);
        return zze;
    }

    public final void zzb(Object obj, long j) {
        ((zzgel) zzggy.zzn(obj, j)).zzb();
    }

    public final <E> void zzc(Object obj, Object obj2, long j) {
        zzgel zzgel = (zzgel) zzggy.zzn(obj, j);
        zzgel zzgel2 = (zzgel) zzggy.zzn(obj2, j);
        int size = zzgel.size();
        int size2 = zzgel2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgel.zza()) {
                zzgel = zzgel.zze(size2 + size);
            }
            zzgel.addAll(zzgel2);
        }
        if (size > 0) {
            zzgel2 = zzgel;
        }
        zzggy.zzo(obj, j, zzgel2);
    }
}
