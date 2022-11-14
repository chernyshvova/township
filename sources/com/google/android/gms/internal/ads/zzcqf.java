package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqf implements zzcws {
    public final /* synthetic */ zzcqg zza;
    public final zzcwt zzb;
    public final zzgju<zzeyq> zzc;
    public final zzgju<zzeye> zzd;
    public final zzgju<Set<zzdhz<zzdby>>> zze;
    public final zzgju<zzdcc> zzf;
    public final zzgju<Set<zzdhz<zzdcr>>> zzg;
    public final zzgju<zzdcp> zzh;
    public final zzgju<String> zzi;
    public final zzgju<zzeyh> zzj;
    public final zzgju<zzdaw> zzk = new zzdax(this.zzd, this.zzi, this.zza.zzbh, this.zzj);
    public final zzgju<zzdff> zzl = zzgjf.zza(zzdfh.zza());
    public final zzgju<Set<zzdhz<zzdcv>>> zzm;
    public final zzgju<zzdct> zzn;
    public final zzgju<zzcxh> zzo;
    public final zzgju<zzbnz> zzp;
    public final zzgju<Runnable> zzq;
    public final zzgju<zzcwr> zzr;

    public /* synthetic */ zzcqf(zzcqg zzcqg, zzcxx zzcxx, zzcwt zzcwt, zzcpp zzcpp) {
        this.zza = zzcqg;
        this.zzb = zzcwt;
        this.zzc = new zzcyb(zzcxx);
        this.zzd = new zzcxy(zzcxx);
        zzgjr zza2 = zzgjs.zza(0, 2);
        zza2.zzb(this.zza.zzck);
        zza2.zzb(this.zza.zzcl);
        zzgjs zzc2 = zza2.zzc();
        this.zze = zzc2;
        this.zzf = zzgjf.zza(new zzdcd(zzc2));
        zzgjr zza3 = zzgjs.zza(4, 3);
        zza3.zza(this.zza.zzcz);
        zza3.zza(this.zza.zzcA);
        zza3.zza(this.zza.zzcB);
        zza3.zzb(this.zza.zzcM);
        zza3.zzb(this.zza.zzcN);
        zza3.zzb(this.zza.zzcO);
        zza3.zza(this.zza.zzcC);
        zzgjs zzc3 = zza3.zzc();
        this.zzg = zzc3;
        this.zzh = zzgjf.zza(new zzdcq(zzc3));
        this.zzi = new zzcxz(zzcxx);
        this.zzj = new zzcya(zzcxx);
        zzgjr zza4 = zzgjs.zza(1, 1);
        zza4.zzb(this.zza.zzcQ);
        zza4.zza(this.zza.zzcR);
        zzgjs zzc4 = zza4.zzc();
        this.zzm = zzc4;
        this.zzn = new zzdcu(zzc4);
        this.zzo = new zzczd(this.zzc, this.zzd, this.zzf, this.zzh, this.zza.zzcP, this.zzk, this.zzl, this.zzn);
        this.zzp = new zzcwv(zzcwt);
        zzcwu zzcwu = new zzcwu(zzcwt);
        this.zzq = zzcwu;
        this.zzr = zzgjf.zza(new zzcww(this.zzo, this.zzp, zzcwu, this.zza.zza.zzo));
    }

    public final zzcvj zza() {
        zzcwr zzb2 = this.zzr.zzb();
        zzgjp.zzb(zzb2);
        return zzb2;
    }
}
