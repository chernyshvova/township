package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgay implements zzfrm {
    public static final byte[] zza = new byte[0];
    public final zzgbb zzb;
    public final String zzc;
    public final byte[] zzd;
    public final zzgaw zze;
    public final int zzf;

    public zzgay(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, zzgaw zzgaw) throws GeneralSecurityException {
        zzgbc.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzb = new zzgbb(eCPublicKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zzf = i;
        this.zze = zzgaw;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzgba zza2 = this.zzb.zza(this.zzc, this.zzd, bArr2, this.zze.zza(), this.zzf);
        byte[] zza3 = this.zze.zzb(zza2.zzb()).zza(bArr, zza);
        byte[] zza4 = zza2.zza();
        return ByteBuffer.allocate(zza4.length + zza3.length).put(zza4).put(zza3).array();
    }
}
