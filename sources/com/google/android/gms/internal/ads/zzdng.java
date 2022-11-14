package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdng implements zzbps {
    public final zzdnk zza;

    public zzdng(zzdnk zzdnk) {
        this.zza = zzdnk;
    }

    public final void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        zzcmr.zzR().zzw(new zzdnj(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcmr.loadData(str, "text/html", "UTF-8");
        } else {
            zzcmr.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
