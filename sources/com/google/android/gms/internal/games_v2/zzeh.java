package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzeh implements zzaq {
    public final /* synthetic */ SnapshotMetadata zza;

    public /* synthetic */ zzeh(SnapshotMetadata snapshotMetadata) {
        this.zza = snapshotMetadata;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(new zzep(this.zza)).setMethodKey(6724).build());
    }
}
