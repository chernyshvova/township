package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbeb extends zzbeu<zzcfo> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbvh zzb;

    public zzbeb(zzbet zzbet, Context context, zzbvh zzbvh) {
        this.zza = context;
        this.zzb = zzbvh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        try {
            return ((zzcfr) zzcgw.zza(this.zza, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzbea.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 212104000);
        } catch (RemoteException | zzcgv | NullPointerException unused) {
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzm(ObjectWrapper.wrap(this.zza), this.zzb, 212104000);
    }
}
