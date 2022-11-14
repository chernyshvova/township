package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzb implements Parcelable.Creator<VideoConfiguration> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 7) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 8) {
                z2 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 9) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                z3 = SafeParcelReader.readBoolean(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new VideoConfiguration(i, i2, z, z2, z3);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VideoConfiguration[i];
    }
}
