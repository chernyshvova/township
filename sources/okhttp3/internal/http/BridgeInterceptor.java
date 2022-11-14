package okhttp3.internal.http;

import com.facebook.GraphRequest;
import com.swrve.sdk.rest.RESTClient;
import com.vungle.warren.downloader.AssetDownloader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.RealBufferedSource;

public final class BridgeInterceptor implements Interceptor {
    public final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        this.cookieJar = cookieJar2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request;
        if (request != null) {
            Request.Builder builder = new Request.Builder(request);
            RequestBody requestBody = request.body;
            if (requestBody != null) {
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    builder.header("Content-Type", contentType.mediaType);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    builder.header("Content-Length", Long.toString(contentLength));
                    builder.headers.removeAll("Transfer-Encoding");
                } else {
                    builder.header("Transfer-Encoding", "chunked");
                    builder.headers.removeAll("Content-Length");
                }
            }
            if (request.headers.get("Host") == null) {
                builder.header("Host", Util.hostHeader(request.url, false));
            }
            if (request.headers.get("Connection") == null) {
                builder.header("Connection", "Keep-Alive");
            }
            if (request.headers.get(AssetDownloader.ACCEPT_ENCODING) == null && request.headers.get(AssetDownloader.RANGE) == null) {
                builder.header(AssetDownloader.ACCEPT_ENCODING, "gzip");
                z = true;
            } else {
                z = false;
            }
            if (((CookieJar.C20571) this.cookieJar) != null) {
                List emptyList = Collections.emptyList();
                if (!emptyList.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    int size = emptyList.size();
                    for (int i = 0; i < size; i++) {
                        if (i > 0) {
                            sb.append(RESTClient.SEMICOLON_SEPARATOR);
                        }
                        Cookie cookie = (Cookie) emptyList.get(i);
                        sb.append(cookie.name);
                        sb.append('=');
                        sb.append(cookie.value);
                    }
                    builder.header("Cookie", sb.toString());
                }
                if (request.headers.get(GraphRequest.USER_AGENT_HEADER) == null) {
                    builder.header(GraphRequest.USER_AGENT_HEADER, "okhttp/3.12.12");
                }
                Response proceed = realInterceptorChain.proceed(builder.build(), realInterceptorChain.streamAllocation, realInterceptorChain.httpCodec, realInterceptorChain.connection);
                HttpHeaders.receiveHeaders(this.cookieJar, request.url, proceed.headers);
                Response.Builder builder2 = new Response.Builder(proceed);
                builder2.request = request;
                if (z) {
                    String str = proceed.headers.get("Content-Encoding");
                    if (str == null) {
                        str = null;
                    }
                    if ("gzip".equalsIgnoreCase(str) && HttpHeaders.hasBody(proceed)) {
                        GzipSource gzipSource = new GzipSource(proceed.body.source());
                        Headers.Builder newBuilder = proceed.headers.newBuilder();
                        newBuilder.removeAll("Content-Encoding");
                        newBuilder.removeAll("Content-Length");
                        List<String> list = newBuilder.namesAndValues;
                        Headers.Builder builder3 = new Headers.Builder();
                        Collections.addAll(builder3.namesAndValues, (String[]) list.toArray(new String[list.size()]));
                        builder2.headers = builder3;
                        String str2 = proceed.headers.get("Content-Type");
                        if (str2 == null) {
                            str2 = null;
                        }
                        builder2.body = new RealResponseBody(str2, -1, new RealBufferedSource(gzipSource));
                    }
                }
                return builder2.build();
            }
            throw null;
        }
        throw null;
    }
}
