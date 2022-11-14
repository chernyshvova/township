package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzer implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzer(String str, boolean z, int i) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzO((TaskCompletionSource) obj2, this.zza, this.zzb, this.zzc);
    }
}
