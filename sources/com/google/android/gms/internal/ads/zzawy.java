package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawy extends Thread {
    public boolean zza = false;
    public boolean zzb = false;
    public final Object zzc;
    public final zzawp zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final int zzl;
    public final String zzm;
    public final boolean zzn;
    public final boolean zzo;
    public final boolean zzp;

    public zzawy() {
        zzawp zzawp = new zzawp();
        this.zzd = zzawp;
        this.zzc = new Object();
        this.zzf = zzbku.zzd.zze().intValue();
        this.zzg = zzbku.zza.zze().intValue();
        this.zzh = zzbku.zze.zze().intValue();
        this.zzi = zzbku.zzc.zze().intValue();
        this.zzj = ((Integer) zzbex.zzc().zzb(zzbjn.zzN)).intValue();
        this.zzk = ((Integer) zzbex.zzc().zzb(zzbjn.zzO)).intValue();
        this.zzl = ((Integer) zzbex.zzc().zzb(zzbjn.zzP)).intValue();
        this.zze = zzbku.zzf.zze().intValue();
        this.zzm = (String) zzbex.zzc().zzb(zzbjn.zzR);
        this.zzn = ((Boolean) zzbex.zzc().zzb(zzbjn.zzS)).booleanValue();
        this.zzo = ((Boolean) zzbex.zzc().zzb(zzbjn.zzT)).booleanValue();
        this.zzp = ((Boolean) zzbex.zzc().zzb(zzbjn.zzU)).booleanValue();
        setName("ContentFetchTask");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc A[LOOP:2: B:48:0x00dc->B:62:0x00dc, LOOP_START, SYNTHETIC] */
    public final void run() {
        /*
            r6 = this;
        L_0x0000:
            com.google.android.gms.internal.ads.zzawt r0 = com.google.android.gms.ads.internal.zzs.zzf()     // Catch:{ all -> 0x00a8 }
            android.content.Context r0 = r0.zze()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ all -> 0x00a8 }
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            if (r2 == 0) goto L_0x00b2
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x002a:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ all -> 0x00a8 }
            int r4 = android.os.Process.myPid()     // Catch:{ all -> 0x00a8 }
            int r5 = r3.pid     // Catch:{ all -> 0x00a8 }
            if (r4 != r5) goto L_0x002a
            int r1 = r3.importance     // Catch:{ all -> 0x00a8 }
            r3 = 100
            if (r1 != r3) goto L_0x00b2
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00b2
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzawt r0 = com.google.android.gms.ads.internal.zzs.zzf()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            android.app.Activity r0 = r0.zzd()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            if (r0 != 0) goto L_0x006d
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzcgs.zzd(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zzg()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x006d:
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x008e }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r0.findViewById(r2)     // Catch:{ Exception -> 0x008e }
            goto L_0x009d
        L_0x008e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcgd r2 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zzg(r0, r3)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzcgs.zzd(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x009d:
            if (r1 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzawu r0 = new com.google.android.gms.internal.ads.zzawu     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r0.<init>(r6, r1)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x00a8:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcgd r1 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r2 = "ContentFetchTask.isInForeground"
            r1.zzg(r0, r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00b2:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzcgs.zzd(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zzg()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00ba:
            int r0 = r6.zze     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00d9
        L_0x00c3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzcgs.zzg(r1, r0)
            com.google.android.gms.internal.ads.zzcgd r1 = com.google.android.gms.ads.internal.zzs.zzg()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zzg(r0, r2)
            goto L_0x00d9
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzcgs.zzg(r1, r0)
        L_0x00d9:
            java.lang.Object r0 = r6.zzc
            monitor-enter(r0)
        L_0x00dc:
            boolean r1 = r6.zzb     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzcgs.zzd(r1)     // Catch:{ InterruptedException -> 0x00dc }
            java.lang.Object r1 = r6.zzc     // Catch:{ InterruptedException -> 0x00dc }
            r1.wait()     // Catch:{ InterruptedException -> 0x00dc }
            goto L_0x00dc
        L_0x00eb:
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            goto L_0x0000
        L_0x00ee:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            goto L_0x00f2
        L_0x00f1:
            throw r1
        L_0x00f2:
            goto L_0x00f1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawy.run():void");
    }

    public final void zza() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzcgs.zzd("Content hash thread already started, quiting...");
                return;
            }
            this.zza = true;
            start();
        }
    }

    @VisibleForTesting
    public final void zzb(View view) {
        try {
            zzawo zzawo = new zzawo(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context zze2 = zzs.zzf().zze();
            if (zze2 != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(zze2.getResources().getIdentifier((String) zzbex.zzc().zzb(zzbjn.zzQ), "id", zze2.getPackageName()));
                if (str != null) {
                    if (str.equals(this.zzm)) {
                        return;
                    }
                }
            }
            zzawx zzc2 = zzc(view, zzawo);
            zzawo.zzk();
            if (zzc2.zza == 0) {
                if (zzc2.zzb == 0) {
                    return;
                }
            }
            if (zzc2.zzb == 0) {
                if (zzawo.zzo() == 0) {
                    return;
                }
            }
            if (zzc2.zzb == 0) {
                if (this.zzd.zzb(zzawo)) {
                    return;
                }
            }
            this.zzd.zzd(zzawo);
        } catch (Exception e) {
            zzcgs.zzg("Exception in fetchContentOnUIThread", e);
            zzs.zzg().zzg(e, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    public final zzawx zzc(@Nullable View view, zzawo zzawo) {
        if (view == null) {
            return new zzawx(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzawx(this, 0, 0);
            }
            zzawo.zzi(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzawx(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzcmr)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                return new zzawx(this, 0, 0);
            }
            zzawo.zzg();
            webView.post(new zzaww(this, zzawo, webView, globalVisibleRect));
            return new zzawx(this, 0, 1);
        } else if (!(view instanceof ViewGroup)) {
            return new zzawx(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzawx zzc2 = zzc(viewGroup.getChildAt(i3), zzawo);
                i += zzc2.zza;
                i2 += zzc2.zzb;
            }
            return new zzawx(this, i, i2);
        }
    }

    @VisibleForTesting
    public final void zzd(zzawo zzawo, WebView webView, String str, boolean z) {
        zzawo.zzf();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzawo.zzh(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzawo.zzh(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzawo.zza()) {
                this.zzd.zzc(zzawo);
            }
        } catch (JSONException unused) {
            zzcgs.zzd("Json string may be malformed.");
        } catch (Throwable th) {
            zzcgs.zze("Failed to get webview content.", th);
            zzs.zzg().zzg(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzawo zze() {
        return this.zzd.zza(this.zzp);
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzcgs.zzd("ContentFetchThread: wakeup");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzcgs.zzd("ContentFetchThread: paused, mPause = true");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
