package com.google.android.gms.games.leaderboard;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class LeaderboardBuffer extends EntityBuffer<Leaderboard> {
    public LeaderboardBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object getEntry(int i, int i2) {
        return new LeaderboardRef(this.mDataHolder, i, i2);
    }

    @RecentlyNonNull
    public final String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
