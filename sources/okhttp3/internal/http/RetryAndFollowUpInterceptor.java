package okhttp3.internal.http;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
    }

    public final Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        HttpUrl httpUrl2 = httpUrl;
        if (httpUrl2.scheme.equals(Utility.URL_SCHEME)) {
            OkHttpClient okHttpClient = this.client;
            SSLSocketFactory sSLSocketFactory2 = okHttpClient.sslSocketFactory;
            HostnameVerifier hostnameVerifier2 = okHttpClient.hostnameVerifier;
            certificatePinner = okHttpClient.certificatePinner;
            sSLSocketFactory = sSLSocketFactory2;
            hostnameVerifier = hostnameVerifier2;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        String str = httpUrl2.host;
        int i = httpUrl2.port;
        OkHttpClient okHttpClient2 = this.client;
        return new Address(str, i, okHttpClient2.dns, okHttpClient2.socketFactory, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient2.proxyAuthenticator, okHttpClient2.proxy, okHttpClient2.protocols, okHttpClient2.connectionSpecs, okHttpClient2.proxySelector);
    }

    public final Request followUpRequest(Response response, Route route) throws IOException {
        HttpUrl.Builder builder;
        if (response != null) {
            int i = response.code;
            String str = response.request.method;
            RequestBody requestBody = null;
            if (i == 307 || i == 308) {
                if (!str.equals("GET") && !str.equals("HEAD")) {
                    return null;
                }
            } else if (i != 401) {
                if (i == 503) {
                    Response response2 = response.priorResponse;
                    if ((response2 == null || response2.code != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                        return response.request;
                    }
                    return null;
                } else if (i != 407) {
                    if (i != 408) {
                        switch (i) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.client.retryOnConnectionFailure) {
                        return null;
                    } else {
                        Response response3 = response.priorResponse;
                        if ((response3 == null || response3.code != 408) && retryAfter(response, 0) <= 0) {
                            return response.request;
                        }
                        return null;
                    }
                } else if (route.proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (((Authenticator.C20541) this.client.proxyAuthenticator) != null) {
                    return null;
                } else {
                    throw null;
                }
            } else if (((Authenticator.C20541) this.client.authenticator) != null) {
                return null;
            } else {
                throw null;
            }
            if (!this.client.followRedirects) {
                return null;
            }
            String str2 = response.headers.get("Location");
            if (str2 == null) {
                str2 = null;
            }
            if (str2 == null) {
                return null;
            }
            HttpUrl httpUrl = response.request.url;
            if (httpUrl != null) {
                try {
                    builder = new HttpUrl.Builder();
                    builder.parse(httpUrl, str2);
                } catch (IllegalArgumentException unused) {
                    builder = null;
                }
                HttpUrl build = builder != null ? builder.build() : null;
                if (build == null) {
                    return null;
                }
                if (!build.scheme.equals(response.request.url.scheme) && !this.client.followSslRedirects) {
                    return null;
                }
                Request request = response.request;
                if (request != null) {
                    Request.Builder builder2 = new Request.Builder(request);
                    if (zzam.permitsRequestBody(str)) {
                        boolean equals = str.equals("PROPFIND");
                        if (!str.equals("PROPFIND")) {
                            builder2.method("GET", (RequestBody) null);
                        } else {
                            if (equals) {
                                requestBody = response.request.body;
                            }
                            builder2.method(str, requestBody);
                        }
                        if (!equals) {
                            builder2.headers.removeAll("Transfer-Encoding");
                            builder2.headers.removeAll("Content-Length");
                            builder2.headers.removeAll("Content-Type");
                        }
                    }
                    if (!sameConnection(response, build)) {
                        builder2.headers.removeAll("Authorization");
                    }
                    builder2.url(build);
                    return builder2.build();
                }
                throw null;
            }
            throw null;
        }
        throw new IllegalStateException();
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpCodec httpCodec;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request;
        Call call = realInterceptorChain.call;
        EventListener eventListener = realInterceptorChain.eventListener;
        StreamAllocation streamAllocation2 = new StreamAllocation(this.client.connectionPool, createAddress(request.url), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation2;
        int i = 0;
        Response response = null;
        while (!this.canceled) {
            try {
                Response proceed = realInterceptorChain.proceed(request, streamAllocation2, (HttpCodec) null, (RealConnection) null);
                if (response != null) {
                    Response.Builder builder = new Response.Builder(proceed);
                    Response.Builder builder2 = new Response.Builder(response);
                    builder2.body = null;
                    Response build = builder2.build();
                    if (build.body == null) {
                        builder.priorResponse = build;
                        proceed = builder.build();
                    } else {
                        throw new IllegalArgumentException("priorResponse.body != null");
                    }
                }
                try {
                    Request followUpRequest = followUpRequest(proceed, streamAllocation2.route);
                    if (followUpRequest == null) {
                        streamAllocation2.release();
                        return proceed;
                    }
                    Util.closeQuietly((Closeable) proceed.body);
                    int i2 = i + 1;
                    if (i2 <= 20) {
                        if (!sameConnection(proceed, followUpRequest.url)) {
                            streamAllocation2.release();
                            streamAllocation2 = new StreamAllocation(this.client.connectionPool, createAddress(followUpRequest.url), call, eventListener, this.callStackTrace);
                            this.streamAllocation = streamAllocation2;
                        } else {
                            synchronized (streamAllocation2.connectionPool) {
                                httpCodec = streamAllocation2.codec;
                            }
                            if (httpCodec != null) {
                                throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                            }
                        }
                        response = proceed;
                        request = followUpRequest;
                        i = i2;
                    } else {
                        streamAllocation2.release();
                        throw new ProtocolException(GeneratedOutlineSupport.outline14("Too many follow-up requests: ", i2));
                    }
                } catch (IOException e) {
                    streamAllocation2.release();
                    throw e;
                }
            } catch (RouteException e2) {
                if (!recover(e2.lastException, streamAllocation2, false, request)) {
                    throw e2.firstException;
                }
            } catch (IOException e3) {
                if (!recover(e3, streamAllocation2, !(e3 instanceof ConnectionShutdownException), request)) {
                    throw e3;
                }
            } catch (Throwable th) {
                streamAllocation2.streamFailed((IOException) null);
                streamAllocation2.release();
                throw th;
            }
        }
        streamAllocation2.release();
        throw new IOException("Canceled");
    }

    public final boolean recover(IOException iOException, StreamAllocation streamAllocation2, boolean z, Request request) {
        RouteSelector.Selection selection;
        streamAllocation2.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure) {
            return false;
        }
        if (z && (iOException instanceof FileNotFoundException)) {
            return false;
        }
        if (!(!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) : (iOException instanceof SocketTimeoutException) && !z))) {
            return false;
        }
        if (!(streamAllocation2.route != null || ((selection = streamAllocation2.routeSelection) != null && selection.hasNext()) || streamAllocation2.routeSelector.hasNext())) {
            return false;
        }
        return true;
    }

    public final int retryAfter(Response response, int i) {
        String str = response.headers.get("Retry-After");
        if (str == null) {
            str = null;
        }
        if (str == null) {
            return i;
        }
        if (str.matches("\\d+")) {
            return Integer.valueOf(str).intValue();
        }
        return Integer.MAX_VALUE;
    }

    public final boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl httpUrl2 = response.request.url;
        return httpUrl2.host.equals(httpUrl.host) && httpUrl2.port == httpUrl.port && httpUrl2.scheme.equals(httpUrl.scheme);
    }
}
