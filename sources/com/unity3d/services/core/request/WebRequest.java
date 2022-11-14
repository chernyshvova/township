package com.unity3d.services.core.request;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class WebRequest {
    public ByteArrayOutputStream _baos;
    public String _body;
    public boolean _canceled;
    public int _connectTimeout;
    public long _contentLength;
    public Map<String, List<String>> _headers;
    public IWebRequestProgressListener _progressListener;
    public int _readTimeout;
    public String _requestType;
    public int _responseCode;
    public Map<String, List<String>> _responseHeaders;
    public URL _url;

    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map) throws MalformedURLException {
        this(str, str2, map, 30000, 30000);
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() throws NetworkIOException, IllegalArgumentException {
        HttpURLConnection httpURLConnection;
        if (getUrl().toString().startsWith("https://")) {
            try {
                httpURLConnection = (HttpsURLConnection) getUrl().openConnection();
            } catch (IOException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Open HTTPS connection: ");
                outline24.append(e.getMessage());
                throw new NetworkIOException(outline24.toString());
            }
        } else if (getUrl().toString().startsWith("http://")) {
            try {
                httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            } catch (IOException e2) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Open HTTP connection: ");
                outline242.append(e2.getMessage());
                throw new NetworkIOException(outline242.toString());
            }
        } else {
            StringBuilder outline243 = GeneratedOutlineSupport.outline24("Invalid url-protocol in url: ");
            outline243.append(getUrl().toString());
            throw new IllegalArgumentException(outline243.toString());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(getConnectTimeout());
        httpURLConnection.setReadTimeout(getReadTimeout());
        try {
            httpURLConnection.setRequestMethod(getRequestType());
            if (getHeaders() != null && getHeaders().size() > 0) {
                for (String next : getHeaders().keySet()) {
                    for (String str : getHeaders().get(next)) {
                        DeviceLog.debug("Setting header: " + next + "=" + str);
                        httpURLConnection.setRequestProperty(next, str);
                    }
                }
            }
            return httpURLConnection;
        } catch (ProtocolException e3) {
            StringBuilder outline244 = GeneratedOutlineSupport.outline24("Set Request Method: ");
            outline244.append(getRequestType());
            outline244.append(RESTClient.COMMA_SEPARATOR);
            outline244.append(e3.getMessage());
            throw new NetworkIOException(outline244.toString());
        }
    }

    public void cancel() {
        this._canceled = true;
    }

    public String getBody() {
        return this._body;
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public Map<String, List<String>> getHeaders() {
        return this._headers;
    }

    public String getQuery() {
        URL url = this._url;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public int getReadTimeout() {
        return this._readTimeout;
    }

    public String getRequestType() {
        return this._requestType;
    }

    public int getResponseCode() {
        return this._responseCode;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this._responseHeaders;
    }

    public URL getUrl() {
        return this._url;
    }

    public boolean isCanceled() {
        return this._canceled;
    }

    public String makeRequest() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this._baos = byteArrayOutputStream;
        makeStreamRequest(byteArrayOutputStream);
        return this._baos.toString("UTF-8");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007b A[SYNTHETIC, Splitter:B:27:0x007b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long makeStreamRequest(java.io.OutputStream r19) throws java.lang.Exception {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = "Error closing writer"
            java.net.HttpURLConnection r3 = r18.getHttpUrlConnectionWithHeaders()
            r0 = 1
            r3.setDoInput(r0)
            java.lang.String r4 = r18.getRequestType()
            com.unity3d.services.core.request.WebRequest$RequestType r5 = com.unity3d.services.core.request.WebRequest.RequestType.POST
            java.lang.String r5 = "POST"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r3.setDoOutput(r0)
            r4 = 0
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0057 }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0057 }
            java.io.OutputStream r7 = r3.getOutputStream()     // Catch:{ IOException -> 0x0057 }
            java.lang.String r8 = "UTF-8"
            r6.<init>(r7, r8)     // Catch:{ IOException -> 0x0057 }
            r5.<init>(r6, r0)     // Catch:{ IOException -> 0x0057 }
            java.lang.String r0 = r18.getBody()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            if (r0 != 0) goto L_0x003c
            java.lang.String r0 = r18.getQuery()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            r5.print(r0)     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            goto L_0x0043
        L_0x003c:
            java.lang.String r0 = r18.getBody()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            r5.print(r0)     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
        L_0x0043:
            r5.flush()     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
            r5.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x0086
        L_0x004a:
            r0 = move-exception
            r3 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r2, r3)
            throw r3
        L_0x0050:
            r0 = move-exception
            goto L_0x0079
        L_0x0052:
            r0 = move-exception
            r4 = r5
            goto L_0x0058
        L_0x0055:
            r0 = move-exception
            goto L_0x0078
        L_0x0057:
            r0 = move-exception
        L_0x0058:
            java.lang.String r3 = "Error while writing POST params"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r0)     // Catch:{ all -> 0x0055 }
            com.unity3d.services.core.request.NetworkIOException r3 = new com.unity3d.services.core.request.NetworkIOException     // Catch:{ all -> 0x0055 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r5.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = "Error writing POST params: "
            r5.append(r6)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0055 }
            r5.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0055 }
            r3.<init>(r0)     // Catch:{ all -> 0x0055 }
            throw r3     // Catch:{ all -> 0x0055 }
        L_0x0078:
            r5 = r4
        L_0x0079:
            if (r5 == 0) goto L_0x0085
            r5.close()     // Catch:{ Exception -> 0x007f }
            goto L_0x0085
        L_0x007f:
            r0 = move-exception
            r3 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r2, r3)
            throw r3
        L_0x0085:
            throw r0
        L_0x0086:
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            r1._responseCode = r0     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            int r0 = r3.getContentLength()
            long r4 = (long) r0
            r1._contentLength = r4
            r6 = -1
            r2 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00a3
            java.lang.String r0 = "X-OrigLength"
            int r0 = r3.getHeaderFieldInt(r0, r2)
            long r4 = (long) r0
            r1._contentLength = r4
        L_0x00a3:
            java.io.ByteArrayOutputStream r0 = r1._baos
            r4 = 0
            r6 = r19
            if (r0 == 0) goto L_0x00be
            if (r0 != r6) goto L_0x00be
            long r7 = r1._contentLength
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00be
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            long r6 = r1._contentLength
            int r7 = (int) r6
            r0.<init>(r7)
            r1._baos = r0
            r6 = r0
        L_0x00be:
            java.util.Map r0 = r3.getHeaderFields()
            if (r0 == 0) goto L_0x00ca
            java.util.Map r0 = r3.getHeaderFields()
            r1._responseHeaders = r0
        L_0x00ca:
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d7
        L_0x00cf:
            r0 = move-exception
            r7 = r0
            java.io.InputStream r0 = r3.getErrorStream()
            if (r0 == 0) goto L_0x0158
        L_0x00d7:
            com.unity3d.services.core.request.IWebRequestProgressListener r7 = r1._progressListener
            if (r7 == 0) goto L_0x00ec
            java.net.URL r8 = r18.getUrl()
            java.lang.String r8 = r8.toString()
            long r9 = r1._contentLength
            int r11 = r1._responseCode
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12 = r1._responseHeaders
            r7.onRequestStart(r8, r9, r11, r12)
        L_0x00ec:
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream
            r7.<init>(r0)
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            r8 = 0
            r9 = 0
        L_0x00f7:
            boolean r10 = r18.isCanceled()
            if (r10 != 0) goto L_0x0151
            if (r9 == r2) goto L_0x0151
            int r9 = r7.read(r0)     // Catch:{ IOException -> 0x0138, Exception -> 0x011f }
            if (r9 <= 0) goto L_0x00f7
            r6.write(r0, r8, r9)
            long r10 = (long) r9
            long r4 = r4 + r10
            com.unity3d.services.core.request.IWebRequestProgressListener r12 = r1._progressListener
            if (r12 == 0) goto L_0x00f7
            java.net.URL r10 = r18.getUrl()
            java.lang.String r13 = r10.toString()
            long r10 = r1._contentLength
            r14 = r4
            r16 = r10
            r12.onRequestProgress(r13, r14, r16)
            goto L_0x00f7
        L_0x011f:
            r0 = move-exception
            r2 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r3 = "Unknown Exception: "
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0138:
            r0 = move-exception
            r2 = r0
            com.unity3d.services.core.request.NetworkIOException r0 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.String r3 = "Network exception: "
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0151:
            r3.disconnect()
            r6.flush()
            return r4
        L_0x0158:
            com.unity3d.services.core.request.NetworkIOException r0 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.String r2 = "Can't open error stream: "
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            java.lang.String r3 = r7.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x016f:
            r0 = move-exception
            goto L_0x0172
        L_0x0171:
            r0 = move-exception
        L_0x0172:
            com.unity3d.services.core.request.NetworkIOException r2 = new com.unity3d.services.core.request.NetworkIOException
            java.lang.String r3 = "Response code: "
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            goto L_0x018a
        L_0x0189:
            throw r2
        L_0x018a:
            goto L_0x0189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.request.WebRequest.makeStreamRequest(java.io.OutputStream):long");
    }

    public void setBody(String str) {
        this._body = str;
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    public void setProgressListener(IWebRequestProgressListener iWebRequestProgressListener) {
        this._progressListener = iWebRequestProgressListener;
    }

    public void setReadTimeout(int i) {
        this._readTimeout = i;
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map, int i, int i2) throws MalformedURLException {
        RequestType requestType = RequestType.GET;
        this._requestType = "GET";
        this._responseCode = -1;
        this._contentLength = -1;
        this._canceled = false;
        this._url = new URL(str);
        this._requestType = str2;
        this._headers = map;
        this._connectTimeout = i;
        this._readTimeout = i2;
    }
}
