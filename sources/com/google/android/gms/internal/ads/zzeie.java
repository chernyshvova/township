package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeie implements zzedv<zzdrj, zzezn, zzefk> {
    public final Context zza;
    public final Executor zzb;
    public final zzdro zzc;

    public zzeie(Context context, Executor executor, zzdro zzdro) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdro;
    }

    public static final void zze(zzeyq zzeyq, zzeye zzeye, zzedq<zzezn, zzefk> zzedq) {
        try {
            ((zzezn) zzedq.zzb).zzl(zzeyq.zza.zza.zzd, zzeye.zzv.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzedq.zza);
            zzcgs.zzj(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzezn, zzefk> zzedq) throws zzezb {
        if (!((zzezn) zzedq.zzb).zzn()) {
            ((zzefk) zzedq.zzc).zzd(new zzeic(this, zzeyq, zzeye, zzedq));
            ((zzezn) zzedq.zzb).zzk(this.zza, zzeyq.zza.zza.zzd, (String) null, (zzccl) zzedq.zzc, zzeye.zzv.toString());
            return;
        }
        zze(zzeyq, zzeye, zzedq);
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        zzdrk zze = this.zzc.zze(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdrl(new zzeia(zzedq)));
        zze.zza().zzh(new zzcta((zzezn) zzedq.zzb), this.zzb);
        zzdck zzb2 = zze.zzb();
        zzdbb zzc2 = zze.zzc();
        ((zzefk) zzedq.zzc).zzc(new zzeid(this, zze.zzi(), zzc2, zzb2, zze.zzk()));
        return zze.zzh();
    }
}
