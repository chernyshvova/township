package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawp {
    @VisibleForTesting
    public int zza;
    public final Object zzb = new Object();
    public final List<zzawo> zzc = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        return r1;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzawo zza(boolean r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zzb
            monitor-enter(r0)
            java.util.List<com.google.android.gms.internal.ads.zzawo> r1 = r8.zzc     // Catch:{ all -> 0x0061 }
            int r1 = r1.size()     // Catch:{ all -> 0x0061 }
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r9 = "Queue empty"
            com.google.android.gms.internal.ads.zzcgs.zzd(r9)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r2
        L_0x0013:
            java.util.List<com.google.android.gms.internal.ads.zzawo> r1 = r8.zzc     // Catch:{ all -> 0x0061 }
            int r1 = r1.size()     // Catch:{ all -> 0x0061 }
            r3 = 2
            r4 = 0
            if (r1 < r3) goto L_0x004c
            java.util.List<com.google.android.gms.internal.ads.zzawo> r9 = r8.zzc     // Catch:{ all -> 0x0061 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0061 }
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
        L_0x0026:
            boolean r5 = r9.hasNext()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r9.next()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzawo r5 = (com.google.android.gms.internal.ads.zzawo) r5     // Catch:{ all -> 0x0061 }
            int r6 = r5.zzm()     // Catch:{ all -> 0x0061 }
            if (r6 <= r1) goto L_0x0039
            r4 = r3
        L_0x0039:
            if (r6 <= r1) goto L_0x003d
            r7 = r6
            goto L_0x003e
        L_0x003d:
            r7 = r1
        L_0x003e:
            if (r6 <= r1) goto L_0x0041
            r2 = r5
        L_0x0041:
            int r3 = r3 + 1
            r1 = r7
            goto L_0x0026
        L_0x0045:
            java.util.List<com.google.android.gms.internal.ads.zzawo> r9 = r8.zzc     // Catch:{ all -> 0x0061 }
            r9.remove(r4)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r2
        L_0x004c:
            java.util.List<com.google.android.gms.internal.ads.zzawo> r1 = r8.zzc     // Catch:{ all -> 0x0061 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzawo r1 = (com.google.android.gms.internal.ads.zzawo) r1     // Catch:{ all -> 0x0061 }
            if (r9 == 0) goto L_0x005c
            java.util.List<com.google.android.gms.internal.ads.zzawo> r9 = r8.zzc     // Catch:{ all -> 0x0061 }
            r9.remove(r4)     // Catch:{ all -> 0x0061 }
            goto L_0x005f
        L_0x005c:
            r1.zze()     // Catch:{ all -> 0x0061 }
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r1
        L_0x0061:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0065
        L_0x0064:
            throw r9
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawp.zza(boolean):com.google.android.gms.internal.ads.zzawo");
    }

    public final boolean zzb(zzawo zzawo) {
        synchronized (this.zzb) {
            if (this.zzc.contains(zzawo)) {
                return true;
            }
            return false;
        }
    }

    public final boolean zzc(zzawo zzawo) {
        synchronized (this.zzb) {
            Iterator<zzawo> it = this.zzc.iterator();
            while (it.hasNext()) {
                zzawo next = it.next();
                if (!zzs.zzg().zzl().zzd()) {
                    if (zzawo != next && next.zzb().equals(zzawo.zzb())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzs.zzg().zzl().zzh() && zzawo != next && next.zzd().equals(zzawo.zzd())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzd(zzawo zzawo) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                int size = this.zzc.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzcgs.zzd(sb.toString());
                this.zzc.remove(0);
            }
            int i = this.zza;
            this.zza = i + 1;
            zzawo.zzn(i);
            zzawo.zzj();
            this.zzc.add(zzawo);
        }
    }
}
