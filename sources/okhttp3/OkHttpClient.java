package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

public class OkHttpClient implements Cloneable, Call.Factory {
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    public static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    public final Authenticator authenticator;
    @Nullable
    public final Cache cache;
    public final int callTimeout;
    public final CertificateChainCleaner certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeout;
    public final ConnectionPool connectionPool;
    public final List<ConnectionSpec> connectionSpecs;
    public final CookieJar cookieJar;
    public final Dispatcher dispatcher;
    public final Dns dns;
    public final EventListener.Factory eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List<Interceptor> interceptors;
    @Nullable
    public final InternalCache internalCache;
    public final List<Interceptor> networkInterceptors;
    public final int pingInterval;
    public final List<Protocol> protocols;
    @Nullable
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeout;
    public final boolean retryOnConnectionFailure;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final int writeTimeout;

    static {
        Internal.instance = new Internal() {
            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.namesAndValues.add(str);
                builder.namesAndValues.add(str2.trim());
            }

            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                for (RealConnection next : connectionPool.connections) {
                    if (next.isEligible(address, (Route) null) && next.isMultiplexed() && next != streamAllocation.connection()) {
                        if (streamAllocation.codec == null && streamAllocation.connection.allocations.size() == 1) {
                            Socket deallocate = streamAllocation.deallocate(true, false, false);
                            streamAllocation.connection = next;
                            next.allocations.add(streamAllocation.connection.allocations.get(0));
                            return deallocate;
                        }
                        throw new IllegalStateException();
                    }
                }
                return null;
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                for (RealConnection next : connectionPool.connections) {
                    if (next.isEligible(address, route)) {
                        streamAllocation.acquire(next, true);
                        return next;
                    }
                }
                return null;
            }

            @Nullable
            public IOException timeoutExit(Call call, @Nullable IOException iOException) {
                return ((RealCall) call).timeoutExit(iOException);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public Call newCall(Request request) {
        RealCall realCall = new RealCall(this, request, false);
        realCall.eventListener = EventListener.this;
        return realCall;
    }

    public OkHttpClient(Builder builder) {
        boolean z;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        this.connectionSpecs = builder.connectionSpecs;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = null;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        Iterator<ConnectionSpec> it = this.connectionSpecs.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.tls) {
                    z = true;
                }
            }
        }
        if (builder.sslSocketFactory != null || !z) {
            this.sslSocketFactory = builder.sslSocketFactory;
            this.certificateChainCleaner = builder.certificateChainCleaner;
        } else {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                TrustManager[] trustManagers = instance.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                }
                X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
                try {
                    SSLContext sSLContext = Platform.PLATFORM.getSSLContext();
                    sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
                    this.sslSocketFactory = sSLContext.getSocketFactory();
                    this.certificateChainCleaner = Platform.PLATFORM.buildCertificateChainCleaner(x509TrustManager);
                } catch (GeneralSecurityException e) {
                    throw Util.assertionError("No System TLS", e);
                }
            } catch (GeneralSecurityException e2) {
                throw Util.assertionError("No System TLS", e2);
            }
        }
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        if (sSLSocketFactory != null) {
            Platform.PLATFORM.configureSslSocketFactory(sSLSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        CertificatePinner certificatePinner2 = builder.certificatePinner;
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        this.certificatePinner = !Util.equal(certificatePinner2.certificateChainCleaner, certificateChainCleaner2) ? new CertificatePinner(certificatePinner2.pins, certificateChainCleaner2) : certificatePinner2;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (this.interceptors.contains((Object) null)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Null interceptor: ");
            outline24.append(this.interceptors);
            throw new IllegalStateException(outline24.toString());
        } else if (this.networkInterceptors.contains((Object) null)) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Null network interceptor: ");
            outline242.append(this.networkInterceptors);
            throw new IllegalStateException(outline242.toString());
        }
    }

    public static final class Builder {
        public Authenticator authenticator;
        @Nullable
        public Cache cache;
        public int callTimeout;
        @Nullable
        public CertificateChainCleaner certificateChainCleaner;
        public CertificatePinner certificatePinner;
        public int connectTimeout;
        public ConnectionPool connectionPool;
        public List<ConnectionSpec> connectionSpecs;
        public CookieJar cookieJar;
        public Dispatcher dispatcher;
        public Dns dns;
        public EventListener.Factory eventListenerFactory;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public final List<Interceptor> interceptors;
        @Nullable
        public InternalCache internalCache;
        public final List<Interceptor> networkInterceptors;
        public int pingInterval;
        public List<Protocol> protocols;
        @Nullable
        public Proxy proxy;
        public Authenticator proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public boolean retryOnConnectionFailure;
        public SocketFactory socketFactory;
        @Nullable
        public SSLSocketFactory sslSocketFactory;
        public int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = new EventListener.Factory() {
            };
            ProxySelector proxySelector2 = ProxySelector.getDefault();
            this.proxySelector = proxySelector2;
            if (proxySelector2 == null) {
                this.proxySelector = new NullProxySelector();
            }
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            Authenticator authenticator2 = Authenticator.NONE;
            this.proxyAuthenticator = authenticator2;
            this.authenticator = authenticator2;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder(OkHttpClient okHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            this.interceptors.addAll(okHttpClient.interceptors);
            this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
            this.eventListenerFactory = okHttpClient.eventListenerFactory;
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = null;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.callTimeout = okHttpClient.callTimeout;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
            this.pingInterval = okHttpClient.pingInterval;
        }
    }
}
