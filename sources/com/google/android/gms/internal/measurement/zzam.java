package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzam extends zzag.zzb {
    public final /* synthetic */ Activity zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ zzag zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzam(zzag zzag, Activity activity, String str, String str2) {
        super(zzag);
        this.zzf = zzag;
        this.zzc = activity;
        this.zzd = str;
        this.zze = str2;
    }

    public final void zza() throws RemoteException {
        this.zzf.zzm.setCurrentScreen(ObjectWrapper.wrap(this.zzc), this.zzd, this.zze, this.zza);
    }
}
