package com.google.android.gms.internal.drive;

public final class zzld extends zzla {
    public zzld() {
        super();
    }

    public static <E> zzkp<E> zzc(Object obj, long j) {
        return (zzkp) zznd.zzo(obj, j);
    }

    public final void zza(Object obj, long j) {
        zzc(obj, j).zzbp();
    }

    public final <E> void zza(Object obj, Object obj2, long j) {
        zzkp zzc = zzc(obj, j);
        zzkp zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzbo()) {
                zzc = zzc.zzr(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zznd.zza(obj, j, (Object) zzc2);
    }
}
