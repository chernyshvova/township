package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnSyncMoreResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzgh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgh> CREATOR = new zzgi();
    @SafeParcelable.Field(mo17147id = 2)
    public final boolean zzea;

    @SafeParcelable.Constructor
    public zzgh(@SafeParcelable.Param(mo17150id = 2) boolean z) {
        this.zzea = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzea);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
