package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzdzl implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    public final zzchj<InputStream> zza = new zzchj<>();
    public final Object zzb = new Object();
    public boolean zzc = false;
    public boolean zzd = false;
    public zzcbk zze;
    @VisibleForTesting(otherwise = 3)
    @GuardedBy("mLock")
    public zzcav zzf;

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzcgs.zzd("Disconnected from remote ad request service.");
        this.zza.zzd(new zzeaa(1));
    }

    public final void onConnectionSuspended(int i) {
        zzcgs.zzd("Cannot connect to remote service, fallback to local instance.");
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzd = true;
            if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                this.zzf.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
