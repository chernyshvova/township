package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzaya {
    public zzbfr zza;
    public final Context zzb;
    public final String zzc;
    public final zzbhn zzd;
    @AppOpenAd.AppOpenAdOrientation
    public final int zze;
    public final AppOpenAd.AppOpenAdLoadCallback zzf;
    public final zzbve zzg = new zzbve();
    public final zzbdo zzh;

    public zzaya(Context context, String str, zzbhn zzbhn, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzbhn;
        this.zze = i;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzbdo.zza;
    }

    public final void zza() {
        try {
            this.zza = zzbev.zzb().zza(this.zzb, zzbdp.zzd(), this.zzc, this.zzg);
            zzbdv zzbdv = new zzbdv(this.zze);
            zzbfr zzbfr = this.zza;
            if (zzbfr != null) {
                zzbfr.zzH(zzbdv);
                this.zza.zzI(new zzaxn(this.zzf, this.zzc));
                this.zza.zze(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
