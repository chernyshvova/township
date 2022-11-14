package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface LeaderboardsClient {

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public static class LeaderboardScores implements Releasable {
        public final Leaderboard zza;
        public final LeaderboardScoreBuffer zzb;

        public LeaderboardScores(@Nullable Leaderboard leaderboard, @RecentlyNonNull LeaderboardScoreBuffer leaderboardScoreBuffer) {
            this.zza = leaderboard;
            this.zzb = leaderboardScoreBuffer;
        }

        @RecentlyNullable
        public Leaderboard getLeaderboard() {
            return this.zza;
        }

        @NonNull
        public LeaderboardScoreBuffer getScores() {
            return this.zzb;
        }

        public void release() {
            this.zzb.release();
        }
    }

    @RecentlyNonNull
    Task<Intent> getAllLeaderboardsIntent();

    @RecentlyNonNull
    Task<Intent> getLeaderboardIntent(@RecentlyNonNull String str);

    @RecentlyNonNull
    Task<Intent> getLeaderboardIntent(@RecentlyNonNull String str, int i);

    @RecentlyNonNull
    Task<Intent> getLeaderboardIntent(@RecentlyNonNull String str, int i, int i2);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(@RecentlyNonNull String str, int i, int i2);

    @RecentlyNonNull
    Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(@RecentlyNonNull String str, boolean z);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardScores>> loadMoreScores(@RecentlyNonNull LeaderboardScoreBuffer leaderboardScoreBuffer, @IntRange(from = 1, mo281to = 25) int i, int i2);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(@RecentlyNonNull String str, int i, int i2, @IntRange(from = 1, mo281to = 25) int i3);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(@RecentlyNonNull String str, int i, int i2, @IntRange(from = 1, mo281to = 25) int i3, boolean z);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardScores>> loadTopScores(@RecentlyNonNull String str, int i, int i2, @IntRange(from = 1, mo281to = 25) int i3);

    @RecentlyNonNull
    Task<AnnotatedData<LeaderboardScores>> loadTopScores(@RecentlyNonNull String str, int i, int i2, @IntRange(from = 1, mo281to = 25) int i3, boolean z);

    void submitScore(@RecentlyNonNull String str, long j);

    void submitScore(@RecentlyNonNull String str, long j, @RecentlyNonNull String str2);

    @RecentlyNonNull
    Task<ScoreSubmissionData> submitScoreImmediate(@RecentlyNonNull String str, long j);

    @RecentlyNonNull
    Task<ScoreSubmissionData> submitScoreImmediate(@RecentlyNonNull String str, long j, @RecentlyNonNull String str2);
}
