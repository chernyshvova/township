package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {
    public final Set<Route> failedRoutes = new LinkedHashSet();

    public synchronized void connected(Route route) {
        this.failedRoutes.remove(route);
    }
}
