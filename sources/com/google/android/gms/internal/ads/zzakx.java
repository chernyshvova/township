package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakx {
    public static final Comparator<zzakw> zza = zzakt.zza;
    public static final Comparator<zzakw> zzb = zzaku.zza;
    public final ArrayList<zzakw> zzc = new ArrayList<>();
    public final zzakw[] zzd = new zzakw[5];
    public int zze = -1;
    public int zzf;
    public int zzg;
    public int zzh;

    public zzakx(int i) {
    }

    public final void zza() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(int i, float f) {
        zzakw zzakw;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzakw[] zzakwArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzakw = zzakwArr[i3];
        } else {
            zzakw = new zzakw((zzakv) null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzakw.zza = i4;
        zzakw.zzb = i;
        zzakw.zzc = f;
        this.zzc.add(zzakw);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 > 2000) {
                int i6 = i5 - 2000;
                zzakw zzakw2 = this.zzc.get(0);
                int i7 = zzakw2.zzb;
                if (i7 <= i6) {
                    this.zzg -= i7;
                    this.zzc.remove(0);
                    int i8 = this.zzh;
                    if (i8 < 5) {
                        zzakw[] zzakwArr2 = this.zzd;
                        this.zzh = i8 + 1;
                        zzakwArr2[i8] = zzakw2;
                    }
                } else {
                    zzakw2.zzb = i7 - i6;
                    this.zzg -= i6;
                }
            } else {
                return;
            }
        }
    }

    public final float zzc(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = ((float) this.zzg) * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzakw zzakw = this.zzc.get(i2);
            i += zzakw.zzb;
            if (((float) i) >= f2) {
                return zzakw.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<zzakw> arrayList = this.zzc;
        return arrayList.get(arrayList.size() - 1).zzc;
    }
}
