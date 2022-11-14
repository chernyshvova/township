package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzauj {
    public final ExecutorService zza = zzava.zzb("Loader:ExtractorMediaPeriod");
    public zzaug<? extends zzauh> zzb;
    public IOException zzc;

    public zzauj(String str) {
    }

    public final <T extends zzauh> long zza(T t, zzauf<T> zzauf, int i) {
        Looper myLooper = Looper.myLooper();
        zzaul.zzd(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzaug(this, myLooper, t, zzauf, i, elapsedRealtime).zzb(0);
        return elapsedRealtime;
    }

    public final boolean zzb() {
        return this.zzb != null;
    }

    public final void zzc() {
        this.zzb.zzc(false);
    }

    public final void zzd(Runnable runnable) {
        zzaug<? extends zzauh> zzaug = this.zzb;
        if (zzaug != null) {
            zzaug.zzc(true);
        }
        this.zza.execute(runnable);
        this.zza.shutdown();
    }

    public final void zze(int i) throws IOException {
        IOException iOException = this.zzc;
        if (iOException == null) {
            zzaug<? extends zzauh> zzaug = this.zzb;
            if (zzaug != null) {
                zzaug.zza(zzaug.zza);
                return;
            }
            return;
        }
        throw iOException;
    }
}
