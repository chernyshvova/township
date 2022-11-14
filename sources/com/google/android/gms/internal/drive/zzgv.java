package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzgv implements Parcelable.Creator<zzgu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzei zzei = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzei = (zzei) SafeParcelReader.createParcelable(parcel, readHeader, zzei.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzgu(zzei);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzgu[i];
    }
}
