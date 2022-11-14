package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.play.core.assetpacks.dq */
public final class C2256dq {

    /* renamed from: a */
    public final int f3165a;

    /* renamed from: b */
    public final String f3166b;

    /* renamed from: c */
    public final long f3167c;

    /* renamed from: d */
    public final long f3168d;

    /* renamed from: e */
    public final int f3169e;

    public C2256dq() {
    }

    public C2256dq(int i, @Nullable String str, long j, long j2, int i2) {
        this.f3165a = i;
        this.f3166b = str;
        this.f3167c = j;
        this.f3168d = j2;
        this.f3169e = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r1 = r7.f3166b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.C2256dq
            r2 = 0
            if (r1 == 0) goto L_0x003a
            com.google.android.play.core.assetpacks.dq r8 = (com.google.android.play.core.assetpacks.C2256dq) r8
            int r1 = r7.f3165a
            int r3 = r8.f3165a
            if (r1 != r3) goto L_0x003a
            java.lang.String r1 = r7.f3166b
            if (r1 != 0) goto L_0x001a
            java.lang.String r1 = r8.f3166b
            if (r1 != 0) goto L_0x003a
            goto L_0x0023
        L_0x001a:
            java.lang.String r3 = r8.f3166b
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0023
            goto L_0x003a
        L_0x0023:
            long r3 = r7.f3167c
            long r5 = r8.f3167c
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x003a
            long r3 = r7.f3168d
            long r5 = r8.f3168d
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x003a
            int r1 = r7.f3169e
            int r8 = r8.f3169e
            if (r1 != r8) goto L_0x003a
            return r0
        L_0x003a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2256dq.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.f3165a ^ 1000003) * 1000003;
        String str = this.f3166b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f3167c;
        long j2 = this.f3168d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f3169e;
    }

    public String toString() {
        int i = this.f3165a;
        String str = this.f3166b;
        long j = this.f3167c;
        long j2 = this.f3168d;
        int i2 = this.f3169e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
