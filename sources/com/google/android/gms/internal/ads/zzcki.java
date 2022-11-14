package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcki implements zzgis {
    public final ByteBuffer zza;

    public zzcki(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int zza(ByteBuffer byteBuffer) throws IOException {
        if (this.zza.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zza.remaining());
        byte[] bArr = new byte[min];
        this.zza.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long zzb() throws IOException {
        return (long) this.zza.limit();
    }

    public final long zzc() throws IOException {
        return (long) this.zza.position();
    }

    public final void zzd(long j) throws IOException {
        this.zza.position((int) j);
    }

    public final ByteBuffer zze(long j, long j2) throws IOException {
        int position = this.zza.position();
        this.zza.position((int) j);
        ByteBuffer slice = this.zza.slice();
        slice.limit((int) j2);
        this.zza.position(position);
        return slice;
    }
}
