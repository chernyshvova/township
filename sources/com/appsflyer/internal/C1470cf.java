package com.appsflyer.internal;

/* renamed from: com.appsflyer.internal.cf */
public final class C1470cf {
    public static int[] AFInAppEventParameterName(char[] cArr, int[] iArr, boolean z) {
        int i = (cArr[0] << 16) + cArr[1];
        int i2 = (cArr[2] << 16) + cArr[3];
        if (!z) {
            AFInAppEventParameterName(iArr);
        }
        int i3 = 0;
        while (i3 < 16) {
            int i4 = i ^ iArr[i3];
            i3++;
            int AFInAppEventParameterName = i2 ^ AFInAppEventParameterName(i4);
            i2 = i4;
            i = AFInAppEventParameterName;
        }
        int i5 = i ^ iArr[16];
        int i6 = iArr[17] ^ i2;
        int[] iArr2 = {i6, i5};
        cArr[0] = (char) (i6 >>> 16);
        cArr[1] = (char) i6;
        cArr[2] = (char) (i5 >>> 16);
        cArr[3] = (char) i5;
        if (!z) {
            AFInAppEventParameterName(iArr);
        }
        return iArr2;
    }

    public static void AFInAppEventParameterName(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int AFInAppEventParameterName(int i) {
        int[][] iArr = C1468cb.valueOf.AFKeystoreWrapper;
        return ((iArr[0][i >>> 24] + iArr[1][(i >>> 16) & 255]) ^ iArr[2][(i >>> 8) & 255]) + iArr[3][i & 255];
    }
}
