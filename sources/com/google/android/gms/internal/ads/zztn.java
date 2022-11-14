package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztn {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    @Nullable
    public final zztm zzk;
    @Nullable
    public final zzabe zzl;

    public zztn(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable zztm zztm, @Nullable zzabe zzabe) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzh(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzi(i7);
        this.zzj = j;
        this.zzk = zztm;
        this.zzl = zzabe;
    }

    public zztn(byte[] bArr, int i) {
        zzakq zzakq = new zzakq(bArr, bArr.length);
        zzakq.zzd(i * 8);
        this.zza = zzakq.zzh(16);
        this.zzb = zzakq.zzh(16);
        this.zzc = zzakq.zzh(24);
        this.zzd = zzakq.zzh(24);
        int zzh2 = zzakq.zzh(20);
        this.zze = zzh2;
        this.zzf = zzh(zzh2);
        this.zzg = zzakq.zzh(3) + 1;
        int zzh3 = zzakq.zzh(5) + 1;
        this.zzh = zzh3;
        this.zzi = zzi(zzh3);
        this.zzj = zzalh.zzJ(zzakq.zzh(4), zzakq.zzh(32));
        this.zzk = null;
        this.zzl = null;
    }

    public static int zzh(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public static int zzi(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    @Nullable
    public static zzabe zzj(List<String> list, List<zzabl> list2) {
        String str;
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            String[] zzu = zzalh.zzu(str2, "=");
            if (zzu.length != 2) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    str = "Failed to parse Vorbis comment: ".concat(valueOf);
                } else {
                    str = new String("Failed to parse Vorbis comment: ");
                }
                Log.w("FlacStreamMetadata", str);
            } else {
                arrayList.add(new zzabn(zzu[0], zzu[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzabe((List<? extends zzabd>) arrayList);
    }

    public final long zza() {
        long j = this.zzj;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return zzalh.zzy((j * ((long) this.zze)) / 1000000, 0, this.zzj - 1);
    }

    public final zzkc zzc(byte[] bArr, @Nullable zzabe zzabe) {
        bArr[4] = Byte.MIN_VALUE;
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zzabe zzd2 = zzd(zzabe);
        zzkb zzkb = new zzkb();
        zzkb.zzj("audio/flac");
        zzkb.zzk(i);
        zzkb.zzw(this.zzg);
        zzkb.zzx(this.zze);
        zzkb.zzl(Collections.singletonList(bArr));
        zzkb.zzi(zzd2);
        return zzkb.zzD();
    }

    @Nullable
    public final zzabe zzd(@Nullable zzabe zzabe) {
        zzabe zzabe2 = this.zzl;
        return zzabe2 == null ? zzabe : zzabe2.zzc(zzabe);
    }

    public final zztn zze(@Nullable zztm zztm) {
        return new zztn(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zztm, this.zzl);
    }

    public final zztn zzf(List<String> list) {
        return new zztn(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzj(list, Collections.emptyList())));
    }

    public final zztn zzg(List<zzabl> list) {
        return new zztn(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzj(Collections.emptyList(), list)));
    }
}
