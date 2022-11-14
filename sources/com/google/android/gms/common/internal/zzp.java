package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzp implements Handler.Callback {
    public final /* synthetic */ zzq zza;

    public /* synthetic */ zzp(zzq zzq, zzn zzn) {
        this.zza = zzq;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zza.zza) {
                zzm zzm = (zzm) message.obj;
                zzo zzo = (zzo) this.zza.zza.get(zzm);
                if (zzo != null && zzo.zzh()) {
                    if (zzo.zze()) {
                        zzo.zzb("GmsClientSupervisor");
                    }
                    this.zza.zza.remove(zzm);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zza.zza) {
                zzm zzm2 = (zzm) message.obj;
                zzo zzo2 = (zzo) this.zza.zza.get(zzm2);
                if (zzo2 != null && zzo2.zzf() == 3) {
                    String valueOf = String.valueOf(zzm2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName zzj = zzo2.zzj();
                    if (zzj == null) {
                        zzj = zzm2.zzb();
                    }
                    if (zzj == null) {
                        String zza2 = zzm2.zza();
                        Preconditions.checkNotNull(zza2);
                        zzj = new ComponentName(zza2, "unknown");
                    }
                    zzo2.onServiceDisconnected(zzj);
                }
            }
            return true;
        }
    }
}
