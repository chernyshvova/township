package com.google.android.gms.games;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface CurrentPlayerInfo extends Freezable<CurrentPlayerInfo>, Parcelable {
    int getFriendsListVisibilityStatus();
}
