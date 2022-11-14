package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzcou;
import com.google.android.gms.internal.ads.zzdqu;
import com.google.android.gms.internal.ads.zzduu;
import com.google.android.gms.internal.ads.zzezo;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzfdh;
import com.google.android.gms.internal.ads.zzfqo;
import com.google.android.gms.internal.ads.zzgjg;
import com.google.android.gms.internal.ads.zzgjp;
import com.google.android.gms.internal.ads.zzgju;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzu implements zzgjg<zzt> {
    public final zzgju<zzcop> zza;
    public final zzgju<Context> zzb;
    public final zzgju<zzfb> zzc;
    public final zzgju<zzezo<zzdqu>> zzd;
    public final zzgju<zzfqo> zze;
    public final zzgju<ScheduledExecutorService> zzf;
    public final zzgju<zzduu> zzg;
    public final zzgju<zzfdh> zzh;

    public zzu(zzgju<zzcop> zzgju, zzgju<Context> zzgju2, zzgju<zzfb> zzgju3, zzgju<zzezo<zzdqu>> zzgju4, zzgju<zzfqo> zzgju5, zzgju<ScheduledExecutorService> zzgju6, zzgju<zzduu> zzgju7, zzgju<zzfdh> zzgju8) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
        this.zzg = zzgju7;
        this.zzh = zzgju8;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzt(this.zza.zzb(), ((zzcou) this.zzb).zza(), this.zzc.zzb(), this.zzd.zzb(), zzfqo, this.zzf.zzb(), this.zzg.zzb(), this.zzh.zzb());
    }
}
