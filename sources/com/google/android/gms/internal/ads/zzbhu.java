package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhu extends zzbrs {
    public final /* synthetic */ zzbhv zza;

    public /* synthetic */ zzbhu(zzbhv zzbhv, zzbhs zzbhs) {
        this.zza = zzbhv;
    }

    public final void zzb(List<zzbrm> list) throws RemoteException {
        boolean unused = this.zza.zze = false;
        boolean unused2 = this.zza.zzf = true;
        InitializationStatus zzs = zzbhv.zzx(list);
        ArrayList zzt = zzbhv.zza().zza;
        int size = zzt.size();
        for (int i = 0; i < size; i++) {
            ((OnInitializationCompleteListener) zzt.get(i)).onInitializationComplete(zzs);
        }
        zzbhv.zza().zza.clear();
    }
}
