package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgav implements zzfrh {
    public final zzgat zza;
    public final zzgat zzb;

    public zzgav(byte[] bArr) throws GeneralSecurityException {
        this.zza = zzb(bArr, 1);
        this.zzb = zzb(bArr, 0);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= (Integer.MAX_VALUE - this.zza.zzc()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(this.zza.zzc() + length + 16);
            if (allocate.remaining() >= this.zza.zzc() + length + 16) {
                int position = allocate.position();
                this.zza.zzd(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.zza.zzc()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                byte[] bArr4 = new byte[32];
                this.zzb.zze(bArr3, 0).get(bArr4);
                int length2 = bArr2.length;
                int i = length2 & 15;
                int i2 = i == 0 ? length2 : (length2 + 16) - i;
                int remaining = allocate.remaining();
                int i3 = remaining % 16;
                int i4 = (i3 == 0 ? remaining : (remaining + 16) - i3) + i2;
                ByteBuffer order = ByteBuffer.allocate(i4 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(i2);
                order.put(allocate);
                order.position(i4);
                order.putLong((long) length2);
                order.putLong((long) remaining);
                byte[] zza2 = zzgbp.zza(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(zza2);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract zzgat zzb(byte[] bArr, int i) throws InvalidKeyException;
}
