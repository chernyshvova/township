package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.browser.customtabs.CustomTabsIntent;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.impl.C1620R;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzcby;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfqe;
import com.google.android.gms.internal.ads.zzfqn;
import com.google.android.gms.internal.ads.zzgjv;
import com.swrve.sdk.rest.RESTClient;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzr {
    public static final zzfjj zza = new zzf(Looper.getMainLooper());
    @GuardedBy("AdUtil.class")
    public static boolean zzd = false;
    public final AtomicReference<Pattern> zzb = new AtomicReference<>((Object) null);
    public final AtomicReference<Pattern> zzc = new AtomicReference<>((Object) null);
    public boolean zze = true;
    public final Object zzf = new Object();
    @GuardedBy("userAgentLock")
    public String zzg;
    public boolean zzh = false;
    public boolean zzi = false;
    public final Executor zzj = Executors.newSingleThreadExecutor();

    public static final long zzA(View view) {
        float f;
        int i;
        float f2 = Float.MAX_VALUE;
        Object obj = view;
        do {
            f = 0.0f;
            if (!(obj instanceof View)) {
                break;
            }
            View view2 = (View) obj;
            f2 = Math.min(f2, view2.getAlpha());
            i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            obj = view2.getParent();
        } while (i > 0);
        if (f2 >= 0.0f) {
            f = f2;
        }
        return (long) Math.round(f * 100.0f);
    }

    @Nullable
    public static final WebResourceResponse zzB(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(GraphRequest.USER_AGENT_HEADER, zzs.zzc().zze(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzbp(context).zzb(0, str2, hashMap, (byte[]) null).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzcgs.zzj("Could not fetch MRAID JS.", e);
        }
        return null;
    }

    public static final String zzC() {
        Resources zzf2 = zzs.zzg().zzf();
        return zzf2 != null ? zzf2.getString(C1620R.string.f2772s7) : "Test Ad";
    }

    public static final zzbs zzD(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzcgs.zzf("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbs) {
                return (zzbs) queryLocalInterface;
            }
            return new zzbq(iBinder);
        } catch (Exception e) {
            zzs.zzg().zzg(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean zzE(Context context, String str) {
        Context zza2 = zzcby.zza(context);
        return Wrappers.packageManager(zza2).checkPermission(str, zza2.getPackageName()) == 0;
    }

    public static final boolean zzF(String str) {
        if (!zzcgr.zzj()) {
            return false;
        }
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdk)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzbex.zzc().zzb(zzbjn.zzdm);
        if (!str2.isEmpty()) {
            for (String equals : str2.split(";")) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str3 = (String) zzbex.zzc().zzb(zzbjn.zzdl);
        if (str3.isEmpty()) {
            return true;
        }
        for (String equals2 : str3.split(";")) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(16)
    public static final boolean zzG(Context context) {
        KeyguardManager zzad;
        if (context == null || !PlatformVersion.isAtLeastJellyBean() || (zzad = zzad(context)) == null || !zzad.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    public static final boolean zzH(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzcgs.zzg("Error loading class.", th);
            zzs.zzg().zzg(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzI(Context context) {
        boolean z;
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfN)).booleanValue()) {
                synchronized (zzr.class) {
                    z = zzd;
                }
                return z;
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static final boolean zzJ(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (Process.myPid() == next.pid) {
                            if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                return true;
                            }
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager == null) {
                                return true;
                            }
                            if (powerManager.isScreenOn()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzK(Context context) {
        Bundle zzag = zzag(context);
        return TextUtils.isEmpty(zzaf(zzag)) && !TextUtils.isEmpty(zzag.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
    }

    public static final boolean zzL(Context context) {
        Window window;
        if (!(!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null)) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r10 = ((com.google.android.gms.internal.ads.zzcno) r0).zzaB();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void zzM(android.view.View r16, int r17, android.view.MotionEvent r18) {
        /*
            r0 = r16
            r1 = 2
            int[] r2 = new int[r1]
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdsi     // Catch:{ Exception -> 0x00d7 }
            r5 = 0
            if (r4 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzdsi r0 = (com.google.android.gms.internal.ads.zzdsi) r0     // Catch:{ Exception -> 0x00d7 }
            android.view.View r0 = r0.getChildAt(r5)     // Catch:{ Exception -> 0x00d7 }
        L_0x0015:
            boolean r4 = r0.getLocalVisibleRect(r3)     // Catch:{ Exception -> 0x00d7 }
            if (r4 == 0) goto L_0x0024
            int r4 = r3.width()     // Catch:{ Exception -> 0x00d7 }
            int r3 = r3.height()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0026
        L_0x0024:
            r3 = 0
            r4 = 0
        L_0x0026:
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ Exception -> 0x00d7 }
            long r6 = zzA(r0)     // Catch:{ Exception -> 0x00d7 }
            r0.getLocationOnScreen(r2)     // Catch:{ Exception -> 0x00d7 }
            r8 = r2[r5]     // Catch:{ Exception -> 0x00d7 }
            r9 = 1
            r2 = r2[r9]     // Catch:{ Exception -> 0x00d7 }
            boolean r10 = r0 instanceof com.google.android.gms.internal.ads.zzcno     // Catch:{ Exception -> 0x00d7 }
            if (r10 == 0) goto L_0x0045
            r10 = r0
            com.google.android.gms.internal.ads.zzcno r10 = (com.google.android.gms.internal.ads.zzcno) r10     // Catch:{ Exception -> 0x00d7 }
            com.google.android.gms.internal.ads.zzeyh r10 = r10.zzaB()     // Catch:{ Exception -> 0x00d7 }
            if (r10 == 0) goto L_0x0045
            java.lang.String r10 = r10.zzb     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0047
        L_0x0045:
            java.lang.String r10 = "none"
        L_0x0047:
            boolean r11 = r0 instanceof com.google.android.gms.internal.ads.zzcmi     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r12 = "UNKNOWN"
            if (r11 == 0) goto L_0x005f
            r11 = r0
            com.google.android.gms.internal.ads.zzcmi r11 = (com.google.android.gms.internal.ads.zzcmi) r11     // Catch:{ Exception -> 0x00d7 }
            com.google.android.gms.internal.ads.zzeye r11 = r11.zzF()     // Catch:{ Exception -> 0x00d7 }
            if (r11 == 0) goto L_0x005f
            int r12 = r11.zzb     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r12 = com.google.android.gms.internal.ads.zzeye.zza(r12)     // Catch:{ Exception -> 0x00d7 }
            int r11 = r11.zzf     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0060
        L_0x005f:
            r11 = 0
        L_0x0060:
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ Exception -> 0x00d7 }
            r14 = 13
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x00d7 }
            int r15 = r0.getId()     // Catch:{ Exception -> 0x00d7 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x00d7 }
            r14[r5] = r15     // Catch:{ Exception -> 0x00d7 }
            r14[r9] = r10     // Catch:{ Exception -> 0x00d7 }
            r14[r1] = r12     // Catch:{ Exception -> 0x00d7 }
            r5 = 3
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x00d7 }
            r14[r5] = r9     // Catch:{ Exception -> 0x00d7 }
            r5 = 4
            java.lang.Class r9 = r0.getClass()     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r9 = r9.getName()     // Catch:{ Exception -> 0x00d7 }
            r14[r5] = r9     // Catch:{ Exception -> 0x00d7 }
            r5 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00d7 }
            r14[r5] = r8     // Catch:{ Exception -> 0x00d7 }
            r5 = 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d7 }
            r14[r5] = r2     // Catch:{ Exception -> 0x00d7 }
            r2 = 7
            int r5 = r0.getWidth()     // Catch:{ Exception -> 0x00d7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
            r14[r2] = r5     // Catch:{ Exception -> 0x00d7 }
            r2 = 8
            int r0 = r0.getHeight()     // Catch:{ Exception -> 0x00d7 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d7 }
            r14[r2] = r0     // Catch:{ Exception -> 0x00d7 }
            r0 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00d7 }
            r14[r0] = r2     // Catch:{ Exception -> 0x00d7 }
            r0 = 10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00d7 }
            r14[r0] = r2     // Catch:{ Exception -> 0x00d7 }
            r0 = 11
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00d7 }
            r14[r0] = r2     // Catch:{ Exception -> 0x00d7 }
            r0 = 12
            r2 = r17
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)     // Catch:{ Exception -> 0x00d7 }
            r14[r0] = r1     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = "<Ad viewId=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>"
            java.lang.String r0 = java.lang.String.format(r13, r0, r14)     // Catch:{ Exception -> 0x00d7 }
            com.google.android.gms.internal.ads.zzcgs.zzh(r0)     // Catch:{ Exception -> 0x00d7 }
            return
        L_0x00d7:
            r0 = move-exception
            java.lang.String r1 = "Failure getting view location."
            com.google.android.gms.internal.ads.zzcgs.zzg(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zzM(android.view.View, int, android.view.MotionEvent):void");
    }

    public static final void zzN(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            new zzbz(context, str, (String) it.next()).zzb();
        }
    }

    public static final void zzO(Context context, Throwable th) {
        if (context != null) {
            try {
                if (zzblh.zzb.zze().booleanValue()) {
                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static final void zzP(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
    }

    public static final int zzQ(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzcgs.zzi(sb.toString());
            return 0;
        }
    }

    public static final Map<String, String> zzR(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, uri.getQueryParameter(next));
            }
        }
        return hashMap;
    }

    public static final WebResourceResponse zzS(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        zzs.zzc();
        String contentType = httpURLConnection.getContentType();
        String str2 = "";
        if (TextUtils.isEmpty(contentType)) {
            str = str2;
        } else {
            str = contentType.split(";")[0].trim();
        }
        zzs.zzc();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str2 = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        String str3 = str2;
        Map headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry entry : headerFields.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null || ((List) entry.getValue()).size() <= 0)) {
                hashMap.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return zzs.zze().zzn(str, str3, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static final int[] zzT(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzz();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    @VisibleForTesting
    public static final String zzU(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzw();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] zzV(android.app.Activity r6) {
        /*
            android.view.Window r0 = r6.getWindow()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0021
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r4)
            if (r0 == 0) goto L_0x0021
            int[] r4 = new int[r1]
            int r5 = r0.getTop()
            r4[r3] = r5
            int r0 = r0.getBottom()
            r4[r2] = r0
            goto L_0x0025
        L_0x0021:
            int[] r4 = zzz()
        L_0x0025:
            int[] r0 = new int[r1]
            com.google.android.gms.internal.ads.zzcgl r1 = com.google.android.gms.internal.ads.zzbev.zza()
            r5 = r4[r3]
            int r1 = r1.zza(r6, r5)
            r0[r3] = r1
            com.google.android.gms.internal.ads.zzcgl r1 = com.google.android.gms.internal.ads.zzbev.zza()
            r3 = r4[r2]
            int r6 = r1.zza(r6, r3)
            r0[r2] = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zzV(android.app.Activity):int[]");
    }

    public static final boolean zzW(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = zzs.zzc().zze || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzt(view);
        long zzA = zzA(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z)) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzaP)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgC)).booleanValue()) {
                    return true;
                }
                if (zzA < ((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzgE)).intValue())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @TargetApi(18)
    public static final void zzX(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzu(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzcgs.zzd(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzcgs.zzg("No browser is found.", e);
        }
    }

    public static final int[] zzY(Activity activity) {
        int[] zzT = zzT(activity);
        return new int[]{zzbev.zza().zza(activity, zzT[0]), zzbev.zza().zza(activity, zzT[1])};
    }

    public static final boolean zzZ(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zzW(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzad(context));
    }

    public static int zza(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        StringBuilder sb = new StringBuilder(97);
        sb.append("HTTP timeout too low: ");
        sb.append(i);
        sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        zzcgs.zzi(sb.toString());
        return 60000;
    }

    private final JSONArray zzaa(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zzab : collection) {
            zzab(jSONArray, zzab);
        }
        return jSONArray;
    }

    private final void zzab(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzh((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzf((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zzaa((Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object zzab : (Object[]) obj) {
                zzab(jSONArray2, zzab);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zzac(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzh((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzf((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zzaa((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zzaa(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    @Nullable
    public static KeyguardManager zzad(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    public static boolean zzae(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static String zzaf(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) {
            return string;
        }
        return "";
    }

    public static Bundle zzag(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zze.zzb("Error getting metadata", e);
            return null;
        }
    }

    public static void zzk(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzche.zza.execute(runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzt(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r0
            goto L_0x0013
        L_0x0009:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0007
            android.app.Activity r2 = (android.app.Activity) r2
        L_0x0013:
            r1 = 0
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0017:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x002d
            r2 = 1
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zzt(android.view.View):boolean");
    }

    @TargetApi(18)
    public static final void zzu(Context context, Intent intent) {
        Bundle bundle;
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            if (intent.getExtras() != null) {
                bundle = intent.getExtras();
            } else {
                bundle = new Bundle();
            }
            bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(bundle);
        }
    }

    public static final String zzv(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzaf(zzag(context));
    }

    public static final String zzw() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append(RESTClient.SEMICOLON_SEPARATOR);
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append(RESTClient.SEMICOLON_SEPARATOR);
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String zzx() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 1 + str2.length()), str, " ", str2);
    }

    public static final DisplayMetrics zzy(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static final int[] zzz() {
        return new int[]{0, 0};
    }

    public final void zzb(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int zza2 = zza(i);
        StringBuilder sb = new StringBuilder(39);
        sb.append("HTTP timeout: ");
        sb.append(zza2);
        sb.append(" milliseconds.");
        zzcgs.zzh(sb.toString());
        httpURLConnection.setConnectTimeout(zza2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zza2);
        httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, zze(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zzc(Context context) {
        if (this.zzh) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzq(this, (zzl) null), intentFilter);
        this.zzh = true;
        return true;
    }

    public final boolean zzd(Context context) {
        if (this.zzi) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzp(this, (zzl) null), intentFilter);
        this.zzi = true;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0039, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[Catch:{ Exception -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zze(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzf
            monitor-enter(r0)
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return r1
        L_0x0009:
            if (r6 != 0) goto L_0x0011
            java.lang.String r5 = zzw()     // Catch:{ all -> 0x00c3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return r5
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzac r1 = com.google.android.gms.ads.internal.zzs.zze()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = r1.zzb(r5)     // Catch:{ Exception -> 0x001b }
            r4.zzg = r1     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ all -> 0x00c3 }
            boolean r1 = com.google.android.gms.internal.ads.zzcgl.zzp()     // Catch:{ all -> 0x00c3 }
            if (r1 != 0) goto L_0x0063
            r1 = 0
            r4.zzg = r1     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.internal.ads.zzfjj r1 = zza     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.ads.internal.util.zzm r2 = new com.google.android.gms.ads.internal.util.zzm     // Catch:{ all -> 0x00c3 }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x00c3 }
            r1.post(r2)     // Catch:{ all -> 0x00c3 }
        L_0x0039:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            if (r1 != 0) goto L_0x0069
            java.lang.Object r1 = r4.zzf     // Catch:{ InterruptedException -> 0x0043 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x0039
        L_0x0043:
            java.lang.String r1 = zzw()     // Catch:{ all -> 0x00c3 }
            r4.zzg = r1     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "Interrupted, use default user agent: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c3 }
            int r3 = r1.length()     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x005a
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x00c3 }
            goto L_0x005f
        L_0x005a:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00c3 }
            r1.<init>(r2)     // Catch:{ all -> 0x00c3 }
        L_0x005f:
            com.google.android.gms.internal.ads.zzcgs.zzi(r1)     // Catch:{ all -> 0x00c3 }
            goto L_0x0039
        L_0x0063:
            java.lang.String r1 = zzU(r5)     // Catch:{ all -> 0x00c3 }
            r4.zzg = r1     // Catch:{ all -> 0x00c3 }
        L_0x0069:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c3 }
            int r2 = r1.length()     // Catch:{ all -> 0x00c3 }
            int r2 = r2 + 10
            int r3 = r6.length()     // Catch:{ all -> 0x00c3 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r3.<init>(r2)     // Catch:{ all -> 0x00c3 }
            r3.append(r1)     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = " (Mobile; "
            r3.append(r1)     // Catch:{ all -> 0x00c3 }
            r3.append(r6)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00c3 }
            r4.zzg = r6     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r5)     // Catch:{ Exception -> 0x00a9 }
            boolean r5 = r5.isCallerInstantApp()     // Catch:{ Exception -> 0x00a9 }
            if (r5 == 0) goto L_0x00b3
            java.lang.String r5 = r4.zzg     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r6 = ";aia"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x00a9 }
            r4.zzg = r5     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00b3
        L_0x00a9:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzcgd r6 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "AdUtil.getUserAgent"
            r6.zzg(r5, r1)     // Catch:{ all -> 0x00c3 }
        L_0x00b3:
            java.lang.String r5 = r4.zzg     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = ")"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x00c3 }
            r4.zzg = r5     // Catch:{ all -> 0x00c3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return r5
        L_0x00c3:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            goto L_0x00c7
        L_0x00c6:
            throw r5
        L_0x00c7:
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zze(android.content.Context, java.lang.String):java.lang.String");
    }

    public final JSONObject zzf(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                zzac(jSONObject, next, map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final JSONObject zzg(@Nullable Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return zzh(bundle);
        } catch (JSONException e) {
            zzcgs.zzg("Error converting Bundle to JSON", e);
            return null;
        }
    }

    public final JSONObject zzh(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zzac(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final zzfqn<Map<String, String>> zzi(Uri uri) {
        return zzfqe.zzd(new zzk(uri), this.zzj);
    }

    public final void zzj(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        zzs.zzc();
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zzx());
        bundle.putString("eids", TextUtils.join(",", zzbjn.zzc()));
        zzbev.zza();
        zzcgl.zzr(context, str, "gmob-apps", bundle, true, new zzn(this, context, str));
    }

    public final boolean zzl(String str) {
        return zzae(str, this.zzb, (String) zzbex.zzc().zzb(zzbjn.zzW));
    }

    public final boolean zzm(String str) {
        return zzae(str, this.zzc, (String) zzbex.zzc().zzb(zzbjn.zzX));
    }

    @TargetApi(26)
    public final void zzn(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfN)).booleanValue()) {
                ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzo(this));
            }
        }
    }

    @TargetApi(18)
    public final int zzs(Context context, Uri uri) {
        int i;
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            zze.zza("Chrome Custom Tabs can only work with version Jellybean onwards.");
            i = 1;
        } else if (!(context instanceof Activity)) {
            zze.zza("Chrome Custom Tabs can only work with Activity context.");
            i = 2;
        } else {
            i = 0;
        }
        if (true == ((Boolean) zzbex.zzc().zzb(zzbjn.zzcQ)).equals(zzbex.zzc().zzb(zzbjn.zzcR))) {
            i = 9;
        }
        if (i != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
            return i;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcQ)).booleanValue()) {
            zzbkl zzbkl = new zzbkl();
            zzbkl.zzd(new zzl(this, zzbkl, context, uri));
            zzbkl.zze((Activity) context);
        }
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzcR)).booleanValue()) {
            return 5;
        }
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setPackage(zzgjv.zza(context));
        build.launchUrl(context, uri);
        return 5;
    }
}
