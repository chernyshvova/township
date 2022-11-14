package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbel extends zzbeu<zzbfn> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbvh zzc;
    public final /* synthetic */ zzbet zzd;

    public zzbel(zzbet zzbet, Context context, String str, zzbvh zzbvh) {
        this.zzd = zzbet;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbvh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, "native_ad");
        return new zzbie();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        Object zzbfl;
        zzbjn.zza(this.zza);
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgG)).booleanValue()) {
            return this.zzd.zzb.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            IBinder zze = ((zzbfo) zzcgw.zza(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzbek.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 212104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbfn) {
                zzbfl = (zzbfn) queryLocalInterface;
            } else {
                zzbfl = new zzbfl(zze);
            }
            return zzbfl;
        } catch (RemoteException | zzcgv | NullPointerException e) {
            zzcau unused = this.zzd.zzh = zzcas.zza(this.zza);
            this.zzd.zzh.zzd(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzd(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 212104000);
    }
}
