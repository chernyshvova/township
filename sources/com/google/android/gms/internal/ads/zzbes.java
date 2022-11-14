package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbes extends zzbeu<zzcct> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbvh zzc;
    public final /* synthetic */ zzbet zzd;

    public zzbes(zzbet zzbet, Context context, String str, zzbvh zzbvh) {
        this.zzd = zzbet;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbvh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, "rewarded");
        return new zzbim();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return zzcdf.zza(this.zza, this.zzb, this.zzc);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzk(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 212104000);
    }
}
