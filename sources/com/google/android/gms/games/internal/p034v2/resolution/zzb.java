package com.google.android.gms.games.internal.p034v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.games.internal.v2.resolution.zzb */
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzb {
    public static zzb zza() {
        return new zzb();
    }

    public static final Task<zzc> zzb(Activity activity, PendingIntent pendingIntent) {
        zza zza = new zza();
        Intent intent = new Intent(activity, GamesResolutionActivity.class);
        intent.putExtra(BaseGmsClient.KEY_PENDING_INTENT, pendingIntent);
        intent.putExtra("resultReceiver", zza);
        activity.startActivity(intent);
        return zza.zza();
    }
}
