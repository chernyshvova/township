package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzghs extends zzgec<zzghs, zzghp> implements zzgfl {
    public static final zzghs zzk;
    public int zzb;
    public zzghr zze;
    public zzgel<zzgho> zzf = zzgec.zzaE();
    public zzgcz zzg;
    public zzgcz zzh;
    public int zzi;
    public byte zzj = 2;

    static {
        zzghs zzghs = new zzghs();
        zzk = zzghs;
        zzgec.zzay(zzghs.class, zzghs);
    }

    public zzghs() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zzg = zzgcz;
        this.zzh = zzgcz;
    }

    public static zzghp zza() {
        return (zzghp) zzk.zzas();
    }

    public static /* synthetic */ void zzd(zzghs zzghs, zzgho zzgho) {
        zzgho.getClass();
        zzgel<zzgho> zzgel = zzghs.zzf;
        if (!zzgel.zza()) {
            zzghs.zzf = zzgec.zzaF(zzgel);
        }
        zzghs.zzf.add(zzgho);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzgec.zzaz(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzb", "zze", "zzf", zzgho.class, "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzghs();
        } else {
            if (i2 == 4) {
                return new zzghp((zzghg) null);
            }
            if (i2 == 5) {
                return zzk;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzj = b;
            return null;
        }
    }
}
