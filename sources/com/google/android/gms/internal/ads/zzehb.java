package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehb {
    public final zzezj zza;
    public final zzdsp zzb;
    public final zzduu zzc;
    public final zzfdh zzd;

    public zzehb(zzezj zzezj, zzdsp zzdsp, zzduu zzduu, zzfdh zzfdh) {
        this.zza = zzezj;
        this.zzb = zzdsp;
        this.zzc = zzduu;
        this.zzd = zzfdh;
    }

    public final void zza(zzeyh zzeyh, zzeye zzeye, int i, @Nullable zzedr zzedr, long j) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
            zzfdg zza2 = zzfdg.zza("adapter_status");
            zza2.zzh(zzeyh);
            zza2.zzi(zzeye);
            zza2.zzc("adapter_l", String.valueOf(j));
            zza2.zzc("sc", Integer.toString(i));
            if (zzedr != null) {
                zza2.zzc("arec", Integer.toString(zzedr.zzb().zza));
                String zza3 = this.zza.zza(zzedr.getMessage());
                if (zza3 != null) {
                    zza2.zzc("areec", zza3);
                }
            }
            zzdso zzd2 = this.zzb.zzd(zzeye.zzt);
            if (zzd2 != null) {
                zza2.zzc("ancn", zzd2.zza);
                zzbyb zzbyb = zzd2.zzb;
                if (zzbyb != null) {
                    zza2.zzc("adapter_v", zzbyb.toString());
                }
                zzbyb zzbyb2 = zzd2.zzc;
                if (zzbyb2 != null) {
                    zza2.zzc("adapter_sv", zzbyb2.toString());
                }
            }
            this.zzd.zza(zza2);
            return;
        }
        zzdut zza4 = this.zzc.zza();
        zza4.zza(zzeyh);
        zza4.zzb(zzeye);
        zza4.zzc("action", "adapter_status");
        zza4.zzc("adapter_l", String.valueOf(j));
        zza4.zzc("sc", Integer.toString(i));
        if (zzedr != null) {
            zza4.zzc("arec", Integer.toString(zzedr.zzb().zza));
            String zza5 = this.zza.zza(zzedr.getMessage());
            if (zza5 != null) {
                zza4.zzc("areec", zza5);
            }
        }
        zzdso zzd3 = this.zzb.zzd(zzeye.zzt);
        if (zzd3 != null) {
            zza4.zzc("ancn", zzd3.zza);
            zzbyb zzbyb3 = zzd3.zzb;
            if (zzbyb3 != null) {
                zza4.zzc("adapter_v", zzbyb3.toString());
            }
            zzbyb zzbyb4 = zzd3.zzc;
            if (zzbyb4 != null) {
                zza4.zzc("adapter_sv", zzbyb4.toString());
            }
        }
        zza4.zzd();
    }
}
