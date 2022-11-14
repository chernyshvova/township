package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "OpenContentsRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgj> CREATOR = new zzgk();
    @SafeParcelable.Field(mo17147id = 3)
    public final int mode;
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzdd;
    @SafeParcelable.Field(mo17147id = 4)
    public final int zzip;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgj(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) int i2) {
        this.zzdd = driveId;
        this.mode = i;
        this.zzip = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.mode);
        SafeParcelWriter.writeInt(parcel, 4, this.zzip);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
