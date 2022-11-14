package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzag extends zzc {
    public zzct<Application> zza;
    public zzct<zzal> zzb;
    public zzct<zzab> zzc;
    public zzct<zzau> zzd;
    public zzct<zzaz> zze;
    public zzct<zzb> zzf;
    public zzct<zzn> zzg;
    public zzct<zze> zzh;
    public zzct<zzaj> zzi;
    public zzct<zzz> zzj;
    public zzct<zzp> zzk;
    public zzct<zzj> zzl;

    public zzag(Application application) {
        zzcp zza2 = zzcs.zza(application);
        this.zza = zza2;
        this.zzb = zzcq.zza(new zzao(zza2));
        this.zzc = zzcq.zza(zzad.zza);
        zzaf zzaf = new zzaf(this);
        this.zzd = zzaf;
        this.zze = zzcq.zza(new zzbc(zzaf));
        zzd zzd2 = new zzd(this.zza);
        this.zzf = zzd2;
        this.zzg = new zzq(this.zza, zzd2, this.zzb);
        this.zzh = zzcq.zza(new zzh(zzas.zza));
        zzam zzam = new zzam(this.zza, this.zzb, zzas.zza);
        this.zzi = zzam;
        this.zzj = new zzac(this.zzh, zzam, this.zzb);
        zzv zzv = new zzv(this.zza, this.zzc, zzaq.zza, zzas.zza, this.zzb, this.zze, this.zzg, this.zzj, this.zzh);
        this.zzk = zzv;
        this.zzl = zzcq.zza(new zzm(this.zzb, zzv, this.zze));
    }

    public final zzj zza() {
        return this.zzl.zza();
    }

    public final zzaz zzb() {
        return this.zze.zza();
    }

    public /* synthetic */ zzag(Application application, zzaf zzaf) {
        this(application);
    }
}
