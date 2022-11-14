package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzd extends zze {
    /* renamed from: zza */
    public final GameEntity createFromParcel(Parcel parcel) {
        Uri uri;
        Uri uri2;
        Uri uri3;
        if (GamesDowngradeableSafeParcel.zzo(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        String readString7 = parcel.readString();
        if (readString7 == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString7);
        }
        String readString8 = parcel.readString();
        if (readString8 == null) {
            uri2 = null;
        } else {
            uri2 = Uri.parse(readString8);
        }
        String readString9 = parcel.readString();
        if (readString9 == null) {
            uri3 = null;
        } else {
            uri3 = Uri.parse(readString9);
        }
        return new GameEntity(readString, readString2, readString3, readString4, readString5, readString6, uri, uri2, uri3, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, (String) null, (String) null, (String) null, false, false, false, (String) null, false);
    }
}
