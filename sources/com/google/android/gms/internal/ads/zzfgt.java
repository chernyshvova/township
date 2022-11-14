package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgt extends zzfgp {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public /* synthetic */ zzfgt(String str, boolean z, boolean z2, zzfgr zzfgr) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfgp) {
            zzfgp zzfgp = (zzfgp) obj;
            return this.zza.equals(zzfgp.zza()) && this.zzb == zzfgp.zzb() && this.zzc == zzfgp.zzc();
        }
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003;
        if (true == this.zzc) {
            i = 1231;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        StringBuilder sb = new StringBuilder(str.length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzc;
    }
}
