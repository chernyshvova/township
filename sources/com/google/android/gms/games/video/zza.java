package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zza implements Parcelable.Creator<VideoCapabilities> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean[] zArr = null;
        boolean[] zArr2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 2) {
                z2 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 3) {
                z3 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                zArr = SafeParcelReader.createBooleanArray(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zArr2 = SafeParcelReader.createBooleanArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new VideoCapabilities(z, z2, z3, zArr, zArr2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VideoCapabilities[i];
    }
}
