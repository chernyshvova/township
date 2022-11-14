package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgcr implements Comparator<zzgcz> {
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzgcz zzgcz = (zzgcz) obj;
        zzgcz zzgcz2 = (zzgcz) obj2;
        zzgcu zzq = zzgcz.iterator();
        zzgcu zzq2 = zzgcz2.iterator();
        while (zzq.hasNext() && zzq2.hasNext()) {
            int compare = Integer.compare(zzq.zza() & Base64.EQUALS_SIGN_ENC, zzq2.zza() & Base64.EQUALS_SIGN_ENC);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgcz.zzc(), zzgcz2.zzc());
    }
}
