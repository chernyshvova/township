package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakp {
    @Nullable
    public static zzakp zza;
    public final Handler zzb = new Handler(Looper.getMainLooper());
    public final CopyOnWriteArrayList<WeakReference<zzakm>> zzc = new CopyOnWriteArrayList<>();
    public final Object zzd = new Object();
    @GuardedBy("networkTypeLock")
    public int zze = 0;

    public zzakp(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new zzakn(this, (zzakl) null), intentFilter);
    }

    public static synchronized zzakp zza(Context context) {
        zzakp zzakp;
        synchronized (zzakp.class) {
            if (zza == null) {
                zza = new zzakp(context);
            }
            zzakp = zza;
        }
        return zzakp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r0.hasNext() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = r0.next();
        r2 = (com.google.android.gms.internal.ads.zzakm) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r2 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r2.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.zzc.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = r3.zzc.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void zzd(com.google.android.gms.internal.ads.zzakp r3, int r4) {
        /*
            java.lang.Object r0 = r3.zzd
            monitor-enter(r0)
            int r1 = r3.zze     // Catch:{ all -> 0x0031 }
            if (r1 != r4) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0009:
            r3.zze = r4     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzakm>> r0 = r3.zzc
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            com.google.android.gms.internal.ads.zzakm r2 = (com.google.android.gms.internal.ads.zzakm) r2
            if (r2 == 0) goto L_0x002a
            r2.zza(r4)
            goto L_0x0012
        L_0x002a:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzakm>> r2 = r3.zzc
            r2.remove(r1)
            goto L_0x0012
        L_0x0030:
            return
        L_0x0031:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            goto L_0x0035
        L_0x0034:
            throw r3
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakp.zzd(com.google.android.gms.internal.ads.zzakp, int):void");
    }

    public final void zzb(zzakm zzakm) {
        Iterator<WeakReference<zzakm>> it = this.zzc.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (next.get() == null) {
                this.zzc.remove(next);
            }
        }
        this.zzc.add(new WeakReference(zzakm));
        this.zzb.post(new zzakk(this, zzakm));
    }

    public final int zzc() {
        int i;
        synchronized (this.zzd) {
            i = this.zze;
        }
        return i;
    }
}
