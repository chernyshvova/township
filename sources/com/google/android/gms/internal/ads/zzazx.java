package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzazx implements zzgee {
    AD_FORMAT_TYPE_UNSPECIFIED(0),
    BANNER(1),
    INTERSTITIAL(2),
    NATIVE_EXPRESS(3),
    NATIVE_CONTENT(4),
    NATIVE_APP_INSTALL(5),
    NATIVE_CUSTOM_TEMPLATE(6),
    DFP_BANNER(7),
    DFP_INTERSTITIAL(8),
    REWARD_BASED_VIDEO_AD(9),
    BANNER_SEARCH_ADS(10);
    
    public static final zzgef<zzazx> zzl = null;
    public final int zzm;

    /* access modifiers changed from: public */
    static {
        zzl = new zzazv();
    }

    /* access modifiers changed from: public */
    zzazx(int i) {
        this.zzm = i;
    }

    public static zzazx zzb(int i) {
        switch (i) {
            case 0:
                return AD_FORMAT_TYPE_UNSPECIFIED;
            case 1:
                return BANNER;
            case 2:
                return INTERSTITIAL;
            case 3:
                return NATIVE_EXPRESS;
            case 4:
                return NATIVE_CONTENT;
            case 5:
                return NATIVE_APP_INSTALL;
            case 6:
                return NATIVE_CUSTOM_TEMPLATE;
            case 7:
                return DFP_BANNER;
            case 8:
                return DFP_INTERSTITIAL;
            case 9:
                return REWARD_BASED_VIDEO_AD;
            case 10:
                return BANNER_SEARCH_ADS;
            default:
                return null;
        }
    }

    public static zzgeg zzc() {
        return zzazw.zza;
    }

    public final String toString() {
        return "<" + zzazx.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzm + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzm;
    }
}
