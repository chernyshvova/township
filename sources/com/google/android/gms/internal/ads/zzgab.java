package com.google.android.gms.internal.ads;

import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgab extends zzgec<zzgab, zzgaa> implements zzgfl {
    public static final zzgab zzf;
    public String zzb = "";
    public zzgel<zzfza> zze = zzgec.zzaE();

    static {
        zzgab zzgab = new zzgab();
        zzf = zzgab;
        zzgec.zzay(zzgab.class, zzgab);
    }

    public static zzgab zzc() {
        return zzf;
    }

    public final List<zzfza> zza() {
        return this.zze;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zze", zzfza.class});
        } else if (i2 == 3) {
            return new zzgab();
        } else {
            if (i2 == 4) {
                return new zzgaa((zzfzz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
