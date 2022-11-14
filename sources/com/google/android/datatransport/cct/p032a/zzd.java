package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.google.android.datatransport.cct.a.zzd */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzd extends zza {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;

    public /* synthetic */ zzd(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = str7;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        zzd zzd2 = (zzd) ((zza) obj);
        if (this.zza == zzd2.zza && ((str = this.zzb) != null ? str.equals(zzd2.zzb) : zzd2.zzb == null) && ((str2 = this.zzc) != null ? str2.equals(zzd2.zzc) : zzd2.zzc == null) && ((str3 = this.zzd) != null ? str3.equals(zzd2.zzd) : zzd2.zzd == null) && ((str4 = this.zze) != null ? str4.equals(zzd2.zze) : zzd2.zze == null) && ((str5 = this.zzf) != null ? str5.equals(zzd2.zzf) : zzd2.zzf == null) && ((str6 = this.zzg) != null ? str6.equals(zzd2.zzg) : zzd2.zzg == null)) {
            String str7 = this.zzh;
            if (str7 == null) {
                if (zzd2.zzh == null) {
                    return true;
                }
            } else if (str7.equals(zzd2.zzh)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.zza ^ 1000003) * 1000003;
        String str = this.zzb;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzc;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zzd;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.zze;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.zzf;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.zzg;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.zzh;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 ^ i2;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AndroidClientInfo{sdkVersion=");
        outline24.append(this.zza);
        outline24.append(", model=");
        outline24.append(this.zzb);
        outline24.append(", hardware=");
        outline24.append(this.zzc);
        outline24.append(", device=");
        outline24.append(this.zzd);
        outline24.append(", product=");
        outline24.append(this.zze);
        outline24.append(", osBuild=");
        outline24.append(this.zzf);
        outline24.append(", manufacturer=");
        outline24.append(this.zzg);
        outline24.append(", fingerprint=");
        return GeneratedOutlineSupport.outline18(outline24, this.zzh, "}");
    }
}
