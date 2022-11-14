package okhttp3.internal.http1;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec implements HttpCodec {
    public final OkHttpClient client;
    public long headerLimit = 262144;
    public final BufferedSink sink;
    public final BufferedSource source;
    public int state = 0;
    public final StreamAllocation streamAllocation;

    public abstract class AbstractSource implements Source {
        public long bytesRead = 0;
        public boolean closed;
        public final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.source.timeout());

        public AbstractSource(C20711 r2) {
        }

        public final void endOfInput(boolean z, IOException iOException) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.state;
            if (i != 6) {
                if (i == 5) {
                    http1Codec.detachTimeout(this.timeout);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.state = 6;
                    StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                    if (streamAllocation != null) {
                        streamAllocation.streamFinished(!z, http1Codec2, this.bytesRead, iOException);
                        return;
                    }
                    return;
                }
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("state: ");
                outline24.append(Http1Codec.this.state);
                throw new IllegalStateException(outline24.toString());
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = Http1Codec.this.source.read(buffer, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(false, e);
                throw e;
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    public final class ChunkedSink implements Sink {
        public boolean closed;
        public final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());

        public ChunkedSink() {
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.sink.writeHexadecimalUnsignedLong(j);
                Http1Codec.this.sink.writeUtf8("\r\n");
                Http1Codec.this.sink.write(buffer, j);
                Http1Codec.this.sink.writeUtf8("\r\n");
            }
        }
    }

    public class ChunkedSource extends AbstractSource {
        public long bytesRemainingInChunk = -1;
        public boolean hasMoreChunks = true;
        public final HttpUrl url;

        public ChunkedSource(HttpUrl httpUrl) {
            super((C20711) null);
            this.url = httpUrl;
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, (IOException) null);
                }
                this.closed = true;
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                long j2 = this.bytesRemainingInChunk;
                if (j2 == 0 || j2 == -1) {
                    if (this.bytesRemainingInChunk != -1) {
                        Http1Codec.this.source.readUtf8LineStrict();
                    }
                    try {
                        this.bytesRemainingInChunk = Http1Codec.this.source.readHexadecimalUnsignedLong();
                        String trim = Http1Codec.this.source.readUtf8LineStrict().trim();
                        if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                        }
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            Http1Codec http1Codec = Http1Codec.this;
                            HttpHeaders.receiveHeaders(http1Codec.client.cookieJar, this.url, http1Codec.readHeaders());
                            endOfInput(true, (IOException) null);
                        }
                        if (!this.hasMoreChunks) {
                            return -1;
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long read = super.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            }
        }
    }

    public final class FixedLengthSink implements Sink {
        public long bytesRemaining;
        public boolean closed;
        public final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());

        public FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(buffer.size, 0, j);
                if (j <= this.bytesRemaining) {
                    Http1Codec.this.sink.write(buffer, j);
                    this.bytesRemaining -= j;
                    return;
                }
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("expected ");
                outline24.append(this.bytesRemaining);
                outline24.append(" bytes but received ");
                outline24.append(j);
                throw new ProtocolException(outline24.toString());
            }
            throw new IllegalStateException("closed");
        }
    }

    public class FixedLengthSource extends AbstractSource {
        public long bytesRemaining;

        public FixedLengthSource(Http1Codec http1Codec, long j) throws IOException {
            super((C20711) null);
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true, (IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, (IOException) null);
                }
                this.closed = true;
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.closed) {
                long j2 = this.bytesRemaining;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.bytesRemaining - read;
                    this.bytesRemaining = j3;
                    if (j3 == 0) {
                        endOfInput(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    public class UnknownLengthSource extends AbstractSource {
        public boolean inputExhausted;

        public UnknownLengthSource(Http1Codec http1Codec) {
            super((C20711) null);
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, (IOException) null);
                }
                this.closed = true;
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true, (IOException) null);
                return -1;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            Util.closeQuietly(connection.rawSocket);
        }
    }

    public Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.headers.get("Transfer-Encoding"))) {
            if (this.state == 1) {
                this.state = 2;
                return new ChunkedSink();
            }
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("state: ");
            outline24.append(this.state);
            throw new IllegalStateException(outline24.toString());
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        } else {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("state: ");
            outline242.append(this.state);
            throw new IllegalStateException(outline242.toString());
        }
    }

    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout timeout = forwardingTimeout.delegate;
        forwardingTimeout.delegate = Timeout.NONE;
        timeout.clearDeadline();
        timeout.clearTimeout();
    }

    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(this, j);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("state: ");
        outline24.append(this.state);
        throw new IllegalStateException(outline24.toString());
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        String str = null;
        if (this.streamAllocation.eventListener != null) {
            String str2 = response.headers.get("Content-Type");
            if (str2 == null) {
                str2 = null;
            }
            if (!HttpHeaders.hasBody(response)) {
                return new RealResponseBody(str2, 0, Okio.buffer(newFixedLengthSource(0)));
            }
            String str3 = response.headers.get("Transfer-Encoding");
            if (str3 != null) {
                str = str3;
            }
            if ("chunked".equalsIgnoreCase(str)) {
                HttpUrl httpUrl = response.request.url;
                if (this.state == 4) {
                    this.state = 5;
                    return new RealResponseBody(str2, -1, Okio.buffer((Source) new ChunkedSource(httpUrl)));
                }
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("state: ");
                outline24.append(this.state);
                throw new IllegalStateException(outline24.toString());
            }
            long contentLength = HttpHeaders.contentLength(response);
            if (contentLength != -1) {
                return new RealResponseBody(str2, contentLength, Okio.buffer(newFixedLengthSource(contentLength)));
            }
            if (this.state == 4) {
                StreamAllocation streamAllocation2 = this.streamAllocation;
                if (streamAllocation2 != null) {
                    this.state = 5;
                    streamAllocation2.noNewStreams();
                    return new RealResponseBody(str2, -1, Okio.buffer((Source) new UnknownLengthSource(this)));
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("state: ");
            outline242.append(this.state);
            throw new IllegalStateException(outline242.toString());
        }
        throw null;
    }

    public final String readHeaderLine() throws IOException {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return new Headers(builder);
            }
            if (((OkHttpClient.C20611) Internal.instance) != null) {
                int indexOf = readHeaderLine.indexOf(CertificateUtil.DELIMITER, 1);
                if (indexOf != -1) {
                    builder.addLenient(readHeaderLine.substring(0, indexOf), readHeaderLine.substring(indexOf + 1));
                } else if (readHeaderLine.startsWith(CertificateUtil.DELIMITER)) {
                    String substring = readHeaderLine.substring(1);
                    builder.namesAndValues.add("");
                    builder.namesAndValues.add(substring.trim());
                } else {
                    builder.namesAndValues.add("");
                    builder.namesAndValues.add(readHeaderLine.trim());
                }
            } else {
                throw null;
            }
        }
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i = this.state;
        if (i == 1 || i == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder builder = new Response.Builder();
                builder.protocol = parse.protocol;
                builder.code = parse.code;
                builder.message = parse.message;
                builder.headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return builder;
                }
                this.state = 4;
                return builder;
            } catch (EOFException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("unexpected end of stream on ");
                outline24.append(this.streamAllocation);
                IOException iOException = new IOException(outline24.toString());
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("state: ");
            outline242.append(this.state);
            throw new IllegalStateException(outline242.toString());
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            this.sink.writeUtf8("\r\n");
            this.state = 1;
            return;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("state: ");
        outline24.append(this.state);
        throw new IllegalStateException(outline24.toString());
    }

    public void writeRequestHeaders(Request request) throws IOException {
        Proxy.Type type = this.streamAllocation.connection().route.proxy.type();
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        if (!request.url.scheme.equals(Utility.URL_SCHEME) && type == Proxy.Type.HTTP) {
            sb.append(request.url);
        } else {
            sb.append(zzam.requestPath(request.url));
        }
        sb.append(" HTTP/1.1");
        writeRequest(request.headers, sb.toString());
    }
}
