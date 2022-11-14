package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehi implements zzedv<zzdrj, zzezn, zzefj> {
    public final Context zza;
    public final Executor zzb;
    public final zzdro zzc;

    public zzehi(Context context, Executor executor, zzdro zzdro) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdro;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzezn, zzefj> zzedq) throws zzezb {
        try {
            zzeyw zzeyw = zzeyq.zza.zza;
            if (zzeyw.zzo.zza == 3) {
                ((zzezn) zzedq.zzb).zzx(this.zza, zzeyw.zzd, zzeye.zzv.toString(), (zzbvn) zzedq.zzc);
            } else {
                ((zzezn) zzedq.zzb).zzv(this.zza, zzeyw.zzd, zzeye.zzv.toString(), (zzbvn) zzedq.zzc);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzedq.zza);
            zzcgs.zzj(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        zzdrk zze = this.zzc.zze(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdrl(new zzehh(zzedq)));
        zze.zza().zzh(new zzcta((zzezn) zzedq.zzb), this.zzb);
        ((zzefj) zzedq.zzc).zzc(zze.zzm());
        return zze.zzh();
    }
}
