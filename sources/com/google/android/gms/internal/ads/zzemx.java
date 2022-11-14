package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzemx implements zzeqp {
    public static final Object zzf = new Object();
    public final String zza;
    public final String zzb;
    public final zzcyv zzc;
    public final zzezw zzd;
    public final zzeyw zze;
    public final zzg zzg = zzs.zzg().zzl();

    public zzemx(String str, String str2, zzcyv zzcyv, zzezw zzezw, zzeyw zzeyw) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcyv;
        this.zzd = zzezw;
        this.zze = zzeyw;
    }

    public final zzfqn zza() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdR)).booleanValue()) {
            this.zzc.zzi(this.zze.zzd);
            bundle.putAll(this.zzd.zzc());
        }
        return zzfqe.zza(new zzemw(this, bundle));
    }

    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        String str;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdR)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdQ)).booleanValue()) {
                synchronized (zzf) {
                    this.zzc.zzi(this.zze.zzd);
                    bundle2.putBundle("quality_signals", this.zzd.zzc());
                }
            } else {
                this.zzc.zzi(this.zze.zzd);
                bundle2.putBundle("quality_signals", this.zzd.zzc());
            }
        }
        bundle2.putString("seq_num", this.zza);
        if (this.zzg.zzC()) {
            str = "";
        } else {
            str = this.zzb;
        }
        bundle2.putString("session_id", str);
    }
}
