package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzcnv extends zzcmy {
    public zzcnv(zzcmr zzcmr, zzayx zzayx, boolean z) {
        super(zzcmr, zzayx, z);
    }

    @Nullable
    public final WebResourceResponse zzL(WebView webView, String str, @Nullable Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzcmr)) {
            zzcgs.zzi("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcmr zzcmr = (zzcmr) webView;
        zzcdz zzcdz = this.zza;
        if (zzcdz != null) {
            zzcdz.zze(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzy(str, map);
        }
        if (zzcmr.zzR() != null) {
            zzcmr.zzR().zzA();
        }
        if (zzcmr.zzP().zzg()) {
            str2 = (String) zzbex.zzc().zzb(zzbjn.zzJ);
        } else if (zzcmr.zzW()) {
            str2 = (String) zzbex.zzc().zzb(zzbjn.zzI);
        } else {
            str2 = (String) zzbex.zzc().zzb(zzbjn.zzH);
        }
        zzs.zzc();
        return zzr.zzB(zzcmr.getContext(), zzcmr.zzt().zza, str2);
    }
}
