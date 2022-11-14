package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* renamed from: com.google.android.play.core.assetpacks.dc */
public final class C2242dc extends InputStream {

    /* renamed from: a */
    public final Enumeration<File> f3116a;
    @Nullable

    /* renamed from: b */
    public InputStream f3117b;

    public C2242dc(Enumeration<File> enumeration) throws IOException {
        this.f3116a = enumeration;
        mo33226a();
    }

    /* renamed from: a */
    public final void mo33226a() throws IOException {
        InputStream inputStream = this.f3117b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f3117b = this.f3116a.hasMoreElements() ? new FileInputStream(this.f3116a.nextElement()) : null;
    }

    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f3117b;
        if (inputStream != null) {
            inputStream.close();
            this.f3117b = null;
        }
    }

    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f3117b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            mo33226a();
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3117b == null) {
            return -1;
        }
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.f3117b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                mo33226a();
            } while (this.f3117b != null);
            return -1;
        }
    }
}
