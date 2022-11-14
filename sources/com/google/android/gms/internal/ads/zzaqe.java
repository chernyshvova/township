package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqe extends zzaqg {
    public final long zza;
    public final List<zzaqf> zzb = new ArrayList();
    public final List<zzaqe> zzc = new ArrayList();

    public zzaqe(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        String zzg = zzaqg.zzg(this.zzaR);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(zzg).length(), 22, String.valueOf(arrays).length(), String.valueOf(arrays2).length()));
        GeneratedOutlineSupport.outline34(sb, zzg, " leaves: ", arrays, " containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final void zza(zzaqf zzaqf) {
        this.zzb.add(zzaqf);
    }

    public final void zzb(zzaqe zzaqe) {
        this.zzc.add(zzaqe);
    }

    public final zzaqf zzc(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaqf zzaqf = this.zzb.get(i2);
            if (zzaqf.zzaR == i) {
                return zzaqf;
            }
        }
        return null;
    }

    public final zzaqe zzd(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaqe zzaqe = this.zzc.get(i2);
            if (zzaqe.zzaR == i) {
                return zzaqe;
            }
        }
        return null;
    }
}
