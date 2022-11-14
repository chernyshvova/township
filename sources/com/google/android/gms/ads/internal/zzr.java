package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbfe;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbha;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbkr;
import com.google.android.gms.internal.ads.zzcaa;
import com.google.android.gms.internal.ads.zzcad;
import com.google.android.gms.internal.ads.zzccg;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzfc;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzr extends zzbfq {
    public final zzcgy zza;
    public final zzbdp zzb;
    public final Future<zzfb> zzc = zzche.zza.zzb(new zzo(this));
    public final Context zzd;
    public final zzq zze;
    @Nullable
    public WebView zzf = new WebView(this.zzd);
    @Nullable
    public zzbfe zzg;
    @Nullable
    public zzfb zzh;
    public AsyncTask<Void, Void, String> zzi;

    public zzr(Context context, zzbdp zzbdp, String str, zzcgy zzcgy) {
        this.zzd = context;
        this.zza = zzcgy;
        this.zzb = zzbdp;
        this.zze = new zzq(context, str);
        zzL(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzm(this));
        this.zzf.setOnTouchListener(new zzn(this));
    }

    public static /* synthetic */ String zzT(zzr zzr, String str) {
        if (zzr.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzr.zzh.zze(parse, zzr.zzd, (View) null, (Activity) null);
        } catch (zzfc e) {
            zzcgs.zzj("Unable to process ad data", e);
        }
        return parse.toString();
    }

    public static /* synthetic */ void zzU(zzr zzr, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzr.zzd.startActivity(intent);
    }

    public final boolean zzA() throws RemoteException {
        return false;
    }

    public final void zzB(zzccg zzccg) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzC(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzD(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Nullable
    public final zzbhg zzE() {
        return null;
    }

    public final void zzF(zzbiv zzbiv) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzG(zzbhk zzbhk) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzH(zzbdv zzbdv) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzI(zzaxv zzaxv) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    public final int zzK(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzbev.zza();
            return zzcgl.zzs(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @VisibleForTesting
    public final void zzL(int i) {
        if (this.zzf != null) {
            this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    @VisibleForTesting
    public final String zzM() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzbkr.zzd.zze());
        builder.appendQueryParameter("query", this.zze.zzb());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        Map<String, String> zzd2 = this.zze.zzd();
        for (String next : zzd2.keySet()) {
            builder.appendQueryParameter(next, zzd2.get(next));
        }
        Uri build = builder.build();
        zzfb zzfb = this.zzh;
        if (zzfb != null) {
            try {
                build = zzfb.zzc(build, this.zzd);
            } catch (zzfc e) {
                zzcgs.zzj("Unable to process ad data", e);
            }
        }
        String zzN = zzN();
        String encodedQuery = build.getEncodedQuery();
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(zzN).length() + 1 + String.valueOf(encodedQuery).length()), zzN, "#", encodedQuery);
    }

    @VisibleForTesting
    public final String zzN() {
        String zza2 = this.zze.zza();
        if (true == TextUtils.isEmpty(zza2)) {
            zza2 = "www.google.com";
        }
        String zze2 = zzbkr.zzd.zze();
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(zza2).length() + 8 + String.valueOf(zze2).length()), "https://", zza2, zze2);
    }

    public final void zzO(zzbha zzbha) {
    }

    public final void zzP(zzbdk zzbdk, zzbfh zzbfh) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzbgf zzbgf) {
    }

    public final void zzab(zzbgc zzbgc) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    public final boolean zzbZ() throws RemoteException {
        return false;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(true);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final boolean zze(zzbdk zzbdk) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zze(zzbdk, this.zza);
        this.zzi = new zzp(this, (zzm) null).execute(new Void[0]);
        return true;
    }

    public final void zzf() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void zzg() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzh(zzbfe zzbfe) throws RemoteException {
        this.zzg = zzbfe;
    }

    public final void zzi(zzbfy zzbfy) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzj(zzbfv zzbfv) {
        throw new IllegalStateException("Unused method");
    }

    public final Bundle zzk() {
        throw new IllegalStateException("Unused method");
    }

    public final void zzl() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzm() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzbdp zzn() throws RemoteException {
        return this.zzb;
    }

    public final void zzo(zzbdp zzbdp) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzp(zzcaa zzcaa) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzq(zzcad zzcad, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Nullable
    public final String zzr() throws RemoteException {
        return null;
    }

    @Nullable
    public final String zzs() throws RemoteException {
        return null;
    }

    @Nullable
    public final zzbhd zzt() {
        return null;
    }

    public final String zzu() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzbfy zzv() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzbfe zzw() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void zzx(zzbki zzbki) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzy(zzbfb zzbfb) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzz(boolean z) throws RemoteException {
    }
}
