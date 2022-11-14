package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcg extends BroadcastReceiver {
    public final /* synthetic */ zzch zza;

    public zzcg(zzch zzch) {
        this.zza = zzch;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zze(context, intent);
    }
}
