package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzge extends BroadcastReceiver {
    public final /* synthetic */ zzgf zza;

    public zzge(zzgf zzgf) {
        this.zza = zzgf;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzg();
    }
}
