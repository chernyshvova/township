package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzcj;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.vungle.warren.VisionController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcnk extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcmr {
    public static final /* synthetic */ int zza = 0;
    @GuardedBy("this")
    public boolean zzA;
    @GuardedBy("this")
    public boolean zzB;
    @GuardedBy("this")
    public zzblu zzC;
    @GuardedBy("this")
    public zzblr zzD;
    @GuardedBy("this")
    public zzaxm zzE;
    @GuardedBy("this")
    public int zzF;
    @GuardedBy("this")
    public int zzG;
    public zzbjz zzH;
    public final zzbjz zzI;
    public zzbjz zzJ;
    public final zzbka zzK;
    public WeakReference<View.OnClickListener> zzL;
    public int zzM;
    public int zzN;
    public int zzO;
    @GuardedBy("this")
    public zzl zzP;
    @GuardedBy("this")
    public boolean zzQ;
    public final zzcj zzR;
    public int zzS = -1;
    public int zzT = -1;
    public int zzU = -1;
    public int zzV = -1;
    public Map<String, zzckx> zzW;
    public final WindowManager zzX;
    public final zzayx zzY;
    public final zzcog zzb;
    @Nullable
    public final zzfb zzc;
    @Nullable
    public final zzbkm zzd;
    public final zzcgy zze;
    @Nullable
    public com.google.android.gms.ads.internal.zzl zzf;
    public final zza zzg;
    public final DisplayMetrics zzh;
    public final float zzi;
    @Nullable
    public zzeye zzj;
    @Nullable
    public zzeyh zzk;
    public boolean zzl = false;
    public boolean zzm = false;
    public zzcmy zzn;
    @GuardedBy("this")
    public zzl zzo;
    @GuardedBy("this")
    public IObjectWrapper zzp;
    @GuardedBy("this")
    public zzcoh zzq;
    @GuardedBy("this")
    public final String zzr;
    @GuardedBy("this")
    public boolean zzs;
    @GuardedBy("this")
    public boolean zzt;
    @GuardedBy("this")
    public boolean zzu;
    @GuardedBy("this")
    public boolean zzv;
    @GuardedBy("this")
    public Boolean zzw;
    @GuardedBy("this")
    public boolean zzx = true;
    @GuardedBy("this")
    public final String zzy = "";
    @GuardedBy("this")
    public zzcnn zzz;

    @VisibleForTesting
    public zzcnk(zzcog zzcog, zzcoh zzcoh, String str, boolean z, boolean z2, @Nullable zzfb zzfb, @Nullable zzbkm zzbkm, zzcgy zzcgy, zzbkc zzbkc, com.google.android.gms.ads.internal.zzl zzl2, zza zza2, zzayx zzayx, zzeye zzeye, zzeyh zzeyh) {
        super(zzcog);
        zzeyh zzeyh2;
        this.zzb = zzcog;
        this.zzq = zzcoh;
        this.zzr = str;
        this.zzu = z;
        this.zzc = zzfb;
        this.zzd = zzbkm;
        this.zze = zzcgy;
        this.zzf = zzl2;
        this.zzg = zza2;
        this.zzX = (WindowManager) getContext().getSystemService(VisionController.WINDOW);
        zzs.zzc();
        DisplayMetrics zzy2 = zzr.zzy(this.zzX);
        this.zzh = zzy2;
        this.zzi = zzy2.density;
        this.zzY = zzayx;
        this.zzj = zzeye;
        this.zzk = zzeyh;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzcgs.zzg("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(zzs.zzc().zze(zzcog, zzcgy.zza));
        zzs.zze().zza(getContext(), settings);
        setDownloadListener(this);
        zzaX();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(new zzcns(this, new zzcnp(this)), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzR = new zzcj(this.zzb.zza(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzbc();
        zzbka zzbka = new zzbka(new zzbkc(true, "make_wv", this.zzr));
        this.zzK = zzbka;
        zzbka.zzc().zza((zzbkc) null);
        if (!(!((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() || (zzeyh2 = this.zzk) == null || zzeyh2.zzb == null)) {
            this.zzK.zzc().zzd("gqi", this.zzk.zzb);
        }
        this.zzK.zzc();
        zzbjz zzf2 = zzbkc.zzf();
        this.zzI = zzf2;
        this.zzK.zza("native:view_create", zzf2);
        this.zzJ = null;
        this.zzH = null;
        zzs.zze().zzc(zzcog);
        zzs.zzg().zzi();
    }

    private final synchronized void zzaU(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzs.zzg().zzg(e, "AdWebViewImpl.loadUrlUnsafe");
            zzcgs.zzj("Could not call loadUrl. ", e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzaO(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzaV() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcgd r0 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ all -> 0x0023 }
            java.lang.Boolean r0 = r0.zzc()     // Catch:{ all -> 0x0023 }
            r2.zzw = r0     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            java.lang.String r0 = "(function(){})()"
            r1 = 0
            r2.evaluateJavascript(r0, r1)     // Catch:{ IllegalStateException -> 0x001a }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IllegalStateException -> 0x001a }
            r2.zzaO(r0)     // Catch:{ IllegalStateException -> 0x001a }
            monitor-exit(r2)
            return
        L_0x001a:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0023 }
            r2.zzaO(r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnk.zzaV():void");
    }

    private final void zzaW() {
        zzbju.zza(this.zzK.zzc(), this.zzI, "aeh2");
    }

    private final synchronized void zzaX() {
        zzeye zzeye = this.zzj;
        if (zzeye != null) {
            if (zzeye.zzai) {
                zzcgs.zzd("Disabling hardware acceleration on an overlay.");
                zzaY();
                return;
            }
        }
        if (!this.zzu) {
            if (!this.zzq.zzg()) {
                zzcgs.zzd("Enabling hardware acceleration on an AdView.");
                zzaZ();
                return;
            }
        }
        zzcgs.zzd("Enabling hardware acceleration on an overlay.");
        zzaZ();
    }

    private final synchronized void zzaY() {
        if (!this.zzv) {
            setLayerType(1, (Paint) null);
        }
        this.zzv = true;
    }

    private final synchronized void zzaZ() {
        if (this.zzv) {
            setLayerType(0, (Paint) null);
        }
        this.zzv = false;
    }

    private final synchronized void zzba() {
        if (!this.zzQ) {
            this.zzQ = true;
            zzs.zzg().zzj();
        }
    }

    private final synchronized void zzbb() {
        Map<String, zzckx> map = this.zzW;
        if (map != null) {
            for (zzckx release : map.values()) {
                release.release();
            }
        }
        this.zzW = null;
    }

    private final void zzbc() {
        zzbka zzbka = this.zzK;
        if (zzbka != null) {
            zzbkc zzc2 = zzbka.zzc();
            if (zzs.zzg().zza() != null) {
                zzs.zzg().zza().zzb(zzc2);
            }
        }
    }

    private final void zzbd(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zze("onAdVisibilityChanged", hashMap);
    }

    public final synchronized void destroy() {
        zzbc();
        this.zzR.zzc();
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzb();
            this.zzo.zzq();
            this.zzo = null;
        }
        this.zzp = null;
        this.zzn.zzv();
        this.zzE = null;
        this.zzf = null;
        setOnClickListener((View.OnClickListener) null);
        setOnTouchListener((View.OnTouchListener) null);
        if (!this.zzt) {
            zzs.zzy();
            zzckq.zzd(this);
            zzbb();
            this.zzt = true;
            zze.zza("Initiating WebView self destruct sequence in 3...");
            zze.zza("Loading blank page in WebView, 2...");
            zzaU("about:blank");
        }
    }

    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (zzX()) {
            zzcgs.zzl("#004 The webview is destroyed. Ignoring action.", (Throwable) null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
                return;
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzt) {
                    this.zzn.zzv();
                    zzs.zzy();
                    zzckq.zzd(this);
                    zzbb();
                    zzba();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzX()) {
            super.loadData(str, str2, str3);
        } else {
            zzcgs.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!zzX()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzcgs.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!zzX()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzs.zzg().zzg(e, "AdWebViewImpl.loadUrl");
                zzcgs.zzj("Could not call loadUrl. ", e);
            }
        } else {
            zzcgs.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void onAdClicked() {
        zzcmy zzcmy = this.zzn;
        if (zzcmy != null) {
            zzcmy.onAdClicked();
        }
    }

    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzX()) {
            this.zzR.zzd();
        }
        boolean z = this.zzA;
        zzcmy zzcmy = this.zzn;
        if (zzcmy != null && zzcmy.zzd()) {
            if (!this.zzB) {
                this.zzn.zzf();
                this.zzn.zzg();
                this.zzB = true;
            }
            zzaK();
            z = true;
        }
        zzbd(z);
    }

    public final void onDetachedFromWindow() {
        zzcmy zzcmy;
        synchronized (this) {
            if (!zzX()) {
                this.zzR.zze();
            }
            super.onDetachedFromWindow();
            if (this.zzB && (zzcmy = this.zzn) != null && zzcmy.zzd() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzn.zzf();
                this.zzn.zzg();
                this.zzB = false;
            }
        }
        zzbd(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzs.zzc();
            zzr.zzP(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzcgs.zzd(sb.toString());
        }
    }

    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!zzX()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zzaK = zzaK();
        zzl zzN2 = zzN();
        if (zzN2 != null && zzaK) {
            zzN2.zzB();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01cb A[SYNTHETIC, Splitter:B:116:0x01cb] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0141  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:66:0x00e0=Splitter:B:66:0x00e0, B:126:0x01ec=Splitter:B:126:0x01ec} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzX()     // Catch:{ all -> 0x01f1 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x000d:
            boolean r0 = r8.isInEditMode()     // Catch:{ all -> 0x01f1 }
            if (r0 != 0) goto L_0x01ec
            boolean r0 = r8.zzu     // Catch:{ all -> 0x01f1 }
            if (r0 != 0) goto L_0x01ec
            com.google.android.gms.internal.ads.zzcoh r0 = r8.zzq     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.zzh()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x0021
            goto L_0x01ec
        L_0x0021:
            com.google.android.gms.internal.ads.zzcoh r0 = r8.zzq     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.zzj()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzcoh r0 = r8.zzq     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.zzi()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzcj     // Catch:{ all -> 0x01f1 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x01f1 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x01f1 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzcnn r0 = r8.zzh()     // Catch:{ all -> 0x01f1 }
            r2 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.zzm()     // Catch:{ all -> 0x01f1 }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0063
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x0063:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f1 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01f1 }
            float r2 = (float) r10     // Catch:{ all -> 0x01f1 }
            float r2 = r2 * r0
            int r2 = (int) r2     // Catch:{ all -> 0x01f1 }
            float r3 = (float) r9     // Catch:{ all -> 0x01f1 }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x01f1 }
            if (r10 != 0) goto L_0x007e
            if (r3 == 0) goto L_0x007d
            float r10 = (float) r3     // Catch:{ all -> 0x01f1 }
            float r10 = r10 * r0
            int r2 = (int) r10     // Catch:{ all -> 0x01f1 }
            r1 = r9
            r10 = r3
            goto L_0x0088
        L_0x007d:
            r10 = 0
        L_0x007e:
            if (r9 != 0) goto L_0x0087
            if (r2 == 0) goto L_0x0088
            float r9 = (float) r2     // Catch:{ all -> 0x01f1 }
            float r9 = r9 / r0
            int r3 = (int) r9     // Catch:{ all -> 0x01f1 }
            r1 = r2
            goto L_0x0088
        L_0x0087:
            r1 = r9
        L_0x0088:
            int r9 = java.lang.Math.min(r2, r1)     // Catch:{ all -> 0x01f1 }
            int r10 = java.lang.Math.min(r3, r10)     // Catch:{ all -> 0x01f1 }
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x0095:
            com.google.android.gms.internal.ads.zzcoh r0 = r8.zzq     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.zzf()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzcn     // Catch:{ all -> 0x01f1 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x01f1 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x01f1 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01f1 }
            if (r0 != 0) goto L_0x00e0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01f1 }
            if (r0 != 0) goto L_0x00b6
            goto L_0x00e0
        L_0x00b6:
            com.google.android.gms.internal.ads.zzcni r0 = new com.google.android.gms.internal.ads.zzcni     // Catch:{ all -> 0x01f1 }
            r0.<init>(r8)     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = "/contentHeight"
            r8.zzab(r1, r0)     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r8.zzaN(r0)     // Catch:{ all -> 0x01f1 }
            android.util.DisplayMetrics r0 = r8.zzh     // Catch:{ all -> 0x01f1 }
            float r0 = r0.density     // Catch:{ all -> 0x01f1 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f1 }
            int r1 = r8.zzG     // Catch:{ all -> 0x01f1 }
            r2 = -1
            if (r1 == r2) goto L_0x00d7
            float r10 = (float) r1     // Catch:{ all -> 0x01f1 }
            float r10 = r10 * r0
            int r10 = (int) r10     // Catch:{ all -> 0x01f1 }
            goto L_0x00db
        L_0x00d7:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01f1 }
        L_0x00db:
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x00e0:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x00e5:
            com.google.android.gms.internal.ads.zzcoh r0 = r8.zzq     // Catch:{ all -> 0x01f1 }
            boolean r0 = r0.zzg()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x00fa
            android.util.DisplayMetrics r9 = r8.zzh     // Catch:{ all -> 0x01f1 }
            int r9 = r9.widthPixels     // Catch:{ all -> 0x01f1 }
            android.util.DisplayMetrics r10 = r8.zzh     // Catch:{ all -> 0x01f1 }
            int r10 = r10.heightPixels     // Catch:{ all -> 0x01f1 }
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x00fa:
            int r0 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01f1 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f1 }
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x01f1 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01f1 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r5) goto L_0x011a
            if (r0 != r4) goto L_0x0116
            goto L_0x011a
        L_0x0116:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x011b
        L_0x011a:
            r0 = r9
        L_0x011b:
            if (r2 == r5) goto L_0x011f
            if (r2 != r4) goto L_0x0120
        L_0x011f:
            r3 = r10
        L_0x0120:
            com.google.android.gms.internal.ads.zzcoh r2 = r8.zzq     // Catch:{ all -> 0x01f1 }
            int r4 = r2.zzb     // Catch:{ all -> 0x01f1 }
            r5 = 1
            if (r4 > r0) goto L_0x012e
            int r2 = r2.zza     // Catch:{ all -> 0x01f1 }
            if (r2 <= r3) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzbjn.zzdJ     // Catch:{ all -> 0x01f1 }
            com.google.android.gms.internal.ads.zzbjl r6 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x01f1 }
            java.lang.Object r4 = r6.zzb(r4)     // Catch:{ all -> 0x01f1 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01f1 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01f1 }
            if (r4 == 0) goto L_0x0160
            com.google.android.gms.internal.ads.zzcoh r4 = r8.zzq     // Catch:{ all -> 0x01f1 }
            int r6 = r4.zzb     // Catch:{ all -> 0x01f1 }
            float r7 = r8.zzi     // Catch:{ all -> 0x01f1 }
            float r6 = (float) r6     // Catch:{ all -> 0x01f1 }
            float r6 = r6 / r7
            float r0 = (float) r0     // Catch:{ all -> 0x01f1 }
            float r0 = r0 / r7
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x015b
            int r0 = r4.zza     // Catch:{ all -> 0x01f1 }
            float r0 = (float) r0     // Catch:{ all -> 0x01f1 }
            float r0 = r0 / r7
            float r3 = (float) r3     // Catch:{ all -> 0x01f1 }
            float r3 = r3 / r7
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x015b
            r0 = 1
            goto L_0x015c
        L_0x015b:
            r0 = 0
        L_0x015c:
            if (r5 == r2) goto L_0x015f
            goto L_0x0160
        L_0x015f:
            r2 = r0
        L_0x0160:
            r0 = 8
            if (r2 == 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzcoh r2 = r8.zzq     // Catch:{ all -> 0x01f1 }
            int r3 = r2.zzb     // Catch:{ all -> 0x01f1 }
            float r4 = r8.zzi     // Catch:{ all -> 0x01f1 }
            int r2 = r2.zza     // Catch:{ all -> 0x01f1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            r7 = 103(0x67, float:1.44E-43)
            r6.<init>(r7)     // Catch:{ all -> 0x01f1 }
            java.lang.String r7 = "Not enough space to show ad. Needs "
            r6.append(r7)     // Catch:{ all -> 0x01f1 }
            float r3 = (float) r3     // Catch:{ all -> 0x01f1 }
            float r3 = r3 / r4
            int r3 = (int) r3     // Catch:{ all -> 0x01f1 }
            r6.append(r3)     // Catch:{ all -> 0x01f1 }
            java.lang.String r3 = "x"
            r6.append(r3)     // Catch:{ all -> 0x01f1 }
            float r2 = (float) r2     // Catch:{ all -> 0x01f1 }
            float r2 = r2 / r4
            int r2 = (int) r2     // Catch:{ all -> 0x01f1 }
            r6.append(r2)     // Catch:{ all -> 0x01f1 }
            java.lang.String r2 = " dp, but only has "
            r6.append(r2)     // Catch:{ all -> 0x01f1 }
            float r9 = (float) r9     // Catch:{ all -> 0x01f1 }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01f1 }
            r6.append(r9)     // Catch:{ all -> 0x01f1 }
            java.lang.String r9 = "x"
            r6.append(r9)     // Catch:{ all -> 0x01f1 }
            float r9 = (float) r10     // Catch:{ all -> 0x01f1 }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01f1 }
            r6.append(r9)     // Catch:{ all -> 0x01f1 }
            java.lang.String r9 = " dp."
            r6.append(r9)     // Catch:{ all -> 0x01f1 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x01f1 }
            com.google.android.gms.internal.ads.zzcgs.zzi(r9)     // Catch:{ all -> 0x01f1 }
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01f1 }
            if (r9 == r0) goto L_0x01b7
            r9 = 4
            r8.setVisibility(r9)     // Catch:{ all -> 0x01f1 }
        L_0x01b7:
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01f1 }
            boolean r9 = r8.zzl     // Catch:{ all -> 0x01f1 }
            if (r9 != 0) goto L_0x01c9
            com.google.android.gms.internal.ads.zzayx r9 = r8.zzY     // Catch:{ all -> 0x01f1 }
            com.google.android.gms.internal.ads.zzayz r10 = com.google.android.gms.internal.ads.zzayz.BANNER_SIZE_INVALID     // Catch:{ all -> 0x01f1 }
            r9.zzb(r10)     // Catch:{ all -> 0x01f1 }
            r8.zzl = r5     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x01c9:
            monitor-exit(r8)
            return
        L_0x01cb:
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01f1 }
            if (r9 == r0) goto L_0x01d4
            r8.setVisibility(r1)     // Catch:{ all -> 0x01f1 }
        L_0x01d4:
            boolean r9 = r8.zzm     // Catch:{ all -> 0x01f1 }
            if (r9 != 0) goto L_0x01e1
            com.google.android.gms.internal.ads.zzayx r9 = r8.zzY     // Catch:{ all -> 0x01f1 }
            com.google.android.gms.internal.ads.zzayz r10 = com.google.android.gms.internal.ads.zzayz.BANNER_SIZE_VALID     // Catch:{ all -> 0x01f1 }
            r9.zzb(r10)     // Catch:{ all -> 0x01f1 }
            r8.zzm = r5     // Catch:{ all -> 0x01f1 }
        L_0x01e1:
            com.google.android.gms.internal.ads.zzcoh r9 = r8.zzq     // Catch:{ all -> 0x01f1 }
            int r10 = r9.zzb     // Catch:{ all -> 0x01f1 }
            int r9 = r9.zza     // Catch:{ all -> 0x01f1 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x01ec:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01f1 }
            monitor-exit(r8)
            return
        L_0x01f1:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnk.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!zzX()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzcgs.zzg("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!zzX()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzcgs.zzg("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzn.zzd() || this.zzn.zze()) {
            zzfb zzfb = this.zzc;
            if (zzfb != null) {
                zzfb.zzd(motionEvent);
            }
            zzbkm zzbkm = this.zzd;
            if (zzbkm != null) {
                zzbkm.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                zzblu zzblu = this.zzC;
                if (zzblu != null) {
                    zzblu.zzb(motionEvent);
                }
            }
        }
        if (zzX()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzL = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcmy) {
            this.zzn = (zzcmy) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!zzX()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzcgs.zzg("Could not stop loading webview.", e);
            }
        }
    }

    public final synchronized void zzA() {
        zzblr zzblr = this.zzD;
        if (zzblr != null) {
            zzblr.zza();
        }
    }

    public final void zzB(int i) {
        this.zzN = i;
    }

    public final void zzC(int i) {
        this.zzO = i;
    }

    public final int zzD() {
        return this.zzN;
    }

    public final int zzE() {
        return this.zzO;
    }

    public final zzeye zzF() {
        return this.zzj;
    }

    public final WebView zzG() {
        return this;
    }

    public final View zzH() {
        return this;
    }

    public final void zzI() {
        zzaW();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zze.zza);
        zze("onhide", hashMap);
    }

    public final void zzJ(int i) {
        if (i == 0) {
            zzbju.zza(this.zzK.zzc(), this.zzI, "aebb2");
        }
        zzaW();
        this.zzK.zzc();
        this.zzK.zzc().zzd("close_type", String.valueOf(i));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zze.zza);
        zze("onhide", hashMap);
    }

    public final void zzK() {
        if (this.zzH == null) {
            zzbju.zza(this.zzK.zzc(), this.zzI, "aes2");
            this.zzK.zzc();
            zzbjz zzf2 = zzbkc.zzf();
            this.zzH = zzf2;
            this.zzK.zza("native:view_show", zzf2);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zze.zza);
        zze("onshow", hashMap);
    }

    public final void zzL() {
        throw null;
    }

    public final Context zzM() {
        return this.zzb.zzb();
    }

    public final synchronized zzl zzN() {
        return this.zzo;
    }

    public final synchronized zzl zzO() {
        return this.zzP;
    }

    public final synchronized zzcoh zzP() {
        return this.zzq;
    }

    public final synchronized String zzQ() {
        return this.zzr;
    }

    public final /* bridge */ /* synthetic */ zzcof zzR() {
        return this.zzn;
    }

    public final WebViewClient zzS() {
        return this.zzn;
    }

    public final synchronized boolean zzT() {
        return this.zzs;
    }

    public final zzfb zzU() {
        return this.zzc;
    }

    public final synchronized IObjectWrapper zzV() {
        return this.zzp;
    }

    public final synchronized boolean zzW() {
        return this.zzu;
    }

    public final synchronized boolean zzX() {
        return this.zzt;
    }

    public final synchronized void zzY() {
        zze.zza("Destroying WebView!");
        zzba();
        zzr.zza.post(new zzcnj(this));
    }

    public final synchronized boolean zzZ() {
        return this.zzx;
    }

    public final void zza(String str) {
        throw null;
    }

    public final boolean zzaA() {
        return false;
    }

    public final zzeyh zzaB() {
        return this.zzk;
    }

    public final void zzaC(zzeye zzeye, zzeyh zzeyh) {
        this.zzj = zzeye;
        this.zzk = zzeyh;
    }

    public final synchronized void zzaD(boolean z) {
        if (z) {
            setBackgroundColor(0);
        }
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzu(z);
        }
    }

    public final zzfqn<String> zzaE() {
        return this.zzd.zzb();
    }

    public final void zzaF(zzc zzc2) {
        this.zzn.zzm(zzc2);
    }

    public final void zzaG(boolean z, int i) {
        this.zzn.zzo(z, i);
    }

    public final void zzaH(boolean z, int i, String str) {
        this.zzn.zzp(z, i, str);
    }

    public final void zzaI(boolean z, int i, String str, String str2) {
        this.zzn.zzq(z, i, str, str2);
    }

    public final void zzaJ(zzbs zzbs, zzedb zzedb, zzduu zzduu, zzfdh zzfdh, String str, String str2, int i) {
        this.zzn.zzn(zzbs, zzedb, zzduu, zzfdh, str, str2, i);
    }

    public final boolean zzaK() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzn.zzc() && !this.zzn.zzd()) {
            return false;
        }
        zzbev.zza();
        DisplayMetrics displayMetrics = this.zzh;
        int zzq2 = zzcgl.zzq(displayMetrics, displayMetrics.widthPixels);
        zzbev.zza();
        DisplayMetrics displayMetrics2 = this.zzh;
        int zzq3 = zzcgl.zzq(displayMetrics2, displayMetrics2.heightPixels);
        Activity zza2 = this.zzb.zza();
        if (zza2 == null || zza2.getWindow() == null) {
            i2 = zzq2;
            i = zzq3;
        } else {
            zzs.zzc();
            int[] zzT2 = zzr.zzT(zza2);
            zzbev.zza();
            int zzq4 = zzcgl.zzq(this.zzh, zzT2[0]);
            zzbev.zza();
            i = zzcgl.zzq(this.zzh, zzT2[1]);
            i2 = zzq4;
        }
        int i3 = this.zzT;
        if (i3 == zzq2 && this.zzS == zzq3 && this.zzU == i2 && this.zzV == i) {
            return false;
        }
        if (!(i3 == zzq2 && this.zzS == zzq3)) {
            z = true;
        }
        this.zzT = zzq2;
        this.zzS = zzq3;
        this.zzU = i2;
        this.zzV = i;
        new zzbyq(this, "").zzk(zzq2, zzq3, i2, i, this.zzh.density, this.zzX.getDefaultDisplay().getRotation());
        return z;
    }

    public final synchronized void zzaL(String str) {
        if (!zzX()) {
            loadUrl(str);
        } else {
            zzcgs.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @TargetApi(19)
    public final synchronized void zzaM(String str, ValueCallback<String> valueCallback) {
        if (!zzX()) {
            evaluateJavascript(str, (ValueCallback<String>) null);
        } else {
            zzcgs.zzi("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzaN(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzaP() == null) {
                zzaV();
            }
            if (zzaP().booleanValue()) {
                zzaM(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzaL(valueOf.length() != 0 ? SingleQuestionFragment.JS_inlineScriptTag.concat(valueOf) : new String(SingleQuestionFragment.JS_inlineScriptTag));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzaL(valueOf2.length() != 0 ? SingleQuestionFragment.JS_inlineScriptTag.concat(valueOf2) : new String(SingleQuestionFragment.JS_inlineScriptTag));
    }

    @VisibleForTesting
    public final void zzaO(Boolean bool) {
        synchronized (this) {
            this.zzw = bool;
        }
        zzs.zzg().zzb(bool);
    }

    @VisibleForTesting
    public final synchronized Boolean zzaP() {
        return this.zzw;
    }

    public final zzcmy zzaQ() {
        return this.zzn;
    }

    public final synchronized boolean zzaa() {
        return this.zzF > 0;
    }

    public final void zzab(String str, zzbps<? super zzcmr> zzbps) {
        zzcmy zzcmy = this.zzn;
        if (zzcmy != null) {
            zzcmy.zzs(str, zzbps);
        }
    }

    public final void zzac(String str, zzbps<? super zzcmr> zzbps) {
        zzcmy zzcmy = this.zzn;
        if (zzcmy != null) {
            zzcmy.zzt(str, zzbps);
        }
    }

    public final void zzad(String str, Predicate<zzbps<? super zzcmr>> predicate) {
        zzcmy zzcmy = this.zzn;
        if (zzcmy != null) {
            zzcmy.zzu(str, predicate);
        }
    }

    public final synchronized void zzae(zzl zzl2) {
        this.zzo = zzl2;
    }

    public final synchronized void zzaf(zzcoh zzcoh) {
        this.zzq = zzcoh;
        requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzag(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzu     // Catch:{ all -> 0x003a }
            r2.zzu = r3     // Catch:{ all -> 0x003a }
            r2.zzaX()     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzL     // Catch:{ all -> 0x003a }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x003a }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzcoh r0 = r2.zzq     // Catch:{ all -> 0x003a }
            boolean r0 = r0.zzg()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0038
        L_0x0024:
            com.google.android.gms.internal.ads.zzbyq r0 = new com.google.android.gms.internal.ads.zzbyq     // Catch:{ all -> 0x003a }
            java.lang.String r1 = ""
            r0.<init>(r2, r1)     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r1 == r3) goto L_0x0031
            java.lang.String r3 = "default"
            goto L_0x0033
        L_0x0031:
            java.lang.String r3 = "expanded"
        L_0x0033:
            r0.zzj(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return
        L_0x0038:
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnk.zzag(boolean):void");
    }

    public final void zzah() {
        this.zzR.zzb();
    }

    public final void zzai(Context context) {
        this.zzb.setBaseContext(context);
        this.zzR.zza(this.zzb.zza());
    }

    public final synchronized void zzaj(boolean z) {
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzt(this.zzn.zzc(), z);
        } else {
            this.zzs = z;
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) {
        this.zzp = iObjectWrapper;
    }

    public final synchronized void zzal(int i) {
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzw(i);
        }
    }

    public final synchronized void zzam(zzl zzl2) {
        this.zzP = zzl2;
    }

    public final synchronized void zzan(boolean z) {
        this.zzx = z;
    }

    public final void zzao() {
        if (this.zzJ == null) {
            this.zzK.zzc();
            zzbjz zzf2 = zzbkc.zzf();
            this.zzJ = zzf2;
            this.zzK.zza("native:view_load", zzf2);
        }
    }

    public final synchronized void zzap(zzblu zzblu) {
        this.zzC = zzblu;
    }

    public final synchronized zzblu zzaq() {
        return this.zzC;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzar(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.zzF     // Catch:{ all -> 0x0017 }
            r1 = 1
            if (r1 == r3) goto L_0x0007
            r1 = -1
        L_0x0007:
            int r0 = r0 + r1
            r2.zzF = r0     // Catch:{ all -> 0x0017 }
            if (r0 > 0) goto L_0x0015
            com.google.android.gms.ads.internal.overlay.zzl r3 = r2.zzo     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            r3.zzE()     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return
        L_0x0015:
            monitor-exit(r2)
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnk.zzar(boolean):void");
    }

    public final void zzas() {
        setBackgroundColor(0);
    }

    public final synchronized void zzat(String str, String str2, @Nullable String str3) {
        String str4;
        if (!zzX()) {
            String[] strArr = new String[1];
            String str5 = (String) zzbex.zzc().zzb(zzbjn.zzK);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", str5);
                jSONObject.put("sdk", "Google Mobile Ads");
                jSONObject.put("sdkVersion", "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException e) {
                zzcgs.zzj("Unable to build MRAID_ENV", e);
                str4 = null;
            }
            strArr[0] = str4;
            super.loadDataWithBaseURL(str, zzcny.zza(str2, strArr), "text/html", "UTF-8", (String) null);
            return;
        }
        zzcgs.zzi("#004 The webview is destroyed. Ignoring action.");
    }

    public final void zzau() {
        throw null;
    }

    public final void zzav(boolean z) {
        this.zzn.zzB(z);
    }

    public final synchronized void zzaw(zzblr zzblr) {
        this.zzD = zzblr;
    }

    public final synchronized void zzax(zzaxm zzaxm) {
        this.zzE = zzaxm;
    }

    public final synchronized zzaxm zzay() {
        return this.zzE;
    }

    public final boolean zzaz(boolean z, int i) {
        destroy();
        this.zzY.zzc(new zzcnh(z, i));
        this.zzY.zzb(zzayz.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final void zzb(String str, String str2) {
        zzaN(GeneratedOutlineSupport.outline20(new StringBuilder(str.length() + 3 + String.valueOf(str2).length()), str, "(", str2, ");"));
    }

    public final synchronized void zzbB() {
        com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
        if (zzl2 != null) {
            zzl2.zzbB();
        }
    }

    public final synchronized void zzbC() {
        com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
        if (zzl2 != null) {
            zzl2.zzbC();
        }
    }

    public final void zzc(zzavy zzavy) {
        synchronized (this) {
            this.zzA = zzavy.zzj;
        }
        zzbd(zzavy.zzj);
    }

    public final void zzd(String str, JSONObject jSONObject) {
        String str2;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        if (valueOf.length() != 0) {
            str2 = "Dispatching AFMA event: ".concat(valueOf);
        } else {
            str2 = new String("Dispatching AFMA event: ");
        }
        zzcgs.zzd(str2);
        zzaN(sb.toString());
    }

    public final void zze(String str, Map<String, ?> map) {
        try {
            zzd(str, zzs.zzc().zzf(map));
        } catch (JSONException unused) {
            zzcgs.zzi("Could not convert parameters to JSON.");
        }
    }

    public final zzcio zzf() {
        return null;
    }

    public final void zzg(boolean z) {
        this.zzn.zzz(false);
    }

    public final synchronized zzcnn zzh() {
        return this.zzz;
    }

    public final zzbjz zzi() {
        return this.zzI;
    }

    @Nullable
    public final Activity zzj() {
        return this.zzb.zza();
    }

    public final zza zzk() {
        return this.zzg;
    }

    public final void zzl() {
        zzl zzN2 = zzN();
        if (zzN2 != null) {
            zzN2.zzD();
        }
    }

    public final synchronized String zzm() {
        return this.zzy;
    }

    public final synchronized String zzn() {
        zzeyh zzeyh = this.zzk;
        if (zzeyh == null) {
            return null;
        }
        return zzeyh.zzb;
    }

    public final synchronized void zzo(int i) {
        this.zzM = i;
    }

    public final synchronized int zzp() {
        return this.zzM;
    }

    public final zzbka zzq() {
        return this.zzK;
    }

    public final void zzr(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    public final synchronized zzckx zzs(String str) {
        Map<String, zzckx> map = this.zzW;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final zzcgy zzt() {
        return this.zze;
    }

    public final synchronized void zzu(String str, zzckx zzckx) {
        if (this.zzW == null) {
            this.zzW = new HashMap();
        }
        this.zzW.put(str, zzckx);
    }

    public final void zzv(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        hashMap.put("duration", Long.toString(j));
        zze("onCacheAccessComplete", hashMap);
    }

    public final void zzw(int i) {
    }

    public final synchronized void zzx(zzcnn zzcnn) {
        if (this.zzz != null) {
            zzcgs.zzf("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzz = zzcnn;
        }
    }

    public final int zzy() {
        return getMeasuredHeight();
    }

    public final int zzz() {
        return getMeasuredWidth();
    }
}
