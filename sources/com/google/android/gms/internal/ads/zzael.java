package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzael extends zzadf<Integer> {
    public static final zzkq zza;
    public final zzadx[] zzb;
    public final zzmv[] zzc;
    public final ArrayList<zzadx> zzd;
    public final Map<Object, Long> zze;
    public final zzfnl<Object, zzadb> zzf;
    public int zzg = -1;
    public long[][] zzh;
    @Nullable
    public zzaek zzi;
    public final zzadh zzj;

    static {
        zzkj zzkj = new zzkj();
        zzkj.zza("MergingMediaSource");
        zza = zzkj.zzc();
    }

    public zzael(boolean z, boolean z2, zzadx... zzadxArr) {
        zzadh zzadh = new zzadh();
        this.zzb = zzadxArr;
        this.zzj = zzadh;
        this.zzd = new ArrayList<>(Arrays.asList(zzadxArr));
        this.zzc = new zzmv[zzadxArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzfns.zzb(8).zzb(2).zza();
    }

    public final void zzA(zzadt zzadt) {
        zzaej zzaej = (zzaej) zzadt;
        int i = 0;
        while (true) {
            zzadx[] zzadxArr = this.zzb;
            if (i < zzadxArr.length) {
                zzadxArr[i].zzA(zzaej.zza(i));
                i++;
            } else {
                return;
            }
        }
    }

    public final zzadt zzC(zzadv zzadv, zzahy zzahy, long j) {
        int length = this.zzb.length;
        zzadt[] zzadtArr = new zzadt[length];
        int zzh2 = this.zzc[0].zzh(zzadv.zza);
        for (int i = 0; i < length; i++) {
            zzadtArr[i] = this.zzb[i].zzC(zzadv.zzc(this.zzc[i].zzi(zzh2)), zzahy, j - this.zzh[zzh2][i]);
        }
        return new zzaej(this.zzj, this.zzh[zzh2], zzadtArr, (byte[]) null);
    }

    public final void zza(@Nullable zzajd zzajd) {
        super.zza(zzajd);
        for (int i = 0; i < this.zzb.length; i++) {
            zzw(Integer.valueOf(i), this.zzb[i]);
        }
    }

    public final void zzd() {
        super.zzd();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    public final void zzu() throws IOException {
        zzaek zzaek = this.zzi;
        if (zzaek == null) {
            super.zzu();
            return;
        }
        throw zzaek;
    }

    public final /* bridge */ /* synthetic */ void zzv(Object obj, zzadx zzadx, zzmv zzmv) {
        int i;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i = zzmv.zzs();
                this.zzg = i;
            } else {
                int zzs = zzmv.zzs();
                int i2 = this.zzg;
                if (zzs == i2) {
                    i = i2;
                } else {
                    this.zzi = new zzaek(0);
                    return;
                }
            }
            if (this.zzh.length == 0) {
                int[] iArr = new int[2];
                iArr[1] = this.zzc.length;
                iArr[0] = i;
                this.zzh = (long[][]) Array.newInstance(long.class, iArr);
            }
            this.zzd.remove(zzadx);
            this.zzc[((Integer) obj).intValue()] = zzmv;
            if (this.zzd.isEmpty()) {
                zze(this.zzc[0]);
            }
        }
    }

    @Nullable
    public final /* bridge */ /* synthetic */ zzadv zzx(Object obj, zzadv zzadv) {
        if (((Integer) obj).intValue() == 0) {
            return zzadv;
        }
        return null;
    }

    public final zzkq zzz() {
        zzadx[] zzadxArr = this.zzb;
        return zzadxArr.length > 0 ? zzadxArr[0].zzz() : zza;
    }
}
