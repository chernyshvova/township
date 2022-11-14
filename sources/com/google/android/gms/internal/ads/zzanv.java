package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzanv {
    public static final zzanv zza = new zzans();

    public abstract int zza();

    public abstract zzanu zzb(int i, zzanu zzanu, boolean z, long j);

    public abstract int zzc();

    public abstract zzant zzd(int i, zzant zzant, boolean z);

    public abstract int zze(Object obj);

    public final boolean zzf() {
        return zza() == 0;
    }

    public final zzanu zzg(int i, zzanu zzanu, boolean z) {
        return zzb(i, zzanu, false, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if ((zza() - 1) == 0) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzh(int r3, com.google.android.gms.internal.ads.zzant r4, com.google.android.gms.internal.ads.zzanu r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zzd(r3, r4, r0)
            r2.zzg(r0, r5, r0)
            r4 = 1
            if (r3 != 0) goto L_0x0031
            r3 = -1
            if (r6 == 0) goto L_0x0022
            if (r6 == r4) goto L_0x0020
            r1 = 2
            if (r6 != r1) goto L_0x001a
            int r6 = r2.zza()
            int r6 = r6 + r3
            if (r6 != 0) goto L_0x002a
            goto L_0x0020
        L_0x001a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L_0x0020:
            r4 = 0
            goto L_0x002a
        L_0x0022:
            int r6 = r2.zza()
            int r6 = r6 + r3
            if (r6 != 0) goto L_0x002a
            r4 = -1
        L_0x002a:
            if (r4 != r3) goto L_0x002d
            return r3
        L_0x002d:
            r2.zzg(r4, r5, r0)
            return r0
        L_0x0031:
            int r3 = r3 + r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanv.zzh(int, com.google.android.gms.internal.ads.zzant, com.google.android.gms.internal.ads.zzanu, int):int");
    }
}
