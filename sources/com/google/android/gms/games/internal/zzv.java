package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzv extends zza {
    public final TaskCompletionSource<AnnotatedData<AchievementBuffer>> zza;

    public zzv(TaskCompletionSource<AnnotatedData<AchievementBuffer>> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzc(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 0 || statusCode == 3) {
            this.zza.setResult(new AnnotatedData(new AchievementBuffer(dataHolder), statusCode == 3));
            return;
        }
        GamesStatusUtils.zza(this.zza, statusCode);
        dataHolder.close();
    }
}
