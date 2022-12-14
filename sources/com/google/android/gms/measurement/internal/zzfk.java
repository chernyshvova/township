package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfk implements ServiceConnection {
    public final /* synthetic */ zzfl zza;
    public final String zzb;

    public zzfk(zzfl zzfl, String str) {
        this.zza = zzfl;
        this.zzb = str;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzq().zzh().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzd zza2 = zzg.zza(iBinder);
            if (zza2 == null) {
                this.zza.zza.zzq().zzh().zza("Install Referrer Service implementation was not found");
                return;
            }
            this.zza.zza.zzq().zzw().zza("Install Referrer Service connected");
            this.zza.zza.zzp().zza((Runnable) new zzfn(this, zza2, this));
        } catch (Exception e) {
            this.zza.zza.zzq().zzh().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzq().zzw().zza("Install Referrer Service disconnected");
    }
}
