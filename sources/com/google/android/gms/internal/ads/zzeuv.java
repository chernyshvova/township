package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeuv implements zzfpl {
    public final zzeux zza;
    public final zzfaq zzb;
    public final zzcyl zzc;

    public zzeuv(zzeux zzeux, zzfaq zzfaq, zzcyl zzcyl) {
        this.zza = zzeux;
        this.zzb = zzfaq;
        this.zzc = zzcyl;
    }

    public final zzfqn zza(Object obj) {
        zzfaq zzfaq = this.zzb;
        zzcyl zzcyl = this.zzc;
        zzeyq zzeyq = (zzeyq) obj;
        zzfaq.zzb = zzeyq;
        Iterator<zzeye> it = zzeyq.zzb.zza.iterator();
        boolean z = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator<String> it2 = it.next().zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z = true;
                    }
                }
            } else if (z) {
                return zzcyl.zzc(zzfqe.zza(zzeyq));
            }
        }
        return zzfqe.zza(null);
    }
}
