package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzghj implements zzgee {
    SAFE(0),
    DANGEROUS(1),
    UNKNOWN(2),
    POTENTIALLY_UNWANTED(3),
    DANGEROUS_HOST(4);
    
    public static final zzgef<zzghj> zzf = null;
    public final int zzg;

    /* access modifiers changed from: public */
    static {
        zzf = new zzghh();
    }

    /* access modifiers changed from: public */
    zzghj(int i) {
        this.zzg = i;
    }

    public static zzghj zza(int i) {
        if (i == 0) {
            return SAFE;
        }
        if (i == 1) {
            return DANGEROUS;
        }
        if (i == 2) {
            return UNKNOWN;
        }
        if (i == 3) {
            return POTENTIALLY_UNWANTED;
        }
        if (i != 4) {
            return null;
        }
        return DANGEROUS_HOST;
    }

    public static zzgeg zzb() {
        return zzghi.zza;
    }

    public final String toString() {
        return "<" + zzghj.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
