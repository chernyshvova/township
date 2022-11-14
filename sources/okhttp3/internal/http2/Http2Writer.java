package okhttp3.internal.http2;

import com.playrix.gplay.billing.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

public final class Http2Writer implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public final boolean client;
    public boolean closed;
    public final Buffer hpackBuffer;
    public final Hpack.Writer hpackWriter;
    public int maxFrameSize = 16384;
    public final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.sink = bufferedSink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            int i = this.maxFrameSize;
            if ((settings.set & 32) != 0) {
                i = settings.values[5];
            }
            this.maxFrameSize = i;
            int i2 = -1;
            if (((settings.set & 2) != 0 ? settings.values[1] : -1) != -1) {
                Hpack.Writer writer = this.hpackWriter;
                if ((settings.set & 2) != 0) {
                    i2 = settings.values[1];
                }
                if (writer != null) {
                    int min = Math.min(i2, 16384);
                    int i3 = writer.maxDynamicTableByteCount;
                    if (i3 != min) {
                        if (min < i3) {
                            writer.smallestHeaderTableSizeSetting = Math.min(writer.smallestHeaderTableSizeSetting, min);
                        }
                        writer.emitDynamicTableSizeUpdate = true;
                        writer.maxDynamicTableByteCount = min;
                        int i4 = writer.dynamicTableByteCount;
                        if (min < i4) {
                            if (min == 0) {
                                writer.clearDynamicTable();
                            } else {
                                writer.evictToRecoverBytes(i4 - min);
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.closed) {
            frameHeader(i, i2, (byte) 0, z ? (byte) 1 : 0);
            if (i2 > 0) {
                this.sink.write(buffer, (long) i2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void frameHeader(int i, int i2, byte b, byte b2) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i, i2, b, b2));
        }
        int i3 = this.maxFrameSize;
        if (i2 > i3) {
            Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) == 0) {
            BufferedSink bufferedSink = this.sink;
            bufferedSink.writeByte((i2 >>> 16) & 255);
            bufferedSink.writeByte((i2 >>> 8) & 255);
            bufferedSink.writeByte(i2 & 255);
            this.sink.writeByte(b & Base64.EQUALS_SIGN_ENC);
            this.sink.writeByte(b2 & Base64.EQUALS_SIGN_ENC);
            this.sink.writeInt(i & Integer.MAX_VALUE);
        } else {
            Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
    }

    public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.sink.writeInt(i);
            this.sink.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        } else {
            Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public void headers(boolean z, int i, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long j = this.hpackBuffer.size;
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            byte b = j == j2 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            frameHeader(i, min, (byte) 1, b);
            this.sink.write(this.hpackBuffer, j2);
            if (j > j2) {
                writeContinuationFrames(i, j - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.sink.writeInt(i);
            this.sink.writeInt(i2);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(i, 4, (byte) 3, (byte) 0);
            this.sink.writeInt(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            frameHeader(i, 4, (byte) 8, (byte) 0);
            this.sink.writeInt((int) j);
            this.sink.flush();
        }
    }

    public final void writeContinuationFrames(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            j -= j2;
            frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }
}
