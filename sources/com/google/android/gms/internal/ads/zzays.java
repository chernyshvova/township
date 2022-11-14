package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzays implements BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ zzchj zza;
    public final /* synthetic */ zzayt zzb;

    public zzays(zzayt zzayt, zzchj zzchj) {
        this.zzb = zzayt;
        this.zza = zzchj;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
