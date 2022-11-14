package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzdaj;
import com.google.android.gms.internal.ads.zzdak;
import com.google.android.gms.internal.ads.zzfcr;
import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfqn;
import com.google.android.gms.internal.ads.zzgjg;
import com.google.android.gms.internal.ads.zzgju;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzab implements zzgjg<zzfqn<zzaf>> {
    public final zzgju<zzfcx> zza;
    public final zzgju<zzad> zzb;
    public final zzgju<zzdaj> zzc;

    public zzab(zzgju<zzfcx> zzgju, zzgju<zzad> zzgju2, zzgju<zzdaj> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzb().zza(zzfcr.GENERATE_SIGNALS, ((zzdak) this.zzc).zzb().zzb()).zzc(((zzae) this.zzb).zzb()).zzh((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzdO)).intValue(), TimeUnit.SECONDS).zzi();
    }
}
