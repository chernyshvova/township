package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavl {
    public final zzavk zza;
    public final boolean zzb;
    public final long zzc;
    public final long zzd;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public long zzi;
    public long zzj;
    public long zzk;

    public zzavl() {
        this(-1.0d);
    }

    private final boolean zzd(long j, long j2) {
        return Math.abs((j2 - this.zzi) - (j - this.zzj)) > 20000000;
    }

    public final void zza() {
        this.zzh = false;
        if (this.zzb) {
            this.zza.zzb();
        }
    }

    public final void zzb() {
        if (this.zzb) {
            this.zza.zzc();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzc(long r10, long r12) {
        /*
            r9 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r10
            boolean r2 = r9.zzh
            if (r2 == 0) goto L_0x0042
            long r2 = r9.zze
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r9.zzk
            r4 = 1
            long r2 = r2 + r4
            r9.zzk = r2
            long r2 = r9.zzg
            r9.zzf = r2
        L_0x0019:
            long r2 = r9.zzk
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r9.zzj
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r9.zzf
            long r2 = r2 + r4
            boolean r4 = r9.zzd(r2, r12)
            if (r4 == 0) goto L_0x0033
            r9.zzh = r6
            goto L_0x0042
        L_0x0033:
            long r4 = r9.zzi
            long r4 = r4 + r2
            long r6 = r9.zzj
            long r4 = r4 - r6
            goto L_0x0044
        L_0x003a:
            boolean r2 = r9.zzd(r0, r12)
            if (r2 == 0) goto L_0x0042
            r9.zzh = r6
        L_0x0042:
            r4 = r12
            r2 = r0
        L_0x0044:
            boolean r6 = r9.zzh
            r7 = 0
            if (r6 != 0) goto L_0x0053
            r9.zzj = r0
            r9.zzi = r12
            r9.zzk = r7
            r12 = 1
            r9.zzh = r12
        L_0x0053:
            r9.zze = r10
            r9.zzg = r2
            com.google.android.gms.internal.ads.zzavk r10 = r9.zza
            if (r10 == 0) goto L_0x0085
            long r10 = r10.zza
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0062
            goto L_0x0085
        L_0x0062:
            com.google.android.gms.internal.ads.zzavk r10 = r9.zza
            long r10 = r10.zza
            long r12 = r9.zzc
            long r0 = r4 - r10
            long r0 = r0 / r12
            long r0 = r0 * r12
            long r0 = r0 + r10
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0075
            long r10 = r0 - r12
            goto L_0x0078
        L_0x0075:
            long r12 = r12 + r0
            r10 = r0
            r0 = r12
        L_0x0078:
            long r12 = r0 - r4
            long r4 = r4 - r10
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r0 = r10
        L_0x0081:
            long r10 = r9.zzd
            long r0 = r0 - r10
            return r0
        L_0x0085:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavl.zzc(long, long):long");
    }

    public zzavl(double d) {
        long j;
        boolean z = d != -1.0d;
        this.zzb = z;
        if (z) {
            this.zza = zzavk.zza();
            long j2 = (long) (1.0E9d / d);
            this.zzc = j2;
            j = (j2 * 80) / 100;
        } else {
            this.zza = null;
            j = -1;
            this.zzc = -1;
        }
        this.zzd = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzavl(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>((double) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavl.<init>(android.content.Context):void");
    }
}
