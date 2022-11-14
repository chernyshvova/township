package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfqm<T> extends AtomicReference<Runnable> implements Runnable {
    public static final Runnable zza = new zzfql((zzfqj) null);
    public static final Runnable zzb = new zzfql((zzfqj) null);

    private final void zzb(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzfqk zzfqk = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzfqk)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzfqk = (zzfqk) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzfqk);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !zzd();
            if (z) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zza)) {
                        zzb(currentThread);
                    }
                    zzg(th);
                    return;
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzb(currentThread);
            }
            if (z) {
                zzf(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzfqk) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            str = GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(name).length() + 21), "running=[RUNNING ON ", name, "]");
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzc = zzc();
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzc).length()), str, RESTClient.COMMA_SEPARATOR, zzc);
    }

    public abstract T zza() throws Exception;

    public abstract String zzc();

    public abstract boolean zzd();

    public abstract void zzf(T t);

    public abstract void zzg(Throwable th);

    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzfqk zzfqk = new zzfqk(this, (zzfqj) null);
            zzfqm.super.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzfqk)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }
}
