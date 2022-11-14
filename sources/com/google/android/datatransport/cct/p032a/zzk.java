package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.List;

/* renamed from: com.google.android.datatransport.cct.a.zzk */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzk extends zzv {
    public final long zza;
    public final long zzb;
    public final zzq zzc;
    public final int zzd;
    public final String zze;
    public final List<zzt> zzf;
    public final zzaa zzg;

    public /* synthetic */ zzk(long j, long j2, zzq zzq, int i, String str, List list, zzaa zzaa) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = zzq;
        this.zzd = i;
        this.zze = str;
        this.zzf = list;
        this.zzg = zzaa;
    }

    public boolean equals(Object obj) {
        zzq zzq;
        String str;
        List<zzt> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzv)) {
            return false;
        }
        zzk zzk = (zzk) ((zzv) obj);
        if (this.zza == zzk.zza && this.zzb == zzk.zzb && ((zzq = this.zzc) != null ? zzq.equals(zzk.zzc) : zzk.zzc == null) && this.zzd == zzk.zzd && ((str = this.zze) != null ? str.equals(zzk.zze) : zzk.zze == null) && ((list = this.zzf) != null ? list.equals(zzk.zzf) : zzk.zzf == null)) {
            zzaa zzaa = this.zzg;
            if (zzaa == null) {
                if (zzk.zzg == null) {
                    return true;
                }
            } else if (zzaa.equals(zzk.zzg)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.zza;
        long j2 = this.zzb;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        zzq zzq = this.zzc;
        int i2 = 0;
        int hashCode = (((i ^ (zzq == null ? 0 : zzq.hashCode())) * 1000003) ^ this.zzd) * 1000003;
        String str = this.zze;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<zzt> list = this.zzf;
        int hashCode3 = (hashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        zzaa zzaa = this.zzg;
        if (zzaa != null) {
            i2 = zzaa.hashCode();
        }
        return hashCode3 ^ i2;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("LogRequest{requestTimeMs=");
        outline24.append(this.zza);
        outline24.append(", requestUptimeMs=");
        outline24.append(this.zzb);
        outline24.append(", clientInfo=");
        outline24.append(this.zzc);
        outline24.append(", logSource=");
        outline24.append(this.zzd);
        outline24.append(", logSourceName=");
        outline24.append(this.zze);
        outline24.append(", logEvents=");
        outline24.append(this.zzf);
        outline24.append(", qosTier=");
        outline24.append(this.zzg);
        outline24.append("}");
        return outline24.toString();
    }
}
