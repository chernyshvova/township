package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.PlayerEntity;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zza implements Parcelable.Creator<EventEntity> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        PlayerEntity playerEntity = null;
        String str5 = null;
        long j = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    playerEntity = (PlayerEntity) SafeParcelReader.createParcelable(parcel2, readHeader, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new EventEntity(str, str2, str3, uri, str4, playerEntity, j, str5, z);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new EventEntity[i];
    }
}
