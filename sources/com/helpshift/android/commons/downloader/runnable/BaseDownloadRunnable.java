package com.helpshift.android.commons.downloader.runnable;

import android.os.Build;
import com.helpshift.android.commons.downloader.HelpshiftSSLSocketFactory;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.util.AttachmentNetworkUtil;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

public abstract class BaseDownloadRunnable implements Runnable {
    public static final String DOWNLOAD_MANAGER_DB_KEY = "kDownloadManagerCachedFiles";
    public static final String TAG = "Helpshift_DownloadRun";
    public NetworkAuthDataFetcher networkAuthDataFetcher;
    public OnDownloadFinishListener onDownloadFinishListener;
    public OnProgressChangedListener onProgressChangedListener;
    public DownloadRequestedFileInfo requestInfo;

    public BaseDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, NetworkAuthDataFetcher networkAuthDataFetcher2, OnProgressChangedListener onProgressChangedListener2, OnDownloadFinishListener onDownloadFinishListener2) {
        this.requestInfo = downloadRequestedFileInfo;
        this.networkAuthDataFetcher = networkAuthDataFetcher2;
        this.onProgressChangedListener = onProgressChangedListener2;
        this.onDownloadFinishListener = onDownloadFinishListener2;
    }

    private URL buildUrl() throws MalformedURLException, URISyntaxException, GeneralSecurityException {
        DownloadRequestedFileInfo downloadRequestedFileInfo = this.requestInfo;
        if (downloadRequestedFileInfo.isSecured) {
            return AttachmentNetworkUtil.buildSecureURL(downloadRequestedFileInfo.url, this.networkAuthDataFetcher);
        }
        return new URL(new URI(this.requestInfo.url).toASCIIString());
    }

    private void fixSSLSocketProtocols(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT <= 19) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("TLSv1.2");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("SSLv3");
            httpsURLConnection.setSSLSocketFactory(new HelpshiftSSLSocketFactory(httpsURLConnection.getSSLSocketFactory(), arrayList, arrayList2));
        }
    }

    public abstract void clearCache();

    public void closeFileStream(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public abstract long getAlreadyDownloadedBytes() throws FileNotFoundException;

    public abstract boolean isGzipSupported();

    public void notifyDownloadFinish(boolean z, Object obj, int i, String str) {
        OnDownloadFinishListener onDownloadFinishListener2 = this.onDownloadFinishListener;
        if (onDownloadFinishListener2 != null) {
            onDownloadFinishListener2.onDownloadFinish(z, this.requestInfo.url, obj, i, str);
        }
    }

    public void notifyProgressChange(int i) {
        OnProgressChangedListener onProgressChangedListener2 = this.onProgressChangedListener;
        if (onProgressChangedListener2 != null) {
            onProgressChangedListener2.onProgressChanged(this.requestInfo.url, i);
        }
    }

    public abstract void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException;

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        notifyDownloadFinish(false, r7, r8, r2);
        com.helpshift.util.HSLogger.m3243e(TAG, "Exception in closing download response", (java.lang.Throwable) r7, com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString("route", r13.requestInfo.url));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0123, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        notifyDownloadFinish(false, r7, r8, r2);
        com.helpshift.util.HSLogger.m3243e(TAG, "Exception in closing download response", (java.lang.Throwable) r7, com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString("route", r13.requestInfo.url));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0142, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        notifyDownloadFinish(false, r7, r8, r2);
        com.helpshift.util.HSLogger.m3243e(TAG, "Exception in closing download response", (java.lang.Throwable) r7, com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString("route", r13.requestInfo.url));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0161, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0094, B:38:0x00dc] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0094, B:54:0x011f] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0094, B:62:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011f A[SYNTHETIC, Splitter:B:54:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013e A[SYNTHETIC, Splitter:B:62:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0159 A[ExcHandler: Exception (e java.lang.Exception), PHI: r2 r8 
      PHI: (r2v19 java.lang.String) = (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String) binds: [B:62:0x013e, B:65:0x0143, B:63:?, B:54:0x011f, B:57:0x0124, B:55:?, B:38:0x00dc, B:41:0x00e1, B:42:?, B:39:?, B:23:0x0094, B:24:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v15 int) = (r8v16 int), (r8v16 int), (r8v16 int), (r8v17 int), (r8v17 int), (r8v17 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int) binds: [B:62:0x013e, B:65:0x0143, B:63:?, B:54:0x011f, B:57:0x0124, B:55:?, B:38:0x00dc, B:41:0x00e1, B:42:?, B:39:?, B:23:0x0094, B:24:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015b A[ExcHandler: GeneralSecurityException (e java.security.GeneralSecurityException), PHI: r2 r8 
      PHI: (r2v18 java.lang.String) = (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String) binds: [B:62:0x013e, B:65:0x0143, B:63:?, B:54:0x011f, B:57:0x0124, B:55:?, B:38:0x00dc, B:41:0x00e1, B:42:?, B:39:?, B:23:0x0094, B:24:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v14 int) = (r8v16 int), (r8v16 int), (r8v16 int), (r8v17 int), (r8v17 int), (r8v17 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int) binds: [B:62:0x013e, B:65:0x0143, B:63:?, B:54:0x011f, B:57:0x0124, B:55:?, B:38:0x00dc, B:41:0x00e1, B:42:?, B:39:?, B:23:0x0094, B:24:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0161 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), PHI: r2 r8 
      PHI: (r2v15 java.lang.String) = (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v20 java.lang.String), (r2v4 java.lang.String), (r2v4 java.lang.String) binds: [B:62:0x013e, B:65:0x0143, B:63:?, B:54:0x011f, B:57:0x0124, B:55:?, B:38:0x00dc, B:41:0x00e1, B:42:?, B:39:?, B:23:0x0094, B:24:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v11 int) = (r8v16 int), (r8v16 int), (r8v16 int), (r8v17 int), (r8v17 int), (r8v17 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int), (r8v25 int) binds: [B:62:0x013e, B:65:0x0143, B:63:?, B:54:0x011f, B:57:0x0124, B:55:?, B:38:0x00dc, B:41:0x00e1, B:42:?, B:39:?, B:23:0x0094, B:24:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Exception in closing download response"
            java.lang.String r1 = "route"
            java.lang.String r2 = "Starting download : "
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r3 = r13.requestInfo
            java.lang.String r3 = r3.url
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Helpshift_DownloadRun"
            com.helpshift.util.HSLogger.m3237d(r3, r2)
            r2 = 10
            android.os.Process.setThreadPriority(r2)
            java.lang.String r2 = ""
            r4 = 1
            r5 = 0
            boolean r6 = java.lang.Thread.interrupted()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            if (r6 != 0) goto L_0x0163
            java.net.URL r6 = r13.buildUrl()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            java.lang.String r7 = "https"
            java.lang.String r8 = r6.getProtocol()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            boolean r7 = r7.equals(r8)     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            if (r7 == 0) goto L_0x0043
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            r13.fixSSLSocketProtocols(r6)     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            goto L_0x0049
        L_0x0043:
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
        L_0x0049:
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r7 = r13.requestInfo     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            java.lang.String r7 = r7.etag     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            if (r7 == 0) goto L_0x0062
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r7 = r13.requestInfo     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            java.lang.String r7 = r7.etag     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            boolean r7 = r7.isEmpty()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            if (r7 != 0) goto L_0x0062
            java.lang.String r7 = "If-None-Match"
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r8 = r13.requestInfo     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            java.lang.String r8 = r8.etag     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            r6.setRequestProperty(r7, r8)     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
        L_0x0062:
            r6.setInstanceFollowRedirects(r4)     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            r7 = 0
            long r8 = r13.getAlreadyDownloadedBytes()     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            java.lang.String r10 = "Range"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            r11.<init>()     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            java.lang.String r12 = "bytes="
            r11.append(r12)     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            r11.append(r8)     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            java.lang.String r8 = "-"
            r11.append(r8)     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            java.lang.String r8 = r11.toString()     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            r6.setRequestProperty(r10, r8)     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            int r8 = r6.getResponseCode()     // Catch:{ IOException -> 0x0106, all -> 0x0101 }
            r9 = 416(0x1a0, float:5.83E-43)
            if (r8 == r9) goto L_0x00f4
            r9 = 304(0x130, float:4.26E-43)
            if (r8 != r9) goto L_0x0098
            r13.notifyDownloadFinish(r5, r7, r8, r2)     // Catch:{ IOException -> 0x00ff }
            r6.disconnect()     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            return
        L_0x0098:
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ IOException -> 0x00ff }
            boolean r9 = r13.isGzipSupported()     // Catch:{ IOException -> 0x00ff }
            if (r9 == 0) goto L_0x00ca
            java.util.Map r9 = r6.getHeaderFields()     // Catch:{ IOException -> 0x00ff }
            java.lang.String r10 = "Content-Encoding"
            java.lang.Object r9 = r9.get(r10)     // Catch:{ IOException -> 0x00ff }
            java.util.List r9 = (java.util.List) r9     // Catch:{ IOException -> 0x00ff }
            if (r9 == 0) goto L_0x00ca
            int r10 = r9.size()     // Catch:{ IOException -> 0x00ff }
            if (r10 <= 0) goto L_0x00ca
            java.lang.Object r9 = r9.get(r5)     // Catch:{ IOException -> 0x00ff }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x00ff }
            java.lang.String r10 = "gzip"
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ IOException -> 0x00ff }
            if (r9 == 0) goto L_0x00ca
            java.util.zip.GZIPInputStream r9 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00ff }
            r9.<init>(r7)     // Catch:{ IOException -> 0x00ff }
            r7 = r9
        L_0x00ca:
            int r9 = r6.getContentLength()     // Catch:{ IOException -> 0x00ff }
            java.lang.String r10 = "Etag"
            java.lang.String r2 = r6.getHeaderField(r10)     // Catch:{ IOException -> 0x00ff }
            r13.processHttpResponse(r7, r9, r8, r2)     // Catch:{ IOException -> 0x00ff }
            java.lang.Thread.interrupted()     // Catch:{ IOException -> 0x00ff }
            if (r7 == 0) goto L_0x0136
            r7.close()     // Catch:{ IOException -> 0x00e0, InterruptedException -> 0x0161, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            goto L_0x0136
        L_0x00e0:
            r7 = move-exception
            r13.notifyDownloadFinish(r5, r7, r8, r2)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.logger.logmodels.ILogExtrasModel[] r9 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r10 = r13.requestInfo     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            java.lang.String r10 = r10.url     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.logger.logmodels.ILogExtrasModel r10 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r10)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            r9[r5] = r10     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r7, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r9)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            goto L_0x0136
        L_0x00f4:
            r13.clearCache()     // Catch:{ IOException -> 0x00ff }
            java.io.IOException r9 = new java.io.IOException     // Catch:{ IOException -> 0x00ff }
            java.lang.String r10 = "Requested Range Not Satisfiable, failed with 416 status"
            r9.<init>(r10)     // Catch:{ IOException -> 0x00ff }
            throw r9     // Catch:{ IOException -> 0x00ff }
        L_0x00ff:
            r9 = move-exception
            goto L_0x0109
        L_0x0101:
            r8 = move-exception
            r9 = 0
            r9 = r8
            r8 = 0
            goto L_0x013c
        L_0x0106:
            r8 = move-exception
            r9 = r8
            r8 = 0
        L_0x0109:
            r13.notifyDownloadFinish(r5, r9, r8, r2)     // Catch:{ all -> 0x013b }
            java.lang.String r10 = "Exception in download"
            com.helpshift.logger.logmodels.ILogExtrasModel[] r11 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]     // Catch:{ all -> 0x013b }
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r12 = r13.requestInfo     // Catch:{ all -> 0x013b }
            java.lang.String r12 = r12.url     // Catch:{ all -> 0x013b }
            com.helpshift.logger.logmodels.ILogExtrasModel r12 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r12)     // Catch:{ all -> 0x013b }
            r11[r5] = r12     // Catch:{ all -> 0x013b }
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r10, (java.lang.Throwable) r9, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r11)     // Catch:{ all -> 0x013b }
            if (r7 == 0) goto L_0x0136
            r7.close()     // Catch:{ IOException -> 0x0123, InterruptedException -> 0x0161, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            goto L_0x0136
        L_0x0123:
            r7 = move-exception
            r13.notifyDownloadFinish(r5, r7, r8, r2)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.logger.logmodels.ILogExtrasModel[] r9 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r10 = r13.requestInfo     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            java.lang.String r10 = r10.url     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.logger.logmodels.ILogExtrasModel r10 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r10)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            r9[r5] = r10     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r7, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r9)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
        L_0x0136:
            r6.disconnect()     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            goto L_0x01e2
        L_0x013b:
            r9 = move-exception
        L_0x013c:
            if (r7 == 0) goto L_0x0155
            r7.close()     // Catch:{ IOException -> 0x0142, InterruptedException -> 0x0161, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            goto L_0x0155
        L_0x0142:
            r7 = move-exception
            r13.notifyDownloadFinish(r5, r7, r8, r2)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.logger.logmodels.ILogExtrasModel[] r10 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r11 = r13.requestInfo     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            java.lang.String r11 = r11.url     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.logger.logmodels.ILogExtrasModel r11 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r11)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            r10[r5] = r11     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r7, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r10)     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
        L_0x0155:
            r6.disconnect()     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
            throw r9     // Catch:{ InterruptedException -> 0x0161, MalformedURLException -> 0x015f, IOException -> 0x015d, GeneralSecurityException -> 0x015b, Exception -> 0x0159 }
        L_0x0159:
            r0 = move-exception
            goto L_0x016b
        L_0x015b:
            r0 = move-exception
            goto L_0x0182
        L_0x015d:
            r0 = move-exception
            goto L_0x0199
        L_0x015f:
            r0 = move-exception
            goto L_0x01b0
        L_0x0161:
            r0 = move-exception
            goto L_0x01c7
        L_0x0163:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            r0.<init>()     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
            throw r0     // Catch:{ InterruptedException -> 0x01c5, MalformedURLException -> 0x01ae, IOException -> 0x0197, GeneralSecurityException -> 0x0180, Exception -> 0x0169 }
        L_0x0169:
            r0 = move-exception
            r8 = 0
        L_0x016b:
            r13.notifyDownloadFinish(r5, r0, r8, r2)
            com.helpshift.logger.logmodels.ILogExtrasModel[] r2 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r4 = r13.requestInfo
            java.lang.String r4 = r4.url
            com.helpshift.logger.logmodels.ILogExtrasModel r1 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r4)
            r2[r5] = r1
            java.lang.String r1 = "Unknown Exception"
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r1, (java.lang.Throwable) r0, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r2)
            goto L_0x01e2
        L_0x0180:
            r0 = move-exception
            r8 = 0
        L_0x0182:
            r13.notifyDownloadFinish(r5, r0, r8, r2)
            com.helpshift.logger.logmodels.ILogExtrasModel[] r2 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r4 = r13.requestInfo
            java.lang.String r4 = r4.url
            com.helpshift.logger.logmodels.ILogExtrasModel r1 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r4)
            r2[r5] = r1
            java.lang.String r1 = "GeneralSecurityException"
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r1, (java.lang.Throwable) r0, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r2)
            goto L_0x01e2
        L_0x0197:
            r0 = move-exception
            r8 = 0
        L_0x0199:
            r13.notifyDownloadFinish(r5, r0, r8, r2)
            com.helpshift.logger.logmodels.ILogExtrasModel[] r2 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r4 = r13.requestInfo
            java.lang.String r4 = r4.url
            com.helpshift.logger.logmodels.ILogExtrasModel r1 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r4)
            r2[r5] = r1
            java.lang.String r1 = "Exception IO"
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r1, (java.lang.Throwable) r0, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r2)
            goto L_0x01e2
        L_0x01ae:
            r0 = move-exception
            r8 = 0
        L_0x01b0:
            r13.notifyDownloadFinish(r5, r0, r8, r2)
            com.helpshift.logger.logmodels.ILogExtrasModel[] r2 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r4 = r13.requestInfo
            java.lang.String r4 = r4.url
            com.helpshift.logger.logmodels.ILogExtrasModel r1 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r4)
            r2[r5] = r1
            java.lang.String r1 = "MalformedURLException"
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r1, (java.lang.Throwable) r0, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r2)
            goto L_0x01e2
        L_0x01c5:
            r0 = move-exception
            r8 = 0
        L_0x01c7:
            r13.notifyDownloadFinish(r5, r0, r8, r2)
            com.helpshift.logger.logmodels.ILogExtrasModel[] r2 = new com.helpshift.logger.logmodels.ILogExtrasModel[r4]
            com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo r4 = r13.requestInfo
            java.lang.String r4 = r4.url
            com.helpshift.logger.logmodels.ILogExtrasModel r1 = com.helpshift.logger.logmodels.LogExtrasModelProvider.fromString(r1, r4)
            r2[r5] = r1
            java.lang.String r1 = "Exception Interrupted"
            com.helpshift.util.HSLogger.m3243e((java.lang.String) r3, (java.lang.String) r1, (java.lang.Throwable) r0, (com.helpshift.logger.logmodels.ILogExtrasModel[]) r2)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable.run():void");
    }
}
