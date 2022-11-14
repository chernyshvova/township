package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpe<InputT, OutputT> extends zzfpj<OutputT> {
    public static final Logger zza = Logger.getLogger(zzfpe.class.getName());
    @CheckForNull
    public zzfmg<? extends zzfqn<? extends InputT>> zzb;
    public final boolean zzc;
    public final boolean zzd;

    public zzfpe(zzfmg<? extends zzfqn<? extends InputT>> zzfmg, boolean z, boolean z2) {
        super(zzfmg.size());
        this.zzb = zzfmg;
        this.zzc = z;
        this.zzd = z2;
    }

    public static /* synthetic */ void zzA(zzfpe zzfpe, zzfmg zzfmg) {
        int zzD = zzfpe.zzD();
        int i = 0;
        zzfke.zzb(zzD >= 0, "Less than 0 remaining futures");
        if (zzD == 0) {
            if (zzfmg != null) {
                zzfom zza2 = zzfmg.iterator();
                while (zza2.hasNext()) {
                    Future future = (Future) zza2.next();
                    if (!future.isCancelled()) {
                        zzfpe.zzK(i, future);
                    }
                    i++;
                }
            }
            zzfpe.zzE();
            zzfpe.zzx();
            zzfpe.zzB(2);
        }
    }

    private final void zzI(Throwable th) {
        if (th == null) {
            throw null;
        } else if (this.zzc && !zzi(th) && zzL(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }

    public static void zzJ(Throwable th) {
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    /* access modifiers changed from: private */
    public final void zzK(int i, Future<? extends InputT> future) {
        try {
            zzw(i, zzfqe.zzq(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    public static boolean zzL(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public void zzB(int i) {
        this.zzb = null;
    }

    public final void zza() {
        zzfmg<? extends zzfqn<? extends InputT>> zzfmg = this.zzb;
        zzfmg.getClass();
        if (zzfmg.isEmpty()) {
            zzx();
        } else if (this.zzc) {
            zzfom<? extends zzfqn<? extends InputT>> zza2 = this.zzb.iterator();
            int i = 0;
            while (zza2.hasNext()) {
                zzfqn zzfqn = (zzfqn) zza2.next();
                zzfqn.zze(new zzfpc(this, zzfqn, i), zzfps.INSTANCE);
                i++;
            }
        } else {
            zzfpd zzfpd = new zzfpd(this, this.zzd ? this.zzb : null);
            zzfom<? extends zzfqn<? extends InputT>> zza3 = this.zzb.iterator();
            while (zza3.hasNext()) {
                ((zzfqn) zza3.next()).zze(zzfpd, zzfps.INSTANCE);
            }
        }
    }

    public final void zzb(Set<Throwable> set) {
        if (set == null) {
            throw null;
        } else if (!isCancelled()) {
            Throwable zzk = zzk();
            zzk.getClass();
            zzL(set, zzk);
        }
    }

    @CheckForNull
    public final String zzc() {
        zzfmg<? extends zzfqn<? extends InputT>> zzfmg = this.zzb;
        if (zzfmg == null) {
            return super.zzc();
        }
        String valueOf = String.valueOf(zzfmg);
        return GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 8), "futures=", valueOf);
    }

    public final void zzd() {
        zzfmg<? extends zzfqn<? extends InputT>> zzfmg = this.zzb;
        boolean z = true;
        zzB(1);
        boolean isCancelled = isCancelled();
        if (zzfmg == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzg = zzg();
            zzfom<? extends zzfqn<? extends InputT>> zza2 = zzfmg.iterator();
            while (zza2.hasNext()) {
                ((Future) zza2.next()).cancel(zzg);
            }
        }
    }

    public abstract void zzw(int i, InputT inputt);

    public abstract void zzx();
}
