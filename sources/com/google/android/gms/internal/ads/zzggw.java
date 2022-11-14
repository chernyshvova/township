package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggw extends zzggx {
    public zzggw(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object obj, long j, byte b) {
        if (zzggy.zzb) {
            zzggy.zzG(obj, j, b);
        } else {
            zzggy.zzH(obj, j, b);
        }
    }

    public final boolean zzb(Object obj, long j) {
        if (zzggy.zzb) {
            return zzggy.zzy(obj, j);
        }
        return zzggy.zzz(obj, j);
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzggy.zzb) {
            zzggy.zzG(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzggy.zzH(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(zzm(obj, j));
    }

    public final void zze(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(zzo(obj, j));
    }

    public final void zzg(Object obj, long j, double d) {
        zzp(obj, j, Double.doubleToLongBits(d));
    }

    public final byte zzh(long j) {
        return Memory.peekByte(j);
    }

    public final void zzi(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray(j, bArr, (int) j2, (int) j3);
    }
}
