package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzab extends zza {
    public final TaskCompletionSource<AnnotatedData<Leaderboard>> zza;

    public zzab(TaskCompletionSource<AnnotatedData<Leaderboard>> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzi(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                Object freeze = leaderboardBuffer.getCount() > 0 ? ((Leaderboard) leaderboardBuffer.get(0)).freeze() : null;
                leaderboardBuffer.close();
                this.zza.setResult(new AnnotatedData(freeze, z));
                return;
            } catch (Throwable unused) {
            }
        } else {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
            return;
        }
        throw th;
    }
}
