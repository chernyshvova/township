package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfbj<R extends zzdam<AdT>, AdT extends zzcxi> {
    public final zzfbc<R, AdT> zza;
    public final zzfqn<zzfba<R, AdT>> zzb;
    @GuardedBy("this")
    public boolean zzc = false;
    @GuardedBy("this")
    public boolean zzd = false;

    public zzfbj(zzfah zzfah, zzfbb<R, AdT> zzfbb, zzfbc<R, AdT> zzfbc) {
        this.zza = zzfbc;
        this.zzb = zzfqe.zzg(zzfqe.zzi(zzfbb.zza(zzfbc), new zzfbg(this, zzfbb, zzfah, zzfbc), zzfbc.zza()), Exception.class, new zzfbh(this, zzfbb), zzfbc.zza());
    }

    public final synchronized void zza(zzfqa<Void> zzfqa) {
        zzfqe.zzp(zzfqe.zzi(this.zzb, zzfbi.zza, this.zza.zza()), zzfqa, this.zza.zza());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfqn<com.google.android.gms.internal.ads.zzfba<R, AdT>> zzb(com.google.android.gms.internal.ads.zzfbc<R, AdT> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzd     // Catch:{ all -> 0x0035 }
            r1 = 0
            if (r0 != 0) goto L_0x0033
            boolean r0 = r2.zzc     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x000b
            goto L_0x0033
        L_0x000b:
            com.google.android.gms.internal.ads.zzfbc<R, AdT> r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfar r0 = r0.zzb()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfar r0 = r3.zzb()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfbc<R, AdT> r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfar r0 = r0.zzb()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfar r3 = r3.zzb()     // Catch:{ all -> 0x0035 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r3 = 1
            r2.zzc = r3     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfqn<com.google.android.gms.internal.ads.zzfba<R, AdT>> r3 = r2.zzb     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)
            return r3
        L_0x0031:
            monitor-exit(r2)
            return r1
        L_0x0033:
            monitor-exit(r2)
            return r1
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbj.zzb(com.google.android.gms.internal.ads.zzfbc):com.google.android.gms.internal.ads.zzfqn");
    }

    public final /* synthetic */ zzfqn zzc(zzfbb zzfbb, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final /* synthetic */ zzfqn zzd(zzfbb zzfbb, zzfah zzfah, zzfbc zzfbc, zzfaq zzfaq) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfbb.zzb(zzfaq);
            if (!this.zzc) {
                zzfah.zzb(zzfbc.zzb(), zzfaq);
                zzfqn zza2 = zzfqe.zza(null);
                return zza2;
            }
            zzfqn zza3 = zzfqe.zza(new zzfba(zzfaq, zzfbc));
            return zza3;
        }
    }
}
