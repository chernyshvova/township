package com.google.android.gms.ads.p033h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.ads.zzbqj;
import com.google.android.gms.internal.ads.zzbqw;

@RequiresApi(api = 21)
/* renamed from: com.google.android.gms.ads.h5.H5AdsWebViewClient */
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class H5AdsWebViewClient extends zzbqj {
    public final zzbqw zza;

    public H5AdsWebViewClient(@RecentlyNonNull Context context, @RecentlyNonNull WebView webView) {
        this.zza = new zzbqw(context, webView);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    @RecentlyNonNull
    public WebViewClient getDelegate() {
        return this.zza;
    }

    @RecentlyNullable
    public WebViewClient getDelegateWebViewClient() {
        return this.zza.getDelegate();
    }

    public void setDelegateWebViewClient(@Nullable WebViewClient webViewClient) {
        this.zza.zzb(webViewClient);
    }
}
