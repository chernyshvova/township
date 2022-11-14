package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.List;

/* renamed from: com.google.android.datatransport.cct.a.zze */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zze extends zzo {
    public final List<zzv> zza;

    public zze(List<zzv> list) {
        if (list != null) {
            this.zza = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzo) {
            return this.zza.equals(((zze) ((zzo) obj)).zza);
        }
        return false;
    }

    public int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("BatchedLogRequest{logRequests=");
        outline24.append(this.zza);
        outline24.append("}");
        return outline24.toString();
    }
}
