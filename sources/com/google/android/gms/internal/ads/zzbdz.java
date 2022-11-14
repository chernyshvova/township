package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdz extends zzbeu<zzbzr> {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzbet zzb;

    public zzbdz(zzbet zzbet, Activity activity) {
        this.zzb = zzbet;
        this.zza = activity;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        zzbjn.zza(this.zza);
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgG)).booleanValue()) {
            return this.zzb.zzf.zza(this.zza);
        }
        try {
            return zzbzq.zzF(((zzbzu) zzcgw.zza(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzbdy.zza)).zze(ObjectWrapper.wrap(this.zza)));
        } catch (RemoteException | zzcgv | NullPointerException e) {
            zzcau unused = this.zzb.zzh = zzcas.zza(this.zza.getApplicationContext());
            this.zzb.zzh.zzd(e, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzg(ObjectWrapper.wrap(this.zza));
    }
}
