package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzw extends zza {
    public final TaskCompletionSource<SnapshotMetadata> zza;

    public zzw(TaskCompletionSource<SnapshotMetadata> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzp(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode != 0) {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
            return;
        }
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            SnapshotMetadataEntity snapshotMetadataEntity = snapshotMetadataBuffer.getCount() > 0 ? new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)) : null;
            snapshotMetadataBuffer.close();
            this.zza.setResult(snapshotMetadataEntity);
            return;
        } catch (Throwable unused) {
        }
        throw th;
    }
}
