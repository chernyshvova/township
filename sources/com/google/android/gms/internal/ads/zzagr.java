package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagr implements Comparable<zzagr> {
    public final boolean zza;
    public final zzagm zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
        if (r10 < ((float) r8.zzh)) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        if (r10 < r8.zzi) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagr(com.google.android.gms.internal.ads.zzkc r7, com.google.android.gms.internal.ads.zzagm r8, int r9, boolean r10) {
        /*
            r6 = this;
            r6.<init>()
            r6.zzb = r8
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1
            r2 = -1
            r3 = 0
            if (r10 == 0) goto L_0x0033
            int r4 = r7.zzq
            if (r4 == r2) goto L_0x0014
            int r5 = r8.zzb
            if (r4 > r5) goto L_0x0033
        L_0x0014:
            int r4 = r7.zzr
            if (r4 == r2) goto L_0x001c
            int r5 = r8.zzc
            if (r4 > r5) goto L_0x0033
        L_0x001c:
            float r4 = r7.zzs
            int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0029
            int r5 = r8.zzd
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0033
        L_0x0029:
            int r4 = r7.zzh
            if (r4 == r2) goto L_0x0031
            int r5 = r8.zze
            if (r4 > r5) goto L_0x0033
        L_0x0031:
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            r6.zza = r4
            if (r10 == 0) goto L_0x005e
            int r10 = r7.zzq
            if (r10 == r2) goto L_0x0040
            int r4 = r8.zzf
            if (r10 < r4) goto L_0x005e
        L_0x0040:
            int r10 = r7.zzr
            if (r10 == r2) goto L_0x0048
            int r4 = r8.zzg
            if (r10 < r4) goto L_0x005e
        L_0x0048:
            float r10 = r7.zzs
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0055
            int r0 = r8.zzh
            float r0 = (float) r0
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L_0x005e
        L_0x0055:
            int r10 = r7.zzh
            if (r10 == r2) goto L_0x005f
            int r0 = r8.zzi
            if (r10 < r0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            r6.zzc = r1
            boolean r9 = com.google.android.gms.internal.ads.zzags.zzd(r9, r3)
            r6.zzd = r9
            int r9 = r7.zzh
            r6.zze = r9
            int r9 = r7.zzc()
            r6.zzf = r9
        L_0x0071:
            com.google.android.gms.internal.ads.zzfml<java.lang.String> r9 = r8.zzp
            int r9 = r9.size()
            if (r3 >= r9) goto L_0x008d
            java.lang.String r9 = r7.zzl
            if (r9 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzfml<java.lang.String> r10 = r8.zzp
            java.lang.Object r10 = r10.get(r3)
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x008a
            goto L_0x0090
        L_0x008a:
            int r3 = r3 + 1
            goto L_0x0071
        L_0x008d:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L_0x0090:
            r6.zzg = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagr.<init>(com.google.android.gms.internal.ads.zzkc, com.google.android.gms.internal.ads.zzagm, int, boolean):void");
    }

    /* renamed from: zza */
    public final int compareTo(zzagr zzagr) {
        zzfnx zzfnx;
        zzfnx zzfnx2;
        if (!this.zza || !this.zzd) {
            zzfnx = zzags.zzc.zza();
        } else {
            zzfnx = zzags.zzc;
        }
        zzfma zza2 = zzfma.zzg().zzd(this.zzd, zzagr.zzd).zzd(this.zza, zzagr.zza).zzd(this.zzc, zzagr.zzc).zza(Integer.valueOf(this.zzg), Integer.valueOf(zzagr.zzg), zzfnx.zzb().zza());
        Integer valueOf = Integer.valueOf(this.zze);
        Integer valueOf2 = Integer.valueOf(zzagr.zze);
        if (this.zzb.zzx) {
            zzfnx2 = zzags.zzc.zza();
        } else {
            zzfnx2 = zzags.zzd;
        }
        return zza2.zza(valueOf, valueOf2, zzfnx2).zza(Integer.valueOf(this.zzf), Integer.valueOf(zzagr.zzf), zzfnx).zza(Integer.valueOf(this.zze), Integer.valueOf(zzagr.zze), zzfnx).zze();
    }
}
