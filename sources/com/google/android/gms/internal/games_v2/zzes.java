package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.internal.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzes implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzes(String str, boolean z, boolean z2, int i) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i;
    }

    public final void accept(Object obj, Object obj2) {
        ((TaskCompletionSource) obj2).setResult(((zzay) ((zzas) obj).getService()).zzm(this.zza, this.zzb, this.zzc, this.zzd));
    }
}
