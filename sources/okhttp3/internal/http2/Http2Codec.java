package okhttp3.internal.http2;

import com.android.billingclient.api.zzam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http2.Http2Stream;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {
    public static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
    public static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    public final Interceptor.Chain chain;
    public final Http2Connection connection;
    public final Protocol protocol;
    public Http2Stream stream;
    public final StreamAllocation streamAllocation;

    public class StreamFinishingSource extends ForwardingSource {
        public long bytesRead = 0;
        public boolean completed = false;

        public StreamFinishingSource(Source source) {
            super(source);
        }

        public void close() throws IOException {
            super.close();
            endOfInput((IOException) null);
        }

        public final void endOfInput(IOException iOException) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(e);
                throw e;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain2, StreamAllocation streamAllocation2, Http2Connection http2Connection) {
        Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        this.chain = chain2;
        this.streamAllocation = streamAllocation2;
        this.connection = http2Connection;
        this.protocol = !okHttpClient.protocols.contains(protocol2) ? Protocol.HTTP_2 : protocol2;
    }

    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    public void finishRequest() throws IOException {
        ((Http2Stream.FramingSink) this.stream.getSink()).close();
    }

    public void flushRequest() throws IOException {
        this.connection.writer.flush();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        String str = null;
        if (this.streamAllocation.eventListener != null) {
            String str2 = response.headers.get("Content-Type");
            if (str2 != null) {
                str = str2;
            }
            return new RealResponseBody(str, HttpHeaders.contentLength(response), Okio.buffer((Source) new StreamFinishingSource(this.stream.source)));
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cd, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ce, code lost:
        r0.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        throw r11;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response.Builder readResponseHeaders(boolean r11) throws java.io.IOException {
        /*
            r10 = this;
            okhttp3.internal.http2.Http2Stream r0 = r10.stream
            monitor-enter(r0)
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r0.readTimeout     // Catch:{ all -> 0x00d4 }
            r1.enter()     // Catch:{ all -> 0x00d4 }
        L_0x0008:
            java.util.Deque<okhttp3.Headers> r1 = r0.headersQueue     // Catch:{ all -> 0x00cd }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00cd }
            if (r1 == 0) goto L_0x0018
            okhttp3.internal.http2.ErrorCode r1 = r0.errorCode     // Catch:{ all -> 0x00cd }
            if (r1 != 0) goto L_0x0018
            r0.waitForIo()     // Catch:{ all -> 0x00cd }
            goto L_0x0008
        L_0x0018:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r0.readTimeout     // Catch:{ all -> 0x00d4 }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x00d4 }
            java.util.Deque<okhttp3.Headers> r1 = r0.headersQueue     // Catch:{ all -> 0x00d4 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00d4 }
            if (r1 != 0) goto L_0x00c5
            java.util.Deque<okhttp3.Headers> r1 = r0.headersQueue     // Catch:{ all -> 0x00d4 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x00d4 }
            okhttp3.Headers r1 = (okhttp3.Headers) r1     // Catch:{ all -> 0x00d4 }
            monitor-exit(r0)
            okhttp3.Protocol r0 = r10.protocol
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            r3 = 0
            int r4 = r1.size()
            r5 = 0
            r6 = r5
        L_0x003e:
            if (r3 >= r4) goto L_0x0083
            java.lang.String r7 = r1.name(r3)
            java.lang.String r8 = r1.value(r3)
            java.lang.String r9 = ":status"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x0066
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "HTTP/1.1 "
            r6.append(r7)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            okhttp3.internal.http.StatusLine r6 = okhttp3.internal.http.StatusLine.parse(r6)
            goto L_0x0080
        L_0x0066:
            java.util.List<java.lang.String> r9 = HTTP_2_SKIPPED_RESPONSE_HEADERS
            boolean r9 = r9.contains(r7)
            if (r9 != 0) goto L_0x0080
            okhttp3.internal.Internal r9 = okhttp3.internal.Internal.instance
            okhttp3.OkHttpClient$1 r9 = (okhttp3.OkHttpClient.C20611) r9
            if (r9 == 0) goto L_0x007f
            r2.add(r7)
            java.lang.String r7 = r8.trim()
            r2.add(r7)
            goto L_0x0080
        L_0x007f:
            throw r5
        L_0x0080:
            int r3 = r3 + 1
            goto L_0x003e
        L_0x0083:
            if (r6 == 0) goto L_0x00bd
            okhttp3.Response$Builder r1 = new okhttp3.Response$Builder
            r1.<init>()
            r1.protocol = r0
            int r0 = r6.code
            r1.code = r0
            java.lang.String r0 = r6.message
            r1.message = r0
            int r0 = r2.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r0 = r2.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            okhttp3.Headers$Builder r2 = new okhttp3.Headers$Builder
            r2.<init>()
            java.util.List<java.lang.String> r3 = r2.namesAndValues
            java.util.Collections.addAll(r3, r0)
            r1.headers = r2
            if (r11 == 0) goto L_0x00bc
            okhttp3.internal.Internal r11 = okhttp3.internal.Internal.instance
            okhttp3.OkHttpClient$1 r11 = (okhttp3.OkHttpClient.C20611) r11
            if (r11 == 0) goto L_0x00bb
            int r11 = r1.code
            r0 = 100
            if (r11 != r0) goto L_0x00bc
            return r5
        L_0x00bb:
            throw r5
        L_0x00bc:
            return r1
        L_0x00bd:
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r0 = "Expected ':status' header not present"
            r11.<init>(r0)
            throw r11
        L_0x00c5:
            okhttp3.internal.http2.StreamResetException r11 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x00d4 }
            okhttp3.internal.http2.ErrorCode r1 = r0.errorCode     // Catch:{ all -> 0x00d4 }
            r11.<init>(r1)     // Catch:{ all -> 0x00d4 }
            throw r11     // Catch:{ all -> 0x00d4 }
        L_0x00cd:
            r11 = move-exception
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r0.readTimeout     // Catch:{ all -> 0x00d4 }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x00d4 }
            throw r11     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            r11 = move-exception
            monitor-exit(r0)
            goto L_0x00d8
        L_0x00d7:
            throw r11
        L_0x00d8:
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Codec.readResponseHeaders(boolean):okhttp3.Response$Builder");
    }

    public void writeRequestHeaders(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        if (this.stream == null) {
            boolean z = false;
            boolean z2 = request.body != null;
            Headers headers = request.headers;
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method));
            arrayList.add(new Header(Header.TARGET_PATH, zzam.requestPath(request.url)));
            String str = request.headers.get("Host");
            if (str != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, str));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url.scheme));
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
                if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8.utf8())) {
                    arrayList.add(new Header(encodeUtf8, headers.value(i2)));
                }
            }
            Http2Connection http2Connection = this.connection;
            boolean z3 = !z2;
            synchronized (http2Connection.writer) {
                synchronized (http2Connection) {
                    if (http2Connection.nextStreamId > 1073741823) {
                        http2Connection.shutdown(ErrorCode.REFUSED_STREAM);
                    }
                    if (!http2Connection.shutdown) {
                        i = http2Connection.nextStreamId;
                        http2Connection.nextStreamId += 2;
                        http2Stream = new Http2Stream(i, http2Connection, z3, false, (Headers) null);
                        if (!z2 || http2Connection.bytesLeftInWriteWindow == 0 || http2Stream.bytesLeftInWriteWindow == 0) {
                            z = true;
                        }
                        if (http2Stream.isOpen()) {
                            http2Connection.streams.put(Integer.valueOf(i), http2Stream);
                        }
                    } else {
                        throw new ConnectionShutdownException();
                    }
                }
                Http2Writer http2Writer = http2Connection.writer;
                synchronized (http2Writer) {
                    if (!http2Writer.closed) {
                        http2Writer.headers(z3, i, arrayList);
                    } else {
                        throw new IOException("closed");
                    }
                }
            }
            if (z) {
                http2Connection.writer.flush();
            }
            this.stream = http2Stream;
            http2Stream.readTimeout.timeout((long) ((RealInterceptorChain) this.chain).readTimeout, TimeUnit.MILLISECONDS);
            this.stream.writeTimeout.timeout((long) ((RealInterceptorChain) this.chain).writeTimeout, TimeUnit.MILLISECONDS);
        }
    }
}
