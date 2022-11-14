package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.RealBufferedSink;
import okio.Source;

public abstract class RequestBody {
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType r2, java.lang.String r3) {
        /*
            java.nio.charset.Charset r0 = okhttp3.internal.Util.UTF_8
            if (r2 == 0) goto L_0x0029
            java.lang.String r0 = r2.charset     // Catch:{ IllegalArgumentException -> 0x000f }
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r2.charset     // Catch:{ IllegalArgumentException -> 0x000f }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ IllegalArgumentException -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0029
            java.nio.charset.Charset r0 = okhttp3.internal.Util.UTF_8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "; charset=utf-8"
            r1.append(r2)
            java.lang.String r2 = r1.toString()
            okhttp3.MediaType r2 = okhttp3.MediaType.parse(r2)
        L_0x0029:
            byte[] r3 = r3.getBytes(r0)
            okhttp3.RequestBody r2 = create((okhttp3.MediaType) r2, (byte[]) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RequestBody.create(okhttp3.MediaType, java.lang.String):okhttp3.RequestBody");
    }

    public abstract long contentLength() throws IOException;

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(@Nullable final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            public long contentLength() throws IOException {
                return (long) byteString.size();
            }

            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                ((RealBufferedSink) bufferedSink).write(byteString);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                public long contentLength() {
                    return (long) i2;
                }

                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    ((RealBufferedSink) bufferedSink).write(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public long contentLength() {
                    return file.length();
                }

                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Source source = null;
                    try {
                        source = Okio.source(file);
                        ((RealBufferedSink) bufferedSink).writeAll(source);
                    } finally {
                        Util.closeQuietly((Closeable) source);
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
