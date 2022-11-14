package com.swrve.sdk;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SwrveAssetsManagerImp implements SwrveAssetsManager {
    public Set<String> assetsOnDisk = new HashSet();
    public String cdnFonts;
    public String cdnImages;
    public final Context context;
    public File storageDir;

    public SwrveAssetsManagerImp(Context context2) {
        this.context = context2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb A[SYNTHETIC, Splitter:B:43:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9 A[SYNTHETIC, Splitter:B:49:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean downloadAsset(com.swrve.sdk.SwrveAssetsQueueItem r10) {
        /*
            r9 = this;
            java.lang.String r0 = "gzip"
            java.lang.String r1 = "Error closing assets stream."
            boolean r2 = r10.isImage()
            if (r2 == 0) goto L_0x000d
            java.lang.String r2 = r9.cdnImages
            goto L_0x000f
        L_0x000d:
            java.lang.String r2 = r9.cdnFonts
        L_0x000f:
            boolean r3 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r2)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0021
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r5] = r10
            java.lang.String r10 = "Error downloading asset. No cdn url for %s"
            com.swrve.sdk.SwrveLogger.m2754e(r10, r0)
            return r5
        L_0x0021:
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            java.lang.String r3 = r10.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x00bf }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00bf }
            java.net.URLConnection r2 = r6.openConnection()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r6 = "Accept-Encoding"
            r2.setRequestProperty(r6, r0)     // Catch:{ Exception -> 0x00bf }
            com.swrve.sdk.rest.SwrveFilterInputStream r6 = new com.swrve.sdk.rest.SwrveFilterInputStream     // Catch:{ Exception -> 0x00bf }
            java.io.InputStream r7 = r2.getInputStream()     // Catch:{ Exception -> 0x00bf }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r2 = r2.getContentEncoding()     // Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
            if (r2 == 0) goto L_0x0061
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
            java.lang.String r2 = r2.toLowerCase(r3)     // Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
            if (r0 == 0) goto L_0x0061
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
            r3 = r0
            goto L_0x0062
        L_0x0061:
            r3 = r6
        L_0x0062:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00bf }
            r0.<init>()     // Catch:{ Exception -> 0x00bf }
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00bf }
        L_0x006b:
            int r6 = r3.read(r2)     // Catch:{ Exception -> 0x00bf }
            r7 = -1
            if (r6 == r7) goto L_0x0076
            r0.write(r2, r5, r6)     // Catch:{ Exception -> 0x00bf }
            goto L_0x006b
        L_0x0076:
            byte[] r0 = r0.toByteArray()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r2 = com.swrve.sdk.SwrveHelper.sha1(r0)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r6 = r10.getDigest()     // Catch:{ Exception -> 0x00bf }
            boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x00bf }
            if (r6 == 0) goto L_0x009f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00bf }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00bf }
            java.io.File r7 = r9.storageDir     // Catch:{ Exception -> 0x00bf }
            java.lang.String r8 = r10.getName()     // Catch:{ Exception -> 0x00bf }
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x00bf }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00bf }
            r2.write(r0)     // Catch:{ Exception -> 0x00bf }
            r2.close()     // Catch:{ Exception -> 0x00bf }
            goto L_0x00ac
        L_0x009f:
            java.lang.String r0 = "Error downloading assetItem:%s. Did not match digest:%s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00bf }
            r6[r5] = r10     // Catch:{ Exception -> 0x00bf }
            r6[r4] = r2     // Catch:{ Exception -> 0x00bf }
            com.swrve.sdk.SwrveLogger.m2754e(r0, r6)     // Catch:{ Exception -> 0x00bf }
            r4 = 0
        L_0x00ac:
            r3.close()     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00b6
        L_0x00b0:
            r10 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r10, r0)
        L_0x00b6:
            r5 = r4
            goto L_0x00d5
        L_0x00b8:
            r10 = move-exception
            goto L_0x00d7
        L_0x00ba:
            r0 = move-exception
            r3 = r6
            goto L_0x00c0
        L_0x00bd:
            r10 = move-exception
            goto L_0x00d6
        L_0x00bf:
            r0 = move-exception
        L_0x00c0:
            java.lang.String r2 = "Error downloading asset:%s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00bd }
            r4[r5] = r10     // Catch:{ all -> 0x00bd }
            com.swrve.sdk.SwrveLogger.m2753e(r2, r0, r4)     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x00d5
            r3.close()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d5
        L_0x00cf:
            r10 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r10, r0)
        L_0x00d5:
            return r5
        L_0x00d6:
            r6 = r3
        L_0x00d7:
            if (r6 == 0) goto L_0x00e3
            r6.close()     // Catch:{ Exception -> 0x00dd }
            goto L_0x00e3
        L_0x00dd:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r2)
        L_0x00e3:
            goto L_0x00e5
        L_0x00e4:
            throw r10
        L_0x00e5:
            goto L_0x00e4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveAssetsManagerImp.downloadAsset(com.swrve.sdk.SwrveAssetsQueueItem):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00af A[SYNTHETIC, Splitter:B:40:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cd A[SYNTHETIC, Splitter:B:48:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb A[SYNTHETIC, Splitter:B:56:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0109 A[SYNTHETIC, Splitter:B:64:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0117 A[SYNTHETIC, Splitter:B:70:0x0117] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x00f7=Splitter:B:61:0x00f7, B:53:0x00d9=Splitter:B:53:0x00d9, B:45:0x00bb=Splitter:B:45:0x00bb, B:37:0x009d=Splitter:B:37:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean downloadAssetFromExternalSource(com.swrve.sdk.SwrveAssetsQueueItem r12) {
        /*
            r11 = this;
            java.lang.String r0 = "gzip"
            java.lang.String r1 = "Error downloading asset: %s"
            java.lang.String r2 = "Error closing assets stream."
            java.lang.String r3 = r12.getDigest()
            boolean r4 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r3)
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x001c
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r0[r6] = r12
            java.lang.String r12 = "Error downloading asset. No cdn url for %s"
            com.swrve.sdk.SwrveLogger.m2754e(r12, r0)
            return r6
        L_0x001c:
            r4 = 0
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r7.<init>(r3)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.lang.String r8 = "Accept-Encoding"
            r7.setRequestProperty(r8, r0)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            com.swrve.sdk.rest.SwrveFilterInputStream r8 = new com.swrve.sdk.rest.SwrveFilterInputStream     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.io.InputStream r9 = r7.getInputStream()     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r8.<init>(r9)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.lang.String r4 = r7.getContentEncoding()     // Catch:{ MalformedURLException -> 0x0096, UnknownHostException -> 0x0093, IOException -> 0x0090, Exception -> 0x008d, all -> 0x0089 }
            if (r4 == 0) goto L_0x004d
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ MalformedURLException -> 0x0096, UnknownHostException -> 0x0093, IOException -> 0x0090, Exception -> 0x008d, all -> 0x0089 }
            java.lang.String r4 = r4.toLowerCase(r7)     // Catch:{ MalformedURLException -> 0x0096, UnknownHostException -> 0x0093, IOException -> 0x0090, Exception -> 0x008d, all -> 0x0089 }
            boolean r0 = r4.contains(r0)     // Catch:{ MalformedURLException -> 0x0096, UnknownHostException -> 0x0093, IOException -> 0x0090, Exception -> 0x008d, all -> 0x0089 }
            if (r0 == 0) goto L_0x004d
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ MalformedURLException -> 0x0096, UnknownHostException -> 0x0093, IOException -> 0x0090, Exception -> 0x008d, all -> 0x0089 }
            r0.<init>(r8)     // Catch:{ MalformedURLException -> 0x0096, UnknownHostException -> 0x0093, IOException -> 0x0090, Exception -> 0x008d, all -> 0x0089 }
            r4 = r0
            goto L_0x004e
        L_0x004d:
            r4 = r8
        L_0x004e:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r0.<init>()     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r7 = 2048(0x800, float:2.87E-42)
            byte[] r7 = new byte[r7]     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
        L_0x0057:
            int r8 = r4.read(r7)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r9 = -1
            if (r8 == r9) goto L_0x0062
            r0.write(r7, r6, r8)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            goto L_0x0057
        L_0x0062:
            byte[] r0 = r0.toByteArray()     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.io.File r8 = new java.io.File     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.io.File r9 = r11.storageDir     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            java.lang.String r10 = r12.getName()     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r8.<init>(r9, r10)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r7.<init>(r8)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r7.write(r0)     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r7.close()     // Catch:{ MalformedURLException -> 0x00f6, UnknownHostException -> 0x00d8, IOException -> 0x00ba, Exception -> 0x009c }
            r4.close()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0114
        L_0x0081:
            r12 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r6]
            com.swrve.sdk.SwrveLogger.m2753e(r2, r12, r0)
            goto L_0x0114
        L_0x0089:
            r12 = move-exception
            r4 = r8
            goto L_0x0115
        L_0x008d:
            r0 = move-exception
            r4 = r8
            goto L_0x009d
        L_0x0090:
            r0 = move-exception
            r4 = r8
            goto L_0x00bb
        L_0x0093:
            r0 = move-exception
            r4 = r8
            goto L_0x00d9
        L_0x0096:
            r0 = move-exception
            r4 = r8
            goto L_0x00f7
        L_0x0099:
            r12 = move-exception
            goto L_0x0115
        L_0x009c:
            r0 = move-exception
        L_0x009d:
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0099 }
            r5[r6] = r12     // Catch:{ all -> 0x0099 }
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "Asset could not be downloaded"
            com.swrve.sdk.QaUser.assetFailedToDownload(r12, r3, r0)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0113
            r4.close()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x0113
        L_0x00b3:
            r12 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r6]
            com.swrve.sdk.SwrveLogger.m2753e(r2, r12, r0)
            goto L_0x0113
        L_0x00ba:
            r0 = move-exception
        L_0x00bb:
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0099 }
            r5[r6] = r12     // Catch:{ all -> 0x0099 }
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "Asset file could not be retrieved"
            com.swrve.sdk.QaUser.assetFailedToDownload(r12, r3, r0)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0113
            r4.close()     // Catch:{ Exception -> 0x00d1 }
            goto L_0x0113
        L_0x00d1:
            r12 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r6]
            com.swrve.sdk.SwrveLogger.m2753e(r2, r12, r0)
            goto L_0x0113
        L_0x00d8:
            r0 = move-exception
        L_0x00d9:
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0099 }
            r5[r6] = r12     // Catch:{ all -> 0x0099 }
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "Host name could not be resolved"
            com.swrve.sdk.QaUser.assetFailedToDownload(r12, r3, r0)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0113
            r4.close()     // Catch:{ Exception -> 0x00ef }
            goto L_0x0113
        L_0x00ef:
            r12 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r6]
            com.swrve.sdk.SwrveLogger.m2753e(r2, r12, r0)
            goto L_0x0113
        L_0x00f6:
            r0 = move-exception
        L_0x00f7:
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0099 }
            r5[r6] = r12     // Catch:{ all -> 0x0099 }
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "Image url was malformed"
            com.swrve.sdk.QaUser.assetFailedToDownload(r12, r3, r0)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0113
            r4.close()     // Catch:{ Exception -> 0x010d }
            goto L_0x0113
        L_0x010d:
            r12 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r6]
            com.swrve.sdk.SwrveLogger.m2753e(r2, r12, r0)
        L_0x0113:
            r5 = 0
        L_0x0114:
            return r5
        L_0x0115:
            if (r4 == 0) goto L_0x0121
            r4.close()     // Catch:{ Exception -> 0x011b }
            goto L_0x0121
        L_0x011b:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r6]
            com.swrve.sdk.SwrveLogger.m2753e(r2, r0, r1)
        L_0x0121:
            goto L_0x0123
        L_0x0122:
            throw r12
        L_0x0123:
            goto L_0x0122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveAssetsManagerImp.downloadAssetFromExternalSource(com.swrve.sdk.SwrveAssetsQueueItem):boolean");
    }

    public void downloadAssets(Set<SwrveAssetsQueueItem> set, SwrveAssetsCompleteCallback swrveAssetsCompleteCallback) {
        if (!this.storageDir.canWrite()) {
            SwrveLogger.m2754e("Could not download assets because do not have write access to storageDir:%s", this.storageDir);
        } else {
            downloadAssets(set);
        }
        if (swrveAssetsCompleteCallback != null) {
            swrveAssetsCompleteCallback.complete();
        }
    }

    public Set<SwrveAssetsQueueItem> filterExistingFiles(Set<SwrveAssetsQueueItem> set) {
        Iterator<SwrveAssetsQueueItem> it = set.iterator();
        while (it.hasNext()) {
            SwrveAssetsQueueItem next = it.next();
            if (new File(this.storageDir, next.getName()).exists()) {
                it.remove();
                synchronized (this.assetsOnDisk) {
                    this.assetsOnDisk.add(next.getName());
                }
            }
        }
        return set;
    }

    public Set<String> getAssetsOnDisk() {
        Set<String> set;
        synchronized (this.assetsOnDisk) {
            set = this.assetsOnDisk;
        }
        return set;
    }

    public File getStorageDir() {
        return this.storageDir;
    }

    public void setCdnFonts(String str) {
        this.cdnFonts = str;
    }

    public void setCdnImages(String str) {
        this.cdnImages = str;
    }

    public void setStorageDir(File file) {
        this.storageDir = file;
    }

    public void downloadAssets(Set<SwrveAssetsQueueItem> set) {
        boolean z;
        if (set != null) {
            for (SwrveAssetsQueueItem next : filterExistingFiles(set)) {
                if (next.isExternalSource()) {
                    z = downloadAssetFromExternalSource(next);
                } else {
                    z = downloadAsset(next);
                }
                if (z) {
                    synchronized (this.assetsOnDisk) {
                        this.assetsOnDisk.add(next.getName());
                    }
                }
            }
        }
    }
}
