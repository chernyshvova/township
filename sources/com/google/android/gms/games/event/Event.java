package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Player;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface Event extends Freezable<Event>, Parcelable {
    @RecentlyNonNull
    String getDescription();

    void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    String getEventId();

    @RecentlyNonNull
    String getFormattedValue();

    void getFormattedValue(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    Uri getIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    @RecentlyNonNull
    String getName();

    void getName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    Player getPlayer();

    long getValue();

    boolean isVisible();
}
