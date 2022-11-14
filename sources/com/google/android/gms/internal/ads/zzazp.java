package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzazp implements zzgee {
    UNSPECIFIED(0),
    IN_MEMORY(1);
    
    public static final zzgef<zzazp> zzc = null;
    public final int zzd;

    /* access modifiers changed from: public */
    static {
        zzc = new zzazn();
    }

    /* access modifiers changed from: public */
    zzazp(int i) {
        this.zzd = i;
    }

    public static zzazp zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i != 1) {
            return null;
        }
        return IN_MEMORY;
    }

    public static zzgeg zzc() {
        return zzazo.zza;
    }

    public final String toString() {
        return "<" + zzazp.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
