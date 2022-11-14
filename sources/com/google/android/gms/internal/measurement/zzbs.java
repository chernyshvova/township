package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbs extends zzag.zzb {
    public final /* synthetic */ Activity zzc;
    public final /* synthetic */ zzt zzd;
    public final /* synthetic */ zzag.zzc zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbs(zzag.zzc zzc2, Activity activity, zzt zzt) {
        super(zzag.this);
        this.zze = zzc2;
        this.zzc = activity;
        this.zzd = zzt;
    }

    public final void zza() throws RemoteException {
        zzag.this.zzm.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
