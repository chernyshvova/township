package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaxi {
    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzaxh> priorityQueue) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        if (length < 6) {
            zzb(i, zze(strArr2, 0, length), zzc(strArr2, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr2, 0, 6);
        zzb(i, zze, zzc(strArr2, 0, 6), 6, priorityQueue);
        long zzd = zzd(16785407, 5);
        int i3 = 1;
        while (true) {
            int length2 = strArr2.length;
            if (i3 < length2 - 5) {
                zze = (((((long) zzaxe.zza(strArr2[i3 + 5])) + 2147483647L) % 1073807359) + (((((zze + 1073807359) - ((((((long) zzaxe.zza(strArr2[i3 - 1])) + 2147483647L) % 1073807359) * zzd) % 1073807359)) % 1073807359) * 16785407) % 1073807359)) % 1073807359;
                zzb(i, zze, zzc(strArr2, i3, 6), length2, priorityQueue);
                i3++;
            } else {
                return;
            }
        }
    }

    @VisibleForTesting
    public static void zzb(int i, long j, String str, int i2, PriorityQueue<zzaxh> priorityQueue) {
        zzaxh zzaxh = new zzaxh(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzc <= zzaxh.zzc && priorityQueue.peek().zza <= zzaxh.zza)) && !priorityQueue.contains(zzaxh)) {
            priorityQueue.add(zzaxh);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    @VisibleForTesting
    public static String zzc(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzcgs.zzf("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    @VisibleForTesting
    public static long zzd(long j, int i) {
        return i == 1 ? j : (i & 1) == 0 ? zzd((j * j) % 1073807359, i >> 1) % 1073807359 : ((zzd((j * j) % 1073807359, i >> 1) % 1073807359) * j) % 1073807359;
    }

    public static long zze(String[] strArr, int i, int i2) {
        long zza = (((long) zzaxe.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zza = (((((long) zzaxe.zza(strArr[i3])) + 2147483647L) % 1073807359) + ((zza * 16785407) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}
