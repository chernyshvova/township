package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzblp extends zzblz {
    public static final int zza;
    public static final int zzb = zzc;
    public static final int zzc = Color.rgb(12, 174, 206);
    public static final int zzd;
    public final String zze;
    public final List<zzbls> zzf = new ArrayList();
    public final List<zzbmi> zzg = new ArrayList();
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final int zzl;

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzd = rgb;
        zza = rgb;
    }

    public zzblp(String str, List<zzbls> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        int i3;
        int i4;
        this.zze = str;
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzbls zzbls = list.get(i5);
            this.zzf.add(zzbls);
            this.zzg.add(zzbls);
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = zza;
        }
        this.zzh = i3;
        if (num2 != null) {
            i4 = num2.intValue();
        } else {
            i4 = zzb;
        }
        this.zzi = i4;
        this.zzj = num3 != null ? num3.intValue() : 12;
        this.zzk = i;
        this.zzl = i2;
    }

    public final String zzb() {
        return this.zze;
    }

    public final List<zzbmi> zzc() {
        return this.zzg;
    }

    public final List<zzbls> zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi;
    }

    public final int zzg() {
        return this.zzj;
    }

    public final int zzh() {
        return this.zzk;
    }

    public final int zzi() {
        return this.zzl;
    }
}
