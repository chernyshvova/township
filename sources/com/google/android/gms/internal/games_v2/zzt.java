package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzt implements RemoteCall {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ zzy zzb;

    public /* synthetic */ zzt(zzw zzw, zzy zzy) {
        this.zza = zzw;
        this.zzb = zzy;
    }

    public final void accept(Object obj, Object obj2) {
        zzw zzw = this.zza;
        ((zzae) ((zzx) obj).getService()).zzd(new zzv(zzw, (TaskCompletionSource) obj2), this.zzb);
    }
}
