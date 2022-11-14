package okio;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.nio.ByteBuffer;
import okio.Okio;

public final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink2) {
        if (sink2 != null) {
            this.sink = sink2;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public Buffer buffer() {
        return this.buffer;
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (this.buffer.size > 0) {
                    this.sink.write(this.buffer, this.buffer.size);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.sink.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.closed = true;
            if (th != null) {
                Util.sneakyRethrow(th);
                throw null;
            }
        }
    }

    public BufferedSink emit() throws IOException {
        if (!this.closed) {
            Buffer buffer2 = this.buffer;
            long j = buffer2.size;
            if (j > 0) {
                this.sink.write(buffer2, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink emitCompleteSegments() throws IOException {
        if (!this.closed) {
            long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.buffer, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.closed) {
            Buffer buffer2 = this.buffer;
            long j = buffer2.size;
            if (j > 0) {
                this.sink.write(buffer2, j);
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("buffer(");
        outline24.append(this.sink);
        outline24.append(")");
        return outline24.toString();
    }

    public void write(Buffer buffer2, long j) throws IOException {
        if (!this.closed) {
            this.buffer.write(buffer2, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long writeAll(Source source) throws IOException {
        long j = 0;
        while (true) {
            long read = ((Okio.C20882) source).read(this.buffer, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    public BufferedSink writeByte(int i) throws IOException {
        if (!this.closed) {
            this.buffer.writeByte(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException {
        if (!this.closed) {
            this.buffer.writeHexadecimalUnsignedLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeInt(int i) throws IOException {
        if (!this.closed) {
            this.buffer.writeInt(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeIntLe(int i) throws IOException {
        if (!this.closed) {
            Buffer buffer2 = this.buffer;
            if (buffer2 != null) {
                buffer2.writeInt(Util.reverseBytesInt(i));
                emitCompleteSegments();
                return this;
            }
            throw null;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShort(int i) throws IOException {
        if (!this.closed) {
            this.buffer.writeShort(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str) throws IOException {
        if (!this.closed) {
            this.buffer.writeUtf8(str);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(ByteString byteString) throws IOException {
        if (!this.closed) {
            this.buffer.write(byteString);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.closed) {
            this.buffer.write(bArr);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            this.buffer.write(bArr, i, i2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.closed) {
            int write = this.buffer.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
