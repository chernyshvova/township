package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaez implements zzaeg {
    public final zzahs zza;
    public final zzaem zzb;
    public int zzc = 1048576;
    public final zzaih zzd = new zzaih(-1);
    public final zzrw zze = new zzrw();

    public zzaez(zzahs zzahs, zztg zztg) {
        zzaey zzaey = new zzaey(zztg);
        this.zza = zzahs;
        this.zzb = zzaey;
    }

    public final zzaez zza(int i) {
        this.zzc = i;
        return this;
    }

    public final zzafa zzb(zzkq zzkq) {
        if (zzkq.zzb != null) {
            return new zzafa(zzkq, this.zza, this.zzb, zzsi.zza, this.zzd, this.zzc, (zzaex) null, (byte[]) null);
        }
        throw null;
    }
}
