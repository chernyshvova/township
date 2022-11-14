package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgx {
    public final zzhi zza;
    public final byte[] zzb;

    public zzgx(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzhi.zza(bArr);
    }

    public final zzgp zza() {
        this.zza.zzb();
        return new zzgz(this.zzb);
    }

    public final zzhi zzb() {
        return this.zza;
    }

    public /* synthetic */ zzgx(int i, zzgs zzgs) {
        this(i);
    }
}
