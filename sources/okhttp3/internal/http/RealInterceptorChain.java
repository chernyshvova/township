package okhttp3.internal.http;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Interceptor.Chain {
    public final Call call;
    public int calls;
    public final int connectTimeout;
    public final RealConnection connection;
    public final EventListener eventListener;
    public final HttpCodec httpCodec;
    public final int index;
    public final List<Interceptor> interceptors;
    public final int readTimeout;
    public final Request request;
    public final StreamAllocation streamAllocation;
    public final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation2, HttpCodec httpCodec2, RealConnection realConnection, int i, Request request2, Call call2, EventListener eventListener2, int i2, int i3, int i4) {
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation2;
        this.httpCodec = httpCodec2;
        this.index = i;
        this.request = request2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    public Response proceed(Request request2) throws IOException {
        return proceed(request2, this.streamAllocation, this.httpCodec, this.connection);
    }

    public Response proceed(Request request2, StreamAllocation streamAllocation2, HttpCodec httpCodec2, RealConnection realConnection) throws IOException {
        if (this.index < this.interceptors.size()) {
            this.calls++;
            if (this.httpCodec == null) {
                Request request3 = request2;
            } else if (!this.connection.supportsUrl(request2.url)) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("network interceptor ");
                outline24.append(this.interceptors.get(this.index - 1));
                outline24.append(" must retain the same host and port");
                throw new IllegalStateException(outline24.toString());
            }
            if (this.httpCodec == null || this.calls <= 1) {
                String str = " must call proceed() exactly once";
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation2, httpCodec2, realConnection, this.index + 1, request2, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
                Interceptor interceptor = this.interceptors.get(this.index);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec2 != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + str);
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.body != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("network interceptor ");
                outline242.append(this.interceptors.get(this.index - 1));
                outline242.append(" must call proceed() exactly once");
                throw new IllegalStateException(outline242.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
