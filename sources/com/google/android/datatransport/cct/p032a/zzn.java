package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.cct.p032a.zzy;

/* renamed from: com.google.android.datatransport.cct.a.zzn */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzn extends zzy {
    public final zzy.zzc zza;
    public final zzy.zzb zzb;

    public /* synthetic */ zzn(zzy.zzc zzc, zzy.zzb zzb2) {
        this.zza = zzc;
        this.zzb = zzb2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy.zzc zzc = this.zza;
        if (zzc != null ? zzc.equals(((zzn) obj).zza) : ((zzn) obj).zza == null) {
            zzy.zzb zzb2 = this.zzb;
            if (zzb2 == null) {
                if (((zzn) obj).zzb == null) {
                    return true;
                }
            } else if (zzb2.equals(((zzn) obj).zzb)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzy.zzc zzc = this.zza;
        int i = 0;
        int hashCode = ((zzc == null ? 0 : zzc.hashCode()) ^ 1000003) * 1000003;
        zzy.zzb zzb2 = this.zzb;
        if (zzb2 != null) {
            i = zzb2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("NetworkConnectionInfo{networkType=");
        outline24.append(this.zza);
        outline24.append(", mobileSubtype=");
        outline24.append(this.zzb);
        outline24.append("}");
        return outline24.toString();
    }
}
