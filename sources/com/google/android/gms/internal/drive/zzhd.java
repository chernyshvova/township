package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "UntrashResourceRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzhd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhd> CREATOR = new zzhe();
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzdd;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzhd(@SafeParcelable.Param(mo17150id = 2) DriveId driveId) {
        this.zzdd = driveId;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
