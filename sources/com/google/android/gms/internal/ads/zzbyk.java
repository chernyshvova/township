package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyk extends zzbyq {
    public static final Set<String> zza = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    public String zzb = "top-right";
    public boolean zzc = true;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = -1;
    public int zzg = 0;
    public int zzh = 0;
    public int zzi = -1;
    public final Object zzj = new Object();
    public final zzcmr zzk;
    public final Activity zzl;
    public zzcoh zzm;
    public ImageView zzn;
    public LinearLayout zzo;
    public final zzbyr zzp;
    public PopupWindow zzq;
    public RelativeLayout zzr;
    public ViewGroup zzs;

    public zzbyk(zzcmr zzcmr, zzbyr zzbyr) {
        super(zzcmr, "resize");
        this.zzk = zzcmr;
        this.zzl = zzcmr.zzj();
        this.zzp = zzbyr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01fa A[Catch:{ RuntimeException -> 0x0428 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01fb A[Catch:{ RuntimeException -> 0x0428 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x025b A[Catch:{ RuntimeException -> 0x0428 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0262 A[Catch:{ RuntimeException -> 0x0428 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.zzj
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzcmr r3 = r1.zzk     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcoh r3 = r3.zzP()     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzcmr r3 = r1.zzk     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcoh r3 = r3.zzP()     // Catch:{ all -> 0x0486 }
            boolean r3 = r3.zzg()     // Catch:{ all -> 0x0486 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzcmr r3 = r1.zzk     // Catch:{ all -> 0x0486 }
            boolean r3 = r3.zzW()     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x047f
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0486 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x005b
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0486 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzQ(r3)     // Catch:{ all -> 0x0486 }
            r1.zzi = r3     // Catch:{ all -> 0x0486 }
        L_0x005b:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0486 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x007a
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0486 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzQ(r3)     // Catch:{ all -> 0x0486 }
            r1.zzf = r3     // Catch:{ all -> 0x0486 }
        L_0x007a:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0486 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x0099
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0486 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzQ(r3)     // Catch:{ all -> 0x0486 }
            r1.zzg = r3     // Catch:{ all -> 0x0486 }
        L_0x0099:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0486 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x00b8
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0486 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzQ(r3)     // Catch:{ all -> 0x0486 }
            r1.zzh = r3     // Catch:{ all -> 0x0486 }
        L_0x00b8:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0486 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x00d4
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0486 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x0486 }
            r1.zzc = r3     // Catch:{ all -> 0x0486 }
        L_0x00d4:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0486 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x00e4
            r1.zzb = r0     // Catch:{ all -> 0x0486 }
        L_0x00e4:
            int r0 = r1.zzi     // Catch:{ all -> 0x0486 }
            if (r0 < 0) goto L_0x0478
            int r0 = r1.zzf     // Catch:{ all -> 0x0486 }
            if (r0 < 0) goto L_0x0478
            android.app.Activity r0 = r1.zzl     // Catch:{ all -> 0x0486 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0486 }
            if (r0 == 0) goto L_0x0471
            android.view.View r3 = r0.getDecorView()     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x00fc
            goto L_0x0471
        L_0x00fc:
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0486 }
            int[] r3 = com.google.android.gms.ads.internal.util.zzr.zzY(r3)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0486 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzr.zzV(r4)     // Catch:{ all -> 0x0486 }
            r5 = 0
            r6 = r3[r5]     // Catch:{ all -> 0x0486 }
            r7 = 1
            r3 = r3[r7]     // Catch:{ all -> 0x0486 }
            int r8 = r1.zzi     // Catch:{ all -> 0x0486 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = 2
            r13 = 50
            if (r8 < r13) goto L_0x0253
            if (r8 <= r6) goto L_0x0122
            goto L_0x0253
        L_0x0122:
            int r14 = r1.zzf     // Catch:{ all -> 0x0486 }
            if (r14 < r13) goto L_0x024d
            if (r14 <= r3) goto L_0x012a
            goto L_0x024d
        L_0x012a:
            if (r14 != r3) goto L_0x0135
            if (r8 != r6) goto L_0x0135
            java.lang.String r3 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.ads.zzcgs.zzi(r3)     // Catch:{ all -> 0x0486 }
            goto L_0x0258
        L_0x0135:
            boolean r3 = r1.zzc     // Catch:{ all -> 0x0486 }
            if (r3 == 0) goto L_0x020c
            java.lang.String r3 = r1.zzb     // Catch:{ all -> 0x0486 }
            int r15 = r3.hashCode()     // Catch:{ all -> 0x0486 }
            switch(r15) {
                case -1364013995: goto L_0x0175;
                case -1012429441: goto L_0x016b;
                case -655373719: goto L_0x0161;
                case 1163912186: goto L_0x0157;
                case 1288627767: goto L_0x014d;
                case 1755462605: goto L_0x0143;
                default: goto L_0x0142;
            }
        L_0x0142:
            goto L_0x017f
        L_0x0143:
            java.lang.String r15 = "top-center"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x017f
            r3 = 1
            goto L_0x0180
        L_0x014d:
            java.lang.String r15 = "bottom-center"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x017f
            r3 = 4
            goto L_0x0180
        L_0x0157:
            java.lang.String r15 = "bottom-right"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x017f
            r3 = 5
            goto L_0x0180
        L_0x0161:
            java.lang.String r15 = "bottom-left"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x017f
            r3 = 3
            goto L_0x0180
        L_0x016b:
            java.lang.String r15 = "top-left"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x017f
            r3 = 0
            goto L_0x0180
        L_0x0175:
            java.lang.String r15 = "center"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x017f
            r3 = 2
            goto L_0x0180
        L_0x017f:
            r3 = -1
        L_0x0180:
            if (r3 == 0) goto L_0x01e2
            if (r3 == r7) goto L_0x01d6
            if (r3 == r12) goto L_0x01c2
            if (r3 == r11) goto L_0x01b2
            if (r3 == r10) goto L_0x01a6
            if (r3 == r9) goto L_0x0199
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r14 = r1.zzg     // Catch:{ all -> 0x0486 }
            r15 = -50
            int r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r3, r14, r8, r15)     // Catch:{ all -> 0x0486 }
            int r8 = r1.zze
            goto L_0x01e9
        L_0x0199:
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r15 = r1.zzg     // Catch:{ all -> 0x0486 }
            r9 = -50
            int r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r3, r15, r8, r9)     // Catch:{ all -> 0x0486 }
            int r8 = r1.zze
            goto L_0x01b9
        L_0x01a6:
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r9 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r3 = r3 + r9
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0486 }
            goto L_0x01b9
        L_0x01b2:
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0486 }
        L_0x01b9:
            int r9 = r1.zzh     // Catch:{ all -> 0x0486 }
            r15 = -50
            int r8 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r8, r9, r14, r15)
            goto L_0x01ec
        L_0x01c2:
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r9 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r3 = r3 + r9
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0486 }
            int r9 = r1.zzh     // Catch:{ all -> 0x0486 }
            int r8 = r8 + r9
            int r9 = r14 >> 1
            int r8 = r8 + r9
            int r8 = r8 + -25
            goto L_0x01ec
        L_0x01d6:
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r9 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r3 = r3 + r9
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0486 }
            goto L_0x01e9
        L_0x01e2:
            int r3 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0486 }
        L_0x01e9:
            int r9 = r1.zzh     // Catch:{ all -> 0x0486 }
            int r8 = r8 + r9
        L_0x01ec:
            if (r3 < 0) goto L_0x0258
            int r3 = r3 + r13
            if (r3 > r6) goto L_0x0258
            r3 = r4[r5]     // Catch:{ all -> 0x0486 }
            if (r8 < r3) goto L_0x0258
            int r8 = r8 + r13
            r3 = r4[r7]     // Catch:{ all -> 0x0486 }
            if (r8 <= r3) goto L_0x01fb
            goto L_0x0258
        L_0x01fb:
            int[] r3 = new int[r12]     // Catch:{ all -> 0x0486 }
            int r4 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r4 = r4 + r6
            r3[r5] = r4     // Catch:{ all -> 0x0486 }
            int r4 = r1.zze     // Catch:{ all -> 0x0486 }
            int r6 = r1.zzh     // Catch:{ all -> 0x0486 }
            int r4 = r4 + r6
            r3[r7] = r4     // Catch:{ all -> 0x0486 }
            goto L_0x0259
        L_0x020c:
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0486 }
            int[] r3 = com.google.android.gms.ads.internal.util.zzr.zzY(r3)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0486 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzr.zzV(r4)     // Catch:{ all -> 0x0486 }
            r3 = r3[r5]     // Catch:{ all -> 0x0486 }
            int r6 = r1.zzd     // Catch:{ all -> 0x0486 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0486 }
            int r6 = r6 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0486 }
            int r9 = r1.zzh     // Catch:{ all -> 0x0486 }
            int r8 = r8 + r9
            if (r6 >= 0) goto L_0x022e
            r6 = 0
            goto L_0x0236
        L_0x022e:
            int r9 = r1.zzi     // Catch:{ all -> 0x0486 }
            int r14 = r6 + r9
            if (r14 <= r3) goto L_0x0236
            int r6 = r3 - r9
        L_0x0236:
            r3 = r4[r5]     // Catch:{ all -> 0x0486 }
            if (r8 >= r3) goto L_0x023c
            r8 = r3
            goto L_0x0246
        L_0x023c:
            int r3 = r1.zzf     // Catch:{ all -> 0x0486 }
            int r9 = r8 + r3
            r4 = r4[r7]     // Catch:{ all -> 0x0486 }
            if (r9 <= r4) goto L_0x0246
            int r8 = r4 - r3
        L_0x0246:
            int[] r3 = new int[r12]     // Catch:{ all -> 0x0486 }
            r3[r5] = r6     // Catch:{ all -> 0x0486 }
            r3[r7] = r8     // Catch:{ all -> 0x0486 }
            goto L_0x0259
        L_0x024d:
            java.lang.String r3 = "Height is too small or too large."
            com.google.android.gms.internal.ads.zzcgs.zzi(r3)     // Catch:{ all -> 0x0486 }
            goto L_0x0258
        L_0x0253:
            java.lang.String r3 = "Width is too small or too large."
            com.google.android.gms.internal.ads.zzcgs.zzi(r3)     // Catch:{ all -> 0x0486 }
        L_0x0258:
            r3 = 0
        L_0x0259:
            if (r3 != 0) goto L_0x0262
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0262:
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ all -> 0x0486 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0486 }
            int r6 = r1.zzi     // Catch:{ all -> 0x0486 }
            int r4 = com.google.android.gms.internal.ads.zzcgl.zzs(r4, r6)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ all -> 0x0486 }
            android.app.Activity r6 = r1.zzl     // Catch:{ all -> 0x0486 }
            int r8 = r1.zzf     // Catch:{ all -> 0x0486 }
            int r6 = com.google.android.gms.internal.ads.zzcgl.zzs(r6, r8)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r8 = r1.zzk     // Catch:{ all -> 0x0486 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0486 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x0486 }
            if (r8 == 0) goto L_0x046a
            boolean r9 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0486 }
            if (r9 == 0) goto L_0x046a
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r9 = r1.zzk     // Catch:{ all -> 0x0486 }
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0486 }
            r8.removeView(r9)     // Catch:{ all -> 0x0486 }
            android.widget.PopupWindow r9 = r1.zzq     // Catch:{ all -> 0x0486 }
            if (r9 != 0) goto L_0x02cc
            r1.zzs = r8     // Catch:{ all -> 0x0486 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r8 = r1.zzk     // Catch:{ all -> 0x0486 }
            r9 = r8
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0486 }
            r9.setDrawingCacheEnabled(r7)     // Catch:{ all -> 0x0486 }
            r9 = r8
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0486 }
            android.graphics.Bitmap r9 = r9.getDrawingCache()     // Catch:{ all -> 0x0486 }
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r9)     // Catch:{ all -> 0x0486 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0486 }
            r8.setDrawingCacheEnabled(r5)     // Catch:{ all -> 0x0486 }
            android.widget.ImageView r8 = new android.widget.ImageView     // Catch:{ all -> 0x0486 }
            android.app.Activity r14 = r1.zzl     // Catch:{ all -> 0x0486 }
            r8.<init>(r14)     // Catch:{ all -> 0x0486 }
            r1.zzn = r8     // Catch:{ all -> 0x0486 }
            r8.setImageBitmap(r9)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r8 = r1.zzk     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcoh r8 = r8.zzP()     // Catch:{ all -> 0x0486 }
            r1.zzm = r8     // Catch:{ all -> 0x0486 }
            android.view.ViewGroup r8 = r1.zzs     // Catch:{ all -> 0x0486 }
            android.widget.ImageView r9 = r1.zzn     // Catch:{ all -> 0x0486 }
            r8.addView(r9)     // Catch:{ all -> 0x0486 }
            goto L_0x02cf
        L_0x02cc:
            r9.dismiss()     // Catch:{ all -> 0x0486 }
        L_0x02cf:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0486 }
            android.app.Activity r9 = r1.zzl     // Catch:{ all -> 0x0486 }
            r8.<init>(r9)     // Catch:{ all -> 0x0486 }
            r1.zzr = r8     // Catch:{ all -> 0x0486 }
            r8.setBackgroundColor(r5)     // Catch:{ all -> 0x0486 }
            android.widget.RelativeLayout r8 = r1.zzr     // Catch:{ all -> 0x0486 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0486 }
            r9.<init>(r4, r6)     // Catch:{ all -> 0x0486 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            android.widget.RelativeLayout r8 = r1.zzr     // Catch:{ all -> 0x0486 }
            android.widget.PopupWindow r9 = new android.widget.PopupWindow     // Catch:{ all -> 0x0486 }
            r9.<init>(r8, r4, r6, r5)     // Catch:{ all -> 0x0486 }
            r1.zzq = r9     // Catch:{ all -> 0x0486 }
            r9.setOutsideTouchable(r5)     // Catch:{ all -> 0x0486 }
            android.widget.PopupWindow r5 = r1.zzq     // Catch:{ all -> 0x0486 }
            r5.setTouchable(r7)     // Catch:{ all -> 0x0486 }
            android.widget.PopupWindow r5 = r1.zzq     // Catch:{ all -> 0x0486 }
            boolean r8 = r1.zzc     // Catch:{ all -> 0x0486 }
            r8 = r8 ^ r7
            r5.setClippingEnabled(r8)     // Catch:{ all -> 0x0486 }
            android.widget.RelativeLayout r5 = r1.zzr     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r8 = r1.zzk     // Catch:{ all -> 0x0486 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0486 }
            r9 = -1
            r5.addView(r8, r9, r9)     // Catch:{ all -> 0x0486 }
            android.widget.LinearLayout r5 = new android.widget.LinearLayout     // Catch:{ all -> 0x0486 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0486 }
            r5.<init>(r8)     // Catch:{ all -> 0x0486 }
            r1.zzo = r5     // Catch:{ all -> 0x0486 }
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ all -> 0x0486 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0486 }
            int r8 = com.google.android.gms.internal.ads.zzcgl.zzs(r8, r13)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ all -> 0x0486 }
            android.app.Activity r9 = r1.zzl     // Catch:{ all -> 0x0486 }
            int r9 = com.google.android.gms.internal.ads.zzcgl.zzs(r9, r13)     // Catch:{ all -> 0x0486 }
            r5.<init>(r8, r9)     // Catch:{ all -> 0x0486 }
            java.lang.String r8 = r1.zzb     // Catch:{ all -> 0x0486 }
            int r9 = r8.hashCode()     // Catch:{ all -> 0x0486 }
            switch(r9) {
                case -1364013995: goto L_0x0367;
                case -1012429441: goto L_0x035d;
                case -655373719: goto L_0x0353;
                case 1163912186: goto L_0x0349;
                case 1288627767: goto L_0x033f;
                case 1755462605: goto L_0x0335;
                default: goto L_0x0334;
            }
        L_0x0334:
            goto L_0x0371
        L_0x0335:
            java.lang.String r9 = "top-center"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0371
            r8 = 1
            goto L_0x0372
        L_0x033f:
            java.lang.String r9 = "bottom-center"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0371
            r8 = 4
            goto L_0x0372
        L_0x0349:
            java.lang.String r9 = "bottom-right"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0371
            r8 = 5
            goto L_0x0372
        L_0x0353:
            java.lang.String r9 = "bottom-left"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0371
            r8 = 3
            goto L_0x0372
        L_0x035d:
            java.lang.String r9 = "top-left"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0371
            r8 = 0
            goto L_0x0372
        L_0x0367:
            java.lang.String r9 = "center"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0371
            r8 = 2
            goto L_0x0372
        L_0x0371:
            r8 = -1
        L_0x0372:
            r9 = 9
            r13 = 10
            if (r8 == 0) goto L_0x03b2
            r14 = 14
            if (r8 == r7) goto L_0x03ab
            if (r8 == r12) goto L_0x03a5
            r12 = 12
            if (r8 == r11) goto L_0x039e
            if (r8 == r10) goto L_0x0397
            r9 = 11
            r10 = 5
            if (r8 == r10) goto L_0x0390
            r5.addRule(r13)     // Catch:{ all -> 0x0486 }
            r5.addRule(r9)     // Catch:{ all -> 0x0486 }
            goto L_0x03b8
        L_0x0390:
            r5.addRule(r12)     // Catch:{ all -> 0x0486 }
            r5.addRule(r9)     // Catch:{ all -> 0x0486 }
            goto L_0x03b8
        L_0x0397:
            r5.addRule(r12)     // Catch:{ all -> 0x0486 }
            r5.addRule(r14)     // Catch:{ all -> 0x0486 }
            goto L_0x03b8
        L_0x039e:
            r5.addRule(r12)     // Catch:{ all -> 0x0486 }
            r5.addRule(r9)     // Catch:{ all -> 0x0486 }
            goto L_0x03b8
        L_0x03a5:
            r8 = 13
            r5.addRule(r8)     // Catch:{ all -> 0x0486 }
            goto L_0x03b8
        L_0x03ab:
            r5.addRule(r13)     // Catch:{ all -> 0x0486 }
            r5.addRule(r14)     // Catch:{ all -> 0x0486 }
            goto L_0x03b8
        L_0x03b2:
            r5.addRule(r13)     // Catch:{ all -> 0x0486 }
            r5.addRule(r9)     // Catch:{ all -> 0x0486 }
        L_0x03b8:
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzbyj r9 = new com.google.android.gms.internal.ads.zzbyj     // Catch:{ all -> 0x0486 }
            r9.<init>(r1)     // Catch:{ all -> 0x0486 }
            r8.setOnClickListener(r9)     // Catch:{ all -> 0x0486 }
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x0486 }
            java.lang.String r9 = "Close button"
            r8.setContentDescription(r9)     // Catch:{ all -> 0x0486 }
            android.widget.RelativeLayout r8 = r1.zzr     // Catch:{ all -> 0x0486 }
            android.widget.LinearLayout r9 = r1.zzo     // Catch:{ all -> 0x0486 }
            r8.addView(r9, r5)     // Catch:{ all -> 0x0486 }
            android.widget.PopupWindow r5 = r1.zzq     // Catch:{ RuntimeException -> 0x0428 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0428 }
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ RuntimeException -> 0x0428 }
            android.app.Activity r8 = r1.zzl     // Catch:{ RuntimeException -> 0x0428 }
            r9 = 0
            r9 = r3[r9]     // Catch:{ RuntimeException -> 0x0428 }
            int r8 = com.google.android.gms.internal.ads.zzcgl.zzs(r8, r9)     // Catch:{ RuntimeException -> 0x0428 }
            com.google.android.gms.internal.ads.zzbev.zza()     // Catch:{ RuntimeException -> 0x0428 }
            android.app.Activity r9 = r1.zzl     // Catch:{ RuntimeException -> 0x0428 }
            r10 = r3[r7]     // Catch:{ RuntimeException -> 0x0428 }
            int r9 = com.google.android.gms.internal.ads.zzcgl.zzs(r9, r10)     // Catch:{ RuntimeException -> 0x0428 }
            r10 = 0
            r5.showAtLocation(r0, r10, r8, r9)     // Catch:{ RuntimeException -> 0x0428 }
            r0 = r3[r10]     // Catch:{ all -> 0x0486 }
            r5 = r3[r7]     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzbyr r8 = r1.zzp     // Catch:{ all -> 0x0486 }
            if (r8 == 0) goto L_0x0400
            int r9 = r1.zzi     // Catch:{ all -> 0x0486 }
            int r10 = r1.zzf     // Catch:{ all -> 0x0486 }
            r8.zza(r0, r5, r9, r10)     // Catch:{ all -> 0x0486 }
        L_0x0400:
            com.google.android.gms.internal.ads.zzcmr r0 = r1.zzk     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcoh r4 = com.google.android.gms.internal.ads.zzcoh.zzc(r4, r6)     // Catch:{ all -> 0x0486 }
            r0.zzaf(r4)     // Catch:{ all -> 0x0486 }
            r0 = 0
            r4 = r3[r0]     // Catch:{ all -> 0x0486 }
            r3 = r3[r7]     // Catch:{ all -> 0x0486 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0486 }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x0486 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzr.zzV(r5)     // Catch:{ all -> 0x0486 }
            r0 = r5[r0]     // Catch:{ all -> 0x0486 }
            int r3 = r3 - r0
            int r0 = r1.zzi     // Catch:{ all -> 0x0486 }
            int r5 = r1.zzf     // Catch:{ all -> 0x0486 }
            r1.zzh(r4, r3, r0, r5)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "resized"
            r1.zzj(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0428:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0486 }
            int r4 = r0.length()     // Catch:{ all -> 0x0486 }
            if (r4 == 0) goto L_0x043e
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0486 }
            goto L_0x0443
        L_0x043e:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0486 }
            r0.<init>(r3)     // Catch:{ all -> 0x0486 }
        L_0x0443:
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            android.widget.RelativeLayout r0 = r1.zzr     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r3 = r1.zzk     // Catch:{ all -> 0x0486 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0486 }
            r0.removeView(r3)     // Catch:{ all -> 0x0486 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0486 }
            if (r0 == 0) goto L_0x0468
            android.widget.ImageView r3 = r1.zzn     // Catch:{ all -> 0x0486 }
            r0.removeView(r3)     // Catch:{ all -> 0x0486 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r3 = r1.zzk     // Catch:{ all -> 0x0486 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0486 }
            r0.addView(r3)     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcmr r0 = r1.zzk     // Catch:{ all -> 0x0486 }
            com.google.android.gms.internal.ads.zzcoh r3 = r1.zzm     // Catch:{ all -> 0x0486 }
            r0.zzaf(r3)     // Catch:{ all -> 0x0486 }
        L_0x0468:
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x046a:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0471:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0478:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x047f:
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzf(r0)     // Catch:{ all -> 0x0486 }
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            return
        L_0x0486:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0486 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyk.zza(java.util.Map):void");
    }

    public final void zzb(boolean z) {
        synchronized (this.zzj) {
            PopupWindow popupWindow = this.zzq;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.zzr.removeView((View) this.zzk);
                ViewGroup viewGroup = this.zzs;
                if (viewGroup != null) {
                    viewGroup.removeView(this.zzn);
                    this.zzs.addView((View) this.zzk);
                    this.zzk.zzaf(this.zzm);
                }
                if (z) {
                    zzj("default");
                    zzbyr zzbyr = this.zzp;
                    if (zzbyr != null) {
                        zzbyr.zzb();
                    }
                }
                this.zzq = null;
                this.zzr = null;
                this.zzs = null;
                this.zzo = null;
            }
        }
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzj) {
            this.zzd = i;
            this.zze = i2;
        }
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzj) {
            z = this.zzq != null;
        }
        return z;
    }

    public final void zze(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }
}
