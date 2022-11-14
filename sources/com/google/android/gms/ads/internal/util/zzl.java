package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzgjv;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzl implements zzbkj {
    public final /* synthetic */ zzbkl zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ Uri zzc;

    public zzl(zzr zzr, zzbkl zzbkl, Context context, Uri uri) {
        this.zza = zzbkl;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.zza.zzc()).build();
        build.intent.setPackage(zzgjv.zza(this.zzb));
        build.launchUrl(this.zzb, this.zzc);
        this.zza.zzb((Activity) this.zzb);
    }
}
