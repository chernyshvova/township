package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzw extends Thread {
    public final BlockingQueue<zzac<?>> zza;
    public final zzv zzb;
    public final zzm zzc;
    public volatile boolean zzd = false;
    public final zzt zze;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>>, com.google.android.gms.internal.ads.zzv] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzm] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzt, com.google.android.gms.internal.ads.zzm] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzw(java.util.concurrent.BlockingQueue r1, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>> r2, com.google.android.gms.internal.ads.zzv r3, com.google.android.gms.internal.ads.zzm r4, com.google.android.gms.internal.ads.zzt r5) {
        /*
            r0 = this;
            r0.<init>()
            r5 = 0
            r0.zzd = r5
            r0.zza = r1
            r0.zzb = r2
            r0.zzc = r3
            r0.zze = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzw.<init>(java.util.concurrent.BlockingQueue, com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzm, com.google.android.gms.internal.ads.zzt, byte[]):void");
    }

    private void zzb() throws InterruptedException {
        zzac take = this.zza.take();
        SystemClock.elapsedRealtime();
        take.zze(3);
        try {
            take.zzc("network-queue-take");
            take.zzl();
            TrafficStats.setThreadStatsTag(take.zzb());
            zzy zza2 = this.zzb.zza(take);
            take.zzc("network-http-complete");
            if (!zza2.zze || !take.zzq()) {
                zzai zzr = take.zzr(zza2);
                take.zzc("network-parse-complete");
                if (zzr.zzb != null) {
                    this.zzc.zzb(take.zzi(), zzr.zzb);
                    take.zzc("network-cache-written");
                }
                take.zzp();
                this.zze.zza(take, zzr, (Runnable) null);
                take.zzv(zzr);
                take.zze(4);
                return;
            }
            take.zzd("not-modified");
            take.zzw();
        } catch (zzal e) {
            SystemClock.elapsedRealtime();
            this.zze.zzb(take, e);
            take.zzw();
        } catch (Exception e2) {
            zzao.zzd(e2, "Unhandled exception %s", e2.toString());
            zzal zzal = new zzal((Throwable) e2);
            SystemClock.elapsedRealtime();
            this.zze.zzb(take, zzal);
            take.zzw();
        } finally {
            take.zze(4);
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzao.zzc("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
