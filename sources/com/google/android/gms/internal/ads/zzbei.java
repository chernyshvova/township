package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbei extends zzbeu<zzbfr> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbdp zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzbet zzd;

    public zzbei(zzbet zzbet, Context context, zzbdp zzbdp, String str) {
        this.zzd = zzbet;
        this.zza = context;
        this.zzb = zzbdp;
        this.zzc = str;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, "search");
        return new zzbig();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zzd.zza.zza(this.zza, this.zzb, this.zzc, (zzbvh) null, 3);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzi(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 212104000);
    }
}
