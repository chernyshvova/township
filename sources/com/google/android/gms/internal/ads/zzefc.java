package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefc implements zzedn<zzdiw> {
    public final Context zza;
    public final zzdjt zzb;
    public final Executor zzc;
    public final zzeyd zzd;

    public zzefc(Context context, Executor executor, zzdjt zzdjt, zzeyd zzeyd) {
        this.zza = context;
        this.zzb = zzdjt;
        this.zzc = executor;
        this.zzd = zzeyd;
    }

    public static String zzd(zzeye zzeye) {
        try {
            return zzeye.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        return (this.zza instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzbkl.zza(this.zza) && !TextUtils.isEmpty(zzd(zzeye));
    }

    public final zzfqn<zzdiw> zzb(zzeyq zzeyq, zzeye zzeye) {
        String zzd2 = zzd(zzeye);
        return zzfqe.zzi(zzfqe.zza(null), new zzefa(this, zzd2 != null ? Uri.parse(zzd2) : null, zzeyq, zzeye), this.zzc);
    }

    public final /* synthetic */ zzfqn zzc(Uri uri, zzeyq zzeyq, zzeye zzeye, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzt) null);
            zzchj zzchj = new zzchj();
            zzdix zzc3 = this.zzb.zzc(new zzcxx(zzeyq, zzeye, (String) null), new zzdja(new zzefb(zzchj), (zzcmr) null));
            zzchj.zzc(new AdOverlayInfoParcel(zzc2, (zzbcz) null, zzc3.zzi(), (zzv) null, new zzcgy(0, 0, false, false, false), (zzcmr) null));
            this.zzd.zzd();
            return zzfqe.zza(zzc3.zzh());
        } catch (Throwable th) {
            zzcgs.zzg("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
