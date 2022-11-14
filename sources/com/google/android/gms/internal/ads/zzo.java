package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzo extends Thread {
    public static final boolean zza = zzao.zzb;
    public final BlockingQueue<zzac<?>> zzb;
    public final BlockingQueue<zzac<?>> zzc;
    public final zzm zzd;
    public volatile boolean zze = false;
    public final zzap zzf;
    public final zzt zzg;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>>, com.google.android.gms.internal.ads.zzm] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzt, com.google.android.gms.internal.ads.zzm] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzo(java.util.concurrent.BlockingQueue r1, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>> r2, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>> r3, com.google.android.gms.internal.ads.zzm r4, com.google.android.gms.internal.ads.zzt r5) {
        /*
            r0 = this;
            r0.<init>()
            r5 = 0
            r0.zze = r5
            r0.zzb = r1
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            com.google.android.gms.internal.ads.zzap r1 = new com.google.android.gms.internal.ads.zzap
            r3 = 0
            r1.<init>(r0, r2, r4, r3)
            r0.zzf = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzo.<init>(java.util.concurrent.BlockingQueue, java.util.concurrent.BlockingQueue, com.google.android.gms.internal.ads.zzm, com.google.android.gms.internal.ads.zzt, byte[]):void");
    }

    private void zzc() throws InterruptedException {
        zzac take = this.zzb.take();
        take.zzc("cache-queue-take");
        take.zze(1);
        try {
            take.zzl();
            zzl zza2 = this.zzd.zza(take.zzi());
            if (zza2 == null) {
                take.zzc("cache-miss");
                if (!this.zzf.zzc(take)) {
                    this.zzc.put(take);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (zza2.zza(currentTimeMillis)) {
                take.zzc("cache-hit-expired");
                take.zzj(zza2);
                if (!this.zzf.zzc(take)) {
                    this.zzc.put(take);
                }
                take.zze(2);
                return;
            }
            take.zzc("cache-hit");
            zzai zzr = take.zzr(new zzy(zza2.zza, zza2.zzg));
            take.zzc("cache-hit-parsed");
            if (!zzr.zzc()) {
                take.zzc("cache-parsing-failed");
                this.zzd.zzd(take.zzi(), true);
                take.zzj((zzl) null);
                if (!this.zzf.zzc(take)) {
                    this.zzc.put(take);
                }
                take.zze(2);
                return;
            }
            if (zza2.zzf < currentTimeMillis) {
                take.zzc("cache-hit-refresh-needed");
                take.zzj(zza2);
                zzr.zzd = true;
                if (!this.zzf.zzc(take)) {
                    this.zzg.zza(take, zzr, new zzn(this, take));
                } else {
                    this.zzg.zza(take, zzr, (Runnable) null);
                }
            } else {
                this.zzg.zza(take, zzr, (Runnable) null);
            }
            take.zze(2);
        } finally {
            take.zze(2);
        }
    }

    public final void run() {
        if (zza) {
            zzao.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzc();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzao.zzc("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zze = true;
        interrupt();
    }
}
