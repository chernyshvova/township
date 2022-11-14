package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcng extends FrameLayout implements zzcmr {
    public final zzcmr zza;
    public final zzcio zzb;
    public final AtomicBoolean zzc = new AtomicBoolean();

    public zzcng(zzcmr zzcmr) {
        super(zzcmr.getContext());
        this.zza = zzcmr;
        this.zzb = new zzcio(zzcmr.zzM(), this, this);
        addView((View) this.zza);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        IObjectWrapper zzV = zzV();
        if (zzV != null) {
            zzr.zza.post(new zzcne(zzV));
            zzfjj zzfjj = zzr.zza;
            zzcmr zzcmr = this.zza;
            zzcmr.getClass();
            zzfjj.postDelayed(zzcnf.zza(zzcmr), (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdp)).intValue());
            return;
        }
        this.zza.destroy();
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzcmr zzcmr = this.zza;
        if (zzcmr != null) {
            zzcmr.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zzd();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA() {
        this.zza.zzA();
    }

    public final void zzB(int i) {
        this.zza.zzB(i);
    }

    public final void zzC(int i) {
        this.zza.zzC(i);
    }

    public final int zzD() {
        return this.zza.zzD();
    }

    public final int zzE() {
        return this.zza.zzE();
    }

    public final zzeye zzF() {
        return this.zza.zzF();
    }

    public final WebView zzG() {
        return (WebView) this.zza;
    }

    public final View zzH() {
        return this;
    }

    public final void zzI() {
        this.zza.zzI();
    }

    public final void zzJ(int i) {
        this.zza.zzJ(i);
    }

    public final void zzK() {
        this.zza.zzK();
    }

    public final void zzL() {
        zzcmr zzcmr = this.zza;
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzs.zzh().zzd()));
        hashMap.put("app_volume", String.valueOf(zzs.zzh().zzb()));
        zzcnk zzcnk = (zzcnk) zzcmr;
        hashMap.put("device_volume", String.valueOf(zzad.zze(zzcnk.getContext())));
        zzcnk.zze("volume", hashMap);
    }

    public final Context zzM() {
        return this.zza.zzM();
    }

    public final zzl zzN() {
        return this.zza.zzN();
    }

    public final zzl zzO() {
        return this.zza.zzO();
    }

    public final zzcoh zzP() {
        return this.zza.zzP();
    }

    public final String zzQ() {
        return this.zza.zzQ();
    }

    public final zzcof zzR() {
        return ((zzcnk) this.zza).zzaQ();
    }

    public final WebViewClient zzS() {
        return this.zza.zzS();
    }

    public final boolean zzT() {
        return this.zza.zzT();
    }

    public final zzfb zzU() {
        return this.zza.zzU();
    }

    public final IObjectWrapper zzV() {
        return this.zza.zzV();
    }

    public final boolean zzW() {
        return this.zza.zzW();
    }

    public final boolean zzX() {
        return this.zza.zzX();
    }

    public final void zzY() {
        this.zzb.zze();
        this.zza.zzY();
    }

    public final boolean zzZ() {
        return this.zza.zzZ();
    }

    public final void zza(String str) {
        ((zzcnk) this.zza).zzaN(str);
    }

    public final boolean zzaA() {
        return this.zzc.get();
    }

    public final zzeyh zzaB() {
        return this.zza.zzaB();
    }

    public final void zzaC(zzeye zzeye, zzeyh zzeyh) {
        this.zza.zzaC(zzeye, zzeyh);
    }

    public final void zzaD(boolean z) {
        this.zza.zzaD(z);
    }

    public final zzfqn<String> zzaE() {
        return this.zza.zzaE();
    }

    public final void zzaF(zzc zzc2) {
        this.zza.zzaF(zzc2);
    }

    public final void zzaG(boolean z, int i) {
        this.zza.zzaG(z, i);
    }

    public final void zzaH(boolean z, int i, String str) {
        this.zza.zzaH(z, i, str);
    }

    public final void zzaI(boolean z, int i, String str, String str2) {
        this.zza.zzaI(z, i, str, str2);
    }

    public final void zzaJ(zzbs zzbs, zzedb zzedb, zzduu zzduu, zzfdh zzfdh, String str, String str2, int i) {
        this.zza.zzaJ(zzbs, zzedb, zzduu, zzfdh, str, str2, i);
    }

    public final boolean zzaa() {
        return this.zza.zzaa();
    }

    public final void zzab(String str, zzbps<? super zzcmr> zzbps) {
        this.zza.zzab(str, zzbps);
    }

    public final void zzac(String str, zzbps<? super zzcmr> zzbps) {
        this.zza.zzac(str, zzbps);
    }

    public final void zzad(String str, Predicate<zzbps<? super zzcmr>> predicate) {
        this.zza.zzad(str, predicate);
    }

    public final void zzae(zzl zzl) {
        this.zza.zzae(zzl);
    }

    public final void zzaf(zzcoh zzcoh) {
        this.zza.zzaf(zzcoh);
    }

    public final void zzag(boolean z) {
        this.zza.zzag(z);
    }

    public final void zzah() {
        this.zza.zzah();
    }

    public final void zzai(Context context) {
        this.zza.zzai(context);
    }

    public final void zzaj(boolean z) {
        this.zza.zzaj(z);
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zza.zzak(iObjectWrapper);
    }

    public final void zzal(int i) {
        this.zza.zzal(i);
    }

    public final void zzam(zzl zzl) {
        this.zza.zzam(zzl);
    }

    public final void zzan(boolean z) {
        this.zza.zzan(z);
    }

    public final void zzao() {
        this.zza.zzao();
    }

    public final void zzap(@Nullable zzblu zzblu) {
        this.zza.zzap(zzblu);
    }

    @Nullable
    public final zzblu zzaq() {
        return this.zza.zzaq();
    }

    public final void zzar(boolean z) {
        this.zza.zzar(z);
    }

    public final void zzas() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzat(String str, String str2, @Nullable String str3) {
        this.zza.zzat(str, str2, (String) null);
    }

    public final void zzau() {
        TextView textView = new TextView(getContext());
        zzs.zzc();
        textView.setText(zzr.zzC());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzav(boolean z) {
        this.zza.zzav(z);
    }

    public final void zzaw(zzblr zzblr) {
        this.zza.zzaw(zzblr);
    }

    public final void zzax(zzaxm zzaxm) {
        this.zza.zzax(zzaxm);
    }

    public final zzaxm zzay() {
        return this.zza.zzay();
    }

    public final boolean zzaz(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzax)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaz(z, i);
        return true;
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzbB() {
        this.zza.zzbB();
    }

    public final void zzbC() {
        this.zza.zzbC();
    }

    public final void zzc(zzavy zzavy) {
        this.zza.zzc(zzavy);
    }

    public final void zzd(String str, JSONObject jSONObject) {
        this.zza.zzd(str, jSONObject);
    }

    public final void zze(String str, Map<String, ?> map) {
        this.zza.zze(str, map);
    }

    public final zzcio zzf() {
        return this.zzb;
    }

    public final void zzg(boolean z) {
        this.zza.zzg(false);
    }

    public final zzcnn zzh() {
        return this.zza.zzh();
    }

    public final zzbjz zzi() {
        return this.zza.zzi();
    }

    @Nullable
    public final Activity zzj() {
        return this.zza.zzj();
    }

    public final zza zzk() {
        return this.zza.zzk();
    }

    public final void zzl() {
        this.zza.zzl();
    }

    public final String zzm() {
        return this.zza.zzm();
    }

    public final String zzn() {
        return this.zza.zzn();
    }

    public final void zzo(int i) {
        this.zza.zzo(i);
    }

    public final int zzp() {
        return this.zza.zzp();
    }

    public final zzbka zzq() {
        return this.zza.zzq();
    }

    public final void zzr(String str, JSONObject jSONObject) {
        ((zzcnk) this.zza).zzb(str, jSONObject.toString());
    }

    public final zzckx zzs(String str) {
        return this.zza.zzs(str);
    }

    public final zzcgy zzt() {
        return this.zza.zzt();
    }

    public final void zzu(String str, zzckx zzckx) {
        this.zza.zzu(str, zzckx);
    }

    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    public final void zzw(int i) {
        this.zzb.zzf(i);
    }

    public final void zzx(zzcnn zzcnn) {
        this.zza.zzx(zzcnn);
    }

    public final int zzy() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzck)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzz() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzck)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }
}
