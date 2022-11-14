package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C2350j;

public class AssetPackException extends C2350j {

    /* renamed from: a */
    public final int f2863a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AssetPackException(int r7) {
        /*
            r6 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r2 = 0
            r0[r2] = r1
            java.util.Map<java.lang.Integer, java.lang.String> r1 = com.google.android.play.core.assetpacks.model.C2271a.f3211a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0019
            java.lang.String r1 = ""
            goto L_0x0049
        L_0x0019:
            java.util.Map<java.lang.Integer, java.lang.String> r1 = com.google.android.play.core.assetpacks.model.C2271a.f3211a
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.Integer, java.lang.String> r3 = com.google.android.play.core.assetpacks.model.C2271a.f3212b
            java.lang.Object r2 = r3.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r3 = r3 + 113
            int r3 = r3 + r4
            r5.<init>(r3)
            java.lang.String r3 = " (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#"
            java.lang.String r4 = ")"
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline20(r5, r1, r3, r2, r4)
        L_0x0049:
            r2 = 1
            r0[r2] = r1
            java.lang.String r1 = "Asset Pack Download Error(%d): %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r6.<init>((java.lang.String) r0)
            if (r7 == 0) goto L_0x005a
            r6.f2863a = r7
            return
        L_0x005a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "errorCode should not be 0."
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.AssetPackException.<init>(int):void");
    }
}
