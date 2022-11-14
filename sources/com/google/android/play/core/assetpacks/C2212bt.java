package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2315ck;
import java.io.File;

/* renamed from: com.google.android.play.core.assetpacks.bt */
public final class C2212bt {

    /* renamed from: a */
    public static final C2292ag f3011a = new C2292ag("ExtractChunkTaskHandler");

    /* renamed from: b */
    public final byte[] f3012b = new byte[8192];

    /* renamed from: c */
    public final C2198bb f3013c;

    /* renamed from: d */
    public final C2315ck<C2281w> f3014d;

    /* renamed from: e */
    public final C2315ck<C2192aw> f3015e;

    /* renamed from: f */
    public final C2218bz f3016f;

    public C2212bt(C2198bb bbVar, C2315ck<C2281w> ckVar, C2315ck<C2192aw> ckVar2, C2218bz bzVar) {
        this.f3013c = bbVar;
        this.f3014d = ckVar;
        this.f3015e = ckVar2;
        this.f3016f = bzVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0271, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r6 = r5.length();
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013a, code lost:
        if (r8 == r3) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013c, code lost:
        f3011a.mo33278a(3, "Chunk has ended while resuming the previous chunks file content.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014b, code lost:
        r7 = r14;
        r14 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r3.mo33246a(r4.getCanonicalPath(), r6, r7, r2.f3006e);
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x027d A[SYNTHETIC, Splitter:B:106:0x027d] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0346 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0187 A[Catch:{ all -> 0x0271 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a8 A[Catch:{ all -> 0x0271 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d8 A[Catch:{ all -> 0x0271 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo33209a(com.google.android.play.core.assetpacks.C2211bs r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            com.google.android.play.core.assetpacks.dr r0 = new com.google.android.play.core.assetpacks.dr
            com.google.android.play.core.assetpacks.bb r4 = r1.f3013c
            java.lang.String r5 = r2.f3089k
            int r6 = r2.f3002a
            long r7 = r2.f3003b
            java.lang.String r9 = r2.f3004c
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)
            com.google.android.play.core.assetpacks.bb r10 = r1.f3013c
            java.lang.String r11 = r2.f3089k
            int r12 = r2.f3002a
            long r13 = r2.f3003b
            java.lang.String r15 = r2.f3004c
            java.io.File r3 = r10.mo33184f(r11, r12, r13, r15)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x002b
            r3.mkdirs()
        L_0x002b:
            r10 = 2
            r11 = 1
            r12 = 3
            r13 = 0
            java.io.InputStream r3 = r2.f3010i     // Catch:{ IOException -> 0x0356 }
            int r4 = r2.f3005d     // Catch:{ IOException -> 0x0356 }
            if (r4 == r11) goto L_0x0037
            r9 = r3
            goto L_0x0040
        L_0x0037:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0356 }
            byte[] r5 = r1.f3012b     // Catch:{ IOException -> 0x0356 }
            int r5 = r5.length     // Catch:{ IOException -> 0x0356 }
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x0356 }
            r9 = r4
        L_0x0040:
            int r3 = r2.f3006e     // Catch:{ all -> 0x0347 }
            r16 = 0
            if (r3 <= 0) goto L_0x0183
            com.google.android.play.core.assetpacks.dq r3 = r0.mo33242a()     // Catch:{ all -> 0x0347 }
            int r4 = r3.f3169e     // Catch:{ all -> 0x0347 }
            int r5 = r2.f3006e     // Catch:{ all -> 0x0347 }
            int r6 = r5 + -1
            if (r4 != r6) goto L_0x0164
            int r4 = r3.f3165a     // Catch:{ all -> 0x0347 }
            if (r4 == r11) goto L_0x00de
            if (r4 == r10) goto L_0x0093
            if (r4 != r12) goto L_0x007b
            com.google.android.play.core.internal.ag r4 = f3011a     // Catch:{ all -> 0x00dc }
            java.lang.String r5 = "Resuming central directory from last chunk."
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ all -> 0x00dc }
            r4.mo33278a((int) r12, (java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x00dc }
            long r3 = r3.f3167c     // Catch:{ all -> 0x00dc }
            r0.mo33245a((java.io.InputStream) r9, (long) r3)     // Catch:{ all -> 0x00dc }
            boolean r3 = r24.mo33208a()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x0071
            r14 = r9
            goto L_0x0156
        L_0x0071:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB."
            int r4 = r2.f3088j     // Catch:{ all -> 0x00dc }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x00dc }
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x007b:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r4 = new java.lang.Object[r11]     // Catch:{ all -> 0x00dc }
            int r3 = r3.f3165a     // Catch:{ all -> 0x00dc }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00dc }
            r4[r13] = r3     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s."
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x00dc }
            int r4 = r2.f3088j     // Catch:{ all -> 0x00dc }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x00dc }
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x0093:
            com.google.android.play.core.internal.ag r3 = f3011a     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "Resuming zip entry from last chunk during local file header."
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x00dc }
            r3.mo33278a((int) r12, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x00dc }
            com.google.android.play.core.assetpacks.bb r3 = r1.f3013c     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r2.f3089k     // Catch:{ all -> 0x00dc }
            int r5 = r2.f3002a     // Catch:{ all -> 0x00dc }
            long r6 = r2.f3003b     // Catch:{ all -> 0x00dc }
            java.lang.String r8 = r2.f3004c     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x00db
            java.io.File r15 = new java.io.File     // Catch:{ all -> 0x00dc }
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r22 = r8
            java.io.File r3 = r17.mo33184f(r18, r19, r20, r22)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "checkpoint_ext.dat"
            r15.<init>(r3, r4)     // Catch:{ all -> 0x00dc }
            boolean r3 = r15.exists()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x00d1
            java.io.SequenceInputStream r3 = new java.io.SequenceInputStream     // Catch:{ all -> 0x00dc }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x00dc }
            r4.<init>(r15)     // Catch:{ all -> 0x00dc }
            r3.<init>(r4, r9)     // Catch:{ all -> 0x00dc }
            r14 = r9
            r9 = r3
            goto L_0x0185
        L_0x00d1:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "Checkpoint extension file not found."
            int r4 = r2.f3088j     // Catch:{ all -> 0x00dc }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x00dc }
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x00db:
            throw r16     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r0 = move-exception
            goto L_0x0121
        L_0x00de:
            com.google.android.play.core.internal.ag r4 = f3011a     // Catch:{ all -> 0x0347 }
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = r3.f3166b     // Catch:{ all -> 0x0347 }
            r5[r13] = r6     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = "Resuming zip entry from last chunk during file %s."
            r4.mo33278a((int) r12, (java.lang.String) r6, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0347 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0347 }
            java.lang.String r5 = r3.f3166b     // Catch:{ all -> 0x0347 }
            r4.<init>(r5)     // Catch:{ all -> 0x0347 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0347 }
            if (r5 == 0) goto L_0x0159
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ all -> 0x0347 }
            long r6 = r3.f3167c     // Catch:{ all -> 0x0347 }
            r5.seek(r6)     // Catch:{ all -> 0x0347 }
            long r6 = r3.f3168d     // Catch:{ all -> 0x0347 }
        L_0x0106:
            byte[] r3 = r1.f3012b     // Catch:{ all -> 0x0347 }
            int r3 = r3.length     // Catch:{ all -> 0x0347 }
            long r14 = (long) r3     // Catch:{ all -> 0x0347 }
            long r14 = java.lang.Math.min(r6, r14)     // Catch:{ all -> 0x0347 }
            int r3 = (int) r14     // Catch:{ all -> 0x0347 }
            byte[] r8 = r1.f3012b     // Catch:{ all -> 0x0347 }
            int r8 = r9.read(r8, r13, r3)     // Catch:{ all -> 0x0347 }
            int r8 = java.lang.Math.max(r8, r13)     // Catch:{ all -> 0x0347 }
            if (r8 <= 0) goto L_0x0125
            byte[] r14 = r1.f3012b     // Catch:{ all -> 0x00dc }
            r5.write(r14, r13, r8)     // Catch:{ all -> 0x00dc }
            goto L_0x0125
        L_0x0121:
            r3 = r0
            r14 = r9
            goto L_0x034a
        L_0x0125:
            long r14 = (long) r8
            long r14 = r6 - r14
            r6 = 0
            int r18 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r18 <= 0) goto L_0x0133
            if (r8 > 0) goto L_0x0131
            goto L_0x0133
        L_0x0131:
            r6 = r14
            goto L_0x0106
        L_0x0133:
            long r6 = r5.length()     // Catch:{ all -> 0x0347 }
            r5.close()     // Catch:{ all -> 0x0347 }
            if (r8 == r3) goto L_0x0183
            com.google.android.play.core.internal.ag r3 = f3011a     // Catch:{ all -> 0x0347 }
            java.lang.String r5 = "Chunk has ended while resuming the previous chunks file content."
            java.lang.Object[] r8 = new java.lang.Object[r13]     // Catch:{ all -> 0x0347 }
            r3.mo33278a((int) r12, (java.lang.String) r5, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0347 }
            int r8 = r2.f3006e     // Catch:{ all -> 0x0347 }
            r3 = r0
            r5 = r6
            r18 = r8
            r7 = r14
            r14 = r9
            r9 = r18
            r3.mo33246a((java.lang.String) r4, (long) r5, (long) r7, (int) r9)     // Catch:{ all -> 0x0271 }
        L_0x0156:
            r9 = r16
            goto L_0x0185
        L_0x0159:
            r14 = r9
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0271 }
            java.lang.String r3 = "Partial file specified in checkpoint does not exist. Corrupt directory."
            int r4 = r2.f3088j     // Catch:{ all -> 0x0271 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x0164:
            r14 = r9
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0271 }
            java.lang.String r4 = "Trying to resume with chunk number %s when previously processed chunk was number %s."
            java.lang.Object[] r6 = new java.lang.Object[r10]     // Catch:{ all -> 0x0271 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0271 }
            r6[r13] = r5     // Catch:{ all -> 0x0271 }
            int r3 = r3.f3169e     // Catch:{ all -> 0x0271 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0271 }
            r6[r11] = r3     // Catch:{ all -> 0x0271 }
            java.lang.String r3 = java.lang.String.format(r4, r6)     // Catch:{ all -> 0x0271 }
            int r4 = r2.f3088j     // Catch:{ all -> 0x0271 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x0183:
            r14 = r9
            r9 = r14
        L_0x0185:
            if (r9 == 0) goto L_0x0274
            com.google.android.play.core.assetpacks.bm r3 = new com.google.android.play.core.assetpacks.bm     // Catch:{ all -> 0x0271 }
            r3.<init>(r9)     // Catch:{ all -> 0x0271 }
            java.io.File r4 = r23.mo33210b(r24)     // Catch:{ all -> 0x0271 }
        L_0x0190:
            com.google.android.play.core.assetpacks.dx r5 = r3.mo33204a()     // Catch:{ all -> 0x0271 }
            boolean r6 = r5.f3190d     // Catch:{ all -> 0x0271 }
            if (r6 != 0) goto L_0x01dd
            boolean r6 = r3.f2974e     // Catch:{ all -> 0x0271 }
            if (r6 != 0) goto L_0x01dd
            boolean r6 = r5.mo33260b()     // Catch:{ all -> 0x0271 }
            if (r6 == 0) goto L_0x01d8
            boolean r6 = r5.mo33259a()     // Catch:{ all -> 0x0271 }
            if (r6 != 0) goto L_0x01d8
            byte[] r6 = r5.f3192f     // Catch:{ all -> 0x0271 }
            r0.mo33247a((byte[]) r6)     // Catch:{ all -> 0x0271 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0271 }
            java.lang.String r7 = r5.f3187a     // Catch:{ all -> 0x0271 }
            r6.<init>(r4, r7)     // Catch:{ all -> 0x0271 }
            java.io.File r7 = r6.getParentFile()     // Catch:{ all -> 0x0271 }
            r7.mkdirs()     // Catch:{ all -> 0x0271 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0271 }
            r7.<init>(r6)     // Catch:{ all -> 0x0271 }
            byte[] r6 = r1.f3012b     // Catch:{ all -> 0x0271 }
            int r6 = r3.read(r6)     // Catch:{ all -> 0x0271 }
        L_0x01c6:
            if (r6 <= 0) goto L_0x01d4
            byte[] r8 = r1.f3012b     // Catch:{ all -> 0x0271 }
            r7.write(r8, r13, r6)     // Catch:{ all -> 0x0271 }
            byte[] r6 = r1.f3012b     // Catch:{ all -> 0x0271 }
            int r6 = r3.read(r6)     // Catch:{ all -> 0x0271 }
            goto L_0x01c6
        L_0x01d4:
            r7.close()     // Catch:{ all -> 0x0271 }
            goto L_0x01dd
        L_0x01d8:
            byte[] r6 = r5.f3192f     // Catch:{ all -> 0x0271 }
            r0.mo33249a((byte[]) r6, (java.io.InputStream) r3)     // Catch:{ all -> 0x0271 }
        L_0x01dd:
            boolean r6 = r3.f2973d     // Catch:{ all -> 0x0271 }
            if (r6 != 0) goto L_0x01e5
            boolean r6 = r3.f2974e     // Catch:{ all -> 0x0271 }
            if (r6 == 0) goto L_0x0190
        L_0x01e5:
            boolean r4 = r3.f2974e     // Catch:{ all -> 0x0271 }
            if (r4 == 0) goto L_0x01f7
            com.google.android.play.core.internal.ag r4 = f3011a     // Catch:{ all -> 0x0271 }
            java.lang.String r6 = "Writing central directory metadata."
            java.lang.Object[] r7 = new java.lang.Object[r13]     // Catch:{ all -> 0x0271 }
            r4.mo33278a((int) r12, (java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x0271 }
            byte[] r4 = r5.f3192f     // Catch:{ all -> 0x0271 }
            r0.mo33249a((byte[]) r4, (java.io.InputStream) r9)     // Catch:{ all -> 0x0271 }
        L_0x01f7:
            boolean r4 = r24.mo33208a()     // Catch:{ all -> 0x0271 }
            if (r4 != 0) goto L_0x0274
            boolean r4 = r5.f3190d     // Catch:{ all -> 0x0271 }
            if (r4 == 0) goto L_0x0212
            com.google.android.play.core.internal.ag r3 = f3011a     // Catch:{ all -> 0x0271 }
            java.lang.String r4 = "Writing slice checkpoint for partial local file header."
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ all -> 0x0271 }
            r3.mo33278a((int) r12, (java.lang.String) r4, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0271 }
            byte[] r3 = r5.f3192f     // Catch:{ all -> 0x0271 }
            int r4 = r2.f3006e     // Catch:{ all -> 0x0271 }
            r0.mo33248a((byte[]) r3, (int) r4)     // Catch:{ all -> 0x0271 }
            goto L_0x0274
        L_0x0212:
            boolean r4 = r3.f2974e     // Catch:{ all -> 0x0271 }
            if (r4 == 0) goto L_0x0225
            com.google.android.play.core.internal.ag r3 = f3011a     // Catch:{ all -> 0x0271 }
            java.lang.String r4 = "Writing slice checkpoint for central directory."
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x0271 }
            r3.mo33278a((int) r12, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0271 }
            int r3 = r2.f3006e     // Catch:{ all -> 0x0271 }
            r0.mo33243a((int) r3)     // Catch:{ all -> 0x0271 }
            goto L_0x0274
        L_0x0225:
            int r4 = r5.f3189c     // Catch:{ all -> 0x0271 }
            if (r4 != 0) goto L_0x0253
            com.google.android.play.core.internal.ag r4 = f3011a     // Catch:{ all -> 0x0271 }
            java.lang.String r6 = "Writing slice checkpoint for partial file."
            java.lang.Object[] r7 = new java.lang.Object[r13]     // Catch:{ all -> 0x0271 }
            r4.mo33278a((int) r12, (java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x0271 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0271 }
            java.io.File r6 = r23.mo33210b(r24)     // Catch:{ all -> 0x0271 }
            java.lang.String r7 = r5.f3187a     // Catch:{ all -> 0x0271 }
            r4.<init>(r6, r7)     // Catch:{ all -> 0x0271 }
            long r5 = r5.f3188b     // Catch:{ all -> 0x0271 }
            long r7 = r3.f2972c     // Catch:{ all -> 0x0271 }
            long r5 = r5 - r7
            long r7 = r4.length()     // Catch:{ all -> 0x0271 }
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x024b
            goto L_0x0264
        L_0x024b:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0271 }
            java.lang.String r3 = "Partial file is of unexpected size."
            r0.<init>(r3)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x0253:
            com.google.android.play.core.internal.ag r4 = f3011a     // Catch:{ all -> 0x0271 }
            java.lang.String r5 = "Writing slice checkpoint for partial unextractable file."
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ all -> 0x0271 }
            r4.mo33278a((int) r12, (java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0271 }
            java.io.File r4 = r0.mo33250b()     // Catch:{ all -> 0x0271 }
            long r5 = r4.length()     // Catch:{ all -> 0x0271 }
        L_0x0264:
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0271 }
            long r7 = r3.f2972c     // Catch:{ all -> 0x0271 }
            int r9 = r2.f3006e     // Catch:{ all -> 0x0271 }
            r3 = r0
            r3.mo33246a((java.lang.String) r4, (long) r5, (long) r7, (int) r9)     // Catch:{ all -> 0x0271 }
            goto L_0x0274
        L_0x0271:
            r0 = move-exception
            goto L_0x0349
        L_0x0274:
            r14.close()     // Catch:{ IOException -> 0x0356 }
            boolean r3 = r24.mo33208a()
            if (r3 == 0) goto L_0x029e
            int r3 = r2.f3006e     // Catch:{ IOException -> 0x0283 }
            r0.mo33251b(r3)     // Catch:{ IOException -> 0x0283 }
            goto L_0x029e
        L_0x0283:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = f3011a
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.String r5 = r0.getMessage()
            r4[r13] = r5
            java.lang.String r5 = "Writing extraction finished checkpoint failed with %s."
            r6 = 6
            r3.mo33278a((int) r6, (java.lang.String) r5, (java.lang.Object[]) r4)
            com.google.android.play.core.assetpacks.bv r3 = new com.google.android.play.core.assetpacks.bv
            java.lang.String r4 = "Writing extraction finished checkpoint failed."
            int r2 = r2.f3088j
            r3.<init>(r4, r0, r2)
            throw r3
        L_0x029e:
            com.google.android.play.core.internal.ag r0 = f3011a
            r3 = 4
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r3 = r2.f3006e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r13] = r3
            java.lang.String r3 = r2.f3004c
            r4[r11] = r3
            java.lang.String r3 = r2.f3089k
            r4[r10] = r3
            int r3 = r2.f3088j
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r12] = r3
            java.lang.String r3 = "Extraction finished for chunk %s of slice %s of pack %s of session %s."
            r5 = 4
            r0.mo33278a((int) r5, (java.lang.String) r3, (java.lang.Object[]) r4)
            com.google.android.play.core.internal.ck<com.google.android.play.core.assetpacks.w> r0 = r1.f3014d
            java.lang.Object r0 = r0.mo33293a()
            com.google.android.play.core.assetpacks.w r0 = (com.google.android.play.core.assetpacks.C2281w) r0
            int r3 = r2.f3088j
            java.lang.String r4 = r2.f3089k
            java.lang.String r5 = r2.f3004c
            int r6 = r2.f3006e
            r0.mo33164a(r3, r4, r5, r6)
            java.io.InputStream r0 = r2.f3010i     // Catch:{ IOException -> 0x02da }
            r0.close()     // Catch:{ IOException -> 0x02da }
            goto L_0x02f4
        L_0x02da:
            com.google.android.play.core.internal.ag r0 = f3011a
            java.lang.Object[] r3 = new java.lang.Object[r12]
            int r4 = r2.f3006e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r13] = r4
            java.lang.String r4 = r2.f3004c
            r3[r11] = r4
            java.lang.String r4 = r2.f3089k
            r3[r10] = r4
            java.lang.String r4 = "Could not close file for chunk %s of slice %s of pack %s."
            r5 = 5
            r0.mo33278a((int) r5, (java.lang.String) r4, (java.lang.Object[]) r3)
        L_0x02f4:
            int r0 = r2.f3009h
            if (r0 != r12) goto L_0x0346
            com.google.android.play.core.internal.ck<com.google.android.play.core.assetpacks.aw> r0 = r1.f3015e
            java.lang.Object r0 = r0.mo33293a()
            com.google.android.play.core.assetpacks.aw r0 = (com.google.android.play.core.assetpacks.C2192aw) r0
            java.lang.String r3 = r2.f3089k
            long r7 = r2.f3008g
            r4 = 3
            r5 = 0
            com.google.android.play.core.assetpacks.bz r6 = r1.f3016f
            monitor-enter(r6)
            int r9 = r2.f3006e     // Catch:{ all -> 0x0343 }
            double r9 = (double) r9
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r9)
            java.lang.Double.isNaN(r9)
            java.lang.Double.isNaN(r9)
            double r9 = r9 + r11
            int r2 = r2.f3007f     // Catch:{ all -> 0x0343 }
            double r11 = (double) r2
            java.lang.Double.isNaN(r11)
            java.lang.Double.isNaN(r11)
            java.lang.Double.isNaN(r11)
            double r9 = r9 / r11
            java.util.Map<java.lang.String, java.lang.Double> r2 = r6.f3047a     // Catch:{ all -> 0x0343 }
            java.lang.Double r11 = java.lang.Double.valueOf(r9)     // Catch:{ all -> 0x0343 }
            r2.put(r3, r11)     // Catch:{ all -> 0x0343 }
            monitor-exit(r6)
            r11 = 1
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            com.google.android.play.core.assetpacks.AssetPackState r2 = com.google.android.play.core.assetpacks.AssetPackState.m2821a(r2, r3, r4, r5, r7, r9, r11)
            android.os.Handler r3 = r0.f2932k
            com.google.android.play.core.assetpacks.at r4 = new com.google.android.play.core.assetpacks.at
            r4.<init>(r0, r2)
            r3.post(r4)
            return
        L_0x0343:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0346:
            return
        L_0x0347:
            r0 = move-exception
            r14 = r9
        L_0x0349:
            r3 = r0
        L_0x034a:
            r14.close()     // Catch:{ all -> 0x034e }
            goto L_0x0355
        L_0x034e:
            r0 = move-exception
            r4 = r0
            com.google.android.play.core.internal.cd r0 = com.google.android.play.core.internal.C2314cj.f3259a     // Catch:{ IOException -> 0x0356 }
            r0.mo33290a(r3, r4)     // Catch:{ IOException -> 0x0356 }
        L_0x0355:
            throw r3     // Catch:{ IOException -> 0x0356 }
        L_0x0356:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = f3011a
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.String r5 = r0.getMessage()
            r4[r13] = r5
            java.lang.String r5 = "IOException during extraction %s."
            r6 = 6
            r3.mo33278a((int) r6, (java.lang.String) r5, (java.lang.Object[]) r4)
            com.google.android.play.core.assetpacks.bv r3 = new com.google.android.play.core.assetpacks.bv
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r2.f3006e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r13] = r5
            java.lang.String r5 = r2.f3004c
            r4[r11] = r5
            java.lang.String r5 = r2.f3089k
            r4[r10] = r5
            int r5 = r2.f3088j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r12] = r5
            java.lang.String r5 = "Error extracting chunk %s of slice %s of pack %s of session %s."
            java.lang.String r4 = java.lang.String.format(r5, r4)
            int r2 = r2.f3088j
            r3.<init>(r4, r0, r2)
            goto L_0x0391
        L_0x0390:
            throw r3
        L_0x0391:
            goto L_0x0390
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2212bt.mo33209a(com.google.android.play.core.assetpacks.bs):void");
    }

    /* renamed from: b */
    public final File mo33210b(C2211bs bsVar) {
        File a = this.f3013c.mo33175a(bsVar.f3089k, bsVar.f3002a, bsVar.f3003b, bsVar.f3004c);
        if (!a.exists()) {
            a.mkdirs();
        }
        return a;
    }
}
