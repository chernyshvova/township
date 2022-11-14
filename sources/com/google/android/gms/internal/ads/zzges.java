package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzges {
    public static final zzgdo zzb = zzgdo.zza();
    public volatile zzgfk zza;
    public volatile zzgcz zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzges)) {
            return false;
        }
        zzges zzges = (zzges) obj;
        zzgfk zzgfk = this.zza;
        zzgfk zzgfk2 = zzges.zza;
        if (zzgfk == null && zzgfk2 == null) {
            return zzb().equals(zzges.zzb());
        }
        if (zzgfk != null && zzgfk2 != null) {
            return zzgfk.equals(zzgfk2);
        }
        if (zzgfk != null) {
            zzges.zzc(zzgfk.zzbe());
            return zzgfk.equals(zzges.zza);
        }
        zzc(zzgfk2.zzbe());
        return this.zza.equals(zzgfk2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgcw) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaw();
        }
        return 0;
    }

    public final zzgcz zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgcz zzgcz = this.zzc;
                return zzgcz;
            }
            if (this.zza == null) {
                this.zzc = zzgcz.zzb;
            } else {
                this.zzc = this.zza.zzan();
            }
            zzgcz zzgcz2 = this.zzc;
            return zzgcz2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzgfk r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzgfk r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzgfk r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzgeo -> 0x0011 }
            com.google.android.gms.internal.ads.zzgcz r0 = com.google.android.gms.internal.ads.zzgcz.zzb     // Catch:{ zzgeo -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzgeo -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgcz r2 = com.google.android.gms.internal.ads.zzgcz.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzges.zzc(com.google.android.gms.internal.ads.zzgfk):void");
    }
}
