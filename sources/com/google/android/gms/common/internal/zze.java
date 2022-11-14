package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zze implements ServiceConnection {
    public final /* synthetic */ BaseGmsClient zza;
    public final int zzb;

    public zze(BaseGmsClient baseGmsClient, int i) {
        this.zza = baseGmsClient;
        this.zzb = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGmsServiceBroker iGmsServiceBroker;
        if (iBinder == null) {
            BaseGmsClient.zzc(this.zza, 16);
            return;
        }
        synchronized (this.zza.zzq) {
            BaseGmsClient baseGmsClient = this.zza;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                iGmsServiceBroker = new zzab(iBinder);
            } else {
                iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
            }
            IGmsServiceBroker unused = baseGmsClient.zzr = iGmsServiceBroker;
        }
        this.zza.zzb(0, (Bundle) null, this.zzb);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzq) {
            IGmsServiceBroker unused = this.zza.zzr = null;
        }
        Handler handler = this.zza.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzb, 1));
    }
}
