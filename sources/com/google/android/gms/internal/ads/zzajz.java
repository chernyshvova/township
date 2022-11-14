package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajz<T> {
    public final zzajh zza;
    public final zzajt zzb;
    public final zzajx<T> zzc;
    public final CopyOnWriteArraySet<zzajy<T>> zzd;
    public final ArrayDeque<Runnable> zze;
    public final ArrayDeque<Runnable> zzf;
    public boolean zzg;

    public zzajz(Looper looper, zzajh zzajh, zzajx<T> zzajx) {
        this(new CopyOnWriteArraySet(), looper, zzajh, zzajx);
    }

    @CheckResult
    public final zzajz<T> zza(Looper looper, zzajx<T> zzajx) {
        return new zzajz<>(this.zzd, looper, this.zza, zzajx);
    }

    public final void zzb(T t) {
        if (this.zzg) {
            return;
        }
        if (t != null) {
            this.zzd.add(new zzajy(t));
            return;
        }
        throw null;
    }

    public final void zzc(T t) {
        Iterator<zzajy<T>> it = this.zzd.iterator();
        while (it.hasNext()) {
            zzajy next = it.next();
            if (next.zza.equals(t)) {
                next.zza(this.zzc);
                this.zzd.remove(next);
            }
        }
    }

    public final void zzd(int i, zzajw<T> zzajw) {
        this.zzf.add(new zzajv(new CopyOnWriteArraySet(this.zzd), i, zzajw));
    }

    public final void zze() {
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zza(0)) {
                this.zzb.zzb(0).zza();
            }
            boolean isEmpty = this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!(!isEmpty)) {
                while (!this.zze.isEmpty()) {
                    this.zze.peekFirst().run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzf() {
        Iterator<zzajy<T>> it = this.zzd.iterator();
        while (it.hasNext()) {
            it.next().zza(this.zzc);
        }
        this.zzd.clear();
        this.zzg = true;
    }

    public final void zzg(int i, zzajw<T> zzajw) {
        this.zzb.zze(1, 1036, 0, zzajw).zza();
    }

    public final /* bridge */ /* synthetic */ boolean zzh(Message message) {
        int i = message.what;
        if (i == 0) {
            Iterator<zzajy<T>> it = this.zzd.iterator();
            while (it.hasNext()) {
                it.next().zzc(this.zzc);
                if (this.zzb.zza(0)) {
                    break;
                }
            }
        } else if (i == 1) {
            zzd(message.arg1, (zzajw) message.obj);
            zze();
            zzf();
        }
        return true;
    }

    public zzajz(CopyOnWriteArraySet<zzajy<T>> copyOnWriteArraySet, Looper looper, zzajh zzajh, zzajx<T> zzajx) {
        this.zza = zzajh;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzajx;
        this.zze = new ArrayDeque<>();
        this.zzf = new ArrayDeque<>();
        this.zzb = zzajh.zza(looper, new zzaju(this));
    }
}
