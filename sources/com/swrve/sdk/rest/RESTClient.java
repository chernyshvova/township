package com.swrve.sdk.rest;

import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RESTClient implements IRESTClient {
    public static final String CHARSET = "UTF-8";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String SEMICOLON_SEPARATOR = "; ";
    public static List<String> metrics = new ArrayList();
    public final int httpTimeout;

    public RESTClient(int i) {
        this.httpTimeout = i;
    }

    private boolean addMetric(List<String> list, long j, List<String> list2, String str, boolean z) {
        if (j > 0) {
            for (String format : list2) {
                list.add(String.format(format, new Object[]{Long.valueOf(j)}));
            }
            return true;
        }
        list.add(str);
        if (z) {
            for (String format2 : list2) {
                list.add(String.format(format2, new Object[]{Integer.valueOf(this.httpTimeout)}));
            }
        }
        synchronized (metrics) {
            metrics.add(printList(list, COMMA_SEPARATOR));
        }
        return false;
    }

    private HttpURLConnection addMetricsHeader(HttpURLConnection httpURLConnection) {
        ArrayList arrayList = new ArrayList();
        synchronized (metrics) {
            arrayList.addAll(metrics);
            metrics.clear();
        }
        if (!arrayList.isEmpty()) {
            httpURLConnection.addRequestProperty("Swrve-Latency-Metrics", printList(arrayList, SEMICOLON_SEPARATOR));
        }
        return httpURLConnection;
    }

    private String getUrlWithoutPathOrQuery(String str) throws MalformedURLException {
        URL url = new URL(str);
        return String.format("%s://%s", new Object[]{url.getProtocol(), url.getAuthority()});
    }

    private long milisecondsFrom(long j) {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime() - j, TimeUnit.NANOSECONDS);
    }

    private String printList(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (String append : list) {
            sb.append(append);
            size--;
            if (size > 0) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private void recordGetMetrics(String str, long j, long j2, long j3, boolean z) {
        recordMetrics(false, str, j, j2, j2, j3, z);
    }

    private void recordMetrics(boolean z, String str, long j, long j2, long j3, long j4, boolean z2) {
        ArrayList arrayList = new ArrayList();
        try {
            String str2 = str;
            arrayList.add(String.format("u=%s", new Object[]{getUrlWithoutPathOrQuery(str)}));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("c=%d");
            if (addMetric(arrayList, j, arrayList2, "c_error=1", z2)) {
                arrayList2.clear();
                arrayList2.add("sh=%d");
                arrayList2.add("sb=%d");
                if (z) {
                    if (addMetric(arrayList, j2, arrayList2, "sb_error=1", z2)) {
                        arrayList2.clear();
                    } else {
                        return;
                    }
                }
                arrayList2.add("rh=%d");
                if (addMetric(arrayList, j3, arrayList2, "rh_error=1", z2)) {
                    arrayList2.clear();
                    arrayList2.add("rb=%d");
                    if (addMetric(arrayList, j4, arrayList2, "rb_error=1", z2)) {
                        arrayList2.clear();
                        synchronized (metrics) {
                            metrics.add(printList(arrayList, COMMA_SEPARATOR));
                        }
                    }
                }
            }
        } catch (Exception e) {
            SwrveLogger.m2754e(Log.getStackTraceString(e), new Object[0]);
        }
    }

    private void recordPostMetrics(String str, long j, long j2, long j3, long j4, boolean z) {
        recordMetrics(true, str, j, j2, j3, j4, z);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a3, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
        r18 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r18 = null;
        r16 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bb, code lost:
        r11 = r0;
        r16 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a2 A[ExcHandler: all (r0v27 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:26:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ba A[ExcHandler: all (r0v19 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010b A[Catch:{ all -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0115 A[SYNTHETIC, Splitter:B:79:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x014c A[SYNTHETIC, Splitter:B:94:0x014c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void get(java.lang.String r20, com.swrve.sdk.rest.IRESTResponseListener r21) {
        /*
            r19 = this;
            r10 = r19
            r2 = r20
            r11 = r21
            java.lang.String r0 = "gzip"
            r3 = 0
            r1 = 0
            r5 = 0
            r6 = 503(0x1f7, float:7.05E-43)
            r9 = 0
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x00f6, all -> 0x00ef }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00f6, all -> 0x00ef }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ Exception -> 0x00f6, all -> 0x00ef }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00f6, all -> 0x00ef }
            int r8 = r10.httpTimeout     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            r7.setReadTimeout(r8)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            int r8 = r10.httpTimeout     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            r7.setConnectTimeout(r8)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            java.lang.String r8 = "GET"
            r7.setRequestMethod(r8)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            java.lang.String r8 = "Accept-Charset"
            java.lang.String r12 = "UTF-8"
            r7.setRequestProperty(r8, r12)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            java.lang.String r8 = "Connection"
            java.lang.String r12 = "close"
            r7.setRequestProperty(r8, r12)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            java.lang.String r8 = "Accept-Encoding"
            r7.setRequestProperty(r8, r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            java.net.HttpURLConnection r12 = r10.addMetricsHeader(r7)     // Catch:{ Exception -> 0x00e8, all -> 0x00df }
            long r7 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x00db, all -> 0x00d4 }
            r12.connect()     // Catch:{ IOException -> 0x00c7 }
            long r13 = r10.milisecondsFrom(r7)     // Catch:{ Exception -> 0x00db, all -> 0x00d4 }
            int r15 = r12.getResponseCode()     // Catch:{ Exception -> 0x00c0, all -> 0x00ba }
            long r16 = r10.milisecondsFrom(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00ba }
            java.io.InputStream r3 = r12.getErrorStream()     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            if (r3 != 0) goto L_0x005d
            java.io.InputStream r3 = r12.getInputStream()     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
        L_0x005d:
            java.lang.String r4 = r12.getContentEncoding()     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            if (r4 == 0) goto L_0x0075
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.lang.String r4 = r4.toLowerCase(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            boolean r0 = r4.contains(r0)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            if (r0 == 0) goto L_0x0075
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            goto L_0x007a
        L_0x0075:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
        L_0x007a:
            com.swrve.sdk.rest.SwrveFilterInputStream r3 = new com.swrve.sdk.rest.SwrveFilterInputStream     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.lang.String r18 = com.swrve.sdk.SwrveHelper.readStringFromInputStream(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a2 }
            long r7 = r10.milisecondsFrom(r7)     // Catch:{ Exception -> 0x00a0, all -> 0x00a2 }
            r12.disconnect()
            r3.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0099
        L_0x008e:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.swrve.sdk.SwrveLogger.m2754e(r0, r1)
        L_0x0099:
            r1 = r19
            r2 = r20
            r3 = r13
            goto L_0x012a
        L_0x00a0:
            r0 = move-exception
            goto L_0x00a9
        L_0x00a2:
            r0 = move-exception
            r11 = r0
            goto L_0x0144
        L_0x00a6:
            r0 = move-exception
            r18 = r1
        L_0x00a9:
            r1 = r3
            goto L_0x00b8
        L_0x00ab:
            r0 = move-exception
            r11 = r0
            goto L_0x0143
        L_0x00af:
            r0 = move-exception
            r18 = r1
            goto L_0x00b8
        L_0x00b3:
            r0 = move-exception
            r18 = r1
            r16 = r3
        L_0x00b8:
            r3 = r13
            goto L_0x00fe
        L_0x00ba:
            r0 = move-exception
            r11 = r0
            r16 = r3
            goto L_0x0143
        L_0x00c0:
            r0 = move-exception
            r18 = r1
            r16 = r3
            r3 = r13
            goto L_0x00fc
        L_0x00c7:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "RESTClient unable to connect to %s"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x00db, all -> 0x00d4 }
            r8[r5] = r2     // Catch:{ Exception -> 0x00db, all -> 0x00d4 }
            com.swrve.sdk.SwrveLogger.m2754e(r0, r8)     // Catch:{ Exception -> 0x00db, all -> 0x00d4 }
            throw r7     // Catch:{ Exception -> 0x00db, all -> 0x00d4 }
        L_0x00d4:
            r0 = move-exception
            r11 = r0
            r13 = r3
            r16 = r13
            goto L_0x0143
        L_0x00db:
            r0 = move-exception
            r18 = r1
            goto L_0x00fa
        L_0x00df:
            r0 = move-exception
            r11 = r0
            r13 = r3
            r16 = r13
            r3 = r1
            r1 = r7
            goto L_0x0145
        L_0x00e8:
            r0 = move-exception
            r18 = r1
            r16 = r3
            r12 = r7
            goto L_0x00fc
        L_0x00ef:
            r0 = move-exception
            r11 = r0
            r13 = r3
            r16 = r13
            r3 = r1
            goto L_0x0145
        L_0x00f6:
            r0 = move-exception
            r12 = r1
            r18 = r12
        L_0x00fa:
            r16 = r3
        L_0x00fc:
            r15 = 503(0x1f7, float:7.05E-43)
        L_0x00fe:
            java.lang.String r6 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x0140 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x0140 }
            com.swrve.sdk.SwrveLogger.m2754e(r6, r7)     // Catch:{ all -> 0x0140 }
            boolean r9 = r0 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x0140 }
            if (r11 == 0) goto L_0x010e
            r11.onException(r0)     // Catch:{ all -> 0x0140 }
        L_0x010e:
            if (r12 == 0) goto L_0x0113
            r12.disconnect()
        L_0x0113:
            if (r1 == 0) goto L_0x0124
            r1.close()     // Catch:{ IOException -> 0x0119 }
            goto L_0x0124
        L_0x0119:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.swrve.sdk.SwrveLogger.m2754e(r0, r1)
        L_0x0124:
            r7 = 0
            r1 = r19
            r2 = r20
        L_0x012a:
            r5 = r16
            r1.recordGetMetrics(r2, r3, r5, r7, r9)
            r0 = r18
            if (r11 == 0) goto L_0x013f
            com.swrve.sdk.rest.RESTResponse r1 = new com.swrve.sdk.rest.RESTResponse
            java.util.Map r2 = r12.getHeaderFields()
            r1.<init>(r15, r0, r2)
            r11.onResponse(r1)
        L_0x013f:
            return
        L_0x0140:
            r0 = move-exception
            r11 = r0
            r13 = r3
        L_0x0143:
            r3 = r1
        L_0x0144:
            r1 = r12
        L_0x0145:
            if (r1 == 0) goto L_0x014a
            r1.disconnect()
        L_0x014a:
            if (r3 == 0) goto L_0x015b
            r3.close()     // Catch:{ IOException -> 0x0150 }
            goto L_0x015b
        L_0x0150:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.swrve.sdk.SwrveLogger.m2754e(r0, r1)
        L_0x015b:
            r7 = 0
            r1 = r19
            r2 = r20
            r3 = r13
            r5 = r16
            r1.recordGetMetrics(r2, r3, r5, r7, r9)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.rest.RESTClient.get(java.lang.String, com.swrve.sdk.rest.IRESTResponseListener):void");
    }

    public void post(String str, String str2, IRESTResponseListener iRESTResponseListener) {
        post(str, str2, iRESTResponseListener, "application/json");
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b6, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b9, code lost:
        r20 = null;
        r5 = r6;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c5, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cd, code lost:
        r13 = r0;
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0130, code lost:
        r13.onException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0135, code lost:
        r14.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x013f, code lost:
        com.swrve.sdk.SwrveLogger.m2754e(android.util.Log.getStackTraceString(r0), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016e, code lost:
        r3.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0177, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0178, code lost:
        com.swrve.sdk.SwrveLogger.m2754e(android.util.Log.getStackTraceString(r0), new java.lang.Object[0]);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5 A[ExcHandler: all (r0v36 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:22:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cc A[ExcHandler: all (r0v27 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:12:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0130 A[Catch:{ all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x013a A[SYNTHETIC, Splitter:B:81:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0173 A[SYNTHETIC, Splitter:B:96:0x0173] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void post(java.lang.String r22, java.lang.String r23, com.swrve.sdk.rest.IRESTResponseListener r24, java.lang.String r25) {
        /*
            r21 = this;
            r12 = r21
            r13 = r24
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 503(0x1f7, float:7.05E-43)
            r11 = 0
            r6 = r23
            byte[] r6 = r6.getBytes(r0)     // Catch:{ Exception -> 0x0119, all -> 0x010f }
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x0119, all -> 0x010f }
            r8 = r22
            r7.<init>(r8)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            int r9 = r12.httpTimeout     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            r7.setReadTimeout(r9)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            int r9 = r12.httpTimeout     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            r7.setConnectTimeout(r9)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            java.lang.String r9 = "POST"
            r7.setRequestMethod(r9)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            java.lang.String r9 = "Content-Type"
            r10 = r25
            r7.setRequestProperty(r9, r10)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            java.lang.String r9 = "Accept-Charset"
            r7.setRequestProperty(r9, r0)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            java.lang.String r0 = "Connection"
            java.lang.String r9 = "close"
            r7.setRequestProperty(r0, r9)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            int r0 = r6.length     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            r7.setFixedLengthStreamingMode(r0)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            r0 = 1
            r7.setDoOutput(r0)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            r7.setDoInput(r0)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            r7.setUseCaches(r4)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            java.net.HttpURLConnection r14 = r12.addMetricsHeader(r7)     // Catch:{ Exception -> 0x0102, all -> 0x00f8 }
            long r9 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x00f0, all -> 0x00e8 }
            r14.connect()     // Catch:{ Exception -> 0x00f0, all -> 0x00e8 }
            long r15 = r12.milisecondsFrom(r9)     // Catch:{ Exception -> 0x00f0, all -> 0x00e8 }
            java.io.OutputStream r0 = r14.getOutputStream()     // Catch:{ Exception -> 0x00e3, all -> 0x00dc }
            r0.write(r6)     // Catch:{ Exception -> 0x00e3, all -> 0x00dc }
            r0.close()     // Catch:{ Exception -> 0x00e3, all -> 0x00dc }
            long r6 = r12.milisecondsFrom(r9)     // Catch:{ Exception -> 0x00e3, all -> 0x00dc }
            int r17 = r14.getResponseCode()     // Catch:{ Exception -> 0x00d4, all -> 0x00cc }
            long r18 = r12.milisecondsFrom(r9)     // Catch:{ Exception -> 0x00c4, all -> 0x00cc }
            java.io.InputStream r0 = r14.getErrorStream()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            if (r0 != 0) goto L_0x0085
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.io.InputStream r1 = r14.getInputStream()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            goto L_0x008b
        L_0x0085:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            r0 = r1
        L_0x008b:
            com.swrve.sdk.rest.SwrveFilterInputStream r1 = new com.swrve.sdk.rest.SwrveFilterInputStream     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.String r20 = com.swrve.sdk.SwrveHelper.readStringFromInputStream(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            long r9 = r12.milisecondsFrom(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00b5 }
            r14.disconnect()
            r1.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00aa
        L_0x009f:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.swrve.sdk.SwrveLogger.m2754e(r0, r1)
        L_0x00aa:
            r1 = r21
            r2 = r22
            r3 = r15
            r5 = r6
            goto L_0x0150
        L_0x00b2:
            r0 = move-exception
            r3 = r1
            goto L_0x00c9
        L_0x00b5:
            r0 = move-exception
            r13 = r0
            goto L_0x00d1
        L_0x00b8:
            r0 = move-exception
            r20 = r3
            r5 = r6
            r3 = r1
            goto L_0x0125
        L_0x00bf:
            r0 = move-exception
            r13 = r0
            goto L_0x00d0
        L_0x00c2:
            r0 = move-exception
            goto L_0x00c7
        L_0x00c4:
            r0 = move-exception
            r18 = r1
        L_0x00c7:
            r20 = r3
        L_0x00c9:
            r5 = r6
            goto L_0x0125
        L_0x00cc:
            r0 = move-exception
            r13 = r0
            r18 = r1
        L_0x00d0:
            r1 = r3
        L_0x00d1:
            r5 = r6
            goto L_0x016b
        L_0x00d4:
            r0 = move-exception
            r18 = r1
            r20 = r3
            r5 = r6
            goto L_0x0123
        L_0x00dc:
            r0 = move-exception
            r13 = r0
            r5 = r1
            r18 = r5
            goto L_0x016a
        L_0x00e3:
            r0 = move-exception
            r5 = r1
            r18 = r5
            goto L_0x00f5
        L_0x00e8:
            r0 = move-exception
            r13 = r0
            r5 = r1
            r15 = r5
            r18 = r15
            goto L_0x016a
        L_0x00f0:
            r0 = move-exception
            r5 = r1
            r15 = r5
            r18 = r15
        L_0x00f5:
            r20 = r3
            goto L_0x0123
        L_0x00f8:
            r0 = move-exception
            r13 = r0
            r5 = r1
            r15 = r5
            r18 = r15
            r1 = r3
            r3 = r7
            goto L_0x016c
        L_0x0102:
            r0 = move-exception
            r5 = r1
            r15 = r5
            r18 = r15
            r20 = r3
            r14 = r7
            goto L_0x0123
        L_0x010b:
            r0 = move-exception
            goto L_0x0112
        L_0x010d:
            r0 = move-exception
            goto L_0x011c
        L_0x010f:
            r0 = move-exception
            r8 = r22
        L_0x0112:
            r13 = r0
            r5 = r1
            r15 = r5
            r18 = r15
            r1 = r3
            goto L_0x016c
        L_0x0119:
            r0 = move-exception
            r8 = r22
        L_0x011c:
            r5 = r1
            r15 = r5
            r18 = r15
            r14 = r3
            r20 = r14
        L_0x0123:
            r17 = 503(0x1f7, float:7.05E-43)
        L_0x0125:
            java.lang.String r1 = "Got exception while trying to open post connection"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x0168 }
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r2)     // Catch:{ all -> 0x0168 }
            boolean r11 = r0 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x0168 }
            if (r13 == 0) goto L_0x0133
            r13.onException(r0)     // Catch:{ all -> 0x0168 }
        L_0x0133:
            if (r14 == 0) goto L_0x0138
            r14.disconnect()
        L_0x0138:
            if (r3 == 0) goto L_0x0149
            r3.close()     // Catch:{ IOException -> 0x013e }
            goto L_0x0149
        L_0x013e:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.swrve.sdk.SwrveLogger.m2754e(r0, r1)
        L_0x0149:
            r9 = 0
            r1 = r21
            r2 = r22
            r3 = r15
        L_0x0150:
            r7 = r18
            r1.recordPostMetrics(r2, r3, r5, r7, r9, r11)
            r0 = r17
            r1 = r20
            if (r13 == 0) goto L_0x0167
            com.swrve.sdk.rest.RESTResponse r2 = new com.swrve.sdk.rest.RESTResponse
            java.util.Map r3 = r14.getHeaderFields()
            r2.<init>(r0, r1, r3)
            r13.onResponse(r2)
        L_0x0167:
            return
        L_0x0168:
            r0 = move-exception
            r13 = r0
        L_0x016a:
            r1 = r3
        L_0x016b:
            r3 = r14
        L_0x016c:
            if (r3 == 0) goto L_0x0171
            r3.disconnect()
        L_0x0171:
            if (r1 == 0) goto L_0x0182
            r1.close()     // Catch:{ IOException -> 0x0177 }
            goto L_0x0182
        L_0x0177:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.swrve.sdk.SwrveLogger.m2754e(r0, r1)
        L_0x0182:
            r9 = 0
            r1 = r21
            r2 = r22
            r3 = r15
            r7 = r18
            r1.recordPostMetrics(r2, r3, r5, r7, r9, r11)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.rest.RESTClient.post(java.lang.String, java.lang.String, com.swrve.sdk.rest.IRESTResponseListener, java.lang.String):void");
    }

    public void get(String str, Map<String, String> map, IRESTResponseListener iRESTResponseListener) throws UnsupportedEncodingException {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "?");
        outline26.append(SwrveHelper.encodeParameters(map));
        get(outline26.toString(), iRESTResponseListener);
    }
}
