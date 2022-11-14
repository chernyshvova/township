package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztt {
    public final zztw zza;
    public final zztw zzb;

    public zztt(zztw zztw, zztw zztw2) {
        this.zza = zztw;
        this.zzb = zztw2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zztt.class == obj.getClass()) {
            zztt zztt = (zztt) obj;
            return this.zza.equals(zztt.zza) && this.zzb.equals(zztt.zzb);
        }
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        String str;
        String valueOf = String.valueOf(this.zza);
        if (this.zza.equals(this.zzb)) {
            str = "";
        } else {
            String valueOf2 = String.valueOf(this.zzb);
            str = GeneratedOutlineSupport.outline18(new StringBuilder(valueOf2.length() + 2), RESTClient.COMMA_SEPARATOR, valueOf2);
        }
        return GeneratedOutlineSupport.outline20(new StringBuilder(valueOf.length() + 2 + String.valueOf(str).length()), "[", valueOf, str, "]");
    }
}
