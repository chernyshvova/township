package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvx extends zzvz {
    public final long zza;
    public final List<zzvy> zzb = new ArrayList();
    public final List<zzvx> zzc = new ArrayList();

    public zzvx(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        String zzf = zzvz.zzf(this.zzd);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(zzf).length(), 22, String.valueOf(arrays).length(), String.valueOf(arrays2).length()));
        GeneratedOutlineSupport.outline34(sb, zzf, " leaves: ", arrays, " containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final void zza(zzvy zzvy) {
        this.zzb.add(zzvy);
    }

    public final void zzb(zzvx zzvx) {
        this.zzc.add(zzvx);
    }

    @Nullable
    public final zzvy zzc(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzvy zzvy = this.zzb.get(i2);
            if (zzvy.zzd == i) {
                return zzvy;
            }
        }
        return null;
    }

    @Nullable
    public final zzvx zzd(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzvx zzvx = this.zzc.get(i2);
            if (zzvx.zzd == i) {
                return zzvx;
            }
        }
        return null;
    }
}
