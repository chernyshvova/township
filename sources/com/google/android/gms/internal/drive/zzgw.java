package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import java.util.List;

@SafeParcelable.Class(creator = "SetResourceParentsRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgw> CREATOR = new zzgx();
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzis;
    @SafeParcelable.Field(mo17147id = 3)
    public final List<DriveId> zzit;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgw(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) List<DriveId> list) {
        this.zzis = driveId;
        this.zzit = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzis, i, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzit, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
