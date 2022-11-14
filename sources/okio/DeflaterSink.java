package okio;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {
    public boolean closed;
    public final Deflater deflater;
    public final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        if (deflater2 != null) {
            this.sink = bufferedSink;
            this.deflater = deflater2;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                this.deflater.finish();
                deflate(false);
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

    @IgnoreJRERequirement
    public final void deflate(boolean z) throws IOException {
        Segment writableSegment;
        int i;
        Buffer buffer = this.sink.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            if (z) {
                Deflater deflater2 = this.deflater;
                byte[] bArr = writableSegment.data;
                int i2 = writableSegment.limit;
                i = deflater2.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater3 = this.deflater;
                byte[] bArr2 = writableSegment.data;
                int i3 = writableSegment.limit;
                i = deflater3.deflate(bArr2, i3, 8192 - i3);
            }
            if (i > 0) {
                writableSegment.limit += i;
                buffer.size += (long) i;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment.pos == writableSegment.limit) {
            buffer.head = writableSegment.pop();
            SegmentPool.recycle(writableSegment);
        }
    }

    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("DeflaterSink(");
        outline24.append(this.sink);
        outline24.append(")");
        return outline24.toString();
    }

    public void write(Buffer buffer, long j) throws IOException {
        Util.checkOffsetAndCount(buffer.size, 0, j);
        while (j > 0) {
            Segment segment = buffer.head;
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j2 = (long) min;
            buffer.size -= j2;
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j -= j2;
        }
    }
}
