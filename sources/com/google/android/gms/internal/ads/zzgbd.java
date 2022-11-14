package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbd implements zzfrh {
    public final zzgbo zza;
    public final zzfrz zzb;

    public zzgbd(zzgbo zzgbo, zzfrz zzfrz, int i) {
        this.zza = zzgbo;
        this.zzb = zzfrz;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = this.zza.zza(bArr);
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzgar.zza(zza2, this.zzb.zza(zzgar.zza(bArr2, zza2, copyOf)));
    }
}
