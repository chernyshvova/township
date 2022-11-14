package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {
    public final Address address;
    public final InetSocketAddress inetSocketAddress;
    public final Proxy proxy;

    public Route(Address address2, Proxy proxy2, InetSocketAddress inetSocketAddress2) {
        if (address2 == null) {
            throw new NullPointerException("address == null");
        } else if (inetSocketAddress2 != null) {
            this.address = address2;
            this.proxy = proxy2;
            this.inetSocketAddress = inetSocketAddress2;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.address.equals(this.address) && route.proxy.equals(this.proxy) && route.inetSocketAddress.equals(this.inetSocketAddress);
        }
    }

    public int hashCode() {
        int hashCode = this.proxy.hashCode();
        return this.inetSocketAddress.hashCode() + ((hashCode + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Route{");
        outline24.append(this.inetSocketAddress);
        outline24.append("}");
        return outline24.toString();
    }
}
