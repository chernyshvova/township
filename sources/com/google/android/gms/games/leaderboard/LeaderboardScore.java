package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Player;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface LeaderboardScore extends Freezable<LeaderboardScore> {
    public static final int LEADERBOARD_RANK_UNKNOWN = -1;

    @RecentlyNonNull
    String getDisplayRank();

    void getDisplayRank(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    String getDisplayScore();

    void getDisplayScore(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    long getRank();

    long getRawScore();

    @RecentlyNullable
    Player getScoreHolder();

    @RecentlyNonNull
    String getScoreHolderDisplayName();

    void getScoreHolderDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    Uri getScoreHolderHiResImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getScoreHolderHiResImageUrl();

    @RecentlyNonNull
    Uri getScoreHolderIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getScoreHolderIconImageUrl();

    @RecentlyNonNull
    String getScoreTag();

    long getTimestampMillis();
}
