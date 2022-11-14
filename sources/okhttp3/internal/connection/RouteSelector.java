package okhttp3.internal.connection;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector {
    public final Address address;
    public final Call call;
    public final EventListener eventListener;
    public List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    public int nextProxyIndex;
    public final List<Route> postponedRoutes = new ArrayList();
    public List<Proxy> proxies = Collections.emptyList();
    public final RouteDatabase routeDatabase;

    public static final class Selection {
        public int nextRouteIndex = 0;
        public final List<Route> routes;

        public Selection(List<Route> list) {
            this.routes = list;
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }
    }

    public RouteSelector(Address address2, RouteDatabase routeDatabase2, Call call2, EventListener eventListener2) {
        List<Proxy> list;
        this.address = address2;
        this.routeDatabase = routeDatabase2;
        this.call = call2;
        this.eventListener = eventListener2;
        HttpUrl httpUrl = address2.url;
        Proxy proxy = address2.proxy;
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = address2.proxySelector.select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                list = Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = Util.immutableList(select);
            }
            this.proxies = list;
        }
        this.nextProxyIndex = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.address;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connectFailed(okhttp3.Route r4, java.io.IOException r5) {
        /*
            r3 = this;
            java.net.Proxy r0 = r4.proxy
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r1 = java.net.Proxy.Type.DIRECT
            if (r0 == r1) goto L_0x001f
            okhttp3.Address r0 = r3.address
            java.net.ProxySelector r1 = r0.proxySelector
            if (r1 == 0) goto L_0x001f
            okhttp3.HttpUrl r0 = r0.url
            java.net.URI r0 = r0.uri()
            java.net.Proxy r2 = r4.proxy
            java.net.SocketAddress r2 = r2.address()
            r1.connectFailed(r0, r2, r5)
        L_0x001f:
            okhttp3.internal.connection.RouteDatabase r5 = r3.routeDatabase
            monitor-enter(r5)
            java.util.Set<okhttp3.Route> r0 = r5.failedRoutes     // Catch:{ all -> 0x0029 }
            r0.add(r4)     // Catch:{ all -> 0x0029 }
            monitor-exit(r5)
            return
        L_0x0029:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RouteSelector.connectFailed(okhttp3.Route, java.io.IOException):void");
    }

    public boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }
}
