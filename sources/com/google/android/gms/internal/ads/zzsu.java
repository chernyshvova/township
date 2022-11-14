package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsu {
    public static void zza(long j, zzakr zzakr, zztz[] zztzArr) {
        int i;
        while (true) {
            boolean z = true;
            if (zzakr.zzd() > 1) {
                int zzc = zzc(zzakr);
                int zzc2 = zzc(zzakr);
                int zzg = zzakr.zzg() + zzc2;
                if (zzc2 == -1 || zzc2 > zzakr.zzd()) {
                    Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzg = zzakr.zze();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzn = zzakr.zzn();
                    int zzo = zzakr.zzo();
                    if (zzo == 49) {
                        i = zzakr.zzv();
                        zzo = 49;
                    } else {
                        i = 0;
                    }
                    int zzn2 = zzakr.zzn();
                    if (zzo == 47) {
                        zzakr.zzk(1);
                        zzo = 47;
                    }
                    boolean z2 = zzn == 181 && (zzo == 49 || zzo == 47) && zzn2 == 3;
                    if (zzo == 49) {
                        if (i != 1195456820) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        zzb(j, zzakr, zztzArr);
                    }
                }
                zzakr.zzh(zzg);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j, zzakr zzakr, zztz[] zztzArr) {
        int zzn = zzakr.zzn();
        if ((zzn & 64) != 0) {
            zzakr.zzk(1);
            int i = (zzn & 31) * 3;
            int zzg = zzakr.zzg();
            for (zztz zztz : zztzArr) {
                zzakr.zzh(zzg);
                zztz.zzf(zzakr, i);
                zztz.zzd(j, 1, i, 0, (zzty) null);
            }
        }
    }

    public static int zzc(zzakr zzakr) {
        int i = 0;
        while (zzakr.zzd() != 0) {
            int zzn = zzakr.zzn();
            i += zzn;
            if (zzn != 255) {
                return i;
            }
        }
        return -1;
    }
}
