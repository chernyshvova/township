package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class ResponseBody implements Closeable {
    @Nullable
    public Reader reader;

    public static final class BomAwareReader extends Reader {
        public final Charset charset;
        public boolean closed;
        @Nullable
        public Reader delegate;
        public final BufferedSource source;

        public BomAwareReader(BufferedSource bufferedSource, Charset charset2) {
            this.source = bufferedSource;
            this.charset = charset2;
        }

        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.bomAwareCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        Charset charset = Util.UTF_8;
        if (contentType == null) {
            return charset;
        }
        try {
            return contentType.charset != null ? Charset.forName(contentType.charset) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType r4, java.lang.String r5) {
        /*
            java.nio.charset.Charset r0 = okhttp3.internal.Util.UTF_8
            if (r4 == 0) goto L_0x0029
            java.lang.String r0 = r4.charset     // Catch:{ IllegalArgumentException -> 0x000f }
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r4.charset     // Catch:{ IllegalArgumentException -> 0x000f }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ IllegalArgumentException -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0029
            java.nio.charset.Charset r0 = okhttp3.internal.Util.UTF_8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r4 = "; charset=utf-8"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            okhttp3.MediaType r4 = okhttp3.MediaType.parse(r4)
        L_0x0029:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            int r2 = r5.length()
            r3 = 0
            okio.Buffer r5 = r1.writeString(r5, r3, r2, r0)
            long r0 = r5.size
            okhttp3.ResponseBody r4 = create(r4, r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.create(okhttp3.MediaType, java.lang.String):okhttp3.ResponseBody");
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                byte[] readByteArray = source.readByteArray();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) readByteArray.length)) {
                    return readByteArray;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            return source.readString(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        Buffer buffer = new Buffer();
        buffer.write(bArr);
        return create(mediaType, (long) bArr.length, buffer);
    }

    public static ResponseBody create(@Nullable MediaType mediaType, ByteString byteString) {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        return create(mediaType, (long) byteString.size(), buffer);
    }

    public static ResponseBody create(@Nullable final MediaType mediaType, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ResponseBody() {
                public long contentLength() {
                    return j;
                }

                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
