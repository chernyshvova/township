package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zau;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zam implements Parcelable.Creator<zak> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ConnectionResult connectionResult = null;
        zau zau = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readHeader, ConnectionResult.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zau = (zau) SafeParcelReader.createParcelable(parcel, readHeader, zau.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zak(i, connectionResult, zau);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zak[i];
    }
}
