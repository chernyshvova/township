package com.google.android.gms.games.internal.p034v2.resolution;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.google.android.gms.internal.games_v2.zzfn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.games.internal.v2.resolution.zza */
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zza extends ResultReceiver {
    public final TaskCompletionSource<zzc> zza = new TaskCompletionSource<>();

    public zza() {
        super(new zzfn(Looper.getMainLooper()));
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        Intent intent;
        zzc zzc;
        super.onReceiveResult(i, bundle);
        Boolean valueOf = Boolean.valueOf(i == -1);
        if (bundle == null) {
            intent = new Intent();
        } else {
            intent = (Intent) bundle.getParcelable("resultData");
            if (intent == null) {
                intent = new Intent();
            }
        }
        if (valueOf.booleanValue()) {
            zzc = zzc.zzc(intent);
        } else {
            zzc = zzc.zzb(intent);
        }
        this.zza.trySetResult(zzc);
    }

    public final Task<zzc> zza() {
        return this.zza.getTask();
    }
}
