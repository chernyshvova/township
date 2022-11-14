package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfza extends zzgec<zzfza, zzfyz> implements zzgfl {
    public static final zzfza zzi;
    public String zzb = "";
    public String zze = "";
    public int zzf;
    public boolean zzg;
    public String zzh = "";

    static {
        zzfza zzfza = new zzfza();
        zzi = zzfza;
        zzgec.zzay(zzfza.class, zzfza);
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
            return zzgec.zzaz(zzi, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzfza();
        } else {
            if (i2 == 4) {
                return new zzfyz((zzfyy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }

    public final String zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final String zzf() {
        return this.zzh;
    }
}
