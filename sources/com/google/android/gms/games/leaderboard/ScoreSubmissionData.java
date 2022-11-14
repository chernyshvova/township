package com.google.android.gms.games.leaderboard;

import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games_v2.zzah;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class ScoreSubmissionData {
    public static final String[] zza = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    public String zzb;
    public String zzc;
    public int zzd;
    public SparseArray<Result> zze = new SparseArray<>();

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public static final class Result {
        @RecentlyNonNull
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        @RecentlyNonNull
        public final String scoreTag;

        public Result(long j, @RecentlyNonNull String str, @RecentlyNonNull String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        @RecentlyNonNull
        public String toString() {
            return Objects.toStringHelper(this).add("RawScore", Long.valueOf(this.rawScore)).add("FormattedScore", this.formattedScore).add("ScoreTag", this.scoreTag).add("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(@RecentlyNonNull DataHolder dataHolder) {
        this.zzd = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        Preconditions.checkArgument(count == 3);
        int i = 0;
        while (i < count) {
            int windowIndex = dataHolder.getWindowIndex(i);
            if (i == 0) {
                this.zzb = dataHolder.getString("leaderboardId", 0, windowIndex);
                this.zzc = dataHolder.getString("playerId", 0, windowIndex);
                i = 0;
            }
            if (dataHolder.getBoolean("hasResult", i, windowIndex)) {
                this.zze.put(dataHolder.getInteger("timeSpan", i, windowIndex), new Result(dataHolder.getLong("rawScore", i, windowIndex), dataHolder.getString("formattedScore", i, windowIndex), dataHolder.getString("scoreTag", i, windowIndex), dataHolder.getBoolean("newBest", i, windowIndex)));
            }
            i++;
        }
    }

    @RecentlyNonNull
    public String getLeaderboardId() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getPlayerId() {
        return this.zzc;
    }

    @RecentlyNonNull
    public Result getScoreResult(int i) {
        return this.zze.get(i);
    }

    @RecentlyNonNull
    public String toString() {
        String str;
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("PlayerId", this.zzc).add("StatusCode", Integer.valueOf(this.zzd));
        for (int i = 0; i < 3; i++) {
            Result result = this.zze.get(i);
            add.add("TimesSpan", zzah.zza(i));
            if (result == null) {
                str = "null";
            } else {
                str = result.toString();
            }
            add.add("Result", str);
        }
        return add.toString();
    }
}
