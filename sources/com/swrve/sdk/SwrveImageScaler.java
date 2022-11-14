package com.swrve.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class SwrveImageScaler {

    public static class BitmapResult {
        public Bitmap bitmap;
        public int height;
        public int width;

        public BitmapResult(Bitmap bitmap2, int i, int i2) {
            this.bitmap = bitmap2;
            this.width = i;
            this.height = i2;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static BitmapResult decodeSampledBitmapFromFile(String str, int i, int i2, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            options.inSampleSize = Math.max(calculateInSampleSize(options, i, i2), i3);
            options.inJustDecodeBounds = false;
            return new BitmapResult(BitmapFactory.decodeFile(str, options), i4, i5);
        } catch (OutOfMemoryError e) {
            SwrveLogger.m2754e(Log.getStackTraceString(e), new Object[0]);
            return null;
        } catch (Exception e2) {
            SwrveLogger.m2754e(Log.getStackTraceString(e2), new Object[0]);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c A[SYNTHETIC, Splitter:B:24:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeSampledBitmapFromStream(java.io.InputStream r7, int r8, int r9, int r10, java.lang.String r11, java.io.File r12) {
        /*
            java.lang.String r0 = "Exception closing stream for downloading notification image."
            r1 = 0
            r2 = 0
            java.lang.String r3 = "notification-image"
            java.io.File r12 = java.io.File.createTempFile(r3, r1, r12)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r3.<init>(r12)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x003a }
        L_0x0013:
            int r5 = r7.read(r4)     // Catch:{ Exception -> 0x003a }
            r6 = -1
            if (r5 == r6) goto L_0x001e
            r3.write(r4, r2, r5)     // Catch:{ Exception -> 0x003a }
            goto L_0x0013
        L_0x001e:
            r3.close()     // Catch:{ Exception -> 0x003a }
            java.lang.String r7 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x003a }
            com.swrve.sdk.SwrveImageScaler$BitmapResult r7 = decodeSampledBitmapFromFile(r7, r8, r9, r10)     // Catch:{ Exception -> 0x003a }
            if (r7 == 0) goto L_0x002f
            android.graphics.Bitmap r1 = r7.getBitmap()     // Catch:{ Exception -> 0x003a }
        L_0x002f:
            r3.close()     // Catch:{ Exception -> 0x0033 }
            goto L_0x0056
        L_0x0033:
            r7 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.swrve.sdk.SwrveLogger.m2753e(r0, r7, r8)
            goto L_0x0056
        L_0x003a:
            r7 = move-exception
            goto L_0x0040
        L_0x003c:
            r7 = move-exception
            goto L_0x0059
        L_0x003e:
            r7 = move-exception
            r3 = r1
        L_0x0040:
            java.lang.String r8 = "Exception downloading notification image:%s"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0057 }
            r9[r2] = r11     // Catch:{ all -> 0x0057 }
            com.swrve.sdk.SwrveLogger.m2753e(r8, r7, r9)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0056
            r3.close()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0056
        L_0x0050:
            r7 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.swrve.sdk.SwrveLogger.m2753e(r0, r7, r8)
        L_0x0056:
            return r1
        L_0x0057:
            r7 = move-exception
            r1 = r3
        L_0x0059:
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ Exception -> 0x005f }
            goto L_0x0065
        L_0x005f:
            r8 = move-exception
            java.lang.Object[] r9 = new java.lang.Object[r2]
            com.swrve.sdk.SwrveLogger.m2753e(r0, r8, r9)
        L_0x0065:
            goto L_0x0067
        L_0x0066:
            throw r7
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveImageScaler.decodeSampledBitmapFromStream(java.io.InputStream, int, int, int, java.lang.String, java.io.File):android.graphics.Bitmap");
    }
}
