package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.google.android.datatransport.cct.a.zzl */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzl extends zzx {
    public final long zza;

    public zzl(long j) {
        this.zza = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzx) || this.zza != ((zzl) ((zzx) obj)).zza) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.zza;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("LogResponse{nextRequestWaitMillis=");
        outline24.append(this.zza);
        outline24.append("}");
        return outline24.toString();
    }
}
