package com.google.android.gms.internal.ads;

import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbev {
    public static final zzbev zza = new zzbev();
    public final zzcgl zzb;
    public final zzbet zzc;
    public final String zzd;
    public final zzcgy zze;
    public final Random zzf;

    public zzbev() {
        zzcgl zzcgl = new zzcgl();
        zzbet zzbet = new zzbet(new zzbdj(), new zzbdh(), new zzbia(), new zzboh(), new zzcdf(), new zzbzo(), new zzboi());
        String zzf2 = zzcgl.zzf();
        zzcgy zzcgy = new zzcgy(0, 212104000, true, false, false);
        Random random = new Random();
        this.zzb = zzcgl;
        this.zzc = zzbet;
        this.zzd = zzf2;
        this.zze = zzcgy;
        this.zzf = random;
    }

    public static zzcgl zza() {
        return zza.zzb;
    }

    public static zzbet zzb() {
        return zza.zzc;
    }

    public static String zzc() {
        return zza.zzd;
    }

    public static zzcgy zzd() {
        return zza.zze;
    }

    public static Random zze() {
        return zza.zzf;
    }
}
