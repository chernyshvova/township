package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzf extends zzgec<zzfzf, zzfzc> implements zzgfl {
    public static final zzfzf zzf;
    public int zzb;
    public zzgel<zzfze> zze = zzgec.zzaE();

    static {
        zzfzf zzfzf = new zzfzf();
        zzf = zzfzf;
        zzgec.zzay(zzfzf.class, zzfzf);
    }

    public static zzfzf zze(byte[] bArr, zzgdo zzgdo) throws zzgeo {
        return (zzfzf) zzgec.zzaK(zzf, bArr, zzgdo);
    }

    public final int zza() {
        return this.zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzfze.class});
        } else if (i2 == 3) {
            return new zzfzf();
        } else {
            if (i2 == 4) {
                return new zzfzc((zzfzb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final List<zzfze> zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }
}
