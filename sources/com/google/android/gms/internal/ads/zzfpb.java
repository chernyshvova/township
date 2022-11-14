package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpb<I, O, F, T> extends zzfpu<O> implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    @CheckForNull
    public zzfqn<? extends I> zza;
    @CheckForNull
    public F zzb;

    public zzfpb(zzfqn<? extends I> zzfqn, F f) {
        if (zzfqn != null) {
            this.zza = zzfqn;
            if (f != null) {
                this.zzb = f;
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void run() {
        zzfqn<? extends I> zzfqn = this.zza;
        F f = this.zzb;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzfqn == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zza = null;
            if (zzfqn.isCancelled()) {
                zzj(zzfqn);
                return;
            }
            try {
                try {
                    Object zzb2 = zzb(f, zzfqe.zzq(zzfqn));
                    this.zzb = null;
                    zza(zzb2);
                } catch (Throwable th) {
                    this.zzb = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                zzi(e.getCause());
            } catch (RuntimeException e2) {
                zzi(e2);
            } catch (Error e3) {
                zzi(e3);
            }
        }
    }

    public abstract void zza(T t);

    public abstract T zzb(F f, I i) throws Exception;

    @CheckForNull
    public final String zzc() {
        String str;
        zzfqn<? extends I> zzfqn = this.zza;
        F f = this.zzb;
        String zzc2 = super.zzc();
        if (zzfqn != null) {
            String valueOf = String.valueOf(zzfqn);
            str = GeneratedOutlineSupport.outline19(new StringBuilder(valueOf.length() + 16), "inputFuture=[", valueOf, "], ");
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            return GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(str).length() + 11 + valueOf2.length()), str, "function=[", valueOf2, "]");
        } else if (zzc2 == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            return zzc2.length() != 0 ? valueOf3.concat(zzc2) : new String(valueOf3);
        }
    }

    public final void zzd() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
    }
}
