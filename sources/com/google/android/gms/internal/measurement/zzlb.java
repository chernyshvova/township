package com.google.android.gms.internal.measurement;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzlb {
    public static final zzld zza;

    static {
        zzld zzld;
        if (!(zzkz.zza() && zzkz.zzb()) || zzgm.zza()) {
            zzld = new zzlc();
        } else {
            zzld = new zzle();
        }
        zza = zzld;
    }

    public static boolean zza(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static int zzb(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int zzb(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int zzb(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static String zzb(byte[] bArr, int i, int i2) throws zzij {
        return zza.zza(bArr, i, i2);
    }

    public static int zzd(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return zzb(b);
        }
        if (i3 == 1) {
            return zzb(b, bArr[i]);
        }
        if (i3 == 2) {
            return zzb((int) b, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static boolean zza(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }

    public static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzlf(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zza.zza(charSequence, bArr, i, i2);
    }
}
