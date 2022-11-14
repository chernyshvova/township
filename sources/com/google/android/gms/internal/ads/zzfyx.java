package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfyx extends zzgec<zzfyx, zzfyw> implements zzgfl {
    public static final zzfyx zzg;
    public String zzb = "";
    public zzgcz zze = zzgcz.zzb;
    public int zzf;

    static {
        zzfyx zzfyx = new zzfyx();
        zzg = zzfyx;
        zzgec.zzay(zzfyx.class, zzfyx);
    }

    public static zzfyw zze() {
        return (zzfyw) zzg.zzas();
    }

    public static zzfyx zzf() {
        return zzg;
    }

    public static /* synthetic */ void zzh(zzfyx zzfyx, String str) {
        str.getClass();
        zzfyx.zzb = str;
    }

    public final String zza() {
        return this.zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfyx();
        } else {
            if (i2 == 4) {
                return new zzfyw((zzfyv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzgcz zzc() {
        return this.zze;
    }

    public final zzfzy zzd() {
        zzfzy zzb2 = zzfzy.zzb(this.zzf);
        return zzb2 == null ? zzfzy.UNRECOGNIZED : zzb2;
    }
}
