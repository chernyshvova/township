package okhttp3.internal.connection;

import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Source;

public final class RealConnection extends Http2Connection.Listener {
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public final ConnectionPool connectionPool;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNanos = RecyclerView.FOREVER_NS;
    public boolean noNewStreams;
    public Protocol protocol;
    public Socket rawSocket;
    public final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool2, Route route2) {
        this.connectionPool = connectionPool2;
        this.route = route2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x013c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x013c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x013c, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r16, int r17, int r18, int r19, boolean r20, okhttp3.Call r21, okhttp3.EventListener r22) {
        /*
            r15 = this;
            r7 = r15
            r8 = r21
            r9 = r22
            okhttp3.Protocol r0 = r7.protocol
            if (r0 != 0) goto L_0x014f
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address
            java.util.List<okhttp3.ConnectionSpec> r0 = r0.connectionSpecs
            okhttp3.internal.connection.ConnectionSpecSelector r10 = new okhttp3.internal.connection.ConnectionSpecSelector
            r10.<init>(r0)
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address
            javax.net.ssl.SSLSocketFactory r2 = r1.sslSocketFactory
            if (r2 != 0) goto L_0x0055
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0048
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address
            okhttp3.HttpUrl r0 = r0.url
            java.lang.String r0 = r0.host
            okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.PLATFORM
            boolean r1 = r1.isCleartextTrafficPermitted(r0)
            if (r1 == 0) goto L_0x0035
            goto L_0x005f
        L_0x0035:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication to "
            java.lang.String r4 = " not permitted by network security policy"
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline17(r3, r0, r4)
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0048:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0055:
            java.util.List<okhttp3.Protocol> r0 = r1.protocols
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0142
        L_0x005f:
            r11 = 0
            r12 = r11
        L_0x0061:
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00cd }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00cd }
            if (r0 == 0) goto L_0x0081
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r21
            r6 = r22
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00cd }
            java.net.Socket r0 = r7.rawSocket     // Catch:{ IOException -> 0x00cd }
            if (r0 != 0) goto L_0x007c
            goto L_0x0097
        L_0x007c:
            r1 = r16
            r2 = r17
            goto L_0x0088
        L_0x0081:
            r1 = r16
            r2 = r17
            r15.connectSocket(r1, r2, r8, r9)     // Catch:{ IOException -> 0x00c9 }
        L_0x0088:
            r3 = r19
            r15.establishProtocol(r10, r3, r8, r9)     // Catch:{ IOException -> 0x00c7 }
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00c7 }
            java.net.InetSocketAddress r0 = r0.inetSocketAddress     // Catch:{ IOException -> 0x00c7 }
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00c7 }
            java.net.Proxy r0 = r0.proxy     // Catch:{ IOException -> 0x00c7 }
            if (r9 == 0) goto L_0x00c6
        L_0x0097:
            okhttp3.Route r0 = r7.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x00b1
            java.net.Socket r0 = r7.rawSocket
            if (r0 == 0) goto L_0x00a4
            goto L_0x00b1
        L_0x00a4:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00b1:
            okhttp3.internal.http2.Http2Connection r0 = r7.http2Connection
            if (r0 == 0) goto L_0x00c5
            okhttp3.ConnectionPool r1 = r7.connectionPool
            monitor-enter(r1)
            okhttp3.internal.http2.Http2Connection r0 = r7.http2Connection     // Catch:{ all -> 0x00c2 }
            int r0 = r0.maxConcurrentStreams()     // Catch:{ all -> 0x00c2 }
            r7.allocationLimit = r0     // Catch:{ all -> 0x00c2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            goto L_0x00c5
        L_0x00c2:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            throw r0
        L_0x00c5:
            return
        L_0x00c6:
            throw r11     // Catch:{ IOException -> 0x00c7 }
        L_0x00c7:
            r0 = move-exception
            goto L_0x00d3
        L_0x00c9:
            r0 = move-exception
        L_0x00ca:
            r3 = r19
            goto L_0x00d3
        L_0x00cd:
            r0 = move-exception
            r1 = r16
            r2 = r17
            goto L_0x00ca
        L_0x00d3:
            java.net.Socket r4 = r7.socket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r4)
            java.net.Socket r4 = r7.rawSocket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r4)
            r7.socket = r11
            r7.rawSocket = r11
            r7.source = r11
            r7.sink = r11
            r7.handshake = r11
            r7.protocol = r11
            r7.http2Connection = r11
            okhttp3.Route r4 = r7.route
            java.net.InetSocketAddress r4 = r4.inetSocketAddress
            if (r9 == 0) goto L_0x0141
            r4 = 1
            r5 = 0
            if (r12 != 0) goto L_0x00fb
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x010a
        L_0x00fb:
            java.io.IOException r6 = r12.firstException
            java.lang.reflect.Method r13 = okhttp3.internal.Util.addSuppressedExceptionMethod
            if (r13 == 0) goto L_0x0108
            java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0108 }
            r14[r5] = r0     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0108 }
            r13.invoke(r6, r14)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0108 }
        L_0x0108:
            r12.lastException = r0
        L_0x010a:
            if (r20 == 0) goto L_0x0140
            r10.isFallback = r4
            boolean r6 = r10.isFallbackPossible
            if (r6 != 0) goto L_0x0113
            goto L_0x013c
        L_0x0113:
            boolean r6 = r0 instanceof java.net.ProtocolException
            if (r6 == 0) goto L_0x0118
            goto L_0x013c
        L_0x0118:
            boolean r6 = r0 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L_0x011d
            goto L_0x013c
        L_0x011d:
            boolean r6 = r0 instanceof javax.net.ssl.SSLHandshakeException
            if (r6 == 0) goto L_0x012a
            java.lang.Throwable r13 = r0.getCause()
            boolean r13 = r13 instanceof java.security.cert.CertificateException
            if (r13 == 0) goto L_0x012a
            goto L_0x013c
        L_0x012a:
            boolean r13 = r0 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r13 == 0) goto L_0x012f
            goto L_0x013c
        L_0x012f:
            if (r6 != 0) goto L_0x013b
            boolean r5 = r0 instanceof javax.net.ssl.SSLProtocolException
            if (r5 != 0) goto L_0x013b
            boolean r0 = r0 instanceof javax.net.ssl.SSLException
            if (r0 == 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r4 = 0
        L_0x013b:
            r5 = r4
        L_0x013c:
            if (r5 == 0) goto L_0x0140
            goto L_0x0061
        L_0x0140:
            throw r12
        L_0x0141:
            throw r11
        L_0x0142:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x014f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            goto L_0x0158
        L_0x0157:
            throw r0
        L_0x0158:
            goto L_0x0157
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Route route2 = this.route;
        Proxy proxy = route2.proxy;
        Address address = route2.address;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket2 = address.socketFactory.createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        InetSocketAddress inetSocketAddress = this.route.inetSocketAddress;
        if (eventListener != null) {
            socket2.setSoTimeout(i2);
            try {
                Platform.PLATFORM.connectSocket(this.rawSocket, this.route.inetSocketAddress, i);
                try {
                    this.source = new RealBufferedSource(Okio.source(this.rawSocket));
                    this.sink = new RealBufferedSink(Okio.sink(this.rawSocket));
                } catch (NullPointerException e) {
                    if ("throw with null exception".equals(e.getMessage())) {
                        throw new IOException(e);
                    }
                }
            } catch (ConnectException e2) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to connect to ");
                outline24.append(this.route.inetSocketAddress);
                ConnectException connectException = new ConnectException(outline24.toString());
                connectException.initCause(e2);
                throw connectException;
            }
        } else {
            throw null;
        }
    }

    public final void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        int i4 = i2;
        Request.Builder builder = new Request.Builder();
        builder.url(this.route.address.url);
        builder.method("CONNECT", (RequestBody) null);
        builder.header("Host", Util.hostHeader(this.route.address.url, true));
        builder.header("Proxy-Connection", "Keep-Alive");
        builder.header(GraphRequest.USER_AGENT_HEADER, "okhttp/3.12.12");
        Request build = builder.build();
        Response.Builder builder2 = new Response.Builder();
        builder2.request = build;
        builder2.protocol = Protocol.HTTP_1_1;
        builder2.code = 407;
        builder2.message = "Preemptive Authenticate";
        builder2.body = Util.EMPTY_RESPONSE;
        builder2.sentRequestAtMillis = -1;
        builder2.receivedResponseAtMillis = -1;
        Headers.Builder builder3 = builder2.headers;
        if (builder3 != null) {
            Headers.checkName("Proxy-Authenticate");
            Headers.checkValue("OkHttp-Preemptive", "Proxy-Authenticate");
            builder3.removeAll("Proxy-Authenticate");
            builder3.namesAndValues.add("Proxy-Authenticate");
            builder3.namesAndValues.add("OkHttp-Preemptive");
            builder2.build();
            if (((Authenticator.C20541) this.route.address.proxyAuthenticator) != null) {
                HttpUrl httpUrl = build.url;
                int i5 = i;
                connectSocket(i, i2, call, eventListener);
                Http1Codec http1Codec = new Http1Codec((OkHttpClient) null, (StreamAllocation) null, this.source, this.sink);
                this.source.timeout().timeout((long) i4, TimeUnit.MILLISECONDS);
                this.sink.timeout().timeout((long) i3, TimeUnit.MILLISECONDS);
                http1Codec.writeRequest(build.headers, "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1");
                http1Codec.sink.flush();
                Response.Builder readResponseHeaders = http1Codec.readResponseHeaders(false);
                readResponseHeaders.request = build;
                Response build2 = readResponseHeaders.build();
                long contentLength = HttpHeaders.contentLength(build2);
                if (contentLength == -1) {
                    contentLength = 0;
                }
                Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
                Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                ((Http1Codec.FixedLengthSource) newFixedLengthSource).close();
                int i6 = build2.code;
                if (i6 != 200) {
                    if (i6 != 407) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unexpected response code for CONNECT: ");
                        outline24.append(build2.code);
                        throw new IOException(outline24.toString());
                    } else if (((Authenticator.C20541) this.route.address.proxyAuthenticator) != null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else {
                        throw null;
                    }
                } else if (!this.source.buffer().exhausted() || !this.sink.buffer().exhausted()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0129 A[Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012f A[Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void establishProtocol(okhttp3.internal.connection.ConnectionSpecSelector r7, int r8, okhttp3.Call r9, okhttp3.EventListener r10) throws java.io.IOException {
        /*
            r6 = this;
            okhttp3.Protocol r9 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            okhttp3.Protocol r0 = okhttp3.Protocol.HTTP_1_1
            okhttp3.Route r1 = r6.route
            okhttp3.Address r1 = r1.address
            javax.net.ssl.SSLSocketFactory r2 = r1.sslSocketFactory
            if (r2 != 0) goto L_0x0025
            java.util.List<okhttp3.Protocol> r7 = r1.protocols
            boolean r7 = r7.contains(r9)
            if (r7 == 0) goto L_0x001e
            java.net.Socket r7 = r6.rawSocket
            r6.socket = r7
            r6.protocol = r9
            r6.startHttp2(r8)
            return
        L_0x001e:
            java.net.Socket r7 = r6.rawSocket
            r6.socket = r7
            r6.protocol = r0
            return
        L_0x0025:
            r9 = 0
            if (r10 == 0) goto L_0x013c
            java.net.Socket r10 = r6.rawSocket     // Catch:{ AssertionError -> 0x0122 }
            okhttp3.HttpUrl r3 = r1.url     // Catch:{ AssertionError -> 0x0122 }
            java.lang.String r3 = r3.host     // Catch:{ AssertionError -> 0x0122 }
            okhttp3.HttpUrl r4 = r1.url     // Catch:{ AssertionError -> 0x0122 }
            int r4 = r4.port     // Catch:{ AssertionError -> 0x0122 }
            r5 = 1
            java.net.Socket r10 = r2.createSocket(r10, r3, r4, r5)     // Catch:{ AssertionError -> 0x0122 }
            javax.net.ssl.SSLSocket r10 = (javax.net.ssl.SSLSocket) r10     // Catch:{ AssertionError -> 0x0122 }
            okhttp3.ConnectionSpec r7 = r7.configureSecureSocket(r10)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            boolean r2 = r7.supportsTlsExtensions     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            if (r2 == 0) goto L_0x004c
            okhttp3.internal.platform.Platform r2 = okhttp3.internal.platform.Platform.PLATFORM     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.HttpUrl r3 = r1.url     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r3 = r3.host     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.util.List<okhttp3.Protocol> r4 = r1.protocols     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r2.configureTlsExtensions(r10, r3, r4)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
        L_0x004c:
            r10.startHandshake()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            javax.net.ssl.SSLSession r2 = r10.getSession()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.Handshake r3 = okhttp3.Handshake.get(r2)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            javax.net.ssl.HostnameVerifier r4 = r1.hostnameVerifier     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.HttpUrl r5 = r1.url     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r5 = r5.host     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            boolean r2 = r4.verify(r5, r2)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            if (r2 != 0) goto L_0x00d3
            java.util.List<java.security.cert.Certificate> r7 = r3.peerCertificates     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            boolean r8 = r7.isEmpty()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = "Hostname "
            if (r8 != 0) goto L_0x00b5
            r8 = 0
            java.lang.Object r7 = r7.get(r8)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r0.<init>()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.HttpUrl r9 = r1.url     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = r9.host     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = " not verified:\n    certificate: "
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = okhttp3.CertificatePinner.pin(r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = "\n    DN: "
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.security.Principal r9 = r7.getSubjectDN()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = r9.getName()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = "\n    subjectAltNames: "
            r0.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.util.List r7 = okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r0.append(r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r7 = r0.toString()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r8.<init>(r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            throw r8     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
        L_0x00b5:
            javax.net.ssl.SSLPeerUnverifiedException r7 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r8.<init>()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r8.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.HttpUrl r9 = r1.url     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = r9.host     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r8.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = " not verified (no certificates)"
            r8.append(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r8 = r8.toString()     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r7.<init>(r8)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            throw r7     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
        L_0x00d3:
            okhttp3.CertificatePinner r2 = r1.certificatePinner     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.HttpUrl r1 = r1.url     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r1 = r1.host     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.util.List<java.security.cert.Certificate> r4 = r3.peerCertificates     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r2.check(r1, r4)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            boolean r7 = r7.supportsTlsExtensions     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            if (r7 == 0) goto L_0x00e8
            okhttp3.internal.platform.Platform r7 = okhttp3.internal.platform.Platform.PLATFORM     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.lang.String r9 = r7.getSelectedProtocol(r10)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
        L_0x00e8:
            r6.socket = r10     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okio.Source r7 = okio.Okio.source((java.net.Socket) r10)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okio.RealBufferedSource r1 = new okio.RealBufferedSource     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r1.<init>(r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r6.source = r1     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            java.net.Socket r7 = r6.socket     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okio.Sink r7 = okio.Okio.sink((java.net.Socket) r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okio.RealBufferedSink r1 = new okio.RealBufferedSink     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r1.<init>(r7)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r6.sink = r1     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            r6.handshake = r3     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            if (r9 == 0) goto L_0x010a
            okhttp3.Protocol r0 = okhttp3.Protocol.get(r9)     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
        L_0x010a:
            r6.protocol = r0     // Catch:{ AssertionError -> 0x011d, all -> 0x011b }
            okhttp3.internal.platform.Platform r7 = okhttp3.internal.platform.Platform.PLATFORM
            r7.afterHandshake(r10)
            okhttp3.Protocol r7 = r6.protocol
            okhttp3.Protocol r9 = okhttp3.Protocol.HTTP_2
            if (r7 != r9) goto L_0x011a
            r6.startHttp2(r8)
        L_0x011a:
            return
        L_0x011b:
            r7 = move-exception
            goto L_0x0131
        L_0x011d:
            r7 = move-exception
            r9 = r10
            goto L_0x0123
        L_0x0120:
            r7 = move-exception
            goto L_0x0130
        L_0x0122:
            r7 = move-exception
        L_0x0123:
            boolean r8 = okhttp3.internal.Util.isAndroidGetsocknameError(r7)     // Catch:{ all -> 0x0120 }
            if (r8 == 0) goto L_0x012f
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0120 }
            r8.<init>(r7)     // Catch:{ all -> 0x0120 }
            throw r8     // Catch:{ all -> 0x0120 }
        L_0x012f:
            throw r7     // Catch:{ all -> 0x0120 }
        L_0x0130:
            r10 = r9
        L_0x0131:
            if (r10 == 0) goto L_0x0138
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.PLATFORM
            r8.afterHandshake(r10)
        L_0x0138:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r10)
            throw r7
        L_0x013c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.establishProtocol(okhttp3.internal.connection.ConnectionSpecSelector, int, okhttp3.Call, okhttp3.EventListener):void");
    }

    public boolean isEligible(Address address, @Nullable Route route2) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams) {
            return false;
        }
        Internal internal = Internal.instance;
        Address address2 = this.route.address;
        if (((OkHttpClient.C20611) internal) == null) {
            throw null;
        } else if (!address2.equalsNonHost(address)) {
            return false;
        } else {
            if (address.url.host.equals(this.route.address.url.host)) {
                return true;
            }
            if (this.http2Connection == null || route2 == null || route2.proxy.type() != Proxy.Type.DIRECT || this.route.proxy.type() != Proxy.Type.DIRECT || !this.route.inetSocketAddress.equals(route2.inetSocketAddress) || route2.address.hostnameVerifier != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url)) {
                return false;
            }
            try {
                address.certificatePinner.check(address.url.host, this.handshake.peerCertificates);
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, this.http2Connection);
        }
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        this.socket.setSoTimeout(realInterceptorChain.readTimeout);
        this.source.timeout().timeout((long) realInterceptorChain.readTimeout, TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) realInterceptorChain.writeTimeout, TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public final void startHttp2(int i) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection.Builder builder = new Http2Connection.Builder(true);
        Socket socket2 = this.socket;
        String str = this.route.address.url.host;
        BufferedSource bufferedSource = this.source;
        BufferedSink bufferedSink = this.sink;
        builder.socket = socket2;
        builder.hostname = str;
        builder.source = bufferedSource;
        builder.sink = bufferedSink;
        builder.listener = this;
        builder.pingIntervalMillis = i;
        Http2Connection http2Connection2 = new Http2Connection(builder);
        this.http2Connection = http2Connection2;
        Http2Writer http2Writer = http2Connection2.writer;
        synchronized (http2Writer) {
            if (http2Writer.closed) {
                throw new IOException("closed");
            } else if (http2Writer.client) {
                if (Http2Writer.logger.isLoggable(Level.FINE)) {
                    Http2Writer.logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                http2Writer.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                http2Writer.sink.flush();
            }
        }
        Http2Writer http2Writer2 = http2Connection2.writer;
        Settings settings = http2Connection2.okHttpSettings;
        synchronized (http2Writer2) {
            if (!http2Writer2.closed) {
                http2Writer2.frameHeader(0, Integer.bitCount(settings.set) * 6, (byte) 4, (byte) 0);
                int i2 = 0;
                while (i2 < 10) {
                    if (((1 << i2) & settings.set) != 0) {
                        http2Writer2.sink.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                        http2Writer2.sink.writeInt(settings.values[i2]);
                    }
                    i2++;
                }
                http2Writer2.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }
        int initialWindowSize = http2Connection2.okHttpSettings.getInitialWindowSize();
        if (initialWindowSize != 65535) {
            http2Connection2.writer.windowUpdate(0, (long) (initialWindowSize - SupportMenu.USER_MASK));
        }
        new Thread(http2Connection2.readerRunnable).start();
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        int i = httpUrl.port;
        HttpUrl httpUrl2 = this.route.address.url;
        if (i != httpUrl2.port) {
            return false;
        }
        if (httpUrl.host.equals(httpUrl2.host)) {
            return true;
        }
        Handshake handshake2 = this.handshake;
        if (handshake2 == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host, (X509Certificate) handshake2.peerCertificates.get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Connection{");
        outline24.append(this.route.address.url.host);
        outline24.append(CertificateUtil.DELIMITER);
        outline24.append(this.route.address.url.port);
        outline24.append(", proxy=");
        outline24.append(this.route.proxy);
        outline24.append(" hostAddress=");
        outline24.append(this.route.inetSocketAddress);
        outline24.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        outline24.append(handshake2 != null ? handshake2.cipherSuite : IntegrityManager.INTEGRITY_TYPE_NONE);
        outline24.append(" protocol=");
        outline24.append(this.protocol);
        outline24.append('}');
        return outline24.toString();
    }
}
