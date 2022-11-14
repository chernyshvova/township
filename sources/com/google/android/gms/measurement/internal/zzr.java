package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzr extends zzki {
    public String zzb;
    public Set<Integer> zzc;
    public Map<Integer, zzt> zzd;
    public Long zze;
    public Long zzf;

    public zzr(zzkl zzkl) {
        super(zzkl);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x02d2 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzcd.zza> zza(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.zzcd.zzc> r48, java.util.List<com.google.android.gms.internal.measurement.zzcd.zzk> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            r46 = this;
            r10 = r46
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r47)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r48)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r49)
            r0 = r47
            r10.zzb = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzc = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzd = r0
            r0 = r50
            r10.zze = r0
            r0 = r51
            r10.zzf = r0
            java.util.Iterator r0 = r48.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            r11 = 0
            r12 = 1
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1
            java.lang.String r1 = r1.zzc()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0029
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            boolean r0 = com.google.android.gms.internal.measurement.zzmx.zzb()
            if (r0 == 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzab r0 = r46.zzs()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbb
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x005c
            r13 = 1
            goto L_0x005d
        L_0x005c:
            r13 = 0
        L_0x005d:
            boolean r0 = com.google.android.gms.internal.measurement.zzmx.zzb()
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzab r0 = r46.zzs()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzba
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x0073
            r14 = 1
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.zzaf r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            r2.zzaj()
            r2.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.mo31260c_()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x00a3 }
            r7[r11] = r3     // Catch:{ SQLiteException -> 0x00a3 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x00b5
        L_0x00a3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zza(r4, r3, r0)
        L_0x00b5:
            java.util.Map r0 = java.util.Collections.emptyMap()
            if (r14 == 0) goto L_0x00c7
            if (r13 == 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzaf r0 = r46.zzi()
            java.lang.String r2 = r10.zzb
            java.util.Map r0 = r0.zze(r2)
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzaf r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            java.util.Map r15 = r2.zzg(r3)
            boolean r2 = com.google.android.gms.internal.measurement.zznd.zzb()
            if (r2 == 0) goto L_0x00e5
            com.google.android.gms.measurement.internal.zzab r2 = r46.zzs()
            java.lang.String r3 = r10.zzb
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzas.zzce
            boolean r2 = r2.zzd(r3, r4)
            if (r2 != 0) goto L_0x00e7
        L_0x00e5:
            if (r15 == 0) goto L_0x036d
        L_0x00e7:
            boolean r2 = r15.isEmpty()
            if (r2 == 0) goto L_0x00ef
            goto L_0x036d
        L_0x00ef:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r15.keySet()
            r2.<init>(r3)
            if (r1 == 0) goto L_0x01d8
            java.lang.String r1 = r10.zzb
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r4 = r15.isEmpty()
            if (r4 != 0) goto L_0x01d6
            com.google.android.gms.measurement.internal.zzaf r4 = r46.zzi()
            java.util.Map r1 = r4.zzf(r1)
            java.util.Set r4 = r15.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x011d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d6
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r15.get(r6)
            com.google.android.gms.internal.measurement.zzcd$zzi r6 = (com.google.android.gms.internal.measurement.zzcd.zzi) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r1.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01cc
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x014b
            goto L_0x01cc
        L_0x014b:
            com.google.android.gms.measurement.internal.zzkr r8 = r46.mo31422f_()
            java.util.List r9 = r6.zzc()
            java.util.List r8 = r8.zza((java.util.List<java.lang.Long>) r9, (java.util.List<java.lang.Integer>) r7)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x011d
            com.google.android.gms.internal.measurement.zzhy$zzb r9 = r6.zzbo()
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r9 = (com.google.android.gms.internal.measurement.zzcd.zzi.zza) r9
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r9 = r9.zzb()
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r8 = r9.zzb((java.lang.Iterable<? extends java.lang.Long>) r8)
            com.google.android.gms.measurement.internal.zzkr r9 = r46.mo31422f_()
            java.util.List r11 = r6.zza()
            java.util.List r9 = r9.zza((java.util.List<java.lang.Long>) r11, (java.util.List<java.lang.Integer>) r7)
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r11 = r8.zza()
            r11.zza((java.lang.Iterable<? extends java.lang.Long>) r9)
            r9 = 0
        L_0x017f:
            int r11 = r6.zzf()
            if (r9 >= r11) goto L_0x019d
            com.google.android.gms.internal.measurement.zzcd$zzb r11 = r6.zza((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x019a
            r8.zza((int) r9)
        L_0x019a:
            int r9 = r9 + 1
            goto L_0x017f
        L_0x019d:
            r9 = 0
        L_0x019e:
            int r11 = r6.zzh()
            if (r9 >= r11) goto L_0x01bc
            com.google.android.gms.internal.measurement.zzcd$zzj r11 = r6.zzb((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x01b9
            r8.zzb((int) r9)
        L_0x01b9:
            int r9 = r9 + 1
            goto L_0x019e
        L_0x01bc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzjj r6 = r8.zzy()
            com.google.android.gms.internal.measurement.zzhy r6 = (com.google.android.gms.internal.measurement.zzhy) r6
            com.google.android.gms.internal.measurement.zzcd$zzi r6 = (com.google.android.gms.internal.measurement.zzcd.zzi) r6
            r3.put(r5, r6)
            goto L_0x01d3
        L_0x01cc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.put(r5, r6)
        L_0x01d3:
            r11 = 0
            goto L_0x011d
        L_0x01d6:
            r11 = r3
            goto L_0x01d9
        L_0x01d8:
            r11 = r15
        L_0x01d9:
            java.util.Iterator r16 = r2.iterator()
        L_0x01dd:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x036d
            java.lang.Object r1 = r16.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r17 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzcd$zzi r1 = (com.google.android.gms.internal.measurement.zzcd.zzi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x0245
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x020f
            goto L_0x0245
        L_0x020f:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x0217:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0245
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zzb r3 = (com.google.android.gms.internal.measurement.zzcd.zzb) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0217
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzc()
            if (r8 == 0) goto L_0x0240
            long r8 = r3.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x0241
        L_0x0240:
            r3 = 0
        L_0x0241:
            r7.put(r4, r3)
            goto L_0x0217
        L_0x0245:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x028c
            int r2 = r1.zzh()
            if (r2 != 0) goto L_0x0253
            goto L_0x028c
        L_0x0253:
            java.util.List r2 = r1.zzg()
            java.util.Iterator r2 = r2.iterator()
        L_0x025b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x028c
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zzj r3 = (com.google.android.gms.internal.measurement.zzcd.zzj) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x025b
            int r4 = r3.zzd()
            if (r4 <= 0) goto L_0x025b
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r9 = r3.zzd()
            int r9 = r9 - r12
            long r18 = r3.zza((int) r9)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r4, r3)
            goto L_0x025b
        L_0x028c:
            if (r1 == 0) goto L_0x02d6
            r2 = 0
        L_0x028f:
            int r3 = r1.zzb()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x02d6
            java.util.List r3 = r1.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzkr.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02c8
            com.google.android.gms.measurement.internal.zzeq r3 = r46.zzq()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzw()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            java.lang.String r12 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r12, r4, r9)
            r6.set(r2)
            java.util.List r3 = r1.zzc()
            boolean r3 = com.google.android.gms.measurement.internal.zzkr.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02c8
            r5.set(r2)
            r3 = 1
            goto L_0x02c9
        L_0x02c8:
            r3 = 0
        L_0x02c9:
            if (r3 != 0) goto L_0x02d2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x02d2:
            int r2 = r2 + 1
            r12 = 1
            goto L_0x028f
        L_0x02d6:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r15.get(r1)
            r4 = r1
            com.google.android.gms.internal.measurement.zzcd$zzi r4 = (com.google.android.gms.internal.measurement.zzcd.zzi) r4
            if (r14 == 0) goto L_0x0351
            if (r13 == 0) goto L_0x0351
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0351
            java.lang.Long r2 = r10.zzf
            if (r2 == 0) goto L_0x0351
            java.lang.Long r2 = r10.zze
            if (r2 != 0) goto L_0x02fa
            goto L_0x0351
        L_0x02fa:
            java.util.Iterator r1 = r1.iterator()
        L_0x02fe:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0351
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbv$zzb r2 = (com.google.android.gms.internal.measurement.zzbv.zzb) r2
            int r3 = r2.zzb()
            java.lang.Long r9 = r10.zzf
            long r18 = r9.longValue()
            r20 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 / r20
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x0326
            java.lang.Long r2 = r10.zze
            long r18 = r2.longValue()
            long r18 = r18 / r20
        L_0x0326:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x033b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r9 = java.lang.Long.valueOf(r18)
            r7.put(r2, r9)
        L_0x033b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r8.containsKey(r2)
            if (r2 == 0) goto L_0x02fe
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r2, r3)
            goto L_0x02fe
        L_0x0351:
            com.google.android.gms.measurement.internal.zzt r12 = new com.google.android.gms.measurement.internal.zzt
            java.lang.String r3 = r10.zzb
            r9 = 0
            r1 = r12
            r2 = r46
            r18 = r11
            r11 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r1 = r10.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r1.put(r2, r12)
            r11 = r18
            r12 = 1
            goto L_0x01dd
        L_0x036d:
            r11 = 0
            boolean r0 = r48.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 != 0) goto L_0x04f2
            com.google.android.gms.measurement.internal.zzs r0 = new com.google.android.gms.measurement.internal.zzs
            r0.<init>(r10, r11)
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r48.iterator()
        L_0x0384:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04f2
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.zzcd$zzc r4 = (com.google.android.gms.internal.measurement.zzcd.zzc) r4
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzcd$zzc r5 = r0.zza(r5, r4)
            if (r5 == 0) goto L_0x0384
            com.google.android.gms.measurement.internal.zzaf r6 = r46.zzi()
            java.lang.String r13 = r10.zzb
            java.lang.String r7 = r5.zzc()
            java.lang.String r8 = r4.zzc()
            com.google.android.gms.measurement.internal.zzam r8 = r6.zza((java.lang.String) r13, (java.lang.String) r8)
            if (r8 != 0) goto L_0x03e4
            com.google.android.gms.measurement.internal.zzeq r8 = r6.zzq()
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzh()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r7)
            java.lang.String r7 = "Event aggregate wasn't created during raw event logging. appId, event"
            r8.zza(r7, r9, r6)
            com.google.android.gms.measurement.internal.zzam r6 = new com.google.android.gms.measurement.internal.zzam
            r12 = r6
            java.lang.String r14 = r4.zzc()
            r15 = 1
            r17 = 1
            r19 = 1
            long r21 = r4.zze()
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)
            goto L_0x0419
        L_0x03e4:
            com.google.android.gms.measurement.internal.zzam r6 = new com.google.android.gms.measurement.internal.zzam
            r29 = r6
            java.lang.String r4 = r8.zza
            r30 = r4
            java.lang.String r4 = r8.zzb
            r31 = r4
            long r12 = r8.zzc
            r14 = 1
            long r32 = r12 + r14
            long r12 = r8.zzd
            long r34 = r12 + r14
            long r12 = r8.zze
            long r36 = r12 + r14
            long r12 = r8.zzf
            r38 = r12
            long r12 = r8.zzg
            r40 = r12
            java.lang.Long r4 = r8.zzh
            r42 = r4
            java.lang.Long r4 = r8.zzi
            r43 = r4
            java.lang.Long r4 = r8.zzj
            r44 = r4
            java.lang.Boolean r4 = r8.zzk
            r45 = r4
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)
        L_0x0419:
            com.google.android.gms.measurement.internal.zzaf r4 = r46.zzi()
            r4.zza((com.google.android.gms.measurement.internal.zzam) r6)
            long r7 = r6.zzc
            java.lang.String r4 = r5.zzc()
            java.lang.Object r9 = r2.get(r4)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 != 0) goto L_0x0456
            com.google.android.gms.measurement.internal.zzaf r9 = r46.zzi()
            java.lang.String r12 = r10.zzb
            java.util.Map r9 = r9.zzf(r12, r4)
            boolean r12 = com.google.android.gms.internal.measurement.zznd.zzb()
            if (r12 == 0) goto L_0x044c
            com.google.android.gms.measurement.internal.zzab r12 = r46.zzs()
            java.lang.String r13 = r10.zzb
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzas.zzce
            boolean r12 = r12.zzd(r13, r14)
            if (r12 != 0) goto L_0x0453
        L_0x044c:
            if (r9 != 0) goto L_0x0453
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
        L_0x0453:
            r2.put(r4, r9)
        L_0x0456:
            java.util.Set r4 = r9.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x045e:
            boolean r12 = r4.hasNext()
            if (r12 == 0) goto L_0x0384
            java.lang.Object r12 = r4.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r15 = r12.intValue()
            java.util.Set<java.lang.Integer> r12 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x048a
            com.google.android.gms.measurement.internal.zzeq r12 = r46.zzq()
            com.google.android.gms.measurement.internal.zzes r12 = r12.zzw()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            r12.zza(r1, r13)
            goto L_0x045e
        L_0x048a:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r15)
            java.lang.Object r12 = r9.get(r12)
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r20 = r12.iterator()
            r12 = 1
        L_0x0499:
            boolean r13 = r20.hasNext()
            if (r13 == 0) goto L_0x04df
            java.lang.Object r12 = r20.next()
            com.google.android.gms.internal.measurement.zzbv$zzb r12 = (com.google.android.gms.internal.measurement.zzbv.zzb) r12
            com.google.android.gms.measurement.internal.zzv r14 = new com.google.android.gms.measurement.internal.zzv
            java.lang.String r13 = r10.zzb
            r14.<init>(r10, r13, r15, r12)
            java.lang.Long r13 = r10.zze
            java.lang.Long r11 = r10.zzf
            int r12 = r12.zzb()
            boolean r19 = r10.zza(r15, r12)
            r12 = r14
            r21 = r0
            r0 = r14
            r14 = r11
            r11 = r15
            r15 = r5
            r16 = r7
            r18 = r6
            boolean r12 = r12.zza(r13, r14, r15, r16, r18, r19)
            if (r12 == 0) goto L_0x04d5
            com.google.android.gms.measurement.internal.zzt r13 = r10.zza(r11)
            r13.zza((com.google.android.gms.measurement.internal.zzu) r0)
            r15 = r11
            r0 = r21
            r11 = 0
            goto L_0x0499
        L_0x04d5:
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            r0.add(r13)
            goto L_0x04e2
        L_0x04df:
            r21 = r0
            r11 = r15
        L_0x04e2:
            if (r12 != 0) goto L_0x04ed
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r0.add(r11)
        L_0x04ed:
            r0 = r21
            r11 = 0
            goto L_0x045e
        L_0x04f2:
            boolean r0 = r49.isEmpty()
            if (r0 != 0) goto L_0x064d
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r2 = r49.iterator()
        L_0x0501:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x064d
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zzk r3 = (com.google.android.gms.internal.measurement.zzcd.zzk) r3
            java.lang.String r4 = r3.zzc()
            java.lang.Object r5 = r0.get(r4)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x0541
            com.google.android.gms.measurement.internal.zzaf r5 = r46.zzi()
            java.lang.String r6 = r10.zzb
            java.util.Map r5 = r5.zzg(r6, r4)
            boolean r6 = com.google.android.gms.internal.measurement.zznd.zzb()
            if (r6 == 0) goto L_0x0537
            com.google.android.gms.measurement.internal.zzab r6 = r46.zzs()
            java.lang.String r7 = r10.zzb
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzce
            boolean r6 = r6.zzd(r7, r8)
            if (r6 != 0) goto L_0x053e
        L_0x0537:
            if (r5 != 0) goto L_0x053e
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
        L_0x053e:
            r0.put(r4, r5)
        L_0x0541:
            java.util.Set r4 = r5.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0549:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0501
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0575
            com.google.android.gms.measurement.internal.zzeq r3 = r46.zzq()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzw()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.zza(r1, r4)
            goto L_0x0501
        L_0x0575:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r5.get(r7)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x0584:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0640
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzbv$zze r8 = (com.google.android.gms.internal.measurement.zzbv.zze) r8
            com.google.android.gms.measurement.internal.zzeq r9 = r46.zzq()
            r11 = 2
            boolean r9 = r9.zza((int) r11)
            if (r9 == 0) goto L_0x05dd
            com.google.android.gms.measurement.internal.zzeq r9 = r46.zzq()
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzw()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            boolean r12 = r8.zza()
            if (r12 == 0) goto L_0x05b6
            int r12 = r8.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x05b7
        L_0x05b6:
            r12 = 0
        L_0x05b7:
            com.google.android.gms.measurement.internal.zzeo r13 = r46.zzn()
            java.lang.String r14 = r8.zzc()
            java.lang.String r13 = r13.zzc(r14)
            java.lang.String r14 = "Evaluating filter. audience, filter, property"
            r9.zza(r14, r11, r12, r13)
            com.google.android.gms.measurement.internal.zzeq r9 = r46.zzq()
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzw()
            com.google.android.gms.measurement.internal.zzkr r11 = r46.mo31422f_()
            java.lang.String r11 = r11.zza((com.google.android.gms.internal.measurement.zzbv.zze) r8)
            java.lang.String r12 = "Filter definition"
            r9.zza(r12, r11)
        L_0x05dd:
            boolean r9 = r8.zza()
            if (r9 == 0) goto L_0x0618
            int r9 = r8.zzb()
            r11 = 256(0x100, float:3.59E-43)
            if (r9 <= r11) goto L_0x05ec
            goto L_0x0618
        L_0x05ec:
            com.google.android.gms.measurement.internal.zzx r9 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r11 = r10.zzb
            r9.<init>(r10, r11, r6, r8)
            java.lang.Long r11 = r10.zze
            java.lang.Long r12 = r10.zzf
            int r8 = r8.zzb()
            boolean r8 = r10.zza(r6, r8)
            boolean r8 = r9.zza(r11, r12, r3, r8)
            if (r8 == 0) goto L_0x060e
            com.google.android.gms.measurement.internal.zzt r11 = r10.zza(r6)
            r11.zza((com.google.android.gms.measurement.internal.zzu) r9)
            goto L_0x0584
        L_0x060e:
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            goto L_0x0640
        L_0x0618:
            com.google.android.gms.measurement.internal.zzeq r7 = r46.zzq()
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzh()
            java.lang.String r9 = r10.zzb
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r9)
            boolean r11 = r8.zza()
            if (r11 == 0) goto L_0x0635
            int r8 = r8.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0636
        L_0x0635:
            r8 = 0
        L_0x0636:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r11 = "Invalid property filter ID. appId, id"
            r7.zza(r11, r9, r8)
            r8 = 0
        L_0x0640:
            if (r8 != 0) goto L_0x0549
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
            goto L_0x0549
        L_0x064d:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r0 = r10.zzd
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.zzc
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0661:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x06f1
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r3 = r10.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzt r3 = (com.google.android.gms.measurement.internal.zzt) r3
            com.google.android.gms.internal.measurement.zzcd$zza r3 = r3.zza((int) r0)
            r1.add(r3)
            com.google.android.gms.measurement.internal.zzaf r4 = r46.zzi()
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzcd$zzi r3 = r3.zzc()
            r4.zzaj()
            r4.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbk()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r7 = "audience_id"
            r6.put(r7, r0)
            java.lang.String r0 = "current_results"
            r6.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.mo31260c_()     // Catch:{ SQLiteException -> 0x06dc }
            java.lang.String r3 = "audience_filter_values"
            r7 = 5
            r8 = 0
            long r6 = r0.insertWithOnConflict(r3, r8, r6, r7)     // Catch:{ SQLiteException -> 0x06da }
            r11 = -1
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0661
            com.google.android.gms.measurement.internal.zzeq r0 = r4.zzq()     // Catch:{ SQLiteException -> 0x06da }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()     // Catch:{ SQLiteException -> 0x06da }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r5)     // Catch:{ SQLiteException -> 0x06da }
            r0.zza(r3, r6)     // Catch:{ SQLiteException -> 0x06da }
            goto L_0x0661
        L_0x06da:
            r0 = move-exception
            goto L_0x06de
        L_0x06dc:
            r0 = move-exception
            r8 = 0
        L_0x06de:
            com.google.android.gms.measurement.internal.zzeq r3 = r4.zzq()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r5)
            java.lang.String r5 = "Error storing filter results. appId"
            r3.zza(r5, r4, r0)
            goto L_0x0661
        L_0x06f1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzr.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final boolean zzd() {
        return false;
    }

    private final zzt zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzt zzt = new zzt(this, this.zzb, (zzq) null);
        this.zzd.put(Integer.valueOf(i), zzt);
        return zzt;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }
}
