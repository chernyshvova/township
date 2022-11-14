package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzfhk implements zzgee {
    BLOCKED_REASON_UNKNOWN(1),
    BLOCKED_REASON_BACKGROUND(2);
    
    public static final zzgef<zzfhk> zzc = null;
    public final int zzd;

    /* access modifiers changed from: public */
    static {
        zzc = new zzfhi();
    }

    /* access modifiers changed from: public */
    zzfhk(int i) {
        this.zzd = i;
    }

    public static zzfhk zzb(int i) {
        if (i == 1) {
            return BLOCKED_REASON_UNKNOWN;
        }
        if (i != 2) {
            return null;
        }
        return BLOCKED_REASON_BACKGROUND;
    }

    public static zzgeg zzc() {
        return zzfhj.zza;
    }

    public final String toString() {
        return "<" + zzfhk.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
