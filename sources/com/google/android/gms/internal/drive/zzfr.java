package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnFetchThumbnailResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfr> CREATOR = new zzfs();
    @SafeParcelable.Field(mo17147id = 2)
    public final ParcelFileDescriptor zzih;

    @SafeParcelable.Constructor
    public zzfr(@SafeParcelable.Param(mo17150id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzih = parcelFileDescriptor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzih, i | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
