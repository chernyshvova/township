package com.google.android.gms.internal.ads;

import com.swrve.sdk.rest.RESTClient;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfjy {
    public final String zza;
    public final zzfjx zzb;
    public zzfjx zzc;

    public /* synthetic */ zzfjy(String str, zzfjw zzfjw) {
        zzfjx zzfjx = new zzfjx((zzfjw) null);
        this.zzb = zzfjx;
        this.zzc = zzfjx;
        if (str != null) {
            this.zza = str;
            return;
        }
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfjx zzfjx = this.zzb.zzb;
        String str = "";
        while (zzfjx != null) {
            Object obj = zzfjx.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzfjx = zzfjx.zzb;
            str = RESTClient.COMMA_SEPARATOR;
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfjy zza(@CheckForNull Object obj) {
        zzfjx zzfjx = new zzfjx((zzfjw) null);
        this.zzc.zzb = zzfjx;
        this.zzc = zzfjx;
        zzfjx.zza = obj;
        return this;
    }
}
