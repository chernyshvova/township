package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2292ag;

/* renamed from: com.google.android.play.core.assetpacks.cs */
public final class C2235cs {

    /* renamed from: a */
    public static final C2292ag f3090a = new C2292ag("ExtractorTaskFinder");

    /* renamed from: b */
    public final C2232cp f3091b;

    /* renamed from: c */
    public final C2198bb f3092c;

    /* renamed from: d */
    public final C2204bk f3093d;

    public C2235cs(C2232cp cpVar, C2198bb bbVar, C2204bk bkVar) {
        this.f3091b = cpVar;
        this.f3092c = bbVar;
        this.f3093d = bkVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.play.core.assetpacks.cr] */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x042b, code lost:
        if (r0 != null) goto L_0x042d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        f3090a.mo33278a(3, "Found final move task for session %s with pack %s.", new java.lang.Object[]{java.lang.Integer.valueOf(r4.f3069a), r4.f3071c.f3064a});
        r12 = r4.f3069a;
        r9 = r4.f3071c;
        r11 = new com.google.android.play.core.assetpacks.C2247dh(r12, r9.f3064a, r4.f3070b, r9.f3065b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0224, code lost:
        r0 = f3090a;
        r4 = new java.lang.Object[r5];
        r4[r7] = java.lang.Integer.valueOf(r9.f3069a);
        r4[1] = r9.f3071c.f3064a;
        r4[r6] = r11.f3072a;
        r0.mo33278a(r5, "Found extraction task for patch for session %s, pack %s, slice %s.", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r4 = r1.f3092c;
        r10 = r9.f3071c;
        r0 = new java.io.FileInputStream(r4.mo33182e(r10.f3064a, r9.f3070b, r10.f3065b, r11.f3072a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r10 = r9.f3069a;
        r12 = r9.f3071c;
        r18 = new com.google.android.play.core.assetpacks.C2211bs(r10, r12.f3064a, r9.f3070b, r12.f3065b, r11.f3072a, 0, 0, 1, r12.f3067d, r12.f3066c, r0);
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03bc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x038f A[LOOP:9: B:99:0x038f->B:157:0x038f, LOOP_END, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x021e A[Catch:{ FileNotFoundException -> 0x028e, IOException -> 0x0090, all -> 0x0445 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02b4 A[Catch:{ FileNotFoundException -> 0x028e, IOException -> 0x0090, all -> 0x0445 }] */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.C2234cr mo33219a() {
        /*
            r32 = this;
            r1 = r32
            com.google.android.play.core.assetpacks.cp r0 = r1.f3091b     // Catch:{ all -> 0x0445 }
            java.util.concurrent.locks.ReentrantLock r0 = r0.f3083g     // Catch:{ all -> 0x0445 }
            r0.lock()     // Catch:{ all -> 0x0445 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0445 }
            r2.<init>()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cp r0 = r1.f3091b     // Catch:{ all -> 0x0445 }
            java.util.Map<java.lang.Integer, com.google.android.play.core.assetpacks.cm> r0 = r0.f3082f     // Catch:{ all -> 0x0445 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x0445 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0445 }
        L_0x001a:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0445 }
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cm r3 = (com.google.android.play.core.assetpacks.C2229cm) r3     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r4 = r3.f3071c     // Catch:{ all -> 0x0445 }
            int r4 = r4.f3066c     // Catch:{ all -> 0x0445 }
            boolean r4 = com.android.billingclient.api.zzam.m34c(r4)     // Catch:{ all -> 0x0445 }
            if (r4 == 0) goto L_0x001a
            r2.add(r3)     // Catch:{ all -> 0x0445 }
            goto L_0x001a
        L_0x0034:
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0445 }
            r3 = 0
            if (r0 != 0) goto L_0x0435
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0445 }
        L_0x003f:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0445 }
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x00af
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C2229cm) r4     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bb r9 = r1.f3092c     // Catch:{ IOException -> 0x0090 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ IOException -> 0x0090 }
            java.lang.String r11 = r10.f3064a     // Catch:{ IOException -> 0x0090 }
            int r12 = r4.f3070b     // Catch:{ IOException -> 0x0090 }
            long r13 = r10.f3065b     // Catch:{ IOException -> 0x0090 }
            int r9 = r9.mo33181d(r11, r12, r13)     // Catch:{ IOException -> 0x0090 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ IOException -> 0x0090 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r10 = r10.f3068e     // Catch:{ IOException -> 0x0090 }
            int r10 = r10.size()     // Catch:{ IOException -> 0x0090 }
            if (r9 != r10) goto L_0x003f
            com.google.android.play.core.internal.ag r0 = f3090a     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x0445 }
            int r10 = r4.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0445 }
            r9[r7] = r10     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r10.f3064a     // Catch:{ all -> 0x0445 }
            r9[r8] = r10     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = "Found final move task for session %s with pack %s."
            r0.mo33278a((int) r5, (java.lang.String) r10, (java.lang.Object[]) r9)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.dh r0 = new com.google.android.play.core.assetpacks.dh     // Catch:{ all -> 0x0445 }
            int r12 = r4.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r13 = r9.f3064a     // Catch:{ all -> 0x0445 }
            int r14 = r4.f3070b     // Catch:{ all -> 0x0445 }
            long r9 = r9.f3065b     // Catch:{ all -> 0x0445 }
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x0445 }
            goto L_0x00b0
        L_0x0090:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bv r2 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0445 }
            int r5 = r4.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0445 }
            r3[r7] = r5     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r5 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r5 = r5.f3064a     // Catch:{ all -> 0x0445 }
            r3[r8] = r5     // Catch:{ all -> 0x0445 }
            java.lang.String r5 = "Failed to check number of completed merges for session %s, pack %s"
            java.lang.String r3 = java.lang.String.format(r5, r3)     // Catch:{ all -> 0x0445 }
            int r4 = r4.f3069a     // Catch:{ all -> 0x0445 }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x0445 }
            throw r2     // Catch:{ all -> 0x0445 }
        L_0x00af:
            r0 = r3
        L_0x00b0:
            if (r0 != 0) goto L_0x042d
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0445 }
        L_0x00b6:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0445 }
            if (r4 == 0) goto L_0x013b
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C2229cm) r4     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f3071c     // Catch:{ all -> 0x0445 }
            int r9 = r9.f3066c     // Catch:{ all -> 0x0445 }
            boolean r9 = com.android.billingclient.api.zzam.m34c(r9)     // Catch:{ all -> 0x0445 }
            if (r9 == 0) goto L_0x00b6
            com.google.android.play.core.assetpacks.cl r9 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r9 = r9.f3068e     // Catch:{ all -> 0x0445 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0445 }
        L_0x00d4:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0445 }
            if (r10 == 0) goto L_0x00b6
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cn r10 = (com.google.android.play.core.assetpacks.C2230cn) r10     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bb r11 = r1.f3092c     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r12 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r13 = r12.f3064a     // Catch:{ all -> 0x0445 }
            int r14 = r4.f3070b     // Catch:{ all -> 0x0445 }
            r18 = r9
            long r8 = r12.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r15 = r10.f3072a     // Catch:{ all -> 0x0445 }
            r12 = r13
            r13 = r14
            r16 = r15
            r14 = r8
            java.io.File r8 = r11.mo33178b(r12, r13, r14, r16)     // Catch:{ all -> 0x0445 }
            boolean r8 = r8.exists()     // Catch:{ all -> 0x0445 }
            if (r8 == 0) goto L_0x0137
            com.google.android.play.core.internal.ag r0 = f3090a     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0445 }
            int r9 = r4.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0445 }
            r8[r7] = r9     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r9 = r9.f3064a     // Catch:{ all -> 0x0445 }
            r11 = 1
            r8[r11] = r9     // Catch:{ all -> 0x0445 }
            java.lang.String r9 = r10.f3072a     // Catch:{ all -> 0x0445 }
            r8[r6] = r9     // Catch:{ all -> 0x0445 }
            java.lang.String r9 = "Found merge task for session %s with pack %s and slice %s."
            r0.mo33278a((int) r5, (java.lang.String) r9, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.de r0 = new com.google.android.play.core.assetpacks.de     // Catch:{ all -> 0x0445 }
            int r8 = r4.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r11 = r9.f3064a     // Catch:{ all -> 0x0445 }
            int r4 = r4.f3070b     // Catch:{ all -> 0x0445 }
            long r12 = r9.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r9 = r10.f3072a     // Catch:{ all -> 0x0445 }
            r18 = r0
            r19 = r8
            r20 = r11
            r21 = r4
            r22 = r12
            r24 = r9
            r18.<init>(r19, r20, r21, r22, r24)     // Catch:{ all -> 0x0445 }
            goto L_0x013c
        L_0x0137:
            r9 = r18
            r8 = 1
            goto L_0x00d4
        L_0x013b:
            r0 = r3
        L_0x013c:
            if (r0 != 0) goto L_0x042d
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0445 }
        L_0x0142:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0445 }
            if (r4 == 0) goto L_0x01dd
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C2229cm) r4     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r8 = r4.f3071c     // Catch:{ all -> 0x0445 }
            int r8 = r8.f3066c     // Catch:{ all -> 0x0445 }
            boolean r8 = com.android.billingclient.api.zzam.m34c(r8)     // Catch:{ all -> 0x0445 }
            if (r8 == 0) goto L_0x0142
            com.google.android.play.core.assetpacks.cl r8 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r8 = r8.f3068e     // Catch:{ all -> 0x0445 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0445 }
        L_0x0160:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0445 }
            if (r9 == 0) goto L_0x0142
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cn r9 = (com.google.android.play.core.assetpacks.C2230cn) r9     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.dr r18 = new com.google.android.play.core.assetpacks.dr     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bb r11 = r1.f3092c     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r12 = r10.f3064a     // Catch:{ all -> 0x0445 }
            int r13 = r4.f3070b     // Catch:{ all -> 0x0445 }
            long r14 = r10.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r9.f3072a     // Catch:{ all -> 0x0445 }
            r16 = r10
            r10 = r18
            r10.<init>(r11, r12, r13, r14, r16)     // Catch:{ all -> 0x0445 }
            boolean r10 = r18.mo33254d()     // Catch:{ all -> 0x0445 }
            if (r10 == 0) goto L_0x0160
            com.google.android.play.core.assetpacks.bb r11 = r1.f3092c     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r12 = r10.f3064a     // Catch:{ all -> 0x0445 }
            int r13 = r4.f3070b     // Catch:{ all -> 0x0445 }
            long r14 = r10.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r9.f3072a     // Catch:{ all -> 0x0445 }
            r16 = r10
            java.io.File r10 = r11.mo33175a((java.lang.String) r12, (int) r13, (long) r14, (java.lang.String) r16)     // Catch:{ all -> 0x0445 }
            boolean r10 = r10.exists()     // Catch:{ all -> 0x0445 }
            if (r10 == 0) goto L_0x0160
            com.google.android.play.core.internal.ag r0 = f3090a     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0445 }
            int r10 = r4.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0445 }
            r8[r7] = r10     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r10.f3064a     // Catch:{ all -> 0x0445 }
            r11 = 1
            r8[r11] = r10     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r9.f3072a     // Catch:{ all -> 0x0445 }
            r8[r6] = r10     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = "Found verify task for session %s with pack %s and slice %s."
            r0.mo33278a((int) r5, (java.lang.String) r10, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.du r0 = new com.google.android.play.core.assetpacks.du     // Catch:{ all -> 0x0445 }
            int r8 = r4.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r10 = r4.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r11 = r10.f3064a     // Catch:{ all -> 0x0445 }
            int r4 = r4.f3070b     // Catch:{ all -> 0x0445 }
            long r12 = r10.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r9.f3072a     // Catch:{ all -> 0x0445 }
            java.lang.String r9 = r9.f3073b     // Catch:{ all -> 0x0445 }
            r18 = r0
            r19 = r8
            r20 = r11
            r21 = r4
            r22 = r12
            r24 = r10
            r25 = r9
            r18.<init>(r19, r20, r21, r22, r24, r25)     // Catch:{ all -> 0x0445 }
            goto L_0x01de
        L_0x01dd:
            r0 = r3
        L_0x01de:
            if (r0 != 0) goto L_0x042d
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0445 }
        L_0x01e4:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0445 }
            r8 = 4
            if (r0 == 0) goto L_0x036a
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0445 }
            r9 = r0
            com.google.android.play.core.assetpacks.cm r9 = (com.google.android.play.core.assetpacks.C2229cm) r9     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r0 = r9.f3071c     // Catch:{ all -> 0x0445 }
            int r0 = r0.f3066c     // Catch:{ all -> 0x0445 }
            boolean r0 = com.android.billingclient.api.zzam.m34c(r0)     // Catch:{ all -> 0x0445 }
            if (r0 == 0) goto L_0x01e4
            com.google.android.play.core.assetpacks.cl r0 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r0 = r0.f3068e     // Catch:{ all -> 0x0445 }
            java.util.Iterator r10 = r0.iterator()     // Catch:{ all -> 0x0445 }
        L_0x0204:
            boolean r0 = r10.hasNext()     // Catch:{ all -> 0x0445 }
            if (r0 == 0) goto L_0x01e4
            java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x0445 }
            r11 = r0
            com.google.android.play.core.assetpacks.cn r11 = (com.google.android.play.core.assetpacks.C2230cn) r11     // Catch:{ all -> 0x0445 }
            int r0 = r11.f3077f     // Catch:{ all -> 0x0445 }
            r12 = 1
            if (r0 == r12) goto L_0x021b
            if (r0 != r6) goto L_0x0219
            goto L_0x021b
        L_0x0219:
            r0 = 0
            goto L_0x021c
        L_0x021b:
            r0 = 1
        L_0x021c:
            if (r0 == 0) goto L_0x02b4
            boolean r0 = r1.mo33220a(r9, r11)     // Catch:{ all -> 0x0445 }
            if (r0 == 0) goto L_0x0204
            com.google.android.play.core.internal.ag r0 = f3090a     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ all -> 0x0445 }
            int r10 = r9.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0445 }
            r4[r7] = r10     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r10 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r10.f3064a     // Catch:{ all -> 0x0445 }
            r12 = 1
            r4[r12] = r10     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r11.f3072a     // Catch:{ all -> 0x0445 }
            r4[r6] = r10     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = "Found extraction task for patch for session %s, pack %s, slice %s."
            r0.mo33278a((int) r5, (java.lang.String) r10, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0445 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x028e }
            com.google.android.play.core.assetpacks.bb r4 = r1.f3092c     // Catch:{ FileNotFoundException -> 0x028e }
            com.google.android.play.core.assetpacks.cl r10 = r9.f3071c     // Catch:{ FileNotFoundException -> 0x028e }
            java.lang.String r12 = r10.f3064a     // Catch:{ FileNotFoundException -> 0x028e }
            int r13 = r9.f3070b     // Catch:{ FileNotFoundException -> 0x028e }
            long r14 = r10.f3065b     // Catch:{ FileNotFoundException -> 0x028e }
            java.lang.String r10 = r11.f3072a     // Catch:{ FileNotFoundException -> 0x028e }
            r18 = r4
            r19 = r12
            r20 = r13
            r21 = r14
            r23 = r10
            java.io.File r4 = r18.mo33182e(r19, r20, r21, r23)     // Catch:{ FileNotFoundException -> 0x028e }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x028e }
            com.google.android.play.core.assetpacks.bs r4 = new com.google.android.play.core.assetpacks.bs     // Catch:{ all -> 0x0445 }
            int r10 = r9.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r12 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r13 = r12.f3064a     // Catch:{ all -> 0x0445 }
            int r9 = r9.f3070b     // Catch:{ all -> 0x0445 }
            long r14 = r12.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r11 = r11.f3072a     // Catch:{ all -> 0x0445 }
            long r6 = r12.f3067d     // Catch:{ all -> 0x0445 }
            r25 = 0
            r26 = 0
            r27 = 1
            int r12 = r12.f3066c     // Catch:{ all -> 0x0445 }
            r18 = r4
            r19 = r10
            r20 = r13
            r21 = r9
            r22 = r14
            r24 = r11
            r28 = r6
            r30 = r12
            r31 = r0
            r18.<init>(r19, r20, r21, r22, r24, r25, r26, r27, r28, r30, r31)     // Catch:{ all -> 0x0445 }
            goto L_0x036b
        L_0x028e:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bv r2 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0445 }
            int r4 = r9.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0445 }
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r4 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = r4.f3064a     // Catch:{ all -> 0x0445 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = r11.f3072a     // Catch:{ all -> 0x0445 }
            r5 = 2
            r3[r5] = r4     // Catch:{ all -> 0x0445 }
            java.lang.String r4 = "Error finding patch, session %s packName %s sliceId %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x0445 }
            int r4 = r9.f3069a     // Catch:{ all -> 0x0445 }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x0445 }
            throw r2     // Catch:{ all -> 0x0445 }
        L_0x02b4:
            com.google.android.play.core.assetpacks.dr r0 = new com.google.android.play.core.assetpacks.dr     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bb r6 = r1.f3092c     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r7 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r12 = r7.f3064a     // Catch:{ all -> 0x0445 }
            int r13 = r9.f3070b     // Catch:{ all -> 0x0445 }
            long r14 = r7.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = r11.f3072a     // Catch:{ all -> 0x0445 }
            r18 = r0
            r19 = r6
            r20 = r12
            r21 = r13
            r22 = r14
            r24 = r7
            r18.<init>(r19, r20, r21, r22, r24)     // Catch:{ all -> 0x0445 }
            int r0 = r0.mo33253c()     // Catch:{ IOException -> 0x02d6 }
            goto L_0x02e7
        L_0x02d6:
            r0 = move-exception
            r6 = r0
            com.google.android.play.core.internal.ag r0 = f3090a     // Catch:{ all -> 0x0445 }
            r7 = 1
            java.lang.Object[] r12 = new java.lang.Object[r7]     // Catch:{ all -> 0x0445 }
            r7 = 0
            r12[r7] = r6     // Catch:{ all -> 0x0445 }
            java.lang.String r6 = "Slice checkpoint corrupt, restarting extraction. %s"
            r7 = 6
            r0.mo33278a((int) r7, (java.lang.String) r6, (java.lang.Object[]) r12)     // Catch:{ all -> 0x0445 }
            r0 = 0
        L_0x02e7:
            r6 = -1
            if (r0 == r6) goto L_0x0365
            java.util.List<com.google.android.play.core.assetpacks.ck> r6 = r11.f3075d     // Catch:{ all -> 0x0445 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.ck r6 = (com.google.android.play.core.assetpacks.C2227ck) r6     // Catch:{ all -> 0x0445 }
            boolean r6 = r6.f3063a     // Catch:{ all -> 0x0445 }
            if (r6 == 0) goto L_0x0365
            com.google.android.play.core.internal.ag r4 = f3090a     // Catch:{ all -> 0x0445 }
            r6 = 5
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0445 }
            int r7 = r11.f3076e     // Catch:{ all -> 0x0445 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0445 }
            r10 = 0
            r6[r10] = r7     // Catch:{ all -> 0x0445 }
            int r7 = r9.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0445 }
            r10 = 1
            r6[r10] = r7     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r7 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = r7.f3064a     // Catch:{ all -> 0x0445 }
            r10 = 2
            r6[r10] = r7     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = r11.f3072a     // Catch:{ all -> 0x0445 }
            r6[r5] = r7     // Catch:{ all -> 0x0445 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0445 }
            r6[r8] = r7     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = "Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s."
            r4.mo33278a((int) r5, (java.lang.String) r7, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bk r4 = r1.f3093d     // Catch:{ all -> 0x0445 }
            int r6 = r9.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r7 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = r7.f3064a     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r11.f3072a     // Catch:{ all -> 0x0445 }
            java.io.InputStream r31 = r4.mo33202a(r6, r7, r10, r0)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bs r4 = new com.google.android.play.core.assetpacks.bs     // Catch:{ all -> 0x0445 }
            int r6 = r9.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r7 = r9.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r10 = r7.f3064a     // Catch:{ all -> 0x0445 }
            int r12 = r9.f3070b     // Catch:{ all -> 0x0445 }
            long r13 = r7.f3065b     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = r11.f3072a     // Catch:{ all -> 0x0445 }
            int r15 = r11.f3076e     // Catch:{ all -> 0x0445 }
            java.util.List<com.google.android.play.core.assetpacks.ck> r11 = r11.f3075d     // Catch:{ all -> 0x0445 }
            int r27 = r11.size()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r9 = r9.f3071c     // Catch:{ all -> 0x0445 }
            r19 = r6
            long r5 = r9.f3067d     // Catch:{ all -> 0x0445 }
            int r9 = r9.f3066c     // Catch:{ all -> 0x0445 }
            r18 = r4
            r20 = r10
            r21 = r12
            r22 = r13
            r24 = r7
            r25 = r15
            r26 = r0
            r28 = r5
            r30 = r9
            r18.<init>(r19, r20, r21, r22, r24, r25, r26, r27, r28, r30, r31)     // Catch:{ all -> 0x0445 }
            goto L_0x036b
        L_0x0365:
            r5 = 3
            r6 = 2
            r7 = 0
            goto L_0x0204
        L_0x036a:
            r4 = r3
        L_0x036b:
            if (r4 != 0) goto L_0x043d
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0445 }
        L_0x0371:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0445 }
            if (r2 == 0) goto L_0x042a
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cm r2 = (com.google.android.play.core.assetpacks.C2229cm) r2     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r4 = r2.f3071c     // Catch:{ all -> 0x0445 }
            int r4 = r4.f3066c     // Catch:{ all -> 0x0445 }
            boolean r4 = com.android.billingclient.api.zzam.m34c(r4)     // Catch:{ all -> 0x0445 }
            if (r4 == 0) goto L_0x0371
            com.google.android.play.core.assetpacks.cl r4 = r2.f3071c     // Catch:{ all -> 0x0445 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r4 = r4.f3068e     // Catch:{ all -> 0x0445 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0445 }
        L_0x038f:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0445 }
            if (r5 == 0) goto L_0x0371
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cn r5 = (com.google.android.play.core.assetpacks.C2230cn) r5     // Catch:{ all -> 0x0445 }
            int r6 = r5.f3077f     // Catch:{ all -> 0x0445 }
            r7 = 1
            if (r6 == r7) goto L_0x03a6
            r7 = 2
            if (r6 != r7) goto L_0x03a4
            goto L_0x03a6
        L_0x03a4:
            r6 = 0
            goto L_0x03a7
        L_0x03a6:
            r6 = 1
        L_0x03a7:
            if (r6 == 0) goto L_0x038f
            java.util.List<com.google.android.play.core.assetpacks.ck> r6 = r5.f3075d     // Catch:{ all -> 0x0445 }
            r7 = 0
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.ck r6 = (com.google.android.play.core.assetpacks.C2227ck) r6     // Catch:{ all -> 0x0445 }
            boolean r6 = r6.f3063a     // Catch:{ all -> 0x0445 }
            if (r6 == 0) goto L_0x038f
            boolean r6 = r1.mo33220a(r2, r5)     // Catch:{ all -> 0x0445 }
            if (r6 != 0) goto L_0x038f
            com.google.android.play.core.internal.ag r0 = f3090a     // Catch:{ all -> 0x0445 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x0445 }
            int r6 = r5.f3077f     // Catch:{ all -> 0x0445 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0445 }
            r7 = 0
            r4[r7] = r6     // Catch:{ all -> 0x0445 }
            int r6 = r2.f3069a     // Catch:{ all -> 0x0445 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0445 }
            r7 = 1
            r4[r7] = r6     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r6 = r2.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r6 = r6.f3064a     // Catch:{ all -> 0x0445 }
            r9 = 2
            r4[r9] = r6     // Catch:{ all -> 0x0445 }
            java.lang.String r6 = r5.f3072a     // Catch:{ all -> 0x0445 }
            r10 = 3
            r4[r10] = r6     // Catch:{ all -> 0x0445 }
            java.lang.String r6 = "Found patch slice task using patch format %s for session %s, pack %s, slice %s."
            r0.mo33278a((int) r10, (java.lang.String) r6, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bk r0 = r1.f3093d     // Catch:{ all -> 0x0445 }
            int r4 = r2.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r6 = r2.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r6 = r6.f3064a     // Catch:{ all -> 0x0445 }
            java.lang.String r7 = r5.f3072a     // Catch:{ all -> 0x0445 }
            r11 = 0
            java.io.InputStream r25 = r0.mo33202a(r4, r6, r7, r11)     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.dn r0 = new com.google.android.play.core.assetpacks.dn     // Catch:{ all -> 0x0445 }
            int r13 = r2.f3069a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r4 = r2.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r14 = r4.f3064a     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bb r4 = r1.f3092c     // Catch:{ all -> 0x0445 }
            java.io.File r4 = r4.mo33185g(r14)     // Catch:{ all -> 0x0445 }
            long r6 = com.google.android.play.core.assetpacks.C2198bb.m2857b((java.io.File) r4)     // Catch:{ all -> 0x0445 }
            int r15 = (int) r6     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.bb r4 = r1.f3092c     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r6 = r2.f3071c     // Catch:{ all -> 0x0445 }
            java.lang.String r6 = r6.f3064a     // Catch:{ all -> 0x0445 }
            long r16 = r4.mo33183f(r6)     // Catch:{ all -> 0x0445 }
            int r4 = r2.f3070b     // Catch:{ all -> 0x0445 }
            com.google.android.play.core.assetpacks.cl r2 = r2.f3071c     // Catch:{ all -> 0x0445 }
            long r6 = r2.f3065b     // Catch:{ all -> 0x0445 }
            int r2 = r5.f3077f     // Catch:{ all -> 0x0445 }
            java.lang.String r8 = r5.f3072a     // Catch:{ all -> 0x0445 }
            long r9 = r5.f3074c     // Catch:{ all -> 0x0445 }
            r12 = r0
            r18 = r4
            r19 = r6
            r21 = r2
            r22 = r8
            r23 = r9
            r12.<init>(r13, r14, r15, r16, r18, r19, r21, r22, r23, r25)     // Catch:{ all -> 0x0445 }
            goto L_0x042b
        L_0x042a:
            r0 = r3
        L_0x042b:
            if (r0 == 0) goto L_0x0435
        L_0x042d:
            com.google.android.play.core.assetpacks.cp r2 = r1.f3091b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f3083g
            r2.unlock()
            return r0
        L_0x0435:
            com.google.android.play.core.assetpacks.cp r0 = r1.f3091b
            java.util.concurrent.locks.ReentrantLock r0 = r0.f3083g
            r0.unlock()
            return r3
        L_0x043d:
            com.google.android.play.core.assetpacks.cp r0 = r1.f3091b
            java.util.concurrent.locks.ReentrantLock r0 = r0.f3083g
            r0.unlock()
            return r4
        L_0x0445:
            r0 = move-exception
            com.google.android.play.core.assetpacks.cp r2 = r1.f3091b
            java.util.concurrent.locks.ReentrantLock r2 = r2.f3083g
            r2.unlock()
            goto L_0x044f
        L_0x044e:
            throw r0
        L_0x044f:
            goto L_0x044e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2235cs.mo33219a():com.google.android.play.core.assetpacks.cr");
    }

    /* renamed from: a */
    public final boolean mo33220a(C2229cm cmVar, C2230cn cnVar) {
        C2198bb bbVar = this.f3092c;
        C2228cl clVar = cmVar.f3071c;
        String str = clVar.f3064a;
        return bbVar.mo33182e(str, cmVar.f3070b, clVar.f3065b, cnVar.f3072a).exists();
    }
}
