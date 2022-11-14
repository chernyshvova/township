package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxl extends zzgec<zzfxl, zzfxk> implements zzgfl {
    public static final zzfxl zze;
    public zzfyx zzb;

    static {
        zzfxl zzfxl = new zzfxl();
        zze = zzfxl;
        zzgec.zzay(zzfxl.class, zzfxl);
    }

    public static zzfxk zzc() {
        return (zzfxk) zze.zzas();
    }

    public static zzfxl zzd() {
        return zze;
    }

    public static /* synthetic */ void zzf(zzfxl zzfxl, zzfyx zzfyx) {
        zzfyx.getClass();
        zzfxl.zzb = zzfyx;
    }

    public final zzfyx zza() {
        zzfyx zzfyx = this.zzb;
        return zzfyx == null ? zzfyx.zzf() : zzfyx;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zze, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzfxl();
        } else {
            if (i2 == 4) {
                return new zzfxk((zzfxj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
