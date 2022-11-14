package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import com.google.android.gms.drive.DriveFile;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaab extends zzrr {
    public long zzf;
    public int zzg;
    public int zzh = 32;

    public zzaab() {
        super(2, 0);
    }

    public final void zza() {
        super.zza();
        this.zzg = 0;
    }

    public final void zzl(@IntRange(from = 1) int i) {
        this.zzh = i;
    }

    public final long zzm() {
        return this.zzf;
    }

    public final int zzn() {
        return this.zzg;
    }

    public final boolean zzo() {
        return this.zzg > 0;
    }

    public final boolean zzp(zzrr zzrr) {
        ByteBuffer byteBuffer;
        zzajg.zza(!zzrr.zzh(1073741824));
        zzajg.zza(!zzrr.zzh(DriveFile.MODE_READ_ONLY));
        zzajg.zza(!zzrr.zzh(4));
        if (zzo()) {
            if (this.zzg >= this.zzh || zzrr.zzh(Integer.MIN_VALUE) != zzh(Integer.MIN_VALUE)) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzrr.zzb;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzb) == null)) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.zzg;
        this.zzg = i + 1;
        if (i == 0) {
            this.zzd = zzrr.zzd;
            if (zzrr.zzh(1)) {
                zzf(1);
            }
        }
        if (zzrr.zzh(Integer.MIN_VALUE)) {
            zzf(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = zzrr.zzb;
        if (byteBuffer3 != null) {
            zzi(byteBuffer3.remaining());
            this.zzb.put(byteBuffer3);
        }
        this.zzf = zzrr.zzd;
        return true;
    }
}
