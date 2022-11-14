package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.games.zzm;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzbj<T> {
    public final TaskCompletionSource<T> zza;
    public final zzap zzb;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.games_v2.zzap, com.google.android.gms.tasks.TaskCompletionSource<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbj(com.google.android.gms.internal.games_v2.zzap r1, com.google.android.gms.internal.games_v2.zzap r2, com.google.android.gms.tasks.TaskCompletionSource<T> r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzb = r1
            r0.zza = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.games_v2.zzbj.<init>(com.google.android.gms.internal.games_v2.zzap, com.google.android.gms.tasks.TaskCompletionSource, byte[]):void");
    }

    public final void zza(GoogleApi<zzm> googleApi) {
        this.zzb.zza(googleApi).addOnCompleteListener(zzfr.zza(), new zzbi(this));
    }

    public final /* synthetic */ void zzb(Task task) {
        if (task.isSuccessful()) {
            this.zza.setResult(task.getResult());
            return;
        }
        TaskCompletionSource<T> taskCompletionSource = this.zza;
        Exception exception = task.getException();
        zzfo.zza(exception);
        taskCompletionSource.setException(exception);
    }

    public final void zzc(Exception exc) {
        this.zza.setException(exc);
    }
}
