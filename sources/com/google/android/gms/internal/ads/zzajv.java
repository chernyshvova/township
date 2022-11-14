package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzajv implements Runnable {
    public final CopyOnWriteArraySet zza;
    public final int zzb;
    public final zzajw zzc;

    public zzajv(CopyOnWriteArraySet copyOnWriteArraySet, int i, zzajw zzajw) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i;
        this.zzc = zzajw;
    }

    public final void run() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.zza;
        int i = this.zzb;
        zzajw zzajw = this.zzc;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zzajy) it.next()).zzb(i, zzajw);
        }
    }
}
