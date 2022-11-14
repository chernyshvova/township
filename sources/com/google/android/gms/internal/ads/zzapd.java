package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapd extends zzaoy {
    public final zzapb zza = new zzapb();
    public ByteBuffer zzb;
    public long zzc;

    public zzapd(int i) {
    }

    private final ByteBuffer zzj(int i) {
        ByteBuffer byteBuffer = this.zzb;
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(44, "Buffer too small (", byteBuffer == null ? 0 : byteBuffer.capacity(), " < ", i);
        outline22.append(")");
        throw new IllegalStateException(outline22.toString());
    }

    public final void zza() {
        super.zza();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void zzh(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = zzj(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzb.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzj = zzj(i2);
            if (position > 0) {
                this.zzb.position(0);
                this.zzb.limit(position);
                zzj.put(this.zzb);
            }
            this.zzb = zzj;
        }
    }

    public final boolean zzi() {
        return zzg(1073741824);
    }
}
