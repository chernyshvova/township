package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zza extends zzb {
    /* renamed from: zza */
    public final ParticipantEntity createFromParcel(Parcel parcel) {
        if (GamesDowngradeableSafeParcel.zzo(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        return new ParticipantEntity();
    }
}
