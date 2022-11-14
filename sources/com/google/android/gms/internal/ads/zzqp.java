package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqp {
    public final zzpn[] zza;
    public final zzrg zzb;
    public final zzri zzc;

    public zzqp(zzpn... zzpnArr) {
        zzrg zzrg = new zzrg();
        zzri zzri = new zzri();
        zzpn[] zzpnArr2 = new zzpn[2];
        this.zza = zzpnArr2;
        System.arraycopy(zzpnArr, 0, zzpnArr2, 0, 0);
        this.zzb = zzrg;
        this.zzc = zzri;
        zzpn[] zzpnArr3 = this.zza;
        zzpnArr3[0] = zzrg;
        zzpnArr3[1] = zzri;
    }

    public final zzpn[] zza() {
        return this.zza;
    }

    public final zzll zzb(zzll zzll) {
        this.zzc.zzi(zzll.zzb);
        this.zzc.zzj(zzll.zzc);
        return zzll;
    }

    public final boolean zzc(boolean z) {
        this.zzb.zzo(z);
        return z;
    }

    public final long zzd(long j) {
        return this.zzc.zzk(j);
    }

    public final long zze() {
        return this.zzb.zzp();
    }
}
