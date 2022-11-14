package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.bd */
public final class C2200bd extends InputStream {

    /* renamed from: a */
    public final InputStream f2953a;

    /* renamed from: b */
    public long f2954b;

    public C2200bd(InputStream inputStream, long j) {
        this.f2953a = inputStream;
        this.f2954b = j;
    }

    public final void close() throws IOException {
        super.close();
        this.f2953a.close();
        this.f2954b = 0;
    }

    public final int read() throws IOException {
        long j = this.f2954b;
        if (j <= 0) {
            return -1;
        }
        this.f2954b = j - 1;
        return this.f2953a.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f2954b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f2953a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f2954b -= (long) read;
        }
        return read;
    }
}
