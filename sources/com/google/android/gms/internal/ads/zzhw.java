package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhw extends BroadcastReceiver implements Runnable {
    public final /* synthetic */ zzhy zza;
    public final zzhx zzb;
    public final Handler zzc;

    public zzhw(zzhy zzhy, Handler handler, zzhx zzhx) {
        this.zza = zzhy;
        this.zzc = handler;
        this.zzb = zzhx;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    public final void run() {
    }
}
