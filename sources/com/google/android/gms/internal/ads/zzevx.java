package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevx {
    public static zzevv<zzcum, zzcus> zza(Context context, zzfad zzfad, zzfav zzfav) {
        return zzc(context, zzfad, zzfav);
    }

    public static zzevv<zzcux, zzcvc> zzb(Context context, zzfad zzfad, zzfav zzfav) {
        return zzc(context, zzfad, zzfav);
    }

    public static <AppOpenAdRequestComponent extends zzdam<AppOpenAd>, AppOpenAd extends zzcxi> zzevv<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzfad zzfad, zzfav zzfav) {
        if (((Integer) zzbex.zzc().zzb(zzbjn.zzeS)).intValue() > 0) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeC)).booleanValue() || zzs.zzg().zzl().zzo().zzi()) {
                zzfau zza = zzfav.zza(zzfal.AppOpen, context, zzfad, new zzeva(new zzeux()));
                return new zzevc(new zzevm(new zzevl()), new zzevi(zza.zza, zzche.zza), zza.zzb, zza.zza.zze().zzf, zzche.zza);
            }
        }
        return new zzevl();
    }
}
