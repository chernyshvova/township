package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzax extends zzag.zzb {
    public final /* synthetic */ zzt zzc;
    public final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzax(zzag zzag, zzt zzt) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzt;
    }

    public final void zza() throws RemoteException {
        this.zzd.zzm.getGmpAppId(this.zzc);
    }

    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
