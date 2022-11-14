package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbd extends zzag.zzb {
    public final /* synthetic */ int zzc = 5;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ Object zzf;
    public final /* synthetic */ Object zzg;
    public final /* synthetic */ zzag zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbd(zzag zzag, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.zzh = zzag;
        this.zzd = str;
        this.zze = obj;
        this.zzf = null;
        this.zzg = null;
    }

    public final void zza() throws RemoteException {
        this.zzh.zzm.logHealthData(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
