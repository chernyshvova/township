package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqh {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    public final boolean zze;
    public final zzaut zzf;
    public final zzaut zzg;
    public int zzh;
    public int zzi;

    public zzaqh(zzaut zzaut, zzaut zzaut2, boolean z) {
        this.zzg = zzaut;
        this.zzf = zzaut2;
        this.zze = z;
        zzaut2.zzi(12);
        this.zza = zzaut2.zzu();
        zzaut.zzi(12);
        this.zzi = zzaut.zzu();
        zzaul.zze(zzaut.zzr() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            j = this.zzf.zzv();
        } else {
            j = this.zzf.zzp();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzu();
            this.zzg.zzj(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzu();
            }
            this.zzh = i2;
        }
        return true;
    }
}
