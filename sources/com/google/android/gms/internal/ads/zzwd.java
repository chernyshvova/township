package com.google.android.gms.internal.ads;

import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwd implements zzwb {
    public final int zza;
    public final int zzb;
    public final zzakr zzc;

    public zzwd(zzvy zzvy, zzkc zzkc) {
        zzakr zzakr = zzvy.zza;
        this.zzc = zzakr;
        zzakr.zzh(12);
        int zzB = this.zzc.zzB();
        if ("audio/raw".equals(zzkc.zzl)) {
            int zzQ = zzalh.zzQ(zzkc.zzA, zzkc.zzy);
            if (zzB == 0 || zzB % zzQ != 0) {
                Log.w("AtomParsers", GeneratedOutlineSupport.outline11(88, "Audio sample size mismatch. stsd sample size: ", zzQ, ", stsz sample size: ", zzB));
                zzB = zzQ;
            }
        }
        this.zza = zzB == 0 ? -1 : zzB;
        this.zzb = this.zzc.zzB();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzB() : i;
    }
}
