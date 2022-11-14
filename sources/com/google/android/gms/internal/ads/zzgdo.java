package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdo {
    public static final zzgdo zza = new zzgdo(true);
    public static volatile boolean zzb = false;
    public static volatile zzgdo zzc;
    public static volatile zzgdo zzd;
    public final Map<zzgdn, zzgea<?, ?>> zze;

    public zzgdo() {
        this.zze = new HashMap();
    }

    public static zzgdo zza() {
        zzgdo zzgdo = zzc;
        if (zzgdo == null) {
            synchronized (zzgdo.class) {
                zzgdo = zzc;
                if (zzgdo == null) {
                    zzgdo = zza;
                    zzc = zzgdo;
                }
            }
        }
        return zzgdo;
    }

    public static zzgdo zzb() {
        Class<zzgdo> cls = zzgdo.class;
        zzgdo zzgdo = zzd;
        if (zzgdo != null) {
            return zzgdo;
        }
        synchronized (cls) {
            zzgdo zzgdo2 = zzd;
            if (zzgdo2 != null) {
                return zzgdo2;
            }
            zzgdo zzb2 = zzgdw.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final <ContainingType extends zzgfk> zzgea<ContainingType, ?> zzc(ContainingType containingtype, int i) {
        return this.zze.get(new zzgdn(containingtype, i));
    }

    public zzgdo(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
