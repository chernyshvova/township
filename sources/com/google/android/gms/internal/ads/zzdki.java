package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdki implements zzcxl<zzcxp> {
    public final Map<String, zzedn<zzcxp>> zza;
    public final Map<String, zzedn<zzdlv>> zzb;
    public final Map<String, zzegb<zzdlv>> zzc;
    public final zzgju<zzcxl<zzcvj>> zzd;
    public final zzdml zze;

    public zzdki(Map<String, zzedn<zzcxp>> map, Map<String, zzedn<zzdlv>> map2, Map<String, zzegb<zzdlv>> map3, zzgju<zzcxl<zzcvj>> zzgju, zzdml zzdml) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzgju;
        this.zze = zzdml;
    }

    @Nullable
    public final zzedn<zzcxp> zza(int i, String str) {
        zzedn zza2;
        zzedn<zzcxp> zzedn = this.zza.get(str);
        if (zzedn != null) {
            return zzedn;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzegb zzegb = this.zzc.get(str);
            if (zzegb != null) {
                return zzcxp.zza(zzegb);
            }
            zzedn zzedn2 = this.zzb.get(str);
            if (zzedn2 == null) {
                return null;
            }
            return zzcxp.zzb(zzedn2);
        } else if (this.zze.zzd() == null || (zza2 = this.zzd.zzb().zza(i, str)) == null) {
            return null;
        } else {
            return zzcxp.zzb(zza2);
        }
    }
}
