package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbv;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegj implements zzedv<zzdlv, zzezn, zzefj> {
    public final Context zza;
    public final zzdkp zzb;
    public final Executor zzc;

    public zzegj(Context context, zzdkp zzdkp, Executor executor) {
        this.zza = context;
        this.zzb = zzdkp;
        this.zzc = executor;
    }

    public static final boolean zzc(zzeyq zzeyq, int i) {
        return zzeyq.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzezn, zzefj> zzedq) throws zzezb {
        zzeyw zzeyw = zzeyq.zza.zza;
        ((zzezn) zzedq.zzb).zzo(this.zza, zzeyq.zza.zza.zzd, zzeye.zzv.toString(), zzbv.zzl(zzeye.zzs), (zzbvn) zzedq.zzc, zzeyw.zzi, zzeyw.zzg);
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        zzdma zzdma;
        zzbvs zzB = ((zzezn) zzedq.zzb).zzB();
        zzbvt zzC = ((zzezn) zzedq.zzb).zzC();
        zzbvw zzu = ((zzezn) zzedq.zzb).zzu();
        if (zzu != null && zzc(zzeyq, 6)) {
            zzdma = zzdma.zzaa(zzu);
        } else if (zzB != null && zzc(zzeyq, 6)) {
            zzdma = zzdma.zzad(zzB);
        } else if (zzB != null && zzc(zzeyq, 2)) {
            zzdma = zzdma.zzac(zzB);
        } else if (zzC != null && zzc(zzeyq, 6)) {
            zzdma = zzdma.zzae(zzC);
        } else if (zzC == null || !zzc(zzeyq, 1)) {
            throw new zzehd(1, "No native ad mappers");
        } else {
            zzdma = zzdma.zzab(zzC);
        }
        if (zzeyq.zza.zza.zzg.contains(Integer.toString(zzdma.zzv()))) {
            zzdmc zzd = this.zzb.zzd(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdmm(zzdma), new zzdnz(zzC, zzB, zzu, (byte[]) null));
            ((zzefj) zzedq.zzc).zzc(zzd.zzf());
            zzd.zza().zzh(new zzcta((zzezn) zzedq.zzb), this.zzc);
            return zzd.zzh();
        }
        throw new zzehd(1, "No corresponding native ad listener");
    }
}
