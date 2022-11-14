package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbow implements zzbps {
    public static final zzbps zza = new zzbow();

    public final void zza(Object obj, Map map) {
        zzcnt zzcnt = (zzcnt) obj;
        zzbps<zzcmr> zzbps = zzbpr.zza;
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzcgs.zzi("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzcnt.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            hashMap.put(str2, valueOf);
            String valueOf2 = String.valueOf(valueOf);
            StringBuilder sb = new StringBuilder(str2.length() + 14 + valueOf2.length());
            sb.append("/canOpenURLs;");
            sb.append(str2);
            sb.append(";");
            sb.append(valueOf2);
            zze.zza(sb.toString());
        }
        ((zzbsj) zzcnt).zze("openableURLs", hashMap);
    }
}
