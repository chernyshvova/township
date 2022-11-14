package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.games.internal.zzat;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzbo implements zzbl {
    public final Application zza;
    public final zzg zzb;
    public final zzaw zzc;

    public zzbo(Application application, zzg zzg, zzaw zzaw, byte[] bArr) {
        this.zza = application;
        this.zzb = zzg;
        this.zzc = zzaw;
    }

    private final zzs zzc() {
        Activity zza2 = this.zzb.zza();
        if (zza2 != null) {
            return zzr.zza(zza2, this.zzc.zzb);
        }
        zzaw zzaw = this.zzc;
        return zzr.zza(zzaw.zza, zzaw.zzb);
    }

    public final Task<zzbp> zza(zzy zzy) {
        boolean z = false;
        if (zzy.zza() == 0 && !InstantApps.isInstantApp(this.zza)) {
            z = true;
        }
        Task<zzaa> zza2 = zzc().zza(zzy, z);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zza2.continueWithTask(zzfr.zza(), new zzbm(this, zzy, z)).addOnCompleteListener(zzfr.zza(), new zzbn(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final /* synthetic */ Task zzb(zzy zzy, boolean z, Task task) throws Exception {
        if (task.isSuccessful()) {
            return task;
        }
        Exception exception = task.getException();
        if (!(exception instanceof ApiException) || ((ApiException) exception).getStatusCode() != 20) {
            return task;
        }
        zzat.zza("GamesAuthenticator", "Service connection suspended during the first sign-in attempt. Trying again.");
        return zzc().zza(zzy, z);
    }
}
