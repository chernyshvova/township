package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcei extends zzcfc {
    public final Clock zzb;
    public final zzgju<Context> zzc;
    public final zzgju<zzg> zzd;
    public final zzgju<zzcfb> zze;
    public final zzgju<zzcea> zzf;
    public final zzgju<Clock> zzg;
    public final zzgju<zzcec> zzh;
    public final zzgju<zzcee> zzi;
    public final zzgju<zzcfh> zzj;

    public /* synthetic */ zzcei(Context context, Clock clock, zzg zzg2, zzcfb zzcfb, zzceg zzceg) {
        this.zzb = clock;
        this.zzc = zzgjh.zza(context);
        this.zzd = zzgjh.zza(zzg2);
        zzgjg zza = zzgjh.zza(zzcfb);
        this.zze = zza;
        this.zzf = zzgjf.zza(new zzceb(this.zzc, this.zzd, zza));
        zzgjg zza2 = zzgjh.zza(clock);
        this.zzg = zza2;
        zzgju<zzcec> zza3 = zzgjf.zza(new zzced(zza2, this.zzd, this.zze));
        this.zzh = zza3;
        zzcef zzcef = new zzcef(this.zzg, zza3);
        this.zzi = zzcef;
        this.zzj = zzgjf.zza(new zzcfi(this.zzc, zzcef));
    }

    public final zzcea zza() {
        return this.zzf.zzb();
    }

    public final zzcee zzb() {
        return new zzcee(this.zzb, this.zzh.zzb());
    }

    public final zzcfh zzc() {
        return this.zzj.zzb();
    }
}
