package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzggo<T, B> {
    public abstract boolean zza(zzgfv zzgfv);

    public abstract void zzb(B b, int i, long j);

    public abstract void zzc(B b, int i, int i2);

    public abstract void zzd(B b, int i, long j);

    public abstract void zze(B b, int i, zzgcz zzgcz);

    public abstract void zzf(B b, int i, T t);

    public abstract B zzg();

    public abstract T zzh(B b);

    public abstract void zzi(Object obj, T t);

    public abstract T zzj(Object obj);

    public abstract B zzk(Object obj);

    public abstract void zzl(Object obj, B b);

    public abstract void zzm(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:19:0x003c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzn(B r7, com.google.android.gms.internal.ads.zzgfv r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.zzc()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0060
            if (r0 == r2) goto L_0x0058
            r3 = 2
            if (r0 == r3) goto L_0x0050
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.zzk()
            r6.zzc(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzgen r7 = com.google.android.gms.internal.ads.zzgeo.zzi()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.zzg()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zzb()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.zzn(r0, r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.zzc()
            if (r3 != r8) goto L_0x004b
            r6.zzh(r0)
            r6.zzf(r7, r1, r0)
            return r2
        L_0x004b:
            com.google.android.gms.internal.ads.zzgeo r7 = com.google.android.gms.internal.ads.zzgeo.zzh()
            throw r7
        L_0x0050:
            com.google.android.gms.internal.ads.zzgcz r8 = r8.zzq()
            r6.zze(r7, r1, r8)
            return r2
        L_0x0058:
            long r3 = r8.zzj()
            r6.zzd(r7, r1, r3)
            return r2
        L_0x0060:
            long r3 = r8.zzh()
            r6.zzb(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzggo.zzn(java.lang.Object, com.google.android.gms.internal.ads.zzgfv):boolean");
    }

    public abstract T zzo(T t, T t2);

    public abstract int zzp(T t);

    public abstract int zzq(T t);

    public abstract void zzr(T t, zzgdk zzgdk) throws IOException;
}
