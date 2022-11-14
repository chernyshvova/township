package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaiz {
    public static final zzait zza = new zzait(0, -9223372036854775807L, (zzair) null);
    public static final zzait zzb = new zzait(1, -9223372036854775807L, (zzair) null);
    public static final zzait zzc = new zzait(2, -9223372036854775807L, (zzair) null);
    public static final zzait zzd = new zzait(3, -9223372036854775807L, (zzair) null);
    public final ExecutorService zze = zzalh.zzl("ExoPlayer:Loader:ProgressiveMediaPeriod");
    @Nullable
    public zzaiu<? extends zzaiv> zzf;
    @Nullable
    public IOException zzg;

    public zzaiz(String str) {
    }

    public static zzait zza(boolean z, long j) {
        return new zzait(z ? 1 : 0, j, (zzair) null);
    }

    public final boolean zzb() {
        return this.zzg != null;
    }

    public final void zzc() {
        this.zzg = null;
    }

    public final <T extends zzaiv> long zzd(T t, zzais<T> zzais, int i) {
        Looper myLooper = Looper.myLooper();
        zzajg.zze(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzaiu(this, myLooper, t, zzais, i, elapsedRealtime).zzb(0);
        return elapsedRealtime;
    }

    public final boolean zze() {
        return this.zzf != null;
    }

    public final void zzf() {
        zzaiu<? extends zzaiv> zzaiu = this.zzf;
        zzajg.zze(zzaiu);
        zzaiu.zzc(false);
    }

    public final void zzg(@Nullable zzaiw zzaiw) {
        zzaiu<? extends zzaiv> zzaiu = this.zzf;
        if (zzaiu != null) {
            zzaiu.zzc(true);
        }
        this.zze.execute(new zzaix(zzaiw));
        this.zze.shutdown();
    }

    public final void zzh(int i) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzaiu<? extends zzaiv> zzaiu = this.zzf;
            if (zzaiu != null) {
                zzaiu.zza(i);
                return;
            }
            return;
        }
        throw iOException;
    }
}
