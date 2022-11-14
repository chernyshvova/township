package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzam extends zza {
    public final TaskCompletionSource<AnnotatedData<PlayerStats>> zza;

    public zzam(TaskCompletionSource<AnnotatedData<PlayerStats>> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzk(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 0 || statusCode == 3) {
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                boolean z = false;
                PlayerStatsEntity playerStatsEntity = playerStatsBuffer.getCount() > 0 ? new PlayerStatsEntity(playerStatsBuffer.get(0)) : null;
                playerStatsBuffer.close();
                if (statusCode == 3) {
                    z = true;
                }
                this.zza.setResult(new AnnotatedData(playerStatsEntity, z));
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
