package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "OnDriveIdResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfo();
    @SafeParcelable.Field(mo17147id = 2)
    public DriveId zzdd;

    @SafeParcelable.Constructor
    public zzfn(@SafeParcelable.Param(mo17150id = 2) DriveId driveId) {
        this.zzdd = driveId;
    }

    public final DriveId getDriveId() {
        return this.zzdd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
