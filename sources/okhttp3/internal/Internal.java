package okhttp3.internal;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public abstract class Internal {
    public static Internal instance;

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    @Nullable
    public abstract IOException timeoutExit(Call call, @Nullable IOException iOException);
}
