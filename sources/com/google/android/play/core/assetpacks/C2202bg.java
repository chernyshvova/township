package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.google.android.play.core.assetpacks.bg */
public final class C2202bg extends AssetPackLocation {

    /* renamed from: a */
    public final int f2958a;

    /* renamed from: b */
    public final String f2959b;

    /* renamed from: c */
    public final String f2960c;

    public C2202bg(int i, @Nullable String str, @Nullable String str2) {
        this.f2958a = i;
        this.f2959b = str;
        this.f2960c = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r1 = r4.f2960c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r4.f2959b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.play.core.assetpacks.AssetPackLocation
            r2 = 0
            if (r1 == 0) goto L_0x0037
            com.google.android.play.core.assetpacks.AssetPackLocation r5 = (com.google.android.play.core.assetpacks.AssetPackLocation) r5
            int r1 = r4.f2958a
            com.google.android.play.core.assetpacks.bg r5 = (com.google.android.play.core.assetpacks.C2202bg) r5
            int r3 = r5.f2958a
            if (r1 != r3) goto L_0x0037
            java.lang.String r1 = r4.f2959b
            if (r1 != 0) goto L_0x001c
            java.lang.String r1 = r5.f2959b
            if (r1 != 0) goto L_0x0037
            goto L_0x0024
        L_0x001c:
            java.lang.String r3 = r5.f2959b
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0037
        L_0x0024:
            java.lang.String r1 = r4.f2960c
            if (r1 != 0) goto L_0x002d
            java.lang.String r5 = r5.f2960c
            if (r5 != 0) goto L_0x0037
            goto L_0x0036
        L_0x002d:
            java.lang.String r5 = r5.f2960c
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            return r0
        L_0x0037:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2202bg.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = (this.f2958a ^ 1000003) * 1000003;
        String str = this.f2959b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2960c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        int i = this.f2958a;
        String str = this.f2959b;
        String str2 = this.f2960c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        return GeneratedOutlineSupport.outline19(sb, ", assetsPath=", str2, "}");
    }
}
