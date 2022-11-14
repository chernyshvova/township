package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzedm implements zzbzl {
    public final zzbzl zza;
    public final zzbzl zzb;

    public zzedm(zzbzl zzbzl, zzbzl zzbzl2) {
        this.zza = zzbzl;
        this.zzb = zzbzl2;
    }

    private final zzbzl zzb() {
        return ((Boolean) zzbex.zzc().zzb(zzbjn.zzdv)).booleanValue() ? this.zza : this.zzb;
    }

    public final boolean zza(Context context) {
        return zzb().zza(context);
    }

    @Nullable
    public final String zzc(Context context) {
        return zzb().zzc(context);
    }

    @Nullable
    public final IObjectWrapper zzd(String str, WebView webView, String str2, String str3, String str4) {
        return zzb().zzd(str, webView, "", "javascript", str4);
    }

    @Nullable
    public final IObjectWrapper zze(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5) {
        return zzb().zze(str, webView, "", "javascript", str4, str5);
    }

    @Nullable
    public final IObjectWrapper zzf(String str, WebView webView, String str2, String str3, @Nullable String str4, zzbzn zzbzn, zzbzm zzbzm, @Nullable String str5) {
        return zzb().zzf(str, webView, "", "javascript", str4, zzbzn, zzbzm, str5);
    }

    @Nullable
    public final IObjectWrapper zzg(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzbzn zzbzn, zzbzm zzbzm, @Nullable String str6) {
        return zzb().zzg(str, webView, "", "javascript", str4, str5, zzbzn, zzbzm, str6);
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        zzb().zzh(iObjectWrapper);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        zzb().zzi(iObjectWrapper);
    }

    public final void zzj(IObjectWrapper iObjectWrapper, View view) {
        zzb().zzj(iObjectWrapper, view);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, View view) {
        zzb().zzk(iObjectWrapper, view);
    }
}
