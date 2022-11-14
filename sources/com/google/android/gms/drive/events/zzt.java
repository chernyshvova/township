package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "TransferProgressOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzct;

    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Param(mo17150id = 2) int i) {
        this.zzct = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzct);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
