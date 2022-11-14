package com.google.android.gms.games;

import android.os.Parcelable;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface PlayerRelationshipInfo extends Freezable<PlayerRelationshipInfo>, Parcelable {
    int getFriendStatus();

    @RecentlyNullable
    String zza();

    @RecentlyNullable
    String zzb();

    @RecentlyNullable
    String zzc();
}
