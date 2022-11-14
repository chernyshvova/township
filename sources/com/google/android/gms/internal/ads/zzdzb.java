package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzb implements zzdzz {
    public static final Pattern zzf = Pattern.compile("Received error HTTP response code: (.*)");
    public final zzdyc zza;
    public final zzfqo zzb;
    public final zzeyw zzc;
    public final ScheduledExecutorService zzd;
    public final zzecf zze;

    public zzdzb(zzeyw zzeyw, zzdyc zzdyc, zzfqo zzfqo, ScheduledExecutorService scheduledExecutorService, zzecf zzecf) {
        this.zzc = zzeyw;
        this.zza = zzdyc;
        this.zzb = zzfqo;
        this.zzd = scheduledExecutorService;
        this.zze = zzecf;
    }

    public final zzfqn<zzeyq> zza(zzcbk zzcbk) {
        zzfqn<zzeyq> zzi = zzfqe.zzi(this.zza.zza(zzcbk), new zzdyy(this), this.zzb);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdN)).booleanValue()) {
            zzi = zzfqe.zzg(zzfqe.zzh(zzi, (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdO)).intValue(), TimeUnit.SECONDS, this.zzd), TimeoutException.class, zzdyz.zza, zzche.zzf);
        }
        zzfqe.zzp(zzi, new zzdza(this), zzche.zzf);
        return zzi;
    }

    public final /* synthetic */ zzfqn zzb(InputStream inputStream) throws Exception {
        return zzfqe.zza(new zzeyq(new zzeyn(this.zzc), zzeyp.zza(new InputStreamReader(inputStream))));
    }
}
