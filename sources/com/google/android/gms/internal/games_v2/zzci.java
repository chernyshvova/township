package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzci implements zzaq {
    public final /* synthetic */ boolean zza;

    public /* synthetic */ zzci(boolean z) {
        this.zza = z;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doRead(TaskApiCall.builder().run(new zzcf(this.zza)).setMethodKey(6727).build());
    }
}
