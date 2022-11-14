package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzak implements zzar {
    public zzct<zzbh> zza;
    public zzct<zzbb> zzb;
    public zzct<zzat> zzc;
    public zzct zzd;
    public zzct<zzbe> zze;
    public final /* synthetic */ zzag zzf;

    public zzak(zzag zzag, zzbb zzbb) {
        this.zzf = zzag;
        this.zza = zzcq.zza(new zzbk(this.zzf.zza));
        this.zzb = zzcs.zza(zzbb);
        this.zzc = new zzcn();
        this.zzd = new zzbo(this.zzf.zza, this.zza, zzaq.zza, zzas.zza, this.zzf.zzh, this.zzf.zzi, this.zzc);
        this.zze = new zzbi(this.zza, zzaq.zza, this.zzd);
        zzcn.zza(this.zzc, zzcq.zza(new zzba(this.zzf.zza, this.zzf.zzc, this.zza, this.zzf.zzb, this.zzb, this.zze)));
    }

    public final zzat zza() {
        return this.zzc.zza();
    }

    public /* synthetic */ zzak(zzag zzag, zzbb zzbb, zzaf zzaf) {
        this(zzag, zzbb);
    }
}
