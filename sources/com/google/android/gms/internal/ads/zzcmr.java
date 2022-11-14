package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public interface zzcmr extends zzbcz, zzcmi, zzbsj, zzcno, zzcnt, zzbsx, zzavz, zzcnx, zzl, zzcoa, zzcob, zzciz, zzcoc {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    zzeye zzF();

    WebView zzG();

    View zzH();

    void zzI();

    void zzJ(int i);

    void zzK();

    void zzL();

    Context zzM();

    com.google.android.gms.ads.internal.overlay.zzl zzN();

    com.google.android.gms.ads.internal.overlay.zzl zzO();

    zzcoh zzP();

    String zzQ();

    @Nullable
    zzcof zzR();

    WebViewClient zzS();

    boolean zzT();

    zzfb zzU();

    @Nullable
    IObjectWrapper zzV();

    boolean zzW();

    boolean zzX();

    void zzY();

    boolean zzZ();

    boolean zzaA();

    zzeyh zzaB();

    void zzaC(zzeye zzeye, zzeyh zzeyh);

    void zzaD(boolean z);

    zzfqn<String> zzaE();

    boolean zzaa();

    void zzab(String str, zzbps<? super zzcmr> zzbps);

    void zzac(String str, zzbps<? super zzcmr> zzbps);

    void zzad(String str, Predicate<zzbps<? super zzcmr>> predicate);

    void zzae(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzaf(zzcoh zzcoh);

    void zzag(boolean z);

    void zzah();

    void zzai(Context context);

    void zzaj(boolean z);

    void zzak(IObjectWrapper iObjectWrapper);

    void zzal(int i);

    void zzam(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzan(boolean z);

    void zzao();

    void zzap(zzblu zzblu);

    zzblu zzaq();

    void zzar(boolean z);

    void zzas();

    void zzat(String str, String str2, @Nullable String str3);

    void zzau();

    void zzav(boolean z);

    void zzaw(zzblr zzblr);

    void zzax(zzaxm zzaxm);

    zzaxm zzay();

    boolean zzaz(boolean z, int i);

    @Nullable
    zzcnn zzh();

    @Nullable
    Activity zzj();

    zza zzk();

    zzbka zzq();

    zzcgy zzt();

    void zzu(String str, zzckx zzckx);

    void zzx(zzcnn zzcnn);
}
