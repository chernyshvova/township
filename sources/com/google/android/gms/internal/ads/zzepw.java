package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzepw implements zzeqp<zzepx> {
    public final String zza;
    public final zzfqo zzb;
    public final ScheduledExecutorService zzc;
    public final zzejp zzd;
    public final Context zze;
    public final zzeyw zzf;
    public final zzejk zzg;

    public zzepw(zzfqo zzfqo, ScheduledExecutorService scheduledExecutorService, String str, zzejp zzejp, Context context, zzeyw zzeyw, zzejk zzejk) {
        this.zzb = zzfqo;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzejp;
        this.zze = context;
        this.zzf = zzeyw;
        this.zzg = zzejk;
    }

    public final zzfqn<zzepx> zza() {
        return zzfqe.zze(new zzeps(this), this.zzb);
    }

    public final /* synthetic */ zzfqn zzb(String str, List list, Bundle bundle) throws Exception {
        zzchj zzchj = new zzchj();
        this.zzg.zza(str);
        zzbxo zzb2 = this.zzg.zzb(str);
        if (zzb2 != null) {
            Bundle bundle2 = bundle;
            zzb2.zze(ObjectWrapper.wrap(this.zze), this.zza, bundle2, (Bundle) list.get(0), this.zzf.zze, new zzejs(str, zzb2, zzchj));
            return zzchj;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzfqn zzc() {
        Map<String, List<Bundle>> zzb2 = this.zzd.zzb(this.zza, this.zzf.zzf);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : zzb2.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            Bundle bundle = this.zzf.zzd.zzm;
            arrayList.add(zzfqe.zzf((zzfpv) zzfqe.zzh(zzfpv.zzw(zzfqe.zze(new zzept(this, str, list, bundle != null ? bundle.getBundle(str) : null), this.zzb)), ((Long) zzbex.zzc().zzb(zzbjn.zzaX)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Throwable.class, new zzepu(str), this.zzb));
        }
        return zzfqe.zzo(arrayList).zza(new zzepv(arrayList), this.zzb);
    }
}
