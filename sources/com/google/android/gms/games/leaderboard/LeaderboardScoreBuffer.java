package com.google.android.gms.games.leaderboard;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    public final zza zza;

    public LeaderboardScoreBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
        this.zza = new zza(dataHolder.getMetadata());
    }

    @RecentlyNonNull
    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.mDataHolder, i);
    }

    public final zza zza() {
        return this.zza;
    }
}
