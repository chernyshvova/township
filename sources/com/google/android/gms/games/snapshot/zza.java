package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.Contents;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zza implements Parcelable.Creator<SnapshotContentsEntity> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Contents contents = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                contents = (Contents) SafeParcelReader.createParcelable(parcel, readHeader, Contents.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SnapshotContentsEntity(contents);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SnapshotContentsEntity[i];
    }
}
