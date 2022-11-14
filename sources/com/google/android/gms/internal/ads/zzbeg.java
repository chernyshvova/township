package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbeg extends zzbeu<zzbfr> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbdp zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzbvh zzd;
    public final /* synthetic */ zzbet zze;

    public zzbeg(zzbet zzbet, Context context, zzbdp zzbdp, String str, zzbvh zzbvh) {
        this.zze = zzbet;
        this.zza = context;
        this.zzb = zzbdp;
        this.zzc = str;
        this.zzd = zzbvh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, "banner");
        return new zzbig();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 1);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 212104000);
    }
}
