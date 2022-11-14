package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckq implements Iterable<zzckp> {
    public final List<zzckp> zza = new ArrayList();

    public static final zzckp zzc(zzciz zzciz) {
        Iterator<zzckp> it = zzs.zzy().iterator();
        while (it.hasNext()) {
            zzckp next = it.next();
            if (next.zza == zzciz) {
                return next;
            }
        }
        return null;
    }

    public static final boolean zzd(zzciz zzciz) {
        zzckp zzc = zzc(zzciz);
        if (zzc == null) {
            return false;
        }
        zzc.zzb.zzg();
        return true;
    }

    public final Iterator<zzckp> iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzckp zzckp) {
        this.zza.add(zzckp);
    }

    public final void zzb(zzckp zzckp) {
        this.zza.remove(zzckp);
    }
}
