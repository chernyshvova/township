package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwu implements zzfqa<String> {
    public final /* synthetic */ zzdww zza;

    public zzdwu(zzdww zzdww) {
        this.zza = zzdww;
    }

    public final void zza(Throwable th) {
        synchronized (this) {
            boolean unused = this.zza.zzc = true;
            this.zza.zzu("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzs.zzj().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zzd(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            boolean unused = this.zza.zzc = true;
            this.zza.zzu("com.google.android.gms.ads.MobileAds", true, "", (int) (zzs.zzj().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzdwt(this, str));
        }
    }
}
