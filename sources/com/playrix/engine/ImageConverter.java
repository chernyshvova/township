package com.playrix.engine;

public class ImageConverter {
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0082 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] convertImageToPng(byte[] r12, int r13, int r14) {
        /*
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            int r3 = r12.length     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            android.graphics.Bitmap r12 = android.graphics.BitmapFactory.decodeByteArray(r12, r2, r3)     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            if (r12 != 0) goto L_0x0015
            r1.close()     // Catch:{ Exception -> 0x0014 }
        L_0x0014:
            return r0
        L_0x0015:
            int r2 = r12.getWidth()     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            int r3 = r12.getHeight()     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            if (r13 < 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r13 = r2
        L_0x0021:
            if (r14 < 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r14 = r3
        L_0x0025:
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r13 >= r2) goto L_0x0033
            double r6 = (double) r13
            double r8 = (double) r2
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r8)
            double r6 = r6 / r8
            goto L_0x0034
        L_0x0033:
            r6 = r4
        L_0x0034:
            if (r14 >= r3) goto L_0x0040
            double r8 = (double) r14
            double r10 = (double) r3
            java.lang.Double.isNaN(r8)
            java.lang.Double.isNaN(r10)
            double r8 = r8 / r10
            goto L_0x0041
        L_0x0040:
            r8 = r4
        L_0x0041:
            double r6 = java.lang.Math.min(r6, r8)     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0064
            double r4 = (double) r2
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r6
            int r2 = (int) r4
            int r13 = java.lang.Math.min(r2, r13)     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            double r2 = (double) r3
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r6
            int r2 = (int) r2
            int r14 = java.lang.Math.min(r2, r14)     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            r2 = 1
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createScaledBitmap(r12, r13, r14, r2)     // Catch:{ Exception -> 0x0082, all -> 0x007d }
        L_0x0064:
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            r14 = 100
            boolean r12 = r12.compress(r13, r14, r1)     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            if (r12 != 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            return r0
        L_0x0072:
            r1.flush()     // Catch:{ Exception -> 0x0082, all -> 0x007d }
            r1.close()     // Catch:{ Exception -> 0x0078 }
        L_0x0078:
            byte[] r12 = r1.toByteArray()
            return r12
        L_0x007d:
            r12 = move-exception
            r1.close()     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            throw r12
        L_0x0082:
            r1.close()     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.ImageConverter.convertImageToPng(byte[], int, int):byte[]");
    }
}
