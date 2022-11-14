package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzdi implements LeaderboardsClient {
    public final zzar zza;

    public zzdi(zzar zzar) {
        this.zza = zzar;
    }

    public final Task<Intent> getAllLeaderboardsIntent() {
        return this.zza.zzb(zzcy.zza);
    }

    public final Task<Intent> getLeaderboardIntent(@NonNull String str) {
        return getLeaderboardIntent(str, -1, -1);
    }

    public final Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(@NonNull String str, int i, int i2) {
        return this.zza.zzb(new zzcr(str, i, i2));
    }

    public final Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(@NonNull String str, boolean z) {
        return this.zza.zzb(new zzcw(str, z));
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadMoreScores(@NonNull LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return this.zza.zzb(new zzcp(leaderboardScoreBuffer, i, i2));
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(@NonNull String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzcs(str, i, i2, i3, false));
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(@NonNull String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzct(str, i, i2, i3, false));
    }

    public final void submitScore(@NonNull String str, long j) {
        this.zza.zzb(new zzcu(str, j));
    }

    public final Task<ScoreSubmissionData> submitScoreImmediate(@NonNull String str, long j) {
        return this.zza.zzb(new zzcu(str, j));
    }

    public final Task<Intent> getLeaderboardIntent(@NonNull String str, int i) {
        return getLeaderboardIntent(str, i, -1);
    }

    public final Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z) {
        return this.zza.zzb(new zzcx(z));
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(@NonNull String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzcs(str, i, i2, i3, z));
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(@NonNull String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzct(str, i, i2, i3, z));
    }

    public final void submitScore(@NonNull String str, long j, @NonNull String str2) {
        this.zza.zzb(new zzcv(str, j, str2));
    }

    public final Task<ScoreSubmissionData> submitScoreImmediate(@NonNull String str, long j, @NonNull String str2) {
        return this.zza.zzb(new zzcv(str, j, str2));
    }

    public final Task<Intent> getLeaderboardIntent(@NonNull String str, int i, int i2) {
        return this.zza.zzb(new zzcq(str, i, i2));
    }
}
