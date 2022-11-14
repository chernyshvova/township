package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zzbm extends zzag.zzb {
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbm(zzag zzag, String str, String str2, Object obj, boolean z) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = obj;
        this.zzf = z;
    }

    public final void zza() throws RemoteException {
        this.zzg.zzm.setUserProperty(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), this.zzf, this.zza);
    }
}
