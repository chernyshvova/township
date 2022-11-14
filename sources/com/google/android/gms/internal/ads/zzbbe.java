package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzbbe implements zzgee {
    NETWORKTYPE_UNSPECIFIED(0),
    CELL(1),
    WIFI(2);
    
    public static final zzgef<zzbbe> zzd = null;
    public final int zze;

    /* access modifiers changed from: public */
    static {
        zzd = new zzbbc();
    }

    /* access modifiers changed from: public */
    zzbbe(int i) {
        this.zze = i;
    }

    public static zzbbe zzb(int i) {
        if (i == 0) {
            return NETWORKTYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return CELL;
        }
        if (i != 2) {
            return null;
        }
        return WIFI;
    }

    public static zzgeg zzc() {
        return zzbbd.zza;
    }

    public final String toString() {
        return "<" + zzbbe.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zze;
    }
}
