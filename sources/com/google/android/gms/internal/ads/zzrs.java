package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrs {
    public final String zza;
    public final zzkc zzb;
    public final zzkc zzc;
    public final int zzd;
    public final int zze;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzrs(java.lang.String r3, com.google.android.gms.internal.ads.zzkc r4, com.google.android.gms.internal.ads.zzkc r5, int r6, int r7) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x000a
            if (r7 != 0) goto L_0x000b
            r7 = 0
        L_0x000a:
            r0 = 1
        L_0x000b:
            com.google.android.gms.internal.ads.zzajg.zza(r0)
            com.google.android.gms.internal.ads.zzajg.zzf(r3)
            r2.zza = r3
            r3 = 0
            if (r4 == 0) goto L_0x0022
            r2.zzb = r4
            if (r5 == 0) goto L_0x0021
            r2.zzc = r5
            r2.zzd = r6
            r2.zze = r7
            return
        L_0x0021:
            throw r3
        L_0x0022:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrs.<init>(java.lang.String, com.google.android.gms.internal.ads.zzkc, com.google.android.gms.internal.ads.zzkc, int, int):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzrs.class == obj.getClass()) {
            zzrs zzrs = (zzrs) obj;
            return this.zzd == zzrs.zzd && this.zze == zzrs.zze && this.zza.equals(zzrs.zza) && this.zzb.equals(zzrs.zzb) && this.zzc.equals(zzrs.zzc);
        }
    }

    public final int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.zza, (((this.zzd + 527) * 31) + this.zze) * 31, 31);
        return this.zzc.hashCode() + ((this.zzb.hashCode() + outline4) * 31);
    }
}
