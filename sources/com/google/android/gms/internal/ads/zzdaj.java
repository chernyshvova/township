package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdaj {
    public final zzfcx zza;
    public final zzcgy zzb;
    public final ApplicationInfo zzc;
    public final String zzd;
    public final List<String> zze;
    public final PackageInfo zzf;
    public final zzgja<zzfqn<String>> zzg;
    public final String zzh;
    public final zzeqs<Bundle> zzi;

    public zzdaj(zzfcx zzfcx, zzcgy zzcgy, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, zzgja<zzfqn<String>> zzgja, zzg zzg2, String str2, zzeqs<Bundle> zzeqs) {
        this.zza = zzfcx;
        this.zzb = zzcgy;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzgja;
        this.zzh = str2;
        this.zzi = zzeqs;
    }

    public final zzfqn<Bundle> zza() {
        zzfcx zzfcx = this.zza;
        return zzfci.zza(this.zzi.zza(new Bundle()), zzfcr.SIGNALS, zzfcx).zzi();
    }

    public final zzfqn<zzcbk> zzb() {
        zzfqn<Bundle> zza2 = zza();
        return this.zza.zzb(zzfcr.REQUEST_PARCEL, zza2, this.zzg.zzb()).zza(new zzdai(this, zza2)).zzi();
    }

    public final /* synthetic */ zzcbk zzc(zzfqn zzfqn) throws Exception {
        return new zzcbk((Bundle) zzfqn.get(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (String) this.zzg.zzb().get(), this.zzh, (zzfao) null, (String) null);
    }
}
