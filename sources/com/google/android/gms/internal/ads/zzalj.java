package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalj {
    public final List<byte[]> zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final float zze;
    @Nullable
    public final String zzf;

    public zzalj(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = f;
        this.zzf = str;
    }

    public static zzalj zza(zzakr zzakr) throws zzlg {
        String str;
        float f;
        int i;
        int i2;
        try {
            zzakr.zzk(4);
            int zzn = (zzakr.zzn() & 3) + 1;
            if (zzn != 3) {
                ArrayList arrayList = new ArrayList();
                int zzn2 = zzakr.zzn() & 31;
                for (int i3 = 0; i3 < zzn2; i3++) {
                    arrayList.add(zzb(zzakr));
                }
                int zzn3 = zzakr.zzn();
                for (int i4 = 0; i4 < zzn3; i4++) {
                    arrayList.add(zzb(zzakr));
                }
                if (zzn2 > 0) {
                    zzaki zzb2 = zzakj.zzb((byte[]) arrayList.get(0), zzn, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzb2.zze;
                    int i6 = zzb2.zzf;
                    float f2 = zzb2.zzg;
                    str = zzaji.zza(zzb2.zza, zzb2.zzb, zzb2.zzc);
                    i2 = i5;
                    i = i6;
                    f = f2;
                } else {
                    str = null;
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new zzalj(arrayList, zzn, i2, i, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlg("Error parsing AVC config", e);
        }
    }

    public static byte[] zzb(zzakr zzakr) {
        int zzo = zzakr.zzo();
        int zzg = zzakr.zzg();
        zzakr.zzk(zzo);
        return zzaji.zzc(zzakr.zzi(), zzg, zzo);
    }
}
