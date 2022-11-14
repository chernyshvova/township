package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfm;
import com.google.android.gms.measurement.internal.zzfp;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfp {
    public zzfm zza;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @MainThread
    public final void doStartService(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfm(this);
        }
        this.zza.zza(context, intent);
    }
}
