package okhttp3.internal.http2;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Http2Connection;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Http2Reader implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public final boolean client;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final BufferedSource source;

    public static final class ContinuationSource implements Source {
        public byte flags;
        public int left;
        public int length;
        public short padding;
        public final BufferedSource source;
        public int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        public void close() throws IOException {
        }

        public long read(Buffer buffer, long j) throws IOException {
            int i;
            int readInt;
            do {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    i = this.streamId;
                    int readMedium = Http2Reader.readMedium(this.source);
                    this.left = readMedium;
                    this.length = readMedium;
                    byte readByte = (byte) (this.source.readByte() & Base64.EQUALS_SIGN_ENC);
                    this.flags = (byte) (this.source.readByte() & Base64.EQUALS_SIGN_ENC);
                    if (Http2Reader.logger.isLoggable(Level.FINE)) {
                        Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, readByte, this.flags));
                    }
                    readInt = this.source.readInt() & Integer.MAX_VALUE;
                    this.streamId = readInt;
                    if (readByte != 9) {
                        Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                        throw null;
                    }
                } else {
                    long read = this.source.read(buffer, Math.min(j, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            } while (readInt == i);
            Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & Base64.EQUALS_SIGN_ENC) | ((bufferedSource.readByte() & Base64.EQUALS_SIGN_ENC) << 16) | ((bufferedSource.readByte() & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public void close() throws IOException {
        this.source.close();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0368, code lost:
        if (r19 == false) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x036a, code lost:
        r8.receiveFin();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean nextFrame(boolean r23, okhttp3.internal.http2.Http2Reader.Handler r24) throws java.io.IOException {
        /*
            r22 = this;
            r1 = r22
            r0 = r24
            r2 = 0
            okio.BufferedSource r3 = r1.source     // Catch:{ IOException -> 0x0394 }
            r4 = 9
            r3.require(r4)     // Catch:{ IOException -> 0x0394 }
            okio.BufferedSource r3 = r1.source
            int r3 = readMedium(r3)
            r4 = 1
            r5 = 0
            if (r3 < 0) goto L_0x0386
            r6 = 16384(0x4000, float:2.2959E-41)
            if (r3 > r6) goto L_0x0386
            okio.BufferedSource r7 = r1.source
            byte r7 = r7.readByte()
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r8 = 4
            if (r23 == 0) goto L_0x0037
            if (r7 != r8) goto L_0x0029
            goto L_0x0037
        L_0x0029:
            java.lang.String r0 = "Expected a SETTINGS frame but was %s"
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.lang.Byte r4 = java.lang.Byte.valueOf(r7)
            r3[r2] = r4
            okhttp3.internal.http2.Http2.ioException(r0, r3)
            throw r5
        L_0x0037:
            okio.BufferedSource r9 = r1.source
            byte r9 = r9.readByte()
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            okio.BufferedSource r10 = r1.source
            int r10 = r10.readInt()
            r11 = 2147483647(0x7fffffff, float:NaN)
            r10 = r10 & r11
            java.util.logging.Logger r11 = logger
            java.util.logging.Level r12 = java.util.logging.Level.FINE
            boolean r11 = r11.isLoggable(r12)
            if (r11 == 0) goto L_0x005d
            java.util.logging.Logger r11 = logger
            java.lang.String r12 = okhttp3.internal.http2.Http2.frameLog(r4, r10, r3, r7, r9)
            r11.fine(r12)
        L_0x005d:
            r11 = 5
            r15 = 2
            switch(r7) {
                case 0: goto L_0x0243;
                case 1: goto L_0x0153;
                case 2: goto L_0x0134;
                case 3: goto L_0x012f;
                case 4: goto L_0x007e;
                case 5: goto L_0x0079;
                case 6: goto L_0x0074;
                case 7: goto L_0x006f;
                case 8: goto L_0x006a;
                default: goto L_0x0062;
            }
        L_0x0062:
            okio.BufferedSource r0 = r1.source
            long r2 = (long) r3
            r0.skip(r2)
            goto L_0x0385
        L_0x006a:
            r1.readWindowUpdate(r0, r3, r10)
            goto L_0x0385
        L_0x006f:
            r1.readGoAway(r0, r3, r10)
            goto L_0x0385
        L_0x0074:
            r1.readPing(r0, r3, r9, r10)
            goto L_0x0385
        L_0x0079:
            r1.readPushPromise(r0, r3, r9, r10)
            goto L_0x0385
        L_0x007e:
            if (r10 != 0) goto L_0x0127
            r7 = r9 & 1
            if (r7 == 0) goto L_0x0095
            if (r3 != 0) goto L_0x008d
            okhttp3.internal.http2.Http2Connection$ReaderRunnable r0 = (okhttp3.internal.http2.Http2Connection.ReaderRunnable) r0
            if (r0 == 0) goto L_0x008c
            goto L_0x0385
        L_0x008c:
            throw r5
        L_0x008d:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "FRAME_SIZE_ERROR ack frame should be empty!"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x0095:
            int r7 = r3 % 6
            if (r7 != 0) goto L_0x0119
            okhttp3.internal.http2.Settings r7 = new okhttp3.internal.http2.Settings
            r7.<init>()
            r9 = 0
        L_0x009f:
            if (r9 >= r3) goto L_0x00f2
            okio.BufferedSource r10 = r1.source
            short r10 = r10.readShort()
            r12 = 65535(0xffff, float:9.1834E-41)
            r10 = r10 & r12
            okio.BufferedSource r12 = r1.source
            int r12 = r12.readInt()
            if (r10 == r15) goto L_0x00df
            r13 = 3
            if (r10 == r13) goto L_0x00dd
            if (r10 == r8) goto L_0x00d1
            if (r10 == r11) goto L_0x00bb
            goto L_0x00ec
        L_0x00bb:
            if (r12 < r6) goto L_0x00c3
            r13 = 16777215(0xffffff, float:2.3509886E-38)
            if (r12 > r13) goto L_0x00c3
            goto L_0x00ec
        L_0x00c3:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r0[r2] = r3
            java.lang.String r2 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x00d1:
            r10 = 7
            if (r12 < 0) goto L_0x00d5
            goto L_0x00ec
        L_0x00d5:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x00dd:
            r10 = 4
            goto L_0x00ec
        L_0x00df:
            if (r12 == 0) goto L_0x00ec
            if (r12 != r4) goto L_0x00e4
            goto L_0x00ec
        L_0x00e4:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x00ec:
            r7.set(r10, r12)
            int r9 = r9 + 6
            goto L_0x009f
        L_0x00f2:
            r20 = 0
            okhttp3.internal.http2.Http2Connection$ReaderRunnable r0 = (okhttp3.internal.http2.Http2Connection.ReaderRunnable) r0
            if (r0 == 0) goto L_0x0118
            okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ RejectedExecutionException -> 0x0385 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.writerExecutor     // Catch:{ RejectedExecutionException -> 0x0385 }
            okhttp3.internal.http2.Http2Connection$ReaderRunnable$2 r5 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$2     // Catch:{ RejectedExecutionException -> 0x0385 }
            java.lang.String r18 = "OkHttp %s ACK Settings"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ RejectedExecutionException -> 0x0385 }
            okhttp3.internal.http2.Http2Connection r8 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ RejectedExecutionException -> 0x0385 }
            java.lang.String r8 = r8.hostname     // Catch:{ RejectedExecutionException -> 0x0385 }
            r6[r2] = r8     // Catch:{ RejectedExecutionException -> 0x0385 }
            r16 = r5
            r17 = r0
            r19 = r6
            r21 = r7
            r16.<init>(r18, r19, r20, r21)     // Catch:{ RejectedExecutionException -> 0x0385 }
            r3.execute(r5)     // Catch:{ RejectedExecutionException -> 0x0385 }
            goto L_0x0385
        L_0x0118:
            throw r5
        L_0x0119:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0[r2] = r3
            java.lang.String r2 = "TYPE_SETTINGS length %% 6 != 0: %s"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x0127:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "TYPE_SETTINGS streamId != 0"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x012f:
            r1.readRstStream(r0, r3, r10)
            goto L_0x0385
        L_0x0134:
            if (r3 != r11) goto L_0x0145
            if (r10 == 0) goto L_0x013d
            r1.readPriority(r0, r10)
            goto L_0x0385
        L_0x013d:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "TYPE_PRIORITY streamId == 0"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x0145:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0[r2] = r3
            java.lang.String r2 = "TYPE_PRIORITY length: %d != 5"
            okhttp3.internal.http2.Http2.ioException(r2, r0)
            throw r5
        L_0x0153:
            if (r10 == 0) goto L_0x023b
            r6 = r9 & 1
            if (r6 == 0) goto L_0x015b
            r6 = 1
            goto L_0x015c
        L_0x015b:
            r6 = 0
        L_0x015c:
            r7 = r9 & 8
            if (r7 == 0) goto L_0x016a
            okio.BufferedSource r7 = r1.source
            byte r7 = r7.readByte()
            r7 = r7 & 255(0xff, float:3.57E-43)
            short r7 = (short) r7
            goto L_0x016b
        L_0x016a:
            r7 = 0
        L_0x016b:
            r8 = r9 & 32
            if (r8 == 0) goto L_0x0174
            r1.readPriority(r0, r10)
            int r3 = r3 + -5
        L_0x0174:
            int r3 = lengthWithoutPadding(r3, r9, r7)
            java.util.List r17 = r1.readHeaderBlock(r3, r7, r9, r10)
            okhttp3.internal.http2.Http2Connection$ReaderRunnable r0 = (okhttp3.internal.http2.Http2Connection.ReaderRunnable) r0
            okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this
            boolean r3 = r3.pushedStream(r10)
            if (r3 == 0) goto L_0x01a9
            okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
            if (r0 == 0) goto L_0x01a8
            okhttp3.internal.http2.Http2Connection$5 r3 = new okhttp3.internal.http2.Http2Connection$5     // Catch:{ RejectedExecutionException -> 0x0385 }
            java.lang.String r14 = "OkHttp %s Push Headers[%s]"
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ RejectedExecutionException -> 0x0385 }
            java.lang.String r5 = r0.hostname     // Catch:{ RejectedExecutionException -> 0x0385 }
            r15[r2] = r5     // Catch:{ RejectedExecutionException -> 0x0385 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ RejectedExecutionException -> 0x0385 }
            r15[r4] = r2     // Catch:{ RejectedExecutionException -> 0x0385 }
            r12 = r3
            r13 = r0
            r16 = r10
            r18 = r6
            r12.<init>(r14, r15, r16, r17, r18)     // Catch:{ RejectedExecutionException -> 0x0385 }
            r0.pushExecutorExecute(r3)     // Catch:{ RejectedExecutionException -> 0x0385 }
            goto L_0x0385
        L_0x01a8:
            throw r5
        L_0x01a9:
            okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this
            monitor-enter(r3)
            okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Stream r5 = r5.getStream(r10)     // Catch:{ all -> 0x0238 }
            if (r5 != 0) goto L_0x0210
            okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            boolean r5 = r5.shutdown     // Catch:{ all -> 0x0238 }
            if (r5 == 0) goto L_0x01bd
            monitor-exit(r3)     // Catch:{ all -> 0x0238 }
            goto L_0x0385
        L_0x01bd:
            okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            int r5 = r5.lastGoodStreamId     // Catch:{ all -> 0x0238 }
            if (r10 > r5) goto L_0x01c6
            monitor-exit(r3)     // Catch:{ all -> 0x0238 }
            goto L_0x0385
        L_0x01c6:
            int r5 = r10 % 2
            okhttp3.internal.http2.Http2Connection r7 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            int r7 = r7.nextStreamId     // Catch:{ all -> 0x0238 }
            int r7 = r7 % r15
            if (r5 != r7) goto L_0x01d2
            monitor-exit(r3)     // Catch:{ all -> 0x0238 }
            goto L_0x0385
        L_0x01d2:
            okhttp3.Headers r17 = okhttp3.internal.Util.toHeaders(r17)     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Stream r5 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Connection r14 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            r7 = 0
            r12 = r5
            r13 = r10
            r8 = 2
            r15 = r7
            r16 = r6
            r12.<init>(r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Connection r6 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            r6.lastGoodStreamId = r10     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Connection r6 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r6 = r6.streams     // Catch:{ all -> 0x0238 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0238 }
            r6.put(r7, r5)     // Catch:{ all -> 0x0238 }
            java.util.concurrent.ExecutorService r6 = okhttp3.internal.http2.Http2Connection.listenerExecutor     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Connection$ReaderRunnable$1 r7 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$1     // Catch:{ all -> 0x0238 }
            java.lang.String r9 = "OkHttp %s stream %d"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0238 }
            okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0238 }
            java.lang.String r11 = r11.hostname     // Catch:{ all -> 0x0238 }
            r8[r2] = r11     // Catch:{ all -> 0x0238 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0238 }
            r8[r4] = r2     // Catch:{ all -> 0x0238 }
            r7.<init>(r9, r8, r5)     // Catch:{ all -> 0x0238 }
            r6.execute(r7)     // Catch:{ all -> 0x0238 }
            monitor-exit(r3)     // Catch:{ all -> 0x0238 }
            goto L_0x0385
        L_0x0210:
            monitor-exit(r3)     // Catch:{ all -> 0x0238 }
            monitor-enter(r5)
            r5.hasResponseHeaders = r4     // Catch:{ all -> 0x0235 }
            java.util.Deque<okhttp3.Headers> r0 = r5.headersQueue     // Catch:{ all -> 0x0235 }
            okhttp3.Headers r2 = okhttp3.internal.Util.toHeaders(r17)     // Catch:{ all -> 0x0235 }
            r0.add(r2)     // Catch:{ all -> 0x0235 }
            boolean r0 = r5.isOpen()     // Catch:{ all -> 0x0235 }
            r5.notifyAll()     // Catch:{ all -> 0x0235 }
            monitor-exit(r5)     // Catch:{ all -> 0x0235 }
            if (r0 != 0) goto L_0x022e
            okhttp3.internal.http2.Http2Connection r0 = r5.connection
            int r2 = r5.f2854id
            r0.removeStream(r2)
        L_0x022e:
            if (r6 == 0) goto L_0x0385
            r5.receiveFin()
            goto L_0x0385
        L_0x0235:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0235 }
            throw r0
        L_0x0238:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0238 }
            throw r0
        L_0x023b:
            java.lang.String r0 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            okhttp3.internal.http2.Http2.ioException(r0, r2)
            throw r5
        L_0x0243:
            r8 = 2
            if (r10 == 0) goto L_0x037d
            r6 = r9 & 1
            if (r6 == 0) goto L_0x024d
            r19 = 1
            goto L_0x024f
        L_0x024d:
            r19 = 0
        L_0x024f:
            r6 = r9 & 32
            if (r6 == 0) goto L_0x0255
            r6 = 1
            goto L_0x0256
        L_0x0255:
            r6 = 0
        L_0x0256:
            if (r6 != 0) goto L_0x0375
            r6 = r9 & 8
            if (r6 == 0) goto L_0x0266
            okio.BufferedSource r6 = r1.source
            byte r6 = r6.readByte()
            r6 = r6 & 255(0xff, float:3.57E-43)
            short r6 = (short) r6
            goto L_0x0267
        L_0x0266:
            r6 = 0
        L_0x0267:
            int r3 = lengthWithoutPadding(r3, r9, r6)
            okio.BufferedSource r7 = r1.source
            okhttp3.internal.http2.Http2Connection$ReaderRunnable r0 = (okhttp3.internal.http2.Http2Connection.ReaderRunnable) r0
            okhttp3.internal.http2.Http2Connection r9 = okhttp3.internal.http2.Http2Connection.this
            boolean r9 = r9.pushedStream(r10)
            if (r9 == 0) goto L_0x02ca
            okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
            if (r0 == 0) goto L_0x02c9
            okio.Buffer r5 = new okio.Buffer
            r5.<init>()
            long r11 = (long) r3
            r7.require(r11)
            r7.read(r5, r11)
            long r13 = r5.size
            int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x02ad
            okhttp3.internal.http2.Http2Connection$6 r7 = new okhttp3.internal.http2.Http2Connection$6
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.String r8 = r0.hostname
            r15[r2] = r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r15[r4] = r2
            java.lang.String r14 = "OkHttp %s Push Data[%s]"
            r12 = r7
            r13 = r0
            r16 = r10
            r17 = r5
            r18 = r3
            r12.<init>(r14, r15, r16, r17, r18, r19)
            r0.pushExecutorExecute(r7)
            goto L_0x036d
        L_0x02ad:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r4 = r5.size
            r2.append(r4)
            java.lang.String r4 = " != "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x02c9:
            throw r5
        L_0x02ca:
            okhttp3.internal.http2.Http2Connection r8 = okhttp3.internal.http2.Http2Connection.this
            okhttp3.internal.http2.Http2Stream r8 = r8.getStream(r10)
            if (r8 != 0) goto L_0x02e4
            okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this
            okhttp3.internal.http2.ErrorCode r5 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR
            r2.writeSynResetLater(r10, r5)
            okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
            long r2 = (long) r3
            r0.updateConnectionFlowControl(r2)
            r7.skip(r2)
            goto L_0x036d
        L_0x02e4:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r8.source
            long r9 = (long) r3
            if (r0 == 0) goto L_0x0374
        L_0x02e9:
            r11 = 0
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x0368
            okhttp3.internal.http2.Http2Stream r3 = okhttp3.internal.http2.Http2Stream.this
            monitor-enter(r3)
            boolean r5 = r0.finished     // Catch:{ all -> 0x0365 }
            okio.Buffer r13 = r0.readBuffer     // Catch:{ all -> 0x0365 }
            long r13 = r13.size     // Catch:{ all -> 0x0365 }
            long r13 = r13 + r9
            long r11 = r0.maxByteCount     // Catch:{ all -> 0x0365 }
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 <= 0) goto L_0x0301
            r11 = 1
            goto L_0x0302
        L_0x0301:
            r11 = 0
        L_0x0302:
            monitor-exit(r3)     // Catch:{ all -> 0x0365 }
            if (r11 == 0) goto L_0x0310
            r7.skip(r9)
            okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
            okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.FLOW_CONTROL_ERROR
            r0.closeLater(r2)
            goto L_0x0368
        L_0x0310:
            if (r5 == 0) goto L_0x0316
            r7.skip(r9)
            goto L_0x0368
        L_0x0316:
            okio.Buffer r3 = r0.receiveBuffer
            long r11 = r7.read(r3, r9)
            r13 = -1
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x035f
            long r9 = r9 - r11
            okhttp3.internal.http2.Http2Stream r3 = okhttp3.internal.http2.Http2Stream.this
            monitor-enter(r3)
            boolean r5 = r0.closed     // Catch:{ all -> 0x035c }
            if (r5 == 0) goto L_0x0334
            okio.Buffer r5 = r0.receiveBuffer     // Catch:{ all -> 0x035c }
            long r11 = r5.size     // Catch:{ all -> 0x035c }
            okio.Buffer r5 = r0.receiveBuffer     // Catch:{ all -> 0x035c }
            r5.clear()     // Catch:{ all -> 0x035c }
            goto L_0x0351
        L_0x0334:
            okio.Buffer r5 = r0.readBuffer     // Catch:{ all -> 0x035c }
            long r11 = r5.size     // Catch:{ all -> 0x035c }
            r13 = 0
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x0340
            r5 = 1
            goto L_0x0341
        L_0x0340:
            r5 = 0
        L_0x0341:
            okio.Buffer r11 = r0.readBuffer     // Catch:{ all -> 0x035c }
            okio.Buffer r12 = r0.receiveBuffer     // Catch:{ all -> 0x035c }
            r11.writeAll(r12)     // Catch:{ all -> 0x035c }
            if (r5 == 0) goto L_0x034f
            okhttp3.internal.http2.Http2Stream r5 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x035c }
            r5.notifyAll()     // Catch:{ all -> 0x035c }
        L_0x034f:
            r11 = 0
        L_0x0351:
            monitor-exit(r3)     // Catch:{ all -> 0x035c }
            r13 = 0
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x02e9
            r0.updateConnectionFlowControl(r11)
            goto L_0x02e9
        L_0x035c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x035c }
            throw r0
        L_0x035f:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        L_0x0365:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0365 }
            throw r0
        L_0x0368:
            if (r19 == 0) goto L_0x036d
            r8.receiveFin()
        L_0x036d:
            okio.BufferedSource r0 = r1.source
            long r2 = (long) r6
            r0.skip(r2)
            goto L_0x0385
        L_0x0374:
            throw r5
        L_0x0375:
            java.lang.String r0 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            okhttp3.internal.http2.Http2.ioException(r0, r2)
            throw r5
        L_0x037d:
            java.lang.String r0 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            okhttp3.internal.http2.Http2.ioException(r0, r2)
            throw r5
        L_0x0385:
            return r4
        L_0x0386:
            java.lang.String r0 = "FRAME_SIZE_ERROR: %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r2] = r3
            okhttp3.internal.http2.Http2.ioException(r0, r4)
            throw r5
        L_0x0394:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.nextFrame(boolean, okhttp3.internal.http2.Http2Reader$Handler):boolean");
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (!this.client) {
            ByteString readByteString = this.source.readByteString((long) Http2.CONNECTION_PREFACE.size());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(readByteString)) {
                Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
                throw null;
            }
        } else if (!nextFrame(true, handler)) {
            Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public final void readGoAway(Handler handler, int i, int i2) throws IOException {
        Http2Stream[] http2StreamArr;
        if (i < 8) {
            Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i3 = i - 8;
            if (ErrorCode.fromHttp2(readInt2) != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.source.readByteString((long) i3);
                }
                Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) handler;
                if (readerRunnable != null) {
                    byteString.size();
                    synchronized (Http2Connection.this) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                        Http2Connection.this.shutdown = true;
                    }
                    for (Http2Stream http2Stream : http2StreamArr) {
                        if (http2Stream.f2854id > readInt && http2Stream.isLocallyInitiated()) {
                            ErrorCode errorCode = ErrorCode.REFUSED_STREAM;
                            synchronized (http2Stream) {
                                if (http2Stream.errorCode == null) {
                                    http2Stream.errorCode = errorCode;
                                    http2Stream.notifyAll();
                                }
                            }
                            Http2Connection.this.removeStream(http2Stream.f2854id);
                        }
                    }
                    return;
                }
                throw null;
            }
            Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = s;
        continuationSource.flags = b;
        continuationSource.streamId = i2;
        Hpack.Reader reader = this.hpackReader;
        while (!reader.source.exhausted()) {
            byte readByte = reader.source.readByte() & Base64.EQUALS_SIGN_ENC;
            if (readByte == 128) {
                throw new IOException("index == 0");
            } else if ((readByte & 128) == 128) {
                int readInt = reader.readInt(readByte, 127) - 1;
                if (readInt >= 0 && readInt <= Hpack.STATIC_HEADER_TABLE.length + -1) {
                    reader.headerList.add(Hpack.STATIC_HEADER_TABLE[readInt]);
                } else {
                    int dynamicTableIndex = reader.dynamicTableIndex(readInt - Hpack.STATIC_HEADER_TABLE.length);
                    if (dynamicTableIndex >= 0) {
                        Header[] headerArr = reader.dynamicTable;
                        if (dynamicTableIndex < headerArr.length) {
                            reader.headerList.add(headerArr[dynamicTableIndex]);
                        }
                    }
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Header index too large ");
                    outline24.append(readInt + 1);
                    throw new IOException(outline24.toString());
                }
            } else if (readByte == 64) {
                ByteString readByteString = reader.readByteString();
                Hpack.checkLowercase(readByteString);
                reader.insertIntoDynamicTable(-1, new Header(readByteString, reader.readByteString()));
            } else if ((readByte & 64) == 64) {
                reader.insertIntoDynamicTable(-1, new Header(reader.getName(reader.readInt(readByte, 63) - 1), reader.readByteString()));
            } else if ((readByte & 32) == 32) {
                int readInt2 = reader.readInt(readByte, 31);
                reader.maxDynamicTableByteCount = readInt2;
                if (readInt2 < 0 || readInt2 > reader.headerTableSizeSetting) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Invalid dynamic table size update ");
                    outline242.append(reader.maxDynamicTableByteCount);
                    throw new IOException(outline242.toString());
                }
                int i3 = reader.dynamicTableByteCount;
                if (readInt2 < i3) {
                    if (readInt2 == 0) {
                        reader.clearDynamicTable();
                    } else {
                        reader.evictToRecoverBytes(i3 - readInt2);
                    }
                }
            } else if (readByte == 16 || readByte == 0) {
                ByteString readByteString2 = reader.readByteString();
                Hpack.checkLowercase(readByteString2);
                reader.headerList.add(new Header(readByteString2, reader.readByteString()));
            } else {
                reader.headerList.add(new Header(reader.getName(reader.readInt(readByte, 15) - 1), reader.readByteString()));
            }
        }
        Hpack.Reader reader2 = this.hpackReader;
        if (reader2 != null) {
            ArrayList arrayList = new ArrayList(reader2.headerList);
            reader2.headerList.clear();
            return arrayList;
        }
        throw null;
    }

    public final void readPing(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) handler;
            if (readerRunnable == null) {
                throw null;
            } else if (z) {
                synchronized (Http2Connection.this) {
                    if (readInt == 1) {
                        try {
                            Http2Connection.this.intervalPongsReceived++;
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (readInt == 2) {
                        Http2Connection.this.degradedPongsReceived++;
                    } else if (readInt == 3) {
                        Http2Connection.this.awaitPongsReceived++;
                        Http2Connection.this.notifyAll();
                    }
                }
            } else {
                try {
                    Http2Connection.this.writerExecutor.execute(new Http2Connection.PingRunnable(true, readInt, readInt2));
                } catch (RejectedExecutionException unused) {
                }
            }
        } else {
            Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void readPriority(Handler handler, int i) throws IOException {
        int readInt = this.source.readInt() & Integer.MIN_VALUE;
        this.source.readByte();
        if (((Http2Connection.ReaderRunnable) handler) == null) {
            throw null;
        }
    }

    public final void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            short readByte = (b & 8) != 0 ? (short) (this.source.readByte() & Base64.EQUALS_SIGN_ENC) : 0;
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            List<Header> readHeaderBlock = readHeaderBlock(lengthWithoutPadding(i - 4, b, readByte), readByte, b, i2);
            Http2Connection http2Connection = Http2Connection.this;
            synchronized (http2Connection) {
                if (http2Connection.currentPushRequests.contains(Integer.valueOf(readInt))) {
                    http2Connection.writeSynResetLater(readInt, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                http2Connection.currentPushRequests.add(Integer.valueOf(readInt));
                try {
                    http2Connection.pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{http2Connection.hostname, Integer.valueOf(readInt)}, readInt, readHeaderBlock) {
                        public final /* synthetic */ List val$requestHeaders;
                        public final /* synthetic */ int val$streamId;

                        public void execute(
/*
Method generation error in method: okhttp3.internal.http2.Http2Connection.4.execute():void, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: okhttp3.internal.http2.Http2Connection.4.execute():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:260)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        } else {
            Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void readRstStream(Handler handler, int i, int i2) throws IOException {
        if (i != 4) {
            Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) handler;
                if (Http2Connection.this.pushedStream(i2)) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{http2Connection.hostname, Integer.valueOf(i2)}, i2, fromHttp2) {
                        public final /* synthetic */ ErrorCode val$errorCode;
                        public final /* synthetic */ int val$streamId;

                        public void execute(
/*
Method generation error in method: okhttp3.internal.http2.Http2Connection.7.execute():void, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: okhttp3.internal.http2.Http2Connection.7.execute():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    });
                    return;
                }
                Http2Stream removeStream = Http2Connection.this.removeStream(i2);
                if (removeStream != null) {
                    synchronized (removeStream) {
                        if (removeStream.errorCode == null) {
                            removeStream.errorCode = fromHttp2;
                            removeStream.notifyAll();
                        }
                    }
                    return;
                }
                return;
            }
            Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void readWindowUpdate(Handler handler, int i, int i2) throws IOException {
        if (i == 4) {
            long readInt = ((long) this.source.readInt()) & 2147483647L;
            if (readInt != 0) {
                Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) handler;
                if (i2 == 0) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.bytesLeftInWriteWindow += readInt;
                        Http2Connection.this.notifyAll();
                    }
                    return;
                }
                Http2Stream stream = Http2Connection.this.getStream(i2);
                if (stream != null) {
                    synchronized (stream) {
                        stream.bytesLeftInWriteWindow += readInt;
                        if (readInt > 0) {
                            stream.notifyAll();
                        }
                    }
                    return;
                }
                return;
            }
            Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        throw null;
    }
}
