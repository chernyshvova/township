package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayx;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzbos;
import com.google.android.gms.internal.ads.zzbou;
import com.google.android.gms.internal.ads.zzbpt;
import com.google.android.gms.internal.ads.zzbpv;
import com.google.android.gms.internal.ads.zzbyr;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzcmr;
import com.google.android.gms.internal.ads.zzcnd;
import com.google.android.gms.internal.ads.zzcof;
import com.google.android.gms.internal.ads.zzcoh;
import com.google.android.gms.internal.ads.zzduu;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzedj;
import com.google.android.gms.internal.ads.zzeye;
import com.google.android.gms.internal.ads.zzeyh;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzfdh;
import com.google.android.gms.internal.ads.zzfdz;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzl extends zzbzq implements zzz {
    @VisibleForTesting
    public static final int zza = Color.argb(0, 0, 0, 0);
    public final Activity zzb;
    @Nullable
    @VisibleForTesting
    public AdOverlayInfoParcel zzc;
    @VisibleForTesting
    public zzcmr zzd;
    @VisibleForTesting
    public zzi zze;
    @VisibleForTesting
    public zzq zzf;
    @VisibleForTesting
    public boolean zzg = false;
    @VisibleForTesting
    public FrameLayout zzh;
    @VisibleForTesting
    public WebChromeClient.CustomViewCallback zzi;
    @VisibleForTesting
    public boolean zzj = false;
    @VisibleForTesting
    public boolean zzk = false;
    @VisibleForTesting
    public zzh zzl;
    @VisibleForTesting
    public boolean zzm = false;
    @VisibleForTesting
    public int zzn = 1;
    public final Object zzo = new Object();
    public Runnable zzp;
    public boolean zzq;
    public boolean zzr;
    public boolean zzs = false;
    public boolean zzt = false;
    public boolean zzu = true;

    public zzl(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzG(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzc
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzj r0 = r0.zzo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzac r3 = com.google.android.gms.ads.internal.zzs.zze()
            android.app.Activity r4 = r5.zzb
            boolean r6 = r3.zzo(r4, r6)
            boolean r3 = r5.zzk
            if (r3 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0031
        L_0x0021:
            if (r6 != 0) goto L_0x0031
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzc
            if (r6 == 0) goto L_0x0032
            com.google.android.gms.ads.internal.zzj r6 = r6.zzo
            if (r6 == 0) goto L_0x0032
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0032
            r2 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            android.app.Activity r6 = r5.zzb
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzaL
            com.google.android.gms.internal.ads.zzbjl r3 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005e
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L_0x0058
            if (r2 == 0) goto L_0x0055
            r0 = 5894(0x1706, float:8.259E-42)
            goto L_0x005a
        L_0x0055:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L_0x005a
        L_0x0058:
            r0 = 256(0x100, float:3.59E-43)
        L_0x005a:
            r6.setSystemUiVisibility(r0)
            return
        L_0x005e:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0076
            r6.addFlags(r0)
            r6.clearFlags(r3)
            if (r2 == 0) goto L_0x0075
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L_0x0075:
            return
        L_0x0076:
            r6.addFlags(r3)
            r6.clearFlags(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzG(android.content.res.Configuration):void");
    }

    public static final void zzH(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzs.zzr().zzj(iObjectWrapper, view);
        }
    }

    @VisibleForTesting
    public final void zzA() {
        zzcmr zzcmr;
        zzo zzo2;
        if (!this.zzt) {
            this.zzt = true;
            zzcmr zzcmr2 = this.zzd;
            if (zzcmr2 != null) {
                this.zzl.removeView(zzcmr2.zzH());
                zzi zzi2 = this.zze;
                if (zzi2 != null) {
                    this.zzd.zzai(zzi2.zzd);
                    this.zzd.zzag(false);
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzH = this.zzd.zzH();
                    zzi zzi3 = this.zze;
                    viewGroup.addView(zzH, zzi3.zza, zzi3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzai(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
                zzo2.zzbK(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzcmr = adOverlayInfoParcel2.zzd) != null) {
                zzH(zzcmr.zzV(), this.zzc.zzd.zzH());
            }
        }
    }

    public final void zzB() {
        if (this.zzm) {
            this.zzm = false;
            zzC();
        }
    }

    public final void zzC() {
        this.zzd.zzK();
    }

    public final void zzD() {
        this.zzl.zzb = true;
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzq = true;
            if (this.zzp != null) {
                zzr.zza.removeCallbacks(this.zzp);
                zzr.zza.post(this.zzp);
            }
        }
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzw(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzd() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zze() {
        this.zzn = 1;
    }

    public final void zzf() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
            zzo2.zzbI();
        }
    }

    public final boolean zzg() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzZ = this.zzd.zzZ();
            if (!zzZ) {
                this.zzd.zze("onbackblocked", Collections.emptyMap());
            }
            return zzZ;
        }
        this.zzd.goBack();
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A[Catch:{ zzg -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb A[Catch:{ zzg -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0 A[Catch:{ zzg -> 0x00ec }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzh(android.os.Bundle r9) {
        /*
            r8 = this;
            android.app.Activity r0 = r8.zzb
            r1 = 1
            r0.requestWindowFeature(r1)
            r0 = 0
            if (r9 == 0) goto L_0x0013
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x00ec }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzg -> 0x00ec }
            r8.zzc = r3     // Catch:{ zzg -> 0x00ec }
            if (r3 == 0) goto L_0x00e4
            com.google.android.gms.internal.ads.zzcgy r3 = r3.zzm     // Catch:{ zzg -> 0x00ec }
            int r3 = r3.zzc     // Catch:{ zzg -> 0x00ec }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0030
            r8.zzn = r2     // Catch:{ zzg -> 0x00ec }
        L_0x0030:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x00ec }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x00ec }
            if (r3 == 0) goto L_0x0046
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x00ec }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x00ec }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzg -> 0x00ec }
            r8.zzu = r3     // Catch:{ zzg -> 0x00ec }
        L_0x0046:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.ads.internal.zzj r4 = r3.zzo     // Catch:{ zzg -> 0x00ec }
            r5 = 5
            if (r4 == 0) goto L_0x0054
            boolean r6 = r4.zza     // Catch:{ zzg -> 0x00ec }
            r8.zzk = r6     // Catch:{ zzg -> 0x00ec }
            if (r6 == 0) goto L_0x006f
            goto L_0x005a
        L_0x0054:
            int r6 = r3.zzk     // Catch:{ zzg -> 0x00ec }
            if (r6 != r5) goto L_0x006d
            r8.zzk = r1     // Catch:{ zzg -> 0x00ec }
        L_0x005a:
            int r3 = r3.zzk     // Catch:{ zzg -> 0x00ec }
            if (r3 == r5) goto L_0x006f
            int r3 = r4.zzf     // Catch:{ zzg -> 0x00ec }
            r4 = -1
            if (r3 == r4) goto L_0x006f
            com.google.android.gms.ads.internal.overlay.zzk r3 = new com.google.android.gms.ads.internal.overlay.zzk     // Catch:{ zzg -> 0x00ec }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzg -> 0x00ec }
            r3.zzb()     // Catch:{ zzg -> 0x00ec }
            goto L_0x006f
        L_0x006d:
            r8.zzk = r0     // Catch:{ zzg -> 0x00ec }
        L_0x006f:
            if (r9 != 0) goto L_0x0094
            boolean r9 = r8.zzu     // Catch:{ zzg -> 0x00ec }
            if (r9 == 0) goto L_0x0087
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.internal.ads.zzdbq r9 = r9.zzx     // Catch:{ zzg -> 0x00ec }
            if (r9 == 0) goto L_0x007e
            r9.zzb()     // Catch:{ zzg -> 0x00ec }
        L_0x007e:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.ads.internal.overlay.zzo r9 = r9.zzc     // Catch:{ zzg -> 0x00ec }
            if (r9 == 0) goto L_0x0087
            r9.zzbE()     // Catch:{ zzg -> 0x00ec }
        L_0x0087:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x00ec }
            int r3 = r9.zzk     // Catch:{ zzg -> 0x00ec }
            if (r3 == r1) goto L_0x0094
            com.google.android.gms.internal.ads.zzbcz r9 = r9.zzb     // Catch:{ zzg -> 0x00ec }
            if (r9 == 0) goto L_0x0094
            r9.onAdClicked()     // Catch:{ zzg -> 0x00ec }
        L_0x0094:
            com.google.android.gms.ads.internal.overlay.zzh r9 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzg -> 0x00ec }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzg -> 0x00ec }
            java.lang.String r6 = r4.zzn     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.internal.ads.zzcgy r7 = r4.zzm     // Catch:{ zzg -> 0x00ec }
            java.lang.String r7 = r7.zza     // Catch:{ zzg -> 0x00ec }
            java.lang.String r4 = r4.zzw     // Catch:{ zzg -> 0x00ec }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzg -> 0x00ec }
            r8.zzl = r9     // Catch:{ zzg -> 0x00ec }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.ads.internal.util.zzac r9 = com.google.android.gms.ads.internal.zzs.zze()     // Catch:{ zzg -> 0x00ec }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x00ec }
            r9.zzr(r3)     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x00ec }
            int r3 = r9.zzk     // Catch:{ zzg -> 0x00ec }
            if (r3 == r1) goto L_0x00e0
            r4 = 2
            if (r3 == r4) goto L_0x00d3
            r9 = 3
            if (r3 == r9) goto L_0x00cf
            if (r3 != r5) goto L_0x00c7
            r8.zzy(r0)     // Catch:{ zzg -> 0x00ec }
            return
        L_0x00c7:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x00ec }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzg -> 0x00ec }
            throw r9     // Catch:{ zzg -> 0x00ec }
        L_0x00cf:
            r8.zzy(r1)     // Catch:{ zzg -> 0x00ec }
            return
        L_0x00d3:
            com.google.android.gms.ads.internal.overlay.zzi r1 = new com.google.android.gms.ads.internal.overlay.zzi     // Catch:{ zzg -> 0x00ec }
            com.google.android.gms.internal.ads.zzcmr r9 = r9.zzd     // Catch:{ zzg -> 0x00ec }
            r1.<init>(r9)     // Catch:{ zzg -> 0x00ec }
            r8.zze = r1     // Catch:{ zzg -> 0x00ec }
            r8.zzy(r0)     // Catch:{ zzg -> 0x00ec }
            return
        L_0x00e0:
            r8.zzy(r0)     // Catch:{ zzg -> 0x00ec }
            return
        L_0x00e4:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x00ec }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzg -> 0x00ec }
            throw r9     // Catch:{ zzg -> 0x00ec }
        L_0x00ec:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.internal.ads.zzcgs.zzi(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzh(android.os.Bundle):void");
    }

    public final void zzi() {
    }

    public final void zzj() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdf)).booleanValue()) {
            zzcmr zzcmr = this.zzd;
            if (zzcmr == null || zzcmr.zzX()) {
                zzcgs.zzi("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzk() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzca();
        }
        zzG(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdf)).booleanValue()) {
            zzcmr zzcmr = this.zzd;
            if (zzcmr == null || zzcmr.zzX()) {
                zzcgs.zzi("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzl() {
        zzo zzo2;
        zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbJ();
        }
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdf)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzz();
    }

    public final void zzm(int i, int i2, Intent intent) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        zzG((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzp() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdf)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzz();
    }

    public final void zzq() {
        zzcmr zzcmr = this.zzd;
        if (zzcmr != null) {
            try {
                this.zzl.removeView(zzcmr.zzH());
            } catch (NullPointerException unused) {
            }
        }
        zzz();
    }

    public final void zzr(boolean z) {
        int intValue = ((Integer) zzbex.zzc().zzb(zzbjn.zzdh)).intValue();
        zzp zzp2 = new zzp();
        zzp2.zzd = 50;
        int i = 0;
        zzp2.zza = true != z ? 0 : intValue;
        if (true != z) {
            i = intValue;
        }
        zzp2.zzb = i;
        zzp2.zzc = intValue;
        this.zzf = new zzq(this.zzb, zzp2, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z ? 9 : 11);
        zzt(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    public final void zzs() {
        this.zzr = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzc).zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzt(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzaJ
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzc
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzj r0 = r0.zzo
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzh
            if (r0 == 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzbjn.zzaK
            com.google.android.gms.internal.ads.zzbjl r4 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzc
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzj r3 = r3.zzo
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzi
            if (r3 == 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzbyq r7 = new com.google.android.gms.internal.ads.zzbyq
            com.google.android.gms.internal.ads.zzcmr r4 = r6.zzd
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzf(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzq r7 = r6.zzf
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r7.zza(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzt(boolean, boolean):void");
    }

    public final void zzu(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzv() {
        this.zzl.removeView(this.zzf);
        zzr(true);
    }

    public final void zzw(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzbex.zzc().zzb(zzbjn.zzel)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzbex.zzc().zzb(zzbjn.zzem)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzbex.zzc().zzb(zzbjn.zzen)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzbex.zzc().zzb(zzbjn.zzeo)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzs.zzg().zzh(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzx(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzr = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    public final void zzy(boolean z) throws zzg {
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window != null) {
            zzcmr zzcmr = this.zzc.zzd;
            zzb zzb2 = null;
            zzcof zzR = zzcmr != null ? zzcmr.zzR() : null;
            boolean z2 = false;
            boolean z3 = zzR != null && zzR.zzc();
            this.zzm = false;
            if (z3) {
                int i = this.zzc.zzj;
                if (i == 6) {
                    if (this.zzb.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzm = z2;
                } else if (i == 7) {
                    if (this.zzb.getResources().getConfiguration().orientation == 2) {
                        z2 = true;
                    }
                    this.zzm = z2;
                }
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z2);
            zzcgs.zzd(sb.toString());
            zzw(this.zzc.zzj);
            window.setFlags(16777216, 16777216);
            zzcgs.zzd("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzk) {
                this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.zzl.setBackgroundColor(zza);
            }
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            if (z) {
                try {
                    zzs.zzd();
                    Activity activity = this.zzb;
                    zzcmr zzcmr2 = this.zzc.zzd;
                    zzcoh zzP = zzcmr2 != null ? zzcmr2.zzP() : null;
                    zzcmr zzcmr3 = this.zzc.zzd;
                    String zzQ = zzcmr3 != null ? zzcmr3.zzQ() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                    zzcgy zzcgy = adOverlayInfoParcel.zzm;
                    zzcmr zzcmr4 = adOverlayInfoParcel.zzd;
                    zzcmr zza2 = zzcnd.zza(activity, zzP, zzQ, true, z3, (zzfb) null, (zzbkm) null, zzcgy, (zzbkc) null, (com.google.android.gms.ads.internal.zzl) null, zzcmr4 != null ? zzcmr4.zzk() : null, zzayx.zza(), (zzeye) null, (zzeyh) null);
                    this.zzd = zza2;
                    zzcof zzR2 = zza2.zzR();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    zzbos zzbos = adOverlayInfoParcel2.zzp;
                    zzbou zzbou = adOverlayInfoParcel2.zze;
                    zzv zzv = adOverlayInfoParcel2.zzi;
                    zzcmr zzcmr5 = adOverlayInfoParcel2.zzd;
                    if (zzcmr5 != null) {
                        zzb2 = zzcmr5.zzR().zzb();
                    }
                    zzR2.zzK((zzbcz) null, zzbos, (zzo) null, zzbou, zzv, true, (zzbpv) null, zzb2, (zzbyr) null, (zzcdz) null, (zzedb) null, (zzfdz) null, (zzduu) null, (zzfdh) null, (zzbpt) null);
                    this.zzd.zzR().zzw(new zzd(this));
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                    String str = adOverlayInfoParcel3.zzl;
                    if (str != null) {
                        this.zzd.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel3.zzh;
                        if (str2 != null) {
                            this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str2, "text/html", "UTF-8", (String) null);
                        } else {
                            throw new zzg("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzcmr zzcmr6 = this.zzc.zzd;
                    if (zzcmr6 != null) {
                        zzcmr6.zzam(this);
                    }
                } catch (Exception e) {
                    zzcgs.zzg("Error obtaining webview.", e);
                    throw new zzg("Could not obtain webview for the overlay.");
                }
            } else {
                zzcmr zzcmr7 = this.zzc.zzd;
                this.zzd = zzcmr7;
                zzcmr7.zzai(this.zzb);
            }
            this.zzd.zzae(this);
            zzcmr zzcmr8 = this.zzc.zzd;
            if (zzcmr8 != null) {
                zzH(zzcmr8.zzV(), this.zzl);
            }
            if (this.zzc.zzk != 5) {
                ViewParent parent = this.zzd.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzd.zzH());
                }
                if (this.zzk) {
                    this.zzd.zzas();
                }
                this.zzl.addView(this.zzd.zzH(), -1, -1);
            }
            if (!z && !this.zzm) {
                zzC();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            if (adOverlayInfoParcel4.zzk != 5) {
                zzr(z3);
                if (this.zzd.zzT()) {
                    zzt(z3, true);
                    return;
                }
                return;
            }
            zzedj.zzc(this.zzb, this, adOverlayInfoParcel4.zzu, adOverlayInfoParcel4.zzr, adOverlayInfoParcel4.zzs, adOverlayInfoParcel4.zzt, adOverlayInfoParcel4.zzq, adOverlayInfoParcel4.zzv);
            return;
        }
        throw new zzg("Invalid activity, no window available.");
    }

    public final void zzz() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzo zzo2;
        if (this.zzb.isFinishing() && !this.zzs) {
            this.zzs = true;
            zzcmr zzcmr = this.zzd;
            if (zzcmr != null) {
                int i = this.zzn;
                if (i != 0) {
                    zzcmr.zzJ(i - 1);
                    synchronized (this.zzo) {
                        if (!this.zzq && this.zzd.zzaa()) {
                            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdd)).booleanValue() && !this.zzt && (adOverlayInfoParcel = this.zzc) != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
                                zzo2.zzbH();
                            }
                            zze zze2 = new zze(this);
                            this.zzp = zze2;
                            zzr.zza.postDelayed(zze2, ((Long) zzbex.zzc().zzb(zzbjn.zzaI)).longValue());
                            return;
                        }
                    }
                } else {
                    throw null;
                }
            }
            zzA();
        }
    }
}
