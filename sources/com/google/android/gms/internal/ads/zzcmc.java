package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcmc implements zzahs {
    public final zzahs zza;
    public final byte[] zzb;

    public zzcmc(zzahs zzahs, byte[] bArr) {
        this.zza = zzahs;
        this.zzb = bArr;
    }

    public final zzaht zza() {
        zzahs zzahs = this.zza;
        byte[] bArr = this.zzb;
        int i = zzcmh.zzc;
        return new zzclm(new zzahn(bArr), bArr.length, zzahs.zza());
    }
}
