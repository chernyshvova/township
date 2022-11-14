package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.internal.Utility;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzcmy extends WebViewClient implements zzcof {
    public static final /* synthetic */ int zzb = 0;
    public final HashSet<String> zzA;
    public View.OnAttachStateChangeListener zzB;
    @Nullable
    public zzcdz zza;
    public final zzcmr zzc;
    @Nullable
    public final zzayx zzd;
    public final HashMap<String, List<zzbps<? super zzcmr>>> zze = new HashMap<>();
    public final Object zzf = new Object();
    public zzbcz zzg;
    public zzo zzh;
    public zzcod zzi;
    public zzcoe zzj;
    public zzbos zzk;
    public zzbou zzl;
    public boolean zzm;
    public boolean zzn;
    @GuardedBy("lock")
    public boolean zzo;
    @GuardedBy("lock")
    public boolean zzp;
    @GuardedBy("lock")
    public boolean zzq;
    public zzv zzr;
    @Nullable
    public zzbyp zzs;
    public zzb zzt;
    public zzbyk zzu;
    @Nullable
    public zzfdz zzv;
    public boolean zzw;
    public boolean zzx;
    public int zzy;
    public boolean zzz;

    public zzcmy(zzcmr zzcmr, @Nullable zzayx zzayx, boolean z) {
        zzbyp zzbyp = new zzbyp(zzcmr, zzcmr.zzM(), new zzbiy(zzcmr.getContext()));
        this.zzd = zzayx;
        this.zzc = zzcmr;
        this.zzo = z;
        this.zzs = zzbyp;
        this.zzu = null;
        this.zzA = new HashSet<>(Arrays.asList(((String) zzbex.zzc().zzb(zzbjn.zzdT)).split(",")));
    }

    /* access modifiers changed from: private */
    public final void zzL(View view, zzcdz zzcdz, int i) {
        if (zzcdz.zzc() && i > 0) {
            zzcdz.zzd(view);
            if (zzcdz.zzc()) {
                zzr.zza.postDelayed(new zzcms(this, view, zzcdz, i), 100);
            }
        }
    }

    private final void zzM() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzB;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public static WebResourceResponse zzN() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzav)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzO(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        String str2;
        String str3;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry next : map.entrySet()) {
                        openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzs.zzc().zzb(this.zzc.getContext(), this.zzc.zzt().zza, false, httpURLConnection, false, 60000);
                        zzcgr zzcgr = new zzcgr((String) null);
                        zzcgr.zza(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzcgr.zzc(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzs.zzc();
                            WebResourceResponse zzS = zzr.zzS(httpURLConnection);
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField == null) {
                                throw new IOException("Missing Location header in redirect");
                            } else if (headerField.startsWith("tel:")) {
                                TrafficStats.clearThreadStatsTag();
                                return null;
                            } else {
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    zzcgs.zzi("Protocol is null");
                                    WebResourceResponse zzN = zzN();
                                    TrafficStats.clearThreadStatsTag();
                                    return zzN;
                                } else if (protocol.equals("http") || protocol.equals(Utility.URL_SCHEME)) {
                                    if (headerField.length() != 0) {
                                        str2 = "Redirecting to ".concat(headerField);
                                    } else {
                                        str2 = new String("Redirecting to ");
                                    }
                                    zzcgs.zzd(str2);
                                    httpURLConnection.disconnect();
                                    url = url2;
                                } else {
                                    if (protocol.length() != 0) {
                                        str3 = "Unsupported scheme: ".concat(protocol);
                                    } else {
                                        str3 = new String("Unsupported scheme: ");
                                    }
                                    zzcgs.zzi(str3);
                                    return zzN();
                                }
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzs.zzc();
            WebResourceResponse zzS2 = zzr.zzS(httpURLConnection);
            TrafficStats.clearThreadStatsTag();
            return zzS2;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzP(Map<String, String> map, List<zzbps<? super zzcmr>> list, String str) {
        String str2;
        if (zze.zzc()) {
            if (str.length() != 0) {
                str2 = "Received GMSG: ".concat(str);
            } else {
                str2 = new String("Received GMSG: ");
            }
            zze.zza(str2);
            for (String next : map.keySet()) {
                String str3 = map.get(next);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str3);
                zze.zza(sb.toString());
            }
        }
        for (zzbps<? super zzcmr> zza2 : list) {
            zza2.zza(this.zzc, map);
        }
    }

    public final void onAdClicked() {
        zzbcz zzbcz = this.zzg;
        if (zzbcz != null) {
            zzbcz.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Loading resource: ".concat(valueOf);
        } else {
            str2 = new String("Loading resource: ");
        }
        zze.zza(str2);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzD(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zzb();
        r0.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzw = true;
        r1 = r0.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.zzf
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcmr r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.zzX()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzcmr r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            r2.zzY()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzw = r1
            com.google.android.gms.internal.ads.zzcoe r1 = r0.zzj
            if (r1 == 0) goto L_0x0025
            r1.zzb()
            r1 = 0
            r0.zzj = r1
        L_0x0025:
            r0.zzl()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmy.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzn = true;
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaz(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzy(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "AdWebView shouldOverrideUrlLoading: ".concat(valueOf);
        } else {
            str2 = new String("AdWebView shouldOverrideUrlLoading: ");
        }
        zze.zza(str2);
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzm && webView == this.zzc.zzG()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || Utility.URL_SCHEME.equalsIgnoreCase(scheme)) {
                    zzbcz zzbcz = this.zzg;
                    if (zzbcz != null) {
                        zzbcz.onAdClicked();
                        zzcdz zzcdz = this.zza;
                        if (zzcdz != null) {
                            zzcdz.zzb(str);
                        }
                        this.zzg = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzc.zzG().willNotDraw()) {
                try {
                    zzfb zzU = this.zzc.zzU();
                    if (zzU != null && zzU.zza(parse)) {
                        Context context = this.zzc.getContext();
                        zzcmr zzcmr = this.zzc;
                        parse = zzU.zze(parse, context, (View) zzcmr, zzcmr.zzj());
                    }
                } catch (zzfc unused) {
                    String valueOf2 = String.valueOf(str);
                    zzcgs.zzi(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zzb zzb2 = this.zzt;
                if (zzb2 == null || zzb2.zzb()) {
                    zzm(new zzc("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (zzt) null));
                    return true;
                }
                this.zzt.zzc(str);
                return true;
            }
            String valueOf3 = String.valueOf(str);
            zzcgs.zzi(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            return true;
        }
        zzD(parse);
        return true;
    }

    public final void zzA() {
        synchronized (this.zzf) {
            this.zzm = false;
            this.zzo = true;
            zzche.zze.execute(new zzcmt(this));
        }
    }

    public final void zzB(boolean z) {
        this.zzz = z;
    }

    public final void zzC(int i, int i2) {
        zzbyk zzbyk = this.zzu;
        if (zzbyk != null) {
            zzbyk.zze(i, i2);
        }
    }

    public final void zzD(Uri uri) {
        String str;
        String path = uri.getPath();
        List list = this.zze.get(path);
        if (path == null || list == null) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf.length() + 32);
            sb.append("No GMSG handler found for GMSG: ");
            sb.append(valueOf);
            zze.zza(sb.toString());
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeX)).booleanValue() && zzs.zzg().zza() != null) {
                zzche.zza.execute(new zzcmu((path == null || path.length() < 2) ? "null" : path.substring(1)));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdS)).booleanValue() && this.zzA.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzbex.zzc().zzb(zzbjn.zzdU)).intValue()) {
                if (path.length() != 0) {
                    str = "Parsing gmsg query params on BG thread: ".concat(path);
                } else {
                    str = new String("Parsing gmsg query params on BG thread: ");
                }
                zze.zza(str);
                zzfqe.zzp(zzs.zzc().zzi(uri), new zzcmw(this, list, path, uri), zzche.zze);
                return;
            }
        }
        zzs.zzc();
        zzP(zzr.zzR(uri), list, path);
    }

    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzp = true;
        }
    }

    public final void zzF(boolean z) {
        synchronized (this.zzf) {
            this.zzq = z;
        }
    }

    public final /* synthetic */ void zzG() {
        this.zzc.zzah();
        zzl zzN = this.zzc.zzN();
        if (zzN != null) {
            zzN.zzv();
        }
    }

    public final /* synthetic */ void zzH(View view, zzcdz zzcdz, int i) {
        zzL(view, zzcdz, i - 1);
    }

    public final void zzK(@Nullable zzbcz zzbcz, @Nullable zzbos zzbos, @Nullable zzo zzo2, @Nullable zzbou zzbou, @Nullable zzv zzv2, boolean z, @Nullable zzbpv zzbpv, @Nullable zzb zzb2, @Nullable zzbyr zzbyr, @Nullable zzcdz zzcdz, @Nullable zzedb zzedb, @Nullable zzfdz zzfdz, @Nullable zzduu zzduu, @Nullable zzfdh zzfdh, @Nullable zzbpt zzbpt) {
        zzbos zzbos2 = zzbos;
        zzbou zzbou2 = zzbou;
        zzbpv zzbpv2 = zzbpv;
        zzbyr zzbyr2 = zzbyr;
        zzcdz zzcdz2 = zzcdz;
        zzfdz zzfdz2 = zzfdz;
        zzbpt zzbpt2 = zzbpt;
        zzb zzb3 = zzb2 == null ? new zzb(this.zzc.getContext(), zzcdz2, (zzcay) null) : zzb2;
        this.zzu = new zzbyk(this.zzc, zzbyr2);
        this.zza = zzcdz2;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaC)).booleanValue()) {
            zzs("/adMetadata", new zzbor(zzbos2));
        }
        if (zzbou2 != null) {
            zzs("/appEvent", new zzbot(zzbou2));
        }
        zzs("/backButton", zzbpr.zzk);
        zzs("/refresh", zzbpr.zzl);
        zzs("/canOpenApp", zzbpr.zzb);
        zzs("/canOpenURLs", zzbpr.zza);
        zzs("/canOpenIntents", zzbpr.zzc);
        zzs("/close", zzbpr.zze);
        zzs("/customClose", zzbpr.zzf);
        zzs("/instrument", zzbpr.zzo);
        zzs("/delayPageLoaded", zzbpr.zzq);
        zzs("/delayPageClosed", zzbpr.zzr);
        zzs("/getLocationInfo", zzbpr.zzs);
        zzs("/log", zzbpr.zzh);
        zzs("/mraid", new zzbpz(zzb3, this.zzu, zzbyr2));
        zzbyp zzbyp = this.zzs;
        if (zzbyp != null) {
            zzs("/mraidLoaded", zzbyp);
        }
        zzs("/open", new zzbqd(zzb3, this.zzu, zzedb, zzduu, zzfdh));
        zzs("/precache", new zzcky());
        zzs("/touch", zzbpr.zzj);
        zzs("/video", zzbpr.zzm);
        zzs("/videoMeta", zzbpr.zzn);
        if (zzedb == null || zzfdz2 == null) {
            zzs("/click", zzbpr.zzd);
            zzs("/httpTrack", zzbpr.zzg);
        } else {
            zzs("/click", zzezf.zza(zzedb, zzfdz));
            zzs("/httpTrack", zzezf.zzb(zzedb, zzfdz));
        }
        if (zzs.zzA().zzb(this.zzc.getContext())) {
            zzs("/logScionEvent", new zzbpy(this.zzc.getContext()));
        }
        if (zzbpv2 != null) {
            zzs("/setInterstitialProperties", new zzbpu(zzbpv2, (byte[]) null));
        }
        if (zzbpt2 != null) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue()) {
                zzs("/inspectorNetworkExtras", zzbpt2);
            }
        }
        this.zzg = zzbcz;
        this.zzh = zzo2;
        this.zzk = zzbos2;
        this.zzl = zzbou2;
        this.zzr = zzv2;
        this.zzt = zzb3;
        this.zzm = z;
        this.zzv = zzfdz2;
    }

    public final void zza(int i, int i2, boolean z) {
        zzbyp zzbyp = this.zzs;
        if (zzbyp != null) {
            zzbyp.zzb(i, i2);
        }
        zzbyk zzbyk = this.zzu;
        if (zzbyk != null) {
            zzbyk.zzc(i, i2, false);
        }
    }

    public final zzb zzb() {
        return this.zzt;
    }

    public final boolean zzc() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzo;
        }
        return z;
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzp;
        }
        return z;
    }

    public final boolean zze() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzq;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzf() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzg() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final void zzh() {
        zzcdz zzcdz = this.zza;
        if (zzcdz != null) {
            WebView zzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(zzG)) {
                zzL(zzG, zzcdz, 10);
                return;
            }
            zzM();
            zzcmv zzcmv = new zzcmv(this, zzcdz);
            this.zzB = zzcmv;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcmv);
        }
    }

    public final void zzi() {
        synchronized (this.zzf) {
        }
        this.zzy++;
        zzl();
    }

    public final void zzj() {
        this.zzy--;
        zzl();
    }

    public final void zzk() {
        zzayx zzayx = this.zzd;
        if (zzayx != null) {
            zzayx.zzb(zzayz.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzx = true;
        zzl();
        this.zzc.destroy();
    }

    public final void zzl() {
        if (this.zzi != null && ((this.zzw && this.zzy <= 0) || this.zzx || this.zzn)) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && this.zzc.zzq() != null) {
                zzbju.zza(this.zzc.zzq().zzc(), this.zzc.zzi(), "awfllc");
            }
            zzcod zzcod = this.zzi;
            boolean z = false;
            if (!this.zzx && !this.zzn) {
                z = true;
            }
            zzcod.zza(z);
            this.zzi = null;
        }
        this.zzc.zzao();
    }

    public final void zzm(zzc zzc2) {
        zzbcz zzbcz;
        boolean zzW = this.zzc.zzW();
        if (!zzW || this.zzc.zzP().zzg()) {
            zzbcz = this.zzg;
        } else {
            zzbcz = null;
        }
        zzr(new AdOverlayInfoParcel(zzc2, zzbcz, zzW ? null : this.zzh, this.zzr, this.zzc.zzt(), this.zzc));
    }

    public final void zzn(zzbs zzbs, zzedb zzedb, zzduu zzduu, zzfdh zzfdh, String str, String str2, int i) {
        zzcmr zzcmr = this.zzc;
        zzr(new AdOverlayInfoParcel(zzcmr, zzcmr.zzt(), zzbs, zzedb, zzduu, zzfdh, str, str2, i));
    }

    public final void zzo(boolean z, int i) {
        zzbcz zzbcz;
        if (!this.zzc.zzW() || this.zzc.zzP().zzg()) {
            zzbcz = this.zzg;
        } else {
            zzbcz = null;
        }
        zzo zzo2 = this.zzh;
        zzv zzv2 = this.zzr;
        zzcmr zzcmr = this.zzc;
        zzr(new AdOverlayInfoParcel(zzbcz, zzo2, zzv2, zzcmr, z, i, zzcmr.zzt()));
    }

    public final void zzp(boolean z, int i, String str) {
        zzbcz zzbcz;
        zzcmx zzcmx;
        boolean zzW = this.zzc.zzW();
        if (!zzW || this.zzc.zzP().zzg()) {
            zzbcz = this.zzg;
        } else {
            zzbcz = null;
        }
        if (zzW) {
            zzcmx = null;
        } else {
            zzcmx = new zzcmx(this.zzc, this.zzh);
        }
        zzbos zzbos = this.zzk;
        zzbou zzbou = this.zzl;
        zzv zzv2 = this.zzr;
        zzcmr zzcmr = this.zzc;
        zzr(new AdOverlayInfoParcel(zzbcz, zzcmx, zzbos, zzbou, zzv2, zzcmr, z, i, str, zzcmr.zzt()));
    }

    public final void zzq(boolean z, int i, String str, String str2) {
        zzbcz zzbcz;
        zzcmx zzcmx;
        boolean zzW = this.zzc.zzW();
        if (!zzW || this.zzc.zzP().zzg()) {
            zzbcz = this.zzg;
        } else {
            zzbcz = null;
        }
        if (zzW) {
            zzcmx = null;
        } else {
            zzcmx = new zzcmx(this.zzc, this.zzh);
        }
        zzbos zzbos = this.zzk;
        zzbou zzbou = this.zzl;
        zzv zzv2 = this.zzr;
        zzcmr zzcmr = this.zzc;
        zzr(new AdOverlayInfoParcel(zzbcz, zzcmx, zzbos, zzbou, zzv2, zzcmr, z, i, str, str2, zzcmr.zzt()));
    }

    public final void zzr(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzc2;
        zzbyk zzbyk = this.zzu;
        boolean zzd2 = zzbyk != null ? zzbyk.zzd() : false;
        zzs.zzb();
        zzm.zza(this.zzc.getContext(), adOverlayInfoParcel, !zzd2);
        zzcdz zzcdz = this.zza;
        if (zzcdz != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzcdz.zzb(str);
        }
    }

    public final void zzs(String str, zzbps<? super zzcmr> zzbps) {
        synchronized (this.zzf) {
            List list = this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbps);
        }
    }

    public final void zzt(String str, zzbps<? super zzcmr> zzbps) {
        synchronized (this.zzf) {
            List list = this.zze.get(str);
            if (list != null) {
                list.remove(zzbps);
            }
        }
    }

    public final void zzu(String str, Predicate<zzbps<? super zzcmr>> predicate) {
        synchronized (this.zzf) {
            List<zzbps> list = this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzbps zzbps : list) {
                    if (predicate.apply(zzbps)) {
                        arrayList.add(zzbps);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void zzv() {
        zzcdz zzcdz = this.zza;
        if (zzcdz != null) {
            zzcdz.zzf();
            this.zza = null;
        }
        zzM();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzm = false;
            this.zzo = false;
            this.zzp = false;
            this.zzr = null;
            this.zzt = null;
            this.zzs = null;
            zzbyk zzbyk = this.zzu;
            if (zzbyk != null) {
                zzbyk.zzb(true);
                this.zzu = null;
            }
            this.zzv = null;
        }
    }

    public final void zzw(zzcod zzcod) {
        this.zzi = zzcod;
    }

    public final void zzx(zzcoe zzcoe) {
        this.zzj = zzcoe;
    }

    @Nullable
    public final WebResourceResponse zzy(String str, Map<String, String> map) {
        zzayg zzc2;
        try {
            if (zzblb.zza.zze().booleanValue()) {
                if (this.zzv != null && "oda".equals(Uri.parse(str).getScheme())) {
                    this.zzv.zzb(str);
                    return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
                }
            }
            String zza2 = zzcfd.zza(str, this.zzc.getContext(), this.zzz);
            if (!zza2.equals(str)) {
                return zzO(zza2, map);
            }
            zzayj zza3 = zzayj.zza(Uri.parse(str));
            if (zza3 != null && (zzc2 = zzs.zzi().zzc(zza3)) != null && zzc2.zza()) {
                return new WebResourceResponse("", "", zzc2.zzb());
            }
            if (!zzcgr.zzj() || !zzbkx.zzb.zze().booleanValue()) {
                return null;
            }
            return zzO(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            zzs.zzg().zzg(e, "AdWebViewClient.interceptRequest");
            return zzN();
        }
    }

    public final void zzz(boolean z) {
        this.zzm = false;
    }
}
