package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzew implements zzaq {
    public final /* synthetic */ Snapshot zza;

    public /* synthetic */ zzew(Snapshot snapshot) {
        this.zza = snapshot;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(new zzef(this.zza)).setMethodKey(6723).build());
    }
}
