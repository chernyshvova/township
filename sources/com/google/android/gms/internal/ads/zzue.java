package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzue {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static zzub zzb(zzakr zzakr, boolean z, boolean z2) throws zzlg {
        if (z) {
            zzc(3, zzakr, false);
        }
        String zzE = zzakr.zzE((int) zzakr.zzu(), zzfjs.zzc);
        int length = zzE.length();
        long zzu = zzakr.zzu();
        String[] strArr = new String[((int) zzu)];
        int i = length + 15;
        for (int i2 = 0; ((long) i2) < zzu; i2++) {
            String zzE2 = zzakr.zzE((int) zzakr.zzu(), zzfjs.zzc);
            strArr[i2] = zzE2;
            i = i + 4 + zzE2.length();
        }
        if (!z2 || (zzakr.zzn() & 1) != 0) {
            return new zzub(zzE, strArr, i + 1);
        }
        throw new zzlg("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzc(int i, zzakr zzakr, boolean z) throws zzlg {
        String str;
        if (zzakr.zzd() < 7) {
            if (z) {
                return false;
            }
            throw new zzlg(GeneratedOutlineSupport.outline9(29, "too short header: ", zzakr.zzd()), (Throwable) null);
        } else if (zzakr.zzn() != i) {
            if (z) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i));
            if (valueOf.length() != 0) {
                str = "expected header type ".concat(valueOf);
            } else {
                str = new String("expected header type ");
            }
            throw new zzlg(str, (Throwable) null);
        } else if (zzakr.zzn() == 118 && zzakr.zzn() == 111 && zzakr.zzn() == 114 && zzakr.zzn() == 98 && zzakr.zzn() == 105 && zzakr.zzn() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new zzlg("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
