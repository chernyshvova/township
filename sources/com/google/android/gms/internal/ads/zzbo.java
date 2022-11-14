package com.google.android.gms.internal.ads;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbo {
    public static long zza(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        return j < 0 ? j + AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT : j;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        return zzc(byteBuffer.get()) + (zzc(byteBuffer.get()) << 8);
    }

    public static int zzc(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static long zzd(ByteBuffer byteBuffer) {
        long zza = zza(byteBuffer) << 32;
        if (zza >= 0) {
            return zza(byteBuffer) + zza;
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double zze(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & Base64.EQUALS_SIGN_ENC));
        Double.isNaN(d);
        return d / 65536.0d;
    }

    public static double zzf(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & Base64.EQUALS_SIGN_ENC));
        Double.isNaN(d);
        return d / 1.073741824E9d;
    }
}
