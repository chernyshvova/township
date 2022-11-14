package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzan extends zza {
    public final /* synthetic */ zzas zza;
    public final TaskCompletionSource<AnnotatedData<PlayerBuffer>> zzb;

    public zzan(zzas zzas, TaskCompletionSource<AnnotatedData<PlayerBuffer>> taskCompletionSource) {
        this.zza = zzas;
        this.zzb = taskCompletionSource;
    }

    public final void zzg(DataHolder dataHolder) {
        zzl(dataHolder);
    }

    public final void zzl(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 10003) {
            zzas.zzq(this.zza, this.zzb);
            dataHolder.close();
            return;
        }
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zzb.setResult(new AnnotatedData(new PlayerBuffer(dataHolder), z));
            return;
        }
        GamesStatusUtils.zza(this.zzb, statusCode);
        dataHolder.close();
    }
}
