package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqm extends zzql {
    @Nullable
    public int[] zzd;
    @Nullable
    public int[] zze;

    public final void zzc(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        if (iArr != null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            ByteBuffer zzi = zzi(((limit - position) / this.zzb.zze) * this.zzc.zze);
            while (position < limit) {
                for (int i : iArr) {
                    zzi.putShort(byteBuffer.getShort(i + i + position));
                }
                position += this.zzb.zze;
            }
            byteBuffer.position(limit);
            zzi.flip();
            return;
        }
        throw null;
    }

    public final zzpl zzk(zzpl zzpl) throws zzpm {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzpl.zza;
        }
        if (zzpl.zzd == 2) {
            boolean z = zzpl.zzc != iArr.length;
            int i = 0;
            while (true) {
                int length = iArr.length;
                if (i >= length) {
                    return z ? new zzpl(zzpl.zzb, length, 2) : zzpl.zza;
                }
                int i2 = iArr[i];
                if (i2 < zzpl.zzc) {
                    z |= i2 != i;
                    i++;
                } else {
                    throw new zzpm(zzpl);
                }
            }
        } else {
            throw new zzpm(zzpl);
        }
    }

    public final void zzm() {
        this.zze = this.zzd;
    }

    public final void zzn() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(@Nullable int[] iArr) {
        this.zzd = iArr;
    }
}
