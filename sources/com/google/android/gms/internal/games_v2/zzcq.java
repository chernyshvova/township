package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzcq implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcq(String str, int i, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doRead(TaskApiCall.builder().run(new zzcz(this.zza, this.zzb, this.zzc)).setMethodKey(6701).build());
    }
}
