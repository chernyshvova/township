package com.google.android.gms.internal.drive;

public class zzkx {
    public static final zzjx zzng = zzjx.zzci();
    public zzjc zzth;
    public volatile zzlq zzti;
    public volatile zzjc zztj;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.drive.zzlq zzh(com.google.android.gms.internal.drive.zzlq r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.drive.zzlq r0 = r1.zzti
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.drive.zzlq r0 = r1.zzti     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzti = r2     // Catch:{ zzkq -> 0x0012 }
            com.google.android.gms.internal.drive.zzjc r0 = com.google.android.gms.internal.drive.zzjc.zznq     // Catch:{ zzkq -> 0x0012 }
            r1.zztj = r0     // Catch:{ zzkq -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzti = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.drive.zzjc r2 = com.google.android.gms.internal.drive.zzjc.zznq     // Catch:{ all -> 0x001a }
            r1.zztj = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.drive.zzlq r2 = r1.zzti
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzkx.zzh(com.google.android.gms.internal.drive.zzlq):com.google.android.gms.internal.drive.zzlq");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkx)) {
            return false;
        }
        zzkx zzkx = (zzkx) obj;
        zzlq zzlq = this.zzti;
        zzlq zzlq2 = zzkx.zzti;
        if (zzlq == null && zzlq2 == null) {
            return zzbl().equals(zzkx.zzbl());
        }
        if (zzlq != null && zzlq2 != null) {
            return zzlq.equals(zzlq2);
        }
        if (zzlq != null) {
            return zzlq.equals(zzkx.zzh(zzlq.zzda()));
        }
        return zzh(zzlq2.zzda()).equals(zzlq2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjc zzbl() {
        if (this.zztj != null) {
            return this.zztj;
        }
        synchronized (this) {
            if (this.zztj != null) {
                zzjc zzjc = this.zztj;
                return zzjc;
            }
            if (this.zzti == null) {
                this.zztj = zzjc.zznq;
            } else {
                this.zztj = this.zzti.zzbl();
            }
            zzjc zzjc2 = this.zztj;
            return zzjc2;
        }
    }

    public final int zzcx() {
        if (this.zztj != null) {
            return this.zztj.size();
        }
        if (this.zzti != null) {
            return this.zzti.zzcx();
        }
        return 0;
    }

    public final zzlq zzi(zzlq zzlq) {
        zzlq zzlq2 = this.zzti;
        this.zzth = null;
        this.zztj = null;
        this.zzti = zzlq;
        return zzlq2;
    }
}
