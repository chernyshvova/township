package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class LeaderboardScoreEntity implements LeaderboardScore {
    public final long zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final long zze;
    public final String zzf;
    public final Uri zzg;
    public final Uri zzh;
    public final PlayerEntity zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;

    public LeaderboardScoreEntity(@RecentlyNonNull LeaderboardScore leaderboardScore) {
        PlayerEntity playerEntity;
        this.zza = leaderboardScore.getRank();
        this.zzb = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayRank());
        this.zzc = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayScore());
        this.zzd = leaderboardScore.getRawScore();
        this.zze = leaderboardScore.getTimestampMillis();
        this.zzf = leaderboardScore.getScoreHolderDisplayName();
        this.zzg = leaderboardScore.getScoreHolderIconImageUri();
        this.zzh = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        if (scoreHolder == null) {
            playerEntity = null;
        } else {
            playerEntity = new PlayerEntity(scoreHolder);
        }
        this.zzi = playerEntity;
        this.zzj = leaderboardScore.getScoreTag();
        this.zzk = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzl = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    public static int zza(LeaderboardScore leaderboardScore) {
        return Objects.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    public static String zzb(LeaderboardScore leaderboardScore) {
        return Objects.toStringHelper(leaderboardScore).add("Rank", Long.valueOf(leaderboardScore.getRank())).add("DisplayRank", leaderboardScore.getDisplayRank()).add("Score", Long.valueOf(leaderboardScore.getRawScore())).add("DisplayScore", leaderboardScore.getDisplayScore()).add("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).add("DisplayName", leaderboardScore.getScoreHolderDisplayName()).add("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).add("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).add("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).add("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).add("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).add("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public static boolean zzc(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return Objects.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && Objects.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && Objects.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && Objects.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && Objects.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && Objects.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && Objects.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && Objects.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && Objects.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && Objects.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzc(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @RecentlyNonNull
    public final String getDisplayRank() {
        return this.zzb;
    }

    public final void getDisplayRank(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @RecentlyNonNull
    public final String getDisplayScore() {
        return this.zzc;
    }

    public final void getDisplayScore(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    public final long getRank() {
        return this.zza;
    }

    public final long getRawScore() {
        return this.zzd;
    }

    @RecentlyNonNull
    public final Player getScoreHolder() {
        return this.zzi;
    }

    @RecentlyNonNull
    public final String getScoreHolderDisplayName() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzf : playerEntity.getDisplayName();
    }

    public final void getScoreHolderDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzi;
        if (playerEntity == null) {
            DataUtils.copyStringToBuffer(this.zzf, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    @RecentlyNonNull
    public final Uri getScoreHolderHiResImageUri() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzh : playerEntity.getHiResImageUri();
    }

    @RecentlyNonNull
    public String getScoreHolderHiResImageUrl() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzl : playerEntity.getHiResImageUrl();
    }

    @RecentlyNonNull
    public final Uri getScoreHolderIconImageUri() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzg : playerEntity.getIconImageUri();
    }

    @RecentlyNonNull
    public String getScoreHolderIconImageUrl() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzk : playerEntity.getIconImageUrl();
    }

    @RecentlyNonNull
    public final String getScoreTag() {
        return this.zzj;
    }

    public final long getTimestampMillis() {
        return this.zze;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return zzb(this);
    }
}
