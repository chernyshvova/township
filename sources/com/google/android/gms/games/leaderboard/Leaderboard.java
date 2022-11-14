package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface Leaderboard extends Freezable<Leaderboard> {
    public static final int SCORE_ORDER_LARGER_IS_BETTER = 1;
    public static final int SCORE_ORDER_SMALLER_IS_BETTER = 0;

    @RecentlyNonNull
    String getDisplayName();

    void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    Uri getIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    @RecentlyNonNull
    String getLeaderboardId();

    int getScoreOrder();

    @RecentlyNonNull
    ArrayList<LeaderboardVariant> getVariants();

    @RecentlyNonNull
    Game zza();
}
