package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface StockProfileImage extends Freezable<StockProfileImage>, Parcelable {
    @RecentlyNonNull
    String getImageUrl();

    @RecentlyNonNull
    Uri zza();
}
