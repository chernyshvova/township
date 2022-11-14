package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzaj extends zza {
    public final TaskCompletionSource<AnnotatedData<SnapshotMetadataBuffer>> zza;

    public zzaj(TaskCompletionSource<AnnotatedData<SnapshotMetadataBuffer>> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzt(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zza.setResult(new AnnotatedData(new SnapshotMetadataBuffer(dataHolder), z));
            return;
        }
        GamesStatusUtils.zza(this.zza, statusCode);
        dataHolder.close();
    }
}
