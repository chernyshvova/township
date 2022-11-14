package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzaq extends zzag.zzb {
    public final /* synthetic */ zzag zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaq(zzag zzag) {
        super(zzag);
        this.zzc = zzag;
    }

    public final void zza() throws RemoteException {
        this.zzc.zzm.resetAnalyticsData(this.zza);
    }
}
