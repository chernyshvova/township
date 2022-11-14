package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzdb implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ boolean zze;

    public /* synthetic */ zzdb(String str, int i, int i2, int i3, boolean z) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzJ((TaskCompletionSource) obj2, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
