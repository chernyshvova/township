package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzfhr implements zzgee {
    EVENT_TYPE_UNKNOWN(0),
    BLOCKED_IMPRESSION(1);
    
    public static final zzgef<zzfhr> zzc = null;
    public final int zzd;

    /* access modifiers changed from: public */
    static {
        zzc = new zzfhp();
    }

    /* access modifiers changed from: public */
    zzfhr(int i) {
        this.zzd = i;
    }

    public static zzfhr zzb(int i) {
        if (i == 0) {
            return EVENT_TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return BLOCKED_IMPRESSION;
    }

    public static zzgeg zzc() {
        return zzfhq.zza;
    }

    public final String toString() {
        return "<" + zzfhr.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzd;
    }
}
