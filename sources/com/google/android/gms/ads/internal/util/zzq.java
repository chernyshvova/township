package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzq extends BroadcastReceiver {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzq(zzr zzr, zzl zzl) {
        this.zza = zzr;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.zza.zze = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.zza.zze = false;
        }
    }
}
