package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeu implements zzex {
    @Nullable
    public static zzeu zzb;
    @VisibleForTesting
    public volatile long zza = 0;
    public final Context zzc;
    public final zzfig zzd;
    public final zzfin zze;
    public final zzfip zzf;
    public final zzfs zzg;
    public final zzfgn zzh;
    public final Executor zzi;
    public final zzhl zzj;
    public final zzfim zzk;
    public final Object zzl = new Object();
    public volatile boolean zzm;
    public volatile boolean zzn = false;

    @VisibleForTesting
    public zzeu(@NonNull Context context, @NonNull zzfgn zzfgn, @NonNull zzfig zzfig, @NonNull zzfin zzfin, @NonNull zzfip zzfip, @NonNull zzfs zzfs, @NonNull Executor executor, @NonNull zzfgj zzfgj, zzhl zzhl) {
        this.zzc = context;
        this.zzh = zzfgn;
        this.zzd = zzfig;
        this.zze = zzfin;
        this.zzf = zzfip;
        this.zzg = zzfs;
        this.zzi = executor;
        this.zzj = zzhl;
        this.zzk = new zzes(this, zzfgj);
    }

    public static synchronized zzeu zza(@NonNull String str, @NonNull Context context, boolean z, boolean z2) {
        zzeu zzeu;
        synchronized (zzeu.class) {
            if (zzb == null) {
                zzfgo zzd2 = zzfgp.zzd();
                zzd2.zza(str);
                zzd2.zzb(z);
                zzfgp zzd3 = zzd2.zzd();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzfgn zzb2 = zzfgn.zzb(context, newCachedThreadPool, z2);
                zzfhg zza2 = zzfhg.zza(context, newCachedThreadPool, zzb2, zzd3);
                zzfr zzfr = new zzfr(context);
                zzfs zzfs = new zzfs(zzd3, zza2, new zzgf(context, zzfr), zzfr);
                zzhl zzb3 = zzfht.zzb(context, zzb2);
                zzfgj zzfgj = new zzfgj();
                Context context2 = context;
                zzeu zzeu2 = new zzeu(context2, zzb2, new zzfig(context, zzb3), new zzfin(context, zzb3, new zzer(zzb2), ((Boolean) zzbex.zzc().zzb(zzbjn.zzbs)).booleanValue()), new zzfip(context, zzfs, zzb2, zzfgj), zzfs, newCachedThreadPool, zzfgj, zzb3);
                zzb = zzeu2;
                zzeu2.zzc();
                zzb.zzk();
            }
            zzeu = zzb;
        }
        return zzeu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (r4.zza().zzc().equals(r5.zzc()) != false) goto L_0x00f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void zzo(com.google.android.gms.internal.ads.zzeu r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.android.gms.internal.ads.zzfif r3 = r12.zzq(r2)
            r4 = 0
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzhr r4 = r3.zza()
            java.lang.String r4 = r4.zza()
            com.google.android.gms.internal.ads.zzhr r3 = r3.zza()
            java.lang.String r3 = r3.zzc()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001f:
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzgeo -> 0x011b }
            r6 = 1
            com.google.android.gms.internal.ads.zzhl r7 = r12.zzj     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzfgn r11 = r12.zzh     // Catch:{ zzgeo -> 0x011b }
            com.google.android.gms.internal.ads.zzfik r3 = com.google.android.gms.internal.ads.zzfgx.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzgeo -> 0x011b }
            byte[] r4 = r3.zzb     // Catch:{ zzgeo -> 0x011b }
            if (r4 == 0) goto L_0x010e
            int r5 = r4.length     // Catch:{ zzgeo -> 0x011b }
            if (r5 != 0) goto L_0x0037
            goto L_0x010e
        L_0x0037:
            com.google.android.gms.internal.ads.zzgcz r4 = com.google.android.gms.internal.ads.zzgcz.zzt(r4)     // Catch:{ NullPointerException -> 0x0101 }
            com.google.android.gms.internal.ads.zzgdo r5 = com.google.android.gms.internal.ads.zzgdo.zza()     // Catch:{ NullPointerException -> 0x0101 }
            com.google.android.gms.internal.ads.zzho r4 = com.google.android.gms.internal.ads.zzho.zze(r4, r5)     // Catch:{ NullPointerException -> 0x0101 }
            com.google.android.gms.internal.ads.zzhr r5 = r4.zza()     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r5 = r5.zza()     // Catch:{ zzgeo -> 0x011b }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgeo -> 0x011b }
            if (r5 != 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzhr r5 = r4.zza()     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r5 = r5.zzc()     // Catch:{ zzgeo -> 0x011b }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgeo -> 0x011b }
            if (r5 != 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzgcz r5 = r4.zzd()     // Catch:{ zzgeo -> 0x011b }
            byte[] r5 = r5.zzz()     // Catch:{ zzgeo -> 0x011b }
            int r5 = r5.length     // Catch:{ zzgeo -> 0x011b }
            if (r5 != 0) goto L_0x006c
            goto L_0x00f4
        L_0x006c:
            com.google.android.gms.internal.ads.zzfif r5 = r12.zzq(r2)     // Catch:{ zzgeo -> 0x011b }
            if (r5 != 0) goto L_0x0073
            goto L_0x009b
        L_0x0073:
            com.google.android.gms.internal.ads.zzhr r5 = r5.zza()     // Catch:{ zzgeo -> 0x011b }
            com.google.android.gms.internal.ads.zzhr r6 = r4.zza()     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r6 = r6.zza()     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r7 = r5.zza()     // Catch:{ zzgeo -> 0x011b }
            boolean r6 = r6.equals(r7)     // Catch:{ zzgeo -> 0x011b }
            if (r6 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzhr r6 = r4.zza()     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r6 = r6.zzc()     // Catch:{ zzgeo -> 0x011b }
            java.lang.String r5 = r5.zzc()     // Catch:{ zzgeo -> 0x011b }
            boolean r5 = r6.equals(r5)     // Catch:{ zzgeo -> 0x011b }
            if (r5 != 0) goto L_0x00f4
        L_0x009b:
            com.google.android.gms.internal.ads.zzfim r5 = r12.zzk     // Catch:{ zzgeo -> 0x011b }
            int r3 = r3.zzc     // Catch:{ zzgeo -> 0x011b }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzbjn.zzbq     // Catch:{ zzgeo -> 0x011b }
            com.google.android.gms.internal.ads.zzbjl r7 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ zzgeo -> 0x011b }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ zzgeo -> 0x011b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzgeo -> 0x011b }
            boolean r6 = r6.booleanValue()     // Catch:{ zzgeo -> 0x011b }
            if (r6 == 0) goto L_0x00c5
            r6 = 3
            if (r3 != r6) goto L_0x00bb
            com.google.android.gms.internal.ads.zzfin r3 = r12.zze     // Catch:{ zzgeo -> 0x011b }
            boolean r3 = r3.zzb(r4)     // Catch:{ zzgeo -> 0x011b }
            goto L_0x00cb
        L_0x00bb:
            r6 = 4
            if (r3 != r6) goto L_0x00cd
            com.google.android.gms.internal.ads.zzfin r3 = r12.zze     // Catch:{ zzgeo -> 0x011b }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzgeo -> 0x011b }
            goto L_0x00cb
        L_0x00c5:
            com.google.android.gms.internal.ads.zzfig r3 = r12.zzd     // Catch:{ zzgeo -> 0x011b }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzgeo -> 0x011b }
        L_0x00cb:
            if (r3 != 0) goto L_0x00da
        L_0x00cd:
            com.google.android.gms.internal.ads.zzfgn r2 = r12.zzh     // Catch:{ zzgeo -> 0x011b }
            r3 = 4009(0xfa9, float:5.618E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzgeo -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzgeo -> 0x011b }
            return
        L_0x00da:
            com.google.android.gms.internal.ads.zzfif r3 = r12.zzq(r2)     // Catch:{ zzgeo -> 0x011b }
            if (r3 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzfip r4 = r12.zzf     // Catch:{ zzgeo -> 0x011b }
            boolean r3 = r4.zza(r3)     // Catch:{ zzgeo -> 0x011b }
            if (r3 == 0) goto L_0x00ea
            r12.zzn = r2     // Catch:{ zzgeo -> 0x011b }
        L_0x00ea:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzgeo -> 0x011b }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzgeo -> 0x011b }
        L_0x00f3:
            return
        L_0x00f4:
            com.google.android.gms.internal.ads.zzfgn r2 = r12.zzh     // Catch:{ zzgeo -> 0x011b }
            r3 = 5010(0x1392, float:7.02E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzgeo -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzgeo -> 0x011b }
            return
        L_0x0101:
            com.google.android.gms.internal.ads.zzfgn r2 = r12.zzh     // Catch:{ zzgeo -> 0x011b }
            r3 = 2030(0x7ee, float:2.845E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzgeo -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzgeo -> 0x011b }
            return
        L_0x010e:
            com.google.android.gms.internal.ads.zzfgn r2 = r12.zzh     // Catch:{ zzgeo -> 0x011b }
            r3 = 5009(0x1391, float:7.019E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzgeo -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzgeo -> 0x011b }
            return
        L_0x011b:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfgn r12 = r12.zzh
            r3 = 4002(0xfa2, float:5.608E-42)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            r12.zzd(r3, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeu.zzo(com.google.android.gms.internal.ads.zzeu):void");
    }

    private final zzfif zzq(int i) {
        if (!zzfht.zza(this.zzj)) {
            return null;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbq)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final synchronized boolean zzb() {
        return this.zzn;
    }

    public final synchronized void zzc() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfif zzq = zzq(1);
        if (zzq == null) {
            this.zzh.zzc(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zza(zzq)) {
            this.zzn = true;
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        zzfgq zzb2 = this.zzf.zzb();
        if (zzb2 != null) {
            try {
                zzb2.zzd((String) null, motionEvent);
            } catch (zzfio e) {
                this.zzh.zzd(e.zza(), -1, e);
            }
        }
    }

    public final void zze(int i, int i2, int i3) {
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        zzk();
        zzfgq zzb2 = this.zzf.zzb();
        if (zzb2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zzb2.zzc(context, (String) null, str, view, activity);
        this.zzh.zze(5000, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map<String, String>) null);
        return zzc2;
    }

    public final String zzg(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final void zzh(View view) {
        this.zzg.zza(view);
    }

    public final String zzi(Context context, View view, Activity activity) {
        zzk();
        zzfgq zzb2 = this.zzf.zzb();
        if (zzb2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb3 = zzb2.zzb(context, (String) null, view, (Activity) null);
        this.zzh.zze(5002, System.currentTimeMillis() - currentTimeMillis, zzb3, (Map<String, String>) null);
        return zzb3;
    }

    public final String zzj(Context context) {
        zzk();
        zzfgq zzb2 = this.zzf.zzb();
        if (zzb2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza2 = zzb2.zza(context, (String) null);
        this.zzh.zze(5001, System.currentTimeMillis() - currentTimeMillis, zza2, (Map<String, String>) null);
        return zza2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk() {
        /*
            r6 = this;
            boolean r0 = r6.zzm
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r6.zzl
            monitor-enter(r0)
            boolean r1 = r6.zzm     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzfip r1 = r6.zzf     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzfif r1 = r1.zzc()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zze(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            com.google.android.gms.internal.ads.zzhl r1 = r6.zzj     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.android.gms.internal.ads.zzfht.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r6.zzi     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzet r2 = new com.google.android.gms.internal.ads.zzet     // Catch:{ all -> 0x003f }
            r2.<init>(r6)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeu.zzk():void");
    }
}
