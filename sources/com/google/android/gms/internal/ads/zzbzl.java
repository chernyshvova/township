package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface zzbzl {
    boolean zza(Context context);

    @Nullable
    String zzc(Context context);

    @Nullable
    IObjectWrapper zzd(String str, WebView webView, String str2, String str3, String str4);

    @Nullable
    IObjectWrapper zze(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5);

    @Nullable
    IObjectWrapper zzf(String str, WebView webView, String str2, String str3, @Nullable String str4, zzbzn zzbzn, zzbzm zzbzm, @Nullable String str5);

    @Nullable
    IObjectWrapper zzg(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzbzn zzbzn, zzbzm zzbzm, @Nullable String str6);

    void zzh(IObjectWrapper iObjectWrapper);

    void zzi(IObjectWrapper iObjectWrapper);

    void zzj(IObjectWrapper iObjectWrapper, View view);

    void zzk(IObjectWrapper iObjectWrapper, View view);
}
