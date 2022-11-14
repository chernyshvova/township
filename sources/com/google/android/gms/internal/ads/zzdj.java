package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzdj implements zzgee {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5);
    
    public static final zzgef<zzdj> zzg = null;
    public final int zzh;

    /* access modifiers changed from: public */
    static {
        zzg = new zzdh();
    }

    /* access modifiers changed from: public */
    zzdj(int i) {
        this.zzh = i;
    }

    public static zzdj zzb(int i) {
        if (i == 0) {
            return UNKNOWN_ENCRYPTION_METHOD;
        }
        if (i == 1) {
            return BITSLICER;
        }
        if (i == 2) {
            return TINK_HYBRID;
        }
        if (i == 3) {
            return UNENCRYPTED;
        }
        if (i == 4) {
            return DG;
        }
        if (i != 5) {
            return null;
        }
        return DG_XTEA;
    }

    public static zzgeg zzc() {
        return zzdi.zza;
    }

    public final String toString() {
        return "<" + zzdj.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzh;
    }
}
