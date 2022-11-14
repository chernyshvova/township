package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzhi implements PackageManager.OnChecksumsReadyListener {
    public final zzfqv zza;

    public zzhi(zzfqv zzfqv) {
        this.zza = zzfqv;
    }

    public final void onChecksumsReady(List list) {
        zzfqv zzfqv = this.zza;
        if (list == null) {
            zzfqv.zzh(null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                if (apkChecksum.getType() == 8) {
                    zzfqv.zzh(zzgb.zzb(apkChecksum.getValue()));
                    return;
                }
            }
            zzfqv.zzh(null);
        } catch (Throwable unused) {
            zzfqv.zzh(null);
        }
    }
}
