package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzac extends zza {
    public final /* synthetic */ zzas zza;
    public final TaskCompletionSource<AnnotatedData<LeaderboardScore>> zzb;

    public zzac(zzas zzas, TaskCompletionSource<AnnotatedData<LeaderboardScore>> taskCompletionSource) {
        this.zza = zzas;
        this.zzb = taskCompletionSource;
    }

    public final void zzj(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 10003) {
            zzas.zzq(this.zza, this.zzb);
            dataHolder.close();
            return;
        } else if (statusCode == 0 || z) {
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                LeaderboardScoreEntity leaderboardScoreEntity = leaderboardScoreBuffer.getCount() > 0 ? new LeaderboardScoreEntity(leaderboardScoreBuffer.get(0)) : null;
                leaderboardScoreBuffer.close();
                this.zzb.setResult(new AnnotatedData(leaderboardScoreEntity, z));
                return;
            } catch (Throwable unused) {
            }
        } else {
            GamesStatusUtils.zza(this.zzb, statusCode);
            dataHolder.close();
            return;
        }
        throw th;
    }
}
