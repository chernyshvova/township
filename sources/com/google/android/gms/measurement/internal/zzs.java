package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcd;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzs {
    public zzcd.zzc zza;
    public Long zzb;
    public long zzc;
    public final /* synthetic */ zzr zzd;

    public zzs(zzr zzr) {
        this.zzd = zzr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzcd.zzc zza(java.lang.String r18, com.google.android.gms.internal.measurement.zzcd.zzc r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r8 = r19
            java.lang.String r9 = r19.zzc()
            java.util.List r10 = r19.zza()
            com.google.android.gms.measurement.internal.zzr r2 = r1.zzd
            r2.mo31422f_()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkr.zzb(r8, r2)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            r3 = 1
            r5 = 0
            if (r4 == 0) goto L_0x0022
            r6 = 1
            goto L_0x0023
        L_0x0022:
            r6 = 0
        L_0x0023:
            if (r6 == 0) goto L_0x002f
            java.lang.String r7 = "_ep"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x002f
            r7 = 1
            goto L_0x0030
        L_0x002f:
            r7 = 0
        L_0x0030:
            r11 = 0
            if (r7 == 0) goto L_0x0144
            com.google.android.gms.measurement.internal.zzr r6 = r1.zzd
            r6.mo31422f_()
            java.lang.String r6 = "_en"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzkr.zzb(r8, r6)
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            r7 = 0
            if (r6 == 0) goto L_0x0059
            com.google.android.gms.measurement.internal.zzr r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzf()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.zza(r2, r4)
            return r7
        L_0x0059:
            com.google.android.gms.internal.measurement.zzcd$zzc r6 = r1.zza
            if (r6 == 0) goto L_0x006f
            java.lang.Long r6 = r1.zzb
            if (r6 == 0) goto L_0x006f
            long r13 = r4.longValue()
            java.lang.Long r6 = r1.zzb
            long r15 = r6.longValue()
            int r6 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r6 == 0) goto L_0x009e
        L_0x006f:
            com.google.android.gms.measurement.internal.zzr r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zzi()
            android.util.Pair r6 = r6.zza((java.lang.String) r0, (java.lang.Long) r4)
            if (r6 == 0) goto L_0x0134
            java.lang.Object r13 = r6.first
            if (r13 != 0) goto L_0x0081
            goto L_0x0134
        L_0x0081:
            com.google.android.gms.internal.measurement.zzcd$zzc r13 = (com.google.android.gms.internal.measurement.zzcd.zzc) r13
            r1.zza = r13
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r1.zzc = r6
            com.google.android.gms.measurement.internal.zzr r6 = r1.zzd
            r6.mo31422f_()
            com.google.android.gms.internal.measurement.zzcd$zzc r6 = r1.zza
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkr.zzb(r6, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r1.zzb = r2
        L_0x009e:
            long r6 = r1.zzc
            r13 = 1
            long r6 = r6 - r13
            r1.zzc = r6
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzr r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzi()
            r2.zzc()
            com.google.android.gms.measurement.internal.zzeq r4 = r2.zzq()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzw()
            java.lang.String r6 = "Clearing complex main event info. appId"
            r4.zza(r6, r0)
            android.database.sqlite.SQLiteDatabase r4 = r2.mo31260c_()     // Catch:{ SQLiteException -> 0x00cd }
            java.lang.String r6 = "delete from main_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00cd }
            r3[r5] = r0     // Catch:{ SQLiteException -> 0x00cd }
            r4.execSQL(r6, r3)     // Catch:{ SQLiteException -> 0x00cd }
            goto L_0x00eb
        L_0x00cd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zza(r3, r0)
            goto L_0x00eb
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzr r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzi()
            long r5 = r1.zzc
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = r1.zza
            r3 = r18
            r2.zza(r3, r4, r5, r7)
        L_0x00eb:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = r1.zza
            java.util.List r2 = r2.zza()
            java.util.Iterator r2 = r2.iterator()
        L_0x00fa:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0119
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3
            com.google.android.gms.measurement.internal.zzr r4 = r1.zzd
            r4.mo31422f_()
            java.lang.String r4 = r3.zzb()
            com.google.android.gms.internal.measurement.zzcd$zze r4 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r8, (java.lang.String) r4)
            if (r4 != 0) goto L_0x00fa
            r0.add(r3)
            goto L_0x00fa
        L_0x0119:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0124
            r0.addAll(r10)
            r10 = r0
            goto L_0x0188
        L_0x0124:
            com.google.android.gms.measurement.internal.zzr r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzf()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.zza(r2, r9)
            goto L_0x0188
        L_0x0134:
            com.google.android.gms.measurement.internal.zzr r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzf()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zza(r2, r9, r4)
            return r7
        L_0x0144:
            if (r6 == 0) goto L_0x0188
            r1.zzb = r4
            r1.zza = r8
            com.google.android.gms.measurement.internal.zzr r2 = r1.zzd
            r2.mo31422f_()
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            java.lang.String r3 = "_epc"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkr.zzb(r8, r3)
            if (r3 != 0) goto L_0x015c
            goto L_0x015d
        L_0x015c:
            r2 = r3
        L_0x015d:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r1.zzc = r2
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x0179
            com.google.android.gms.measurement.internal.zzr r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzf()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r0.zza(r2, r9)
            goto L_0x0188
        L_0x0179:
            com.google.android.gms.measurement.internal.zzr r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzi()
            long r5 = r1.zzc
            r3 = r18
            r7 = r19
            r2.zza(r3, r4, r5, r7)
        L_0x0188:
            com.google.android.gms.internal.measurement.zzhy$zzb r0 = r19.zzbo()
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r0
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = r0.zza((java.lang.String) r9)
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = r0.zzc()
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = r0.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zze>) r10)
            com.google.android.gms.internal.measurement.zzjj r0 = r0.zzy()
            com.google.android.gms.internal.measurement.zzhy r0 = (com.google.android.gms.internal.measurement.zzhy) r0
            com.google.android.gms.internal.measurement.zzcd$zzc r0 = (com.google.android.gms.internal.measurement.zzcd.zzc) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzs.zza(java.lang.String, com.google.android.gms.internal.measurement.zzcd$zzc):com.google.android.gms.internal.measurement.zzcd$zzc");
    }

    public /* synthetic */ zzs(zzr zzr, zzq zzq) {
        this(zzr);
    }
}
