package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaxd {
    public final int zza;
    public final zzaxa zzb = new zzaxf();

    public zzaxd(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(arrayList.get(i).toLowerCase(Locale.US));
            sb.append(10);
        }
        String[] split = sb.toString().split("\n");
        if (split.length == 0) {
            return "";
        }
        zzaxc zzaxc = new zzaxc();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzaxb(this));
        for (String zzb2 : split) {
            String[] zzb3 = zzaxe.zzb(zzb2, false);
            if (zzb3.length != 0) {
                zzaxi.zza(zzb3, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzaxc.zzb.write(this.zzb.zza(((zzaxh) it.next()).zzb));
            } catch (IOException e) {
                zzcgs.zzg("Error while writing hash to byteStream", e);
            }
        }
        return zzaxc.toString();
    }
}
