package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbrj implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ zzchj zza;
    public final /* synthetic */ zzbrl zzb;

    public zzbrj(zzbrl zzbrl, zzchj zzchj) {
        this.zzb = zzbrl;
        this.zza = zzchj;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException(GeneratedOutlineSupport.outline9(34, "onConnectionSuspended: ", i)));
    }
}
