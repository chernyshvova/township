package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.lang.Throwable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfow<V, X extends Throwable, F, T> extends zzfpu<V> implements Runnable {
    @CheckForNull
    public zzfqn<? extends V> zza;
    @CheckForNull
    public Class<X> zzb;
    @CheckForNull
    public F zzc;

    public zzfow(zzfqn<? extends V> zzfqn, Class<X> cls, F f) {
        if (zzfqn != null) {
            this.zza = zzfqn;
            this.zzb = cls;
            if (f != null) {
                this.zzc = f;
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzfqn<? extends V> r0 = r10.zza
            java.lang.Class<X> r1 = r10.zzb
            F r2 = r10.zzc
            r3 = 1
            if (r0 != 0) goto L_0x000b
            r4 = 1
            goto L_0x000c
        L_0x000b:
            r4 = 0
        L_0x000c:
            if (r1 != 0) goto L_0x0010
            r5 = 1
            goto L_0x0011
        L_0x0010:
            r5 = 0
        L_0x0011:
            r4 = r4 | r5
            if (r2 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            r3 = r3 | r4
            if (r3 != 0) goto L_0x00a2
            boolean r3 = r10.isCancelled()
            if (r3 == 0) goto L_0x0021
            goto L_0x00a2
        L_0x0021:
            r3 = 0
            r10.zza = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfrf     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            if (r4 == 0) goto L_0x0030
            r4 = r0
            com.google.android.gms.internal.ads.zzfrf r4 = (com.google.android.gms.internal.ads.zzfrf) r4     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            java.lang.Throwable r4 = r4.zzk()     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            goto L_0x0031
        L_0x0030:
            r4 = r3
        L_0x0031:
            if (r4 != 0) goto L_0x0077
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzfqe.zzq(r0)     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            goto L_0x0078
        L_0x0038:
            r4 = move-exception
            goto L_0x0077
        L_0x003a:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0076
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r7 = r6.length()
            int r8 = r4.length()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            int r7 = r7 + 35
            int r7 = r7 + r8
            r9.<init>(r7)
            java.lang.String r7 = "Future type "
            java.lang.String r8 = " threw "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r9, r7, r6, r8, r4)
            java.lang.String r4 = " without a cause"
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            r5.<init>(r4)
        L_0x0076:
            r4 = r5
        L_0x0077:
            r5 = r3
        L_0x0078:
            if (r4 != 0) goto L_0x007e
            r10.zzh(r5)
            return
        L_0x007e:
            boolean r1 = r1.isInstance(r4)
            if (r1 == 0) goto L_0x009f
            java.lang.Object r0 = r10.zzb(r2, r4)     // Catch:{ all -> 0x0090 }
            r10.zzb = r3
            r10.zzc = r3
            r10.zza(r0)
            return
        L_0x0090:
            r0 = move-exception
            r10.zzi(r0)     // Catch:{ all -> 0x0099 }
            r10.zzb = r3
            r10.zzc = r3
            return
        L_0x0099:
            r0 = move-exception
            r10.zzb = r3
            r10.zzc = r3
            throw r0
        L_0x009f:
            r10.zzj(r0)
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfow.run():void");
    }

    public abstract void zza(T t);

    public abstract T zzb(F f, X x) throws Exception;

    @CheckForNull
    public final String zzc() {
        String str;
        zzfqn<? extends V> zzfqn = this.zza;
        Class<X> cls = this.zzb;
        F f = this.zzc;
        String zzc2 = super.zzc();
        if (zzfqn != null) {
            String valueOf = String.valueOf(zzfqn);
            str = GeneratedOutlineSupport.outline19(new StringBuilder(valueOf.length() + 16), "inputFuture=[", valueOf, "], ");
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            String valueOf2 = String.valueOf(cls);
            String valueOf3 = String.valueOf(f);
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(str).length(), 29, valueOf2.length(), valueOf3.length()));
            GeneratedOutlineSupport.outline34(sb, str, "exceptionType=[", valueOf2, "], fallback=[");
            return GeneratedOutlineSupport.outline18(sb, valueOf3, "]");
        } else if (zzc2 == null) {
            return null;
        } else {
            String valueOf4 = String.valueOf(str);
            return zzc2.length() != 0 ? valueOf4.concat(zzc2) : new String(valueOf4);
        }
    }

    public final void zzd() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }
}
