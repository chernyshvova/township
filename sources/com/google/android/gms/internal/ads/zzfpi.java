package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpi extends zzfpg {
    public zzfpi() {
        super((zzfpf) null);
    }

    public /* synthetic */ zzfpi(zzfpf zzfpf) {
        super((zzfpf) null);
    }

    public final void zza(zzfpj<?> zzfpj, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
        synchronized (zzfpj) {
            if (zzfpj.seenExceptions == null) {
                Set unused = zzfpj.seenExceptions = set2;
            }
        }
    }

    public final int zzb(zzfpj<?> zzfpj) {
        int zzH;
        synchronized (zzfpj) {
            zzH = zzfpj.zzH(zzfpj);
        }
        return zzH;
    }
}
