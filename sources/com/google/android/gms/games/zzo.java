package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzo extends zzp {
    /* renamed from: zza */
    public final PlayerEntity createFromParcel(Parcel parcel) {
        Uri uri;
        Uri uri2;
        if (GamesDowngradeableSafeParcel.zzo(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        long readLong = parcel.readLong();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        if (readString3 == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString3);
        }
        if (readString4 == null) {
            uri2 = null;
        } else {
            uri2 = Uri.parse(readString4);
        }
        return new PlayerEntity(readString, readString2, uri, uri2, readLong, -1, -1, (String) null, (String) null, (String) null, (MostRecentGameInfoEntity) null, (PlayerLevelInfo) null, true, false, readString5, readString6, (Uri) null, (String) null, (Uri) null, (String) null, -1, (zzs) null, (zza) null, false);
    }
}
