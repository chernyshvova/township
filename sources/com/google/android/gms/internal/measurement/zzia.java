package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzia {
    public static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzb;
    public static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final ByteBuffer zzd;
    public static final zzhb zze;

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzd = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzb;
        zze = zzhb.zza(bArr2, 0, bArr2.length, false);
    }

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static <T> T zza(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    public static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zza(byte[] bArr) {
        return zzlb.zza(bArr);
    }

    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static boolean zza(zzjj zzjj) {
        if (!(zzjj instanceof zzgh)) {
            return false;
        }
        zzgh zzgh = (zzgh) zzjj;
        return false;
    }

    public static Object zza(Object obj, Object obj2) {
        return ((zzjj) obj).zzbt().zza((zzjj) obj2).zzx();
    }
}
