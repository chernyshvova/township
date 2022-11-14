package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzca implements zzgee {
    UNKNOWN(0),
    ENABLED(1),
    DISABLED(2);
    
    public static final zzgef<zzca> zzd = null;
    public final int zze;

    /* access modifiers changed from: public */
    static {
        zzd = new zzby();
    }

    /* access modifiers changed from: public */
    zzca(int i) {
        this.zze = i;
    }

    public static zzca zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i != 2) {
            return null;
        }
        return DISABLED;
    }

    public static zzgeg zzc() {
        return zzbz.zza;
    }

    public final String toString() {
        return "<" + zzca.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zze;
    }
}
