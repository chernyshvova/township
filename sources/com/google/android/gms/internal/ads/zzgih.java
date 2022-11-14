package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzgih implements zzgee {
    AD_RESOURCE_UNKNOWN(0),
    AD_RESOURCE_CREATIVE(1),
    AD_RESOURCE_POST_CLICK(2),
    AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
    
    public static final zzgef<zzgih> zze = null;
    public final int zzf;

    /* access modifiers changed from: public */
    static {
        zze = new zzgif();
    }

    /* access modifiers changed from: public */
    zzgih(int i) {
        this.zzf = i;
    }

    public static zzgih zzb(int i) {
        if (i == 0) {
            return AD_RESOURCE_UNKNOWN;
        }
        if (i == 1) {
            return AD_RESOURCE_CREATIVE;
        }
        if (i == 2) {
            return AD_RESOURCE_POST_CLICK;
        }
        if (i != 3) {
            return null;
        }
        return AD_RESOURCE_AUTO_CLICK_DESTINATION;
    }

    public static zzgeg zzc() {
        return zzgig.zza;
    }

    public final String toString() {
        return "<" + zzgih.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzf;
    }
}
