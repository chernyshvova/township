package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcld extends zzckx implements zzauk<zzatv> {
    public String zzd;
    public final zzciy zze;
    public boolean zzf;
    public final zzclc zzg = new zzclc();
    public final zzckj zzh = new zzckj();
    public ByteBuffer zzi;
    public boolean zzj;
    public final Object zzk = new Object();
    public final String zzl;
    public final int zzm;
    public boolean zzn;

    public zzcld(zzciz zzciz, zzciy zzciy) {
        super(zzciz);
        this.zze = zzciy;
        this.zzl = zzciz != null ? zzciz.zzn() : "";
        this.zzm = zzciz != null ? zzciz.zzp() : 0;
    }

    public static final String zzs(String str) {
        String valueOf = String.valueOf(zzcgl.zzd(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    private final void zzt() {
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round((((float) position) / ((float) zza)) * ((float) zza2));
        boolean z = round > 0;
        int zzan = zzciq.zzan();
        int zzao = zzciq.zzao();
        String str = this.zzd;
        zzi(str, zzs(str), position, zza, (long) round, (long) zza2, z, zzan, zzao);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.google.android.gms.internal.ads.zzatz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: com.google.android.gms.internal.ads.zzatz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.google.android.gms.internal.ads.zzcjv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: com.google.android.gms.internal.ads.zzatz} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0155, code lost:
        r0 = th;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r26) {
        /*
            r25 = this;
            r9 = r25
            r10 = r26
            r9.zzd = r10
            java.lang.String r11 = zzs(r26)
            java.lang.String r12 = "error"
            r0 = 0
            com.google.android.gms.internal.ads.zzatz r13 = new com.google.android.gms.internal.ads.zzatz     // Catch:{ Exception -> 0x0157 }
            java.lang.String r2 = r9.zzb     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzciy r1 = r9.zze     // Catch:{ Exception -> 0x0157 }
            int r5 = r1.zzd     // Catch:{ Exception -> 0x0157 }
            r3 = 0
            int r6 = r1.zzf     // Catch:{ Exception -> 0x0157 }
            r7 = 1
            r8 = 0
            r1 = r13
            r4 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzciy r1 = r9.zze     // Catch:{ Exception -> 0x0157 }
            boolean r1 = r1.zzj     // Catch:{ Exception -> 0x0157 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzcjv r8 = new com.google.android.gms.internal.ads.zzcjv     // Catch:{ Exception -> 0x0157 }
            android.content.Context r2 = r9.zza     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = r9.zzl     // Catch:{ Exception -> 0x0157 }
            int r5 = r9.zzm     // Catch:{ Exception -> 0x0157 }
            r6 = 0
            r7 = 0
            r1 = r8
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0157 }
            r13 = r8
        L_0x0036:
            android.net.Uri r15 = android.net.Uri.parse(r26)     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzatx r1 = new com.google.android.gms.internal.ads.zzatx     // Catch:{ Exception -> 0x0157 }
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = -1
            r23 = 0
            r24 = 0
            r14 = r1
            r14.<init>(r15, r16, r17, r19, r21, r23, r24)     // Catch:{ Exception -> 0x0157 }
            r13.zza(r1)     // Catch:{ Exception -> 0x0157 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzciz> r1 = r9.zzc     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzciz r1 = (com.google.android.gms.internal.ads.zzciz) r1     // Catch:{ Exception -> 0x0157 }
            if (r1 == 0) goto L_0x005c
            r1.zzu(r11, r9)     // Catch:{ Exception -> 0x0157 }
        L_0x005c:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ Exception -> 0x0157 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzbjn.zzt     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzbjl r5 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0157 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzbjn.zzs     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzbjl r7 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ Exception -> 0x0157 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0157 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0157 }
            com.google.android.gms.internal.ads.zzciy r8 = r9.zze     // Catch:{ Exception -> 0x0157 }
            int r8 = r8.zzc     // Catch:{ Exception -> 0x0157 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0157 }
            r9.zzi = r8     // Catch:{ Exception -> 0x0157 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r14 = new byte[r8]     // Catch:{ Exception -> 0x0157 }
            r15 = r2
            r17 = r12
        L_0x0095:
            java.nio.ByteBuffer r12 = r9.zzi     // Catch:{ Exception -> 0x0142 }
            int r12 = r12.remaining()     // Catch:{ Exception -> 0x0142 }
            int r8 = java.lang.Math.min(r12, r8)     // Catch:{ Exception -> 0x0142 }
            int r0 = r13.zzb(r14, r0, r8)     // Catch:{ Exception -> 0x0142 }
            r8 = -1
            if (r0 != r8) goto L_0x00b7
            r0 = 1
            r9.zzn = r0     // Catch:{ Exception -> 0x0142 }
            com.google.android.gms.internal.ads.zzckj r0 = r9.zzh     // Catch:{ Exception -> 0x0142 }
            java.nio.ByteBuffer r1 = r9.zzi     // Catch:{ Exception -> 0x0142 }
            long r0 = r0.zza(r1)     // Catch:{ Exception -> 0x0142 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0142 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0142 }
            r9.zzm(r10, r11, r0)     // Catch:{ Exception -> 0x0142 }
            goto L_0x00d0
        L_0x00b7:
            java.lang.Object r8 = r9.zzk     // Catch:{ Exception -> 0x0142 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0142 }
            boolean r12 = r9.zzf     // Catch:{ all -> 0x014a }
            if (r12 != 0) goto L_0x00c4
            java.nio.ByteBuffer r12 = r9.zzi     // Catch:{ all -> 0x014a }
            r10 = 0
            r12.put(r14, r10, r0)     // Catch:{ all -> 0x014a }
        L_0x00c4:
            monitor-exit(r8)     // Catch:{ all -> 0x014a }
            java.nio.ByteBuffer r0 = r9.zzi     // Catch:{ Exception -> 0x0142 }
            int r0 = r0.remaining()     // Catch:{ Exception -> 0x0142 }
            if (r0 > 0) goto L_0x00d2
            r25.zzt()     // Catch:{ Exception -> 0x0142 }
        L_0x00d0:
            r0 = 1
            return r0
        L_0x00d2:
            boolean r0 = r9.zzf     // Catch:{ Exception -> 0x0142 }
            if (r0 != 0) goto L_0x0115
            long r18 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0142 }
            long r20 = r18 - r15
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x00e5
            r25.zzt()     // Catch:{ Exception -> 0x0142 }
            r15 = r18
        L_0x00e5:
            long r18 = r18 - r2
            r20 = 1000(0x3e8, double:4.94E-321)
            long r20 = r20 * r6
            int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r0 > 0) goto L_0x00f5
            r8 = 8192(0x2000, float:1.14794E-41)
            r0 = 0
            r10 = r26
            goto L_0x0095
        L_0x00f5:
            java.lang.String r1 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013b }
            r2 = 49
            r0.<init>(r2)     // Catch:{ Exception -> 0x013b }
            java.lang.String r2 = "Timeout exceeded. Limit: "
            r0.append(r2)     // Catch:{ Exception -> 0x013b }
            r0.append(r6)     // Catch:{ Exception -> 0x013b }
            java.lang.String r2 = " sec"
            r0.append(r2)     // Catch:{ Exception -> 0x013b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x013b }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ Exception -> 0x013b }
            r2.<init>(r0)     // Catch:{ Exception -> 0x013b }
            throw r2     // Catch:{ Exception -> 0x013b }
        L_0x0115:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x013b }
            java.nio.ByteBuffer r2 = r9.zzi     // Catch:{ Exception -> 0x013b }
            int r2 = r2.limit()     // Catch:{ Exception -> 0x013b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013b }
            r4 = 35
            r3.<init>(r4)     // Catch:{ Exception -> 0x013b }
            java.lang.String r4 = "Precache abort at "
            r3.append(r4)     // Catch:{ Exception -> 0x013b }
            r3.append(r2)     // Catch:{ Exception -> 0x013b }
            java.lang.String r2 = " bytes"
            r3.append(r2)     // Catch:{ Exception -> 0x013b }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x013b }
            r0.<init>(r2)     // Catch:{ Exception -> 0x013b }
            throw r0     // Catch:{ Exception -> 0x013b }
        L_0x013b:
            r0 = move-exception
            r2 = r26
            r12 = r1
            r3 = r9
            r1 = r2
            goto L_0x015b
        L_0x0142:
            r0 = move-exception
        L_0x0143:
            r1 = r26
            r2 = r1
            r3 = r9
            r12 = r17
            goto L_0x015b
        L_0x014a:
            r0 = move-exception
            r1 = r26
            r2 = r1
            r3 = r9
            r12 = r17
        L_0x0151:
            monitor-exit(r8)     // Catch:{ all -> 0x0155 }
            throw r0     // Catch:{ Exception -> 0x0153 }
        L_0x0153:
            r0 = move-exception
            goto L_0x015b
        L_0x0155:
            r0 = move-exception
            goto L_0x0151
        L_0x0157:
            r0 = move-exception
            r17 = r12
            goto L_0x0143
        L_0x015b:
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            int r6 = r6.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r5 = r5 + 1
            int r5 = r5 + r6
            r7.<init>(r5)
            java.lang.String r5 = ":"
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline19(r7, r4, r5, r0)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r2 = r2.length()
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = r2 + 34
            int r2 = r2 + r4
            r5.<init>(r2)
            java.lang.String r2 = "Failed to preload url "
            r5.append(r2)
            r5.append(r1)
            java.lang.String r2 = " Exception: "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r2 = r5.toString()
            com.google.android.gms.internal.ads.zzcgs.zzi(r2)
            r3.zzn(r1, r11, r12, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcld.zza(java.lang.String):boolean");
    }

    public final void zzg() {
        this.zzf = true;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, zzatx zzatx) {
        this.zzg.zzb((zzatz) obj);
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i) {
    }

    public final String zzp() {
        return this.zzd;
    }

    public final boolean zzq() {
        return this.zzn;
    }

    public final ByteBuffer zzr() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }
}
