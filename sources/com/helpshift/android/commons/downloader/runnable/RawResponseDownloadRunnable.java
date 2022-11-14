package com.helpshift.android.commons.downloader.runnable;

import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;

public class RawResponseDownloadRunnable extends BaseDownloadRunnable {
    public static final String TAG = "Helpshift_RawDownRun";

    public RawResponseDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
    }

    public void clearCache() {
    }

    public long getAlreadyDownloadedBytes() {
        return 0;
    }

    public boolean isGzipSupported() {
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|(3:1|2|(1:4)(1:20))|5|11|12|13|14|15|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        notifyDownloadFinish(true, r4, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processHttpResponse(java.io.InputStream r4, int r5, int r6, java.lang.String r7) throws java.io.IOException {
        /*
            r3 = this;
            java.io.InputStreamReader r5 = new java.io.InputStreamReader
            r5.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r0.<init>(r5)
        L_0x000f:
            java.lang.String r5 = r0.readLine()     // Catch:{ IOException -> 0x001f }
            if (r5 == 0) goto L_0x0019
            r4.append(r5)     // Catch:{ IOException -> 0x001f }
            goto L_0x000f
        L_0x0019:
            r3.closeFileStream(r0)
            goto L_0x0028
        L_0x001d:
            r4 = move-exception
            goto L_0x0047
        L_0x001f:
            r5 = move-exception
            java.lang.String r1 = "Helpshift_RawDownRun"
            java.lang.String r2 = "IO Exception while reading response"
            com.helpshift.util.HSLogger.m3238d((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r5)     // Catch:{ all -> 0x001d }
            goto L_0x0019
        L_0x0028:
            r5 = 1
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0036 }
            java.lang.String r1 = r4.toString()     // Catch:{ JSONException -> 0x0036 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0036 }
            r3.notifyDownloadFinish(r5, r0, r6, r7)     // Catch:{ JSONException -> 0x0036 }
            goto L_0x0046
        L_0x0036:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0043 }
            java.lang.String r1 = r4.toString()     // Catch:{ JSONException -> 0x0043 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0043 }
            r3.notifyDownloadFinish(r5, r0, r6, r7)     // Catch:{ JSONException -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            r3.notifyDownloadFinish(r5, r4, r6, r7)
        L_0x0046:
            return
        L_0x0047:
            r3.closeFileStream(r0)
            goto L_0x004c
        L_0x004b:
            throw r4
        L_0x004c:
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.android.commons.downloader.runnable.RawResponseDownloadRunnable.processHttpResponse(java.io.InputStream, int, int, java.lang.String):void");
    }
}
