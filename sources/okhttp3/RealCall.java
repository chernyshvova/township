package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

public final class RealCall implements Call {
    public final OkHttpClient client;
    @Nullable
    public EventListener eventListener;
    public boolean executed;
    public final boolean forWebSocket;
    public final Request originalRequest;
    public final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    public final AsyncTimeout timeout;

    public final class AsyncCall extends NamedRunnable {
        public final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        public AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[Catch:{ IOException -> 0x0047, all -> 0x0021, all -> 0x0088 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[Catch:{ IOException -> 0x0047, all -> 0x0021, all -> 0x0088 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A[Catch:{ IOException -> 0x0047, all -> 0x0021, all -> 0x0088 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okio.AsyncTimeout r0 = r0.timeout
                r0.enter()
                r0 = 0
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0047, all -> 0x0021 }
                okhttp3.Response r0 = r1.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x0047, all -> 0x0021 }
                r1 = 1
                okhttp3.Callback r2 = r5.responseCallback     // Catch:{ IOException -> 0x001f, all -> 0x001b }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x001f, all -> 0x001b }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x001f, all -> 0x001b }
            L_0x0016:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.client
                goto L_0x007e
            L_0x001b:
                r0 = move-exception
                r1 = r0
                r0 = 1
                goto L_0x0022
            L_0x001f:
                r0 = move-exception
                goto L_0x004a
            L_0x0021:
                r1 = move-exception
            L_0x0022:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0088 }
                r2.cancel()     // Catch:{ all -> 0x0088 }
                if (r0 != 0) goto L_0x0046
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0088 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
                r2.<init>()     // Catch:{ all -> 0x0088 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0088 }
                r2.append(r1)     // Catch:{ all -> 0x0088 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0088 }
                r0.<init>(r2)     // Catch:{ all -> 0x0088 }
                okhttp3.Callback r2 = r5.responseCallback     // Catch:{ all -> 0x0088 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ all -> 0x0088 }
                r2.onFailure(r3, r0)     // Catch:{ all -> 0x0088 }
            L_0x0046:
                throw r1     // Catch:{ all -> 0x0088 }
            L_0x0047:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x004a:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0088 }
                java.io.IOException r0 = r2.timeoutExit(r0)     // Catch:{ all -> 0x0088 }
                if (r1 == 0) goto L_0x0070
                okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.PLATFORM     // Catch:{ all -> 0x0088 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
                r3.<init>()     // Catch:{ all -> 0x0088 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0088 }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x0088 }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x0088 }
                r3.append(r4)     // Catch:{ all -> 0x0088 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0088 }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x0088 }
                goto L_0x0016
            L_0x0070:
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ all -> 0x0088 }
                okhttp3.EventListener r1 = r1.eventListener     // Catch:{ all -> 0x0088 }
                if (r1 == 0) goto L_0x0086
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ all -> 0x0088 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0088 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0088 }
                goto L_0x0016
            L_0x007e:
                okhttp3.Dispatcher r0 = r0.dispatcher
                java.util.Deque<okhttp3.RealCall$AsyncCall> r1 = r0.runningAsyncCalls
                r0.finished(r1, r5)
                return
            L_0x0086:
                r0 = 0
                throw r0     // Catch:{ all -> 0x0088 }
            L_0x0088:
                r0 = move-exception
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.client
                okhttp3.Dispatcher r1 = r1.dispatcher
                java.util.Deque<okhttp3.RealCall$AsyncCall> r2 = r1.runningAsyncCalls
                r1.finished(r2, r5)
                goto L_0x0096
            L_0x0095:
                throw r0
            L_0x0096:
                goto L_0x0095
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        C20621 r4 = new AsyncTimeout() {
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.timeout = r4;
        r4.timeout((long) okHttpClient.callTimeout, TimeUnit.MILLISECONDS);
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor2 = this.retryAndFollowUpInterceptor;
        retryAndFollowUpInterceptor2.canceled = true;
        StreamAllocation streamAllocation = retryAndFollowUpInterceptor2.streamAllocation;
        if (streamAllocation != null) {
            synchronized (streamAllocation.connectionPool) {
                streamAllocation.canceled = true;
                httpCodec = streamAllocation.codec;
                realConnection = streamAllocation.connection;
            }
            if (httpCodec != null) {
                httpCodec.cancel();
            } else if (realConnection != null) {
                Util.closeQuietly(realConnection.rawSocket);
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        OkHttpClient okHttpClient = this.client;
        RealCall realCall = new RealCall(okHttpClient, this.originalRequest, this.forWebSocket);
        realCall.eventListener = EventListener.this;
        return realCall;
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.retryAndFollowUpInterceptor.callStackTrace = Platform.PLATFORM.getStackTraceForCloseable("response.body().close()");
        if (this.eventListener != null) {
            Dispatcher dispatcher = this.client.dispatcher;
            AsyncCall asyncCall = new AsyncCall(callback);
            synchronized (dispatcher) {
                dispatcher.readyAsyncCalls.add(asyncCall);
            }
            dispatcher.promoteAndExecute();
            return;
        }
        throw null;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.retryAndFollowUpInterceptor.callStackTrace = Platform.PLATFORM.getStackTraceForCloseable("response.body().close()");
        this.timeout.enter();
        if (this.eventListener != null) {
            try {
                Dispatcher dispatcher = this.client.dispatcher;
                synchronized (dispatcher) {
                    dispatcher.runningSyncCalls.add(this);
                }
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                Dispatcher dispatcher2 = this.client.dispatcher;
                dispatcher2.finished(dispatcher2.runningSyncCalls, this);
                return responseWithInterceptorChain;
            } catch (IOException e) {
                try {
                    IOException timeoutExit = timeoutExit(e);
                    if (this.eventListener != null) {
                        throw timeoutExit;
                    }
                    throw null;
                } catch (Throwable th) {
                    Dispatcher dispatcher3 = this.client.dispatcher;
                    dispatcher3.finished(dispatcher3.runningSyncCalls, this);
                    throw th;
                }
            }
        } else {
            throw null;
        }
    }

    public Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors);
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar));
        arrayList.add(new CacheInterceptor(this.client.internalCache));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors);
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Request request = this.originalRequest;
        EventListener eventListener2 = this.eventListener;
        OkHttpClient okHttpClient = this.client;
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, request, this, eventListener2, okHttpClient.connectTimeout, okHttpClient.readTimeout, okHttpClient.writeTimeout).proceed(this.originalRequest);
        if (!this.retryAndFollowUpInterceptor.canceled) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.canceled;
    }

    public String redactedUrl() {
        HttpUrl.Builder builder;
        HttpUrl httpUrl = this.originalRequest.url;
        if (httpUrl != null) {
            try {
                builder = new HttpUrl.Builder();
                builder.parse(httpUrl, "/...");
            } catch (IllegalArgumentException unused) {
                builder = null;
            }
            if (builder != null) {
                builder.encodedUsername = HttpUrl.canonicalize("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                builder.encodedPassword = HttpUrl.canonicalize("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return builder.build().url;
            }
            throw null;
        }
        throw null;
    }

    @Nullable
    public IOException timeoutExit(@Nullable IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.retryAndFollowUpInterceptor.canceled ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }
}
