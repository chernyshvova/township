package com.microsoft.appcenter.http;

import android.net.TrafficStats;
import android.os.AsyncTask;
import com.microsoft.appcenter.http.HttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class DefaultHttpClientCallTask extends AsyncTask<Void, Void, Object> {
    public static final Pattern REDIRECT_URI_REGEX_JSON = Pattern.compile("redirect_uri\":\"[^\"]+\"");
    public static final Pattern TOKEN_REGEX_JSON = Pattern.compile("token\":\"[^\"]+\"");
    public static final Pattern TOKEN_REGEX_URL_ENCODED = Pattern.compile("token=[^&]+");
    public final HttpClient.CallTemplate mCallTemplate;
    public final boolean mCompressionEnabled;
    public final Map<String, String> mHeaders;
    public final String mMethod;
    public final ServiceCallback mServiceCallback;
    public final Tracker mTracker;
    public final String mUrl;

    public interface Tracker {
    }

    public DefaultHttpClientCallTask(String str, String str2, Map<String, String> map, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback, Tracker tracker, boolean z) {
        this.mUrl = str;
        this.mMethod = str2;
        this.mHeaders = map;
        this.mCallTemplate = callTemplate;
        this.mServiceCallback = serviceCallback;
        this.mTracker = tracker;
        this.mCompressionEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[Catch:{ all -> 0x0103, all -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069 A[Catch:{ all -> 0x0103, all -> 0x01bb }, LOOP:0: B:21:0x0063->B:23:0x0069, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089 A[SYNTHETIC, Splitter:B:28:0x0089] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.microsoft.appcenter.http.HttpResponse doHttpCall() throws java.lang.Exception {
        /*
            r13 = this;
            java.net.URL r0 = new java.net.URL
            java.lang.String r1 = r13.mUrl
            r0.<init>(r1)
            javax.net.ssl.HttpsURLConnection r1 = com.microsoft.appcenter.http.HttpUtils.createHttpsConnection(r0)
            java.lang.String r2 = r13.mMethod     // Catch:{ all -> 0x01bb }
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x01bb }
            java.lang.String r2 = r13.mMethod     // Catch:{ all -> 0x01bb }
            java.lang.String r3 = "POST"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01bb }
            java.lang.String r3 = "application/json"
            r4 = 1
            r5 = 0
            java.lang.String r6 = "Content-Type"
            r7 = 0
            if (r2 == 0) goto L_0x004b
            com.microsoft.appcenter.http.HttpClient$CallTemplate r2 = r13.mCallTemplate     // Catch:{ all -> 0x01bb }
            if (r2 == 0) goto L_0x004b
            com.microsoft.appcenter.http.HttpClient$CallTemplate r2 = r13.mCallTemplate     // Catch:{ all -> 0x01bb }
            java.lang.String r2 = r2.buildRequestBody()     // Catch:{ all -> 0x01bb }
            java.lang.String r8 = "UTF-8"
            byte[] r8 = r2.getBytes(r8)     // Catch:{ all -> 0x01bb }
            boolean r9 = r13.mCompressionEnabled     // Catch:{ all -> 0x01bb }
            if (r9 == 0) goto L_0x003c
            int r9 = r8.length     // Catch:{ all -> 0x01bb }
            r10 = 1400(0x578, float:1.962E-42)
            if (r9 < r10) goto L_0x003c
            r9 = 1
            goto L_0x003d
        L_0x003c:
            r9 = 0
        L_0x003d:
            java.util.Map<java.lang.String, java.lang.String> r10 = r13.mHeaders     // Catch:{ all -> 0x01bb }
            boolean r10 = r10.containsKey(r6)     // Catch:{ all -> 0x01bb }
            if (r10 != 0) goto L_0x004e
            java.util.Map<java.lang.String, java.lang.String> r10 = r13.mHeaders     // Catch:{ all -> 0x01bb }
            r10.put(r6, r3)     // Catch:{ all -> 0x01bb }
            goto L_0x004e
        L_0x004b:
            r2 = r7
            r8 = r2
            r9 = 0
        L_0x004e:
            if (r9 == 0) goto L_0x0059
            java.util.Map<java.lang.String, java.lang.String> r10 = r13.mHeaders     // Catch:{ all -> 0x01bb }
            java.lang.String r11 = "Content-Encoding"
            java.lang.String r12 = "gzip"
            r10.put(r11, r12)     // Catch:{ all -> 0x01bb }
        L_0x0059:
            java.util.Map<java.lang.String, java.lang.String> r10 = r13.mHeaders     // Catch:{ all -> 0x01bb }
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x01bb }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x01bb }
        L_0x0063:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x01bb }
            if (r11 == 0) goto L_0x007f
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x01bb }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x01bb }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x01bb }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x01bb }
            java.lang.Object r11 = r11.getValue()     // Catch:{ all -> 0x01bb }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01bb }
            r1.setRequestProperty(r12, r11)     // Catch:{ all -> 0x01bb }
            goto L_0x0063
        L_0x007f:
            boolean r10 = r13.isCancelled()     // Catch:{ all -> 0x01bb }
            if (r10 == 0) goto L_0x0089
            r1.disconnect()
            return r7
        L_0x0089:
            com.microsoft.appcenter.http.HttpClient$CallTemplate r10 = r13.mCallTemplate     // Catch:{ all -> 0x01bb }
            if (r10 == 0) goto L_0x0094
            com.microsoft.appcenter.http.HttpClient$CallTemplate r10 = r13.mCallTemplate     // Catch:{ all -> 0x01bb }
            java.util.Map<java.lang.String, java.lang.String> r11 = r13.mHeaders     // Catch:{ all -> 0x01bb }
            r10.onBeforeCalling(r0, r11)     // Catch:{ all -> 0x01bb }
        L_0x0094:
            java.lang.String r0 = "AppCenter"
            r10 = 2
            if (r8 == 0) goto L_0x010d
            int r11 = com.microsoft.appcenter.utils.AppCenterLog.sLogLevel     // Catch:{ all -> 0x01bb }
            if (r11 > r10) goto L_0x00c9
            int r11 = r2.length()     // Catch:{ all -> 0x01bb }
            r12 = 4096(0x1000, float:5.74E-42)
            if (r11 >= r12) goto L_0x00c6
            java.util.regex.Pattern r11 = TOKEN_REGEX_URL_ENCODED     // Catch:{ all -> 0x01bb }
            java.util.regex.Matcher r2 = r11.matcher(r2)     // Catch:{ all -> 0x01bb }
            java.lang.String r11 = "token=***"
            java.lang.String r2 = r2.replaceAll(r11)     // Catch:{ all -> 0x01bb }
            java.util.Map<java.lang.String, java.lang.String> r11 = r13.mHeaders     // Catch:{ all -> 0x01bb }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ all -> 0x01bb }
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x01bb }
            if (r3 == 0) goto L_0x00c6
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x01bb }
            r3.<init>(r2)     // Catch:{ all -> 0x01bb }
            java.lang.String r2 = r3.toString(r10)     // Catch:{ all -> 0x01bb }
        L_0x00c6:
            com.microsoft.appcenter.utils.AppCenterLog.verbose(r0, r2)     // Catch:{ all -> 0x01bb }
        L_0x00c9:
            if (r9 == 0) goto L_0x00e0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01bb }
            int r3 = r8.length     // Catch:{ all -> 0x01bb }
            r2.<init>(r3)     // Catch:{ all -> 0x01bb }
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x01bb }
            r3.<init>(r2)     // Catch:{ all -> 0x01bb }
            r3.write(r8)     // Catch:{ all -> 0x01bb }
            r3.close()     // Catch:{ all -> 0x01bb }
            byte[] r8 = r2.toByteArray()     // Catch:{ all -> 0x01bb }
        L_0x00e0:
            r1.setDoOutput(r4)     // Catch:{ all -> 0x01bb }
            int r2 = r8.length     // Catch:{ all -> 0x01bb }
            r1.setFixedLengthStreamingMode(r2)     // Catch:{ all -> 0x01bb }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ all -> 0x01bb }
        L_0x00eb:
            int r3 = r8.length     // Catch:{ all -> 0x0103 }
            if (r5 >= r3) goto L_0x0105
            int r3 = r8.length     // Catch:{ all -> 0x0103 }
            int r3 = r3 - r5
            r4 = 1024(0x400, float:1.435E-42)
            int r3 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x0103 }
            r2.write(r8, r5, r3)     // Catch:{ all -> 0x0103 }
            boolean r3 = r13.isCancelled()     // Catch:{ all -> 0x0103 }
            if (r3 == 0) goto L_0x0100
            goto L_0x0105
        L_0x0100:
            int r5 = r5 + 1024
            goto L_0x00eb
        L_0x0103:
            r0 = move-exception
            goto L_0x0109
        L_0x0105:
            r2.close()     // Catch:{ all -> 0x01bb }
            goto L_0x010d
        L_0x0109:
            r2.close()     // Catch:{ all -> 0x01bb }
            throw r0     // Catch:{ all -> 0x01bb }
        L_0x010d:
            boolean r2 = r13.isCancelled()     // Catch:{ all -> 0x01bb }
            if (r2 == 0) goto L_0x0117
            r1.disconnect()
            return r7
        L_0x0117:
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x01bb }
            java.lang.String r3 = r13.readResponse(r1)     // Catch:{ all -> 0x01bb }
            int r4 = com.microsoft.appcenter.utils.AppCenterLog.sLogLevel     // Catch:{ all -> 0x01bb }
            if (r4 > r10) goto L_0x0171
            java.lang.String r4 = r1.getHeaderField(r6)     // Catch:{ all -> 0x01bb }
            if (r4 == 0) goto L_0x013d
            java.lang.String r5 = "text/"
            boolean r5 = r4.startsWith(r5)     // Catch:{ all -> 0x01bb }
            if (r5 != 0) goto L_0x013d
            java.lang.String r5 = "application/"
            boolean r4 = r4.startsWith(r5)     // Catch:{ all -> 0x01bb }
            if (r4 == 0) goto L_0x013a
            goto L_0x013d
        L_0x013a:
            java.lang.String r4 = "<binary>"
            goto L_0x0155
        L_0x013d:
            java.util.regex.Pattern r4 = TOKEN_REGEX_JSON     // Catch:{ all -> 0x01bb }
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch:{ all -> 0x01bb }
            java.lang.String r5 = "token\":\"***\""
            java.lang.String r4 = r4.replaceAll(r5)     // Catch:{ all -> 0x01bb }
            java.util.regex.Pattern r5 = REDIRECT_URI_REGEX_JSON     // Catch:{ all -> 0x01bb }
            java.util.regex.Matcher r4 = r5.matcher(r4)     // Catch:{ all -> 0x01bb }
            java.lang.String r5 = "redirect_uri\":\"***\""
            java.lang.String r4 = r4.replaceAll(r5)     // Catch:{ all -> 0x01bb }
        L_0x0155:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bb }
            r5.<init>()     // Catch:{ all -> 0x01bb }
            java.lang.String r6 = "HTTP response status="
            r5.append(r6)     // Catch:{ all -> 0x01bb }
            r5.append(r2)     // Catch:{ all -> 0x01bb }
            java.lang.String r6 = " payload="
            r5.append(r6)     // Catch:{ all -> 0x01bb }
            r5.append(r4)     // Catch:{ all -> 0x01bb }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x01bb }
            com.microsoft.appcenter.utils.AppCenterLog.verbose(r0, r4)     // Catch:{ all -> 0x01bb }
        L_0x0171:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x01bb }
            r0.<init>()     // Catch:{ all -> 0x01bb }
            java.util.Map r4 = r1.getHeaderFields()     // Catch:{ all -> 0x01bb }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x01bb }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x01bb }
        L_0x0182:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x01bb }
            if (r5 == 0) goto L_0x01a4
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x01bb }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x01bb }
            java.lang.Object r6 = r5.getKey()     // Catch:{ all -> 0x01bb }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x01bb }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x01bb }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x01bb }
            java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x01bb }
            r0.put(r6, r5)     // Catch:{ all -> 0x01bb }
            goto L_0x0182
        L_0x01a4:
            com.microsoft.appcenter.http.HttpResponse r4 = new com.microsoft.appcenter.http.HttpResponse     // Catch:{ all -> 0x01bb }
            r4.<init>(r2, r3, r0)     // Catch:{ all -> 0x01bb }
            r0 = 200(0xc8, float:2.8E-43)
            if (r2 < r0) goto L_0x01b5
            r0 = 300(0x12c, float:4.2E-43)
            if (r2 >= r0) goto L_0x01b5
            r1.disconnect()
            return r4
        L_0x01b5:
            com.microsoft.appcenter.http.HttpException r0 = new com.microsoft.appcenter.http.HttpException     // Catch:{ all -> 0x01bb }
            r0.<init>(r4)     // Catch:{ all -> 0x01bb }
            throw r0     // Catch:{ all -> 0x01bb }
        L_0x01bb:
            r0 = move-exception
            r1.disconnect()
            goto L_0x01c1
        L_0x01c0:
            throw r0
        L_0x01c1:
            goto L_0x01c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.DefaultHttpClientCallTask.doHttpCall():com.microsoft.appcenter.http.HttpResponse");
    }

    public Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        TrafficStats.setThreadStatsTag(-667034599);
        try {
            e = doHttpCall();
        } catch (Exception e) {
            e = e;
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
        TrafficStats.clearThreadStatsTag();
        return e;
    }

    public void onCancelled(Object obj) {
        if ((obj instanceof HttpResponse) || (obj instanceof HttpException)) {
            onPostExecute(obj);
            return;
        }
        DefaultHttpClient defaultHttpClient = (DefaultHttpClient) this.mTracker;
        synchronized (defaultHttpClient) {
            defaultHttpClient.mTasks.remove(this);
        }
    }

    public void onPostExecute(Object obj) {
        DefaultHttpClient defaultHttpClient = (DefaultHttpClient) this.mTracker;
        synchronized (defaultHttpClient) {
            defaultHttpClient.mTasks.remove(this);
        }
        if (obj instanceof Exception) {
            this.mServiceCallback.onCallFailed((Exception) obj);
            return;
        }
        this.mServiceCallback.onCallSucceeded((HttpResponse) obj);
    }

    public void onPreExecute() {
        DefaultHttpClient defaultHttpClient = (DefaultHttpClient) this.mTracker;
        synchronized (defaultHttpClient) {
            defaultHttpClient.mTasks.add(this);
        }
    }

    public final String readResponse(HttpsURLConnection httpsURLConnection) throws IOException {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder(Math.max(httpsURLConnection.getContentLength(), 16));
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 400) {
            inputStream = httpsURLConnection.getErrorStream();
        } else {
            inputStream = httpsURLConnection.getInputStream();
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            char[] cArr = new char[1024];
            do {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            } while (!isCancelled());
            return sb.toString();
        } finally {
            inputStream.close();
        }
    }
}
