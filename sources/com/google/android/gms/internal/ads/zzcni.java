package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcni implements zzbps<zzcmr> {
    public final /* synthetic */ zzcnk zza;

    public zzcni(zzcnk zzcnk) {
        this.zza = zzcnk;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        if (this.zza.zzG != parseInt) {
                            int unused = this.zza.zzG = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzcgs.zzj("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
