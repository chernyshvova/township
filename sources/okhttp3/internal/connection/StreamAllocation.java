package okhttp3.internal.connection;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation {
    public final Address address;
    public final Call call;
    public final Object callStackTrace;
    public boolean canceled;
    public HttpCodec codec;
    public RealConnection connection;
    public final ConnectionPool connectionPool;
    public final EventListener eventListener;
    public int refusedStreamCount;
    public boolean released;
    public boolean reportedAcquired;
    public Route route;
    public RouteSelector.Selection routeSelection;
    public final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        public StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        if (((OkHttpClient.C20611) Internal.instance) != null) {
            this.routeSelector = new RouteSelector(address2, connectionPool2.routeDatabase, call2, eventListener2);
            this.callStackTrace = obj;
            return;
        }
        throw null;
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public final Socket deallocate(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.codec = null;
        }
        boolean z4 = true;
        if (z2) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection == null) {
            return null;
        }
        if (z) {
            realConnection.noNewStreams = true;
        }
        if (this.codec != null) {
            return null;
        }
        if (!this.released && !this.connection.noNewStreams) {
            return null;
        }
        RealConnection realConnection2 = this.connection;
        int size = realConnection2.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection2.allocations.get(i).get() == this) {
                realConnection2.allocations.remove(i);
                if (this.connection.allocations.isEmpty()) {
                    this.connection.idleAtNanos = System.nanoTime();
                    Internal internal = Internal.instance;
                    ConnectionPool connectionPool2 = this.connectionPool;
                    RealConnection realConnection3 = this.connection;
                    if (((OkHttpClient.C20611) internal) == null) {
                        throw null;
                    } else if (connectionPool2 != null) {
                        if (realConnection3.noNewStreams || connectionPool2.maxIdleConnections == 0) {
                            connectionPool2.connections.remove(realConnection3);
                        } else {
                            connectionPool2.notifyAll();
                            z4 = false;
                        }
                        if (z4) {
                            socket = this.connection.socket;
                            this.connection = null;
                            return socket;
                        }
                    } else {
                        throw null;
                    }
                }
                socket = null;
                this.connection = null;
                return socket;
            }
        }
        throw new IllegalStateException();
    }

    public final RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        int i5;
        Socket deallocate;
        RealConnection realConnection;
        RealConnection realConnection2;
        Route route2;
        boolean z2;
        boolean z3;
        RealConnection realConnection3;
        Socket socket;
        RouteSelector.Selection selection;
        String str;
        int i6;
        boolean contains;
        Route route3;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new IllegalStateException("released");
            } else if (this.codec != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.canceled) {
                RealConnection realConnection4 = this.connection;
                RealConnection realConnection5 = this.connection;
                i5 = 1;
                deallocate = (realConnection5 == null || !realConnection5.noNewStreams) ? null : deallocate(false, false, true);
                if (this.connection != null) {
                    realConnection2 = this.connection;
                    realConnection = null;
                } else {
                    realConnection = realConnection4;
                    realConnection2 = null;
                }
                if (!this.reportedAcquired) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.connectionPool, this.address, this, (Route) null);
                    if (this.connection != null) {
                        realConnection2 = this.connection;
                        z2 = true;
                        route2 = null;
                    } else {
                        route3 = this.route;
                    }
                } else {
                    route3 = null;
                }
                route2 = route3;
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null && this.eventListener == null) {
            throw null;
        } else if (z2 && this.eventListener == null) {
            throw null;
        } else if (realConnection2 != null) {
            this.route = this.connection.route;
            return realConnection2;
        } else {
            if (route2 != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
                z3 = false;
            } else {
                RouteSelector routeSelector2 = this.routeSelector;
                if (routeSelector2.hasNext()) {
                    ArrayList arrayList = new ArrayList();
                    while (routeSelector2.hasNextProxy()) {
                        if (routeSelector2.hasNextProxy()) {
                            List<Proxy> list = routeSelector2.proxies;
                            int i7 = routeSelector2.nextProxyIndex;
                            routeSelector2.nextProxyIndex = i7 + 1;
                            Proxy proxy = list.get(i7);
                            routeSelector2.inetSocketAddresses = new ArrayList();
                            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                HttpUrl httpUrl = routeSelector2.address.url;
                                str = httpUrl.host;
                                i6 = httpUrl.port;
                            } else {
                                SocketAddress address2 = proxy.address();
                                if (address2 instanceof InetSocketAddress) {
                                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                                    InetAddress address3 = inetSocketAddress.getAddress();
                                    if (address3 == null) {
                                        str = inetSocketAddress.getHostName();
                                    } else {
                                        str = address3.getHostAddress();
                                    }
                                    i6 = inetSocketAddress.getPort();
                                } else {
                                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Proxy.address() is not an InetSocketAddress: ");
                                    outline24.append(address2.getClass());
                                    throw new IllegalArgumentException(outline24.toString());
                                }
                            }
                            if (i6 < i5 || i6 > 65535) {
                                throw new SocketException("No route to " + str + CertificateUtil.DELIMITER + i6 + "; port is out of range");
                            }
                            if (proxy.type() == Proxy.Type.SOCKS) {
                                routeSelector2.inetSocketAddresses.add(InetSocketAddress.createUnresolved(str, i6));
                            } else if (routeSelector2.eventListener == null) {
                                throw null;
                            } else if (((Dns.C20581) routeSelector2.address.dns) == null) {
                                throw null;
                            } else if (str != null) {
                                try {
                                    List asList = Arrays.asList(InetAddress.getAllByName(str));
                                    if (asList.isEmpty()) {
                                        throw new UnknownHostException(routeSelector2.address.dns + " returned no addresses for " + str);
                                    } else if (routeSelector2.eventListener != null) {
                                        int size = asList.size();
                                        for (int i8 = 0; i8 < size; i8++) {
                                            routeSelector2.inetSocketAddresses.add(new InetSocketAddress((InetAddress) asList.get(i8), i6));
                                        }
                                    } else {
                                        throw null;
                                    }
                                } catch (NullPointerException e) {
                                    UnknownHostException unknownHostException = new UnknownHostException(GeneratedOutlineSupport.outline16("Broken system behaviour for dns lookup of ", str));
                                    unknownHostException.initCause(e);
                                    throw unknownHostException;
                                }
                            } else {
                                throw new UnknownHostException("hostname == null");
                            }
                            int size2 = routeSelector2.inetSocketAddresses.size();
                            for (int i9 = 0; i9 < size2; i9++) {
                                Route route4 = new Route(routeSelector2.address, proxy, routeSelector2.inetSocketAddresses.get(i9));
                                RouteDatabase routeDatabase = routeSelector2.routeDatabase;
                                synchronized (routeDatabase) {
                                    contains = routeDatabase.failedRoutes.contains(route4);
                                }
                                if (contains) {
                                    routeSelector2.postponedRoutes.add(route4);
                                } else {
                                    arrayList.add(route4);
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                break;
                            }
                            i5 = 1;
                        } else {
                            StringBuilder outline242 = GeneratedOutlineSupport.outline24("No route to ");
                            outline242.append(routeSelector2.address.url.host);
                            outline242.append("; exhausted proxy configurations: ");
                            outline242.append(routeSelector2.proxies);
                            throw new SocketException(outline242.toString());
                        }
                    }
                    if (arrayList.isEmpty()) {
                        arrayList.addAll(routeSelector2.postponedRoutes);
                        routeSelector2.postponedRoutes.clear();
                    }
                    this.routeSelection = new RouteSelector.Selection(arrayList);
                    z3 = true;
                } else {
                    throw new NoSuchElementException();
                }
            }
            synchronized (this.connectionPool) {
                if (!this.canceled) {
                    if (z3) {
                        RouteSelector.Selection selection2 = this.routeSelection;
                        if (selection2 != null) {
                            ArrayList arrayList2 = new ArrayList(selection2.routes);
                            int size3 = arrayList2.size();
                            int i10 = 0;
                            while (true) {
                                if (i10 >= size3) {
                                    break;
                                }
                                Route route5 = (Route) arrayList2.get(i10);
                                Internal.instance.get(this.connectionPool, this.address, this, route5);
                                if (this.connection != null) {
                                    realConnection2 = this.connection;
                                    this.route = route5;
                                    z2 = true;
                                    break;
                                }
                                i10++;
                            }
                        } else {
                            throw null;
                        }
                    }
                    if (!z2) {
                        if (route2 == null) {
                            RouteSelector.Selection selection3 = this.routeSelection;
                            if (selection3.hasNext()) {
                                List<Route> list2 = selection3.routes;
                                int i11 = selection3.nextRouteIndex;
                                selection3.nextRouteIndex = i11 + 1;
                                route2 = list2.get(i11);
                            } else {
                                throw new NoSuchElementException();
                            }
                        }
                        this.route = route2;
                        this.refusedStreamCount = 0;
                        realConnection2 = new RealConnection(this.connectionPool, route2);
                        acquire(realConnection2, false);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            }
            if (!z2) {
                realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
                Internal internal = Internal.instance;
                ConnectionPool connectionPool2 = this.connectionPool;
                if (((OkHttpClient.C20611) internal) != null) {
                    connectionPool2.routeDatabase.connected(realConnection2.route);
                    synchronized (this.connectionPool) {
                        this.reportedAcquired = true;
                        Internal internal2 = Internal.instance;
                        ConnectionPool connectionPool3 = this.connectionPool;
                        if (((OkHttpClient.C20611) internal2) != null) {
                            if (!connectionPool3.cleanupRunning) {
                                connectionPool3.cleanupRunning = true;
                                ConnectionPool.executor.execute(connectionPool3.cleanupRunnable);
                            }
                            connectionPool3.connections.add(realConnection2);
                            if (realConnection2.isMultiplexed()) {
                                socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                                realConnection3 = this.connection;
                            } else {
                                realConnection3 = realConnection2;
                                socket = null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    Util.closeQuietly(socket);
                    if (this.eventListener != null) {
                        return realConnection3;
                    }
                    throw null;
                }
                throw null;
            } else if (this.eventListener != null) {
                return realConnection2;
            } else {
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r1.socket.isClosed() != false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r1.socket.isInputShutdown() != false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r1.socket.isOutputShutdown() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        r5 = r1.http2Connection;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r5 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r6 = java.lang.System.nanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        if (r5.shutdown == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (r5.degradedPongsReceived >= r5.degradedPingsSent) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004b, code lost:
        if (r6 < r5.degradedPongDeadlineNs) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0055, code lost:
        if (r18 == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5 = r1.socket.getSoTimeout();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r1.socket.setSoTimeout(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0068, code lost:
        if (r1.source.exhausted() == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1.socket.setSoTimeout(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0070, code lost:
        r1.socket.setSoTimeout(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0077, code lost:
        r1.socket.setSoTimeout(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007c, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007f A[LOOP:0: B:0:0x0000->B:51:0x007f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0084 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.internal.connection.RealConnection findHealthyConnection(int r13, int r14, int r15, int r16, boolean r17, boolean r18) throws java.io.IOException {
        /*
            r12 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r1 = r12.findConnection(r13, r14, r15, r16, r17)
            r2 = r12
            okhttp3.ConnectionPool r3 = r2.connectionPool
            monitor-enter(r3)
            int r0 = r1.successCount     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0014
            boolean r0 = r1.isMultiplexed()     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0014
            monitor-exit(r3)     // Catch:{ all -> 0x0085 }
            return r1
        L_0x0014:
            monitor-exit(r3)     // Catch:{ all -> 0x0085 }
            java.net.Socket r0 = r1.socket
            boolean r0 = r0.isClosed()
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x007d
            java.net.Socket r0 = r1.socket
            boolean r0 = r0.isInputShutdown()
            if (r0 != 0) goto L_0x007d
            java.net.Socket r0 = r1.socket
            boolean r0 = r0.isOutputShutdown()
            if (r0 == 0) goto L_0x0030
            goto L_0x007d
        L_0x0030:
            okhttp3.internal.http2.Http2Connection r5 = r1.http2Connection
            if (r5 == 0) goto L_0x0055
            long r6 = java.lang.System.nanoTime()
            monitor-enter(r5)
            boolean r0 = r5.shutdown     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x003f
            monitor-exit(r5)
            goto L_0x007d
        L_0x003f:
            long r8 = r5.degradedPongsReceived     // Catch:{ all -> 0x0052 }
            long r10 = r5.degradedPingsSent     // Catch:{ all -> 0x0052 }
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x004f
            long r8 = r5.degradedPongDeadlineNs     // Catch:{ all -> 0x0052 }
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x004f
            monitor-exit(r5)
            goto L_0x007d
        L_0x004f:
            monitor-exit(r5)
        L_0x0050:
            r3 = 1
            goto L_0x007d
        L_0x0052:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0055:
            if (r18 == 0) goto L_0x0050
            java.net.Socket r0 = r1.socket     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            int r5 = r0.getSoTimeout()     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            java.net.Socket r0 = r1.socket     // Catch:{ all -> 0x0076 }
            r0.setSoTimeout(r4)     // Catch:{ all -> 0x0076 }
            okio.BufferedSource r0 = r1.source     // Catch:{ all -> 0x0076 }
            boolean r0 = r0.exhausted()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0070
            java.net.Socket r0 = r1.socket     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            r0.setSoTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            goto L_0x007d
        L_0x0070:
            java.net.Socket r0 = r1.socket     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            r0.setSoTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            goto L_0x0050
        L_0x0076:
            r0 = move-exception
            java.net.Socket r6 = r1.socket     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            r6.setSoTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
            throw r0     // Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x007d }
        L_0x007d:
            if (r3 != 0) goto L_0x0084
            r12.noNewStreams()
            goto L_0x0000
        L_0x0084:
            return r1
        L_0x0085:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0085 }
            goto L_0x0089
        L_0x0088:
            throw r0
        L_0x0089:
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null && this.eventListener == null) {
            throw null;
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            if (this.eventListener == null) {
                throw null;
            }
        }
    }

    public void streamFailed(IOException iOException) {
        boolean z;
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        this.route = null;
                    }
                    z = false;
                    realConnection = this.connection;
                    deallocate = deallocate(z, false, true);
                    if (this.connection != null || !this.reportedAcquired) {
                        realConnection = null;
                    }
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.route = null;
                    }
                    z = false;
                    realConnection = this.connection;
                    deallocate = deallocate(z, false, true);
                    realConnection = null;
                }
            } else {
                if (this.connection != null && (!this.connection.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.connection.successCount == 0) {
                        if (!(this.route == null || iOException == null)) {
                            this.routeSelector.connectFailed(this.route, iOException);
                        }
                        this.route = null;
                    }
                }
                z = false;
                realConnection = this.connection;
                deallocate = deallocate(z, false, true);
                realConnection = null;
            }
            z = true;
            realConnection = this.connection;
            deallocate = deallocate(z, false, true);
            realConnection = null;
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null && this.eventListener == null) {
            throw null;
        }
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z2;
        if (this.eventListener != null) {
            synchronized (this.connectionPool) {
                if (httpCodec != null) {
                    if (httpCodec == this.codec) {
                        if (!z) {
                            this.connection.successCount++;
                        }
                        realConnection = this.connection;
                        deallocate = deallocate(z, false, true);
                        if (this.connection != null) {
                            realConnection = null;
                        }
                        z2 = this.released;
                    }
                }
                throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
            }
            Util.closeQuietly(deallocate);
            if (realConnection != null && this.eventListener == null) {
                throw null;
            } else if (iOException != null) {
                Internal.instance.timeoutExit(this.call, iOException);
                if (this.eventListener == null) {
                    throw null;
                }
            } else if (z2) {
                Internal.instance.timeoutExit(this.call, (IOException) null);
                if (this.eventListener == null) {
                    throw null;
                }
            }
        } else {
            throw null;
        }
    }

    public String toString() {
        RealConnection connection2 = connection();
        return connection2 != null ? connection2.toString() : this.address.toString();
    }
}
