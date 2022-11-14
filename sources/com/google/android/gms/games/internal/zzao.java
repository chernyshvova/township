package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzao extends zza {
    public final TaskCompletionSource<AnnotatedData<Player>> zza;

    public zzao(TaskCompletionSource<AnnotatedData<Player>> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzl(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 0 || statusCode == 3) {
            PlayerBuffer playerBuffer = new PlayerBuffer(dataHolder);
            try {
                boolean z = false;
                PlayerEntity playerEntity = playerBuffer.getCount() > 0 ? new PlayerEntity(playerBuffer.get(0)) : null;
                if (statusCode == 3) {
                    z = true;
                }
                this.zza.setResult(new AnnotatedData(playerEntity, z));
            } finally {
                playerBuffer.release();
            }
        } else {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
        }
    }
}
