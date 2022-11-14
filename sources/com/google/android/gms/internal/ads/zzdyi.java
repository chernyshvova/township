package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyi implements zzgjg<zzfqn<String>> {
    public final zzgju<zzfcx> zza;
    public final zzgju<Context> zzb;

    public zzdyi(zzgju<zzfcx> zzgju, zzgju<Context> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CookieManager zzk = zzs.zze().zzk(this.zzb.zzb());
        zzfcr zzfcr = zzfcr.WEBVIEW_COOKIE;
        return zzfci.zzb(new zzdye(zzk), zzfcr, this.zza.zzb()).zzh(1, TimeUnit.SECONDS).zzf(Exception.class, zzdyf.zza).zzi();
    }
}
