package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlx {
    public final zzlw zza;
    public final zzlv zzb;
    public final zzajh zzc;
    public final zzmv zzd;
    public int zze;
    @Nullable
    public Object zzf;
    public final Looper zzg;
    public final int zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;

    public zzlx(zzlv zzlv, zzlw zzlw, zzmv zzmv, int i, zzajh zzajh, Looper looper) {
        this.zzb = zzlv;
        this.zza = zzlw;
        this.zzd = zzmv;
        this.zzg = looper;
        this.zzc = zzajh;
        this.zzh = i;
    }

    public final zzlw zza() {
        return this.zza;
    }

    public final zzlx zzb(int i) {
        zzajg.zzd(!this.zzi);
        this.zze = i;
        return this;
    }

    public final int zzc() {
        return this.zze;
    }

    public final zzlx zzd(@Nullable Object obj) {
        zzajg.zzd(!this.zzi);
        this.zzf = obj;
        return this;
    }

    @Nullable
    public final Object zze() {
        return this.zzf;
    }

    public final Looper zzf() {
        return this.zzg;
    }

    public final zzlx zzg() {
        zzajg.zzd(!this.zzi);
        this.zzi = true;
        this.zzb.zzf(this);
        return this;
    }

    public final synchronized boolean zzh() {
        return false;
    }

    public final synchronized void zzi(boolean z) {
        this.zzj = z | this.zzj;
        this.zzk = true;
        notifyAll();
    }

    public final synchronized boolean zzj() throws InterruptedException {
        zzajg.zzd(this.zzi);
        zzajg.zzd(this.zzg.getThread() != Thread.currentThread());
        while (!this.zzk) {
            wait();
        }
        return this.zzj;
    }

    public final synchronized boolean zzk(long j) throws InterruptedException, TimeoutException {
        zzajg.zzd(this.zzi);
        zzajg.zzd(this.zzg.getThread() != Thread.currentThread());
        long j2 = 2000;
        long elapsedRealtime = SystemClock.elapsedRealtime() + 2000;
        while (!this.zzk) {
            if (j2 > 0) {
                wait(j2);
                j2 = elapsedRealtime - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
        return this.zzj;
    }
}
