package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaye implements BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ zzayf zza;

    public zzaye(zzayf zzayf) {
        this.zza = zzayf;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zza.zzb) {
            zzayl unused = this.zza.zze = null;
            if (this.zza.zzc != null) {
                zzayi unused2 = this.zza.zzc = null;
            }
            this.zza.zzb.notifyAll();
        }
    }
}
