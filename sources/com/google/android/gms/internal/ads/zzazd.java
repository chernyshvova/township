package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzazd {
    @VisibleForTesting
    public zzams zza;
    @VisibleForTesting
    public boolean zzb;

    public zzazd() {
    }

    public zzazd(Context context) {
        zzbjn.zza(context);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdi)).booleanValue()) {
            try {
                this.zza = (zzams) zzcgw.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzaza.zza);
                ObjectWrapper.wrap(context);
                this.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzb = true;
            } catch (RemoteException | zzcgv | NullPointerException unused) {
                zzcgs.zzd("Cannot dynamite load clearcut");
            }
        }
    }
}
