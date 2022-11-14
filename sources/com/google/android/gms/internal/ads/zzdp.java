package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzdp implements zzgee {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    
    public static final zzgef<zzdp> zze = null;
    public final int zzf;

    /* access modifiers changed from: public */
    static {
        zze = new zzdn();
    }

    /* access modifiers changed from: public */
    zzdp(int i) {
        this.zzf = i;
    }

    public static zzdp zza(int i) {
        if (i == 0) {
            return UNKNOWN_PROTO;
        }
        if (i == 1) {
            return AFMA_SIGNALS;
        }
        if (i == 2) {
            return UNITY_SIGNALS;
        }
        if (i != 3) {
            return null;
        }
        return PARTNER_SIGNALS;
    }

    public static zzgeg zzb() {
        return zzdo.zza;
    }

    public final String toString() {
        return "<" + zzdp.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }
}
