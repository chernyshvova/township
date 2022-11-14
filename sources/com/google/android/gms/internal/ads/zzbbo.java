package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzbbo implements zzgee {
    UNSPECIFIED(0),
    CONNECTING(1),
    CONNECTED(2),
    DISCONNECTING(3),
    DISCONNECTED(4),
    SUSPENDED(5);
    
    public static final zzgef<zzbbo> zzg = null;
    public final int zzh;

    /* access modifiers changed from: public */
    static {
        zzg = new zzbbm();
    }

    /* access modifiers changed from: public */
    zzbbo(int i) {
        this.zzh = i;
    }

    public static zzbbo zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return CONNECTING;
        }
        if (i == 2) {
            return CONNECTED;
        }
        if (i == 3) {
            return DISCONNECTING;
        }
        if (i == 4) {
            return DISCONNECTED;
        }
        if (i != 5) {
            return null;
        }
        return SUSPENDED;
    }

    public static zzgeg zzc() {
        return zzbbn.zza;
    }

    public final String toString() {
        return "<" + zzbbo.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzh;
    }
}
