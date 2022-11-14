package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzre {
    public static List<byte[]> zza(byte[] bArr) {
        byte b = bArr[11];
        byte b2 = bArr[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzb(zzc((long) (((b & Base64.EQUALS_SIGN_ENC) << 8) | (b2 & Base64.EQUALS_SIGN_ENC)))));
        arrayList.add(zzb(zzc(3840)));
        return arrayList;
    }

    public static byte[] zzb(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static long zzc(long j) {
        return (j * 1000000000) / 48000;
    }
}
