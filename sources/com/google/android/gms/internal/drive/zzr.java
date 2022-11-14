package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CreateContentsRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.drive.DriveFile.MODE_WRITE_ONLY", mo17147id = 2)
    public final int mode;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(mo17150id = 2) int i) {
        Preconditions.checkArgument(i == 536870912 || i == 805306368, "Cannot create a new read-only contents!");
        this.mode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.mode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
