package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfto implements zzfrh {
    public static final byte[] zza = new byte[0];
    public final zzfyx zzb;
    public final zzfrh zzc;

    public zzfto(zzfyx zzfyx, zzfrh zzfrh) {
        this.zzb = zzfyx;
        this.zzc = zzfrh;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzao = zzfsn.zzh(this.zzb).zzao();
        byte[] zza2 = this.zzc.zza(zzao, zza);
        byte[] zza3 = ((zzfrh) zzfsn.zzj(this.zzb.zza(), zzao, zzfrh.class)).zza(bArr, bArr2);
        int length = zza2.length;
        return ByteBuffer.allocate(length + 4 + zza3.length).putInt(length).put(zza2).put(zza3).array();
    }
}
