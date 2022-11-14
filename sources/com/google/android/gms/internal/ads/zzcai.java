package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcai {
    @GuardedBy("InternalQueryInfoGenerator.class")
    public static zzcfo zzd;
    public final Context zza;
    public final AdFormat zzb;
    @Nullable
    public final zzbhn zzc;

    public zzcai(Context context, AdFormat adFormat, @Nullable zzbhn zzbhn) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = zzbhn;
    }

    @Nullable
    public static zzcfo zza(Context context) {
        zzcfo zzcfo;
        synchronized (zzcai.class) {
            if (zzd == null) {
                zzd = zzbev.zzb().zzh(context, new zzbve());
            }
            zzcfo = zzd;
        }
        return zzcfo;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbdk zzbdk;
        zzcfo zza2 = zza(this.zza);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zza);
        zzbhn zzbhn = this.zzc;
        if (zzbhn == null) {
            zzbdk = new zzbdl().zza();
        } else {
            zzbdk = zzbdo.zza.zza(this.zza, zzbhn);
        }
        try {
            zza2.zze(wrap, new zzcfs((String) null, this.zzb.name(), (zzbdp) null, zzbdk), new zzcah(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
