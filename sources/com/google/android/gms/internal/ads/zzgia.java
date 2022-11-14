package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzgia implements zzgee {
    TYPE_UNKNOWN(0),
    TYPE_CREATIVE(1);
    
    public static final zzgef<zzgia> zzc = null;
    public final int zzd;

    /* access modifiers changed from: public */
    static {
        zzc = new zzghy();
    }

    /* access modifiers changed from: public */
    zzgia(int i) {
        this.zzd = i;
    }

    public static zzgia zzb(int i) {
        if (i == 0) {
            return TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return TYPE_CREATIVE;
    }

    public static zzgeg zzc() {
        return zzghz.zza;
    }

    public final String toString() {
        return "<" + zzgia.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
