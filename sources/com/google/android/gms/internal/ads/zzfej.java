package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfej {
    public final zzfeq zza;
    public final WebView zzb;
    public final List<zzfer> zzc = new ArrayList();
    public final Map<String, zzfer> zzd = new HashMap();
    public final String zze;
    @Nullable
    public final String zzf;
    public final zzfek zzg;

    public zzfej(zzfeq zzfeq, WebView webView, String str, List<zzfer> list, @Nullable String str2, String str3, zzfek zzfek) {
        this.zza = zzfeq;
        this.zzb = webView;
        this.zzg = zzfek;
        this.zzf = str2;
        this.zze = "";
    }

    @Deprecated
    public static zzfej zza(zzfeq zzfeq, WebView webView, String str) {
        return new zzfej(zzfeq, webView, (String) null, (List<zzfer>) null, (String) null, "", zzfek.HTML);
    }

    public static zzfej zzb(zzfeq zzfeq, WebView webView, @Nullable String str, String str2) {
        return new zzfej(zzfeq, webView, (String) null, (List<zzfer>) null, str, "", zzfek.HTML);
    }

    public static zzfej zzc(zzfeq zzfeq, WebView webView, @Nullable String str, String str2) {
        return new zzfej(zzfeq, webView, (String) null, (List<zzfer>) null, str, "", zzfek.JAVASCRIPT);
    }

    public final zzfeq zzd() {
        return this.zza;
    }

    public final List<zzfer> zze() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map<String, zzfer> zzf() {
        return Collections.unmodifiableMap(this.zzd);
    }

    public final WebView zzg() {
        return this.zzb;
    }

    @Nullable
    public final String zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zze;
    }

    public final zzfek zzj() {
        return this.zzg;
    }
}
