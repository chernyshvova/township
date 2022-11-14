package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzly extends zzhv {
    public final int zzc;
    public final int zzd;
    public final int[] zze;
    public final int[] zzf;
    public final zzmv[] zzg;
    public final Object[] zzh;
    public final HashMap<Object, Integer> zzi = new HashMap<>();

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.Collection<? extends com.google.android.gms.internal.ads.zzkz>, com.google.android.gms.internal.ads.zzafm] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzly(java.util.Collection r5, java.util.Collection<? extends com.google.android.gms.internal.ads.zzkz> r6, com.google.android.gms.internal.ads.zzafm r7) {
        /*
            r4 = this;
            r7 = 0
            r0 = 0
            r4.<init>(r7, r6, r0)
            int r6 = r5.size()
            int[] r0 = new int[r6]
            r4.zze = r0
            int[] r0 = new int[r6]
            r4.zzf = r0
            com.google.android.gms.internal.ads.zzmv[] r0 = new com.google.android.gms.internal.ads.zzmv[r6]
            r4.zzg = r0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.zzh = r6
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r4.zzi = r6
            java.util.Iterator r5 = r5.iterator()
            r6 = 0
            r0 = 0
        L_0x0026:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x006d
            java.lang.Object r1 = r5.next()
            com.google.android.gms.internal.ads.zzkz r1 = (com.google.android.gms.internal.ads.zzkz) r1
            com.google.android.gms.internal.ads.zzmv[] r2 = r4.zzg
            com.google.android.gms.internal.ads.zzmv r3 = r1.zzb()
            r2[r0] = r3
            int[] r2 = r4.zzf
            r2[r0] = r7
            int[] r2 = r4.zze
            r2[r0] = r6
            com.google.android.gms.internal.ads.zzmv[] r2 = r4.zzg
            r2 = r2[r0]
            int r2 = r2.zzr()
            int r7 = r7 + r2
            com.google.android.gms.internal.ads.zzmv[] r2 = r4.zzg
            r2 = r2[r0]
            int r2 = r2.zzs()
            int r6 = r6 + r2
            java.lang.Object[] r2 = r4.zzh
            java.lang.Object r1 = r1.zza()
            r2[r0] = r1
            int r1 = r0 + 1
            java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.zzi
            java.lang.Object[] r3 = r4.zzh
            r3 = r3[r0]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r3, r0)
            r0 = r1
            goto L_0x0026
        L_0x006d:
            r4.zzc = r7
            r4.zzd = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.<init>(java.util.Collection, com.google.android.gms.internal.ads.zzafm, byte[]):void");
    }

    public final int zzj(int i) {
        return zzalh.zzC(this.zze, i + 1, false, false);
    }

    public final int zzk(int i) {
        return zzalh.zzC(this.zzf, i + 1, false, false);
    }

    public final int zzl(Object obj) {
        Integer num = this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final zzmv zzm(int i) {
        return this.zzg[i];
    }

    public final int zzn(int i) {
        return this.zze[i];
    }

    public final int zzo(int i) {
        return this.zzf[i];
    }

    public final Object zzp(int i) {
        return this.zzh[i];
    }

    public final List<zzmv> zzq() {
        return Arrays.asList(this.zzg);
    }

    public final int zzr() {
        return this.zzc;
    }

    public final int zzs() {
        return this.zzd;
    }
}
