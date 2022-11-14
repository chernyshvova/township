package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegz implements zzfqa {
    public final /* synthetic */ long zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzeye zzc;
    public final /* synthetic */ zzeyh zzd;
    public final /* synthetic */ zzeha zze;

    public zzegz(zzeha zzeha, long j, String str, zzeye zzeye, zzeyh zzeyh) {
        this.zze = zzeha;
        this.zza = j;
        this.zzb = str;
        this.zzc = zzeye;
        this.zzd = zzeyh;
    }

    public final void zza(Throwable th) {
        int i;
        zzbdd zzbdd;
        long elapsedRealtime = this.zze.zza.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzegp) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzezb) {
            i = 5;
        } else {
            i = (!(th instanceof zzdxy) || zzezr.zza(th).zza != 3) ? 6 : 1;
        }
        zzeha.zzd(this.zze, this.zzb, i, elapsedRealtime, this.zzc.zzab);
        if (this.zze.zzd) {
            this.zze.zzb.zza(this.zzd, this.zzc, i, th instanceof zzedr ? (zzedr) th : null, elapsedRealtime);
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfJ)).booleanValue()) {
            zzbdd zza2 = zzezr.zza(th);
            int i2 = zza2.zza;
            if ((i2 == 3 || i2 == 0) && (zzbdd = zza2.zzd) != null && !zzbdd.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zza2 = zzezr.zza(new zzedr(13, zza2.zzd));
            }
            this.zze.zze.zzc(this.zzc, elapsedRealtime, zza2);
        }
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zze.zza.elapsedRealtime() - this.zza;
        zzeha.zzd(this.zze, this.zzb, 0, elapsedRealtime, this.zzc.zzab);
        if (this.zze.zzd) {
            this.zze.zzb.zza(this.zzd, this.zzc, 0, (zzedr) null, elapsedRealtime);
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfJ)).booleanValue()) {
            this.zze.zze.zzc(this.zzc, elapsedRealtime, (zzbdd) null);
        }
    }
}
