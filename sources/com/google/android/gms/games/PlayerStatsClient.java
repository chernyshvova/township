package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface PlayerStatsClient {
    @RecentlyNonNull
    Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z);
}
