package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzcp implements zzaq {
    public final /* synthetic */ LeaderboardScoreBuffer zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcp(LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        this.zza = leaderboardScoreBuffer;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doRead(TaskApiCall.builder().run(new zzco(this.zza, this.zzb, this.zzc)).setMethodKey(6706).build());
    }
}
