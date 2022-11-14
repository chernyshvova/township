package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzbap implements zzgee {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    
    public static final zzgef<zzbap> zzd = null;
    public final int zze;

    /* access modifiers changed from: public */
    static {
        zzd = new zzban();
    }

    /* access modifiers changed from: public */
    zzbap(int i) {
        this.zze = i;
    }

    public static zzbap zzb(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzgeg zzc() {
        return zzbao.zza;
    }

    public final String toString() {
        return "<" + zzbap.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zze;
    }
}
