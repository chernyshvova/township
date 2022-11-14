package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgw extends zzhg {
    public List<Long> zzi = null;

    public zzgw(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "h706sF1zmcc4AioWh+Jfvy0LKolmQxQ7/qBdFNEqjMTCjpxVey9eXR4ewnu7+Xxj", "PpTasJ7rye0SEy8bP+e639N2f2p/VqK1Ye1mnYIaTjk=", zzcn, i, 31);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzq(-1);
        this.zze.zzr(-1);
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        }
        List<Long> list = this.zzi;
        if (list != null && list.size() == 2) {
            synchronized (this.zze) {
                this.zze.zzq(this.zzi.get(0).longValue());
                this.zze.zzr(this.zzi.get(1).longValue());
            }
        }
    }
}
