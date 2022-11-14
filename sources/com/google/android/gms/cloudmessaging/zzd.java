package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzd implements Runnable {
    public final CloudMessagingReceiver zza;
    public final Intent zzb;
    public final Context zzc;
    public final boolean zzd;
    public final BroadcastReceiver.PendingResult zze;

    public zzd(CloudMessagingReceiver cloudMessagingReceiver, Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.zza = cloudMessagingReceiver;
        this.zzb = intent;
        this.zzc = context;
        this.zzd = z;
        this.zze = pendingResult;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
