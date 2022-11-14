package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzbr implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbr(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(new zzbx(this.zza, this.zzb)).setMethodKey(6696).build());
    }
}
