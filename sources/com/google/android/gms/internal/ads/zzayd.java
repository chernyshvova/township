package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayd implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ zzayf zza;

    public zzayd(zzayf zzayf) {
        this.zza = zzayf;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zza.zzb) {
            try {
                if (this.zza.zzc != null) {
                    zzayf zzayf = this.zza;
                    zzayl unused = zzayf.zze = zzayf.zzc.zzq();
                }
            } catch (DeadObjectException e) {
                zzcgs.zzg("Unable to obtain a cache service instance.", e);
                zzayf.zzf(this.zza);
            }
            this.zza.zzb.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzb) {
            zzayl unused = this.zza.zze = null;
            this.zza.zzb.notifyAll();
        }
    }
}
