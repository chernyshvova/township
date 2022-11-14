package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzha extends zzhg {
    public final zzgf zzi;
    public long zzj;

    public zzha(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2, zzgf zzgf) {
        super(zzfy, "HGo1ox5JLQS5or5cJa/Y/rh1xBDCHENOhVObQPPiVgVWewsU7bgdJYYTcTgXDqTz", "4/LuQCxE41OF3+ELaCV0AA8Jaj2RFLkgJd6cCnnHOg0=", zzcn, i, 53);
        this.zzi = zzgf;
        if (zzgf != null) {
            this.zzj = zzgf.zzc();
        }
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzJ(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
