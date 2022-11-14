package com.google.android.gms.internal.games_v2;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzbi implements OnCompleteListener {
    public final /* synthetic */ zzbj zza;

    public /* synthetic */ zzbi(zzbj zzbj) {
        this.zza = zzbj;
    }

    public final void onComplete(Task task) {
        this.zza.zzb(task);
    }
}
