package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdmv extends zzbml implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdnu {
    public static final zzfml<String> zza = zzfml.zzl("2011", "1009", "3010");
    public final String zzb;
    @GuardedBy("this")
    public Map<String, WeakReference<View>> zzc = new HashMap();
    public FrameLayout zzd;
    public FrameLayout zze;
    public final zzfqo zzf;
    public View zzg;
    public final int zzh;
    @GuardedBy("this")
    public zzdlv zzi;
    public zzawa zzj;
    public IObjectWrapper zzk = null;
    public zzbmf zzl;
    public boolean zzm;
    public boolean zzn = false;

    public zzdmv(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = 212104000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        String str = "3012";
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            boolean equals = "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
        }
        this.zzb = str;
        zzs.zzz();
        zzchr.zza(frameLayout, this);
        zzs.zzz();
        zzchr.zzb(frameLayout, this);
        this.zzf = zzche.zze;
        this.zzj = new zzawa(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzs() {
        this.zzf.execute(new zzdmu(this));
    }

    private final synchronized void zzt(String str) {
        DisplayMetrics displayMetrics;
        FrameLayout frameLayout = new FrameLayout(this.zze.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.zze.getContext();
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        if (!TextUtils.isEmpty(str)) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Resources resources = context.getResources();
            if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    frameLayout.setBackground(bitmapDrawable);
                } catch (IllegalArgumentException e) {
                    zzcgs.zzj("Encountered invalid base64 watermark.", e);
                }
            }
        }
        this.zze.addView(frameLayout);
    }

    public final synchronized void onClick(View view) {
        zzdlv zzdlv = this.zzi;
        if (zzdlv != null) {
            zzdlv.zzu();
            this.zzi.zzj(view, this.zzd, zzj(), zzk(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzdlv zzdlv = this.zzi;
        if (zzdlv != null) {
            zzdlv.zzp(this.zzd, zzj(), zzk(), zzdlv.zzA(this.zzd));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdlv zzdlv = this.zzi;
        if (zzdlv != null) {
            zzdlv.zzp(this.zzd, zzj(), zzk(), zzdlv.zzA(this.zzd));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdlv zzdlv = this.zzi;
        if (zzdlv != null) {
            zzdlv.zzk(view, motionEvent, this.zzd);
        }
        return false;
    }

    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zzi(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final FrameLayout zzbL() {
        return this.zze;
    }

    public final synchronized void zzbM(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    public final void zzbN(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzbO(zzbmf zzbmf) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbmf;
            zzdlv zzdlv = this.zzi;
            if (zzdlv != null) {
                zzdlv.zzH().zzb(zzbmf);
            }
        }
    }

    public final /* bridge */ /* synthetic */ View zzbP() {
        return this.zzd;
    }

    public final synchronized IObjectWrapper zzc(String str) {
        return ObjectWrapper.wrap(zzm(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzn     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x006f }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzdlv     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.internal.ads.zzcgs.zzi(r2)     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzdlv r0 = r1.zzi     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x001d
            r0.zzh(r1)     // Catch:{ all -> 0x006f }
        L_0x001d:
            r1.zzs()     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdlv r2 = (com.google.android.gms.internal.ads.zzdlv) r2     // Catch:{ all -> 0x006f }
            r1.zzi = r2     // Catch:{ all -> 0x006f }
            r2.zzg(r1)     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdlv r2 = r1.zzi     // Catch:{ all -> 0x006f }
            android.widget.FrameLayout r0 = r1.zzd     // Catch:{ all -> 0x006f }
            r2.zzF(r0)     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdlv r2 = r1.zzi     // Catch:{ all -> 0x006f }
            android.widget.FrameLayout r0 = r1.zze     // Catch:{ all -> 0x006f }
            r2.zzG(r0)     // Catch:{ all -> 0x006f }
            boolean r2 = r1.zzm     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzdlv r2 = r1.zzi     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzdlx r2 = r2.zzH()     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzbmf r0 = r1.zzl     // Catch:{ all -> 0x006f }
            r2.zzb(r0)     // Catch:{ all -> 0x006f }
        L_0x0044:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzbjn.zzcm     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x006f }
            java.lang.Object r2 = r0.zzb(r2)     // Catch:{ all -> 0x006f }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x006f }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzdlv r2 = r1.zzi     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.zzC()     // Catch:{ all -> 0x006f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x006f }
            if (r2 != 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzdlv r2 = r1.zzi     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.zzC()     // Catch:{ all -> 0x006f }
            r1.zzt(r2)     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return
        L_0x006d:
            monitor-exit(r1)
            return
        L_0x006f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmv.zzd(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized void zze() {
        if (!this.zzn) {
            zzdlv zzdlv = this.zzi;
            if (zzdlv != null) {
                zzdlv.zzh(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        this.zzi.zzs((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final zzawa zzh() {
        return this.zzj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzc     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzc     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzh     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzby.zza(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmv.zzi(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized Map<String, WeakReference<View>> zzj() {
        return this.zzc;
    }

    public final synchronized Map<String, WeakReference<View>> zzk() {
        return this.zzc;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzl() {
        return null;
    }

    public final synchronized View zzm(String str) {
        if (this.zzn) {
            return null;
        }
        WeakReference weakReference = this.zzc.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized String zzn() {
        return this.zzb;
    }

    @Nullable
    public final IObjectWrapper zzo() {
        return this.zzk;
    }

    @Nullable
    public final synchronized JSONObject zzp() {
        zzdlv zzdlv = this.zzi;
        if (zzdlv == null) {
            return null;
        }
        return zzdlv.zzq(this.zzd, zzj(), zzk());
    }

    @Nullable
    public final synchronized JSONObject zzq() {
        zzdlv zzdlv = this.zzi;
        if (zzdlv == null) {
            return null;
        }
        return zzdlv.zzr(this.zzd, zzj(), zzk());
    }

    public final /* synthetic */ void zzr() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
