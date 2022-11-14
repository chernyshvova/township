package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbox implements zzbps {
    public static final zzbps zza = new zzbox();

    public final void zza(Object obj, Map map) {
        zzcnt zzcnt = (zzcnt) obj;
        zzbps<zzcmr> zzbps = zzbpr.zza;
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfE)).booleanValue()) {
            zzcgs.zzi("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzcgs.zzi("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(zzcnt.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        hashMap.put(str, valueOf);
        String valueOf2 = String.valueOf(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + valueOf2.length());
        sb.append("/canOpenApp;");
        sb.append(str);
        sb.append(";");
        sb.append(valueOf2);
        zze.zza(sb.toString());
        ((zzbsj) zzcnt).zze("openableApp", hashMap);
    }
}
