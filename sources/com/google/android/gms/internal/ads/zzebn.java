package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebn implements zzdhn {
    @GuardedBy("this")
    public boolean zza = false;
    @GuardedBy("this")
    public boolean zzb = false;
    public final String zzc;
    public final zzfdh zzd;
    public final zzg zze;

    public zzebn(String str, zzfdh zzfdh) {
        this.zzc = str;
        this.zzd = zzfdh;
        this.zze = zzs.zzg().zzl();
    }

    private final zzfdg zzf(String str) {
        String str2;
        if (this.zze.zzC()) {
            str2 = "";
        } else {
            str2 = this.zzc;
        }
        zzfdg zza2 = zzfdg.zza(str);
        zza2.zzc("tms", Long.toString(zzs.zzj().elapsedRealtime(), 10));
        zza2.zzc("tid", str2);
        return zza2;
    }

    public final void zza(String str) {
        zzfdh zzfdh = this.zzd;
        zzfdg zzf = zzf("adapter_init_started");
        zzf.zzc("ancn", str);
        zzfdh.zza(zzf);
    }

    public final void zzb(String str) {
        zzfdh zzfdh = this.zzd;
        zzfdg zzf = zzf("adapter_init_finished");
        zzf.zzc("ancn", str);
        zzfdh.zza(zzf);
    }

    public final void zzc(String str, String str2) {
        zzfdh zzfdh = this.zzd;
        zzfdg zzf = zzf("adapter_init_finished");
        zzf.zzc("ancn", str);
        zzf.zzc("rqe", str2);
        zzfdh.zza(zzf);
    }

    public final synchronized void zzd() {
        if (!this.zza) {
            this.zzd.zza(zzf("init_started"));
            this.zza = true;
        }
    }

    public final synchronized void zze() {
        if (!this.zzb) {
            this.zzd.zza(zzf("init_finished"));
            this.zzb = true;
        }
    }
}
