package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdta implements zzayw {
    public final zzazh zza;
    public final String zzb;
    public final zzbcb zzc;
    public final String zzd;

    public zzdta(zzazh zzazh, String str, zzbcb zzbcb, String str2) {
        this.zza = zzazh;
        this.zzb = str;
        this.zzc = zzbcb;
        this.zzd = str2;
    }

    public final void zza(zzbaq zzbaq) {
        zzazh zzazh = this.zza;
        String str = this.zzb;
        zzbcb zzbcb = this.zzc;
        String str2 = this.zzd;
        zzazi zzazi = (zzazi) zzbaq.zzg().zzau();
        zzazi.zza(zzazh);
        zzbaq.zzh(zzazi);
        zzbag zzbag = (zzbag) zzbaq.zze().zzau();
        zzbag.zza(str);
        zzbag.zzb(zzbcb);
        zzbaq.zzf(zzbag);
        zzbaq.zzb(str2);
    }
}
