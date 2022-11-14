package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwv extends zzbrp {
    public final /* synthetic */ Object zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzchj zzd;
    public final /* synthetic */ zzdww zze;

    public zzdwv(zzdww zzdww, Object obj, String str, long j, zzchj zzchj) {
        this.zze = zzdww;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzchj;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zze.zzu(this.zzb, true, "", (int) (zzs.zzj().elapsedRealtime() - this.zzc));
            this.zze.zzl.zzb(this.zzb);
            this.zze.zzo.zzb(this.zzb);
            this.zzd.zzc(Boolean.TRUE);
        }
    }

    public final void zzf(String str) {
        synchronized (this.zza) {
            this.zze.zzu(this.zzb, false, str, (int) (zzs.zzj().elapsedRealtime() - this.zzc));
            this.zze.zzl.zzc(this.zzb, "error");
            this.zze.zzo.zzc(this.zzb, "error");
            this.zzd.zzc(Boolean.FALSE);
        }
    }
}
