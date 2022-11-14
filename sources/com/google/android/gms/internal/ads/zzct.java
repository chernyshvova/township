package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzct implements zzgee {
    DEVICE_IDENTIFIER_NO_ID(0),
    DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
    DEVICE_IDENTIFIER_GLOBAL_ID(2),
    DEVICE_IDENTIFIER_ADVERTISER_ID(3),
    DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
    DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
    DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6),
    DEVICE_IDENTIFIER_PER_APP_ID(7),
    DEVICE_IDENTIFIER_PER_APP_ID_V2(8);
    
    public static final zzgef<zzct> zzj = null;
    public final int zzk;

    /* access modifiers changed from: public */
    static {
        zzj = new zzcr();
    }

    /* access modifiers changed from: public */
    zzct(int i) {
        this.zzk = i;
    }

    public static zzct zzb(int i) {
        switch (i) {
            case 0:
                return DEVICE_IDENTIFIER_NO_ID;
            case 1:
                return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
            case 2:
                return DEVICE_IDENTIFIER_GLOBAL_ID;
            case 3:
                return DEVICE_IDENTIFIER_ADVERTISER_ID;
            case 4:
                return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
            case 5:
                return DEVICE_IDENTIFIER_ANDROID_AD_ID;
            case 6:
                return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
            case 7:
                return DEVICE_IDENTIFIER_PER_APP_ID;
            case 8:
                return DEVICE_IDENTIFIER_PER_APP_ID_V2;
            default:
                return null;
        }
    }

    public static zzgeg zzc() {
        return zzcs.zza;
    }

    public final String toString() {
        return "<" + zzct.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzk;
    }
}
