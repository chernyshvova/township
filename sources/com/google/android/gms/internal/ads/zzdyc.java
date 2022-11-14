package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyc {
    public final zzfqo zza;
    public final zzfqo zzb;
    public final zzdzj zzc;
    public final zzgja<zzebb> zzd;

    public zzdyc(zzfqo zzfqo, zzfqo zzfqo2, zzdzj zzdzj, zzgja<zzebb> zzgja) {
        this.zza = zzfqo;
        this.zzb = zzfqo2;
        this.zzc = zzdzj;
        this.zzd = zzgja;
    }

    public final zzfqn<InputStream> zza(zzcbk zzcbk) {
        zzfqn<V> zzfqn;
        String str = zzcbk.zzd;
        zzs.zzc();
        if (zzr.zzF(str)) {
            zzfqn = zzfqe.zzc(new zzeaa(1));
        } else {
            zzfqn = zzfqe.zzg(this.zza.zzb(new zzdxz(this, zzcbk)), ExecutionException.class, zzdya.zza, this.zzb);
        }
        return zzfqe.zzg(zzfqn, zzeaa.class, new zzdyb(this, zzcbk, Binder.getCallingUid()), this.zzb);
    }

    public final /* synthetic */ zzfqn zzb(zzcbk zzcbk, int i, zzeaa zzeaa) throws Exception {
        return this.zzd.zzb().zzb(zzcbk, i);
    }

    public final /* synthetic */ InputStream zzc(zzcbk zzcbk) throws Exception {
        zzchj<InputStream> zzchj;
        zzdzj zzdzj = this.zzc;
        synchronized (zzdzj.zzb) {
            if (zzdzj.zzc) {
                zzchj = zzdzj.zza;
            } else {
                zzdzj.zzc = true;
                zzdzj.zze = zzcbk;
                zzdzj.zzf.checkAvailabilityAndConnect();
                zzdzj.zza.zze(new zzdzi(zzdzj), zzche.zzf);
                zzchj = zzdzj.zza;
            }
        }
        return (InputStream) zzchj.get((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdO)).intValue(), TimeUnit.SECONDS);
    }
}
