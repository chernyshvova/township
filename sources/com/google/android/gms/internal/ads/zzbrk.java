package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbrk implements BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ zzchj zza;

    public zzbrk(zzbrl zzbrl, zzchj zzchj) {
        this.zza = zzchj;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zza.zzd(new RuntimeException("Connection failed."));
    }
}
