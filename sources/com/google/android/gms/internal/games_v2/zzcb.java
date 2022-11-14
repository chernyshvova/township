package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzcb implements zzaq {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzcb(String str) {
        this.zza = str;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(new zzbv(this.zza)).setMethodKey(6694).build());
    }
}
