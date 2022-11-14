package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbep extends zzbeu<zzbmm> {
    public final /* synthetic */ FrameLayout zza;
    public final /* synthetic */ FrameLayout zzb;
    public final /* synthetic */ Context zzc;
    public final /* synthetic */ zzbet zzd;

    public zzbep(zzbet zzbet, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzd = zzbet;
        this.zza = frameLayout;
        this.zzb = frameLayout2;
        this.zzc = context;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zzc, "native_ad_view_delegate");
        return new zzbij();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        zzbjn.zza(this.zzc);
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgG)).booleanValue()) {
            return this.zzd.zzd.zza(this.zzc, this.zza, this.zzb);
        }
        try {
            return zzbml.zzbQ(((zzbmp) zzcgw.zza(this.zzc, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", zzbeo.zza)).zze(ObjectWrapper.wrap(this.zzc), ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), 212104000));
        } catch (RemoteException | zzcgv | NullPointerException e) {
            zzcau unused = this.zzd.zzh = zzcas.zza(this.zzc);
            this.zzd.zzh.zzd(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb));
    }
}
