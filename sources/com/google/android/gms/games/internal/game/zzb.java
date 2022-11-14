package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzb extends zzc {
    /* renamed from: zza */
    public final GameBadgeEntity createFromParcel(Parcel parcel) {
        Uri uri;
        if (GamesDowngradeableSafeParcel.zzo(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        if (readString3 == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString3);
        }
        return new GameBadgeEntity(readInt, readString, readString2, uri);
    }
}
