package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzene implements zzeqp<zzenf> {
    public final zzfqo zza;
    public final Context zzb;

    public zzene(zzfqo zzfqo, Context context) {
        this.zza = zzfqo;
        this.zzb = context;
    }

    public final zzfqn<zzenf> zza() {
        return this.zza.zzb(new zzend(this));
    }

    public final /* synthetic */ zzenf zzb() throws Exception {
        double d;
        Intent registerReceiver = this.zzb.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = (double) registerReceiver.getIntExtra("level", -1);
            double intExtra3 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzenf(d, z);
    }
}
