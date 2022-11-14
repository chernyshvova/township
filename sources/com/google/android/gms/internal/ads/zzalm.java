package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.CodelessMatcher;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalm {
    public final String zza;

    public zzalm(int i, int i2, String str) {
        this.zza = str;
    }

    @Nullable
    public static zzalm zza(zzakr zzakr) {
        String str;
        zzakr.zzk(2);
        int zzn = zzakr.zzn();
        int i = zzn >> 1;
        int zzn2 = (zzakr.zzn() >> 3) | ((zzn & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else if (i != 9) {
            return null;
        } else {
            str = "avc3";
        }
        String str2 = zzn2 < 10 ? ".0" : CodelessMatcher.CURRENT_CLASS_NAME;
        StringBuilder sb = new StringBuilder(str.length() + 24 + str2.length());
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(str2);
        sb.append(zzn2);
        return new zzalm(i, zzn2, sb.toString());
    }
}
