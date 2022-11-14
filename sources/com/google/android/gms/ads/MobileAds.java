package com.google.android.gms.ads;

import android.content.Context;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbhv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MobileAds {
    @RecentlyNonNull
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    public static void disableMediationAdapterInitialization(@RecentlyNonNull Context context) {
        zzbhv.zza().zzk(context);
    }

    @RecentlyNullable
    public static InitializationStatus getInitializationStatus() {
        return zzbhv.zza().zzj();
    }

    @NonNull
    public static RequestConfiguration getRequestConfiguration() {
        return zzbhv.zza().zzm();
    }

    @RecentlyNonNull
    public static String getVersionString() {
        return zzbhv.zza().zzh();
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(@RecentlyNonNull Context context) {
        zzbhv.zza().zzb(context, (String) null, (OnInitializationCompleteListener) null);
    }

    public static void openAdInspector(@RecentlyNonNull Context context, @RecentlyNonNull OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzbhv.zza().zzl(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        zzbhv.zza().zzg(context, str);
    }

    @KeepForSdk
    public static void registerRtbAdapter(@RecentlyNonNull Class<? extends RtbAdapter> cls) {
        zzbhv.zza().zzi(cls);
    }

    @RequiresApi(api = 21)
    @KeepForSdk
    public static void registerWebView(@RecentlyNonNull WebView webView) {
        zzbhv.zza().zzo(webView);
    }

    public static void setAppMuted(boolean z) {
        zzbhv.zza().zze(z);
    }

    public static void setAppVolume(float f) {
        zzbhv.zza().zzc(f);
    }

    public static void setRequestConfiguration(@RecentlyNonNull RequestConfiguration requestConfiguration) {
        zzbhv.zza().zzn(requestConfiguration);
    }

    public static void initialize(@RecentlyNonNull Context context, @RecentlyNonNull OnInitializationCompleteListener onInitializationCompleteListener) {
        zzbhv.zza().zzb(context, (String) null, onInitializationCompleteListener);
    }
}
