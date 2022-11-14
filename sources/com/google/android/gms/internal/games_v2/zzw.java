package com.google.android.gms.internal.games_v2;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzw extends GoogleApi<zzq> implements zzs {
    public static final Api.ClientKey<zzx> zza = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<zzx, zzq> zzb;
    public static final Api<zzq> zzc;

    static {
        zzu zzu = new zzu();
        zzb = zzu;
        zzc = new Api<>("GamesConnect.API", zzu, zza);
    }

    public zzw(Context context, zzq zzq) {
        super(context, zzc, zzq, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<zzaa> zza(zzy zzy, boolean z) {
        TaskApiCall build = TaskApiCall.builder().run(new zzt(this, zzy)).setMethodKey(6737).setAutoResolveMissingFeatures(z).build();
        if (z) {
            return doWrite(build);
        }
        return doBestEffortWrite(build);
    }
}
