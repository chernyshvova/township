package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Utility;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcas implements zzcau {
    @VisibleForTesting
    public static zzcau zza;
    @VisibleForTesting
    public static zzcau zzb;
    public static final Object zzc = new Object();
    public final Object zzd = new Object();
    public final Context zze;
    public final WeakHashMap<Thread, Boolean> zzf = new WeakHashMap<>();
    public final ExecutorService zzg;
    public final zzcgy zzh;

    public zzcas(Context context, zzcgy zzcgy) {
        zzfji.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zze = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzh = zzcgy;
    }

    public static zzcau zza(Context context) {
        synchronized (zzc) {
            if (zza == null) {
                if (zzblh.zze.zze().booleanValue()) {
                    if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfl)).booleanValue()) {
                        zza = new zzcas(context, zzcgy.zza());
                    }
                }
                zza = new zzcat();
            }
        }
        return zza;
    }

    public static zzcau zzb(Context context, zzcgy zzcgy) {
        synchronized (zzc) {
            if (zzb == null) {
                if (zzblh.zze.zze().booleanValue()) {
                    if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfl)).booleanValue()) {
                        zzcas zzcas = new zzcas(context, zzcgy);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzcas.zzd) {
                                zzcas.zzf.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzcar(zzcas, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzcaq(zzcas, Thread.getDefaultUncaughtExceptionHandler()));
                        zzb = zzcas;
                    }
                }
                zzb = new zzcat();
            }
        }
        return zzb;
    }

    public final void zzc(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z |= zzcgl.zzi(stackTraceElement.getClassName());
                    z2 |= zzcas.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z && !z2) {
                zze(th, "", 1.0f);
            }
        }
    }

    public final void zzd(Throwable th, String str) {
        zze(th, str, 1.0f);
    }

    public final void zze(Throwable th, String str, float f) {
        boolean z;
        String str2;
        if (zzcgl.zzg(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzgcg.zzc(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            double d = (double) f;
            double random = Math.random();
            int i = f > 0.0f ? (int) (1.0f / f) : 1;
            if (random < d) {
                ArrayList arrayList = new ArrayList();
                try {
                    z = Wrappers.packageManager(this.zze).isCallerInstantApp();
                } catch (Throwable th2) {
                    zzcgs.zzg("Error fetching instant app info", th2);
                    z = false;
                }
                try {
                    str2 = this.zze.getPackageName();
                } catch (Throwable unused) {
                    zzcgs.zzi("Cannot obtain package name, proceeding.");
                    str2 = "unknown";
                }
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme(Utility.URL_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str3 = Build.MANUFACTURER;
                String str4 = Build.MODEL;
                if (!str4.startsWith(str3)) {
                    str4 = GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str3).length() + 1 + str4.length()), str3, " ", str4);
                }
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter(DeviceRequestsHelper.DEVICE_INFO_DEVICE, str4).appendQueryParameter("js", this.zzh.zza).appendQueryParameter(AppsFlyerProperties.APP_ID, str2).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", stringWriter2).appendQueryParameter("eids", TextUtils.join(",", zzbjn.zzc())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "386087985").appendQueryParameter(AnalyticsEventKey.SMART_INTENT_SEARCH_RESULT_COUNT, "dev").appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzblh.zzc.zze()));
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaV)).booleanValue()) {
                    appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze))).appendQueryParameter("lite", true != this.zzh.zze ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                arrayList.add(appendQueryParameter2.toString());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.zzg.execute(new zzcap(new zzcgx((String) null), (String) it.next()));
                }
            }
        }
    }
}
