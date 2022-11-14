package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxz implements zzzn {
    public final List<zzkc> zza;

    public zzxz() {
        this(0);
    }

    private final zzzd zzb(zzzm zzzm) {
        return new zzzd(zzd(zzzm));
    }

    private final zzzr zzc(zzzm zzzm) {
        return new zzzr(zzd(zzzm));
    }

    private final List<zzkc> zzd(zzzm zzzm) {
        ArrayList arrayList;
        String str;
        int i;
        List list;
        zzakr zzakr = new zzakr(zzzm.zzd);
        List<zzkc> list2 = this.zza;
        while (zzakr.zzd() > 0) {
            int zzn = zzakr.zzn();
            int zzg = zzakr.zzg() + zzakr.zzn();
            if (zzn == 134) {
                ArrayList arrayList2 = new ArrayList();
                int zzn2 = zzakr.zzn() & 31;
                for (int i2 = 0; i2 < zzn2; i2++) {
                    String zzE = zzakr.zzE(3, zzfjs.zzc);
                    int zzn3 = zzakr.zzn();
                    int i3 = zzn3 & 128;
                    if (i3 != 0) {
                        i = zzn3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte zzn4 = (byte) zzakr.zzn();
                    zzakr.zzk(1);
                    if (i3 != 0) {
                        list = Collections.singletonList((zzn4 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzkb zzkb = new zzkb();
                    zzkb.zzj(str);
                    zzkb.zzd(zzE);
                    zzkb.zzB(i);
                    zzkb.zzl(list);
                    arrayList2.add(zzkb.zzD());
                }
                arrayList = arrayList2;
            } else {
                arrayList = list2;
            }
            zzakr.zzh(zzg);
            list2 = arrayList;
        }
        return list2;
    }

    @Nullable
    public final zzzp zza(int i, zzzm zzzm) {
        if (i == 2) {
            return new zzyt(new zzye(zzc(zzzm)));
        }
        if (i == 3 || i == 4) {
            return new zzyt(new zzyq(zzzm.zzb));
        }
        if (i == 21) {
            return new zzyt(new zzyo());
        }
        if (i == 27) {
            return new zzyt(new zzyl(zzb(zzzm), false, false));
        }
        if (i == 36) {
            return new zzyt(new zzyn(zzb(zzzm)));
        }
        if (i == 89) {
            return new zzyt(new zzyb(zzzm.zzc));
        }
        if (i != 129) {
            if (i == 138) {
                return new zzyt(new zzya(zzzm.zzb));
            }
            if (i == 172) {
                return new zzyt(new zzxv(zzzm.zzb));
            }
            if (i == 257) {
                return new zzzc(new zzys("application/vnd.dvb.ait"));
            }
            if (i == 134) {
                return new zzzc(new zzys("application/x-scte35"));
            }
            if (i != 135) {
                switch (i) {
                    case 15:
                        return new zzyt(new zzxy(false, zzzm.zzb));
                    case 16:
                        return new zzyt(new zzyh(zzc(zzzm)));
                    case 17:
                        return new zzyt(new zzyp(zzzm.zzb));
                    default:
                        return null;
                }
            }
        }
        return new zzyt(new zzxs(zzzm.zzb));
    }

    public zzxz(int i) {
        this.zza = zzfml.zzi();
    }
}
