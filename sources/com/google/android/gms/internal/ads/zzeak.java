package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeak {
    public final zzfqo zza;
    public final zzdzr zzb;
    public final zzgja<zzebb> zzc;

    public zzeak(zzfqo zzfqo, zzdzr zzdzr, zzgja<zzebb> zzgja) {
        this.zza = zzfqo;
        this.zzb = zzdzr;
        this.zzc = zzgja;
    }

    private final <RetT> zzfqn<RetT> zzg(zzcbk zzcbk, zzeaj<InputStream> zzeaj, zzeaj<InputStream> zzeaj2, zzfpl<InputStream, RetT> zzfpl) {
        zzfqn<V> zzfqn;
        String str = zzcbk.zzd;
        zzs.zzc();
        if (zzr.zzF(str)) {
            zzfqn = zzfqe.zzc(new zzeaa(1));
        } else {
            zzfqn = zzfqe.zzg(zzeaj.zzb(zzcbk), ExecutionException.class, zzeab.zza, this.zza);
        }
        return zzfqe.zzg(zzfqe.zzi(zzfpv.zzw(zzfqn), zzfpl, this.zza), zzeaa.class, new zzeac(this, zzeaj2, zzcbk, zzfpl), this.zza);
    }

    public final zzfqn<zzcbk> zza(zzcbk zzcbk) {
        return zzg(zzcbk, zzeae.zza(this.zzb), new zzeaf(this), new zzead(zzcbk));
    }

    public final zzfqn<Void> zzb(zzcbk zzcbk) {
        if (zzgb.zze(zzcbk.zzj)) {
            return zzfqe.zzc(new zzdxy(2, "Pool key missing from removeUrl call."));
        }
        return zzg(zzcbk, new zzeah(this), new zzeai(this), zzeag.zza);
    }

    public final /* synthetic */ zzfqn zzc(zzcbk zzcbk) {
        return this.zzc.zzb().zzd(zzcbk.zzj);
    }

    public final /* synthetic */ zzfqn zzd(zzcbk zzcbk) {
        return this.zzb.zzc(zzcbk.zzj);
    }

    public final /* synthetic */ zzfqn zze(zzcbk zzcbk) {
        return this.zzc.zzb().zzc(zzcbk, Binder.getCallingUid());
    }

    public final /* synthetic */ zzfqn zzf(zzeaj zzeaj, zzcbk zzcbk, zzfpl zzfpl, zzeaa zzeaa) throws Exception {
        return zzfqe.zzi(zzeaj.zzb(zzcbk), zzfpl, this.zza);
    }
}
