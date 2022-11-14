package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgij extends zzgec<zzgij, zzgii> implements zzgfl {
    public static final zzgij zzo;
    public int zzb;
    public int zze;
    public String zzf = "";
    public zzghs zzg;
    public zzghw zzh;
    public int zzi;
    public zzgeh zzj = zzgec.zzaB();
    public String zzk = "";
    public int zzl;
    public zzgel<String> zzm = zzgec.zzaE();
    public byte zzn = 2;

    static {
        zzgij zzgij = new zzgij();
        zzo = zzgij;
        zzgec.zzay(zzgij.class, zzgij);
    }

    public static zzgii zzd() {
        return (zzgii) zzo.zzas();
    }

    public static /* synthetic */ void zzf(zzgij zzgij, int i) {
        zzgij.zzb |= 1;
        zzgij.zze = i;
    }

    public static /* synthetic */ void zzg(zzgij zzgij, String str) {
        str.getClass();
        zzgij.zzb |= 2;
        zzgij.zzf = str;
    }

    public static /* synthetic */ void zzh(zzgij zzgij, zzghs zzghs) {
        zzghs.getClass();
        zzgij.zzg = zzghs;
        zzgij.zzb |= 4;
    }

    public static /* synthetic */ void zzi(zzgij zzgij, zzgih zzgih) {
        zzgij.zzl = zzgih.zza();
        zzgij.zzb |= 64;
    }

    public static /* synthetic */ void zzj(zzgij zzgij, String str) {
        str.getClass();
        zzgel<String> zzgel = zzgij.zzm;
        if (!zzgel.zza()) {
            zzgij.zzm = zzgec.zzaF(zzgel);
        }
        zzgij.zzm.add(str);
    }

    public final String zza() {
        return this.zzf;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzgec.zzaz(zzo, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzgih.zzc(), "zzm"});
        } else if (i2 == 3) {
            return new zzgij();
        } else {
            if (i2 == 4) {
                return new zzgii((zzghg) null);
            }
            if (i2 == 5) {
                return zzo;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzn = b;
            return null;
        }
    }

    public final int zzc() {
        return this.zzm.size();
    }
}
