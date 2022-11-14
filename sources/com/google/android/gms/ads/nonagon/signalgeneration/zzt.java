package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcag;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcfs;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzdao;
import com.google.android.gms.internal.ads.zzdgh;
import com.google.android.gms.internal.ads.zzdqu;
import com.google.android.gms.internal.ads.zzdut;
import com.google.android.gms.internal.ads.zzduu;
import com.google.android.gms.internal.ads.zzeyv;
import com.google.android.gms.internal.ads.zzezo;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzfc;
import com.google.android.gms.internal.ads.zzfdg;
import com.google.android.gms.internal.ads.zzfdh;
import com.google.android.gms.internal.ads.zzfpv;
import com.google.android.gms.internal.ads.zzfqe;
import com.google.android.gms.internal.ads.zzfqn;
import com.google.android.gms.internal.ads.zzfqo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzt extends zzcfn {
    public static final List<String> zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click"}));
    public static final List<String> zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    public static final List<String> zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion"}));
    public static final List<String> zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    public final zzcop zzf;
    public Context zzg;
    public final zzfb zzh;
    public final zzezo<zzdqu> zzi;
    public final zzfqo zzj;
    public final ScheduledExecutorService zzk;
    @Nullable
    public zzcan zzl;
    public Point zzm = new Point();
    public Point zzn = new Point();
    public final Set<WebView> zzo = Collections.newSetFromMap(new WeakHashMap());
    public final zzb zzp;
    public final zzduu zzq;
    public final zzfdh zzr;

    public zzt(zzcop zzcop, Context context, zzfb zzfb, zzezo<zzdqu> zzezo, zzfqo zzfqo, ScheduledExecutorService scheduledExecutorService, zzduu zzduu, zzfdh zzfdh) {
        this.zzf = zzcop;
        this.zzg = context;
        this.zzh = zzfb;
        this.zzi = zzezo;
        this.zzj = zzfqo;
        this.zzk = scheduledExecutorService;
        this.zzp = zzcop.zzw();
        this.zzq = zzduu;
        this.zzr = zzfdh;
    }

    @VisibleForTesting
    public static boolean zzc(@NonNull Uri uri) {
        return zzt(uri, zzc, zzd);
    }

    public static /* synthetic */ void zzp(zzt zzt, String str, String str2, String str3) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfi)).booleanValue()) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
                zzfdh zzfdh = zzt.zzr;
                zzfdg zza2 = zzfdg.zza(str);
                zza2.zzc(str2, str3);
                zzfdh.zza(zza2);
                return;
            }
            zzdut zza3 = zzt.zzq.zza();
            zza3.zzc("action", str);
            zza3.zzc(str2, str3);
            zza3.zzd();
        }
    }

    public static final /* synthetic */ Uri zzr(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzw(uri, "nas", str) : uri;
    }

    public static final /* synthetic */ ArrayList zzs(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzc(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzw(uri, "nas", str));
            }
        }
        return arrayList;
    }

    public static boolean zzt(@NonNull Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String contains : list) {
                if (path.contains(contains)) {
                    for (String endsWith : list2) {
                        if (host.endsWith(endsWith)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final zzfqn<String> zzu(String str) {
        zzdqu[] zzdquArr = new zzdqu[1];
        zzfqn<O> zzi2 = zzfqe.zzi(this.zzi.zzb(), new zzo(this, zzdquArr, str), this.zzj);
        zzi2.zze(new zzp(this, zzdquArr), this.zzj);
        return zzfqe.zzf(zzfqe.zzj((zzfpv) zzfqe.zzh(zzfpv.zzw(zzi2), (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzfk)).intValue(), TimeUnit.MILLISECONDS, this.zzk), zzm.zza, this.zzj), Exception.class, zzn.zza, this.zzj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzv() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzcan r0 = r1.zzl
            if (r0 == 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzt.zzv():boolean");
    }

    public static final Uri zzw(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        StringBuilder sb = new StringBuilder(uri2.substring(0, i));
        GeneratedOutlineSupport.outline34(sb, str, "=", str2, "&");
        sb.append(uri2.substring(i));
        return Uri.parse(sb.toString());
    }

    public final /* synthetic */ void zzd(zzdqu[] zzdquArr) {
        zzdqu zzdqu = zzdquArr[0];
        if (zzdqu != null) {
            this.zzi.zzc(zzfqe.zza(zzdqu));
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcfs zzcfs, zzcfl zzcfl) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        String str = zzcfs.zza;
        String str2 = zzcfs.zzb;
        zzbdp zzbdp = zzcfs.zzc;
        zzbdk zzbdk = zzcfs.zzd;
        zze zzu = this.zzf.zzu();
        zzdao zzdao = new zzdao();
        zzdao.zza(context);
        zzeyv zzeyv = new zzeyv();
        if (str == null) {
            str = "adUnitId";
        }
        zzeyv.zzf(str);
        if (zzbdk == null) {
            zzbdk = new zzbdl().zza();
        }
        zzeyv.zza(zzbdk);
        if (zzbdp == null) {
            zzbdp = new zzbdp();
        }
        zzeyv.zzc(zzbdp);
        zzdao.zzb(zzeyv.zzu());
        zzu.zzc(zzdao.zzd());
        zzw zzw = new zzw();
        zzw.zza(str2);
        zzu.zzb(new zzx(zzw, (zzv) null));
        new zzdgh();
        zzfqe.zzp(zzu.zza().zza(), new zzq(this, zzcfl), this.zzf.zze());
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfj)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzcan zzcan = this.zzl;
            if (zzcan == null) {
                view = null;
            } else {
                view = zzcan.zza;
            }
            this.zzm = zzby.zzh(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzn = this.zzm;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzm;
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzg(List<Uri> list, IObjectWrapper iObjectWrapper, zzcag zzcag) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfj)).booleanValue()) {
            try {
                zzcag.zzf("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzcgs.zzg("", e);
            }
        } else {
            zzfqn zzb2 = this.zzj.zzb(new zzg(this, list, iObjectWrapper));
            if (zzv()) {
                zzb2 = zzfqe.zzi(zzb2, new zzh(this), this.zzj);
            } else {
                zzcgs.zzh("Asset view map is empty.");
            }
            zzfqe.zzp(zzb2, new zzr(this, zzcag), this.zzf.zze());
        }
    }

    public final void zzh(List<Uri> list, IObjectWrapper iObjectWrapper, zzcag zzcag) {
        try {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfj)).booleanValue()) {
                zzcag.zzf("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzcag.zzf("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zzt(uri, zza, zzb)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzcgs.zzi(sb.toString());
                    zzcag.zze(list);
                    return;
                }
                zzfqn zzb2 = this.zzj.zzb(new zzi(this, uri, iObjectWrapper));
                if (zzv()) {
                    zzb2 = zzfqe.zzi(zzb2, new zzj(this), this.zzj);
                } else {
                    zzcgs.zzh("Asset view map is empty.");
                }
                zzfqe.zzp(zzb2, new zzs(this, zzcag), this.zzf.zze());
            }
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void zzi(zzcan zzcan) {
        this.zzl = zzcan;
        this.zzi.zza(1);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgt)).booleanValue()) {
            if (Build.VERSION.SDK_INT < 21) {
                zzcgs.zzi("Not registering the webview because the Android API level is lower than Lollopop which has security risks on webviews.");
                return;
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzcgs.zzf("The webView cannot be null.");
            } else if (this.zzo.contains(webView)) {
                zzcgs.zzh("This webview has already been registered.");
            } else {
                this.zzo.add(webView);
                webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh), "gmaSdk");
            }
        }
    }

    public final /* synthetic */ zzfqn zzk(zzdqu[] zzdquArr, String str, zzdqu zzdqu) throws Exception {
        zzdquArr[0] = zzdqu;
        Context context = this.zzg;
        zzcan zzcan = this.zzl;
        Map<String, WeakReference<View>> map = zzcan.zzb;
        JSONObject zze2 = zzby.zze(context, map, map, zzcan.zza);
        JSONObject zzb2 = zzby.zzb(this.zzg, this.zzl.zza);
        JSONObject zzc2 = zzby.zzc(this.zzl.zza);
        JSONObject zzd2 = zzby.zzd(this.zzg, this.zzl.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zze2);
        jSONObject.put("ad_view_signal", zzb2);
        jSONObject.put("scroll_view_signal", zzc2);
        jSONObject.put("lock_screen_signal", zzd2);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzby.zzf((String) null, this.zzg, this.zzn, this.zzm));
        }
        return zzdqu.zzc(str, jSONObject);
    }

    public final /* synthetic */ zzfqn zzl(Uri uri) throws Exception {
        return zzfqe.zzj(zzu("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzl(this, uri), this.zzj);
    }

    public final /* synthetic */ Uri zzm(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzh.zze(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzfc e) {
            zzcgs.zzj("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    public final /* synthetic */ zzfqn zzn(ArrayList arrayList) throws Exception {
        return zzfqe.zzj(zzu("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzk(this, arrayList), this.zzj);
    }

    public final /* synthetic */ ArrayList zzo(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zzi2 = this.zzh.zzb() != null ? this.zzh.zzb().zzi(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zzi2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzc(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzcgs.zzi(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzw(uri, "ms", zzi2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }
}
