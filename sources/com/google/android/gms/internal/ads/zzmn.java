package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmn extends BroadcastReceiver {
    public final /* synthetic */ zzmo zza;

    public /* synthetic */ zzmn(zzmo zzmo, zzmk zzmk) {
        this.zza = zzmo;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzb.post(new zzmm(this.zza));
    }
}
