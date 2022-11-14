package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzaq extends zza {
    public final TaskCompletionSource<ScoreSubmissionData> zza;

    public zzaq(TaskCompletionSource<ScoreSubmissionData> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzm(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 0 || statusCode == 5) {
            try {
                this.zza.setResult(new ScoreSubmissionData(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
        }
    }
}
