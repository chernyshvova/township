package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzddm extends zzdgf<zzddo> implements zzdbx, zzddc {
    public final zzeye zzb;
    public final AtomicBoolean zzc = new AtomicBoolean();

    public zzddm(Set<zzdhz<zzddo>> set, zzeye zzeye) {
        super(set);
        this.zzb = zzeye;
    }

    private final void zzc() {
        zzbdr zzbdr;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfm)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzbdr = this.zzb.zzaa) != null && zzbdr.zza == 3) {
            zzr(new zzddl(this));
        }
    }

    public final void zzK() {
        if (this.zzb.zzb == 1) {
            zzc();
        }
    }

    public final /* synthetic */ void zza(zzddo zzddo) throws Exception {
        zzddo.zzk(this.zzb.zzaa);
    }

    public final void zzbF() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6) {
            zzc();
        }
    }
}
