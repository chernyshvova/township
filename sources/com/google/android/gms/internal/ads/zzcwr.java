package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcwr extends zzcvj {
    public final zzbnz zzc;
    public final Runnable zzd;
    public final Executor zze;

    public zzcwr(zzcxh zzcxh, zzbnz zzbnz, Runnable runnable, Executor executor) {
        super(zzcxh);
        this.zzc = zzbnz;
        this.zzd = runnable;
        this.zze = executor;
    }

    @WorkerThread
    public final void zzS() {
        this.zze.execute(new zzcwq(this, new zzcwp(new AtomicReference(this.zzd))));
    }

    public final View zza() {
        return null;
    }

    public final void zzb(ViewGroup viewGroup, zzbdp zzbdp) {
    }

    public final zzbhg zzc() {
        return null;
    }

    public final zzeyf zze() {
        return null;
    }

    public final zzeyf zzf() {
        return null;
    }

    public final int zzg() {
        return 0;
    }

    public final void zzh() {
    }

    public final /* synthetic */ void zzj(Runnable runnable) {
        try {
            if (!this.zzc.zzb(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
