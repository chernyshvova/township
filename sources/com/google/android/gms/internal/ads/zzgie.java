package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzgie implements zzgee {
    UNKNOWN(0),
    URL_PHISHING(1),
    URL_MALWARE(2),
    URL_UNWANTED(3),
    CLIENT_SIDE_PHISHING_URL(4),
    CLIENT_SIDE_MALWARE_URL(5),
    DANGEROUS_DOWNLOAD_RECOVERY(6),
    DANGEROUS_DOWNLOAD_WARNING(7),
    OCTAGON_AD(8),
    OCTAGON_AD_SB_MATCH(9);
    
    public static final zzgef<zzgie> zzk = null;
    public final int zzl;

    /* access modifiers changed from: public */
    static {
        zzk = new zzgic();
    }

    /* access modifiers changed from: public */
    zzgie(int i) {
        this.zzl = i;
    }

    public static zzgie zzb(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return URL_PHISHING;
            case 2:
                return URL_MALWARE;
            case 3:
                return URL_UNWANTED;
            case 4:
                return CLIENT_SIDE_PHISHING_URL;
            case 5:
                return CLIENT_SIDE_MALWARE_URL;
            case 6:
                return DANGEROUS_DOWNLOAD_RECOVERY;
            case 7:
                return DANGEROUS_DOWNLOAD_WARNING;
            case 8:
                return OCTAGON_AD;
            case 9:
                return OCTAGON_AD_SB_MATCH;
            default:
                return null;
        }
    }

    public static zzgeg zzc() {
        return zzgid.zza;
    }

    public final String toString() {
        return "<" + zzgie.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzl + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzl;
    }
}
