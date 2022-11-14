package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbeh extends zzbeu<zzbfr> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbdp zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzbvh zzd;
    public final /* synthetic */ zzbet zze;

    public zzbeh(zzbet zzbet, Context context, zzbdp zzbdp, String str, zzbvh zzbvh) {
        this.zze = zzbet;
        this.zza = context;
        this.zzb = zzbdp;
        this.zzc = str;
        this.zzd = zzbvh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbet.zzl(this.zza, FirebaseAnalytics.Event.APP_OPEN);
        return new zzbig();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 4);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzl(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 212104000);
    }
}
