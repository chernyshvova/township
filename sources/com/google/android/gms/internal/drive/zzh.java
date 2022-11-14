package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "TransferProgressDataCreator")
@SafeParcelable.Reserved({1})
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    @SafeParcelable.Field(mo17147id = 4)
    public final int status;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzct;
    @SafeParcelable.Field(mo17147id = 5)
    public final long zzcw;
    @SafeParcelable.Field(mo17147id = 6)
    public final long zzcx;
    @SafeParcelable.Field(mo17147id = 3)
    public final DriveId zzk;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(mo17150id = 2) int i, @SafeParcelable.Param(mo17150id = 3) DriveId driveId, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) long j, @SafeParcelable.Param(mo17150id = 6) long j2) {
        this.zzct = i;
        this.zzk = driveId;
        this.status = i2;
        this.zzcw = j;
        this.zzcx = j2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzh.class) {
            if (obj == this) {
                return true;
            }
            zzh zzh = (zzh) obj;
            return this.zzct == zzh.zzct && Objects.equal(this.zzk, zzh.zzk) && this.status == zzh.status && this.zzcw == zzh.zzcw && this.zzcx == zzh.zzcx;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzct), this.zzk, Integer.valueOf(this.status), Long.valueOf(this.zzcw), Long.valueOf(this.zzcx));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzct);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.status);
        SafeParcelWriter.writeLong(parcel, 5, this.zzcw);
        SafeParcelWriter.writeLong(parcel, 6, this.zzcx);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
