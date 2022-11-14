package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface PlayersClient {
    @RecentlyNonNull
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    @RecentlyNonNull
    Task<Intent> getCompareProfileIntent(@RecentlyNonNull Player player);

    @RecentlyNonNull
    Task<Intent> getCompareProfileIntent(@RecentlyNonNull String str);

    @RecentlyNonNull
    Task<Intent> getCompareProfileIntentWithAlternativeNameHints(@RecentlyNonNull String str, @Nullable String str2, @Nullable String str3);

    @RecentlyNonNull
    Task<Player> getCurrentPlayer();

    @RecentlyNonNull
    Task<AnnotatedData<Player>> getCurrentPlayer(boolean z);

    @RecentlyNonNull
    Task<String> getCurrentPlayerId();

    @RecentlyNonNull
    Task<Intent> getPlayerSearchIntent();

    @RecentlyNonNull
    Task<AnnotatedData<PlayerBuffer>> loadFriends(@IntRange(from = 1, mo281to = 200) int i, boolean z);

    @RecentlyNonNull
    Task<AnnotatedData<PlayerBuffer>> loadMoreFriends(@IntRange(from = 1, mo281to = 200) int i);

    @RecentlyNonNull
    @Deprecated
    Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(@IntRange(from = 1, mo281to = 25) int i);

    @RecentlyNonNull
    Task<AnnotatedData<Player>> loadPlayer(@RecentlyNonNull String str);

    @RecentlyNonNull
    Task<AnnotatedData<Player>> loadPlayer(@RecentlyNonNull String str, boolean z);

    @RecentlyNonNull
    @Deprecated
    Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(@IntRange(from = 1, mo281to = 25) int i, boolean z);
}
