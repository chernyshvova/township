package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzr;
import java.util.List;

@SafeParcelable.Class(creator = "GetPermissionsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzem> CREATOR = new zzen();
    @SafeParcelable.Field(mo17147id = 3)
    public final int responseCode;
    @SafeParcelable.Field(mo17147id = 2)
    public final List<zzr> zzhb;

    @SafeParcelable.Constructor
    public zzem(@SafeParcelable.Param(mo17150id = 2) List<zzr> list, @SafeParcelable.Param(mo17150id = 3) int i) {
        this.zzhb = list;
        this.responseCode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzhb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.responseCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
