package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import com.helpshift.analytics.AnalyticsEventKey;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcts implements zzavz, zzdby, zzo, zzdbx {
    public final zzctn zza;
    public final zzcto zzb;
    public final Set<zzcmr> zzc = new HashSet();
    public final zzbut<JSONObject, JSONObject> zzd;
    public final Executor zze;
    public final Clock zzf;
    public final AtomicBoolean zzg = new AtomicBoolean(false);
    @GuardedBy("this")
    public final zzctr zzh = new zzctr();
    public boolean zzi = false;
    public WeakReference<?> zzj = new WeakReference<>(this);

    public zzcts(zzbuq zzbuq, zzcto zzcto, Executor executor, zzctn zzctn, Clock clock) {
        this.zza = zzctn;
        zzbub<JSONObject> zzbub = zzbue.zza;
        this.zzd = zzbuq.zza("google.afma.activeView.handleUpdate", zzbub, zzbub);
        this.zzb = zzcto;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzk() {
        for (zzcmr zzc2 : this.zzc) {
            this.zza.zzc(zzc2);
        }
        this.zza.zzd();
    }

    public final synchronized void zzb(@Nullable Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    public final synchronized void zzbD(@Nullable Context context) {
        this.zzh.zze = AnalyticsEventKey.URL;
        zzg();
        zzk();
        this.zzi = true;
    }

    public final void zzbE() {
    }

    public final synchronized void zzbF() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zza(this);
            zzg();
        }
    }

    public final synchronized void zzbG(@Nullable Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    public final void zzbH() {
    }

    public final void zzbI() {
    }

    public final synchronized void zzbJ() {
        this.zzh.zzb = true;
        zzg();
    }

    public final void zzbK(int i) {
    }

    public final synchronized void zzc(zzavy zzavy) {
        zzctr zzctr = this.zzh;
        zzctr.zza = zzavy.zzj;
        zzctr.zzf = zzavy;
        zzg();
    }

    public final synchronized void zzca() {
        this.zzh.zzb = false;
        zzg();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.ref.WeakReference<?> r0 = r5.zzj     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x005b
            boolean r0 = r5.zzi     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0059
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzg     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzctr r0 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.common.util.Clock r1 = r5.zzf     // Catch:{ Exception -> 0x0051 }
            long r1 = r1.elapsedRealtime()     // Catch:{ Exception -> 0x0051 }
            r0.zzd = r1     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcto r0 = r5.zzb     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzctr r1 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            org.json.JSONObject r0 = r0.zzb(r1)     // Catch:{ Exception -> 0x0051 }
            java.util.Set<com.google.android.gms.internal.ads.zzcmr> r1 = r5.zzc     // Catch:{ Exception -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x002d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcmr r2 = (com.google.android.gms.internal.ads.zzcmr) r2     // Catch:{ Exception -> 0x0051 }
            java.util.concurrent.Executor r3 = r5.zze     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzctq r4 = new com.google.android.gms.internal.ads.zzctq     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r2, r0)     // Catch:{ Exception -> 0x0051 }
            r3.execute(r4)     // Catch:{ Exception -> 0x0051 }
            goto L_0x002d
        L_0x0044:
            com.google.android.gms.internal.ads.zzbut<org.json.JSONObject, org.json.JSONObject> r1 = r5.zzd     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzfqn r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "ActiveViewListener.callActiveViewJs"
            com.google.android.gms.internal.ads.zzchh.zzb(r0, r1)     // Catch:{ Exception -> 0x0051 }
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            java.lang.String r1 = "Failed to call ActiveViewJS"
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r0)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0059:
            monitor-exit(r5)
            return
        L_0x005b:
            r5.zzh()     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x0064
        L_0x0063:
            throw r0
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcts.zzg():void");
    }

    public final synchronized void zzh() {
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzi(zzcmr zzcmr) {
        this.zzc.add(zzcmr);
        this.zza.zzb(zzcmr);
    }

    public final void zzj(Object obj) {
        this.zzj = new WeakReference<>(obj);
    }
}
