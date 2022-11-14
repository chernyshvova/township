package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzbal implements zzgee {
    PLATFORM_UNSPECIFIED(0),
    IOS(1),
    ANDROID(2);
    
    public static final zzgef<zzbal> zzd = null;
    public final int zze;

    /* access modifiers changed from: public */
    static {
        zzd = new zzbaj();
    }

    /* access modifiers changed from: public */
    zzbal(int i) {
        this.zze = i;
    }

    public static zzbal zza(int i) {
        if (i == 0) {
            return PLATFORM_UNSPECIFIED;
        }
        if (i == 1) {
            return IOS;
        }
        if (i != 2) {
            return null;
        }
        return ANDROID;
    }

    public static zzgeg zzb() {
        return zzbak.zza;
    }

    public final String toString() {
        return "<" + zzbal.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }
}
