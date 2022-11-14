package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayr implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    public final /* synthetic */ zzayj zza;
    public final /* synthetic */ zzchj zzb;
    public final /* synthetic */ zzayt zzc;

    public zzayr(zzayt zzayt, zzayj zzayj, zzchj zzchj) {
        this.zzc = zzayt;
        this.zza = zzayj;
        this.zzb = zzchj;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzc.zzd) {
            if (!this.zzc.zzb) {
                boolean unused = this.zzc.zzb = true;
                zzayi zzf = this.zzc.zza;
                if (zzf != null) {
                    zzfqn<?> zza2 = zzche.zza.zza(new zzayo(this, zzf, this.zza, this.zzb));
                    zzchj zzchj = this.zzb;
                    zzchj.zze(new zzayp(zzchj, zza2), zzche.zzf);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
