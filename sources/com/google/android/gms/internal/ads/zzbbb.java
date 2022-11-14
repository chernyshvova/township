package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzbbb implements zzgee {
    CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
    TWO_G(1),
    THREE_G(2),
    zzd(4);
    
    public static final zzgef<zzbbb> zze = null;
    public final int zzf;

    /* access modifiers changed from: public */
    static {
        zze = new zzbaz();
    }

    /* access modifiers changed from: public */
    zzbbb(int i) {
        this.zzf = i;
    }

    public static zzbbb zzb(int i) {
        if (i == 0) {
            return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return TWO_G;
        }
        if (i == 2) {
            return THREE_G;
        }
        if (i != 4) {
            return null;
        }
        return zzd;
    }

    public static zzgeg zzc() {
        return zzbba.zza;
    }

    public final String toString() {
        return "<" + zzbbb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzf;
    }
}
