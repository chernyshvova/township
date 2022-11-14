package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.p033h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbef extends zzbeu<zzbqq> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbvh zzb;
    public final /* synthetic */ OnH5AdsEventListener zzc;

    public zzbef(zzbet zzbet, Context context, zzbvh zzbvh, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbvh;
        this.zzc = onH5AdsEventListener;
    }

    @NonNull
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzbqx();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        try {
            return ((zzbqt) zzcgw.zza(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzbee.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 212104000, new zzbqk(this.zzc));
        } catch (RemoteException | zzcgv | NullPointerException unused) {
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzbgb zzbgb) throws RemoteException {
        return zzbgb.zzo(ObjectWrapper.wrap(this.zza), this.zzb, 212104000, new zzbqk(this.zzc));
    }
}
