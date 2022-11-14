package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.cct.p032a.zzq;

/* renamed from: com.google.android.datatransport.cct.a.zzg */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzg extends zzq {
    public final zzq.zzb zza;
    public final zza zzb;

    public /* synthetic */ zzg(zzq.zzb zzb2, zza zza2) {
        this.zza = zzb2;
        this.zzb = zza2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq.zzb zzb2 = this.zza;
        if (zzb2 != null ? zzb2.equals(((zzg) obj).zza) : ((zzg) obj).zza == null) {
            zza zza2 = this.zzb;
            if (zza2 == null) {
                if (((zzg) obj).zzb == null) {
                    return true;
                }
            } else if (zza2.equals(((zzg) obj).zzb)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzq.zzb zzb2 = this.zza;
        int i = 0;
        int hashCode = ((zzb2 == null ? 0 : zzb2.hashCode()) ^ 1000003) * 1000003;
        zza zza2 = this.zzb;
        if (zza2 != null) {
            i = zza2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("ClientInfo{clientType=");
        outline24.append(this.zza);
        outline24.append(", androidClientInfo=");
        outline24.append(this.zzb);
        outline24.append("}");
        return outline24.toString();
    }
}
