package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfex extends BroadcastReceiver {
    public final /* synthetic */ zzfey zza;

    public zzfex(zzfey zzfey) {
        this.zza = zzfey;
    }

    public final void onReceive(Context context, Intent intent) {
        KeyguardManager keyguardManager;
        if (intent != null) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzfey.zzf(this.zza, true);
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzfey.zzf(this.zza, false);
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                zzfey.zzf(this.zza, false);
            }
        }
    }
}
