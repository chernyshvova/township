package com.playrix.engine;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpDownloader {
    public static final String LOG_TAG = "HttpDownloader";
    public static final int MAX_THREADS_NUMBER = 5;
    public static final ExecutorService mExecutorService = Executors.newFixedThreadPool(5);
    public boolean mCatchRedirection = true;
    public int mTimeout = 30;
    public boolean mUseCache = false;

    public interface OnDownloadFinishedListener {
        void onDownloadFinished(int i, InputStream inputStream, Map<String, List<String>> map);
    }

    public void SetCatchRedirection(boolean z) {
        this.mCatchRedirection = z;
    }

    public void downloadFile_Java(final String str, final OnDownloadFinishedListener onDownloadFinishedListener) {
        mExecutorService.submit(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec  */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x00fa  */
            /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r13 = this;
                    java.lang.String r0 = "HttpDownloader"
                    r1 = -1
                    r2 = 0
                    java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00fe }
                    java.lang.String r4 = r3     // Catch:{ MalformedURLException -> 0x00fe }
                    r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x00fe }
                    com.playrix.engine.HttpDownloader r4 = com.playrix.engine.HttpDownloader.this     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
                    int r4 = r4.mTimeout     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
                    int r4 = r4 * 1000
                    java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
                    java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
                    r3.setConnectTimeout(r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    com.playrix.engine.HttpDownloader r4 = com.playrix.engine.HttpDownloader.this     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    boolean r4 = r4.mUseCache     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r3.setUseCaches(r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    long r4 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    com.playrix.engine.HttpDownloader r6 = com.playrix.engine.HttpDownloader.this     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    int r6 = r6.mTimeout     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    long r6 = (long) r6     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r8 = 1000000000(0x3b9aca00, double:4.94065646E-315)
                    long r6 = r6 * r8
                    long r6 = r6 + r4
                    r3.connect()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    int r1 = r3.getResponseCode()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r4 = 200(0xc8, float:2.8E-43)
                    if (r1 == r4) goto L_0x00ad
                    com.playrix.engine.HttpDownloader r4 = com.playrix.engine.HttpDownloader.this     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    boolean r4 = r4.mCatchRedirection     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    if (r4 == 0) goto L_0x00ad
                L_0x0049:
                    r4 = 302(0x12e, float:4.23E-43)
                    if (r1 == r4) goto L_0x0055
                    r4 = 301(0x12d, float:4.22E-43)
                    if (r1 == r4) goto L_0x0055
                    r4 = 303(0x12f, float:4.25E-43)
                    if (r1 != r4) goto L_0x00ad
                L_0x0055:
                    java.lang.String r4 = "Location"
                    java.lang.String r4 = r3.getHeaderField(r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r5.<init>()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.lang.String r8 = "Connection redirecting from "
                    r5.append(r8)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.lang.String r8 = r3     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r5.append(r8)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.lang.String r8 = " to "
                    r5.append(r8)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r5.append(r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    android.util.Log.w(r0, r5)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    long r8 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    long r8 = r6 - r8
                    r10 = 1000000(0xf4240, double:4.940656E-318)
                    long r8 = r8 / r10
                    int r5 = (int) r8     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    if (r5 > 0) goto L_0x0087
                    goto L_0x00ad
                L_0x0087:
                    java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r8.<init>(r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.net.URLConnection r4 = r8.openConnection()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
                    com.playrix.engine.HttpDownloader r3 = com.playrix.engine.HttpDownloader.this     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
                    boolean r3 = r3.mUseCache     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
                    r4.setUseCaches(r3)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
                    r4.connect()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
                    int r1 = r4.getResponseCode()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
                    r3 = r4
                    goto L_0x0049
                L_0x00a7:
                    r0 = move-exception
                    r3 = r4
                    goto L_0x00cf
                L_0x00aa:
                    r3 = move-exception
                    r5 = r2
                    goto L_0x00de
                L_0x00ad:
                    java.util.Map r4 = r3.getHeaderFields()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
                    java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c8, all -> 0x00c6 }
                    java.io.InputStream r6 = r3.getInputStream()     // Catch:{ Exception -> 0x00c8, all -> 0x00c6 }
                    r5.<init>(r6)     // Catch:{ Exception -> 0x00c8, all -> 0x00c6 }
                    com.playrix.engine.HttpDownloader$OnDownloadFinishedListener r0 = r4
                    r0.onDownloadFinished(r1, r5, r4)
                    r3.disconnect()
                    r5.close()     // Catch:{ IOException -> 0x00ef }
                    goto L_0x00ef
                L_0x00c6:
                    r0 = move-exception
                    goto L_0x00f3
                L_0x00c8:
                    r5 = move-exception
                    r12 = r4
                    r4 = r3
                    r3 = r5
                    r5 = r12
                    goto L_0x00de
                L_0x00ce:
                    r0 = move-exception
                L_0x00cf:
                    r4 = r2
                    goto L_0x00f3
                L_0x00d1:
                    r4 = move-exception
                    r5 = r2
                    r12 = r4
                    r4 = r3
                    r3 = r12
                    goto L_0x00de
                L_0x00d7:
                    r0 = move-exception
                    r3 = r2
                    r4 = r3
                    goto L_0x00f3
                L_0x00db:
                    r3 = move-exception
                    r4 = r2
                    r5 = r4
                L_0x00de:
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f0 }
                    android.util.Log.w(r0, r3)     // Catch:{ all -> 0x00f0 }
                    com.playrix.engine.HttpDownloader$OnDownloadFinishedListener r0 = r4
                    r0.onDownloadFinished(r1, r2, r5)
                    if (r4 == 0) goto L_0x00ef
                    r4.disconnect()
                L_0x00ef:
                    return
                L_0x00f0:
                    r0 = move-exception
                    r3 = r4
                    r4 = r5
                L_0x00f3:
                    com.playrix.engine.HttpDownloader$OnDownloadFinishedListener r5 = r4
                    r5.onDownloadFinished(r1, r2, r4)
                    if (r3 == 0) goto L_0x00fd
                    r3.disconnect()
                L_0x00fd:
                    throw r0
                L_0x00fe:
                    r3 = move-exception
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r0, r3)
                    com.playrix.engine.HttpDownloader$OnDownloadFinishedListener r0 = r4
                    r0.onDownloadFinished(r1, r2, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.HttpDownloader.C31661.run():void");
            }
        });
    }

    public void setTimeout(int i) {
        this.mTimeout = i;
    }

    public void useCache(boolean z) {
        this.mUseCache = z;
    }
}
