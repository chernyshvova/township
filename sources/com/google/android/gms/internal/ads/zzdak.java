package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdak implements zzgjg<zzdaj> {
    public final zzgju<zzfcx> zza;
    public final zzgju<zzcgy> zzb;
    public final zzgju<ApplicationInfo> zzc;
    public final zzgju<String> zzd;
    public final zzgju<List<String>> zze;
    public final zzgju<PackageInfo> zzf;
    public final zzgju<zzfqn<String>> zzg;
    public final zzgju<zzg> zzh;
    public final zzgju<String> zzi;
    public final zzgju<zzeqs<Bundle>> zzj;

    public zzdak(zzgju<zzfcx> zzgju, zzgju<zzcgy> zzgju2, zzgju<ApplicationInfo> zzgju3, zzgju<String> zzgju4, zzgju<List<String>> zzgju5, zzgju<PackageInfo> zzgju6, zzgju<zzfqn<String>> zzgju7, zzgju<zzg> zzgju8, zzgju<String> zzgju9, zzgju<zzeqs<Bundle>> zzgju10) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
        this.zzg = zzgju7;
        this.zzh = zzgju8;
        this.zzi = zzgju9;
        this.zzj = zzgju10;
    }

    /* renamed from: zza */
    public final zzdaj zzb() {
        return new zzdaj(this.zza.zzb(), ((zzcpd) this.zzb).zza(), ((zzdyk) this.zzc).zzb(), ((zzdyq) this.zzd).zzb(), zzbjn.zzc(), this.zzf.zzb(), zzgjf.zzc(this.zzg), ((zzezz) this.zzh).zzb(), this.zzi.zzb(), ((zzeqt) this.zzj).zzb());
    }
}
