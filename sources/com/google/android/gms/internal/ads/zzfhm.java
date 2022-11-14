package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfhm extends zzgec<zzfhm, zzfhl> implements zzgfl {
    public static final zzgei<Integer, zzfhk> zzf = new zzfhh();
    public static final zzfhm zzj;
    public int zzb;
    public zzgeh zze = zzgec.zzaB();
    public String zzg = "";
    public String zzh = "";
    public String zzi = "";

    static {
        zzfhm zzfhm = new zzfhm();
        zzj = zzfhm;
        zzgec.zzay(zzfhm.class, zzfhm);
    }

    public static zzfhl zza() {
        return (zzfhl) zzj.zzas();
    }

    public static /* synthetic */ void zzd(zzfhm zzfhm, zzfhk zzfhk) {
        zzfhk.getClass();
        zzgeh zzgeh = zzfhm.zze;
        if (!zzgeh.zza()) {
            zzfhm.zze = zzgec.zzaC(zzgeh);
        }
        zzfhm.zze.zzh(zzfhk.zza());
    }

    public static /* synthetic */ void zze(zzfhm zzfhm, String str) {
        str.getClass();
        zzfhm.zzb |= 1;
        zzfhm.zzg = str;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzb", "zze", zzfhk.zzc(), "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzfhm();
        } else {
            if (i2 == 4) {
                return new zzfhl((zzfhh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
