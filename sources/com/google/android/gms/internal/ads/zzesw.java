package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzci;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzesw implements Callable {
    public static final Callable zza = new zzesw();

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzbex.zzc().zzb(zzbjn.zzF);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzbex.zzc().zzb(zzbjn.zzG)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzci.zza(str2));
                }
            }
        }
        return new zzesy(hashMap);
    }
}
