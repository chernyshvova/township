package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaw extends FilterInputStream {
    public final long zza;
    public long zzb;

    public zzaw(InputStream inputStream, long j) {
        super(inputStream);
        this.zza = j;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzb++;
        }
        return read;
    }

    public final long zza() {
        return this.zza - this.zzb;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzb += (long) read;
        }
        return read;
    }
}
