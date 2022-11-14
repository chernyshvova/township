package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {
    public boolean closed;
    public final CRC32 crc = new CRC32();
    public final Deflater deflater = new Deflater(-1, true);
    public final DeflaterSink deflaterSink;
    public final BufferedSink sink;

    public GzipSink(Sink sink2) {
        BufferedSink buffer = Okio.buffer(sink2);
        this.sink = buffer;
        this.deflaterSink = new DeflaterSink(buffer, this.deflater);
        Buffer buffer2 = this.sink.buffer();
        buffer2.writeShort(8075);
        buffer2.writeByte(8);
        buffer2.writeByte(0);
        buffer2.writeInt(0);
        buffer2.writeByte(0);
        buffer2.writeByte(0);
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                DeflaterSink deflaterSink2 = this.deflaterSink;
                deflaterSink2.deflater.finish();
                deflaterSink2.deflate(false);
                this.sink.writeIntLe((int) this.crc.getValue());
                this.sink.writeIntLe((int) this.deflater.getBytesRead());
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.deflater.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                Util.sneakyRethrow(th);
                throw null;
            }
        }
    }

    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            Segment segment = buffer.head;
            long j2 = j;
            while (j2 > 0) {
                int min = (int) Math.min(j2, (long) (segment.limit - segment.pos));
                this.crc.update(segment.data, segment.pos, min);
                j2 -= (long) min;
                segment = segment.next;
            }
            this.deflaterSink.write(buffer, j);
        }
    }
}
