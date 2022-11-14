package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzm;
import java.util.Locale;

public final class zze implements zzk {
    public final zzm zzcv;
    public final long zzcw;
    public final long zzcx;

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.drive.events.zzm, com.google.android.gms.internal.drive.zzf] */
    public zze(zzh zzh) {
        this.zzcv = new zzf(zzh);
        this.zzcw = zzh.zzcw;
        this.zzcx = zzh.zzcx;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zze.class) {
            if (obj == this) {
                return true;
            }
            zze zze = (zze) obj;
            return Objects.equal(this.zzcv, zze.zzcv) && this.zzcw == zze.zzcw && this.zzcx == zze.zzcx;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzcx), Long.valueOf(this.zzcw), Long.valueOf(this.zzcx));
    }

    public final String toString() {
        return String.format(Locale.US, "FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", new Object[]{this.zzcv.toString(), Long.valueOf(this.zzcw), Long.valueOf(this.zzcx)});
    }
}
