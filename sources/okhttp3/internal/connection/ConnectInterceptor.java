package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;

public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request;
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation;
        boolean z = !request.method.equals("GET");
        OkHttpClient okHttpClient = this.client;
        if (streamAllocation != null) {
            try {
                HttpCodec newCodec = streamAllocation.findHealthyConnection(realInterceptorChain.connectTimeout, realInterceptorChain.readTimeout, realInterceptorChain.writeTimeout, okHttpClient.pingInterval, okHttpClient.retryOnConnectionFailure, z).newCodec(okHttpClient, chain, streamAllocation);
                synchronized (streamAllocation.connectionPool) {
                    streamAllocation.codec = newCodec;
                }
                return realInterceptorChain.proceed(request, streamAllocation, newCodec, streamAllocation.connection());
            } catch (IOException e) {
                throw new RouteException(e);
            }
        } else {
            throw null;
        }
    }
}
