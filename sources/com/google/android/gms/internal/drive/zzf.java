package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.drive.DriveId;

public final class zzf {
    public final int status;
    public final int zzct;
    public final DriveId zzk;

    public zzf(zzh zzh) {
        this.zzk = zzh.zzk;
        this.zzct = zzh.zzct;
        this.status = zzh.status;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzf.class) {
            if (obj == this) {
                return true;
            }
            zzf zzf = (zzf) obj;
            return Objects.equal(this.zzk, zzf.zzk) && this.zzct == zzf.zzct && this.status == zzf.status;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzk, Integer.valueOf(this.zzct), Integer.valueOf(this.status));
    }

    public final String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", new Object[]{Integer.valueOf(this.zzct), this.zzk, Integer.valueOf(this.status)});
    }
}
