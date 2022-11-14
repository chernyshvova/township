package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzy {
    public final int zza;
    public final byte[] zzb;
    @Nullable
    public final Map<String, String> zzc;
    @Nullable
    public final List<zzu> zzd;
    public final boolean zze;

    public zzy(int i, byte[] bArr, @Nullable Map<String, String> map, @Nullable List<zzu> list, boolean z, long j) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = map;
        if (list == null) {
            this.zzd = null;
        } else {
            this.zzd = Collections.unmodifiableList(list);
        }
        this.zze = z;
    }

    @Nullable
    public static List<zzu> zza(@Nullable Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new zzu((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }

    @Deprecated
    public zzy(int i, byte[] bArr, @Nullable Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, zza(map), z, j);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzy(int r9, byte[] r10, boolean r11, long r12, @androidx.annotation.Nullable java.util.List<com.google.android.gms.internal.ads.zzu> r14) {
        /*
            r8 = this;
            if (r14 != 0) goto L_0x0005
            r0 = 0
        L_0x0003:
            r3 = r0
            goto L_0x0033
        L_0x0005:
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = java.util.Collections.emptyMap()
            goto L_0x0003
        L_0x0010:
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            java.util.Iterator r1 = r14.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0003
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.ads.zzu r2 = (com.google.android.gms.internal.ads.zzu) r2
            java.lang.String r3 = r2.zza()
            java.lang.String r2 = r2.zzb()
            r0.put(r3, r2)
            goto L_0x001b
        L_0x0033:
            r0 = r8
            r1 = r9
            r2 = r10
            r4 = r14
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzy.<init>(int, byte[], boolean, long, java.util.List):void");
    }

    @Deprecated
    public zzy(byte[] bArr, @Nullable Map<String, String> map) {
        this(200, bArr, map, zza(map), false, 0);
    }
}
