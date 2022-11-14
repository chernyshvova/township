package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaxk implements Comparator<zzawz> {
    public zzaxk(zzaxl zzaxl) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzawz zzawz = (zzawz) obj;
        zzawz zzawz2 = (zzawz) obj2;
        if (zzawz.zzb() >= zzawz2.zzb()) {
            if (zzawz.zzb() > zzawz2.zzb()) {
                return 1;
            }
            if (zzawz.zza() >= zzawz2.zza()) {
                if (zzawz.zza() > zzawz2.zza()) {
                    return 1;
                }
                float zzc = (zzawz.zzc() - zzawz.zza()) * (zzawz.zzd() - zzawz.zzb());
                float zzc2 = (zzawz2.zzc() - zzawz2.zza()) * (zzawz2.zzd() - zzawz2.zzb());
                if (zzc <= zzc2) {
                    if (zzc < zzc2) {
                        return 1;
                    }
                    return 0;
                }
            }
        }
        return -1;
    }
}
