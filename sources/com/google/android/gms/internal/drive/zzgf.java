package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnStartStreamSessionCreator")
@SafeParcelable.Reserved({1})
public final class zzgf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgf> CREATOR = new zzgg();
    @SafeParcelable.Field(mo17147id = 2)
    public final ParcelFileDescriptor zzin;
    @SafeParcelable.Field(mo17147id = 3)
    public final IBinder zzio;
    @SafeParcelable.Field(mo17147id = 4)
    public final String zzm;

    @SafeParcelable.Constructor
    public zzgf(@SafeParcelable.Param(mo17150id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo17150id = 3) IBinder iBinder, @SafeParcelable.Param(mo17150id = 4) String str) {
        this.zzin = parcelFileDescriptor;
        this.zzio = iBinder;
        this.zzm = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzin, i | 1, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzio, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
