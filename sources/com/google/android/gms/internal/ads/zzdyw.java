package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyw {
    public final ScheduledExecutorService zza;
    public final zzfqo zzb;
    public final zzdzn zzc;
    public final zzgja<zzebb> zzd;

    public zzdyw(ScheduledExecutorService scheduledExecutorService, zzfqo zzfqo, zzdzn zzdzn, zzgja<zzebb> zzgja) {
        this.zza = scheduledExecutorService;
        this.zzb = zzfqo;
        this.zzc = zzdzn;
        this.zzd = zzgja;
    }

    public final zzfqn<InputStream> zza(zzcbk zzcbk) {
        zzfqn zzfqn;
        String str = zzcbk.zzd;
        zzs.zzc();
        if (zzr.zzF(str)) {
            zzfqn = zzfqe.zzc(new zzeaa(1));
        } else {
            zzdzn zzdzn = this.zzc;
            synchronized (zzdzn.zzb) {
                if (zzdzn.zzc) {
                    zzfqn = zzdzn.zza;
                } else {
                    zzdzn.zzc = true;
                    zzdzn.zze = zzcbk;
                    zzdzn.zzf.checkAvailabilityAndConnect();
                    zzdzn.zza.zze(new zzdzm(zzdzn), zzche.zzf);
                    zzfqn = zzdzn.zza;
                }
            }
        }
        int callingUid = Binder.getCallingUid();
        zzfpv zzw = zzfpv.zzw(zzfqn);
        long intValue = (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdO)).intValue();
        return zzfqe.zzg((zzfpv) zzfqe.zzh(zzw, intValue, TimeUnit.SECONDS, this.zza), Throwable.class, new zzdyv(this, zzcbk, callingUid), this.zzb);
    }

    public final /* synthetic */ zzfqn zzb(zzcbk zzcbk, int i, Throwable th) throws Exception {
        return this.zzd.zzb().zzi(zzcbk, i);
    }
}
