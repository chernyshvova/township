package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzio {
    public static final zzhl zza = zzhl.zza();
    public zzgp zzb;
    public volatile zzjj zzc;
    public volatile zzgp zzd;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzjj zzb(com.google.android.gms.internal.measurement.zzjj r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzjj r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzjj r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzij -> 0x0012 }
            com.google.android.gms.internal.measurement.zzgp r0 = com.google.android.gms.internal.measurement.zzgp.zza     // Catch:{ zzij -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzij -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzgp r2 = com.google.android.gms.internal.measurement.zzgp.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzjj r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzio.zzb(com.google.android.gms.internal.measurement.zzjj):com.google.android.gms.internal.measurement.zzjj");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzio)) {
            return false;
        }
        zzio zzio = (zzio) obj;
        zzjj zzjj = this.zzc;
        zzjj zzjj2 = zzio.zzc;
        if (zzjj == null && zzjj2 == null) {
            return zzc().equals(zzio.zzc());
        }
        if (zzjj != null && zzjj2 != null) {
            return zzjj.equals(zzjj2);
        }
        if (zzjj != null) {
            return zzjj.equals(zzio.zzb(zzjj.zzbv()));
        }
        return zzb(zzjj2.zzbv()).equals(zzjj2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjj zza(zzjj zzjj) {
        zzjj zzjj2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjj;
        return zzjj2;
    }

    public final zzgp zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzgp zzgp = this.zzd;
                return zzgp;
            }
            if (this.zzc == null) {
                this.zzd = zzgp.zza;
            } else {
                this.zzd = this.zzc.zzbj();
            }
            zzgp zzgp2 = this.zzd;
            return zzgp2;
        }
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbp();
        }
        return 0;
    }
}
