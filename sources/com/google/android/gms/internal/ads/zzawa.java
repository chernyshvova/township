package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.vungle.warren.VisionController;
import java.lang.ref.WeakReference;
import java.util.HashSet;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawa implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    public static final long zzc = ((Long) zzbex.zzc().zzb(zzbjn.zzaQ)).longValue();
    @Nullable
    @VisibleForTesting
    public BroadcastReceiver zza;
    public final WeakReference<View> zzb;
    public final Context zzd;
    public Application zze;
    public final WindowManager zzf;
    public final PowerManager zzg;
    public final KeyguardManager zzh;
    public WeakReference<ViewTreeObserver> zzi;
    public zzawm zzj;
    public final zzca zzk = new zzca(zzc);
    public boolean zzl = false;
    public int zzm = -1;
    public final HashSet<zzavz> zzn = new HashSet<>();
    public final DisplayMetrics zzo;
    public final Rect zzp;

    public zzawa(Context context, View view) {
        this.zzd = context.getApplicationContext();
        this.zzf = (WindowManager) context.getSystemService(VisionController.WINDOW);
        this.zzg = (PowerManager) this.zzd.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzd;
        if (context2 instanceof Application) {
            Application application = (Application) context2;
            this.zze = application;
            this.zzj = new zzawm(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = this.zzf.getDefaultDisplay().getWidth();
        this.zzp.bottom = this.zzf.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference<>(view);
        if (view != null) {
            if (zzs.zze().zzg(view)) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final void zzh() {
        zzr.zza.post(new zzavw(this));
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzb.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0115, code lost:
        if (r11 == 0) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012b, code lost:
        if (r11 == 0) goto L_0x012d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0199 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r33) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            java.util.HashSet<com.google.android.gms.internal.ads.zzavz> r0 = r1.zzn
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r0 = r1.zzb
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r0 = 2
            int[] r8 = new int[r0]
            int[] r0 = new int[r0]
            r9 = 0
            r10 = 1
            r11 = 0
            if (r3 == 0) goto L_0x0069
            boolean r12 = r3.getGlobalVisibleRect(r5)
            boolean r13 = r3.getLocalVisibleRect(r6)
            r3.getHitRect(r7)
            r3.getLocationOnScreen(r8)     // Catch:{ Exception -> 0x0049 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            r0 = move-exception
            java.lang.String r14 = "Failure getting view location."
            com.google.android.gms.internal.ads.zzcgs.zzg(r14, r0)
        L_0x004f:
            r0 = r8[r11]
            r4.left = r0
            r8 = r8[r10]
            r4.top = r8
            int r8 = r3.getWidth()
            int r8 = r8 + r0
            r4.right = r8
            int r0 = r4.top
            int r8 = r3.getHeight()
            int r8 = r8 + r0
            r4.bottom = r8
            r8 = r3
            goto L_0x006c
        L_0x0069:
            r8 = r9
            r12 = 0
            r13 = 0
        L_0x006c:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzaT
            com.google.android.gms.internal.ads.zzbjl r14 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r14.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00bd
            if (r8 == 0) goto L_0x00bd
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ae }
            r0.<init>()     // Catch:{ Exception -> 0x00ae }
            android.view.ViewParent r14 = r8.getParent()     // Catch:{ Exception -> 0x00ae }
        L_0x0089:
            boolean r15 = r14 instanceof android.view.View     // Catch:{ Exception -> 0x00ae }
            if (r15 == 0) goto L_0x00c1
            r15 = r14
            android.view.View r15 = (android.view.View) r15     // Catch:{ Exception -> 0x00ae }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x00ae }
            r11.<init>()     // Catch:{ Exception -> 0x00ae }
            boolean r17 = r15.isScrollContainer()     // Catch:{ Exception -> 0x00ae }
            if (r17 == 0) goto L_0x00a8
            boolean r15 = r15.getGlobalVisibleRect(r11)     // Catch:{ Exception -> 0x00ae }
            if (r15 == 0) goto L_0x00a8
            android.graphics.Rect r11 = r1.zzc(r11)     // Catch:{ Exception -> 0x00ae }
            r0.add(r11)     // Catch:{ Exception -> 0x00ae }
        L_0x00a8:
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00ae }
            r11 = 0
            goto L_0x0089
        L_0x00ae:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcgd r11 = com.google.android.gms.ads.internal.zzs.zzg()
            java.lang.String r14 = "PositionWatcher.getParentScrollViewRects"
            r11.zzg(r0, r14)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00c1
        L_0x00bd:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x00c1:
            r31 = r0
            r0 = 8
            if (r8 == 0) goto L_0x00cc
            int r11 = r8.getWindowVisibility()
            goto L_0x00ce
        L_0x00cc:
            r11 = 8
        L_0x00ce:
            int r14 = r1.zzm
            r15 = -1
            if (r14 == r15) goto L_0x00d4
            r11 = r14
        L_0x00d4:
            com.google.android.gms.ads.internal.zzs.zzc()
            long r26 = com.google.android.gms.ads.internal.util.zzr.zzA(r8)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r14 = com.google.android.gms.internal.ads.zzbjn.zzgB
            com.google.android.gms.internal.ads.zzbjl r15 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0118
            if (r3 == 0) goto L_0x0130
            com.google.android.gms.ads.internal.zzs.zzc()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r14 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzr.zzW(r8, r3, r14)
            if (r3 == 0) goto L_0x0130
            if (r12 == 0) goto L_0x0130
            if (r13 == 0) goto L_0x0130
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzbjn.zzgE
            com.google.android.gms.internal.ads.zzbjl r14 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r14.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            long r14 = (long) r3
            int r3 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x0130
            if (r11 != 0) goto L_0x0130
            goto L_0x012d
        L_0x0118:
            if (r3 == 0) goto L_0x0130
            com.google.android.gms.ads.internal.zzs.zzc()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r14 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzr.zzW(r8, r3, r14)
            if (r3 == 0) goto L_0x0130
            if (r12 == 0) goto L_0x0130
            if (r13 == 0) goto L_0x0130
            if (r11 != 0) goto L_0x0130
        L_0x012d:
            r3 = 1
            r11 = 0
            goto L_0x0131
        L_0x0130:
            r3 = 0
        L_0x0131:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r14 = com.google.android.gms.internal.ads.zzbjn.zzgF
            com.google.android.gms.internal.ads.zzbjl r15 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x018a
            com.google.android.gms.ads.internal.zzs.zzc()
            android.os.PowerManager r14 = r1.zzg
            android.app.KeyguardManager r15 = r1.zzh
            boolean r14 = com.google.android.gms.ads.internal.util.zzr.zzW(r8, r14, r15)
            if (r10 == r14) goto L_0x0152
            r14 = 0
            goto L_0x0154
        L_0x0152:
            r14 = 64
        L_0x0154:
            if (r10 == r12) goto L_0x0158
            r15 = 0
            goto L_0x015a
        L_0x0158:
            r15 = 8
        L_0x015a:
            r14 = r14 | r15
            if (r10 == r13) goto L_0x015f
            r15 = 0
            goto L_0x0161
        L_0x015f:
            r15 = 16
        L_0x0161:
            r14 = r14 | r15
            if (r11 != 0) goto L_0x0167
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x0168
        L_0x0167:
            r11 = 0
        L_0x0168:
            r11 = r11 | r14
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r14 = com.google.android.gms.internal.ads.zzbjn.zzgE
            com.google.android.gms.internal.ads.zzbjl r15 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            long r14 = (long) r14
            int r17 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r17 < 0) goto L_0x0181
            r14 = 32
            goto L_0x0182
        L_0x0181:
            r14 = 0
        L_0x0182:
            com.google.android.gms.ads.internal.zzs.zzc()
            r11 = r11 | r14
            r11 = r11 | r3
            com.google.android.gms.ads.internal.util.zzr.zzM(r8, r11, r9)
        L_0x018a:
            if (r2 != r10) goto L_0x019a
            com.google.android.gms.ads.internal.util.zzca r9 = r1.zzk
            boolean r9 = r9.zza()
            if (r9 != 0) goto L_0x019a
            boolean r9 = r1.zzl
            if (r3 == r9) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            return
        L_0x019a:
            if (r3 != 0) goto L_0x01a4
            boolean r9 = r1.zzl
            if (r9 != 0) goto L_0x01a4
            if (r2 == r10) goto L_0x01a3
            goto L_0x01a4
        L_0x01a3:
            return
        L_0x01a4:
            com.google.android.gms.internal.ads.zzavy r2 = new com.google.android.gms.internal.ads.zzavy
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.ads.internal.zzs.zzj()
            long r17 = r9.elapsedRealtime()
            android.os.PowerManager r9 = r1.zzg
            boolean r9 = r9.isScreenOn()
            if (r8 == 0) goto L_0x01c1
            com.google.android.gms.ads.internal.util.zzac r11 = com.google.android.gms.ads.internal.zzs.zze()
            boolean r11 = r11.zzg(r8)
            if (r11 == 0) goto L_0x01c1
            goto L_0x01c2
        L_0x01c1:
            r10 = 0
        L_0x01c2:
            if (r8 == 0) goto L_0x01cb
            int r0 = r8.getWindowVisibility()
            r19 = r0
            goto L_0x01cd
        L_0x01cb:
            r19 = 8
        L_0x01cd:
            android.graphics.Rect r0 = r1.zzp
            android.graphics.Rect r20 = r1.zzc(r0)
            android.graphics.Rect r21 = r1.zzc(r4)
            android.graphics.Rect r22 = r1.zzc(r5)
            android.graphics.Rect r24 = r1.zzc(r6)
            android.graphics.Rect r28 = r1.zzc(r7)
            android.util.DisplayMetrics r0 = r1.zzo
            float r0 = r0.density
            r29 = r0
            r14 = r2
            r15 = r17
            r17 = r9
            r18 = r10
            r23 = r12
            r25 = r13
            r30 = r3
            r14.<init>(r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31)
            java.util.HashSet<com.google.android.gms.internal.ads.zzavz> r0 = r1.zzn
            java.util.Iterator r0 = r0.iterator()
        L_0x01ff:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x020f
            java.lang.Object r4 = r0.next()
            com.google.android.gms.internal.ads.zzavz r4 = (com.google.android.gms.internal.ads.zzavz) r4
            r4.zzc(r2)
            goto L_0x01ff
        L_0x020f:
            r1.zzl = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawa.zzj(int):void");
    }

    private final int zzk(int i) {
        return (int) (((float) i) / this.zzo.density);
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzavx(this);
            zzs.zzx().zzb(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e) {
                zzcgs.zzg("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e) {
            zzcgs.zzg("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzcgs.zzg("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zza != null) {
            try {
                zzs.zzx().zzc(this.zzd, this.zza);
            } catch (IllegalStateException e3) {
                zzcgs.zzg("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzs.zzg().zzg(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e5) {
                zzcgs.zzg("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzh();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzh();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzh();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzh();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzh();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzh();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzh();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzh();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzh();
        zzm(view);
    }

    public final void zza(zzavz zzavz) {
        this.zzn.add(zzavz);
        zzj(3);
    }

    public final void zzb(zzavz zzavz) {
        this.zzn.remove(zzavz);
    }

    public final Rect zzc(Rect rect) {
        return new Rect(zzk(rect.left), zzk(rect.top), zzk(rect.right), zzk(rect.bottom));
    }

    public final void zzd(long j) {
        this.zzk.zzb(j);
    }

    public final void zze() {
        this.zzk.zzb(zzc);
    }

    public final /* synthetic */ void zzf() {
        zzj(3);
    }
}
