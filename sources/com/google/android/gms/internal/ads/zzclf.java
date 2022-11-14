package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzclf extends zzckx implements zzcip {
    public static final /* synthetic */ int zzd = 0;
    public zzciq zze;
    public String zzf;
    public boolean zzg;
    public boolean zzh;

    public zzclf(zzciz zzciz, zzciy zzciy) {
        super(zzciz);
        zzciq zzciq;
        Context context = zzciz.getContext();
        if (zzciy.zzm) {
            zzciq = new zzclw(context, zzciy, (zzciz) this.zzc.get());
        } else if (zzciy.zzn) {
            zzciq = new zzcmh(context, zzciy, (zzciz) this.zzc.get());
        } else {
            zzciq = new zzckg(context, zzciy, (zzciz) this.zzc.get());
        }
        this.zze = zzciq;
        zzciq.zzP(this);
    }

    public static final String zzk(String str) {
        String valueOf = String.valueOf(zzcgl.zzd(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    public final void release() {
        zzciq zzciq = this.zze;
        if (zzciq != null) {
            zzciq.zzP((zzcip) null);
            this.zze.zzQ();
        }
    }

    public final void zzC() {
        zzcgs.zzi("Precache onRenderedFirstFrame");
    }

    public final boolean zza(String str) {
        return zzb(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01d8, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013b, code lost:
        r5 = r47;
        r6 = r48;
        r7 = r46;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        zzm(r6, r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0161, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0162, code lost:
        r2 = r5;
        r15 = r2;
        r1 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(java.lang.String r48, java.lang.String[] r49) {
        /*
            r47 = this;
            r15 = r47
            r13 = r48
            r0 = r49
            r15.zzf = r13
            java.lang.String r14 = zzk(r48)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01e4 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01e4 }
            r2 = 0
        L_0x0014:
            int r3 = r0.length     // Catch:{ Exception -> 0x01e4 }
            if (r2 >= r3) goto L_0x0022
            r3 = r0[r2]     // Catch:{ Exception -> 0x01e4 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x01e4 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01e4 }
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0022:
            com.google.android.gms.internal.ads.zzciq r0 = r15.zze     // Catch:{ Exception -> 0x01e4 }
            java.lang.String r2 = r15.zzb     // Catch:{ Exception -> 0x01e4 }
            r0.zzN(r1, r2)     // Catch:{ Exception -> 0x01e4 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzciz> r0 = r15.zzc     // Catch:{ Exception -> 0x01e4 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzciz r0 = (com.google.android.gms.internal.ads.zzciz) r0     // Catch:{ Exception -> 0x01e4 }
            if (r0 == 0) goto L_0x0036
            r0.zzu(r14, r15)     // Catch:{ Exception -> 0x01e4 }
        L_0x0036:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ Exception -> 0x01e4 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzbjn.zzt     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ Exception -> 0x01e4 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01e4 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01e4 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzbjn.zzs     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ Exception -> 0x01e4 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01e4 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01e4 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01e4 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzbjn.zzr     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ Exception -> 0x01e4 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01e4 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01e4 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01e4 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzbjn.zzbj     // Catch:{ Exception -> 0x01e4 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ Exception -> 0x01e4 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01e4 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01e4 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01e4 }
            r22 = -1
            r1 = r13
            r2 = r15
            r3 = r22
        L_0x0089:
            monitor-enter(r47)     // Catch:{ Exception -> 0x01dd }
            long r24 = r0.currentTimeMillis()     // Catch:{ all -> 0x01cf }
            long r24 = r24 - r19
            int r5 = (r24 > r9 ? 1 : (r24 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x01a2
            boolean r5 = r2.zzg     // Catch:{ all -> 0x01cf }
            if (r5 != 0) goto L_0x0195
            boolean r5 = r2.zzh     // Catch:{ all -> 0x01cf }
            r24 = 1
            if (r5 == 0) goto L_0x00a2
            monitor-exit(r47)     // Catch:{ all -> 0x01cf }
            r5 = r15
            goto L_0x015b
        L_0x00a2:
            com.google.android.gms.internal.ads.zzciq r5 = r2.zze     // Catch:{ all -> 0x01cf }
            boolean r5 = r5.zzY()     // Catch:{ all -> 0x01cf }
            if (r5 == 0) goto L_0x0188
            com.google.android.gms.internal.ads.zzciq r5 = r2.zze     // Catch:{ all -> 0x01cf }
            r25 = r11
            long r11 = r5.zzaf()     // Catch:{ all -> 0x01cf }
            r27 = 0
            int r5 = (r11 > r27 ? 1 : (r11 == r27 ? 0 : -1))
            if (r5 <= 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzciq r5 = r2.zze     // Catch:{ all -> 0x01cf }
            long r29 = r5.zzal()     // Catch:{ all -> 0x01cf }
            int r5 = (r29 > r3 ? 1 : (r29 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x012e
            int r3 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c9
            r3 = 1
            r8 = 1
            goto L_0x00cb
        L_0x00c9:
            r3 = 0
            r8 = 0
        L_0x00cb:
            if (r21 == 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzciq r3 = r2.zze     // Catch:{ all -> 0x01cf }
            long r3 = r3.zzag()     // Catch:{ all -> 0x01cf }
            r31 = r3
            goto L_0x00d8
        L_0x00d6:
            r31 = r22
        L_0x00d8:
            if (r21 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzciq r3 = r2.zze     // Catch:{ all -> 0x01cf }
            long r3 = r3.zzah()     // Catch:{ all -> 0x01cf }
            r33 = r3
            goto L_0x00e5
        L_0x00e3:
            r33 = r22
        L_0x00e5:
            if (r21 == 0) goto L_0x00f0
            com.google.android.gms.internal.ads.zzciq r3 = r2.zze     // Catch:{ all -> 0x01cf }
            long r1 = r3.zzai()     // Catch:{ all -> 0x01cf }
            r35 = r1
            goto L_0x00f2
        L_0x00f0:
            r35 = r22
        L_0x00f2:
            int r16 = com.google.android.gms.internal.ads.zzciq.zzan()     // Catch:{ all -> 0x0120 }
            int r37 = com.google.android.gms.internal.ads.zzciq.zzao()     // Catch:{ all -> 0x0120 }
            r1 = r47
            r2 = r48
            r3 = r14
            r4 = r29
            r38 = r6
            r6 = r11
            r40 = r9
            r9 = r31
            r44 = r11
            r42 = r25
            r11 = r33
            r46 = r14
            r13 = r35
            r15 = r16
            r16 = r37
            r1.zzh(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x011e }
            r3 = r29
            r1 = r44
            goto L_0x0137
        L_0x011e:
            r0 = move-exception
            goto L_0x0123
        L_0x0120:
            r0 = move-exception
            r46 = r14
        L_0x0123:
            r2 = r47
            r5 = r2
            r15 = r5
            r1 = r48
            r6 = r1
            r14 = r46
            goto L_0x01d5
        L_0x012e:
            r38 = r6
            r40 = r9
            r46 = r14
            r42 = r25
            r1 = r11
        L_0x0137:
            int r5 = (r29 > r1 ? 1 : (r29 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x0146
            r5 = r47
            r6 = r48
            r7 = r46
            r5.zzm(r6, r7, r1)     // Catch:{ all -> 0x0161 }
            monitor-exit(r47)     // Catch:{ all -> 0x0161 }
            goto L_0x015b
        L_0x0146:
            r5 = r47
            r6 = r48
            r7 = r46
            com.google.android.gms.internal.ads.zzciq r1 = r5.zze     // Catch:{ all -> 0x0161 }
            long r1 = r1.zzam()     // Catch:{ all -> 0x0161 }
            int r8 = (r1 > r38 ? 1 : (r1 == r38 ? 0 : -1))
            if (r8 < 0) goto L_0x015c
            int r1 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r1 <= 0) goto L_0x015c
            monitor-exit(r47)     // Catch:{ all -> 0x0161 }
        L_0x015b:
            return r24
        L_0x015c:
            r2 = r5
            r1 = r6
            r8 = r42
            goto L_0x0170
        L_0x0161:
            r0 = move-exception
            r2 = r5
            r15 = r2
            r1 = r6
            goto L_0x01d4
        L_0x0167:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r8 = r25
        L_0x0170:
            r2.wait(r8)     // Catch:{ InterruptedException -> 0x017e }
            monitor-exit(r47)     // Catch:{ all -> 0x01cd }
            r15 = r5
            r13 = r6
            r14 = r7
            r11 = r8
            r6 = r38
            r9 = r40
            goto L_0x0089
        L_0x017e:
            java.lang.String r3 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
            java.lang.String r4 = "Wait interrupted."
            r0.<init>(r4)     // Catch:{ all -> 0x01c9 }
            throw r0     // Catch:{ all -> 0x01c9 }
        L_0x0188:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r3 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
            java.lang.String r4 = "ExoPlayer was released during preloading."
            r0.<init>(r4)     // Catch:{ all -> 0x01c9 }
            throw r0     // Catch:{ all -> 0x01c9 }
        L_0x0195:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r3 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
            java.lang.String r4 = "Abort requested before buffering finished. "
            r0.<init>(r4)     // Catch:{ all -> 0x01c9 }
            throw r0     // Catch:{ all -> 0x01c9 }
        L_0x01a2:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r3 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c9 }
            r8 = 47
            r4.<init>(r8)     // Catch:{ all -> 0x01c9 }
            java.lang.String r8 = "Timeout reached. Limit: "
            r4.append(r8)     // Catch:{ all -> 0x01c9 }
            r8 = r40
            r4.append(r8)     // Catch:{ all -> 0x01c9 }
            java.lang.String r8 = " ms"
            r4.append(r8)     // Catch:{ all -> 0x01c9 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01c9 }
            r0.<init>(r4)     // Catch:{ all -> 0x01c9 }
            throw r0     // Catch:{ all -> 0x01c9 }
        L_0x01c9:
            r0 = move-exception
            r17 = r3
            goto L_0x01d3
        L_0x01cd:
            r0 = move-exception
            goto L_0x01d3
        L_0x01cf:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d3:
            r15 = r5
        L_0x01d4:
            r14 = r7
        L_0x01d5:
            monitor-exit(r15)     // Catch:{ all -> 0x01db }
            throw r0     // Catch:{ Exception -> 0x01d7 }
        L_0x01d7:
            r0 = move-exception
            r3 = r17
            goto L_0x01ee
        L_0x01db:
            r0 = move-exception
            goto L_0x01d5
        L_0x01dd:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
            r13 = r1
            r15 = r2
            goto L_0x01e8
        L_0x01e4:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01e8:
            r14 = r7
            r1 = r13
            r2 = r15
            r3 = r17
            r15 = r5
        L_0x01ee:
            java.lang.String r4 = r0.getMessage()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r6 = r6.length()
            java.lang.String r7 = java.lang.String.valueOf(r4)
            int r7 = r7.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r6 = r6 + 34
            int r6 = r6 + r7
            r8.<init>(r6)
            java.lang.String r6 = "Failed to preload url "
            r8.append(r6)
            r8.append(r1)
            java.lang.String r6 = " Exception: "
            r8.append(r6)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            com.google.android.gms.internal.ads.zzcgs.zzi(r4)
            r15.release()
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            int r6 = r3.length()
            java.lang.String r7 = java.lang.String.valueOf(r4)
            int r7 = r7.length()
            java.lang.String r8 = java.lang.String.valueOf(r0)
            int r8 = r8.length()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r10 = 2
            int r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r6, r10, r7, r8)
            r9.<init>(r6)
            java.lang.String r6 = "/"
            java.lang.String r7 = ":"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r9, r3, r6, r4, r7)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r2.zzn(r1, r14, r3, r0)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclf.zzb(java.lang.String, java.lang.String[]):boolean");
    }

    public final void zzc(int i) {
        this.zze.zzae(i);
    }

    public final void zzd(int i) {
        this.zze.zzad(i);
    }

    public final void zze(int i) {
        this.zze.zzV(i);
    }

    public final void zzf(int i) {
        this.zze.zzW(i);
    }

    public final void zzg() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzn(this.zzf, zzk(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    public final zzciq zzj() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzP((zzcip) null);
        zzciq zzciq = this.zze;
        this.zze = null;
        return zzciq;
    }

    public final void zzr(boolean z, long j) {
        zzciz zzciz = (zzciz) this.zzc.get();
        if (zzciz != null) {
            zzche.zze.execute(new zzcle(zzciz, z, j));
        }
    }

    public final void zzs(int i) {
    }

    public final void zzt(int i, int i2) {
    }

    public final void zzu(String str, Exception exc) {
        zzcgs.zzj("Precache error", exc);
    }

    public final void zzv(String str, Exception exc) {
        zzcgs.zzj("Precache exception", exc);
    }
}
