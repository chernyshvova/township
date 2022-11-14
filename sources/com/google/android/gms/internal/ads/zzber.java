package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzber extends zzbeu<zzbms> {
    public final /* synthetic */ View zza;
    public final /* synthetic */ HashMap zzb;
    public final /* synthetic */ HashMap zzc;
    public final /* synthetic */ zzbet zzd;

    public zzber(zzbet zzbet, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzd = zzbet;
        this.zza = view;
        this.zzb = hashMap;
        this.zzc = hashMap2;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza.getContext(), "native_ad_view_holder_delegate");
        return new zzbik();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        zzbjn.zza(this.zza.getContext());
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgG)).booleanValue()) {
            return this.zzd.zzg.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            return zzbmr.zze(((zzbmv) zzcgw.zza(this.zza.getContext(), "com.google.android.gms.ads.ChimeraNativeAdViewHolderDelegateCreatorImpl", zzbeq.zza)).zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc)));
        } catch (RemoteException | zzcgv | NullPointerException e) {
            zzcau unused = this.zzd.zzh = zzcas.zza(this.zza.getContext());
            this.zzd.zzh.zzd(e, "ClientApiBroker.createNativeAdViewHolderDelegate");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzj(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc));
    }
}
