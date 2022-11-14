package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfox;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpj<OutputT> extends zzfox.zzi<OutputT> {
    public static final zzfpg zzaJ;
    public static final Logger zzaK = Logger.getLogger(zzfpj.class.getName());
    public volatile int remaining;
    @CheckForNull
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzfpg zzfpg;
        try {
            zzfpg = new zzfph(AtomicReferenceFieldUpdater.newUpdater(zzfpj.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzfpj.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzfpg = new zzfpi((zzfpf) null);
        }
        zzaJ = zzfpg;
        if (th != null) {
            zzaK.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzfpj(int i) {
        this.remaining = i;
    }

    public static /* synthetic */ int zzH(zzfpj zzfpj) {
        int i = zzfpj.remaining - 1;
        zzfpj.remaining = i;
        return i;
    }

    public final Set<Throwable> zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzb(newSetFromMap);
        zzaJ.zza(this, (Set<Throwable>) null, newSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        set2.getClass();
        return set2;
    }

    public final int zzD() {
        return zzaJ.zzb(this);
    }

    public final void zzE() {
        this.seenExceptions = null;
    }

    public abstract void zzb(Set<Throwable> set);
}
