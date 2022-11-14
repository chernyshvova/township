package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzben extends zzbeu<zzbgi> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbet zzb;

    public zzben(zzbet zzbet, Context context) {
        this.zzb = zzbet;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, "mobile_ads_settings");
        return new zzbii();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        Object zzbgg;
        zzbjn.zza(this.zza);
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgG)).booleanValue()) {
            return this.zzb.zzc.zza(this.zza);
        }
        try {
            IBinder zze = ((zzbgj) zzcgw.zza(this.zza, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzbem.zza)).zze(ObjectWrapper.wrap(this.zza), 212104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzbgi) {
                zzbgg = (zzbgi) queryLocalInterface;
            } else {
                zzbgg = new zzbgg(zze);
            }
            return zzbgg;
        } catch (RemoteException | zzcgv | NullPointerException e) {
            zzcau unused = this.zzb.zzh = zzcas.zza(this.zza);
            this.zzb.zzh.zzd(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzh(ObjectWrapper.wrap(this.zza), 212104000);
    }
}
