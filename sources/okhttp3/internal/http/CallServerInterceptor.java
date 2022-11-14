package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Interceptor;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public final class CallServerInterceptor implements Interceptor {
    public final boolean forWebSocket;

    public static final class CountingSink extends ForwardingSink {
        public long successfulCount;

        public CountingSink(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.delegate.write(buffer, j);
            this.successfulCount += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010a, code lost:
        if ("close".equalsIgnoreCase(r7) != false) goto L_0x010c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r11) throws java.io.IOException {
        /*
            r10 = this;
            okhttp3.internal.http.RealInterceptorChain r11 = (okhttp3.internal.http.RealInterceptorChain) r11
            okhttp3.internal.http.HttpCodec r0 = r11.httpCodec
            okhttp3.internal.connection.StreamAllocation r1 = r11.streamAllocation
            okhttp3.internal.connection.RealConnection r2 = r11.connection
            okhttp3.Request r3 = r11.request
            long r4 = java.lang.System.currentTimeMillis()
            okhttp3.EventListener r6 = r11.eventListener
            r7 = 0
            if (r6 == 0) goto L_0x0141
            r0.writeRequestHeaders(r3)
            okhttp3.EventListener r6 = r11.eventListener
            if (r6 == 0) goto L_0x0140
            java.lang.String r6 = r3.method
            boolean r6 = com.android.billingclient.api.zzam.permitsRequestBody(r6)
            if (r6 == 0) goto L_0x0079
            okhttp3.RequestBody r6 = r3.body
            if (r6 == 0) goto L_0x0079
            okhttp3.Headers r6 = r3.headers
            java.lang.String r8 = "Expect"
            java.lang.String r6 = r6.get(r8)
            java.lang.String r8 = "100-continue"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0044
            r0.flushRequest()
            okhttp3.EventListener r6 = r11.eventListener
            if (r6 == 0) goto L_0x0043
            r6 = 1
            okhttp3.Response$Builder r6 = r0.readResponseHeaders(r6)
            goto L_0x0045
        L_0x0043:
            throw r7
        L_0x0044:
            r6 = r7
        L_0x0045:
            if (r6 != 0) goto L_0x006f
            okhttp3.EventListener r2 = r11.eventListener
            if (r2 == 0) goto L_0x006e
            okhttp3.RequestBody r2 = r3.body
            long r8 = r2.contentLength()
            okhttp3.internal.http.CallServerInterceptor$CountingSink r2 = new okhttp3.internal.http.CallServerInterceptor$CountingSink
            okio.Sink r8 = r0.createRequestBody(r3, r8)
            r2.<init>(r8)
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)
            okhttp3.RequestBody r8 = r3.body
            r8.writeTo(r2)
            okio.RealBufferedSink r2 = (okio.RealBufferedSink) r2
            r2.close()
            okhttp3.EventListener r2 = r11.eventListener
            if (r2 == 0) goto L_0x006d
            goto L_0x007a
        L_0x006d:
            throw r7
        L_0x006e:
            throw r7
        L_0x006f:
            boolean r2 = r2.isMultiplexed()
            if (r2 != 0) goto L_0x007a
            r1.noNewStreams()
            goto L_0x007a
        L_0x0079:
            r6 = r7
        L_0x007a:
            r0.finishRequest()
            r2 = 0
            if (r6 != 0) goto L_0x008a
            okhttp3.EventListener r6 = r11.eventListener
            if (r6 == 0) goto L_0x0089
            okhttp3.Response$Builder r6 = r0.readResponseHeaders(r2)
            goto L_0x008a
        L_0x0089:
            throw r7
        L_0x008a:
            r6.request = r3
            okhttp3.internal.connection.RealConnection r8 = r1.connection()
            okhttp3.Handshake r8 = r8.handshake
            r6.handshake = r8
            r6.sentRequestAtMillis = r4
            long r8 = java.lang.System.currentTimeMillis()
            r6.receivedResponseAtMillis = r8
            okhttp3.Response r6 = r6.build()
            int r8 = r6.code
            r9 = 100
            if (r8 != r9) goto L_0x00c2
            okhttp3.Response$Builder r2 = r0.readResponseHeaders(r2)
            r2.request = r3
            okhttp3.internal.connection.RealConnection r3 = r1.connection()
            okhttp3.Handshake r3 = r3.handshake
            r2.handshake = r3
            r2.sentRequestAtMillis = r4
            long r3 = java.lang.System.currentTimeMillis()
            r2.receivedResponseAtMillis = r3
            okhttp3.Response r6 = r2.build()
            int r8 = r6.code
        L_0x00c2:
            okhttp3.EventListener r11 = r11.eventListener
            if (r11 == 0) goto L_0x013f
            boolean r11 = r10.forWebSocket
            if (r11 == 0) goto L_0x00dc
            r11 = 101(0x65, float:1.42E-43)
            if (r8 != r11) goto L_0x00dc
            okhttp3.Response$Builder r11 = new okhttp3.Response$Builder
            r11.<init>(r6)
            okhttp3.ResponseBody r0 = okhttp3.internal.Util.EMPTY_RESPONSE
            r11.body = r0
            okhttp3.Response r11 = r11.build()
            goto L_0x00eb
        L_0x00dc:
            okhttp3.Response$Builder r11 = new okhttp3.Response$Builder
            r11.<init>(r6)
            okhttp3.ResponseBody r0 = r0.openResponseBody(r6)
            r11.body = r0
            okhttp3.Response r11 = r11.build()
        L_0x00eb:
            okhttp3.Request r0 = r11.request
            okhttp3.Headers r0 = r0.headers
            java.lang.String r2 = "Connection"
            java.lang.String r0 = r0.get(r2)
            java.lang.String r3 = "close"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x010c
            okhttp3.Headers r0 = r11.headers
            java.lang.String r0 = r0.get(r2)
            if (r0 == 0) goto L_0x0106
            r7 = r0
        L_0x0106:
            boolean r0 = r3.equalsIgnoreCase(r7)
            if (r0 == 0) goto L_0x010f
        L_0x010c:
            r1.noNewStreams()
        L_0x010f:
            r0 = 204(0xcc, float:2.86E-43)
            if (r8 == r0) goto L_0x0117
            r0 = 205(0xcd, float:2.87E-43)
            if (r8 != r0) goto L_0x0123
        L_0x0117:
            okhttp3.ResponseBody r0 = r11.body
            long r0 = r0.contentLength()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0124
        L_0x0123:
            return r11
        L_0x0124:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "HTTP "
            java.lang.String r2 = " had non-zero Content-Length: "
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline25(r1, r8, r2)
            okhttp3.ResponseBody r11 = r11.body
            long r2 = r11.contentLength()
            r1.append(r2)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        L_0x013f:
            throw r7
        L_0x0140:
            throw r7
        L_0x0141:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
