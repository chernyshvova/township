package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PartialDriveIdCreator")
@SafeParcelable.Reserved({1})
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public final String zzad;
    @SafeParcelable.Field(mo17147id = 3)
    public final long zzae;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.drive.DriveId.RESOURCE_TYPE_UNKNOWN", mo17147id = 4)
    public final int zzaf;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) long j, @SafeParcelable.Param(mo17150id = 4) int i) {
        this.zzad = str;
        this.zzae = j;
        this.zzaf = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzad, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzae);
        SafeParcelWriter.writeInt(parcel, 4, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
