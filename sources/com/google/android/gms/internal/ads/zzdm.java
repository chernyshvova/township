package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzdm implements zzgee {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    public static final zzgef<zzdm> zze = null;
    public final int zzf;

    /* access modifiers changed from: public */
    static {
        zze = new zzdk();
    }

    /* access modifiers changed from: public */
    zzdm(int i) {
        this.zzf = i;
    }

    public static zzdm zzb(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzgeg zzc() {
        return zzdl.zza;
    }

    public final String toString() {
        return "<" + zzdm.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzf;
    }
}
