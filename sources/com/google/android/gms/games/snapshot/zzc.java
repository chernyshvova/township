package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzc implements Parcelable.Creator<SnapshotMetadataChangeEntity> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Long l = null;
        BitmapTeleporter bitmapTeleporter = null;
        Uri uri = null;
        Long l2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                l = SafeParcelReader.readLongObject(parcel, readHeader);
            } else if (fieldId == 4) {
                uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
            } else if (fieldId == 5) {
                bitmapTeleporter = (BitmapTeleporter) SafeParcelReader.createParcelable(parcel, readHeader, BitmapTeleporter.CREATOR);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                l2 = SafeParcelReader.readLongObject(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SnapshotMetadataChangeEntity(str, l, bitmapTeleporter, uri, l2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
