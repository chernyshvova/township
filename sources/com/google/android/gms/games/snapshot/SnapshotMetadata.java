package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface SnapshotMetadata extends Freezable<SnapshotMetadata>, Parcelable {
    public static final long PLAYED_TIME_UNKNOWN = -1;
    public static final long PROGRESS_VALUE_UNKNOWN = -1;

    float getCoverImageAspectRatio();

    @RecentlyNullable
    Uri getCoverImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getCoverImageUrl();

    @RecentlyNonNull
    String getDescription();

    void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNullable
    String getDeviceName();

    @RecentlyNonNull
    Game getGame();

    long getLastModifiedTimestamp();

    @RecentlyNonNull
    Player getOwner();

    long getPlayedTime();

    long getProgressValue();

    @RecentlyNonNull
    String getSnapshotId();

    @RecentlyNonNull
    String getUniqueName();

    boolean hasChangePending();

    @RecentlyNonNull
    String zza();
}
