package com.playrix.engine;

import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.playrix.engine.HttpsTls12Helper;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.ByteString;

public class HttpManager {
    public static final int CANCELED_CODE = -2;
    public static final int ERROR_CODE = -1;
    public static final ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static OkHttpClient mainClient;
    public static final HashMap<Long, Call> queries = new HashMap<>();

    public static class HttpRequest {
        public boolean allowRedirects = true;
        public byte[] content = null;
        public String contentType = null;
        public String[] headers = null;
        public String method = null;
        public int openTimeout = 10000;
        public int readTimeout = 10000;
        public String url = null;
    }

    public static class HttpResponse {
        public int code;
        public String[] headers;
        public String message;

        public HttpResponse() {
            this.code = 0;
            this.message = null;
            this.headers = null;
        }
    }

    public static boolean addQuery(long j, Call call) {
        synchronized (queries) {
            if (queries.get(Long.valueOf(j)) != null) {
                return false;
            }
            queries.put(Long.valueOf(j), call);
            return true;
        }
    }

    public static void cancelRequest(long j) {
        Call query = getQuery(j);
        if (query != null) {
            query.cancel();
        } else {
            localLog(Long.toString(j), "No found queryId");
        }
    }

    public static Call createHttpRequest(HttpRequest httpRequest) throws Exception {
        OkHttpClient.Builder builder;
        byte[] bArr;
        synchronized (executorService) {
            if (mainClient == null) {
                enableTls12(false);
            }
            OkHttpClient okHttpClient = mainClient;
            if (okHttpClient != null) {
                builder = new OkHttpClient.Builder(okHttpClient);
            } else {
                throw null;
            }
        }
        builder.connectTimeout = Util.checkDuration("timeout", (long) httpRequest.openTimeout, TimeUnit.MILLISECONDS);
        builder.readTimeout((long) httpRequest.readTimeout, TimeUnit.MILLISECONDS);
        boolean z = httpRequest.allowRedirects;
        builder.followRedirects = z;
        builder.followSslRedirects = z;
        Request.Builder builder2 = new Request.Builder();
        builder2.url(httpRequest.url);
        if (httpRequest.headers != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String[] strArr = httpRequest.headers;
                if (i2 >= strArr.length) {
                    break;
                }
                builder2.addHeader(strArr[i + 0], strArr[i2]);
                i += 2;
            }
        }
        HttpUrl parse = HttpUrl.parse(httpRequest.url);
        if (parse != null) {
            String str = parse.username;
            if (str != null && !str.isEmpty()) {
                String str2 = parse.username;
                String str3 = parse.password;
                Charset charset = Util.ISO_8859_1;
                String base64 = ByteString.encodeString(str2 + CertificateUtil.DELIMITER + str3, charset).base64();
                StringBuilder sb = new StringBuilder();
                sb.append("Basic ");
                sb.append(base64);
                builder2.addHeader("Authorization", sb.toString());
            }
            if (httpRequest.method.equals("GET")) {
                builder2.method("GET", (RequestBody) null);
            } else if (httpRequest.method.equals("HEAD")) {
                builder2.method("HEAD", (RequestBody) null);
            } else if (httpRequest.method.equals("POST")) {
                String str4 = httpRequest.contentType;
                if (str4 == null || str4.isEmpty() || (bArr = httpRequest.content) == null || bArr.length <= 0) {
                    builder2.method("POST", RequestBody.create((MediaType) null, new byte[0]));
                } else {
                    builder2.method("POST", RequestBody.create(MediaType.parse(httpRequest.contentType), httpRequest.content));
                }
            } else {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unknown method: ");
                outline24.append(httpRequest.method);
                throw new Exception(outline24.toString());
            }
            return new OkHttpClient(builder).newCall(builder2.build());
        }
        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Cant parse url: ");
        outline242.append(httpRequest.url);
        throw new Exception(outline242.toString());
    }

    public static HttpResponse createHttpResponse(Response response) {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.code = response.code;
        httpResponse.message = response.message;
        httpResponse.headers = new String[(response.headers.size() * 2)];
        for (int i = 0; i < response.headers.size(); i++) {
            int i2 = i * 2;
            httpResponse.headers[i2 + 0] = response.headers.name(i);
            httpResponse.headers[i2 + 1] = response.headers.value(i);
        }
        return httpResponse;
    }

    public static void enableTls12(boolean z) {
        SSLContext sSLContext;
        synchronized (executorService) {
            if (mainClient == null) {
                mainClient = new OkHttpClient(new OkHttpClient.Builder());
            }
            SSLSocketFactory sSLSocketFactory = mainClient.sslSocketFactory;
            if ((z && (sSLSocketFactory instanceof HttpsTls12Helper.SSLSocketFactoryWithTls12)) || HttpsTls12Helper.checkTls12(sSLSocketFactory, "HttpManager") == 1) {
                try {
                    TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    instance.init((KeyStore) null);
                    TrustManager[] trustManagers = instance.getTrustManagers();
                    if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                    }
                    X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
                    sSLContext = SSLContext.getInstance("TLSv1.2");
                    sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
                    SSLSocketFactory enableTls12Support = HttpsTls12Helper.enableTls12Support(sSLContext.getSocketFactory(), "HttpManager");
                    OkHttpClient okHttpClient = mainClient;
                    if (okHttpClient != null) {
                        OkHttpClient.Builder builder = new OkHttpClient.Builder(okHttpClient);
                        if (enableTls12Support == null) {
                            throw new NullPointerException("sslSocketFactory == null");
                        } else if (x509TrustManager != null) {
                            builder.sslSocketFactory = enableTls12Support;
                            builder.certificateChainCleaner = Platform.PLATFORM.buildCertificateChainCleaner(x509TrustManager);
                            mainClient = new OkHttpClient(builder);
                        } else {
                            throw new NullPointerException("trustManager == null");
                        }
                    } else {
                        throw null;
                    }
                } catch (NoSuchAlgorithmException unused) {
                    sSLContext = SSLContext.getInstance("TLS");
                } catch (Throwable th) {
                    Logger.logError("Can't adjust supported protocols" + th.getMessage());
                }
            }
        }
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static Call getQuery(long j) {
        synchronized (queries) {
            if (j == 0) {
                return null;
            }
            Call call = queries.get(Long.valueOf(j));
            return call;
        }
    }

    public static long getStartTime(Response response) {
        if (response.cacheResponse != null) {
            return -1;
        }
        return response.sentRequestAtMillis;
    }

    public static boolean httpRequestAsync(final long j, HttpRequest httpRequest) {
        try {
            Call createHttpRequest = createHttpRequest(httpRequest);
            if (!addQuery(j, createHttpRequest)) {
                nativeHttpRequestFinished(j, -1, "Duplicate queryId: " + Long.toString(j));
                return false;
            }
            createHttpRequest.enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    HttpManager.onErrorFinish(j, call.isCanceled() ? -2 : -1, iOException);
                }

                public void onResponse(Call call, Response response) {
                    InputStream byteStream;
                    try {
                        ResponseBody responseBody = response.body;
                        try {
                            HttpResponse access$100 = HttpManager.createHttpResponse(response);
                            if (HttpManager.nativeHttpRequestOnHeaders(j, access$100.code, access$100.headers, HttpManager.getStartTime(response))) {
                                byteStream = responseBody.byteStream();
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = byteStream.read(bArr);
                                    if (((long) read) == -1) {
                                        break;
                                    }
                                    HttpManager.nativeHttpRequestOnAppendContent(j, bArr, read);
                                }
                                byteStream.close();
                            }
                            HttpManager.onFinish(j, access$100.code, access$100.message);
                            responseBody.close();
                        } catch (Throwable th) {
                            responseBody.close();
                            throw th;
                        }
                    } catch (Exception e) {
                        HttpManager.onErrorFinish(j, call.isCanceled() ? -2 : -1, e);
                    }
                }
            });
            return true;
        } catch (Exception e) {
            nativeHttpRequestFinished(j, -1, e.toString());
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int httpRequestSync(long r13, com.playrix.engine.HttpManager.HttpRequest r15) {
        /*
            r0 = 0
            okhttp3.Call r15 = createHttpRequest(r15)     // Catch:{ Exception -> 0x0059 }
            okhttp3.Response r1 = r15.execute()     // Catch:{ Exception -> 0x0057 }
            com.playrix.engine.HttpManager$HttpResponse r2 = createHttpResponse(r1)     // Catch:{ all -> 0x0046 }
            int r5 = r2.code     // Catch:{ all -> 0x0046 }
            java.lang.String[] r6 = r2.headers     // Catch:{ all -> 0x0046 }
            long r7 = getStartTime(r1)     // Catch:{ all -> 0x0046 }
            r3 = r13
            boolean r3 = nativeHttpRequestOnHeaders(r3, r5, r6, r7)     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x0048
            okhttp3.ResponseBody r3 = r1.body     // Catch:{ all -> 0x0046 }
            java.io.InputStream r4 = r3.byteStream()     // Catch:{ all -> 0x0041 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x003c }
        L_0x0026:
            int r6 = r4.read(r5)     // Catch:{ all -> 0x003c }
            long r7 = (long) r6     // Catch:{ all -> 0x003c }
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0035
            nativeHttpRequestOnAppendContent(r13, r5, r6)     // Catch:{ all -> 0x003c }
            goto L_0x0026
        L_0x0035:
            r4.close()     // Catch:{ all -> 0x0041 }
            r3.close()     // Catch:{ all -> 0x0046 }
            goto L_0x0048
        L_0x003c:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x0041 }
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x0046 }
            throw r0     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception
            goto L_0x0053
        L_0x0048:
            int r3 = r2.code     // Catch:{ all -> 0x0046 }
            nativeHttpRequestFinished(r13, r3, r0)     // Catch:{ all -> 0x0046 }
            int r0 = r2.code     // Catch:{ all -> 0x0046 }
            r1.close()     // Catch:{ Exception -> 0x0057 }
            return r0
        L_0x0053:
            r1.close()     // Catch:{ Exception -> 0x0057 }
            throw r0     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            r0 = move-exception
            goto L_0x005d
        L_0x0059:
            r15 = move-exception
            r12 = r0
            r0 = r15
            r15 = r12
        L_0x005d:
            if (r15 == 0) goto L_0x0067
            boolean r15 = r15.isCanceled()
            if (r15 == 0) goto L_0x0067
            r15 = -2
            goto L_0x0068
        L_0x0067:
            r15 = -1
        L_0x0068:
            java.lang.String r0 = r0.toString()
            nativeHttpRequestFinished(r13, r15, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.HttpManager.httpRequestSync(long, com.playrix.engine.HttpManager$HttpRequest):int");
    }

    public static void localLog(String str, String str2) {
        Log.d("HttpManager", str + " " + str2);
    }

    public static void logResolvedHost(final String str, final String str2) {
        executorService.submit(new Runnable() {
            public void run() {
                String str;
                try {
                    str = "";
                    for (InetAddress inetAddress : InetAddress.getAllByName(str2)) {
                        str = str + inetAddress.getHostAddress() + RESTClient.COMMA_SEPARATOR;
                    }
                } catch (UnknownHostException e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("сan't resolve host: ");
                    outline24.append(e.toString());
                    str = outline24.toString();
                }
                StringBuilder outline242 = GeneratedOutlineSupport.outline24(GeneratedOutlineSupport.outline16(str, "; Proxy state: "));
                outline242.append(!System.getProperty("http.proxyHost", "").isEmpty());
                String sb = outline242.toString();
                String str2 = str;
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("Host ");
                outline243.append(str2);
                outline243.append(" resolved to ");
                outline243.append(sb);
                HttpManager.localLog(str2, outline243.toString());
            }
        });
    }

    public static native void nativeHttpRequestFinished(long j, int i, String str);

    public static native void nativeHttpRequestOnAppendContent(long j, byte[] bArr, int i);

    public static native boolean nativeHttpRequestOnHeaders(long j, int i, String[] strArr, long j2);

    public static void onErrorFinish(long j, int i, Exception exc) {
        onFinish(j, i, exc == null ? "Unknown" : exc.toString());
    }

    public static void onFinish(long j, int i, String str) {
        removeQuery(j);
        nativeHttpRequestFinished(j, i, str);
    }

    public static Call removeQuery(long j) {
        synchronized (queries) {
            if (j == 0) {
                return null;
            }
            Call remove = queries.remove(Long.valueOf(j));
            return remove;
        }
    }
}
