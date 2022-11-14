package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzej implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzej(String str, boolean z, int i) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(new zzer(this.zza, this.zzb, this.zzc)).setMethodKey(6721).build());
    }
}
