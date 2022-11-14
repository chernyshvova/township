package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    public final PlayerRef zza;

    public LeaderboardScoreRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zza = new PlayerRef(dataHolder, i, (String) null);
    }

    public final boolean equals(@Nullable Object obj) {
        return LeaderboardScoreEntity.zzc(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return new LeaderboardScoreEntity(this);
    }

    @RecentlyNonNull
    public final String getDisplayRank() {
        return getString("display_rank");
    }

    @RecentlyNonNull
    public final String getDisplayScore() {
        return getString("display_score");
    }

    public final long getRank() {
        return getLong("rank");
    }

    public final long getRawScore() {
        return getLong("raw_score");
    }

    @RecentlyNonNull
    public final Player getScoreHolder() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza;
    }

    @RecentlyNonNull
    public final String getScoreHolderDisplayName() {
        if (hasNull("external_player_id")) {
            return getString("default_display_name");
        }
        return this.zza.getDisplayName();
    }

    @RecentlyNonNull
    public final Uri getScoreHolderHiResImageUri() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza.getHiResImageUri();
    }

    @RecentlyNonNull
    public String getScoreHolderHiResImageUrl() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza.getHiResImageUrl();
    }

    @RecentlyNonNull
    public final Uri getScoreHolderIconImageUri() {
        if (hasNull("external_player_id")) {
            return parseUri("default_display_image_uri");
        }
        return this.zza.getIconImageUri();
    }

    @RecentlyNonNull
    public String getScoreHolderIconImageUrl() {
        if (hasNull("external_player_id")) {
            return getString("default_display_image_url");
        }
        return this.zza.getIconImageUrl();
    }

    @RecentlyNonNull
    public final String getScoreTag() {
        return getString("score_tag");
    }

    public final long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    @RecentlyNonNull
    public final String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public final void getDisplayRank(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_rank", charArrayBuffer);
    }

    public final void getDisplayScore(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_score", charArrayBuffer);
    }

    public final void getScoreHolderDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        if (hasNull("external_player_id")) {
            copyToBuffer("default_display_name", charArrayBuffer);
        } else {
            this.zza.getDisplayName(charArrayBuffer);
        }
    }
}
